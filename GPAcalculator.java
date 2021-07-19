package com.UnicornDevelopers;

//import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GPAcalculator {
    public static int courseNumber; //number of courses offered
    public static String[] gradeList; // course grade list
    public static int[] courseCredithourList;  // course credit hour
    public static double[] gradesPointsCollect;

    //main method
    public static void main(String[] arg){
        Scanner input = new Scanner(System.in);

        //Start of Program
        System.out.println("||||||||||||||WELCOME TO GPAgenius GPA CALCULATOR||||||||||||||");
        System.out.println("Enter how many courses you want to calculate GPA for:");
        courseNumber = input.nextInt();
        gradeList = new String[courseNumber];
        courseCredithourList = new int[courseNumber];
        gradesPointsCollect = new  double[courseNumber];
        gradesAndCredits();
        totalGradePoints();
        calculateGPA();
        System.out.println("\n\n<<<<<<<<<<<<<End of Program>>>>>>>>>>>>>>>>>");

    }

    //method to update lists with grades and their credit hours.
    public static void gradesAndCredits(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the grade you got for the course and then its corresponding course credit hour(s):");
      for(int i = 0; i < courseNumber; i++){
          System.out.printf("Enter course grade for COURSE %d:", i+1);
          try {
              gradeList[i] = input.nextLine();
          }
          catch (InputMismatchException e){
              System.out.println("Oops! Wrong input: Grade can only be a letter.");
          }
          System.out.printf("Enter the credit hour(s) for COURSE %d:", i+1);
          try {
              courseCredithourList[i] = input.nextInt();
              input.nextLine();
          }
          catch (InputMismatchException e){
              System.out.println("Oops! Wrong input: Credit hours can only be a number.");
          }

      }
    }

    //method to get total credit hours for courses done
    public static int totalCreditHours(){
        int total = 0; //stores total credit hours
        for (int credit: courseCredithourList){
            total += credit;
        }
        return total;
    }


    //method to find the total grade points
    public static double totalGradePoints(){
        double totalPoints = 0.0;
        double actualgrade;

        //Legend: grades and their respective grade points
        for (int i=0; i<gradeList.length; i++){
            switch (gradeList[i].toUpperCase()) {
                case "A", "A+" -> {
                    actualgrade = 4.0 * courseCredithourList[i];
                    gradesPointsCollect[i] = actualgrade;
                }
                case "B+" -> {
                    gradesPointsCollect[i] = 3.5 * courseCredithourList[i];
                }
                case "B" -> {
                    gradesPointsCollect[i] = 3.0 * courseCredithourList[i];

                }
                case "C+" -> {
                    gradesPointsCollect[i] = 2.5 * courseCredithourList[i];

                }
                case "C" -> {
                    gradesPointsCollect[i] = 2.0 * courseCredithourList[i];

                }
                case "D+" -> {
                    gradesPointsCollect[i] = 1.5 * courseCredithourList[i];

                }
                case "D" -> {
                    gradesPointsCollect[i] = 1.0 * courseCredithourList[i];

                }
                case "E" -> {
                    gradesPointsCollect[i] = 0.5 * courseCredithourList[i];

                }
                case "F" -> gradesPointsCollect[i] = 0.0;
            }

        }
        // getting the total grade points
        for (double gradepoint : gradesPointsCollect){
            totalPoints += gradepoint;
        }
        return totalPoints;

    }


    //method to calculate Student GPA
    public static void calculateGPA(){
        System.out.println("\n**************************************************************");
        System.out.println("Your various course grades and  their respective credit hours:");
        System.out.println("**************************************************************\n");
        System.out.println("COURSE GRADE       COURSE CREDIT HOURS       ACTUAL GRADE POINT");
        for (int i = 0; i<courseNumber; i++){
            System.out.printf("    "+gradeList[i] + "                      " +courseCredithourList[i] +"                     " + gradesPointsCollect[i] + "\n");
        }
        System.out.printf("\nYour total grade points: %.2f", totalGradePoints());
        System.out.println("\t Your total credit hours: " + totalCreditHours());
        System.out.printf("Your GPA is: %.2f", totalGradePoints()/totalCreditHours());



    }


}
