package th.cimb.question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import th.cimb.question.impl.Question3;

class Question3Test {

    Question3 q;

    @BeforeEach
    void setUp() {
        q = new Question3();
    }

    @Test
    void case1() {
        q.setCaze(2);
        Assertions.assertEquals(2, q.answer());
    }

    @Test
    void case2() {
        q.setCaze(3);
        Assertions.assertEquals(3, q.answer());
    }

    @Test
    void case3() {
        q.setCaze(4);
        Assertions.assertEquals(5, q.answer());
    }

    @Test
    void caseZero() {
        q.setCaze(0);
        Assertions.assertEquals(0, q.answer());
    }

    @Test
    void caseNegative() {
        q.setCaze(-1);
        Assertions.assertEquals(0, q.answer());
    }
}
