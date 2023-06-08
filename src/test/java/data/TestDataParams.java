package data;

public enum TestDataParams {

    LOGIN("eve.holt@reqres.in"),
    TOKEN("QpwL5tke4Pnpja7X4");

    final String value;

    TestDataParams(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
