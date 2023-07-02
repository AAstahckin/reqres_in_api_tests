package api.constans;

import lombok.Getter;

@Getter
public enum TimeFormatConstants {

    DD_MM_YYYY_HH_MM("yyyy-MM-dd'T'HH:mm:ss.SSS");


    final String value;

    TimeFormatConstants(String value) {
        this.value = value;
    }

}
