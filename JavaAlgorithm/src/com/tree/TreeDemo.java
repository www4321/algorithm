package com.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class TreeDemo {
	public static class TreeNode {  
        int val;  
        TreeNode left;  
        TreeNode right;  
        public TreeNode(int val) {  
            this.val = val;  
        }  
    } 
	// 1. 求二叉树中的节点个数,递归实现
	public static int getNodeNumRec(TreeNode root){
		if(root==null)
			return 0;
		int result = 1 + getNodeNumRec(root.left) + getNodeNumRec(root.right);		
		return result;
	}
	// 1. 求二叉树中的节点个数,迭代实现
	public static int getNodeNum(TreeNode root){
		if(root==null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode cursor = null;
		queue.add(root);
		int result = 0;
		while(!queue.isEmpty()){
			cursor = queue.remove();
			result++;
			if(cursor.left!=null)
				queue.add(cursor.left);
			if(cursor.right!=null)
				queue.add(cursor.right);
		}	
		return result;
	}
	// 2. 求二叉树的深度: getDepthRec（递归），getDepth
	public static int getDepthRec(TreeNode root){
		if(root==null)
			return 0;
		int result = 1 + Math.max(getDepthRec(root.left),getDepthRec(root.right));	
		return result;
	}
	// 2. 求二叉树的深度: 非递归实现
	public static int getDepth(TreeNode root){
		if(root==null)
			return 0;
		int result = 0;
		int currentLevelNodes = 1;      // 当前Level，node的数量  
        int nextLevelNodes = 0;         // 下一层Level，node的数量  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode cursor = null;
		queue.add(root);
		while(!queue.isEmpty()){
			cursor = queue.remove();
			currentLevelNodes--;
			if(cursor.left!=null){
				queue.add(cursor.left);
				nextLevelNodes++;
			}
			if(cursor.right!=null){
				queue.add(cursor.right);
				nextLevelNodes++;
			}
			if(currentLevelNodes==0){
				result++;
				currentLevelNodes=nextLevelNodes;
				nextLevelNodes = 0;
			}
		}
		return result;
	}
	// 3. 前序遍历，中序遍历，后序遍历:  递归实现前序遍历
	public static void preorderTraversalRec(TreeNode root){
		if(root==null)
			return;
		else{
			System.out.print(root.val + " ");
			preorderTraversalRec(root.left);
			preorderTraversalRec(root.right);
		}
	}
	// 3. 前序遍历，中序遍历，后序遍历:  递归实现中序遍历
	public static void inorderTraversalRec(TreeNode root){
		if(root==null)
			return;
		else{
			inorderTraversalRec(root.left);
			System.out.print(root.val + " ");
			inorderTraversalRec(root.right);
		}
	}
	// 3. 前序遍历，中序遍历，后序遍历:  递归实现后序遍历
	public static void postorderTraversalRec (TreeNode root){
		if(root==null)
			return;
		else{
			postorderTraversalRec(root.left);
			postorderTraversalRec(root.right);
			System.out.print(root.val + " ");
		}
	}	
	// 3. 前序遍历，中序遍历，后序遍历: 迭代实现前序遍历preorderTraversal
	public static void preorderTraversal(TreeNode root){
		if(root==null)
			return;  
        Stack<TreeNode> stack=new Stack<TreeNode>();  
        while(root!=null||!stack.isEmpty()){  
            while(root!=null){  
                System.out.print(root.val+" ");  
                stack.push(root);//先访问再入栈  
                root=root.left;  
            }  
            root=stack.pop();  
            root=root.right;//如果是null，出栈并处理右子树  
        } 
	}
	// 3. 前序遍历，中序遍历，后序遍历: 迭代实现中序遍历inorderTraversal
	public static void inorderTraversal(TreeNode root){
		if(root==null)return;  
        Stack<TreeNode> s=new Stack<TreeNode>();  
        while(root!=null||!s.isEmpty()){  
            while(root!=null){  
                s.push(root);
                root=root.left;  
            }  
            root=s.pop();  
            System.out.print(root.val+" ");  
            root=root.right;//如果是null，出栈并处理右子树  
        }	
	}
	// 3. 前序遍历，中序遍历，后序遍历: 迭代实现后序遍历
	public static void postorderTraversal(TreeNode root){
		if(root==null)
			return ;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode,Boolean> map=new HashMap<TreeNode,Boolean>();   
		stack.push(root);  
        while(!stack.isEmpty()){  
        	TreeNode temp=stack.peek();  
            if(temp.left!=null&&!map.containsKey(temp.left)){  
                temp=temp.left;  
                while(temp!=null){  
                    if(map.containsKey(temp))break;  
                    else stack.push(temp);  
                    temp=temp.left;  
                }  
                continue;  
            }  
            if(temp.right!=null&&!map.containsKey(temp.right)){  
            	stack.push(temp.right);  
                continue;  
            }  
            TreeNode t=stack.pop();  
            map.put(t,true);  
            System.out.print(t.val+" ");  
        } 		
	}
	// 4. 分层遍历二叉树
	public static void levelTraversal(TreeNode root){
		if(root==null)
			return ;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode cursor = null;
		queue.add(root);
		while(!queue.isEmpty()){
			cursor = queue.poll();
			System.out.print(cursor.val+" ");
			if(cursor.left!=null)
				queue.add(cursor.left);
			if(cursor.right!=null)
				queue.add(cursor.right);
		}
	}
	// 4. 分层遍历二叉树
	public static void levelTraversalRec(TreeNode root){
		if(root==null)
			return ;
		 ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
		 dfs(root, 0, ret);  
	     System.out.println(ret);
	}
	private static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret){  
        if(root == null){  
            return;  
        }           
        // 添加一个新的ArrayList表示新的一层  
        if(level >= ret.size()){  
            ret.add(new ArrayList<Integer>());  
        }  
          
        ret.get(level).add(root.val);   // 把节点添加到表示那一层的ArrayList里  
        dfs(root.left, level+1, ret);       // 递归处理下一层的左子树和右子树  
        dfs(root.right, level+1, ret);  
    } 
	//5. 将二叉查找树变为有序的双向链表 要求不能创建新节点，只调整指针
	public static void convertBST2DLLRec(TreeNode root, TreeNode last){
		if(root == null)
			return ;
		if(root.left!=null){
			convertBST2DLLRec(root.left,last);
		}
		root.left = last;
		if(last!=null){
			last.right = root;
		}
		last = root;
		if(root.right!=null){
			convertBST2DLLRec(root.right,last);
		}
	}
	// 8. 判断两棵二叉树是否相同的树
	public static boolean isSameRec(TreeNode root1,TreeNode root2){
		if(root1==null || root2==null)
			return false;
		boolean result = false;
		if(root1.val == root2.val){
			if(root1.left==null && root2.left==null)
				result = true;
			else result =  isSameRec(root1.left,root2.left);
		}		
		if(result){
			if(root1.right==null && root2.right==null)
				result = true;
			else result = isSameRec(root1.right,root2.right);
		}	
		return result;
	}
	
	// 10. 判断两个树是否互相镜像：isMirrorRec
	public static boolean isMirrorRec(TreeNode root1,TreeNode root2){
		if(root1==null || root2==null)
			return false;
		boolean result = false;
		if(root1.val == root2.val){
			if(root1.left==null && root2.right==null)
				result = true;
			else result =  isMirrorRec(root1.left,root2.right);
		}		
		if(result){
			if(root1.right==null && root2.left==null)
				result = true;
			else result = isMirrorRec(root1.right,root2.left);
		}	
		return result;
	}
	
	
	// 11. 求二叉树中两个节点的最低公共祖先节点
	public static TreeNode getCommomNodeRec(TreeNode root,TreeNode node1,TreeNode node2){
		if(root==null)
			return root;
		if(getNodeRec(root.left,node1)){
			if(getNodeRec(root.left,node2))
				return getCommomNodeRec(root.left,node1,node2);
			else
				return root;
		}else{
			if(getNodeRec(root.right,node2))
				return getCommomNodeRec(root.right,node1,node2);
			else
				return root;	
		}
		
	}
	public static boolean getNodeRec(TreeNode root,TreeNode node){
		if(root==null)
			return false;
		if(root==node)
			return true;
		boolean find = getNodeRec(root.left,node);
		if(!find)
			find = getNodeRec(root.right,node);
		return find;
	}
	// 11. 求二叉树中两个节点的最低公共祖先节点
	public static TreeNode getCommomNode(TreeNode root,TreeNode node1,TreeNode node2){
		if(root==null)
			return root;
		List<TreeNode> node1List = new LinkedList<TreeNode>();
		List<TreeNode> node2List = new LinkedList<TreeNode>();
		boolean node1Bool = getNodeLink(root,node1,node1List);
		boolean node2Bool = getNodeLink(root,node2,node2List);
		
		if(!node1Bool || !node2Bool)
			return null;
		Collections.reverse(node1List);
		Collections.reverse(node2List);
		TreeNode last = null;  
        Iterator<TreeNode> iter1 = node1List.iterator();  
        Iterator<TreeNode> iter2 = node2List.iterator();  
        while (iter1.hasNext() && iter2.hasNext()) {  
            TreeNode tmp1 = iter1.next();  
            TreeNode tmp2 = iter2.next();  
            if (tmp1 == tmp2) {  
                last = tmp1;  
            } else { // 直到遇到非公共节点  
                break;  
            }  
        }  
        return last;  
		
	}
	public static boolean getNodeLink(TreeNode root,TreeNode node1,List<TreeNode> list){
		if(root==null)
			return false;
		if(root==node1){
			list.add(root);
			return true;
		}
		boolean find = getNodeLink(root.left,node1,list); //在该结点的左子树查找
		if(!find){
			find = getNodeLink(root.right,node1,list);//若左子树查找不到，在该结点的右子树查找
			if(find)
				list.add(root);//若该结点右子树包含待查结点，则将该结点加入List，否则则说明左右子树均不包含待查结点，该结点不能加入到List
		}else
			list.add(root);//若该结点左子树包含待查结点，则将该结点加入List
		return find;
	}
	
	// 12. 求二叉树中节点的最大距离：getMaxDistanceRec
	public static int getMaxDistanceRec(TreeNode root){
		if(root==null)
			return 0;
		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);
		int leftDist = Math.max(getMaxDistanceRec(root.left),1+leftDepth);
		int rightDist = Math.max(getMaxDistanceRec(root.right),1+rightDepth);
		int length = Math.max(leftDist,rightDist);
		return Math.max(length,1+leftDepth+rightDepth);
	}
	public static int depth(TreeNode root){
		if(root==null)
			return 0;
		return 1+Math.max(depth(root.left),depth(root.right));
	}
	// 13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec
	public static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder){
		TreeNode root = null;  
        List<Integer> leftPreOrder;  
        List<Integer> rightPreOrder;  
        List<Integer> leftInorder;  
        List<Integer> rightInorder;  
        int inorderPos;  
        int preorderPos;  
   
        if ((preOrder.size() != 0) && (inOrder.size() != 0))  
        {  
            // 把preorder的第一个元素作为root  
            root = new TreeNode(preOrder.get(0));  
   
            //  Based upon the current node data seperate the traversals into leftPreorder, rightPreorder,  
            //  leftInorder, rightInorder lists  
            // 因为知道root节点了，所以根据root节点位置，把preorder，inorder分别划分为 root左侧 和 右侧 的两个子区间  
            inorderPos = inOrder.indexOf(preOrder.get(0));      // inorder序列的分割点  
            leftInorder = inOrder.subList(0, inorderPos);  
            rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());  
   
            preorderPos = leftInorder.size();                           // preorder序列的分割点  
            leftPreOrder = preOrder.subList(1, preorderPos + 1);  
            rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());  
   
            root.left = rebuildBinaryTreeRec(leftPreOrder, leftInorder);        // root的左子树就是preorder和inorder的左侧区间而形成的树  
            root.right = rebuildBinaryTreeRec(rightPreOrder, rightInorder); // root的右子树就是preorder和inorder的右侧区间而形成的树  
        }  
   
        return root; 
	}
	// 分层打印二叉树
	public static void levelPrint(TreeNode root){
		if(root==null)
			return ;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int currentLevelNodes = 1;      // 当前Level，node的数量  
        int nextLevelNodes = 0;         // 下一层Level，node的数量  
		TreeNode cursor = null;
		queue.add(root);
		while(!queue.isEmpty()){
			cursor = queue.poll();
			currentLevelNodes--;
			if(cursor == null){
				System.out.print("null ");
				continue;
			}
			else System.out.print(cursor.val+" ");
			if(cursor.left==null && cursor.right==null)
				continue;
			queue.add(cursor.left);
			queue.add(cursor.right);
			nextLevelNodes = nextLevelNodes + 2;
			if(currentLevelNodes==0){
				System.out.println("");
				currentLevelNodes = nextLevelNodes;
				nextLevelNodes = 0;
			}
		}
	}
	@Test
	public void testIsMirrorRec(){
		TreeNode root = new TreeNode(1);  
        TreeNode r2 = new TreeNode(2);  
        TreeNode r3 = new TreeNode(3);  
        TreeNode r4 = new TreeNode(4);  
        TreeNode r5 = new TreeNode(5);  
        TreeNode r6 = new TreeNode(6);       
        root.left = r2;  
        root.right = r3;  
        r2.left = r4;  
        r2.right = r5;  
        r3.right = r6;
        TreeNode root1 = new TreeNode(1);  
        TreeNode r21 = new TreeNode(2);  
        TreeNode r31 = new TreeNode(3);  
        TreeNode r41 = new TreeNode(4);  
        TreeNode r51 = new TreeNode(5);  
        TreeNode r61 = new TreeNode(6);
        root1.left = r31;
        root1.right = r21;
        r21.left = r51;
        r21.right = r41;
        r31.left =r61;
        System.out.println(isMirrorRec(root,root1));
        System.out.println(isSameRec(root,root1));
        System.out.println(isSameRec(root,root));
        levelPrint(root);
	}
			/* 
				    1  
				   / \  
				  2   3  
				 / \   \  
				4  5    6  
				
			*/
	@Test
	public void test(){
		TreeNode root = new TreeNode(1);  
        TreeNode r2 = new TreeNode(2);  
        TreeNode r3 = new TreeNode(3);  
        TreeNode r4 = new TreeNode(4);  
        TreeNode r5 = new TreeNode(5);  
        TreeNode r6 = new TreeNode(6);       
        root.left = r2;  
        root.right = r3;  
        r2.left = r4;  
        r2.right = r5;  
        r3.right = r6;
        System.out.println(getNodeNumRec(root));
        System.out.println(getNodeNum(root));
        System.out.println(getDepthRec(root));
        System.out.println(getDepth(root));
        System.out.println("前序遍历");
        preorderTraversalRec(root);
        System.out.println("");
        preorderTraversal(root);
        System.out.println("");
        System.out.println("中序遍历");
        inorderTraversalRec(root);
        System.out.println("");
        inorderTraversal(root);
        System.out.println("");
        System.out.println("后序遍历");
        postorderTraversalRec(root);
        System.out.println("");
        postorderTraversal(root);
        System.out.println("分层遍历");
        levelTraversal(root);
        System.out.println("");
        levelTraversalRec(root);
	}
	@Test
	public void testconvertBST(){
		TreeNode root = new TreeNode(5);  
        TreeNode r2 = new TreeNode(3);  
        TreeNode r3 = new TreeNode(7);  
        TreeNode r4 = new TreeNode(2);   
        TreeNode r5 = new TreeNode(4);
        root.left = r2;  
        root.right = r3;  
        r2.left = r4;  
        r2.right = r5;
        TreeNode result = null;
        convertBST2DLLRec(root,result);
        while(result!=null){
        	System.out.println(result.val);
        	result = result.right;
        }
	}
	@Test
	public void testCommomNode(){
		TreeNode root = new TreeNode(1);  
        TreeNode r2 = new TreeNode(2);  
        TreeNode r3 = new TreeNode(3);  
        TreeNode r4 = new TreeNode(4);  
        TreeNode r5 = new TreeNode(5);  
        TreeNode r6 = new TreeNode(6);       
        root.left = r2;  
        root.right = r3;  
        r2.left = r4;  
        r2.right = r5;  
        r3.right = r6;
        System.out.println(getNodeRec(root,r6));
        System.out.println(getCommomNodeRec(root,r4,r5).val);
        List<TreeNode> list = new LinkedList<TreeNode>();
        System.out.println(getNodeLink(root,r4,list));
        for(TreeNode node:list){
        	System.out.println(node.val);
        }System.out.println("---------------------------------");
        List<TreeNode> list2 = new LinkedList<TreeNode>();
        System.out.println(getNodeLink(root,r5,list2));
        for(TreeNode node:list2){
        	System.out.println(node.val);
        }
        System.out.println("---------------------------------");
        System.out.println(getCommomNode(root,r4,r5).val);
        System.out.println("---------------------------------");
        System.out.println(getMaxDistanceRec(root));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
