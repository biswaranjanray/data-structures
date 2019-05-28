package com.java.datastructures.stackaslist;

import java.util.EmptyStackException;

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
