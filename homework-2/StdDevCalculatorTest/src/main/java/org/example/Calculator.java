package org.example;

public class Calculator {
    //Function to compute the mean (average) of a list of values
    public static double COMPUTE_MEAN(double[] valuesList) throws emptyException {
        double sumAccumulator = 0;
        int i = 0;
        if (valuesList.length == 0) {
            throw new emptyException("valuesList parameter cannot be null or empty");
        }
        for (i = 0; i < valuesList.length; i++) {
            sumAccumulator += valuesList[i];
        }
        return sumAccumulator / valuesList.length;
    }

    //Function to compute the sum of squared differences from the mean
    public static double Compute_SQUARE_OF_DIFFERENCES(double[] valuesList, double mean) throws emptyException {
        double squareAccumulator = 0;
        int i = 0;
        if (valuesList.length == 0) { //!!!!!
            throw new emptyException("valuesList parameter cannot be null or empty");
        }
        for (i =0; i < valuesList.length; i++){
            double difference = valuesList[i] - mean;
            double squareOfDifference = difference * difference;
            squareAccumulator = squareOfDifference + squareAccumulator;
        }
        return squareAccumulator;
    }

    /*
    Function to compute the variance based on squared differences
    Set isPopulation to true to compute a population standard deviation in COMPUTE_VARIANCE
    Set isPopulation to false to compute a sample standard deviation in COMPUTE_VARIANCE
     */

    //Adjust number of values by minus one if sample where sample is indicated by (not isPopulation)
    public static double COMPUTE_VARIANCE(double squareOfDifferences, double numValues, boolean isPopulation) throws minimumException{
        if (!isPopulation){
            numValues = numValues - 1;
        }
        /*
        Test numValues after adjusting for change to numValues
        We cannot allow numValues to be a 0 denominator (division by zero / undefined)
        */
        if (numValues < 1){
            throw new minimumException("numValues is too low (sample size must be >= 2, population size must be >= 1)");
        }
        return squareOfDifferences / numValues;
    }

    //Function to compute the population or sample standard deviation from a list of values
    public static double COMPUTE_STANDARD_DEVIATION(double[] valuesList, boolean isPopulation) throws emptyException, minimumException {
        if (valuesList.length == 0){
            throw new emptyException("valuesList parameter cannot be null or empty");
        }

        int i = 0;
        double mean = COMPUTE_MEAN(valuesList);
        double squareOfDifferences = Compute_SQUARE_OF_DIFFERENCES(valuesList,mean);

        double variance = COMPUTE_VARIANCE(squareOfDifferences,valuesList.length,isPopulation);

        return Math.sqrt(variance);
    }

    //Function to compute the sample standard deviation from a list of values
    public static double COMPUTE_SAMPLE_STANDARD_DEVIATION(double[] valuesList) {
        try {
            return COMPUTE_STANDARD_DEVIATION(valuesList, false);
        } catch (emptyException | minimumException e) {
            throw new RuntimeException(e);

        }
    }
    //Function to compute the population standard deviation from a list of values
    public static double COMPUTE_POPULATION_STANDARD_DEVIATION(double[] valuesList){
        try {
            return COMPUTE_STANDARD_DEVIATION(valuesList, true);
        } catch (emptyException | minimumException e) {
            throw new RuntimeException(e);
        }
    }
}
