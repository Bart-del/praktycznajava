public class User {
    private final String name;
    private final String email;
    private final String country;
    private final Gender gender;

    public User(String name, Gender gender, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.gender = gender;
    }

    //Gettery i Settery


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public Gender getGender() {
        return gender;
    }

    public static User ofPolishMan(String name, String email) {
        return new User(name, Gender.MAN, email, "Poland");
    }

}
