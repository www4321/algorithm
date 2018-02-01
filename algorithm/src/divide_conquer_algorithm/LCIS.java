package divide_conquer_algorithm;
//Î´Íê³É
public class LCIS {

	public static int LCISLength(int arr[],int start,int end){
		if (end == start)
			return 1;
		int mid = start + ( end - start ) / 2 ;
		
		
		return 0;
	}
	public static int midLength(int arr[],int mid){
		int i = mid, j = mid ;
		if(i==0){
			while(arr[j] < arr[j+1])
				j++;
			while( j < arr.length - 1 && arr[j + 1] < arr[j]){
				j++;
			}
		}else 
			if(i > 0 && arr[i - 1] < arr[i]){
				while(i > 0 && arr[i - 1] < arr[i]){
					i--;
				}
				while(j < arr.length - 1 && arr[j + 1] > arr[j]){
					j++;
				}
				while( j < arr.length - 1 && arr[j + 1] < arr[j]){
					j++;
				}
			}else{
				while(i > 0 && arr[i - 1] > arr[i]){
					i--;
				}
				while(i > 0 && arr[i - 1] < arr[i]){
					i--;
				}
				while( j < arr.length - 1 && arr[j + 1] < arr[j]){
					j++;
				}
		}
		return j - i + 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 5, 8, 2, 1, 9, 8};
		System.out.println(midLength(arr,0));

	}

}
