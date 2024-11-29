package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("")
    void COMPUTE_MEAN() throws emptyException {
        assertAll(assertEquals(1.5811388300841898, Calculator.COMPUTE_MEAN(new double[]{9, 6, 8, 5, 7})),
        // figure out how to test for empty arrays
        ArithmeticException emptyException = assertThrows(emptyException, Calculator.COMPUTE_MEAN(new double[0])));
    }

    @Test
    @DisplayName("")
    void compute_SQUARE_OF_DIFFERENCES() {
    }

    @Test
    @DisplayName("")
    void COMPUTE_VARIANCE() {
    }

    @Test
    @DisplayName("")
    void COMPUTE_STANDARD_DEVIATION() {
    }

    @Test
    @DisplayName("")
    void COMPUTE_SAMPLE_STANDARD_DEVIATION() {
    }

    @Test
    @DisplayName("")
    void COMPUTE_POPULATION_STANDARD_DEVIATION() {
    }
}