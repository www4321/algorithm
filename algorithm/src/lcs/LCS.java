package lcs;

import java.util.ArrayList;
import java.util.List;


//最长公共子序列

public class LCS {

	public static int[][] LCSLength(String str1,String str2){
		char ch1[] = str1.toCharArray();
		char ch2[] = str2.toCharArray();
		int lcs[][] = new int[ch1.length+1][ch2.length+1];
		for(int i = 0; i <=ch1.length ; i++){
			for(int j = 0; j <= ch2.length ; j++){
				if(i == 0 || j == 0){
					lcs[i][j] = 0;
					continue;
				}
				if(ch1[i-1]==ch2[j-1])
					lcs[i][j] = lcs[i-1][j-1]+1;
				else
					lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
			}
		}
		return lcs;
	}
	public static List<Character> getLCS(String str1,String str2,int lcs[][]){
		List<Character> result = new ArrayList<Character>();
		char ch1[] = str1.toCharArray();
		char ch2[] = str2.toCharArray();
		for(int i = ch1.length,j = ch2.length; i > 0&& j>0;){
			if(ch1[i-1]==ch2[j-1]){
				result.add(ch1[i-1]);
				i--;
				j--;
			}else{
				if(lcs[i-1][j]>=lcs[i][j-1]){
					i--;
				}else
					j--;
			}
		}
		System.out.println(result.toString());
		return result;
	}
	public static void print(int seq[][]){
		for(int i=0;i<seq.length;i++){
			for(int j = 0;j < seq[0].length;j++)
				System.out.print(seq[i][j]+" ");
			System.out.println("");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str1 = "BDCABA";
		String str2 = "ABCBDAB";
		int d[][]= LCSLength(str1,str2);
		getLCS(str1,str2,d);
	}

}
