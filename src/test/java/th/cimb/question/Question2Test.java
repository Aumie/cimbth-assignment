package th.cimb.question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import th.cimb.question.impl.Question2;

class Question2Test {

    Question2 q;

    @BeforeEach
    void setUp() {
        q = new Question2();
    }

    @Test
    void case1() {
        Assertions.assertEquals(0, q.answer("1.01","1.001"));
    }

    @Test
    void case2() {
        Assertions.assertEquals(0, q.answer("1.0","1.0.0"));
    }

    @Test
    void case3() {
        Assertions.assertEquals(-1, q.answer("0.1","1.1"));
    }
}
