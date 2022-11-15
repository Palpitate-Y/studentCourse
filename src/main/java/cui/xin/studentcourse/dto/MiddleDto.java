package cui.xin.studentcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: palpitate_yzr
 * @Date: 2022/11/07/10:30
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MiddleDto {
    //学生id
    private Long studentId;
    //学生姓名
    private String studentName;
    //课程id
    private Long courseId;
    //课程姓名
    private String courseName;
    //课程成绩
    private Integer courseGrade;
    //课程性质
    private String courseType;
    //学年
    private Integer courseYear;
}
