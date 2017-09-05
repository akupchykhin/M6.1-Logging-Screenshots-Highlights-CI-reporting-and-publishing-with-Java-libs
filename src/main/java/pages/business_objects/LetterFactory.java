package pages.business_objects;

public class LetterFactory {

    public Letter defaultLetter() {
        Letter letterData = new Letter();
        letterData.setAddress("test2.asd@yandex.ru");
        letterData.setSubject("test email");
        letterData.setBody("test text here21231");
        return letterData;
    }
}
