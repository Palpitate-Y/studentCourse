package cui.xin.studentcourse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cui.xin.studentcourse.bean.Student;
import cui.xin.studentcourse.dto.StudentDto;
import cui.xin.studentcourse.mapper.StudentMapper;
import cui.xin.studentcourse.service.StudentService;
import cui.xin.studentcourse.service.exception.InsertException;
import cui.xin.studentcourse.service.exception.StudentNameDuplicateException;
import cui.xin.studentcourse.service.exception.StudentNotExistException;
import cui.xin.studentcourse.service.exception.WrongPasswordException;
import cui.xin.studentcourse.util.PasswordEncryptedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentDto> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDto> select(){
        QueryWrapper<StudentDto> queryWrapper = new QueryWrapper<>();
        List<StudentDto> students = studentMapper.selectList(queryWrapper);
        return students;
    }
    /**
     * 插入
     * @param studentDto
     * @return
     */
    @Override
    public int addStudent(StudentDto studentDto) {
        return studentMapper.insert(studentDto);
    }

    /**
     * 修改
     * @param studentDto
     * @return
     */
    @Override
    public int editStudent(StudentDto studentDto) {
        return studentMapper.updateById(studentDto);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public StudentDto queryStudentById(Integer id) {
        return studentMapper.selectById(id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delStudentById(Integer id) {
        return studentMapper.deleteById(id);
    }


    /**
     * 更具条件进行查询
     * @param studentDto
     * @return
     */
    @Override
    public List<StudentDto> queryStudentByConditiation(StudentDto studentDto) {
        return studentMapper.queryStudentByConditiation(studentDto);
    }

    /**
     * 查寻没有选课的学生
     * @return
     */
    @Override
    public List<StudentDto> selectNoCourseStudentList() {
        return null;
//        return studentMapper.selectNoCourseStudentList();
    }


    /**
     * Description : 处理用户注册
     *
     * @param student 注册的用户信息
     * @return void
     * @date 2022/11/11
     **/
    @Override
    public void studentRegister(Student student) {
        //需要先判断用户名是否在数据库中重复
        Student queryStudent = studentMapper.queryStudentByStudentId(student.getStudentId());

        //重复的情况下，抛出用户名重复异常
        if (queryStudent != null) {
            throw new StudentNameDuplicateException("该账号已被注册");
        }

        //密码不能以明文方式存入数据库，需要进行加密操作
        //密码加密的实现： 盐值 + password + 盐值 ---> md5算法进行加密，连续加载三次 ---> 得到最终存入数据库的结果
        //盐值就是一个随机的字符串
        //记录旧密码
        String oldPassword = student.getPassword();
        //使用UUID获取时间戳创建盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        //记录此刻的盐值，用于以后做用户登录判断
        student.setSalt(salt);
        //进行加密操作
        String md5Password = PasswordEncryptedUtils.getPasswordByMD5(oldPassword, salt);
        //将加密后的密码设置为用户设置的密码
        student.setPassword(md5Password);
        //不重复，调用插入方法,处理业务
        int result = studentMapper.addStudent(student);

        if (result == 0) { //判断服务器或数据库执行是否出现异常
            throw new InsertException("处理用户注册过程中，服务器或数据库执行出现异常");
        }
    }

    /**
     * Description : 处理用户登录
     *
     * @param student 登录的用户信息
     * @return cui.xin.student_course.bean.Student
     * @date 2022/11/11
     **/
    public Student studentLogin(Student student) {
        //用户id
        Long studentId = student.getStudentId();
        //用户输入的密码
        String studentPassword = student.getPassword();
        //查询登录用户是否在数据库中存在
        Student loginStudent = studentMapper.queryStudentByStudentId(studentId);

        if (loginStudent == null) { //为空代表用户名不存在
            throw new StudentNotExistException("该账号不存在");
        }

        //取得数据库查询返回用户的盐值和密码
        String salt = loginStudent.getSalt();
        String databasePwd = loginStudent.getPassword();
        //对用户输入的密码进行加密
        String md5PasswordBy = PasswordEncryptedUtils.getPasswordByMD5(studentPassword, salt);
        //将加密后的字符和数据库查询的MD5进行校验
//        System.out.println(student_id);
//        System.out.println(studentPassword);
//        System.out.println(salt);
//        System.out.println(md5PasswordBy);
//        System.out.println(databasePwd);
        if (!databasePwd.equals(md5PasswordBy)) {
            throw new WrongPasswordException("该账户密码不正确");
        }
        //密码正确返回查询的用户信息
        return loginStudent;
    }


    /**
     * Description : 处理用户修改密码
     *
     * @param student 用户要修改的新密码
     * @return void
     * @date 2022/11/11
     **/


    @Override
    public void updatePassword(Student student) {


        //从数据库查询对应的信息
        Student student1 = studentMapper.queryStudentByStudentIdAndMobile(student.getStudentId(), student.getMobile());
        if (student1 == null) { //为空代表用户名不存在
            throw new StudentNotExistException("请检查账号和手机号是否准确");
        }

        //取得数据库查询返回用户的盐值和密码
        String salt = student1.getSalt();
        //传用户输入的新密码，而不是数据库中加密过后的再加密
        String newPassword = student.getPassword();

//        System.out.println(student.getStudent_id());
//        System.out.println(salt);
//        System.out.println(newPassword);
        //将新密码进行加密
        String newMD5Pwd = PasswordEncryptedUtils.getPasswordByMD5(newPassword, salt);
        Student student2 = new Student();
        student2.setStudentId(student1.getStudentId());
        student2.setMobile(student1.getMobile());
        student2.setPassword(newMD5Pwd);

        //更新密码
        int result = studentMapper.updatePassword(student2);

        if (result == 0) {
            throw new InsertException("数据库或服务器故障，密码修改失败");
        }
    }


    /**
     * Description : 根据用户student_id查询用户信息
     *
     * @param studentId 用户student_id
     * @return cui.xin.student_course.bean.Student
     * @date 2022/11/11
     **/
    @Override
    public Student queryStudentByStudentId(Long studentId) {
        //根据student_id查询用户信息返回给前端
        return studentMapper.queryStudentByStudentId(studentId);
    }
}
