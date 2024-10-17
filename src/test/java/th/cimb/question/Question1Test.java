package th.cimb.question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Question1Test {

    Question1 q;

    @BeforeEach
    void setUp() {
        q = new Question1();
    }

    @Test
    void case1() {
        int[] c = {7,1,5,3,6,4};
        List<Integer> ca = Question1.createCase(c);
        Assertions.assertEquals(5, q.answer(ca));
    }

    @Test
    void case2() {
        int[] c = {7,6,4,3,1};
        List<Integer> ca = Question1.createCase(c);
        Assertions.assertEquals(0, q.answer(ca));
    }
}
