package introduction.to.algorithms;



public class TreeSearch {
	// ����������
	public static class TreeNode {  
        int val; 
        TreeNode parent;
        TreeNode left;  
        TreeNode right;  
        public TreeNode(int val) {  
            this.val = val;  
        }  
    } 
	// �������Ĳ���(�ݹ�ʵ��)
	public static TreeNode treeSearch(TreeNode root, int value){
		if(root==null)
			return root;
		if(root.val == value)
			return root;
		if(root.val > value)
			return treeSearch(root.left,value);
		else return treeSearch(root.right,value);
	}
	// �������Ĳ���(�ǵݹ�ʵ��)
	public static TreeNode treeSearch2(TreeNode root, int value){
		TreeNode cursor = root;
		while(cursor!=null && cursor.val != value){
			if(cursor.val > value)
				cursor = cursor.left;
			else cursor = cursor.right;
		}
		return cursor;
	}
	// ��������������С��ֵ�ڵ�
	public static TreeNode minIMum(TreeNode root){
		if(root==null)
			System.out.println("the tree is empty");
		TreeNode cursor = root;
		while(cursor.left!=null)
			cursor = cursor.left;
		return cursor;
	}
	// ����������������ֵ�ڵ�
	public static TreeNode maxIMum(TreeNode root){
		if(root==null)
			System.out.println("the tree is empty");
		TreeNode cursor = root;
		while(cursor.right!=null)
			cursor = cursor.right;
		return cursor;
	}
	// �������������������
	public static void inorderTreeWalk(TreeNode root){
		if(root==null)
			return ;
		inorderTreeWalk(root.left);
		System.out.print(root.val+" ");
		inorderTreeWalk(root.right);
	}
	// �����������ĺ�̽��,һ�����x�ĺ���Ǵ���x.key����С�ؼ��ֵĽ��. ��Ϊ���������������x���������ǿ�,��ôx�ĺ��ǡ��x������������;
	// ������x��������Ϊ�ղ�����һ����̽��y,��ôy����x����Ͳ�����,����y��������Ҳ��x��һ������
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
	
	// �����������Ľ��Ĳ���
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
	// �����������Ľ���ɾ��
	public static void treeDelete(TreeNode root,TreeNode newNode){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
