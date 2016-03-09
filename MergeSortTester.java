/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: 1000
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
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

	

    }//end main

    // returns an array of ints of size n, randomly populated with ints from range 0 to 4999999
    public static int[] populate(int n){
	int[] retInt = new int[n];
	for ( int i = 0; i < retInt.length; i++ ){
	    retInt[i] = (int) ( Math.random() * 5000000 );
	}
	return retInt;
    }

    

}//end class
