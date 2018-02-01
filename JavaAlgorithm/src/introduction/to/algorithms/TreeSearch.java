package introduction.to.algorithms;



public class TreeSearch {
	// 二叉搜索树
	public static class TreeNode {  
        int val; 
        TreeNode parent;
        TreeNode left;  
        TreeNode right;  
        public TreeNode(int val) {  
            this.val = val;  
        }  
    } 
	// 二叉树的查找(递归实现)
	public static TreeNode treeSearch(TreeNode root, int value){
		if(root==null)
			return root;
		if(root.val == value)
			return root;
		if(root.val > value)
			return treeSearch(root.left,value);
		else return treeSearch(root.right,value);
	}
	// 二叉树的查找(非递归实现)
	public static TreeNode treeSearch2(TreeNode root, int value){
		TreeNode cursor = root;
		while(cursor!=null && cursor.val != value){
			if(cursor.val > value)
				cursor = cursor.left;
			else cursor = cursor.right;
		}
		return cursor;
	}
	// 二叉排序树的最小键值节点
	public static TreeNode minIMum(TreeNode root){
		if(root==null)
			System.out.println("the tree is empty");
		TreeNode cursor = root;
		while(cursor.left!=null)
			cursor = cursor.left;
		return cursor;
	}
	// 二叉排序树的最大键值节点
	public static TreeNode maxIMum(TreeNode root){
		if(root==null)
			System.out.println("the tree is empty");
		TreeNode cursor = root;
		while(cursor.right!=null)
			cursor = cursor.right;
		return cursor;
	}
	// 二叉排序树的中序遍历
	public static void inorderTreeWalk(TreeNode root){
		if(root==null)
			return ;
		inorderTreeWalk(root.left);
		System.out.print(root.val+" ");
		inorderTreeWalk(root.right);
	}
	// 二叉排序树的后继结点,一个结点x的后继是大于x.key的最小关键字的结点. 分为两种情况：如果结点x的右子树非空,那么x的后继恰是x右子树最左结点;
	// 如果结点x的右子树为空并且有一个后继结点y,那么y就是x的最低层祖先,并且y的左子树也是x的一个祖先
	public static TreeNode treeSuccessor(TreeNode root,TreeNode currentNode){
		if(currentNode == null)
			return null;
		if(currentNode.right!=null)
			return minIMum(currentNode.right);
		TreeNode parent = currentNode.parent;
		while( parent!=null && parent.right == currentNode){
			currentNode = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	// 二叉排序树的结点的插入
	public static void treeInsert(TreeNode root,TreeNode newNode){
		TreeNode cursor = root;
		TreeNode flag = null;
		while(cursor !=null ){
			flag = cursor;
			if(newNode.val > cursor.val)
				cursor = cursor.right;
			else cursor = cursor.left;
		}
		newNode.parent = flag;
		if(flag == null)
			root = newNode;
		else{
			if(flag.val > newNode.val)
				flag.left = newNode;
			else flag.right = newNode;
		}
	}
	// 二叉排序树的结点的删除
	public static void treeDelete(TreeNode root,TreeNode newNode){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
