package my.search;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree_Algorithm {
	
	
	private Node root;
	public  boolean binarySearchTree(int value){
		if(root==null)
			return false;
		Node current = root;
		while(true){
			if(current.data<value){
				if(current.right==null)
					return false;
				else current = current.right;
			}else if(current.data==value){
				return true;
			}else{
				if(current.left==null)
					return false;
				else current = current.left;
			}
		}
	}
	public  Node bstCreat(int arr[]){
		for(int i=0;i<arr.length;i++)
			bstInsert(arr[i]);
		return root;
	}
	public void bstInsert(int value){
		Node node = new Node(value);
		if(root == null){
			root = node ;
			return;
		}
		Node current = root;
		while(true){
			if(current.data<value){
				if(current.right==null){
					current.right = new Node(value);
					return;
				}else{
					current = current.right;
				}
			}
			else if(current.data>value){
					if(current.left==null){
						current.left = new Node(value);
						return;
					}else{
						current = current.left;
					}
			}
		}
		
			
	}

	public  void bstDelete(){
		
	}
	
	//二叉树的先序遍历
	public static void preOrder(Node node){
		if(node==null)return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	//二叉树的中序遍历
	public static void midOrder(Node node){
		if(node!=null){
			midOrder(node.left);
			System.out.print(node.data+" ");
			midOrder(node.right);
		}
		
	}
	//二叉树的后序遍历
	public static void postOrder(Node node){
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data+" ");
		}
	}
	public static void levelOrder(Node node){
		Queue<Node> queue = new LinkedList<Node>();
		Node newNode = null;
		queue.add(node);
		while(!queue.isEmpty()){
			newNode= queue.poll();
			if(newNode.left!=null)
				queue.add(newNode.left);
			if(newNode.right!=null)
				queue.add(newNode.right);
			System.out.print(newNode.data+" ");
		}
	}
	public static void main(String[] args) {
		int arr[] = {4, 5, 2, 1, 0, 9, 3, 7, 6, 8};
		BinarySearchTree_Algorithm b = new BinarySearchTree_Algorithm();
		Node node = b.bstCreat(arr);
		
		preOrder(node);
		System.out.println("\n");
		midOrder(node);
		System.out.println("\n");
		postOrder(node);
		System.out.println("\n");
		levelOrder(node);
		System.out.println("\n");
		System.out.println(b.binarySearchTree(11));
		
	}

}


//public  Node bstCreat2(int arr[]){
//Node root = new Node(arr[0]);
//for(int i=1;i<arr.length;i++)
//	bstInsert2(root,arr[i]);
//return root;
//}
//public void bstInsert2(Node root,int value){
//if(root==null){
//	root = new Node(value);
//	return ;
//}
//
//if(root.data>value)
//	bstInsert2(root.left,value);
//else 
//	bstInsert2(root.right,value);
//}
