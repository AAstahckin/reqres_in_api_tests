package constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Urls {

    URL_REGISTER("/register"),
    URL_LOGIN("/login"),
    URL_USER("/users/%d"),
    URL_USERS("/users");

    final String url;

}
