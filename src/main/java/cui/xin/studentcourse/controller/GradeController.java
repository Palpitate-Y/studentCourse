package cui.xin.studentcourse.controller;


import cui.xin.studentcourse.bean.Course;
import cui.xin.studentcourse.dto.MiddleDto;
import cui.xin.studentcourse.dto.ResponseBean;
import cui.xin.studentcourse.service.MiddleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 选课信息表 前端控制器
 * 使用中间表middle 进行成绩统计
 * </p>
 *
 * @author palpitate_yzr
 * @since 2022年11月9日09:57:22
 */
@Slf4j
@RestController
@RequestMapping("/Grade")
public class GradeController {

    @Autowired
    private MiddleService middleService;


    /**
     * 根据当前登录的学生id查询历年全部成绩
     * @param session
     * @return
     */

    @RequestMapping("/showAllGrade")
    public ResponseBean showAllGrade (HttpSession session){
        ResponseBean responseBean = new ResponseBean();
        //Long studentId = (Long) session.getAttribute("studentId");
        //运行测试 用户固定id为1
        Long studentId=1L;
        List<MiddleDto> middles= middleService.showAllGrade(studentId);
        responseBean.setContent(middles);
        return responseBean;
    }

    /**
     * 根据条件查询成绩
     * @param session
     * @param course
     * @return
     */
    @RequestMapping("/showGradeByCondition")
    public ResponseBean showGradeByCondition (HttpSession session,@RequestBody(required = false) Course course){
        ResponseBean responseBean = new ResponseBean();
        //Long studentId = (Long) session.getAttribute("studentId");
        //运行测试 用户固定id为1
        Long studentId=1L;
        List<MiddleDto> middles= middleService.showGradeByCondition(studentId,course);
        responseBean.setContent(middles);
        return responseBean;
    }

    /**
     * 查询未通过成绩
     * @param session
     * @return
     */
    @RequestMapping("/showNoPassGrade")
    public ResponseBean showNoPassGrade (HttpSession session){
        ResponseBean responseBean = new ResponseBean();
        //Long studentId = (Long) session.getAttribute("studentId");
        //运行测试 用户固定id为1
        Long studentId=1L;
        List<MiddleDto> middles= middleService.showNoPassGrade(studentId);
        responseBean.setContent(middles);
        return responseBean;
    }

    /**
     * 查询已通过的成绩
     * @param session
     * @return
     */
    @RequestMapping("/showPassGrade")
    public ResponseBean showGradeSort (HttpSession session){
        ResponseBean responseBean = new ResponseBean();
        //Long studentId = (Long) session.getAttribute("studentId");
        //运行测试 用户固定id为1
        Long studentId=1L;
        List<MiddleDto> middles= middleService.showPassGrade(studentId);
        responseBean.setContent(middles);
        return responseBean;
    }
}

