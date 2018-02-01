package my.sort;

public class Sort_2dim {

	public static void quickSort(int[][] arrary, int start, int end, int dim) {  
	    if(start >= end) return;         
	    int mid = partition(arrary, start, end,dim);  	      
	    quickSort(arrary, start, mid-1,dim); 
	    quickSort(arrary, mid+1, end,dim); 
	}
	public static int partition(int[][] arrary,int start,int end, int dim){

			int	midvalue = arrary[dim][start];
			int	midvalue1 = arrary[1-dim][start];
			while(start<end){
				while(arrary[dim][end]>midvalue && end > start)
					end--;
				arrary[0][start] = arrary[0][end];
				arrary[1][start] = arrary[1][end];
				while(arrary[dim][start]<midvalue && end > start)
					start++;
				arrary[0][end] = arrary[0][start];
				arrary[1][end] = arrary[1][start];
			}
			arrary[dim][end] = midvalue;
			arrary[1-dim][end] = midvalue1;
		
		return end;
	}
	public static void Sort(int matrix[][], int dim){
		if(matrix.length != 2){
			System.out.println("length of matrix must be 2");
			return;
		}	
		quickSort(matrix,0,matrix[0].length-1,dim);
	}
	public static void print(int matrix[][]){
		for(int i=0; i<2;i++){
			for(int j=0; j<matrix[0].length; j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println("");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int matrix[][] = {{2,8,9,4,5,3},{1,2,3,4,5,6}};
		print(matrix);
		Sort(matrix,1);
		print(matrix);
	}

}
