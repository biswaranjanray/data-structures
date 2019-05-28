package com.java.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Linked list a data structure used for storing collection of elements or objects or nodes having below properties:
		-	It contains sequence of nodes.
		-	a node has data and reference to next node.
		-	first node is the head node.
		-	last node has data and points to null.
		
 * @author C5258401
 *
 */

public class SinglyLinkedList {

	//private ListNode head; //Head node to hold the list
	//It contains a static inner class ListNode
		private static class ListNode {
			private int data;
			private ListNode next;
			
			public ListNode(int node) {
				this.data = node;
				this.next = null;
			}
		}
	
	/**
	 * To print a singly linked list
	 * 
	 * @param head
	 */
	public void display(ListNode head) {
		if(head == null) {
			return;
		}
		
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.print(current);
	}
	
	
	/**
	 * To find the size of a singly linked list
	 * 
	 * @param head
	 * @return
	 */
	public int size(ListNode head) {
		if(head == null)
			return 0;
		
		ListNode current = head;
		int count = 0;
		
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	/**
	 * To add a node at the head of a singly linked list
	 * 
	 * @param head
	 * @param data
	 * @return
	 */
	public ListNode insertAtHead(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if(head == null)
			return newNode;
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	/**
	 * To add a node at the end of a singly linked list
	 * 
	 * @param head
	 * @param data
	 * @return
	 */
	public ListNode insertAtEnd(ListNode head, int data) {
		ListNode newNode = new ListNode(data); // 40 -> null
		if(head == null)
			return newNode;
		ListNode current = head; //10 -> 20 -> 30 -> null
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		return head;
	}
	
	/**
	 * To add a node after a given position in a singly linked list
	 * 
	 * @param previous
	 * @param data
	 */
	public void insertAfter(ListNode previous, int data) {
		if(previous == null) {
			System.out.println("The given previous node cannot be null.");
			return;
		}
		ListNode newNode = new ListNode(data);
		newNode.next = previous.next;
		previous.next = newNode;
	}
	
	/**
	 * To add a node at a given position in a singly linked list
	 * 
	 * @param head
	 * @param data
	 * @param position
	 * @return
	 */
	public ListNode insertAtPosition(ListNode head, int data, int position) {
		//performs check on boundary conditions
		int size = size(head);
		if(position > size + 1 || position < 1) {
			System.out.println("Invalid position.");
			return head;
		}
		
		ListNode newNode = new ListNode(data);
		if(position == 1) {
			newNode.next = head;
			return newNode;
		} else {
			ListNode previous = head;
			int count = 1;
			while(count < position - 1) {
				previous = previous.next;
				count++;
			}
			newNode.next = previous.next;
			previous.next = newNode;
			return head;
		}
	}
	
	/**
	 * To delete a node from the head of a singly linked list
	 * 
	 * @param head
	 * @return
	 */
	public ListNode delteFirst(ListNode head) {
		if(head == null) {
			System.out.println("No node is found to delete.");
			return head;
		}
		ListNode current = head;
		head = current.next;
		current.next = null;
		return head;
	}
	
	/**
	 * To delete a node from the end of a singly linked list
	 * 
	 * @param head
	 */
	public void deleteLast(ListNode head) {
		if(head == null) {
			System.out.println("No node is found to delete.");
			return;
		}
		
		ListNode last = head;
		ListNode previousToLast = null;
		
		while(last.next != null) {
			previousToLast = last;
			last = last.next;
		}
		previousToLast.next = null;
	}
	
	/**
	 * To delete a node at a given position from a singly linked list
	 * 
	 * @param head
	 * @param position
	 * @return
	 */
	public ListNode deleteAtPosition(ListNode head, int position) {
		if(head == null) {
			System.out.println("No node is found to delete.");
			return head;
		}
		int count = 1;
		ListNode previous = head;
		while(count < position - 1) {
			previous = previous.next;
			count++;
		}
		ListNode current = previous.next;
		previous.next = current.next;
		current.next = null;
		return head;
	}
	
	/**
	 * To reverse a singly linked list
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverse(ListNode head) {
		if(head == null) {
			return head;
		}

		// is: 20 -> 30 -> 40 -> 17 -> null
		//: null <- 20 <- 30 <- 40 <- 17 
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
		return head;
	}
	
	/**
	 * To check if the linked list is circular
	 * 
	 * @param head
	 * @return
	 */
	public boolean isCircular(ListNode head) {
		if(head == null) {
			return true;
		}
		
		ListNode current = head.next;
		while(current != null && current.next != null) {
			current = current.next;
			if(current == head) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCyclic(ListNode head) {
		if(head == null)
			return true;
		
		ListNode slower = head;
		ListNode faster = head;
		int counter = 0;
		
		while(faster != null && faster.next != null) {
			slower = faster.next;
			faster = faster.next.next;
			
			if(slower == faster) {
				counter++;
				return true;
			}
			if(counter == 1)
				break;
		}
		return false;
	}
	
	/**
	 * To convert the singly linked list to a circular list
	 * 
	 * @param head
	 * @return
	 */
	public ListNode convertSinglyLinkedListToCircular(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = head;
		return head;
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(10);
		ListNode second = new ListNode(20);
		ListNode third = new ListNode(30);
		ListNode fourth = new ListNode(40);
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		
		SinglyLinkedList linkedList = new SinglyLinkedList();
		
		System.out.println("The original list is: ");
		linkedList.display(head);
		System.out.println();System.out.println();
		
		System.out.println("Length of the list is: " + linkedList.size(head));
		System.out.println();
		
		System.out.println("The list after adding a node at the beginning is: ");
		ListNode updatedList1 = linkedList.insertAtHead(head, 1);
		linkedList.display(updatedList1);
		System.out.println();System.out.println();
		
		System.out.println("The list after adding a node at the end is: ");
		ListNode updatedList2 = linkedList.insertAtEnd(head, 25);
		linkedList.display(updatedList2);
		System.out.println();System.out.println();
		
		System.out.println("The list after adding a node after the third position is: ");
		linkedList.insertAfter(third, 15);
		linkedList.display(head);
		System.out.println();System.out.println();
		
		System.out.println("The list after adding a new node at a given position is: ");
		ListNode updatedList3 = linkedList.insertAtPosition(head, 17, 6);
		linkedList.display(updatedList3);
		System.out.println();System.out.println();
		
		System.out.println("The list after deleting the first node is: ");
		ListNode updatedList4 = linkedList.delteFirst(updatedList3);
		linkedList.display(updatedList4);
		System.out.println();System.out.println();
		
		System.out.println("The list after deleting the last node is: ");
		linkedList.deleteLast(updatedList4);
		linkedList.display(updatedList4);
		System.out.println();System.out.println();
		
		System.out.println("The list after deleteing a node at a given position is: ");
		ListNode updatedList5 = linkedList.deleteAtPosition(updatedList4, 3);
		linkedList.display(updatedList5);
		System.out.println();System.out.println();
		
		System.out.println("The list after reversing it is: ");
		ListNode updatedList6 = linkedList.reverse(updatedList5);
		linkedList.display(updatedList6);
		System.out.println();System.out.println();
		
		System.out.print("Check if the list is circular: ");
		System.out.println(linkedList.isCircular(updatedList6));
		System.out.println();System.out.println();
		
		System.out.println("Convert the singly linked list to a circular linked list: ");
		ListNode updatedList7 = linkedList.convertSinglyLinkedListToCircular(updatedList6);
		System.out.println("Check if the list has a loop: " +linkedList.isCyclic(updatedList7));
		linkedList.display(updatedList7);
		System.out.println();System.out.println();
		
	}
}
