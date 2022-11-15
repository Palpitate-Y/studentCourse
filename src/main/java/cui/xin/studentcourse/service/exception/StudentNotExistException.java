package cui.xin.studentcourse.service.exception;

/**
 * @author hty
 * @version 1.0
 * @description: 表示用户名不存在的异常
 * @date 2022/11/9 13:57
 */
public class StudentNotExistException extends ServiceException {
    public StudentNotExistException() {
        super();
    }

    public StudentNotExistException(String message) {
        super(message);
    }

    public StudentNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotExistException(Throwable cause) {
        super(cause);
    }

    protected StudentNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
