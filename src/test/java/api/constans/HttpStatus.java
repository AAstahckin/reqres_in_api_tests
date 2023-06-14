package api.constans;

public enum HttpStatus {

    OK(200),
    CREATED(201),
    BAD_REQUEST(400);

    private final int code;

    HttpStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
