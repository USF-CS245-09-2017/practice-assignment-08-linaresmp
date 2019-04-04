
//Maria Paula Linares 
import java.util.*;


public class BST<T extends Comparable<T>>{

	private BSTNode root; //private instance Node root 
	

	//BST constructor 
	public BST(){			
		root =null; 		//sets root equal to null 
	}


								
	public void insert(Comparable value){ //passing a comparable value and calling the recursive function insert  
		root = insert(root, value);
	}


	//
	private BSTNode insert(BSTNode node, Comparable value){ //passing in a node and a comparable value object
		if(node == null){
			BSTNode newnode = new BSTNode(value);					//returns the newnode 
			return newnode;
		}else if(node.data.compareTo(value) < 0){
			node.right = insert(node.right, value);
			return node;											//inserts the value on the right node

		}else{
			node.left = insert(node.left, value);					// inserts the value on the left node
			return node;
		}

		
	}

	public boolean find(Comparable value){		//passing in an Comparable object
		return ifind(root, value);				//calls ifind, a recursive function


	}

	public boolean ifind(BSTNode node, Comparable value){ //  passing in a node and a Comporable
		while(node!= null ){
			if(node.data.compareTo(value) == 0){		//compares node to value 
				return true;							//returning true if it equals 0
			}else if(node.data.compareTo(value) >0){	// uses compareTo to compare value and data in node 
				return ifind(node.left, value);
			}else{
				return ifind(node.right, value);			// returns the ifind function recursively 
			}
	
		}
		return false;
	}

	// print function
	// calls private print function
	public void print(){
		print(root);    
	}

	private void print(BSTNode node){   //printing the node
		if (node!= null){
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}

	//remove function
	//calls delete function recursively 

	public void delete(Comparable value){ 	
		root = delete(value, root);
	}

	// takes in a Comparable and a Node value and deletes the node given
	//returns node
	protected BSTNode delete(Comparable value, BSTNode n){
		if( n == null){
			throw new RuntimeException("Item not found");

		}else if(value.compareTo(n.data) < 0){
			n.left = delete(value, n.left);
		}else if(value.compareTo(n.data) > 0){
			n.right = delete(value, n.right);
		}else{
			if(n.left == null){
				return n.right; 
			}if(n.right == null){
				return n.left; 
		
			}
		}
		return n;
	}


	private class BSTNode{
		//Constructor for Node
		// It is a node of Comparable 
		BSTNode(Comparable theElement){
			data = theElement;
			left = right = null;
		}

		Comparable data;
		BSTNode left; 
		BSTNode right;
	}


		
}