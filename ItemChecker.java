/**
 * instantiable class that contain the methods used in the App class
 * -check if the provided piece of text conforms to the rules corresponding to a passport number
 * -generate codes conforms to the given rules
 *
 * @elena 21215456
 */

import java.util.Random;
import java.lang.StringBuffer;

public class ItemChecker {
    //variables
    private String passportNum;
    private final int PASSPORT_LENGTH = 11;
    private boolean isValid;
    private final char[] LETTERS_ARRAY = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    //default constructor
    public ItemChecker() {
    }

    //Setter method. It converts the input to uppercase before setting it
    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum.toUpperCase();
    }

    //Getters

    //This getter is not used, but it may be needed in the future
    public String getPassportNum() {
        return passportNum;
    }

    public boolean getIsValid() {
        return isValid;
    }

    //compute
    //method that call all the others check
    public void checkPassport() {
        //the length is checked first to avoid accessing characters outside the string length
        if (checkPassportLength()) {
            if (checkPassportStart() && checkPassportSpace() && checkPassportLetter() && checkPassportDash() && checkPassportEnd()) {
                isValid = true;
                System.out.println("The validation process is complete.");
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }

    }

    // method that check the first character is P or L
    private boolean checkPassportStart() {
        if (passportNum.startsWith("P") || passportNum.startsWith("L")) {
            return true;
        } else {
            System.out.println("Error. The passport number have to start with P or L");
            return false;
        }
    } // close checkPassportNum method

    //method that check that the second character is a space
    private boolean checkPassportSpace() {
        if (passportNum.charAt(1) == ' ') {
            return true;
        } else {
            System.out.println("Error. The passport number need a space after the first letter");
            return false;
        }
    } // close checkPassportSpace method

    //method that check that the third character is a letter
    private boolean checkPassportLetter() {
        char ch = passportNum.charAt(2);
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        } else {
            System.out.println("Error. The passport number need a letter after the space");
            return false;
        }
    } // close checkPassportLetter method

    //method that check that the fourth character is a dash
    private boolean checkPassportDash() {
        if (passportNum.charAt(3) == '-') {
            return true;
        } else {
            System.out.println("Error. The passport number need a dash '-' after the letter");
            return false;
        }
    }// close checkPassportDash method

    //method that check that the length of the passport number is 11 characters
    private boolean checkPassportLength() {
        if (passportNum.length() == PASSPORT_LENGTH) {
            return true;
        } else {
            System.out.println("Error. The passport number has 11 characters");
            return false;
        }
    } // close checkPassportLength

    //method that checks that the last 7 characters of the passport number are digits between 0 to 9, both inclusive
    private boolean checkPassportEnd() {
        for (int i = 4; i < passportNum.length(); i++) {
            char ch = passportNum.charAt(i);
            //if any character is not a digit, we can return false
            if (ch < '0' || ch > '9') {
                System.out.println("Error. The passport number ends with 7 numbers");
                return false;
            }
        }
        //if we arrive here, all characters have been checked (they are all digits)
        return true;
    } // close checkPassportEnd method

    // method that create a security code
    private String generateOneCode() {
        StringBuffer strBuff = new StringBuffer();

        // use the Random class to generate a random number
        Random myRand = new Random();
        for (int i = 0; i < 4; i++) {
            // num random
            int randomNum = myRand.nextInt(9);
            strBuff.append(randomNum);
        }
        for (int i = 0; i < 3; i++) {
            // randomly select a letter
            int randomLetterIndex = myRand.nextInt(LETTERS_ARRAY.length);
            strBuff.append(LETTERS_ARRAY[randomLetterIndex]);
        }
        return strBuff.toString();
    } // close generateOneCode method

    //generate array of codes
    public String[] generateArrayCodes(int numOfCodes) {
        String[] arrayCodes = new String[numOfCodes];
        for (int i = 0; i < numOfCodes; i++) {
            arrayCodes[i] = generateOneCode();
        }
        return arrayCodes;
    }
} // close class
