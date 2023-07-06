package api.data;

import lombok.Getter;

@Getter
public enum UsersDataValues {

    GEORGE_BLUTH(1, "george.bluth@reqres.in", "George", "Bluth", "1-image.jpg"),
    JANET_WEAVER(2, "janet.weaver@reqres.in", "Janet", "Weaver", "2-image.jpg"),
    EMMA_WONG(3, "emma.wong@reqres.in", "Emma", "Wong", "3-image.jpg"),
    EVE_HOLT(4, "eve.holt@reqres.in", "Eve", "Holt", "4-image.jpg"),
    CHARLES_MORRIS(5, "charles.morris@reqres.in", "Charles", "Morris", "5-image.jpg"),
    TRACEY_RAMOS(6, "tracey.ramos@reqres.in", "Tracey", "Ramos", "6-image.jpg"),
    MICHAEL_LAWSON(7, "michael.lawson@reqres.in", "Michael", "Lawson", "7-image.jpg"),
    LINDSAY_FERGUSON(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson", "8-image.jpg"),
    TOBIAS_FUNKE(9, "tobias.funke@reqres.in", "Tobias", "Funke", "9-image.jpg"),
    BYRON_FIELDS(10, "byron.fields@reqres.in", "Byron", "Fields", "10-image.jpg"),
    GEORGE_EDWARDS(11, "george.edwards@reqres.in", "George", "Edwards", "11-image.jpg"),
    RACHEL_HOWELL(12, "rachel.howell@reqres.in", "Rachel", "Howell", "12-image.jpg");

    private final int id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String avatar;

    public String getAvatar() {
        return String.format("https://reqres.in/img/faces/%s", avatar);
    }

    UsersDataValues(int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

}
