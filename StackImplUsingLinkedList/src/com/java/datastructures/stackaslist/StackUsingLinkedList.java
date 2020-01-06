package com.java.datastructures.stackaslist;

import java.util.EmptyStackException;

/**
 * Using LinkedList to implement a stack we have two options:
	-	we can insert / delete from end (tail) of linkedlist
	-	at the begining of the list (head)
	
 * But inserting a node at the end of a linked list is not a constant time operation. The cost of both inserting and 
 * deletion at the end of linked list, if we have to talk about the time complexity of it is O(n). Here in the definition 
 * of stack we are saying that push and pop operations should take constant time or the time complexity should be O(1). 
 * But if we insert or delete from end time complexity would O(n). To insert a new node in a linked list at the end, 
 * we need to go to the last node set the address part of that node to make it point to the new node. 

 * To traverse a linked list and go to the last node we should start at the head or the first node, from first node we get
 * the address of the second node, so we go to the second node and from second node we get the address of the third node and so on.  

 * All in all this operation will take time proportional to number of elements in the linked list. To delete a node from end, 
 * once again we will have to traverse the whole list. Once again the cost of the traversal will be O(n). 
 * So inserting and deleting at end or is costlier and will take O(n).

 * The cost of  inserting or deleting from beginning however is O(1). It will take constant time to insert a node at beginning
 * or delete a node from beginning.

 * Source: https://www.youtube.com/watch?v=MuwxQ2IB8lQ
 * 		   https://www.youtube.com/watch?v=Us4N22SEbM0
 * 
 * @author C5258401
 *
 */
public class StackUsingLinkedList {
	
	private ListNode top;
	private int length;
	
	private class ListNode {
		
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public StackUsingLinkedList() {
		this.top = null;
		this.length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void push(int data) {
		ListNode temp = new ListNode(data);
		temp.next = top;
		top = temp;
		length++;
	}
	
	public int pop() {
		
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		int result = top.data;
		top = top.next;
		length--;
		
		return result;
	}
	
	public int peek() {
		
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	public void print() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		ListNode temp = top;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println(temp);
	}
}
