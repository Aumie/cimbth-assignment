package th.cimb.question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import th.cimb.question.impl.Question2;

import java.util.Random;

class Question2Test {

    Question2 q;
    final String SALTCHARS = "1234567890";
    @BeforeEach
    void setUp() {
        q = new Question2();
    }

    @Test
    void case1() {
        q.setCaze("1.01,1.001");
        Assertions.assertEquals(0, q.answer());
    }

    @Test
    void case2() {
        q.setCaze("1.0,1.0.0");
        Assertions.assertEquals(0, q.answer());
    }

    @Test
    void case3() {
        q.setCaze("0.1,1.1");
        Assertions.assertEquals(-1, q.answer());
    }

    @Test
    void case4() {
        q.setCaze(".0.1,1.1");
        Assertions.assertEquals(0, q.answer());
    }

    @Test
    void case5() {
        q.setCaze("2.0,1.1");
        Assertions.assertEquals(1, q.answer());
    }

    @Test
    void case6() {
        q.setCaze("2.0.5,1.1.4,10");
        Assertions.assertEquals(0, q.answer());
    }

    @Test
    void caseTooLarge() {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 500) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        q.setCaze("2.0.5,"+salt);
        Assertions.assertEquals(0, q.answer());
    }

    @Test
    void case1Input() {
        q.setCaze(",2.0.5");
        Assertions.assertEquals(0, q.answer());
    }
}
