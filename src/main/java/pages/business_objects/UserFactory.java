package pages.business_objects;

public class UserFactory {

    public User createUser() {
        User userData = new User();
        userData.setEmailUrl("https://mail.yandex.by/");
        userData.setLogin("yalogintest");
        userData.setPassword("yalogintest123");
        return userData;
    }
}
