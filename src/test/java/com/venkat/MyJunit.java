package com.venkat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyJunit {

    @Test
    public void myTest(){
        String name = "Venkatram";
        assertNotNull(name);
    }
}
