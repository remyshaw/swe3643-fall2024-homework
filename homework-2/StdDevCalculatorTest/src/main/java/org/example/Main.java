package org.example;

public class Main {
    public static void main(String[] args) {
        int[] sampleValuesList = new int[]{9, 6, 8, 5, 7};
        double sampleStdDev = COMPUTE_SAMPLE_STANDARD_DEVIATION(sampleValuesList);
        System.out.println("Sample StdDev= " + sampleStdDev);

        int[] populationValuesList = new int[]
                {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};
        int popStdDev = COMPUTE_POPULATION_STANDARD_DEVIATION(populationValuesList);
        System.out.println("Population StdDev= " + popStdDev);

    }

    //Function to compute the mean (average) of a list of values
    public static int COMPUTE_MEAN(int[] valuesList) throws emptyException {
        int sumAccumulator = 0;
        int i = 0;
        if (valuesList[i] == 0) { // for every instance of this check, fix. Checks if current element (Element 0 since i = 0) equals 0, which is incorrect. we want to check if total elements are equal to 0.
            throw new emptyException("valuesList parameter cannot be null or empty");
        }
        for (i = 0; i < valuesList[i]; i++) {
            sumAccumulator = sumAccumulator + i;
        }
        return sumAccumulator / valuesList[i]; /* <- divides by current element of valuesList,
        not total number of elements in array, fix later. */
    }

    //Function to compute the sum of squared differences from the mean
    public static int Compute_SQUARE_OF_DIFFERENCES(int[] valuesList, int mean) throws emptyException {
        int squareAccumulator = 0;
        int i = 0;
        if (valuesList[i] == 0) { //!!!!!
            throw new emptyException("valuesList parameter cannot be null or empty");
        }
        for (i =0; i < valuesList[i]; i++){ //fix for loop to compute results for each element in array
            int difference = i - mean;
            int squareOfDifference = difference * difference;
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
    public static int COMPUTE_VARIANCE(int squareOfDifferences, int numValues, boolean isPopulation) throws minimumException{
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
    public static int COMPUTE_STANDARD_DEVIATION(int[] valuesList, boolean isPopulation) throws emptyException, minimumException {
        int i = 0;
        int mean = COMPUTE_MEAN(valuesList);
        int squareOfDifferences = Compute_SQUARE_OF_DIFFERENCES(valuesList,mean);

        int variance = COMPUTE_VARIANCE(squareOfDifferences,valuesList[i],isPopulation); //not current element in valuesList, total number of elements in valuesList

        if (valuesList[i] == 0){ //!!!!!
            throw new emptyException("valuesList parameter cannot be null or empty");
        }
        return (int) Math.sqrt(variance);
    }

    //Function to compute the sample standard deviation from a list of values
    public static int COMPUTE_SAMPLE_STANDARD_DEVIATION(int[] valuesList) {
        try {
            return COMPUTE_STANDARD_DEVIATION(valuesList, false);
        } catch (emptyException | minimumException e) {
            throw new RuntimeException(e);

        }
    }
        //Function to compute the population standard deviation from a list of values
        public static int COMPUTE_POPULATION_STANDARD_DEVIATION(int[] valuesList){
            try {
                return COMPUTE_STANDARD_DEVIATION(valuesList, true);
            } catch (emptyException | minimumException e) {
                throw new RuntimeException(e);
            }
        }
}