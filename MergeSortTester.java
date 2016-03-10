/*======================================
  class MergeSortTester

  ALGORITHM:
  This sorting algorithm takes an unsorted array and splits it in half creating two arrays. Then these arrays split until they are a single item array where they then return themselves to be merged with other arrays. Merging takes two sorted arrays and compares the values which will go into a final merged sorted array. So once a single item is returned to its parent, the parent will merge it with the sorted array it gets. Then each array will continually return itself to be merged until the final array is sorted.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(NlogN)

  Mean execution times for dataset of size n:
  Batch size: 1000
  n=1       time: .683 milliseconds 
  n=10      time: 21.961 milliseconds
  n=100     time: 52.005 milliseconds
  ...
  n=10000  time: 1687.305 milliseconds 

  ANALYSIS: The runtime seems to be in time of NlogN. From the execution time, it definitely is not running in linear time, or N^2 time. It is also not close to logarithmic runtime. From this we are able to conlude NlogN because the algorithm includes splitting up which is runtime of logN, then it remerges and merging runs in runtime of n. Therefore combining these two togeher, you get runtime of NlogN.
  
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * Generate an array of length 1000 to store the runtimes for 1000 trials.
     * For each of 1000 times, generate a random array of length n of ints from range 0 to 4999999.
     * Sort this array, and time the time in nanoseconds it takes.
     * Add this data to the data array.
     * Average the runtimes in the data array, and report the average in milliseconds.
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

	// print results, time in milliseconds
	System.out.println( "Average mergesort runtime for 1000 arrays of length " + n + ": \t" + ( mean(runtimes) / 1000 ) );

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
	return (double) sum / data.length;
    }
    

}//end class
