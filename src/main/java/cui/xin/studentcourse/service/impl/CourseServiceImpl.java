package cui.xin.studentcourse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.bean.Student;
import cui.xin.studentcourse.mapper.CourseMapper;
import cui.xin.studentcourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 添加
     * @param course
     * @return
     */
    @Override
    public int addCourse(Course course) {
        return courseMapper.insert(course);
    }

    /**
     * 修改
     * @param course
     * @return
     */
    @Override
    public int editCourse(Course course) {
        return courseMapper.updateById(course);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Course queryCourseById(Integer id) {
        return courseMapper.selectById(id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int delCourseById(Integer id) {
        return courseMapper.deleteById(id);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Course> queryCourseList() {
        return courseMapper.selectList(null);
    }

    @Override
    public List<Course> selectTop10() {
        return null;
    }

    @Override
    public List<Course> selectSex() {
        return null;
    }


    /**
     * auth：yangbx
     * 根据条件查询课程
     * @param course
     * @return
     */
    @Override
    public List<Course> queryCourseByConditiation(Course course) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        if(course.getCourseType()!=null&&course.getCourseType()!=""){
            queryWrapper.eq("course_type",course.getCourseType());
        }
        if(!StringUtils.isEmpty(course.getCourseTime())){
            queryWrapper.eq("course_time",course.getCourseTime());
        }
        if(!StringUtils.isEmpty(course.getCourseAddress())){
            queryWrapper.eq("course_address",course.getCourseAddress());
        }
        if(!StringUtils.isEmpty(course.getCourseName())){
            queryWrapper.like("course_name",course.getCourseName());
        }
        if(!StringUtils.isEmpty(course.getCourseTeacher())){
            queryWrapper.eq("course_teacher",course.getCourseTeacher());
        }
        List<Course> courseList = courseMapper.selectList(queryWrapper);
        return courseList;
    }
}
