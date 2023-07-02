package api.constans;

import lombok.Getter;

@Getter
public enum ErrorsTexts {

    ONLY_DEFINED("Note: Only defined users succeed registration"),
    MISSING_PASSWORD("Missing password"),
    MISSING_EMAIL_OR_USERNAME("Missing email or username"),
    USER_NOT_FOUND("user not found");

    final String value;

    ErrorsTexts(String value) {
        this.value = value;
    }

}
