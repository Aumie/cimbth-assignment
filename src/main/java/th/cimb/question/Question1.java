package th.cimb.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question1 {
    public static List<Integer> createCase(int[] c){
        return Arrays.stream(c).boxed().collect(Collectors.toList());
    }

    public Integer answer(List<Integer> prices) {
        return 0;
    }
}
