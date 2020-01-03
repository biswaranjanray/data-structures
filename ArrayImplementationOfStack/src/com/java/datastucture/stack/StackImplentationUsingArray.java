package com.java.datastucture.stack;

/**
 * Class demonstrates how to implement Stack using Array data structure.
 * Stack works with the concept of LIFO(Last-in First-out).
 * 
 * Source: https://www.youtube.com/watch?v=sFVxsglODoo
 * @author C5258401
 *
 */
public class StackImplentationUsingArray {

	private int top;
	private static final int MAX_SIZE = 101;
	private int stack[] = new int[MAX_SIZE];
	
	public StackImplentationUsingArray( ) {
		top = -1;
	}
	
	public void push(int num) {
		if(top == MAX_SIZE - 1) {
			System.out.println("Stack overflow.");
			return;
		}
		stack[++top] = num;
	}
	
	public void pop() {
		if(top == -1) {
			System.out.println("Stack is empty.");
			return;
		}
		top--;
	}
	
	public int top() {
		return stack[top];
	}
	
	public void print() {
		for(int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}
