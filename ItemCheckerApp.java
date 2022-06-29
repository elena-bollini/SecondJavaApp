/**
 * application that has two functionalities:
 * -check if the provided piece of text conforms to the rules corresponding to a passport number
 * -generate codes conforms to the given rules
 *
 * @elena 21215456
 */

import java.util.Scanner;

public class ItemCheckerApp {

    public static void main(String[] args) {
        //variables
        String passportNum;
        int numInputUser;
        int numOfCodes;
        ItemChecker ic;
        ic = new ItemChecker();

        //process
        System.out.println("How many passport do you need to check?");
        Scanner myInput = new Scanner(System.in);
        numInputUser = myInput.nextInt();
        myInput.nextLine();

        for (int i = 0; i < numInputUser; i++) {
            //request input
            System.out.println("Enter you passport number:");
            passportNum = myInput.nextLine();
            //set the passaport number to the input provided by the user
            ic.setPassportNum(passportNum);
            //call method checkPassaport that contain all the methods developed in the I.C. that check the different rules corrisponding to a passport number
            ic.checkPassport();
            // print a string and call the method getIsValid() that return the boolean value of passaport numbervalidation
            if (ic.getIsValid() == true) {
                System.out.println("The passport format is: valid");
            } else {
                System.out.println("The passport format is: invalid");
            }
        }
        //request num of code to generate
        System.out.println("Enter number of codes to generate:");
        numOfCodes = myInput.nextInt();
        myInput.nextLine();
        //cal method generateArrayCodes that generate a number ad codes following to the given rules, passing as attribute the number of codes that the user whant to generate
        String[] arrayOfCodes = ic.generateArrayCodes(numOfCodes);

        //display array
        for (int i = 0; i < arrayOfCodes.length; i++) {
            System.out.println(arrayOfCodes[i]);
        }
    }// close main
} //close ItemCheckerApp class
