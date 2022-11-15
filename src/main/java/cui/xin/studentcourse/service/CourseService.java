package cui.xin.studentcourse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.bean.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService extends IService<Course> {
    /**
     * 新增数据
     * @param course
     * @return
     */
    public int addCourse(Course course);

    /**
     * 修改数据
     * @param course
     * @return
     */
    public int editCourse(Course course);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public Course queryCourseById(Integer id);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    public int delCourseById(Integer id);

    /**
     * 查询所有学生
     * @return
     */
    public List<Course> queryCourseList();

    /**
     * 查询人数前十的科目
     * @return
     */
    public List<Course> selectTop10();

    /**
     * 查询男女比例
     * @return
     */
    public List<Course> selectSex();

    List<Course> queryCourseByConditiation(Course course);
}
