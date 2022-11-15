package cui.xin.studentcourse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cui.xin.studentcourse.bean.Student;
import cui.xin.studentcourse.dto.StudentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author hty
 * @version 1.0
 * @description: Student实体类对应的mapper接口
 * @date 2022/11/9 12:46
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentDto> {

    List<StudentDto> queryStudentByConditiation(StudentDto studentDto);

    /**
     * Description : 用户注册
     * @date 2022/11/11
     * @param student 用户信息
     * @return int 插入的结果
     **/
    int addStudent(Student student);

    /**
     * Description : 根据用户名查询用户信息
     * @date 2022/11/11
     * @param student_name 用户名
     * @return cui.xin.studentcourse.bean.Student
     **/
    Student queryStudentByStudentName(String student_name);

    /**
     * Description : 根据id查询用户信息
     * @date 2022/11/11
     * @param studentId 用户id
     * @return cui.xin.studentcourse.bean.Student
     **/
    Student queryStudentByStudentId(Long studentId);
    /**
     * Description : 根据id和号码查询用户信息
     * @date 2022/11/11
     * @param studentId  用户id
     * @param mobile  手机号码
     * @return cui.xin.studentcourse.bean.Student
     **/
    Student queryStudentByStudentIdAndMobile(Long studentId,String mobile);
    /**
     * Description : 更新密码
     * @date 2022/11/11
     * @param student 用户信息
     * @return int 更新的结果
     **/
    int updatePassword(Student student);

}
