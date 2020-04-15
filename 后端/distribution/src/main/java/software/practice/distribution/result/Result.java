package software.practice.distribution.result;

public class Result {
    //响应码
    private int code;
    //总页数
    private long total;
    //错误信息
    private String message;
    //内容
    private Object content;

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public Result(int code, long total, Object content) {
        this.code = code;
        this.total = total;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
