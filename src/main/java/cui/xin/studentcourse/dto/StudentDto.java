package cui.xin.studentcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: yangbx
 * @Date: 2022/11/04/13:50
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
    //学生id
    private Long studentId;
    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生性别
     */
    private String studentSex;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 课程名字
     */
    private String courseName;

    /**
     * 课程分数
     */
    private Integer courseGarde;

    /**
     * 课程类型
     */
    private String courseType;

    /**
     * 课程时间
     */
    private String courseTime;

    /**
     * 课程地址
     */
    private String courseAddress;

    /**
     * 上课老师
     */
    private String courseTeacher;
}
