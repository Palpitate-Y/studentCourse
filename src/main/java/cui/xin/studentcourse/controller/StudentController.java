package cui.xin.studentcourse.controller;

import com.google.code.kaptcha.Constants;
import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.bean.Student;
import cui.xin.studentcourse.controller.exception.ValidCodeNotMatchException;
import cui.xin.studentcourse.dto.ResponseBean;
import cui.xin.studentcourse.dto.StudentDto;
import cui.xin.studentcourse.service.CourseService;
import cui.xin.studentcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/Student")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    //用户注册
    @PostMapping("/register")
    public ResponseBean<Void> studentRegister(Student student, HttpSession session, String code) {
        //从session取出验证码
        String validCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //判断验证码是否一致
        if (!validCode.equals(code)) {
            throw new ValidCodeNotMatchException("验证码错误,请重试！");
        }
        //执行插入操作
        studentService.studentRegister(student);

        return new ResponseBean<>();
    }

    //用户登录
    @GetMapping("/login")
    public ResponseBean<Student> studentLogin(Student student, HttpSession session, String code) {
        //将存储在session的kaptcha所生成的验证码取出
        String validCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //判断验证码是否一致
        if (!validCode.equals(code)) {
            throw new ValidCodeNotMatchException("验证码错误,请重试！");
        }
        //执行登录操作
        Student loginStudent = studentService.studentLogin(student);
        //分别将用户的session保存到服务端
        session.setAttribute("studentId", loginStudent.getStudentId());
        session.setAttribute("studentName", loginStudent.getStudentName());
        //优化一下传回前端的student数据，有些字段是不需要的。
        //只将用户名和Student_id进行回传
        Student newStudent = new Student();
        newStudent.setStudentName(loginStudent.getStudentName());
        newStudent.setStudentId(loginStudent.getStudentId());
        newStudent.setStudentSex(loginStudent.getStudentSex());
        newStudent.setMobile(loginStudent.getMobile());

        return new ResponseBean<>(newStudent);
    }
    @GetMapping("/queryStudent")
    public ResponseBean<Student> queryStudentByStudent_id(HttpSession session) {
        Long studentId = getStudentIdFromSession(session);
        Student student = studentService.queryStudentByStudentId(studentId);
        //将id、用户名、性别、电话进行回传
        Student newStudent = new Student();
        newStudent.setStudentId(student.getStudentId());
        newStudent.setStudentName(student.getStudentName());
        newStudent.setStudentSex(student.getStudentSex());
        newStudent.setMobile(student.getMobile());

        return new ResponseBean<>(newStudent);
    }
    //修改密码
    @PostMapping("/updatePassword")
    public ResponseBean<Void> studentRestPassword(Student student) {

        studentService.updatePassword(student);

        return new ResponseBean<>();
    }

    //处理用户退出登录的请求
    @GetMapping("/exit")
    public ResponseBean<Void> exitStudentLoginStatus(HttpSession session) {
        session.removeAttribute("studentName");
        session.removeAttribute("studentId");
        return new ResponseBean<>();
    }
    /**
     * auth：yangbx
     * 已选课程展示
     * @param studentDto
     * @return
     */
    @RequestMapping("/queryByConditiation")
    public ResponseBean queryStudentByConditiation(@RequestBody(required = false) StudentDto studentDto){
        System.out.println("====================================================");
        ResponseBean responseBean = new ResponseBean();
        studentService.queryStudentByConditiation(studentDto);
        responseBean.setContent(studentDto);
        System.out.println(studentDto);
        return responseBean;
    }


    @RequestMapping("/add")
    public void add(StudentDto studentDto){
        studentService.addStudent(studentDto);
    }

    @RequestMapping("/edit")
    public void edit(StudentDto studentDto){
        studentService.editStudent(studentDto);
    }

    @RequestMapping("/del/{id}")
    public void del(@PathVariable("id") Integer id){
        studentService.delStudentById(id);
    }

    @RequestMapping("/noStudentList")
    public List<StudentDto> selectNoCourseStuList() {
        return studentService.selectNoCourseStudentList();
    }
}
