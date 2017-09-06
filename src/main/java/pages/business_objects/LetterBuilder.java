package pages.business_objects;

public class LetterBuilder {

    private Letter letter = new Letter();

    public LetterBuilder address(String address) {
        letter.setAddress(address);
        return this;
    }

    public LetterBuilder subject(String subject) {
        letter.setSubject(subject);
        return this;
    }

    public LetterBuilder body(String body) {
        letter.setAddress(body);
        return this;
    }

    public Letter build() {
        return letter;
    }



}
