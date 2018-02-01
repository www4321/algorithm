package introduction.to.algorithms;

public class Heap {
	
	public static void maxHeapify(int arr[], int length, int i){
		int exchange = 0;
		int left =  2*i+1;
		int right = 2*(i+1);
		int max = i;
		if(left < length && arr[left] > arr[i])
			max = left;
		if(right < length && arr[right] > arr[max])
			max = right;
		if(max != i ){
			exchange = arr[max];
			arr[max] = arr[i];
			arr[i] = exchange;
			maxHeapify(arr,length,max);
		}	
	}
	public static void buildMaxHeap(int arr[]){
		int length = arr.length;
		for(int i=(length-1)/2; i>=0 ;i--){
			maxHeapify(arr,length,i);
		}
	}
	public static void heapSort(int arr[]){
		int max = 0,length = arr.length;
		buildMaxHeap(arr);
		print(arr);
		for(int i=arr.length-1;i>0;i--){
			max = arr[0];
			arr[0] = arr[i];
			arr[i] = max;
			length--;
			maxHeapify(arr,length,0);
		}
	}
	
	
	public static void minHeapify(int arr[], int length, int i){
		int exchange = 0;
		int left =  2*i+1;
		int right = 2*(i+1);
		int max = i;
		if(left < length && arr[left] < arr[i])
			max = left;
		if(right < length && arr[right] < arr[max])
			max = right;
		if(max != i ){
			exchange = arr[max];
			arr[max] = arr[i];
			arr[i] = exchange;
			minHeapify(arr,length,max);
		}	
	}
	public static void buildMinHeap(int arr[]){
		int length = arr.length;
		for(int i=(length-1)/2; i>=0 ;i--){
			minHeapify(arr,length,i);
		}
	}
	
	public static int[] topKHeap(int arr[],int k){
		int[] topk = new int[k];   
		for(int i = 0;i< k;i++){  
		    topk[i] = arr[i];  
		} 
		buildMinHeap(topk);
		for(int i=k;i<arr.length;i++){
			if(arr[i]>topk[0]){
				topk[0] = arr[i];
				minHeapify(topk,k,0);
			}
		}
		return topk;
	}
	
	
	
	public static int heapMaxIMum(int[] a){
		return a[0];
	}
	public static int heapExtractMax(int[] a,int k){
		int max = a[0];
		a[0] = a[k];
		maxHeapify(a,k,0);
		return max;
	}
	
	
	public static void print(int arr[]){
		for(int a : arr){
			System.out.print(a+" ");
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {4,1,3,2,16,9,10,14,8,7};
		//buildMaxHeap(arr);
//		heapSort(arr);
//		print(arr);
		buildMinHeap(arr);
		print(arr);
		print(topKHeap(arr,7));

	}

}
