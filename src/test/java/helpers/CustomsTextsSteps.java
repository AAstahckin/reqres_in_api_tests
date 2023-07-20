package helpers;

public class CustomsTextsSteps {

    public static String matchingParameter(String value) {
        return String.format("Проверяем что значение \"%s\" соответствует", value);
    }

    public static String presentParameter(String value) {
        return String.format("Проверяем что параметр \"%s\" присутствует", value);
    }

    public static String matchingParameterId(int value) {
        return String.format("Проверяем что значение \"%d\" соответствует", value);
    }

    public static String countElement(int value) {
        return String.format("Проверяем колличество элементов: \"%d\"", value);
    }

    public static String countPage(int value) {
        return String.format("Проверяем что меняется page при запросе ?page=%d", value);
    }

    public static String countPerPage(int value) {
        return String.format("Проверяем что меняется per_page при запросе ?per_page=%d", value);
    }

    public static String support(String value) {
        return String.format("Проверяем что объекте support присутствует: \"%s\"", value);
    }

    public static String errorText(String value) {
        return String.format("Проверяем что присутствует ошибка: \"%s\"", value);
    }

    public static String statusCodeResponse(int value) {
        return String.format("Проверяем статус код: \"%d\"", value);
    }

    public static String postRequest(String value) {
        return String.format("Выполняется вызов метода POST, на %s", value);
    }

    public static String deleteRequest(String value) {
        return String.format("Выполняется вызов метода DELETE, на %s", value);
    }

    public static String getRequest(String value) {
        return String.format("Выполняется вызов метода GET, на %s", value);
    }

    public static String putRequest(String value) {
        return String.format("Выполняется вызов метода PUT, на %s", value);
    }

}
