package com.lintcode;

public class Main {

	
	
	/** 1. 给出一个整数数组，写一个程序把这个整数数组分成S1跟S2两部分，使S1中的和跟S2中的和的差的绝对值最小。
	*	      如果有一个一个整数数组 S 有 n 个数，如果Subset1有 m 个数，Subset2必须有 n-m 个数并且 abs(sum(Subset1) – sum(Subset2)) 应该最小
	*/
	public int findMin(int[] arr) {
		int sum = 0;
		for(int a : arr)
			sum += a;
		sum = sum / 2;
		

		
		return 0;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
