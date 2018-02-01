package climb;
//½×ÌİÎÊÌâ
public class ClimbStep {

	public static int climbStep(int n){
		if(n==1)
			return 1;
		else if(n==2)
			return 2;
		else if(n==3)
			return 4;
		else return climbStep(n-1)+climbStep(n-2)+climbStep(n-3);
	}
	public static int climbStep2(int n){
		int result[]=new int[n];
		for(int i=0;i<n;i++)
			result[i]=0;
		result[0]=1;
		result[1]=2;
		result[2]=4;
		for(int i=3;i<n;i++){
			result[i]=result[i-1]+result[i-2]+result[i-3];
		}
		return result[n-1];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int result1 = climbStep(36);
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"ms");
		System.out.println(result1);
		long start1 = System.currentTimeMillis();
		int result2 = climbStep2(36);
		long end1 = System.currentTimeMillis();
		System.out.println((end1-start1)+"ms");
		System.out.println(result2);
	}

}
