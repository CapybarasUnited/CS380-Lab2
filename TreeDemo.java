class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

   public String toString() {
      return String.valueOf(value);
   }

}

class BinarySearchTree{

   Node root;
   
   public Node insert(int value) {
      if(this.root == null) {
         this.root = new Node(value);
         return this.root;
      }

      return insert(this.root, value);
   }

   /*
   recursive insert method
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
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      if(root == null) {
         return;
      }

      System.out.println(root);
      inOrderTraversal(root.left);
      inOrderTraversal(root.right);
      return;
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      if(root == null) {
         return;
      }

      inOrderTraversal(root.left);
      System.out.println(root);
      inOrderTraversal(root.right);
      return;

   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //implement me
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  //implement me
      return false;           
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      return -1;
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  return -1;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
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



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
      
      System.out.println("pre-order:");
      t1.preOrderTraversal(t1.root);
      System.out.println();
      
      System.out.println("in-order:");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}