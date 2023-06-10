package api.constans;

public enum TimeFormatConstants {

    DD_MM_YYYY_HH_MM("yyyy-MM-dd'T'HH:mm:ss.SSS");


    final String value;

    TimeFormatConstants(String value) {
        this.value = value;
    }

    public String getTimeFormat() {
        return value;
    }
}
