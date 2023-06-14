package api.constans;

public enum OtherTexts {

    URL_SUPPORT("https://reqres.in/#support-heading"),
    TEXT_SUPPORT("To keep ReqRes free, contributions towards server costs are appreciated!");

    final String value;

    OtherTexts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
