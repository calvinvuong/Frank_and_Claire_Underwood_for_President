// Team Frank and Claire Underwood for President -- James Hua and Calvin Vuong
// APCS2 pd10
// HW11 -- Wrapping it Up
// 2016-03-09

/*======================================
  class MergeSortTester

  ALGORITHM:
  1. If you have a one element array, return the array.
  2. If you have more than one element, split the unsorted array into halves until each subarray is a single item long.
  3. Recursively merge the subarrays from the same immediate parent, going up the split tree, until there is only one array left.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(NlogN)

  Mean execution times for dataset of size n:
  Batch size: 1000
  n=1         time: 0.41 microseconds 
  n=10        time: 21.45 microseconds  
  n=100       time: 48.15 microseconds 
  n=1000      time: 176.49 microseconds 
  n=10000     time: 1339.51 microseconds 
  n=100000    time: 15367.96 microseconds 
  n=1000000   time: 179021.14 microseconds 

 
  ANALYSIS: The runtime seems to be in time of NlogN. 
  From the execution time, it definitely is not running in linear time, or N^2 time. 
  In the beginning it may seem to have a random runtime, but that is because the size of the array is small. However, as the size gets larger and larger, the data set follows NlogN. 
  For example, if we look only at n=100000 and n=1000000, the ratio between 100000log(100000) and 1000000log(1000000) is the same as the ratio between the times for those n values.
  We are able to conclude NlogN also because the algorithm includes splitting up and merging, which has a runtime of logN, and merging which has a  runtime of n. 
  Therefore combining these two together, you get runtime of NlogN.
  With these two observations, we are certain that runtime of MergeSort is NlogN.
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * Generate an array of length 1000 to store the runtimes for 1000 trials.
     * For each of 1000 times, generate a random array of length n of ints from range 0 to 4999999.
     * Sort this array, and time the time in nanoseconds it takes.
     * Add this data to the data array.
     * Average the runtimes in the data array, and report the average in microseconds.
     ******************************/
    public static void main( String[] args ) {
	
	int n; // data size
	// ask user for data size
	try {
	    n = Integer.parseInt( args[0] );
	}
	catch (Exception e){
	    n = 10; // default
	    System.out.println("Invalid input.");
	}

	long[] runtimes = new long[1000]; // stores runtimes of multiple runs
	for ( int i = 0; i < runtimes.length; i++ ){
	    int[] arr = populate(n); // randomly unsorted array
	    
	    long start = System.nanoTime(); //start timer
	    MergeSort.sort( arr );
	    long end = System.nanoTime(); //end timer

	    runtimes[i] = end - start;
	}

	// print results, time in microseconds
	System.out.println( "Average mergesort runtime for 1000 arrays of length " + n + ": \t" + ( mean(runtimes) / 1000.0 ) + " microseconds");

    }//end main

    // returns an array of ints of size n, randomly populated with ints from range 0 to 4999999
    public static int[] populate(int n){
	int[] retInt = new int[n];
	for ( int i = 0; i < retInt.length; i++ ){
	    retInt[i] = (int) ( Math.random() * 5000000 );
	}
	return retInt;
    }

    // returns the average of an array of longs as a double
    public static double mean(long[] data){
	double sum = 0.0;
	for ( int i = 0; i < data.length; i++ ){
	    sum += data[i];
	}
	return sum / data.length;
    }
    

}//end class
