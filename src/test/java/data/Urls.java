package data;

public enum Urls {

    URL_REGISTER("/register"),
    URL_LOGIN("/login"),
    URL_USERS("/users");

    final String value;

    Urls(String value) {
        this.value = value;
    }

    public String getUrl() {
        return value;
    }

}
