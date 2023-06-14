package data;

public enum UsersDataValues {

    GEORGE_BLUTH(1, "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg"),
    JANET_WEAVER(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg"),
    EMMA_WONG(3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg"),
    EVE_HOLT(4, "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg"),
    CHARLES_MORRIS(5, "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg"),
    TRACEY_RAMOS(6, "tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg"),
    MICHAEL_LAWSON(7, "michael.lawson@reqres.in", "Michael", "Lawson", "https://reqres.in/img/faces/7-image.jpg"),
    LINDSAY_FERGUSON(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson", "https://reqres.in/img/faces/8-image.jpg"),
    TOBIAS_FUNKE(9, "tobias.funke@reqres.in", "Tobias", "Funke", "https://reqres.in/img/faces/9-image.jpg"),
    BYRON_FIELDS(10, "byron.fields@reqres.in", "Byron", "Fields", "https://reqres.in/img/faces/10-image.jpg"),
    GEORGE_EDWARDS(11, "george.edwards@reqres.in", "George", "Edwards", "https://reqres.in/img/faces/11-image.jpg"),
    RACHEL_HOWELL(12, "rachel.howell@reqres.in", "Rachel", "Howell", "https://reqres.in/img/faces/12-image.jpg");

    private final int id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String avatar;

    UsersDataValues(int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatar() {
        return avatar;
    }
}
