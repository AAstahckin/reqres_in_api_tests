package data;

public enum TestLoginDataParams {

    LOGIN("eve.holt@reqres.in"),
    TOKEN("QpwL5tke4Pnpja7X4");

    final String value;

    TestLoginDataParams(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
