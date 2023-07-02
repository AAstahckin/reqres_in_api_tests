package api.constans;

import lombok.Getter;

@Getter
public enum Urls {

    URL_REGISTER("/register"),
    URL_LOGIN("/login"),
    URL_USER("/users/"),
    URL_USERS("/users");

    final String url;

    Urls(String url) {
        this.url = url;
    }


}
