package divide_conquer_algorithm;

//分治算法实现二分搜索

public class Search {
	// 分治法实现二分查找
	public static int search(int arr[], int value, int start, int end){
		int mid = start + ( end - start ) / 2 ;
		if(end < start )
			return -1;
		if(arr[mid] == value)
			return mid;
		else if(arr[mid] > value)
			return search(arr,value,start,mid - 1);
		else return search(arr,value,mid + 1, end);
	}
	// 迭代法实现二分查找
	public static int search2(int arr[], int value){
		int start = 0, end = arr.length;
		while( end > start ){
			int mid = start + ( end - start ) / 2 ;
			if(arr[mid] > value)
				end = mid - 1;
			else if(arr[mid] < value)
				start = mid + 1;
			else return mid;
		}
		return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9} ;
		System.out.println(search(arr,3,0,arr.length));
		System.out.println(search(arr,0,0,arr.length));
		System.out.println(search(arr,9,0,arr.length));
		System.out.println("...............................");
		System.out.println(search2(arr,3));
		System.out.println(search2(arr,0));
		System.out.println(search2(arr,9));
	}

}
