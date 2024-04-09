/**
 * Node class to represent nodes in a binary search tree(BST).
 */
class Node{
   int value;
   Node left, right;
   
   /**
    * Node constructor that takes an integer and assigns it to the node's value.
    * @param value value to assign to the node.
    */
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

   /**
    * Overridden toString method to make printing the results of the methods easier.
    */
   public String toString() {
      return String.valueOf(value);
   }

}

/**
 * Binary search tree(BST) class that contains a pointer to the root of a Node BST.
 */
class BinarySearchTree{

   Node root;
   
   /**
    * Single input version of insert that calls the two input version.
    * @param value Value of the node to be inserted.
    * @return A refrence to the node inserted into the BST.
    */
   public Node insert(int value) {
      //if the BST is empty, we need to create a root node
      if(this.root == null) {
         this.root = new Node(value);
         return this.root;
      }

      //if its not empty, call insert with the root of the BST
      return insert(this.root, value);
   }

   /**
    * Two input insert method that inserts a new node into the BST.
    * @param root The root of the tree to insert into. this is used in the recursive call.
    * @param value Value of the node to be inserted.
    * @return A refrence to the node that was inserted.
    */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   /**
    * Void pre-order traversal method that prints a BST in pre-order.
    * @param root Root node of the tree to be traversed. 
    */
   public void preOrderTraversal(Node root){
      //base case
      if(root == null) {
         return;
      }

      System.out.println(root);
      //recursive step
      inOrderTraversal(root.left);
      inOrderTraversal(root.right);
      return;
   }
   
   /**
    * Void in-order traversal method that prints a BST in-order.
    * @param root Root node of the tree to be traversed. 
    */
   public void inOrderTraversal(Node root){
      //base case
      if(root == null) {
         return;
      }

      //recursive step
      inOrderTraversal(root.left);
      System.out.println(root);
      inOrderTraversal(root.right);
      return;

   }
   
   /**
    * Void post-order traversal method that prints a BST in post-order.
    * @param root Root node of the tree to be traversed. 
    */
   public void postOrderTraversal(Node root){
      //base case
      if(root == null) {
         return;
      }

      //recursive step
      inOrderTraversal(root.left);
      inOrderTraversal(root.right);
      System.out.println(root);
      return;   
   }
   
   /**
    * Find method that traverses a BST to find a given node using its value.
    * @param root The root of the BST to be searched.
    * @param key The integer value of the desired roots value
    * @return The desired node, or null if it wasn't found.
    */
   public Node find(Node root, int key){
      //base case (out of nodes to search)
      if(root == null) {
         return null;
      }
      
      //base case (desired node is found)
      else if(root.value == key) {
         return root;
      }

      //recursive step
      if(root.value > key) {
         return find(root.left, key);
      }
      else {
         return find(root.right, key);
      }
   }
   
   /**
    * Method to get the minimum value stored in a BST. Assumes the BST is not empty.
    * @param root The root of the BST to find the minimum of.
    * @return The minimum integer value of the BST.
    */
   public int getMin(Node root){
      //base case
      if(root.left == null) {
         return root.value;
      }

      //recursive step
      return getMin(root.left);
   }
   
   /**
    * Method to get the maximum value stored in a BST. Assumes the BST is not empty.
    * @param root The root of the BST to find the maximum of.
    * @return The maximum integer value of the BST.
    */
   public int getMax(Node root){
      //base case
      if(root.right == null) {
         return root.value;
      }

      //recursive step
      return getMax(root.right);
   }
   
   /**
    * Method to delete a node contained in a BST.
    * @param root Root node of the BST to delete from.
    * @param key The integer value of the node to be deleted from the BST.
    * @return The root of the BST that was deleted from.
    */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   } 
}

/**
 * TreeDemo class used to demonstrate the implemented methods of the BinarySearchTree class.
 */
public class TreeDemo{

   /**
    * Main method of the TreeDemo class.
    * @param args Command line arguments.
    */
   public static void main(String[] args){
      //set up BST
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
      
      //demonstrate pre-order traversal
      System.out.println("CS380 Lab2: Working with git:\n\npre-order:");
      t1.preOrderTraversal(t1.root);
      System.out.println();
      
      //demonstrate in-order traversal
      System.out.println("in-order:");
      t1.inOrderTraversal(t1.root);
      System.out.println();

      //demonstrate post-order traversal
      System.out.println("post-order:");
      t1.postOrderTraversal(t1.root);
      System.out.println();

      //demonstrate getMin() method
      System.out.printf("getMin: %d\n", t1.getMin(t1.root));

      //demonstrate getMax() method
      System.out.printf("\ngetMax: %d\n", t1.getMax(t1.root));

      //demonstrate find() and delete() methods
      System.out.printf("\nfind(18): %s\n", t1.find(t1.root, 18));
      System.out.printf("delete(18): %s\n", t1.delete(t1.root, 18));
      System.out.printf("find(18): %s\n", t1.find(t1.root, 18));      
   }  
}