package denominations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DenominationsCalculator {
    Integer[] denominations;
    Integer paymentAmount;
    Scanner input;

    public DenominationsCalculator(){
        input = new Scanner(System.in);
    }

    void collectDenominations(){

        System.out.println("Denominations : ");

        System.out.println("Enter size / number of denominations available : ");

        Integer denominatorSize = input.nextInt();

        denominations = new Integer[denominatorSize];

        for(int i = 0; i < denominatorSize; i++){
            System.out.printf("Enter the  Denominations value : %d / %d", (i+1), denominatorSize);
            System.out.println();

            denominations[i] = input.nextInt();
        }
    }

    void collectPaymentAmout() {
        System.out.println("Payment Amount :");
        paymentAmount = input.nextInt();
    }

    public void calculate(){

        //sort the Denomidations
        Arrays.sort(denominations, Collections.reverseOrder());

        Integer denominationIndex = 0;
        Integer balanceAmount = paymentAmount;

        while(denominationIndex < denominations.length){
            if(balanceAmount < denominations[denominationIndex]){
                denominationIndex++;
                continue;
            }

            Integer denomination =  denominations[denominationIndex];
            Integer noOfDenominator =  balanceAmount / denomination;
            balanceAmount = balanceAmount % denomination;

            if(noOfDenominator > 0){
                System.out.printf("Denominations : %d, No of times : %d", denomination, noOfDenominator);
                System.out.println();
            }

            denominationIndex++;
        }

        if(balanceAmount == 0 ){
            System.out.println("Able to provide the exact denominations");
        } else {
            System.out.println("Unable to provide the exact denominations");
            System.out.printf("Balance Amount is : %d", balanceAmount);
        }
    }
}
