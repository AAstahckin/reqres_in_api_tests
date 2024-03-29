package constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OtherTexts {

    URL_SUPPORT("https://reqres.in/#support-heading"),
    TEXT_SUPPORT("To keep ReqRes free, contributions towards server costs are appreciated!");

    final String value;

}
