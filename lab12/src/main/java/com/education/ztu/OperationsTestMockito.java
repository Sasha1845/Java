package com.education.ztu;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import Classes.OperationsForMock;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OperationsTestMockito {

    @Mock
    private OperationsForMock operations;

    @Captor
    private ArgumentCaptor<Double> captor;

    @Test
    public void testAddition() {
        when(operations.addition(2.0, 3.0)).thenReturn(5.0);
        double result = operations.addition(2.0, 3.0);
        assertEquals(5.0, result, 0.001);
        verify(operations, times(1)).addition(2.0, 3.0);
    }

    @Test
    public void testSubtraction() {
        when(operations.subtraction(5.0, 3.0)).thenReturn(2.0);
        double result = operations.subtraction(5.0, 3.0);
        assertEquals(2.0, result, 0.001);
        verify(operations, times(1)).subtraction(5.0, 3.0);
    }

    @Test
    public void testMultiplication() {
        when(operations.multiplication(2.0, 3.0)).thenReturn(6.0);
        double result = operations.multiplication(2.0, 3.0);
        assertEquals(6.0, result, 0.001);
        verify(operations, times(1)).multiplication(2.0, 3.0);
    }

    @Test
    public void testDivision() {
        when(operations.division(6.0, 2.0)).thenReturn(3.0);
        double result = operations.division(6.0, 2.0);
        assertEquals(3.0, result, 0.001);
        verify(operations, times(1)).division(6.0, 2.0);
    }

    @Test
    public void testCaptor() {
        when(operations.addition(anyDouble(), anyDouble())).thenReturn(5.0);
        operations.addition(2.0, 3.0);
        verify(operations).addition(captor.capture(), captor.capture());
        assertEquals(Double.valueOf(2.0), captor.getAllValues().get(0));
        assertEquals(Double.valueOf(3.0), captor.getAllValues().get(1));
    }
}
