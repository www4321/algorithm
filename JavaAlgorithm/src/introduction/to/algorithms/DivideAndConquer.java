package introduction.to.algorithms;

/**
 * @author www1234
 * 分治算法
 */
public class DivideAndConquer {
	
    //1. 动态规划求最大的连续子数组的和
	public static int findMaxSubArray(int[] arr){
		int max = 0, maxlevel=0;
		for(int i=0; i<arr.length; i++){
			maxlevel += arr[i];
			if(maxlevel<0)
				maxlevel = 0;
			max = Math.max(max, maxlevel);
		}
		return max;
	}
	//1. 分治算法求最大的连续子数组的和
	public static int[] findMaxSubArray(int[] arr, int start, int end){
		int mid = start + (end - start) / 2;
		if(start == end){
			int result[] = {start,end,arr[start]};
			return result;
		}else{
			int[] left_max = findMaxSubArray(arr, start, mid);
			int[] right_max = findMaxSubArray(arr, mid+1, end);
			int[] mid_max = findCrossMidSubArray(arr,start,end);
			if(left_max[2] > right_max[2] && left_max[2] > mid_max[2])
				return left_max;
			else if(right_max[2] > left_max[2] && right_max[2] > mid_max[2])
				return right_max;
			else return mid_max;
		}
	}
	
	public static int[] findCrossMidSubArray(int[] arr, int start, int end){
		int sum = 0,right_max = Integer.MIN_VALUE, left_max= Integer.MIN_VALUE, left = 0, right = 0;
		int mid = start + (end - start) / 2;
		for(int i = mid; i>start;i--){
			sum += arr[i];
			if(sum > left_max){
				left_max = sum;
				left = i;
			}
		}
		sum = 0;
		for(int i = mid+1; i < end;i++){
			sum += arr[i];
			if(sum > right_max){
				right_max = sum;
				right = i;
			}
		}
		// 防止两个负数相加的溢出问题
		if(left_max==Integer.MIN_VALUE || right_max==Integer.MIN_VALUE){
			int result[] = {left,right,Integer.MIN_VALUE};
			return result;
		}
		else {
			int result[] = {left,right,left_max+right_max};
			return result;
		}
	}
	
	//2. 分治算法实现Strassen矩阵乘法
	
	public static int[][] StrassenMatrix(int[][] matrix1, int[][] matrix2){
		
		
		return null;
	}
	//3. 动态规划实现最大的先升后降子序列
	public static int[] convexSubArrary(int[] arr){
		int max[] = new int[arr.length];
		boolean flag = false;
		for(int i=0; i<arr.length; i++){
			int copy = arr[i];
			flag = false;
			int j = 0;
			for(j=i+1;j<arr.length;j++){
				if(flag == false && copy > arr[j])
					flag = true;
				if(flag && copy < arr[j]){
					break;
				}
				copy = arr[j];
			}
			max[i] = j-i;
		}
		return max;
	}
	//3. 分治算法实现最大的先升后降子序列
	public static int[] convexSubArrary(int[] arr,int start, int end){
		
		
		return null;
	}
	public static int[] convexCrossSubArrary(int[] arr,int start, int end){
		int mid = start + (end - start) / 2;
		int sum = 0,right_max = Integer.MIN_VALUE, left_max= Integer.MIN_VALUE, left = 0, right = 0;
		boolean flag = false, subflag = false;
		if(mid > start && arr[mid]>arr[start])
			flag = true;
		for(int i = mid; i>start;i--){
			
		}
		sum = 0;
		for(int i = mid+1; i < end;i++){
			sum += arr[i];
			if(sum > right_max){
				right_max = sum;
				right = i;
			}
		}
		
		return null;
	}
	
	// 分治算法实现大整数乘法
	public static int multiply(String x, String y){
		int n1 = x.length(), n2 = y.length();
		String a = (String) x.subSequence(0, n1/2-1);
		String b = (String) x.subSequence(n1/2, n1-1);
		String c = (String) y.subSequence(0, n2/2-1);
		String d = (String) y.subSequence(n2/2, n2-1);
		
//		int a = x / Math.pow(10, n1/2);
//		int b = x % 10;
//		int c = y / 10;
//		int d = y % 10;
		
		
		return 0;
	}
	
	
	// 分治算法实现棋盘覆盖
	public static void checkerboardCover(int[][] broad,int xstart,int ystart,int x,int y,int size){
		if(size == 1)
			return ;
		int k = size/2;
		if(x < xstart+ k && y < ystart + k){ // 左上角
			checkerboardCover(broad,xstart,ystart,x,y,k);
			broad[xstart+k-1][ystart+k] = 4;broad[xstart+k][ystart+k] = 4;broad[xstart+k][ystart+k-1] = 4;
			//右上角
			checkerboardCover(broad,xstart,ystart+k,xstart+k-1,ystart+k,k);
			//右下角
			checkerboardCover(broad,xstart+k,ystart+k,xstart+k,ystart+k,k);
			//左下角
			checkerboardCover(broad,xstart+k,ystart,xstart+k,ystart+k-1,k);
		}
		else if(x < xstart+ k && y >= ystart + k){ // 右上角
			checkerboardCover(broad,xstart,ystart+k,x,y,k);
			broad[xstart+k-1][ystart+k-1] = 3;broad[xstart+k][ystart+k] = 3;broad[xstart+k][ystart+k-1] = 3;
			//左上角
			checkerboardCover(broad,xstart,ystart,xstart+k-1,ystart+k-1,k);
			//右下角
			checkerboardCover(broad,xstart+k,ystart+k,xstart+k,ystart+k,k);
			//左下角
			checkerboardCover(broad,xstart+k,ystart,xstart+k,ystart+k-1,k);
		}
		else if(x >= xstart + k && y >= ystart + k){ // 右下角
			checkerboardCover(broad,xstart+k,ystart+k,x,y,k);
			broad[xstart+k-1][ystart+k-1] = 1;broad[xstart+k-1][ystart+k] = 1;broad[xstart+k][ystart+k-1] = 1;
			//左上角
			checkerboardCover(broad,xstart,ystart,xstart+k-1,ystart+k-1,k);
			//右上角
			checkerboardCover(broad,xstart,ystart+k,xstart+k-1,ystart+k,k);
			//左下角
			checkerboardCover(broad,xstart+k,ystart,xstart+k,ystart+k-1,k);
		}
		else if(x >= xstart+ k && y < ystart + k){ // 左下角
			checkerboardCover(broad,xstart+k,ystart,x,y,k);
			broad[xstart+k-1][ystart+k-1] = 2;broad[xstart+k-1][ystart+k] = 2;broad[xstart+k][ystart+k] = 2;
			//左上角
			checkerboardCover(broad,xstart,ystart,xstart+k-1,ystart+k-1,k);
			//右上角
			checkerboardCover(broad,xstart,ystart+k,xstart+k-1,ystart+k,k);
			//右下角
			checkerboardCover(broad,xstart+k,ystart+k,xstart+k,ystart+k,k);
		}	
	}
//	public static void checkerboardCover(int[][] broad,int xstart,int ystart,int x,int y,int size){
//		if(size == 1)
//			return ;
//		int k = size/2;
//		if(x < xstart+ k && y < ystart + k){ // 左上角
//			checkerboardCover(broad,xstart,ystart,x,y,k);
//		}else{
//			broad[xstart+k-1][ystart+k] = 5;broad[xstart+k][ystart+k] = 5;broad[xstart+k][ystart+k-1] = 5;
//			checkerboardCover(broad,xstart,ystart,xstart+k-1,ystart+k-1,k);
//		}
//		if(x < xstart+ k && y >= ystart + k){ // 右上角
//			checkerboardCover(broad,xstart,ystart+k,x,y,k);
//		}else{
//			broad[xstart+k-1][ystart+k-1] = 4;broad[xstart+k][ystart+k] = 4;broad[xstart+k][ystart+k-1] = 4;
//			checkerboardCover(broad,xstart+k,ystart+k,xstart+k,ystart+k,k);
//		}
//		if(x >= xstart + k && y >= ystart + k){ // 右下角
//			checkerboardCover(broad,xstart+k,ystart+k,x,y,k);
//		}else{
//			broad[xstart+k-1][ystart+k-1] = 2;broad[xstart+k-1][ystart+k] = 2;broad[xstart+k][ystart+k-1] = 2;
//			checkerboardCover(broad,xstart+k,ystart+k,xstart+k,ystart+k,k);
//		}
//		if(x >= xstart+ k && y < ystart + k){ // 左下角
//			checkerboardCover(broad,xstart+k,ystart,x,y,k);
//		}else{
//			broad[xstart+k-1][ystart+k-1] = 3;broad[xstart+k-1][ystart+k] = 3;broad[xstart+k][ystart+k] = 3;
//			checkerboardCover(broad,xstart+k,ystart,xstart+k,ystart+k-1,k);
//		}
//	}
	
	
	public static void print(int [][]arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println("");
		}
	}
	
	//分治算法循环赛日程表
	public static void roundMatch(int[][] table,int n){
		if (n == 1) {
			table[0][0] = 1;
			return;
		}
		int m = n / 2;
		// 先填充左上区域
		roundMatch(table, m);
		// 右上区域
		for (int i = 0; i < m; i++) {
			for (int j = m; j < n; j++) {
				table[i][j] = table[i][j - m] + m;
			}
		}
		// 左下区域
		for (int i = m; i < n; i++) {
			for (int j = 0; j < m; j++) {
				table[i][j] = table[i - m][j] + m;
			}
		}
		// 右下区域
		for (int i = m; i < n; i++) {
			for (int j = m; j < n; j++) {
				table[i][j] = table[i - m][j - m];
			}
		}
	}
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {31,-41,59,26,-53,58,97,-93,-23,84};
		int b[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		int c[] = {1,2,1,0,3,5,4,1,9,13};
		int d[] = {11,10,9,8,7,6,5,4,3,2,1};
//		int [][] chess = new int[8][8];
//		checkerboardCover(chess,0,0,1,1,8);
//		print(chess);
		int size = 8;
		int[][] table = new int[size][size];
		roundMatch(table, size);
		print(table);
		
	}

}
