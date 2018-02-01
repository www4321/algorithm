package my.sort;

public class HeapSort_Algorithm {

	public static void initMaxHeap(int[] arr){
		for(int i = arr.length / 2 -1 ; i >=0  ; i--){
			maxHeapAdjust(arr,i,arr.length);
		}
	
	}
	public static  void maxHeapAdjust(int []arr, int i,int n){
		int j=2*i+1,tmp = arr[i];
		while(j<n){
			if((j+1< n) && arr[j+1]>arr[j])
				j=j+1;
			if(arr[j]<tmp)
				break;
			arr[i] = arr[j];
			i = j;
			j = 2*j+1;
			
		}
		arr[i] = tmp ;	
	}
	public static void heapSort(int []arr){
		initMaxHeap(arr);
		int tmp = arr[0];
		for(int i=0;i<arr.length;i++){
			arr[0] = arr[arr.length-i-1];
			arr[arr.length-i-1] = tmp;
			maxHeapAdjust(arr,0,arr.length-i-1);
			tmp = arr[0];
			print(arr);
		}
	}
	public static void print(int arr[]){
		for(int i = 0 ; i < arr.length ;i ++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 5, 2, 6, 9, 7, 8, 0 };
		heapSort(arr);

	}

}
