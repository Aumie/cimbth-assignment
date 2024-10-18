package th.cimb;

import th.cimb.question.Question;
import th.cimb.question.impl.Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = "input: ";
        String exitKey = "q";

        List<Question> questions = new ArrayList<>();
        questions.add(new Question1());
        questions.forEach(q->q.setPrintLog(true));

        System.out.println("========== Hello CIMBTH! ==========");
        System.out.println("enter q to exit");
        while (true){
            System.out.printf("Select your answer(1-%d): ", questions.size());
            String option = scanner.nextLine();
            System.out.println("option is: " + option);
            if (option.equalsIgnoreCase(exitKey)){
                System.exit(0);
            }
            try {
                Question q = questions.get(Integer.parseInt(option)-1);
                System.out.println(q.inputGuideline());
                System.out.print(input);
                String inputCase = scanner.nextLine();
                if (inputCase.equalsIgnoreCase(exitKey)){
                    System.exit(0);
                }
                boolean isValidPattern = q.setCaze(inputCase);
                while(!isValidPattern){
                    System.out.println(q.inputGuideline());
                    System.out.print(input);
                    inputCase = scanner.nextLine();
                    if (inputCase.equalsIgnoreCase(exitKey)){
                        System.exit(0);
                    }
                    isValidPattern = q.setCaze(inputCase);
                }
                q.answer();
                q.setCaze(null);
            }catch (RuntimeException e){
                System.out.println("Sorry, the answer is unavailable...");
            }
        }
    }
}

