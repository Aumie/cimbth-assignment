package th.cimb.question.impl;

import th.cimb.question.Question;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Question2 implements Question {

    private boolean printLog = false;
    private String[] inputs = null;
    private final String regex = "^[0-9.]+$";

    @Override
    public boolean setCaze(Object caze) {
        inputs = null;
        if(caze == null) return false;
        try{
            String[] versions = caze.toString().split(",");
            if(versions.length != 2) return false;
            String v1 = versions[0];
            String v2 = versions[1];
            if(v1.length() > 500 || v2.length() > 500) return false;
            if(!Pattern.matches(regex, v1)) return false;
            if((v1.charAt(0) == '.' ) || (v1.charAt(v1.length()-1) == '.')) return false;
            if(!Pattern.matches(regex, v2)) return false;
            if((v2.charAt(0) == '.') || (v2.charAt(v2.length()-1) == '.')) return false;

            inputs = versions;
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private Integer compareVersion(String version1, String version2){
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        try{
            while(i < v1.length || i < v2.length){
                if(i < v1.length && i < v2.length){
                    if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                        return -1;
                    }else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                        return 1;
                    }
                } else if(i < v1.length){
                    if(Integer.parseInt(v1[i]) != 0){
                        return 1;
                    }
                } else if(i < v2.length){
                    if(Integer.parseInt(v2[i]) != 0){
                        return -1;
                    }
                }
                i++;
            }
            return 0;
        }
        catch (RuntimeException e){
            return 0;
        }
    }

    @Override
    public Integer answer() {
        if(inputs == null || inputs.length == 0) return 0;
        Integer ans = compareVersion(inputs[0], inputs[1]);
        if(printLog) System.out.println("The result is " + ans);
        return ans;
    }

    @Override
    public String inputGuideline() {
        return """
                ========== Q2 ==========
                Input Pattern: 1.0.2,1.2.01
                Constraints:\s
                => - 1 <= version1.length, version2.length <= 500
                => - version1 and version2 only contain digits and '.'""";
    }

    @Override
    public void setPrintLog(boolean printLog) {
        this.printLog = printLog;
    }
}
