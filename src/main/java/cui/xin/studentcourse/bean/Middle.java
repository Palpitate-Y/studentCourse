package cui.xin.studentcourse.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 选课信息表
 * </p>
 *
 * @author palpitate_yzr
 * @since 2022-11-08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Middle implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 学号
     */
    private Long studentId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 课程号
     */
    private Long courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 成绩
     */
    private Integer courseGrade;


}
