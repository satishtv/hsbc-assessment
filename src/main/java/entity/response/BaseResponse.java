package entity.response;

public class BaseResponse {

    public int httpStatusCode;

    public BaseResponse() { }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
