package cui.xin.studentcourse.service.exception;

/**
 * @author hty
 * @version 1.0
 * @description: 用于处理业务层的异常基类
 * @date 2022/11/9 13:56
 */
//e.g. throws new ServiceException("业务层出现异常")
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
