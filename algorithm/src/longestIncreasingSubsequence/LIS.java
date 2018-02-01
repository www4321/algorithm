package longestIncreasingSubsequence;

//最长上升子序列 (Longest Increasing Subsequence)

public class LIS {

	public static int  LISLength(int seq[]){
		int lseq[] = new int[seq.length];
		for(int i=0;i<lseq.length;i++)
			lseq[i]=0;
		int max = 0;
		for(int i=0;i<lseq.length;i++){
			max=0;
			for(int j=0;j<i;j++){
				if(seq[j]<=seq[i])
					max = Math.max(lseq[j], max);
			}
			lseq[i]= max + 1;
		}
		
		print(lseq);
		
		return 0;
	}
	public static int  LISLength2(int seq[]){
		int lseq[] = new int[seq.length];
		for(int i=0;i<lseq.length;i++){
			lseq[i]=1;
			for(int j=0;j<i;j++){
				if(seq[j]<=seq[i]&&lseq[j]+1>lseq[i])
					lseq[i]= lseq[j]+1;
			}		
		}
		print(lseq);
		
		return 0;
	}
	public static void print(int seq[]){
		for(int i=0;i<seq.length;i++)
			System.out.print(seq[i]+" ");
	}
	
		/**
	 * @param args
	 */
	public static void main(String[] args) {
		int seq[]={6,3,7,5,1,9,6,1};
		LISLength2(seq);

	}

}
