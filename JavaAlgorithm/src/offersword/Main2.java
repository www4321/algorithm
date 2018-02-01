package offersword;

import java.lang.reflect.Proxy;

public class Main2 {

	public static int partition(int[] arrary,int start,int end){
		int midvalue = arrary[start];
		while(start<end){
			while(arrary[end]>midvalue && end > start)
				end--;
			arrary[start] = arrary[end];
			while(arrary[start]<midvalue && end > start)
				start++;
			arrary[end] = arrary[start];
		}
		arrary[end] = midvalue;
		return end;
	}
	private static boolean checkHalf(int[] nums, int result) {
		int times = 0;
		for(int i=0;i < nums.length; i++){
			if(nums[i] == result)
				times++;
		}
		if(times < nums.length/2)
			return false;
		return true;
	}
	/**
	 * ˵�����������ڳ���һ������ַ���Ϊ-1������һ������ַ��ظ�����
	 * ����ĺ�������ʹ��partition�㷨��partition�㷨�кܶ��Ӧ������š�top K����ȣ�������top K�����һ�����Ρ�
	 * @param nums
	 * @return
	 */
	
	public static int moreThanHalfNum(int[] nums){
		if(nums==null || nums.length <=0 )
			return -1;
		int mid = nums.length >> 1;
		int start = 0, end = nums.length -1 ;
		int index = partition(nums,start,end);
		while(index != mid){
			if(index > mid){
				end = index - 1;
				index = partition(nums,start,end);
			}else{
				start = index + 1;
				index = partition(nums,start,end);
			}
		}
		int result = nums[mid];
		if(!checkHalf(nums,result))
			return -1;
		return result;
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
        //���ɴ�����Ķ���
        Subject subject = (Subject)Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), new SubjectHandler(realSubject));
        subject.rent(); //���ô�����ķ���


	}

}
