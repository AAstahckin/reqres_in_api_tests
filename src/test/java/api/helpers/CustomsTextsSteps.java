package api.helpers;

public class CustomsTextsSteps {

    public static String stepMatchingParameter(String value) {
        return String.format("Проверяем что %s соответствует", value);
    }

    public static String stepMatchingParameterId(int value) {
        return String.format("Проверяем что %d соответствует", value);
    }


}
