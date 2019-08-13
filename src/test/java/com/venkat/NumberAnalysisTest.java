package com.venkat;

import com.venkat.service.NumberAnalysis;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberAnalysisTest {

    private NumberAnalysis numberAnalysis;

    @Before
    public void setup() {
        numberAnalysis = new NumberAnalysis();
    }

    @After
    public void tearDown() {
        numberAnalysis = null;
    }

    @Test
    public void testHundredThousands(){
        assertEquals(numberAnalysis.numberInWords(100009), "one hundred and thousand nine");
    }

    @Test
    public void testMillionThousands(){
        assertEquals(numberAnalysis.numberInWords(56945781), "fifty six million nine hundred and forty five thousand seven hundred and eighty one");
        //56945781 = fifty six million nine hundred and forty five thousand seven hundred and eighty one
    }

    @Test
    public void testZero(){
        assertEquals(numberAnalysis.numberInWords(0), "zero");
    }
}