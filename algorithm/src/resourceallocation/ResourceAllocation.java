package resourceallocation;

public class ResourceAllocation {

	/*          A       B      C
	 *    0     0      0       0
	 *    1     15     13      11
 	 *    2     28     29      30
	 *    3     40     43      45
	 *    4     51     55      58
	 * 
	 */
	
	
	
	
	public static void resourceAllocation(int arr[][]){
		int result[][] = new int[arr[0].length][arr.length];
		int road[][] = new int[arr[0].length][arr.length];
		for(int i=0; i<arr[0].length; i++){
			for( int j=0; j< arr.length; j++){
				if(i == 0)
					result[i][j] = arr[j][0];
				else{
					result[i][j] = 0;
					road[i][j] = 0;
					for(int k=0; k<=j; k++){
						if(result[i][j]<result[i-1][k]+arr[j-k][i]){
							result[i][j] = result[i-1][k]+arr[j-k][i];
							//road[i][j] = j-k;
						}
						//result[i][j] = Math.max(result[i][j], result[i-1][k]+arr[j-k][i]);
					}
				}
				
			}
		}
		print(result);
		System.out.println(".................................................");
		print(road);
	}
	public static void print(int arr[][]){
		for(int i = 0 ; i < arr.length ;i ++){
			for(int j=0; j< arr[0].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println("\n");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[][]={{0,0,0},{15,13,11},{28,29,30},{40,43,45},{51,55,58}};
		print(arr);
		System.out.println(".................................................");
		resourceAllocation(arr);
	}

}
