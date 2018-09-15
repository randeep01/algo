package org.saggu.tree;

import org.saggu.ll.*;

public class Tree<T> {

	TreeNode<T> root = null;

	private int heightUtil(TreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		int lHeight = heightUtil(node.left);
		int rHeight = heightUtil(node.right);
		if (lHeight > rHeight) {
			return lHeight + 1;
		} else
			return rHeight + 1;
	}

	public int height() {
		return heightUtil(root);
	}

	public void printLevelOrder() {
		int h = height();

		for (int i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	private void printGivenLevel(TreeNode<T> root2, int level) {
		// TODO Auto-generated method stub
		if (root2 == null) {
			return;
		} else if (level == 1) {
			System.out.print(root2.data + " ");
		} else if (level > 1) {
			System.out.println("");
			printGivenLevel(root2.left, level - 1);
			printGivenLevel(root2.right, level - 1);
		}

	}

	/*
	 * method to insert node at last position available
	 */
	public void insertAtLast(T data) {
		if (root == null) {
			root = new TreeNode<T>(data);
			return;
		}

		Queue<TreeNode<T>> queue = new Queue<>();
		queue.enque(root);

		TreeNode<T> temp = null;
		while ((temp = queue.deque()) != null) {
			if (temp.left == null) {
				temp.left = new TreeNode<T>(data);
				break;
			} else {
				queue.enque(temp.left);
			}
			if (temp.right == null) {
				temp.right = new TreeNode<T>(data);
				break;
			} else {
				queue.enque(temp.right);
			}

		}

	}

	public static void main(String args[]) {

		Tree<Integer> tree = new Tree<>();
		tree.root = new TreeNode<>(1);
		tree.root.left = new TreeNode<>(2);
		tree.root.right = new TreeNode<>(3);
		tree.root.left.left = new TreeNode<>(4);
		tree.root.left.right = new TreeNode<>(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();

	}
}
