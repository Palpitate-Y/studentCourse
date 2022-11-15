package cui.xin.studentcourse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cui.xin.studentcourse.bean.Student;
import cui.xin.studentcourse.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.List;

public interface StudentService extends IService<StudentDto> {

    List<StudentDto> select();
    /**
     * 新增数据
     * @param studentDto
     * @return
     */
    int addStudent(StudentDto studentDto);

    /**
     * 修改数据
     * @param studentDto
     * @return
     */
    int editStudent(StudentDto studentDto);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    StudentDto queryStudentById(Integer id);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int delStudentById(Integer id);

    /**
     * 根据条件所有学生
     * @return
     */
    List<StudentDto> queryStudentByConditiation(StudentDto studentDto);

    /**
     * 查询没有选课的学生
     * @return
     */
    List<StudentDto> selectNoCourseStudentList();

    //处理用户注册
    void studentRegister(Student student);
    //处理用户登录
    Student studentLogin(Student student);

    //根据id查询用户信息
    Student queryStudentByStudentId(Long studentId);

    void updatePassword(Student student);
}
