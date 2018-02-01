package my.search;

public class BinarySearch_Algorithm {
	//二分查找 O(logn)
	public static int binarySearch(int []arr, int a){
		int low = 0,high = arr.length - 1;
		int mid = 0;
		while(low<=high){
			mid = low + (high-low)/2;
			if(arr[mid]>a)
				high = mid - 1;		
			if(arr[mid]<a)
				low = mid + 1;
			if(arr[mid]==a)
				return mid;
		}
		return -1;
	}
	//查找第一个与key值相等的元素下表
	public static int binarySearchFirstEqual(int []arr, int a){
		int low = 0,high = arr.length - 1;
		int mid = 0;
		while(low<=high){
			mid = low + (high-low)/2;
			if(arr[mid]>=a)
				high = mid - 1;		
			if(arr[mid]<a)
				low = mid + 1;
		}
		if(arr[low]==a && low<arr.length)
			return low;
		return -1;
	}
	//查找最后一个与key值相等的元素下表
	public static int binarySearchLasttEqual(int []arr, int a){
		int low = 0,high = arr.length - 1;
		int mid = 0;
		while(low<=high){
			mid = low + (high-low)/2;
			if(arr[mid]>a)
				high = mid - 1;		
			if(arr[mid]<=a)
				low = mid + 1;
		}
		if(arr[high]==a && high<arr.length)
			return high;
		return -1;
	}
	//查找第一个大于key的元素
	public static int binarySearchFirstLarger(int []arr, int a){
		int low = 0,high = arr.length - 1;
		int mid = 0;
		while(low<=high){
			mid = low + (high-low)/2;
			if(arr[mid]>a)
				high = mid - 1;		
			if(arr[mid]<=a)
				low = mid + 1;
		}
		return low;
	}
	//查找最后一个小于key的元素
	public static int binarySearchLastSmall(int []arr, int a){
		int low = 0,high = arr.length - 1;
		int mid = 0;
		while(low<=high){
			mid = low + (high-low)/2;
			if(arr[mid]>=a)
				high = mid - 1;		
			if(arr[mid]<a)
				low = mid + 1;
		}
		return high;
	}
	//查找最后一个小于等于key的元素
	public static int binarySearchLastSmEq(int []arr, int a){
		int low = 0,high = arr.length - 1;
		int mid = 0;
		while(low<=high){
			mid = low + (high-low)/2;
			if(arr[mid]>a)
				high = mid - 1;		
			if(arr[mid]<=a)
				low = mid + 1;
		}
		return high;
	}
	public static void main(String[] args) {
//		int arr[] = {0,1,2,3,4,5,6,7,8,9};
//		int a = binarySearch(arr,9);
		
		int arr[] = {0,1,2,3,4,4,5,6,7,8,9};
		int a = binarySearchLastSmEq(arr,4);
		System.out.println(a);

	}

}
