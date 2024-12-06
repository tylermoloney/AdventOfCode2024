package Day2;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Day2 {

    public int run() throws FileNotFoundException {

        Scanner scanner;
        int safeCounter = 0;
        int lineCounter = 0;
        scanner = new Scanner(new File("Day2/input.txt"));
        while (scanner.hasNextLine()) {
            lineCounter++;
            String[] line = (scanner.nextLine().split(" "));
            // Make the string array an int array
            int[] intArray = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                intArray[i] = Integer.parseInt(line[i]);
            }

            boolean positiveLoop = intArray[0] < intArray[1];
            boolean negativeLoop = intArray[0] > intArray[1];
            int firstDiff = intArray[0] - intArray[1];
            if (firstDiff > 3 || firstDiff < -3) {
                System.out.println("First diff is too big: " + firstDiff);
                continue;
            }
            if (lineCounter == 393){
                System.out.println("Line 393");
            }
            // differences are negative
            if (negativeLoop) {
                // System.out.println("First diff is negative, decreasing line");
                int errorCounter = 0;
                negativeLoop: for (int i = 1; i < intArray.length; i++) {
                    if(errorCounter > 0){
                        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(
                            Arrays.stream(intArray).boxed().toArray(Integer[]::new)
                        ));
                        intList.remove(i); 
                        for (int j = 1; j < intArray.length-1; j++){
                            // Make an ArrayList of intArray and remove the element at index i
                            int diff = intList.get(j-1) - intList.get(j);

                            // Diff cannot be greater than 3
                            if (diff > 3) {
                                System.out.println("Diff is too big: " + diff);
                                errorCounter++;
        
                            }
                            if (diff < 0) {
                                System.out.println("Diff is positive: " + diff);
                                errorCounter++;
                            }
                            if (diff == 0) {
                                System.out.println("Diff is 0: " + diff);
                                errorCounter++;
                            }
                            
                            if (errorCounter > 1) {
                                break negativeLoop;
                            }
        
                        }
                    }
                    
                    int diff = intArray[i - 1] - intArray[i];
                    // Diff cannot be greater than 3
                    if (diff > 3) {
                        System.out.println("Diff is too big: " + diff);
                        errorCounter++;

                    }
                    if (diff < 0) {
                        System.out.println("Diff is positive: " + diff);
                        errorCounter++;
                    }
                    if (diff == 0) {
                        System.out.println("Diff is 0: " + diff);
                        errorCounter++;
                    }

                    // If we are at the end of the array, we have a safe line
                    if (i == intArray.length - 1) {
                        if (errorCounter < 2)
                        if (errorCounter > 0){
                            System.out.println("error count is " + errorCounter + " incrementing safeCount on line " + lineCounter);
                        }
                            safeCounter++;
                    }

                }

            } else if (positiveLoop) {
                int errorCounter = 0;
                // System.out.println("First diff is negative, increasing line");
                positiveLoop: for (int i = 1; i < intArray.length; i++) {
                    if(errorCounter > 0){
                        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(
                            Arrays.stream(intArray).boxed().toArray(Integer[]::new)
                        ));
                        intList.remove(i); 
                        for (int j = 1; j < intArray.length-1; j++){
                            // Make an ArrayList of intArray and remove the element at index i
                            int diff = intList.get(j-1) - intList.get(j);

                            // Diff cannot be greater than 3
                            if (diff < -3) {
                                System.out.println("Diff is too big: " + diff);
                                errorCounter++;
                            }
                            if (diff == 0) {
                                System.out.println("Diff is zero: " + diff);
                                errorCounter++;
                            }
                            // Diff cannot be positive
                            if (diff > 0) {
                                System.out.println("Diff is negative: " + diff);
                                errorCounter++;
                            }
        
                            
                            if (errorCounter > 1) {
                                break positiveLoop;
                            }
        
                        }
                    }
                    int diff = intArray[i - 1] - intArray[i];
                    // Diff cannot be less than -3
                    if (diff < -3) {
                        System.out.println("Diff is too big: " + diff);
                        errorCounter++;
                    }
                    if (diff == 0) {
                        System.out.println("Diff is zero: " + diff);
                        errorCounter++;
                    }
                    // Diff cannot be positive
                    if (diff > 0) {
                        System.out.println("Diff is negative: " + diff);
                        errorCounter++;
                    }

                    // If we are at the end of the array, we have a safe line
                    if (i == intArray.length - 1) {
                        if (errorCounter < 2) {
                            if (errorCounter > 0){
                                    System.out.println("error count is " + errorCounter + " incrementing safeCount on line " + lineCounter);
                            }
                            safeCounter++;
                        }
                    }

                }

            }
        }
            scanner.close();
            
        return safeCounter;
    }
}
