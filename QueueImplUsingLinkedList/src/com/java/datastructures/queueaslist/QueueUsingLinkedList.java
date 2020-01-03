package com.java.datastructures.queueaslist;

import java.util.NoSuchElementException;

/**
 * Class demonstrates how to implement Queue using LinkedList data structure.
 * Queue is a type of a linked list that works with the concept of FIFO(First-in First-out).
 *  
 * Source: https://www.youtube.com/watch?v=NkrlOf14GdM
 * 
 * @author C5258401
 *
 */
public class QueueUsingLinkedList {

	private ListNode front;
	private ListNode rear;
	//to store the size of the queue
	private int length;

	private class ListNode {
	
		private int data;
		//reference to next listnode
		private ListNode next;

		public ListNode(int data) {
			this.next = null;
			this.data = data;
		}
	}

	public QueueUsingLinkedList() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	public int length() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public void enqueue(int data) {
		ListNode temp = new ListNode(data);
		if (isEmpty()) {
			front = temp;
		} else {
			rear.next = temp;
		}
		rear = temp;
		length++;
	}

	public ListNode dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();

		// assigning the front node to a temp variable as we would be removing
		// this node from the queue
		ListNode temp = front;
		front = front.next;

		if (front == null)
			rear = null;
		length--;

		// assigning temp.next to null as we need the temp node to be
		// disconnected from the remaining list and we also need it to be
		// garbage collected.
		temp.next = null;

		return front;
	}

	public void print() {
		if (isEmpty()) {
			return;
		}

		ListNode current = front;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.print(current);
	}

}
