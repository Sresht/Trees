import java.util.*;
import java.io.*;

public class BSTiterative{

	/*
		Binary Search Tree (Iterative)
		Key properties: - left subtree is always lesser than the parent
						- right subtree is always greater than the parent
						- no duplicate nodes

		Iterative Insertion:    - 1. Compare the node you want to insert with root
								- 2. If it is greater than the root, go to the right subtree
								- 3. If it is lesser than the root, go to the left subtree
								- 4. Compare to the root of the subtree and repeat steps 2,3,1
								- 5. Insert



	*/


	//GROUNDWORK
	class Node{                   //Nodes are part of tree
		Node leftChild;			  //node can have a left child	
		Node rightChild;		  //node can have a right child	
		int item;				  //node needs item	
  
		Node(int item){           //constructor to create node
			this.leftChild=null;  //left child is set to null
			this.rightChild=null; //right child is set to null
			this.item=item;       //insert item into node
		}

	}

	public Node root; //root is declared and automatically empty

	public BSTiterative(){ //constructor that is used to declare a Tree
		this.root = null; //when Tree is created, root will be automatically set to null
	}


	//FUNCTIONS

	public void insertIter(int item){ //this method inserts into the tree iteratively and takes in the integer as a parameter
		Node n = new Node(item); //integer is now inserted in node n 
		boolean checkTree = true; //this flag checks the tree to see if its empty or not
		//Check if root is empty
		if(root==null){
			root = n; //left child and right child are automatically set to null
			checkTree = false; //function is done running
		}

		if(checkTree == true){ 
			//If you reach here, that means root is not empty and tree has nodes inside of it
			Node currentNode = root; //this pointer starts at the root and will eventually keep changing while we traverse the tree
			Node parentOfCurrentNode = null; //this pointer keeps track of the PARENT of the currentNode (so basically the node behind it)
			//we need the parentOfCurrentNode so that we can easily assign children

			while(currentNode != null){ //when currentNode does EVENTUALLY reach null, that means we know where to insert using the 2 pointers
				parentOfCurrentNode = currentNode; //we assign parent to current because we can keep track of Node before it before it reaches null
				//compare the integer we are trying to insert with the currentNode, if the integer is greater: go right, if the integer is smaller, go left
				if(item > currentNode.item){ 
					currentNode = currentNode.rightChild; //since the integer we are trying to insert is greater, we visit the right child and make that our current node
				}else{
					currentNode = currentNode.leftChild; //since the integer we are trying to insert is less, we visit the left child and make that our current node
				}
			}
			//now that the loop above is complete, currentNode is null and we have tracked the node before it with the parentOfCurrentNode node
			//now we have to insert into the tree
			if(item > parentOfCurrentNode.item){ //compare the integer to the node before the null
				parentOfCurrentNode.rightChild= n; //since the integer is greater than the node, we assign the integer as the left child
			}else{
				parentOfCurrentNode.leftChild = n; //since the integer is less than the parent node, we assign the integer as the left child
			}
		}
			
	}

	// HELPER

	//Inorder traversal: left subtree is explored first, then the root, and then right subtree and we can do this recursively
	//good explanation: https://dev.to/javinpaul/how-to-implement-inorder-traversal-in-a-binary-search-tree-1787

	//IMPORTANT: with Binary Search Tree, an Inorder Traversal will always print least to greatest because it goes from left most subtree to right most subtree
	//This also means we can use this to find the max and min item of a tree and this also works with Sort();
	static void inOrderTraversal(Node node){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		if(node != null){
			inOrderTraversal(node.leftChild);
			//System.out.println(node.item);
			arr.add(node.item);
			inOrderTraversal(node.rightChild);
		}

		for(int i = 0; i<arr.size(); i++){
			System.out.println(arr.get(i));
		}
	}


	//need to print out BST
	static ArrayList<Integer> printBST(BSTiterative tree){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//arr.add(inOrderTraversal(tree.root));
		for(int i = 0; i<arr.size(); i++){
			System.out.println(arr.get(i));
		}
		return arr;
	}





	//MAIN

	public static void main(String[] args){
		BSTiterative Tree = new BSTiterative();
		Tree.insertIter(10);
		Tree.insertIter(5);
		Tree.insertIter(20);
		Tree.insertIter(7);
		Tree.insertIter(19);
		inOrderTraversal(Tree.root);
	}

	

}