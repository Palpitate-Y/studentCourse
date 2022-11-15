package cui.xin.studentcourse.util;

import lombok.Data;

import java.util.Objects;

/**
 * @author hty
 * @version 1.0
 * @description: 响应数据
 * @date 2022/11/9 13:37
 */
@Data
public class JsonResult<E> {
    //响应状态码 200-成功 4000-用户名重复 5000-数据库或服务器异常
    private int status;
    //响应信息
    private String message;
    //响应数据
    private E data;

    public JsonResult() {
    }

    public JsonResult(int status) {
        this.status = status;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(int status, E data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResult<?> that = (JsonResult<?>) o;
        return status == that.status &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, data);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
