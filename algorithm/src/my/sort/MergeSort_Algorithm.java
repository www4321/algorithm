package my.sort;

public class MergeSort_Algorithm {

	public static void print(int arr[]){
		for(int i = 0 ; i < arr.length ;i ++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
	public static void mergeSort(int arr[],int low,int high){
		if(low<high){
			int mid = low + (high-low)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
			
		}
	}
	public static void merge(int arr[],int low,int mid,int high){
		int arrary[] = new int[high-low+1];
		int i =low,j =mid+1,k=0;
		while(i<=mid && j<=high){
			if(arr[i]<arr[j]){
				arrary[k++] = arr[i++];
			}else arrary[k++] = arr[j++];
		}
		while(j<=high) 
			arrary[k++] = arr[j++];
		while(i<=mid) 
			arrary[k++] = arr[i++];
		for(int m=low;m<high+1;m++)
			arr[m] = arrary[m-low];
		
	}
	public static void main(String[] args) {
		int arr[] = { 9, 1, 5, 3, 4, 2, 6, 8, 7};
		mergeSort(arr,0,8);
		print(arr);

	}

}
