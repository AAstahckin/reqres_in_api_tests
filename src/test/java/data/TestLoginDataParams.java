package data;

import lombok.Getter;

@Getter
public enum TestLoginDataParams {

    LOGIN("eve.holt@reqres.in");

    final String value;

    TestLoginDataParams(String value) {
        this.value = value;
    }

}
