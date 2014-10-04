package assignment1;

class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		val=x;
		next=null;
	}
}

public class LinkedList {
	ListNode dummy=new ListNode(0);
	ListNode node=dummy;
	
	public void insert(int val){
		//insert from the end,too slow
	/*	node=dummy;
		while(node.next!=null){
			if(node.next.val==val)
				;
			node=node.next;
		}
		node.next=new ListNode(val);*/
		
		
		node=dummy;
		while(node.next!=null){
			if(find(val))
				;
			ListNode newNode=new ListNode(val);
			newNode.next=node.next;
			node.next=newNode;
			
		}
		node=new ListNode(val);
		}
	
	
	public boolean find(int val){
		node=dummy;
		while(node.next!=null){
			if(node.next.val==val){
				return true;
         			}
			node=node.next;
		}
		return false;
	}
}
