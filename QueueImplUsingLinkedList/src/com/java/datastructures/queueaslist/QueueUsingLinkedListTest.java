package com.java.datastructures.queueaslist;

public class QueueUsingLinkedListTest {
	
	public static void main(String[] args) {
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		
		//insert elements into queue
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		
		//print queue elements
		queue.print(); //10 -> 20 -> 30 -> 40 -> null
		
		queue.dequeue();
		queue.dequeue();
		System.out.println();
		queue.print(); //30 -> 40 -> null
	}
}
