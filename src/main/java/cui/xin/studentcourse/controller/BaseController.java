package cui.xin.studentcourse.controller;

import cui.xin.studentcourse.controller.exception.ValidCodeNotMatchException;
import cui.xin.studentcourse.dto.ResponseBean;
import cui.xin.studentcourse.service.exception.*;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @author hty
 * @version 1.0
 * @description: 基类Controller
 * @date 2022/11/9 11:32
 */
public class BaseController {
    //操作成功的状态码
    public static final int OK = 200;

    /**
     * 1.当出现了value内的异常之一，就会将下方的方法作为新的控制器方法进行执行
     * 因此该方法的返回值也同时是返回给前端的页面
     * 2.此外还自动将异常对象传递到此方法的参数列表中，这里使用Throwable e来接收
     **/
    @ExceptionHandler({ServiceException.class, FileUploadException.class, ValidCodeNotMatchException.class}) //统一处理抛出的异常
    public ResponseBean<Void> handleException(Throwable e) {
        ResponseBean<Void> result = new ResponseBean(e);
        if (e instanceof StudentNameDuplicateException) {
            result.setCode(4000); //表示用户名重复
        } else if (e instanceof InsertException) {
            result.setCode(5001); //数据库或服务器有问题
        } else if (e instanceof StudentNotExistException) {
            result.setCode(5002); //表示用户数据不存在
        } else if (e instanceof WrongPasswordException) {
            result.setCode(5003); //表示密码错误
        } else if (e instanceof OriginalPasswordNotMatchException) {
            result.setCode(5004); //表示原密码错误
        } else if (e instanceof UpdateException) {
            result.setCode(9000); //表示数据更新失败
        } else if (e instanceof ValidCodeNotMatchException) {
            result.setCode(1001); //表示验证码错误
        }
        //返回异常处理结果
        return result;
    }

    /**
     * Description : 从session中获取学生student_id
     *
     * @param session springboot启动时生成的session对象
     * @return java.lang.Integer
     * @date 2022/7/11
     **/
    public final Long getStudentIdFromSession(HttpSession session) {
        String student_idStr = session.getAttribute("studentId").toString();

        return Long.valueOf(student_idStr);
    }

    /**
     * Description : 从session中获取用户student_id
     *
     * @param session springboot启动时生成的session对象
     * @return java.lang.String
     * @date 2022/11/9
     **/
    public final String getStudentNameFromSession(HttpSession session) {
        return session.getAttribute("studentName").toString();
    }
}
