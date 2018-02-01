package com.link;


import java.util.HashSet;

import java.util.Set;
import java.util.Stack;


public class LinkNode2 {

	public static class LinkNode{
		int value;
		LinkNode next;
		public LinkNode(int value) {
			super();
			this.value = value;
			this.next = null;
		}
	}
	
	//1. �������н�����,ע���������Ƿ�Ϊ��. ʱ�临�Ӷ�O(n).
	public static int getListLength(LinkNode root){
		int result = 0;
		if(root == null)
			return result;
		LinkNode cursor = root;
		while(cursor!=null){
			result++;
			cursor = cursor.next;
		}
		return result;
	}
	//2. ������ķ�ת,�ǵݹ�ʵ��
	public static LinkNode reverseList(LinkNode root){
		//�����ж������Ƿ�Ϊ��,���������Ƿ�Ϊ1.
		if(root == null || root.next==null)
			return root;
		LinkNode pre = root;
		LinkNode mid = root.next;
		LinkNode last = null;
		while(mid !=null){
			last = mid.next;
			mid.next = pre;
			pre = mid;
			mid = last;
		}
		//��֤�����޻�
		root.next =null;
		return pre;
	}
	//2. ������ķ�ת,�ݹ�ʵ��.
	public static LinkNode reverseListRec(LinkNode root){
		//�����ж������Ƿ�Ϊ��,���������Ƿ�Ϊ1.
		if(root == null || root.next==null)
			return root;
		LinkNode reHead = reverseListRec(root.next);      
		root.next.next = root;      // ��root����reHead�������һ������  
		root.next = null;               // ��ֹѭ������  
        return reHead; 
	}
	//3. ���ҵ������еĵ�����K����㣨k > 0��
	public static LinkNode  reGetKthNode(LinkNode root, int k){
		if (k == 0 || root == null) {  
            return null;  
        }
		LinkNode pre = root;
		LinkNode kLast = root;
		//ʹpre��kLast����K�����
		while(k>0 && kLast !=null){
			kLast = kLast.next;
			k--;
		}
		//�������С��Kʱ,���ؿ�
		if(k>0 || kLast ==null)
			return null;
		while(kLast !=null ){
			pre = pre.next;
			kLast = kLast.next;
		}
		return pre;
	}
	//4. ���ҵ�������м���
	//�����Ӧ������һ�����Ƶ�˼�롣Ҳ����������ָ�룬ֻ���������ǣ�����ָ��ͬʱ��ǰ�ߣ�ǰ���ָ��ÿ���������������ָ��ÿ����һ���� 
    //* ǰ���ָ���ߵ����һ�����ʱ�������ָ����ָ�������м��㣬���ڣ�n/2+1������㡣ע������Ϊ�գ����������Ϊnull��1�������ʱ�临�Ӷ�O(n)
	public static LinkNode getMiddleNode(LinkNode root){
		if(root ==null || root.next == null)
			return root;
		LinkNode pre =root, last = root;
		while(last != null ){
			pre = pre.next;
			last = last.next.next;
		}
		return pre;
	}
	//5. ��β��ͷ��ӡ������
	//�������ֵߵ�˳������⣬����Ӧ�þͻ��뵽ջ������ȳ������ԣ���һ��Ҫô�Լ�ʹ��ջ��Ҫô��ϵͳʹ��ջ��Ҳ���ǵݹ顣ע������Ϊ�յ���� 
    //ʱ�临�Ӷ�ΪO��n�� 
	public static void reversePrintListStack(LinkNode root){
		if(root == null)
			return;
		Stack<LinkNode> stack = new Stack<LinkNode>();
		LinkNode cursor = root;
		while(cursor!=null){
			stack.push(cursor);
			cursor = cursor.next;
		}
		while(!stack.empty()){
			System.out.println(stack.pop().value);
		}
	}
	//5. ��β��ͷ��ӡ������,�ݹ�ʵ��
	public static void reversePrintListRec(LinkNode root){
		if(root == null)
			return;	
		reversePrintListRec(root.next);
		System.out.println(root.value);
		
	}
	//6. ��֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����,�ǵݹ�ʵ��
	public static LinkNode mergeSortedList(LinkNode pHead1,LinkNode pHead2){
		if( pHead1==null ){
			return pHead2;
		}
		if(pHead2==null)
			return pHead1;
		LinkNode result =null;
		if(pHead1.value<pHead2.value){
			result = pHead1;
			pHead1 = pHead1.next;
		}else{
			result = pHead2;
			pHead2 = pHead2.next;
		}
		LinkNode cursor = result;
		while(pHead1!=null && pHead2!=null){
			if(  pHead1.value<pHead2.value ){
				cursor.next = pHead1;
				pHead1 = pHead1.next;
				cursor = cursor.next;
			}else{
				cursor.next = pHead2;
				pHead2 = pHead2.next;
				cursor = cursor.next;
			}
		}
		if(pHead1==null){
			cursor.next = pHead2;
		}else
			cursor.next = pHead1;	
		return result;
	}
	//6. ��֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����,�ݹ�ʵ��
	public static LinkNode mergeSortedListRec(LinkNode root1,LinkNode root2){
		if( root1==null ){
			return root2;
		}
		if(root2==null)
			return root1;
		LinkNode result = null;
		if(root1.value<root2.value){
			result = root1;
			root1 = root1.next;
			// �����ѽ����������
			result.next = mergeSortedListRec(root1,root2);
		}else{
			result = root2;
			root2 = root2.next;
			// �����ѽ����������
			result.next = mergeSortedListRec(root1,root2);
		}
		
		return result;
	}
	//7. �ж�һ�����������Ƿ��л�: hasCycle , ȡ���л������У����ĳ���
	public static boolean hasCycle(LinkNode root){
		Set<LinkNode> linkNodesMap = new HashSet<LinkNode>();
		LinkNode cursor = root;
		while(cursor!=null){
			if(!linkNodesMap.contains(cursor)){
				linkNodesMap.add(cursor);
				cursor = cursor.next;
			}else{
				return true;
			}
		}
		return false;
	}
	/** 
     * 7. �ж�һ�����������Ƿ��л� 
     * ����Ҳ���õ�����ָ�롣���һ���������л���Ҳ����˵��һ��ָ��ȥ����������Զ�߲���ͷ�ġ���ˣ����ǿ���������ָ��ȥ������һ��ָ��һ�������� 
     * ��һ��ָ��һ����һ��������л�������ָ��϶����ڻ���������ʱ�临�Ӷ�ΪO��n�� 
     */  
    public static boolean hasCycle2(LinkNode head) {  
    	LinkNode fast = head; // ��ָ��ÿ��ǰ������  
    	LinkNode slow = head; // ��ָ��ÿ��ǰ��һ��  
        while (fast != null && fast.next != null) {  
            fast = fast.next.next;  
            slow = slow.next;  
            if (fast == slow) { // ���������ڻ�  
                return true;  
            }  
        }  
        return false;  
    } 
	//7. ȡ���л������У����ĳ���,Ҳ����ȡ�����뻷�ĵ�һ���ڵ�
	public static int cycleLength(LinkNode root){
		Set<LinkNode> linkNodesMap = new HashSet<LinkNode>();
		LinkNode cursor = root;
		while(cursor!=null){
			if(!linkNodesMap.contains(cursor)){
				linkNodesMap.add(cursor);
				cursor = cursor.next;
			}else
				break;
		}
		int length = 1;
		if(cursor==null){
			System.out.println("no cycle");
			return 0;
		}else{
			System.out.println("has cycle");
			LinkNode first = cursor;
			while(first!=cursor.next){
				cursor = cursor.next;
				length++;
			}
		}
		return length;
	}
	//8. �ж������������Ƿ��ཻ: isIntersect
	public static boolean isIntersect(LinkNode root1,LinkNode root2){
		if(root1 == null || root2 == null)
			return false;
		LinkNode head1 = root1;
		LinkNode head2 = root2;
		while(head1.next!=null)
			head1 = head1.next;
		while(head2.next!=null)
			head2 = head2.next;
		if(head1==head2)
			return true;
		else return false;
	}
	//9. �������������ཻ�ĵ�һ���ڵ�: getFirstCommonNode
	public static LinkNode getFirstCommonNode(LinkNode root1,LinkNode root2){
		if(root1==null || root2 == null)
			return null;
		Set<LinkNode> linkNodesMap = new HashSet<LinkNode>();
		LinkNode cursor = root1;
		while(cursor != null){
			linkNodesMap.add(cursor);
			cursor = cursor.next;
		}
		cursor = root2;
		while(cursor != null){
			if(linkNodesMap.contains(cursor))
				return cursor;
			cursor = cursor.next;
		}
		return null;
	}
	/**
	* 9. �������������ཻ�ĵ�һ���ڵ� �Ե�һ��������������㳤��len1��ͬʱ�������һ���ڵ�ĵ�ַ�� 
    * �Եڶ���������������㳤��len2��ͬʱ������һ���ڵ��Ƿ�͵�һ����������һ���ڵ���ͬ��������ͬ�����ཻ�������� 
    * �����������ͷ�ڵ㿪ʼ������len1����len2 
    * ����ô����һ�������ȱ���len1-len2���ڵ㣬��ʱ��������ǰ�ڵ㵽��һ���ཻ�ڵ�ľ��������ˣ�Ȼ��һ����������ֱ�������ڵ�ĵ�ַ��ͬ�� 
    * ʱ�临�Ӷȣ�O(len1+len2) 
	*/
	public static LinkNode getFirstCommonNode2(LinkNode root1,LinkNode root2){
		if(root1==null || root2 == null)
			return null;
		LinkNode head1 = root1;
		LinkNode head2 = root2;
		int len1 = 1;
		int len2 = 1;
		//�ж����������Ƿ��ཻ,������ÿ������ĳ���
		while(head1.next!=null){
			head1 = head1.next;
			len1++;
		}	
		while(head2.next!=null){
			head2 = head2.next;
			len2++;
		}
		if(head1!=head2)
			return null;
		head1 = root1;
		head2 = root2;
		//��֤��������ǰ�ڵ㵽��һ���ཻ�ڵ�ľ���������
		if(len1>len2){
			while(len1>len2){
				head1 = head1.next;
				len1--;
			}
		}else{
			while(len1<len2){
				head2 = head2.next;
				len2--;
			}
		}
		while(head1!=head2){
			head1 = head1.next;
			head2 = head2.next;
		}	
		return head1;
	}
	// 10. ��֪һ���������д��ڻ�������뻷�еĵ�һ���ڵ�
	public static LinkNode getFirstNodeInCycle(LinkNode root){
		LinkNode slow = root;  
		LinkNode fast = root;  
  
        // 1�� �ҵ�����ָ��������  
        while (fast != null && fast.next != null) {  
            slow = slow.next;  
            fast = fast.next.next;  
            if (slow == fast) { // Collision  
                break;  
            }  
        }    
        // �����飬����û�л������  
        if (fast == null || fast.next == null) {  
            return null;  
        }  
        /** 2) �������뻷�Ŀ�ʼ���ľ����������ͷ������ʼ���ľ��룬
         *   ������ָ�루slow��fast������ʱ��slowָ��϶�û�б�����������fastָ���Ѿ��ڻ���ѭ����n��n>=1��Ȧ��
         *   ����slowָ������s������fastָ������2s����ͬʱ��fastָ��Ĳ���������s�����ڻ��϶�ת��nȦ���軷��Ϊr��
         *   ���������¹�ϵ���ʽ: s+nr=2s, s=nr;
         *   �������������ΪL,�����ͷ�ڵ㵽����ڵľ���Ϊa,������ڽڵ���������ľ���Ϊx.
         *   a+x=s; a+x=nr=(n-1)r + r = (n-1)r + L-a; a = (n-1)r + L-a-x
         *   L-a-x��Ϊ�������뻷�Ŀ�ʼ���ľ���
        */
        // ���������ǰ���ָ���������ͷ����ָ�뱣���������㣬Ȼ��  
        // ͬ�ٶ�ǰ�����ٴ���������ǻ��Ŀ�ʼ����  
        slow = root;  
        while (slow != fast) {  
            slow = slow.next;  
            fast = fast.next;  
        }  
        // �ٴ���������ǻ��Ŀ�ʼ��  
        return fast; 
	}
	//����һ������ͷָ��pHead��һ�ڵ�ָ��pToBeDeleted��O(1)ʱ�临�Ӷ�ɾ���ڵ�pToBeDeleted: delete
	public static LinkNode delete(LinkNode root,LinkNode deletedNode){
		if(deletedNode == null)
			return root;
		if(deletedNode.next!=null){
			deletedNode.value = deletedNode.next.value;
			deletedNode.next = deletedNode.next.next;
		}else{
			// Ҫɾ���������һ���ڵ㣡
			if(root==deletedNode)  // ������ֻ��һ���ڵ����� 
				root = null;
			else{
				LinkNode cursor = root;
				while(cursor.next!=deletedNode){
					cursor = cursor.next;
				}
				cursor.next = null;
			}
		}
		return root;
	}
	//��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ��
	public static LinkNode deleteDoubleEle(LinkNode root){
		if(root==null)
			return null;
		LinkNode cursor = root;
		while(cursor!=null && cursor.next!=null){
			if(cursor.value == cursor.next.value){
				int val = cursor.value;
				LinkNode next = cursor;
				//�ظ���Ԫ���ж����һֱ�ҵ�������һ�����ظ���Ԫ��
				while(next!=null&&next.value==val){  
					next = next.next;   
	               } 
				//��cursorָ��ָ���һ�����ظ���Ԫ��
				cursor.next = next;
			}
			cursor = cursor.next;
		}
		
		return root;
	}
	
	public static void print(LinkNode root){
		if(root == null)
			return;
		LinkNode cursor = root;
		while(cursor != null){
			System.out.println(cursor.value);
			cursor = cursor.next;
		}
	}
	
	
	public static void testDeleteDoubleEle(){
		LinkNode root = new LinkNode(5);
		LinkNode node1 = new LinkNode(5);
		LinkNode node2 = new LinkNode(5);
		LinkNode node3 = new LinkNode(5);
		LinkNode node4 = new LinkNode(9);
		LinkNode node5 = new LinkNode(9);
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		print(deleteDoubleEle(root));
	}
	//�����Ƿ������Ƿ�������������ĳ���
	public static void testHasCycle(){
		LinkNode root = new LinkNode(1);
		LinkNode node1 = new LinkNode(3);
		LinkNode node2 = new LinkNode(5);
		LinkNode node3 = new LinkNode(7);
		LinkNode node4 = new LinkNode(8);
		LinkNode node5 = new LinkNode(9);
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node2;
		System.out.println(hasCycle(root));
		System.out.println(hasCycle2(root));
		System.out.println(cycleLength(root));
		System.out.println(getFirstNodeInCycle(root).value);
	}
	//�������������ཻ�ĵ�һ�����
	public static void testFirstCommonNode(){
		LinkNode root = new LinkNode(1);
		LinkNode node1 = new LinkNode(3);
		LinkNode node2 = new LinkNode(5);
		LinkNode node3 = new LinkNode(7);
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		LinkNode root3 = new LinkNode(2);
		LinkNode node13 = new LinkNode(4);
		root3.next = node13;
		node13.next = node2;
		System.out.println(getFirstCommonNode(root,root3).value);
		System.out.println(getFirstCommonNode2(root,root3).value);
	}
	public static void testDeleted(){
		LinkNode root = new LinkNode(1);
		LinkNode node1 = new LinkNode(3);
		LinkNode node2 = new LinkNode(5);
		LinkNode node3 = new LinkNode(7);
		LinkNode node4 = new LinkNode(8);
		LinkNode node5 = new LinkNode(9);
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
//		print(delete(root,root));
//		System.out.println("------------------------------------------------");
		print(delete(root,node1));
		System.out.println("------------------------------------------------");
		print(delete(root,node5));
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkNode root = new LinkNode(1);
		LinkNode node1 = new LinkNode(3);
		LinkNode node2 = new LinkNode(5);
		LinkNode node3 = new LinkNode(7);
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		LinkNode root2 = new LinkNode(2);
		LinkNode node12 = new LinkNode(4);
		LinkNode node22 = new LinkNode(6);
		LinkNode node32 = new LinkNode(8);
		root2.next = node12;
		node12.next = node22;
		node22.next = node32;
		LinkNode root3 = new LinkNode(2);
		LinkNode node13 = new LinkNode(4);
		root3.next = node13;
		node13.next = node2;
		//System.out.println(getListLength(root));
		//print(reverseList(root));
		print(reverseListRec(root));
		//System.out.println(reGetKthNode(root,4).value);
		//System.out.println(getMiddleNode(root).value);
		//reversePrintListStack(root);
		//reversePrintListRec(root);
		//print(mergeSortedList(root,root2));
		//print(mergeSortedListRec(root,root2));
		//System.out.println(isIntersect(root,root3));
		//testHasCycle();
		//testFirstCommonNode();
		//testDeleted();
		//testDeleteDoubleEle();
	}
}
