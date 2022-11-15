package cui.xin.studentcourse.service.exception;

/**
 * @author hty
 * @version 1.0
 * @description: 表示用户名重复的异常
 * @date 2022/11/9 13:57
 */
public class StudentNameDuplicateException extends ServiceException{

    public StudentNameDuplicateException() {
    }

    public StudentNameDuplicateException(String message) {
        super(message);
    }

    public StudentNameDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNameDuplicateException(Throwable cause) {
        super(cause);
    }

    public StudentNameDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
