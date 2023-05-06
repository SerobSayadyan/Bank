package bankProject.validation;

/**
 * A Valid credit card format patterns are following:
 *      1. it should start whit 4,5 or 6;
 *      2. should contain 16 digits;
 *      3. the order should be like in following examples,
 *             - 4417 1234 5678 9113
 *             - 4417123456789113
 *             - 4417-1234-5678-9113
 * Every format other than in examples above will be considered as INVALID.
 */
public class CreditCardValidation {
    private String creditNumber;
    public boolean isCreditCardValid(String creditCardNumber){
        this.creditNumber = creditCardNumber;
        return LuhnAlgorithm();
    }
    private boolean LuhnAlgorithm(){
        if(checkIfAllAreDigits()){
            int n = creditNumber.length();
            if(n != 16){        // the number of digits in valid credit card is 16
                return false;
            }
            byte[] cardDigits = new byte[n];
            for (int i = 0; i < n; i++) {
                cardDigits[i] = (byte) (creditNumber.charAt(i) - 48);
            }
            if(!((cardDigits[0] >= 4) && (cardDigits[0] <= 6))){
                return false;
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if((i % 2) == 0){
                    cardDigits[i] *= 2;
                    if(cardDigits[i] > 9){
                        cardDigits[i] = (byte) ((cardDigits[i] % 10) + 1);
                    }
                }
                res += cardDigits[i];
            }
            return (res % 10 != 0) ? false : true;
        }
        return false;
    }
    private boolean checkIfAllAreDigits(){
        if (creditNumber.contains(" ")){
            creditNumber = creditNumber.replace(" ", "");
        }
        if (creditNumber.contains("-")){
            creditNumber = creditNumber.replace("-", "");
        }
        return creditNumber.matches("[0-9]+");
    }
}
