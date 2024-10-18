package th.cimb.question.impl;

import th.cimb.question.Question;

import java.util.LinkedList;
import java.util.List;

public class Question3 implements Question {

    private boolean printLog = false;
    private Integer caze = null;

    @Override
    public boolean setCaze(Object caze) {
        this.caze = null;
        if(caze == null) return false;
        try {
            Integer tryCast = Integer.valueOf(caze.toString());
            if(tryCast < 1 || tryCast > 45){
                return false;
            }
            this.caze = tryCast;
            return true;
        } catch (RuntimeException e){
            return false;
        }
    }

    private Integer countWays(Integer n, LinkedList<Integer> pattern, String msg){
        if(pattern.isEmpty() || n == null) return 0;

        Integer count = 0;
        if(pattern.peek() > n){
            if(printLog){
                msg = msg.substring(0, msg.lastIndexOf(" + "));
                System.out.println(msg);
            }
            count += pattern.peek();
        }
        else {
            for (Integer steps : pattern){
                if(n - steps >= 0){
                    count += countWays(n - steps, pattern,msg + steps + " + ");
                }
            }
        }
        return count;
    }

    @Override
    public Integer answer() {
        LinkedList<Integer> pattern = new LinkedList<>();
        pattern.add(1);
        pattern.add(2);
        Integer ans = countWays(caze, pattern, "");
        if(printLog){
            System.out.println("all possible ways: "+ans+" way"+(ans>1?"s":""));
        }
        return ans;
    }

    @Override
    public String inputGuideline() {
        return """
                ========== Q3 ==========
                Input Pattern: 3
                Constraints:\s
                => - 1 <= number <= 45""";
    }

    @Override
    public void setPrintLog(boolean printLog) {
        this.printLog = printLog;
    }
}
