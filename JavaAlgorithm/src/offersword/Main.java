package offersword;

import java.util.Iterator;
import java.util.Stack;





public class Main {

	//字符串模拟数值加法
	public static boolean add(String a ,String b){
		
		return false;
		
	}
	
	//1. 同时找到最大值和最小值
	public static void getMinMax(int []arr){
		int length = arr.length;
		int res_Max = arr[0];
		int res_Min = arr[0];
		int start = 0, max, min, end = length;
		if(length%2==1)
			start = 1;
		while(start < end){
			max = arr[start] > arr[start + 1] ? arr[start] : arr[start + 1]; 
			min = arr[start] < arr[start + 1] ? arr[start] : arr[start + 1];
			res_Max = res_Max > max ? res_Max : max;
			res_Min = res_Min < min ? res_Min : min;
			start = start + 2;
		}	
		System.out.println("max:"+res_Max+",min:"+res_Min);
	}
	
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
	
	//2. 第  K 小的元素	
	public static int getKMin(int arr[], int start,int end,int k){
		if(start==end)
			return arr[start];
		int mid = partition(arr,start,end);
		int i = mid - start + 1;
		if(k==i)
			return arr[mid];
		else if(k<i)
			return getKMin(arr,start,mid-1,k);
		else return getKMin(arr,mid+1,end,k-i);	
	}
	//3. top K 问题	
	public static int quickSelect(int arr[], int start,int end,int k){
		if(start==end)
			return start;
		int mid = partition(arr,start,end);
		int pos = end - mid + 1;
		if(k==pos)
			return mid;
		else if(k<pos)
			return quickSelect(arr,mid+1,end,k);
		else return quickSelect(arr,start,mid-1,k-pos);	
	}
	public static int[] getTopK(int arr[],int k){
		int index = quickSelect(arr,0,arr.length-1,k);
		int result[] = new int[k];
		for(int i=index;i<arr.length;i++){
			result[i-index] = arr[i];
		}
		return result;
	}
	
	//大小堆
	
	
	//9.1 二维数组中的查找
	public static boolean twoDimFind(int[][] arr, int target){
		int row = arr.length - 1, col = arr[0].length - 1,ystart = 0, xstart = 0;
		while(ystart <= col && arr[0][ystart] < target)
			ystart++;
		if(ystart <= 0)
			return false;
		if(arr[0][ystart] == target)
			return true;
		while(xstart <= row && arr[xstart][0] < target)
			xstart++;
		xstart--;
		if(arr[xstart][0] == target)
			return true;
		for(int i=0; i < ystart; i++){
			for(int j=0; j < xstart; j++){
				if(arr[j][i] == target)
					return true;
			}
		}
		return false;
	}
	//9.1 二维数组中的查找
	public static boolean twoDimFind2(int[][] arr, int target){
		boolean find = false;
		if(arr!=null && arr.length >0 && arr[0].length>0){
			int rows = arr.length, cols = arr[0].length - 1,row = 0, col = cols - 1;
			while(row < rows && col >= 0){
				if(arr[row][col] == target){
					find = true;
					break;
				}else if(arr[row][col] > target)
					col--;
				else row++;
			}
		}
		return find;
	}
	
	
	
	public static String strReplace(String str){
		char strChar[] = str.toCharArray();
		int num = 0;
		//首先查找原字符串中空格的数量
		for(int i=0; i < strChar.length; i++){
			if(strChar[i] == ' ')
				num++;
		}
		//根据原字符串中空格的数量,确定新字符串的长度
		int length = strChar.length + num * 2;
		char newChar[] = new char[length];
		length--;
		for(int i=strChar.length-1; i >=0; i--){
			if(strChar[i] == ' '){
				newChar[length--] = '0';
				newChar[length--] = '2';
				newChar[length--] = '%';
			}else{
				newChar[length--] = strChar[i];
			}
		}
		return new String(newChar);
 	}
	
	// 调整数组顺序使奇数位于偶数之前
	public static void adjust(int[] arr){
		int start = 0, end = arr.length - 1;
		int tmp = 0;
		while(start < end){
			while(start < end && arr[end]%2 == 0)
				end--;
			while(start < end && arr[start]%2 == 1)
				start++;
			if(start < end){
				tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
			}
		}
	}
	public static void print(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	
	
	//旋转数组的最小数字
	public static int getMin(int[] arr){
		int start = 0, end = arr.length - 1, mid = 0;
		while(arr[start] >= arr[end]){
			if(end - start == 1){
				mid = end;
				break;
			}
			mid = start + (end - start) / 2;
			if(arr[mid] > arr[start])
				start = mid;
			else if(arr[mid] < arr[end])
				end = mid;
		}
		return mid;
	}
	//顺时针输出二维数组(递归实现)
	public static void printArrary(int[][] arr, int xstart,int xend,int ystart,int yend){
		if(xstart - 1==xend  && ystart -1 ==yend)
			return;
		for(int i=ystart;i <= yend; i++)
			System.out.print(arr[xstart][i]+",");
		for(int i=xstart + 1;i <= xend; i++)
			System.out.print(arr[i][yend]+",");
		for(int i=yend -1 ;i >= ystart; i--)
			System.out.print(arr[xend][i]+",");
		for(int i=xend - 1;i > xstart; i--)
			System.out.print(arr[i][ystart]+",");
		printArrary(arr,xstart+1,xend -1,ystart+1,yend-1);
		
	}
	
	//字符串的排列
	public static void permutation(String str){
		char[] ch = str.toCharArray();
		permutation(ch,0);
	}
	
	public static void permutation(char[] ch, int start){
		if(start == ch.length)
			System.out.println(new String(ch));
		else for(int j=start; j < ch.length;j++){
				char tmp = ch[j];
				ch[j] = ch[start];
				ch[start] = tmp;
				permutation(ch,start+1);
				tmp = ch[j];
				ch[j] = ch[start];
				ch[start] = tmp;
			}
	}
	//二进制中1的个数
	public static int numOfOne(int n){
		int count = 0;
		while(n!=0){
			n = (n-1) & n;
			count++;
		}
		return count;
	}
	/**
	 *  数组中只出现一次的数字
	 */
	public static void findNumAppearOne(int[] arr){
		int bitIs1 = 0;
		for(int i=0; i < arr.length; i++)
			bitIs1 = bitIs1 ^ arr[i];
		int num1 = 0, num2 = 0;
		int pos = findFirstBitIs1(bitIs1);
		for(int i = 0; i < arr.length; i++){
			if(bitIsOne(pos,arr[i]))
				num1 = num1 ^ arr[i];
			else num2 = num2 ^ arr[i];
		}
		System.out.println(num1+" "+num2);
	}
	/**
	 * 判断num在pos位的bit值是否为1
	 * @param pos
	 * @param num
	 * @return
	 */
	private static boolean bitIsOne(int pos, int num) {
		num = num >> pos;
		if((num & 1) == 0)
			return false;
		else return true;
	}
	/**
	 * 查找num中第一个bit位是1的位置
	 * @param bitIs1
	 * @return
	 */
	private static int findFirstBitIs1(int bitIs1) {
		int pos = 0;
		while((bitIs1 & 1) == 0 && pos < Integer.SIZE){
			bitIs1 =  bitIs1 >> 1;
			pos++;
		}
		return pos;
	}
	/**
	 *  不用加减乘除做加法
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int add(int num1, int num2){
		int result = num1 ^ num2, midValue = 0;
		int carry = (num1 & num2) << 1;
		while(carry != 0){
			midValue = result;
			result = midValue ^ carry;
			carry = midValue & carry;
		}
		return result;
	}
	
	
	public static class TreeNode {  
        int val;  
        TreeNode left;  
        TreeNode right;  
        public TreeNode(int val) {  
            this.val = val;  
        }  
    } 
	/**
	 *  树的子结构
	 * @param root
	 * @param subTree
	 * @return
	 */
	public static boolean isSubTree(TreeNode root, TreeNode subTree){
		if(root == null)
			return false;
		if(subTree == null)
			return false;
		boolean result = false;
		if(root.val == subTree.val){
			result = isSub(root,subTree);
			if(!result)
				result = isSubTree(root.left,subTree);
			if(!result)
				result = isSubTree(root.right,subTree);
		}	
		return result;	
	}
	public static boolean isSub(TreeNode root, TreeNode subTree){
		if(subTree == null)
			return true;
		if(root == null)
			return false;
		boolean result = false;
		if(root.val == subTree.val){
			result = isSub(root.left,subTree.left);
			if(result)
				result = isSub(root.right,subTree.right);
		}
		return result;
	}
	/**
	 * 二叉树路径查找
	 * @param root
	 * @param sum
	 * @param path
	 * @param currentSum
	 */
	public static void findPath(TreeNode root, int sum, Stack<Integer> path, int currentSum){
		if(root==null)
			return ;
		currentSum +=  root.val;
		path.push(root.val);
		boolean isLeaf = root.left==null && root.right==null;
		if(currentSum==sum && isLeaf){
			Iterator<Integer> items = path.iterator();
			while(items.hasNext()){
				System.out.print(items.next()+" ");
			}
		}
		if(root.left!=null)
			findPath(root.left,sum,path,currentSum);
		if(root.right!=null)
			findPath(root.right,sum,path,currentSum);
		path.pop();
	}
	
	
	public static TreeNode convert(TreeNode root){
		TreeNode plast = null;
		convertNode(root, plast);
		TreeNode pHead = plast;
		System.out.println(pHead!=null);
		while(pHead!=null && pHead.left!=null)
			pHead = pHead.left;
		return pHead;
	}
	
	public static void convertNode(TreeNode root, TreeNode plast){
		if(root==null)
			return;
		if(root.left!=null)
			convertNode(root.left,plast);
		root.left = plast;
		if(plast!=null)
			plast.right = root;
		plast = root;
		if(root.right!=null)
			convertNode(root.right,plast);
	}
	public static TreeNode convertNode2(TreeNode root){
		if(root==null)
			return null;
		TreeNode pLast = null;
		if(root.left!=null)
			pLast = convertNode2(root.left);
		root.left = pLast;
		if(pLast!=null)
			pLast.right = root;
		pLast = root;
		if(root.right!=null)
			pLast = convertNode2(root.right);
		return pLast;
	}
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testConvert();
	}
	
	
	
	
	
	
	
	
	
	
	private static void testConvert(){
		TreeNode root = new TreeNode(10);
		TreeNode p1 = new TreeNode(6);
		TreeNode p2 = new TreeNode(14);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(8);
		TreeNode p5 = new TreeNode(12);
		TreeNode p6 = new TreeNode(16);
		root.left = p1;
		root.right = p2;
//		p1.left = p3;
//		p1.right = p4;
//		p2.left = p5;
//		p2.right = p6;
		TreeNode phead = convert(root);

		while(phead!=null){
			System.out.print(phead.val+" ");
			phead = phead.right;
		}
		
	}
	
	
	
	
	
	
	
	private static void testFindPath(){
		TreeNode root = new TreeNode(10);
		TreeNode p1 = new TreeNode(5);
		TreeNode p2 = new TreeNode(12);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(7);
		root.left = p1;
		root.right = p2;
		p1.left = p3;
		p1.right = p4;
		Stack<Integer> path = new Stack<Integer>();
		findPath(root,22,path,0);
	}
	
	
	private static void testPermutation(){
		permutation("abcd");
	}
	private static void testPrintArrary(){
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printArrary(arr,0,arr.length-1,0,arr[0].length-1);
	}
	
	private static void testGetMin(){
		int arr[] = {3,4,5,1,2};
		int pos = getMin(arr);
		System.out.println(pos+" "+ arr[pos]);
	}
	
	
	private static void testSubTree() {
		TreeNode root = new TreeNode(8);
		TreeNode p1 = new TreeNode(8);
		TreeNode p2 = new TreeNode(7);
		TreeNode p3 = new TreeNode(9);
		TreeNode p4 = new TreeNode(2);
		TreeNode p5 = new TreeNode(4);
		TreeNode p6 = new TreeNode(7);
		root.left = p1;
		root.right = p2;
		p1.left = p3;
		p1.right = p4;
		p4.left = p5;
		p4.right = p6;
		TreeNode subTree = new TreeNode(8);
		TreeNode sp1 = new TreeNode(9);
		TreeNode sp2 = new TreeNode(2);
		subTree.left = sp1;
		subTree.right = sp2;
		System.out.println(isSubTree(root,subTree));
	}

}
