package constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpStatus {

    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    NOT_FOUND(404);

    final int code;

}
