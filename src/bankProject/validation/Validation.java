package bankProject.validation;

/**
 * mail
 * phone number
 * dates (formats)
 * credit card   LOCAL DATE java
 * websites that checks the validation
 */
public class Validation {
    public static void main(String[] args) {
        var isValid = new Validation();
        isValid.infoValidation();
    }

    public void infoValidation() {
        var email = new EmailValidation();
        System.out.println("Is email valid - " + email.checkEmail("serobsayadyan@gmail.com"));
        var card = new CreditCardValidation();
        System.out.println("Is card number valid - " + card.isCreditCardValid("4417 1234 5678 9113")); //4417 1234 5678 9113
        var phone = new PhoneNumValidation();
        System.out.println("Is phone number valid - " + phone.checkPhoneNumberValidity("+37477822776"));
        var date = new CreditCardDateValidation();
        System.out.println("is date valid - " + date.isDateValid("02/2026"));
        var url = new URLValidation();
        System.out.println("is URL valid - " + url.isURLValid("https://www.geeksforgeeks.org/url-class-java-examples/"));
    }
}