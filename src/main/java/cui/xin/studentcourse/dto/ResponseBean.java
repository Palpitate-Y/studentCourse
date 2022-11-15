package cui.xin.studentcourse.dto;

/**
 * @Author: yangbx
 * @Date: 2022/11/04/13:55
 * @Description:
 */
public class ResponseBean<T> {
    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回码
     */
    private long code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T content;

    public ResponseBean(){
        this.code = 200;
        this.message = "success";
    }

    //该构造器用来封装正常操作结果的数据
    public ResponseBean(T data) {
        this.code = 200;
        this.message = "success";
        this.content = data;
    }

    //该构造器用来封装异常操作结果的数据
    //code 此时代表异常状态码
    //msg 此时代表异常信息
    //异常状态下数据保持null的状态
    public ResponseBean(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    //其他用途的构造器
    public ResponseBean(Integer code, String message,T data ) {
        super();
        this.content = data;
        this.code = code;
        this.message= message;
    }





    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResponseDto{");
        sb.append("success=").append(success);
        sb.append(", code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", content=").append(content);
        sb.append('}');
        return sb.toString();
    }
}
