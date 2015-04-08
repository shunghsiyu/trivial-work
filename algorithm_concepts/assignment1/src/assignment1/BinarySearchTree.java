package assignment1;

public class BinarySearchTree {
  private Node root;

   public BinarySearchTree() { 
   this.root=null;
   }  
   public void insert(int value){
    root=insert(root,value);
 }
   
public class Node
   {
      public int value;
      public Node right;
      public Node left;
      
  public Node(int value){
  this.value=value;
  this.right=null;
  this.left=null;
  }
      }

 public Node insert(Node treeNode,int value){
if(treeNode==null){
    treeNode=new Node(value);
}
else{
    if(value>=treeNode.value){
        treeNode.right=insert(treeNode.right,value);
        }
    else{
        treeNode.left=insert(treeNode.left,value);
    }
}
return treeNode;
 }
 
     
 
 
public boolean find(int value){
   Node findTreeNode=root;
   if(findTreeNode.value==value){
       return true;
 }
 else{
       if(value>findTreeNode.value){
           findTreeNode=findTreeNode.right;
           return true;
       }
       else{
           findTreeNode=findTreeNode.left;
           return true;
       }
   } 
 }

}
