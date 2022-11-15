package cui.xin.studentcourse.dto;


/**
 * 公共返回对象
 *
 * @author: LC
 * @date 2022/3/2 1:50 下午
 * @ClassName: RespBean
 */
public class RespBean<T> {
  /*  //数据状态码  给程序用的
    private long code;
    //数据状态信息   发到前端给人看的
    private String message;
    //泛型属性，代表任意类型的数据对象
    private T data;

    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), null);
    }

    public static RespBean success(T data) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), data);
    }

    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }

    public static RespBean error(RespBeanEnum respBeanEnum, T data) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), data);
    }

    public RespBean(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public RespBean(){

    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }*/
}
