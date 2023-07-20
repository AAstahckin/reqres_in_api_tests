package constans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TimeFormatConstants {

    DD_MM_YYYY_HH_MM("yyyy-MM-dd'T'HH:mm:ss.SSS");

    final String value;

}
