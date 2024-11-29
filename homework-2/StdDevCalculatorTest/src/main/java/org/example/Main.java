package org.example;

public class Main {
    public static void main(String[] args) {
        double[] sampleValuesList = new double[]{9, 6, 8, 5, 7};
        double sampleStdDev = Calculator.COMPUTE_SAMPLE_STANDARD_DEVIATION(sampleValuesList);
        System.out.println("Sample StdDev= " + sampleStdDev);

        double[] populationValuesList = new double[]
                {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
        double popStdDev = Calculator.COMPUTE_POPULATION_STANDARD_DEVIATION(populationValuesList);
        System.out.println("Population StdDev= " + popStdDev);

    }
}