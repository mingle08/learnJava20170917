package algoDemo.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	private TreeNode root = null;
	
	public BinaryTree() {
		root = new TreeNode(1,"A");
	}
	
	/**
	 * 构建二叉树
	 * 			A
	 *      B        C
	 *  D       E         F
	 */
	public void createBinaryTree() {
		TreeNode nodeB = new TreeNode(2,"B");
		TreeNode nodeC = new TreeNode(3,"C");
		TreeNode nodeD = new TreeNode(4,"D");
		TreeNode nodeE = new TreeNode(5,"E");
		TreeNode nodeF = new TreeNode(6,"F");
		root.leftChild = nodeB;
		root.rightChild = nodeC;
		nodeB.leftChild = nodeD;
		nodeB.rightChild = nodeE;
		nodeC.rightChild = nodeF;
	}
	
	/**
	 * 获取树的高度
	 * @return
	 */
	public int getHeight() {
		return getHeight(root);
	}
	
	private int getHeight(TreeNode node) {
		if(node == null) {
			return 0;
		}else {
			int i = getHeight(node.leftChild);
			int j = getHeight(node.rightChild);
			return (i<j) ? j+1 : i+1;
		}
	}
	
	/**
	 * 获取二叉树的结点数
	 */
	public int getSize() {
		return getSize(root);
	}
	
	private int getSize(TreeNode node) {
		if(node == null) {
			return 0;
		}else {
			return 1 + getSize(node.leftChild) + getSize(node.rightChild);
		}
	}
	
	/**
	 * 前序遍历：迭代
	 */
	public void preOrder(TreeNode node) {
		if(node == null) {
			return;
		}else {
			System.out.println("preOrder data: " + node.getData());
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	
	/**
	 * 中序遍历：迭代
	 */
	public void midOrder(TreeNode node) {
		if(node == null) {
			return;
		}else {
			midOrder(node.leftChild);
			System.out.println("midOrder data: " + node.getData());
			midOrder(node.rightChild);
		}
	}
	
	/**
	 * 后序遍历：迭代
	 */
	public void postOrder(TreeNode node) {
		if(node == null) {
			return;
		}else {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.println("postOrder data: " + node.getData());
		}
	}
	
	
	// 前序  非递归
    public void preOrderTraversal(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0){
            // 将所有左孩子压栈
            if (node != null){
                printTreeNode(node);    // 访问
                stack.push(node);    // 压栈
                node = node.left;
            } else {
                node = stack.pop();    // 出栈
                node = node.right;
            }
        }
    }

    // 中序  非递归
    public void inOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0){
            if (node != null){
                stack.push(node);  // 压栈
                node = node.left;
            } else {
                node = stack.pop();  // 出栈
                printTreeNode(node);  // 访问
                node = node.right;
            }
        }
    }

    // 后序  非递归
    public void nonRecPostOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();  //按出栈顺序将元素装入此栈中
        TreeNode node = root;
        while(node != null || stack.size()>0){
            if(node != null){
                output.push(node);
                stack.push(node);    // 压栈
                node = node.right;
            }else{
                node = stack.pop();  // 出栈
                node = node.left;
            }
        }

        // 访问
        while(output.size()>0){
            TreeNode out = output.pop();
            System.out.print(out.val + " ");
        }
    }
	
	
	
	/**
	 * ͨ构建二叉树
	 * 				  A
	 *          B            C
	 *     D        E   #           F
	 *  #     #  #     #        #       #   
	 *  
	 *  ABD##E##C#F##
	 */
	public void createBinaryTreePre(ArrayList<String> data) {
		createBinaryTree(data.size(), data);
	}

	private TreeNode createBinaryTree(int size, ArrayList<String> data) {
		if(data.size() == 0) {
			return null;
		}
		String d = data.get(0);
		TreeNode node;
		int index = size - data.size();
		if(d.equals("#")) {
			node = null;
			data.remove(0);
			return node;
		}
		node = new TreeNode(index,d);
		if(index == 0) {
			// 根结点
			root = node;
		}
		data.remove(0);
		node.leftChild = createBinaryTree(size, data);
		node.rightChild = createBinaryTree(size, data);
		
		return node;
	}

	/**
	 * 树结点
	 * @author huxm
	 *
	 * @param <T>
	 */
	public class TreeNode<T>{
		private int index;
		private T data;
		private TreeNode leftChild;
		private TreeNode rightChild;
		public TreeNode(int index, T data) {
			this.index = index;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		
		
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
//		int height = bt.getHeight();
//		System.out.println("treeHeight: " + height);
//		int num = bt.getSize();
//		System.out.println("�������" + num);
//		bt.preOrder(bt.root);
//		System.out.println("====================");
//		bt.midOrder(bt.root);
//		System.out.println("====================");
//		bt.postOrder(bt.root);
//		bt.nonRecPreOrder(bt.root);
//		bt.nonRecMidOrder(bt.root);
		/*
		String[] dataArray = {"A","B","D","#","#","E","#","#","C","#","F","#","#"};
		ArrayList<String> data = new ArrayList<>();
		for(String str : dataArray) {
			data.add(str);
		}
		bt.createBinaryTreePre(data);*/
		bt.nonRecPreOrder(bt.root);
		bt.midOrder(bt.root);
//		bt.nonRecMidOrder(bt.root);
//		bt.nonRecPostOrder(bt.root);
	}
	
}
