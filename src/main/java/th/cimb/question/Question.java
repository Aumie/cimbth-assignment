package th.cimb.question;

public interface Question {
    boolean setCaze(Object caze);
    Integer answer();
    String inputGuideline();
    void setPrintLog(boolean printLog);
}
