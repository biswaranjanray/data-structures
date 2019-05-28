package com.java.datastructures.stackaslist;

public class StackUsingLinkedListTest {
	
	public static void main(String[] args) {
		
		StackUsingLinkedList stack = new StackUsingLinkedList();
		
		//push elements into stack
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		//print the stack
		stack.print();
		
		//print the top element of Stack
		System.out.printf("\nTop element is %d\n", stack.peek());
		
		//remove top element from stack
		stack.pop();
		
		//print the stack
		stack.print();
		
		//print the top element of Stack
		System.out.printf("\nTop element is %d\n", stack.peek());
	}
}
