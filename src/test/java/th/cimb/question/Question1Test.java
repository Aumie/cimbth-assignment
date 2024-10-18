package th.cimb.question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import th.cimb.question.impl.Question1;

import java.util.Random;
import java.util.stream.IntStream;

class Question1Test {

    Question1 q;

    @BeforeEach
    void setUp() {
        q = new Question1();
    }

    @Test
    void case1() {
        Integer[] c = {7,1,5,3,6,4};
        q.setCaze(c);
        Assertions.assertEquals(5, q.answer());
    }

    @Test
    void case2() {
        Integer[] c = {7,6,4,3,1};
        q.setCaze(c);
        Assertions.assertEquals(0, q.answer());
    }

    @Test
    void case3() {
        Integer[] c = {4,4,1,4,5,1,2};
        q.setCaze(c);
        Assertions.assertEquals(4, q.answer());
    }

    @Test
    void case4() {
        Integer[] c = {40,4,1,4,2,1,1,50};
        q.setCaze(c);
        Assertions.assertEquals(49, q.answer());
    }

    @Test
    void case5() {
        Integer[] c = {6,4,4,25,4,4,0};
        q.setCaze(c);
        Assertions.assertEquals(21, q.answer());
    }

    @Test
    void caseMaxValue10000() {
        Integer[] c = {1,10000};
        q.setCaze(c);
        Assertions.assertEquals(9999, q.answer());
    }

    @Test
    void caseMaxValue100001() {
        q.setCaze(IntStream.generate(() -> 100001).limit(10).toArray());
        Assertions.assertEquals(0, q.answer());
    }

    @Test
    void caseMaxSize100001() {
        q.setCaze(IntStream.generate(() -> new Random().nextInt(10)).limit(100001).toArray());
        Assertions.assertEquals(0, q.answer());
    }
}
