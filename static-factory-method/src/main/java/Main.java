public class Main {
    public static void main(String[] args) {
    User user = new User("Jacek", Gender.MAN, "Nowak", "jacek.nowak@email.com");
    User user1 = User.ofPolishMan("Marcin", "123@gmail.com");
    }
}
