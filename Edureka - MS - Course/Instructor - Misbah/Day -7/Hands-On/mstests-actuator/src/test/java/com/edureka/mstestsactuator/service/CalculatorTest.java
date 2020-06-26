package com.edureka.mstestsactuator.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Mock
    private MyClass myClassMock;
    @Mock
    private YourClass yourClassMock;

    @Test
    public void test_add_Solitary() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(myClassMock.process(ArgumentMatchers.anyInt())).thenReturn(5);
        Mockito.when(yourClassMock.process(ArgumentMatchers.anyInt())).thenReturn(6);

        final Calculator calculator = new Calculator(myClassMock, yourClassMock);

        final int actualResult = calculator.add(2, 3);

        assertEquals(11, actualResult);
    }


    @Test
    public void test_add_Sociable() {
        final MyClass myClass = new MyClass();
        final YourClass yourClass = new YourClass();

        final Calculator calculator = new Calculator(myClass, yourClass);

        final int actualResult = calculator.add(2, 3);

        assertEquals(10, actualResult);
    }

}