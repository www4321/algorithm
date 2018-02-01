package activityselect;

public class Activity_Select {

	public static int activitySelect(int s[], int f[], int start,int num){
		int next = start + 1;
		if(next < s.length && s[next] < f[start])
			next++;
		if(next<s.length)
			num++;
		else return 0;
		return activitySelect(s,f,next,num);
	}
	public static boolean[] activitySelect2(int s[], int f[]){
		boolean result[] = new boolean[s.length];
		int start = 0, next = 1;
		result[0] = true;
		while(next < s.length){
			if(s[next] >= f[start]){
				result[next] = true;
				start = next;
				next = next + 1;
			}else next++;
		}
		return result;
	}
	public static boolean[] activitySelect3(int s[], int f[]){
		boolean result[] = new boolean[s.length];
		int start = 0;
		result[0] = true;
		for(int k=1; k < s.length; k++){
			if(s[k] >= f[start]){
				result[k] = true;
				start = k;
			}
		}
		return result;
	}
	public static void print(boolean a[]){
		for(int i=0; i < a.length; i++)
			System.out.print(a[i]+" ");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int s[] = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
		int f[] = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
		boolean resulr[] = activitySelect3(s,f);
		print(resulr);
	}

}
