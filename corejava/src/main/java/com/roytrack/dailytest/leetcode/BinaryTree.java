package com.roytrack.dailytest.leetcode;

/**
 * a typically binary tree search . before middle after iterator
 * Created by roytrack on 2016-07-19.
 */
public class BinaryTree {
  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    TreeNode<String> node = binaryTree.init();
    System.out.println("先序遍历情况。。。");
    binaryTree.xianIterator(node);
    System.out.println("\n中序遍历情况。。。");
    binaryTree.zhongIterator(node);
    System.out.println("\n后序遍历情况。。。");
    binaryTree.houIterator(node);
  }

  public void printNode(TreeNode<String> node) {
    System.out.print(node.getData() + "  ");
  }

  public TreeNode<String> init() {
    TreeNode<String> D = new TreeNode<>("D", null, null);
    TreeNode<String> H = new TreeNode<>("H", null, null);
    TreeNode<String> I = new TreeNode<>("I", null, null);
    TreeNode<String> J = new TreeNode<>("J", null, null);
    TreeNode<String> P = new TreeNode<>("P", null, null);
    TreeNode<String> G = new TreeNode<>("G", P, null);
    TreeNode<String> F = new TreeNode<>("F", null, J);
    TreeNode<String> E = new TreeNode<>("E", H, I);
    TreeNode<String> B = new TreeNode<>("B", D, E);
    TreeNode<String> C = new TreeNode<>("C", F, G);
    TreeNode<String> A = new TreeNode<>("A", B, C);
    return A;
  }

  public void xianIterator(TreeNode<String> node) {
    this.printNode(node);
    if (node.getLeftNode() != null) {
      this.xianIterator(node.getLeftNode());
    }
    if (node.getRightNode() != null) {
      this.xianIterator(node.getRightNode());
    }
  }

  public void zhongIterator(TreeNode<String> node) {

    if (node.getLeftNode() != null) {
      this.zhongIterator(node.getLeftNode());
    }
    this.printNode(node);
    if (node.getRightNode() != null) {
      this.zhongIterator(node.getRightNode());
    }
  }

  public void houIterator(TreeNode<String> node) {
    if (node.getLeftNode() != null) {
      this.houIterator(node.getLeftNode());
    }
    if (node.getRightNode() != null) {
      this.houIterator(node.getRightNode());
    }
    this.printNode(node);
  }

  class TreeNode<T> {
    private T data;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    public TreeNode(T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
      this.data = data;
      this.leftNode = leftNode;
      this.rightNode = rightNode;
    }


    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public TreeNode<T> getLeftNode() {
      return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
      this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() {
      return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
      this.rightNode = rightNode;
    }
  }

}
