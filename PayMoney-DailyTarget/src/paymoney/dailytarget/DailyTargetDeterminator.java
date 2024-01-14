package paymoney.dailytarget;

import java.awt.*;
import java.util.Scanner;

public class DailyTargetDeterminator {

    Integer[] transactionsList;
    Integer transactionsListSize;
    Integer totalNumberOfTarget;
    Integer dailyTarget;
    Scanner input;

    public DailyTargetDeterminator(){
        input = new Scanner(System.in);
    }

    public void collectTransactionValues(){
        System.out.println("Transactions List : ");
        System.out.println("Enter the Transactions List size : ");
        transactionsListSize = input.nextInt();

        transactionsList = new Integer[transactionsListSize];

        for(int index = 0; index < transactionsListSize; index++ ){
            System.out.printf("Transaction value : %d / %d ", (index+1), transactionsListSize);
            System.out.println();

            transactionsList[index] = input.nextInt();
        }
    }

    public void determine(){
        // Get the total number of target and
        System.out.println("Enter the total no of targets that needs to be achieved : ");
        totalNumberOfTarget = input.nextInt();

        // Get daily target and calculate if target is achieved for each target
        for(int i = 1; i <= totalNumberOfTarget ; i++) {
            System.out.println();
            System.out.printf("Enter daily Target %d : ",i);
            dailyTarget = input.nextInt();

            boolean dailyTargetAchieved = false;
            Integer overallSumOfTransactionValues = 0;
            int transactionInstancesCounter = 0;

            for (int index = 0; index < transactionsList.length; index ++) {
                transactionInstancesCounter++;
                Integer trasactionValue = transactionsList[index];

                overallSumOfTransactionValues = overallSumOfTransactionValues + trasactionValue;
                if (overallSumOfTransactionValues >= dailyTarget) {
                    dailyTargetAchieved = true;
                    break;
                }
            }
            if (dailyTargetAchieved) {
                System.out.println("Daily Target is achieved");
                System.out.printf("Achieved after %d Instances", transactionInstancesCounter);

            }else {
                System.out.println("Daily Target NOT achieved");
            }
        }
    }
}
