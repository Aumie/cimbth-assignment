package th.cimb.question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question3Test {

    Question3 q;

    @BeforeEach
    void setUp() {
        q = new Question3();
    }

    @Test
    void case1() {
        Assertions.assertEquals(2, q.answer(2));
    }

    @Test
    void case2() {
        Assertions.assertEquals(3, q.answer(3));
    }
}
