package th.cimb.question.impl;

import th.cimb.question.Question;
import th.cimb.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 implements Question {

    public Question1() {}
    public Question1(List<Integer> ints) {setCaze(ints);}
    public Question1(Integer[] ints) {setCaze(ints);}

    private List<Integer> caze = null;
    private boolean printLog = false;



    private Integer process() {
        if(caze == null || caze.isEmpty()) return 0;

        Integer maxProfit = 0;
        Integer buyAt = 0;
        Integer sellAt = 0;

        for (int p = 0; p < caze.size(); p++) {
            Integer buyDay = p;
            Integer sellDay = getMaxProfitAtDay(caze.subList(p, caze.size())) + p;
            Integer profit = caze.get(sellDay) - caze.get(buyDay);
            if(profit > maxProfit){
                maxProfit = profit;
                buyAt = buyDay;
                sellAt = sellDay;
            }
        }
        if(printLog)
            log(caze, maxProfit, buyAt, sellAt);
        return maxProfit;
    }

    private static void log(List<Integer> prices, Integer maxProfit, Integer buyAt, Integer sellAt) {
        System.out.print("price each day: | ");
        prices.forEach(p -> {
            System.out.print(p+" | ");
        });
        System.out.println("\nbuy at D+"+ (maxProfit > 0? buyAt +1:0));
        System.out.println("sell at D+"+ (maxProfit > 0? sellAt +1:0));
        System.out.println("max profit "+ maxProfit);
        System.out.println("=========================");
    }

    private Integer getMaxProfitAtDay(List<Integer> prices){
        int day = 0;
        for ( int p = 1; p < prices.size(); p++ )
        {
            if ( prices.get(p) > prices.get(day) )
                day = p;
        }
        return day;
    }

    @Override
    public boolean setCaze(Object caze) {
        this.caze = null;

        if(caze == null) {
            return false;
        }

        List<?> toIterate;
        switch (caze) {
            case String s -> {
                String[] strings = s.split(",");
                toIterate = Util.toList(strings);
            }
            case Integer[] integers -> toIterate = Util.toList(integers);
            case int[] ints -> toIterate = Arrays.stream(ints).boxed().toList();
            case List list -> toIterate = list;
            default -> {
                return false;
            }
        }

        if(toIterate.size() > Math.pow(10,5)) return false;
        try{
            List<Integer> toSet = new ArrayList<>();
            for (int i = 0; i < toIterate.size(); i++) {
                Integer val = Integer.parseInt(toIterate.get(i).toString());
                if(val < 0 || val > Math.pow(10,4)) {
                    return false;
                }
                toSet.add(val);
            }
            this.caze = toSet;
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public Integer answer() {
        return process();
    }

    @Override
    public String inputGuideline() {
        return "Input Pattern: 1,2,3,4,5...\n" +
                "Constraints: \n" +
                "=> - 1 <= input.length <= 10^5\n" +
                "=> - 0 <= input[i] <= 10^4";
    }

    @Override
    public void setPrintLog(boolean printLog) {
        this.printLog = printLog;
    }
}
