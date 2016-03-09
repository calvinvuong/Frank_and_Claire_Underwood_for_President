// Calvin Vuong
// APCS2 pd10
// HW09 -- Mergers and Acquisitions
// 2016-03-04

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  1. If you have a one element array, return that element.
  2. If you have more than one element, split the unsorted array into halves until each subarray has only one element.
  3. Recursively merge the subarrays from the same immediate parent, going up the split tree.
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) {
	int[] retInt = new int[a.length + b.length];
	// position of "top card" in arrays a and b
	int aPos = 0;
	int bPos = 0;

	for ( int i = 0; i < retInt.length; i++ ){ 
	    // if one array no more elements, use the other
	    if ( aPos >= a.length ){
		retInt[i] = b[bPos];
		bPos += 1;
	    }
	    else if ( bPos >= b.length ){
		retInt[i] = a[aPos];
		aPos += 1;
	    }

	    // put "top card" of array a in sorted array in no more cards in b or top a less than top b
	    else if ( a[aPos] <= b[bPos] ){
		retInt[i] = a[aPos];
		aPos += 1;
	    }
	    // put "top card" of array b in sorted array in no more cards in a or top b less than top a
	    else if ( b[bPos] < a[aPos] ){
		retInt[i] = b[bPos];
		bPos += 1;
	    }
	}
	return retInt;
	
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) {
	if ( arr.length == 1 ) //base case
	    return arr;
	
	// split arr
	int[] half1 = new int[arr.length / 2];
	int[] half2 = new int[arr.length - half1.length];
	for ( int i = 0; i < arr.length; i++ ){
	    if ( i < half1.length )
		half1[i] = arr[i];
	    else
		half2[i - half1.length] = arr[i];
	}

	// recrusively call sort() on the halves
	int[] half1R = sort(half1);
	int[] half2R = sort(half2);

	// merge the both halves
	return merge( half1R, half2R );

    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }
    
    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------
    

    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};
	int[] arr8 = {2,4,5,6,9,12};
	int[] arr9 = {1,2,3,7,8,9,11};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr0,arr1) );

	System.out.println("\nMerging arr8 and arr9: ");
	printArray( merge(arr8,arr9) );


	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
