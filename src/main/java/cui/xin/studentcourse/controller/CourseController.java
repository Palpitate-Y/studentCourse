package cui.xin.studentcourse.controller;

import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.dto.ResponseBean;
import cui.xin.studentcourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * auth：yangbx
     * 学生根据条件查询课程
     * @param course
     * @return
     */
    @RequestMapping("/queryCourse")
    public ResponseBean queryCourseByConditiation(@RequestBody(required = false) Course course) {
        ResponseBean responseBean = new ResponseBean();
        List<Course> courses = courseService.queryCourseByConditiation(course);
        responseBean.setContent(courses);
        System.out.println(course);
        return responseBean;
    }

    @RequestMapping("/add")
    public void add(Course course){
        courseService.addCourse(course);
    }

    @RequestMapping("/edit")
    public void edit(Course course){
        courseService.editCourse(course);
    }

    @RequestMapping("/query")
    public Course query(Integer id){
        return courseService.queryCourseById(id);
    }

    @RequestMapping("/del/{id}")
    public void del(@PathVariable("id") Integer id){
        courseService.delCourseById(id);
    }

    @RequestMapping("/queryList")
    public List<Course> queryList(){
        return courseService.queryCourseList();
    }

    @RequestMapping("/top10")
    public List<Course> top10(){
        return courseService.selectTop10();
    }

    @RequestMapping("/sex")
    public List<Course> sex(){
        return courseService.selectSex();
    }
}
