This package consist of several classes for following validations
            Purpose                                     Java class
    1. Email validation                ->           class EmailValidation
    2. Phone number validation         ->           class PhoneNumValidation
    3. Credit Card validation          ->           class CreditCardValidation
    4. Credit Card date validation     ->           class CreditCardDateValidation
    5. URL validation                  ->           class URLValidation

Which method should be called for every specific validation
            Java class                                  Method(argument type) : return type
    1. class EmailValidation           ->           checkEmail(String) : boolean
    2. class PhoneNumValidation        ->           checkPhoneNumberValidity(String) : boolean
    3. class CreditCardValidation      ->           isCreditCardValid(String) : boolean
    4. class CreditCardDateValidation  ->           isDateValid(String) : boolean
    5. class URLValidation             ->           isURLValid(String) : boolean

Additional information can be found in header section of .java files.