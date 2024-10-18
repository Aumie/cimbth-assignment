package th.cimb.util;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static <T> List<T> toList(T[] c){
        return Arrays.stream(c).toList();
    }
}
