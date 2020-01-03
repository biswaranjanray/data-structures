package com.java.datastucture.stack;

public class StackImplentationUsingArrayTest {

	public static void main(String[] args) {
		StackImplentationUsingArray stack = new StackImplentationUsingArray();
		stack.push(10);
		stack.print();
		stack.push(20);
		stack.print();
		stack.push(30);
		stack.print();
		stack.pop();
		stack.print();
		stack.pop();
		stack.print();
	}
}
