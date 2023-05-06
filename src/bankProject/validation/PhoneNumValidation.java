package bankProject.validation;

/**
 * A Valid phone number should have:
 *      - "+374" at the beginning of the phone number;
 *      - should contain 8 digits, except "+374".
 */

public class PhoneNumValidation {
    private String phoneNum;
    public boolean checkPhoneNumberValidity(String phoneNum) {
        this.phoneNum = phoneNum;
        return checkNumberCount();
    }
    private boolean checkNumberCount(){
        if (isNumCode()) {
            String numSplit = phoneNum.substring(4, phoneNum.length());
            if (numSplit.length() == 8) {
                numSplit.trim();
                return true;
            }
        }
        return false;
    }

    private boolean isNumCode(){
        if (phoneNum.contains("+374")){
            if (phoneNum.startsWith("+374")) {
                return true;
            }
        }
        return false;
    }
}

