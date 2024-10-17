package th.cimb;

import th.cimb.question.Question1;
import th.cimb.question.Question2;
import th.cimb.question.Question3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        Question1 q1;
        Question2 q2;
        Question3 q3;

        System.out.println("Test Input");
        while (true){
            String name = scanner.nextLine();
            System.out.println("name is: " + name);
            if (name.equals("aum")){
                break;
            }
        }
    }
}

