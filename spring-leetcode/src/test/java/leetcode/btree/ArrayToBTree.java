package leetcode.btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * @author xpengfei
 * @creat 10:04:02 AM Sep 1, 2017
 */
/*
 * 将数组转换为二叉树,并实现对其遍历 广度优先遍历 深度优先遍历 先序遍历、中序遍历、后序遍历
 * 
 * 构造的二叉树： 1 2 3 4 5 6 7 8 9 先序遍历：DLR 1 2 4 8 9 5 3 6 7 中序遍历：LDR 8 4 2 9 5 1 6 3
 * 7 后序遍历：LRD 8 9 4 5 2 6 7 3 1
 * 
 * 深度优先遍历 1 2 4 8 9 5 3 6 7 广度优先遍历 1 2 3 4 5 6 7 8 9
 */
public class ArrayToBTree {
	// 定义将要被转化的数组
//  private static List<Integer>array=new ArrayList();
	private static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// 定义list存储节点
	private static List<Node> nodelist = null;

	// 定义内部节点类
	class Node {
		Node lchild = null;// 定义左孩子
		Node rchild = null;// 定义右孩子
		int data; // 节点存储的数据
		// 构造函数,创建节点

		Node() {
		}

		Node(int data) {
			this.data = data;
		}
	}

	/*
	 * 创建二叉树的函数createTree
	 */
	public void createTree() {
		// 首先将数组以节点的形式存到nodelist中,使用LinkedList的原因:LinkedList可以用作栈、队列，插入删除比较便利
		nodelist = new LinkedList<Node>();
		for (int i = 0; i < array.length; i++) {
			nodelist.add(new Node(array[i]));
		}
		/*
		 * 其次按照数组转化为二叉树时节点之间的数字关系构造二叉树,根节点为0
		 * 最后一个父节点(lastParentNode=array.length/2-1;)有可能不存在右孩子,所以要单独分析
		 */
		int lastParentNode = array.length / 2 - 1; // 得到最后一个父节点的数组下标
//      构建前lastParentNode-1个父节点的二叉树关系
		for (int parentIndex = 0; parentIndex < lastParentNode; parentIndex++) {
//          构造左孩子
			nodelist.get(parentIndex).lchild = nodelist.get(parentIndex * 2 + 1);
//          构造右孩子
			nodelist.get(parentIndex).rchild = nodelist.get(parentIndex * 2 + 2);
		}
//      构造最后一个父节点的孩纸
//      左孩子
		nodelist.get(lastParentNode).lchild = nodelist.get(lastParentNode * 2 + 1);
//      右孩子,如果数组长度为奇数则存在右孩子,否则不存在右孩子
		if (array.length % 2 == 1) {
			nodelist.get(lastParentNode).rchild = nodelist.get(lastParentNode * 2 + 2);
		}
	}

	/**
	 * 先序遍历
	 * 
	 * @param node
	 */
	public void preOrderTraverse(Node node) {
		if (node == null) {
//          System.out.println("树为空!");
			return;
		}
		System.out.print(node.data + "\t");
		preOrderTraverse(node.lchild);
		preOrderTraverse(node.rchild);
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */
	public void midOrderTraverse(Node node) {
		if (node == null) {
//          System.out.println("树为空!");
			return;
		}
		midOrderTraverse(node.lchild);
		System.out.print(node.data + "\t");
		midOrderTraverse(node.rchild);
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 */
	public void lastOrderTraverse(Node node) {
		if (node == null) {
//          System.out.println("树为空!");
			return;
		}
		lastOrderTraverse(node.lchild);
		lastOrderTraverse(node.rchild);
		System.out.print(node.data + "\t");
	}

	/**
	 * 广度优先遍历即层次遍历 使用队列 广度优先遍历 1 2 3 4 5 6 7 8 9  DFS
	 * 
	 * @param root 根节点
	 */
//  public static void visitNode(Node node){
//      System.out.println(node.data+"\t");
//  }
	public void widthOrderTraverse(Node root) {
		if (root == null) {
			System.out.println("树为空!");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root); // 将节点插入到队尾
		System.out.println("广度优先遍历:");
		while (!queue.isEmpty()) { // 队不为空时一直循环遍历
			Node firstNode = queue.poll(); // 移除并返回队头节点
			System.out.print(firstNode.data + "\t");
			if (firstNode.lchild != null)
				queue.offer(firstNode.lchild); // 左孩子入队
			if (firstNode.rchild != null)
				queue.offer(firstNode.rchild); // 右孩子入队
		}
		System.out.println();
	}

	/**
	 * 深度优先遍历类似于先序遍历 使用栈 深度优先遍历 1 2 4 8 9 5 3 6 7
	 * 
	 * @param root
	 */
	public void depthOrderTraverse(Node root) {
		Stack<Node> stack = new Stack<Node>(); // 定义栈
		if (root == null) {
			System.out.println("树为空!");
			return;
		}
		stack.push(root); // 根节点入栈
		System.out.println("深度优先遍历:");
		while (stack.isEmpty() == false) { // 栈不为空,则一直循环
			Node node = stack.pop(); // 取出栈顶元素
			System.out.print(node.data + "\t");
			if (node.rchild != null)
				stack.push(node.rchild); // 右孩子入栈
			if (node.lchild != null)
				stack.push(node.lchild); // 左孩子入栈
		}
		System.out.println();
	}

	@Test
	public void Test() {
		ArrayToBTree array_To_BTree = new ArrayToBTree();
//      array_To_BTree.getArray();
		array_To_BTree.createTree();
//      获取根节点
		Node root = nodelist.get(0);
		System.out.println("先序遍历:");
		array_To_BTree.preOrderTraverse(root);
		System.out.println();
		System.out.println("中序遍历:");
		array_To_BTree.midOrderTraverse(root);
		System.out.println();
		System.out.println("后序遍历:");
		array_To_BTree.lastOrderTraverse(root);
		System.out.println();
		array_To_BTree.widthOrderTraverse(root);
		array_To_BTree.depthOrderTraverse(root);
	}

}
