package cui.xin.studentcourse.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "t_student")
public class Student {
    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @TableId(value = "student_id", type = IdType.AUTO)
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
     * 盐
     */
    private String salt;
}
