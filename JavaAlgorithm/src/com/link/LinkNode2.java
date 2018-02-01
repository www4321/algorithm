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
	
	//1. 求链表中结点个数,注意检查链表是否为空. 时间复杂度O(n).
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
	//2. 单链表的反转,非递归实现
	public static LinkNode reverseList(LinkNode root){
		//首先判断链表是否为空,或链表长度是否为1.
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
		//保证链表无环
		root.next =null;
		return pre;
	}
	//2. 单链表的反转,递归实现.
	public static LinkNode reverseListRec(LinkNode root){
		//首先判断链表是否为空,或链表长度是否为1.
		if(root == null || root.next==null)
			return root;
		LinkNode reHead = reverseListRec(root.next);      
		root.next.next = root;      // 把root接在reHead串的最后一个后面  
		root.next = null;               // 防止循环链表  
        return reHead; 
	}
	//3. 查找单链表中的倒数第K个结点（k > 0）
	public static LinkNode  reGetKthNode(LinkNode root, int k){
		if (k == 0 || root == null) {  
            return null;  
        }
		LinkNode pre = root;
		LinkNode kLast = root;
		//使pre比kLast领先K个结点
		while(k>0 && kLast !=null){
			kLast = kLast.next;
			k--;
		}
		//当结点数小于K时,返回空
		if(k>0 || kLast ==null)
			return null;
		while(kLast !=null ){
			pre = pre.next;
			kLast = kLast.next;
		}
		return pre;
	}
	//4. 查找单链表的中间结点
	//此题可应用于上一题类似的思想。也是设置两个指针，只不过这里是，两个指针同时向前走，前面的指针每次走两步，后面的指针每次走一步， 
    //* 前面的指针走到最后一个结点时，后面的指针所指结点就是中间结点，即第（n/2+1）个结点。注意链表为空，链表结点个数为null和1的情况。时间复杂度O(n)
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
	//5. 从尾到头打印单链表
	//对于这种颠倒顺序的问题，我们应该就会想到栈，后进先出。所以，这一题要么自己使用栈，要么让系统使用栈，也就是递归。注意链表为空的情况 
    //时间复杂度为O（n） 
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
	//5. 从尾到头打印单链表,递归实现
	public static void reversePrintListRec(LinkNode root){
		if(root == null)
			return;	
		reversePrintListRec(root.next);
		System.out.println(root.value);
		
	}
	//6. 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序,非递归实现
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
	//6. 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序,递归实现
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
			// 连接已解决的子问题
			result.next = mergeSortedListRec(root1,root2);
		}else{
			result = root2;
			root2 = root2.next;
			// 连接已解决的子问题
			result.next = mergeSortedListRec(root1,root2);
		}
		
		return result;
	}
	//7. 判断一个单链表中是否有环: hasCycle , 取出有环链表中，环的长度
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
     * 7. 判断一个单链表中是否有环 
     * 这里也是用到两个指针。如果一个链表中有环，也就是说用一个指针去遍历，是永远走不到头的。因此，我们可以用两个指针去遍历，一个指针一次走两步 
     * ，一个指针一次走一步，如果有环，两个指针肯定会在环中相遇。时间复杂度为O（n） 
     */  
    public static boolean hasCycle2(LinkNode head) {  
    	LinkNode fast = head; // 快指针每次前进两步  
    	LinkNode slow = head; // 慢指针每次前进一步  
        while (fast != null && fast.next != null) {  
            fast = fast.next.next;  
            slow = slow.next;  
            if (fast == slow) { // 相遇，存在环  
                return true;  
            }  
        }  
        return false;  
    } 
	//7. 取出有环链表中，环的长度,也可以取出进入环的第一个节点
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
	//8. 判断两个单链表是否相交: isIntersect
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
	//9. 求两个单链表相交的第一个节点: getFirstCommonNode
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
	* 9. 求两个单链表相交的第一个节点 对第一个链表遍历，计算长度len1，同时保存最后一个节点的地址。 
    * 对第二个链表遍历，计算长度len2，同时检查最后一个节点是否和第一个链表的最后一个节点相同，若不相同，不相交，结束。 
    * 两个链表均从头节点开始，假设len1大于len2 
    * ，那么将第一个链表先遍历len1-len2个节点，此时两个链表当前节点到第一个相交节点的距离就相等了，然后一起向后遍历，直到两个节点的地址相同。 
    * 时间复杂度，O(len1+len2) 
	*/
	public static LinkNode getFirstCommonNode2(LinkNode root1,LinkNode root2){
		if(root1==null || root2 == null)
			return null;
		LinkNode head1 = root1;
		LinkNode head2 = root2;
		int len1 = 1;
		int len2 = 1;
		//判断两个链表是否相交,并计算每个链表的长度
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
		//保证两个链表当前节点到第一个相交节点的距离就相等了
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
	// 10. 已知一个单链表中存在环，求进入环中的第一个节点
	public static LinkNode getFirstNodeInCycle(LinkNode root){
		LinkNode slow = root;  
		LinkNode fast = root;  
  
        // 1） 找到快慢指针相遇点  
        while (fast != null && fast.next != null) {  
            slow = slow.next;  
            fast = fast.next.next;  
            if (slow == fast) { // Collision  
                break;  
            }  
        }    
        // 错误检查，这是没有环的情况  
        if (fast == null || fast.next == null) {  
            return null;  
        }  
        /** 2) 相遇点离环的开始处的距离等于链表头到环开始处的距离，
         *   当快慢指针（slow、fast）相遇时，slow指针肯定没有遍历完链表，而fast指针已经在环内循环了n（n>=1）圈。
         *   假设slow指针走了s步，则fast指针走了2s步。同时，fast指针的步数还等于s加上在环上多转的n圈，设环长为r，
         *   则满足如下关系表达式: s+nr=2s, s=nr;
         *   假设链表结点个数为L,链表的头节点到环入口的距离为a,环的入口节点与相遇点的距离为x.
         *   a+x=s; a+x=nr=(n-1)r + r = (n-1)r + L-a; a = (n-1)r + L-a-x
         *   L-a-x即为相遇点离环的开始处的距离
        */
        // 这样，我们把慢指针放在链表头，快指针保持在相遇点，然后  
        // 同速度前进，再次相遇点就是环的开始处！  
        slow = root;  
        while (slow != fast) {  
            slow = slow.next;  
            fast = fast.next;  
        }  
        // 再次相遇点就是环的开始处  
        return fast; 
	}
	//给出一单链表头指针pHead和一节点指针pToBeDeleted，O(1)时间复杂度删除节点pToBeDeleted: delete
	public static LinkNode delete(LinkNode root,LinkNode deletedNode){
		if(deletedNode == null)
			return root;
		if(deletedNode.next!=null){
			deletedNode.value = deletedNode.next.value;
			deletedNode.next = deletedNode.next.next;
		}else{
			// 要删除的是最后一个节点！
			if(root==deletedNode)  // 链表中只有一个节点的情况 
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
	//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
	public static LinkNode deleteDoubleEle(LinkNode root){
		if(root==null)
			return null;
		LinkNode cursor = root;
		while(cursor!=null && cursor.next!=null){
			if(cursor.value == cursor.next.value){
				int val = cursor.value;
				LinkNode next = cursor;
				//重复的元素有多个，一直找到在其后第一个不重复的元素
				while(next!=null&&next.value==val){  
					next = next.next;   
	               } 
				//将cursor指针指向第一个不重复的元素
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
	//测试是否链表是否包含环，及环的长度
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
	//测试两个链表相交的第一个结点
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
