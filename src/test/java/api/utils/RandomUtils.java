package api.utils;

import com.github.javafaker.Faker;
import data.UsersDataValues;

public class RandomUtils {

    static Faker faker = new Faker();

    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        return enumClass.getEnumConstants()[faker.random().nextInt(0, enumClass.getEnumConstants().length - 1)];
    }

    public static UsersDataValues getRandomUserForId() {
        return getRandomEnum(UsersDataValues.class);
    }

    public static String getRandomText(int length) {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<length; i++){
            stringBuilder.append(str.charAt(faker.random().nextInt(str.length())));
        }
        return stringBuilder.toString();
    }

}
