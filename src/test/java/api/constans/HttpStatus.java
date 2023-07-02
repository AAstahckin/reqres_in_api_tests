package api.constans;

import lombok.Getter;

@Getter
public enum HttpStatus {

    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    NOT_FOUND(404);

    private final int code;

    HttpStatus(int code) {
        this.code = code;
    }

}
