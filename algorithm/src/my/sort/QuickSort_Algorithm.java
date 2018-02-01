package my.sort;

public class QuickSort_Algorithm {

	
	public void quickSort(int[] arrary, int start, int end) {  
	    if(start >= end) return;         
	    int mid = partition(arrary, start, end);  	      
	    quickSort(arrary, start, mid-1); 
	    quickSort(arrary, mid+1, end); 
	    print(arrary);
	}
	public int partition(int[] arrary,int start,int end){
		int midvalue = arrary[start];
		while(start<end){
			while(arrary[end]>midvalue && end > start)
				end--;
			arrary[start] = arrary[end];
			while(arrary[start]<midvalue && end > start)
				start++;
			arrary[end] = arrary[start];
		}
		arrary[end] = midvalue;
		return end;
	}
	public static void print(int arr[]){
		for(int i = 0 ; i < arr.length ;i ++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arrary ={20,10,6,45,3,23,7,30,24,5};
		QuickSort_Algorithm quickSort = new QuickSort_Algorithm();
		quickSort.quickSort(arrary, 0, arrary.length-1);
		for(int i=0;i<arrary.length;i++)
			System.out.print(arrary[i]+" ");
	}

}
