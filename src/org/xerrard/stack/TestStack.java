package org.xerrard.stack;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class TestStack {
	@Test
	public void testSqStack() {
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(stack.isEmpty());
		Integer[] array = { 1, 2, 3, 4, 5 };
		for (Integer k : array) {
			stack.push(k);
		}
		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			System.out.println(stack.peek() + "   " + stack.pop());
		}
	}

	@Test
	public void testLinkedList() {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		System.out.println(stack.isEmpty());
		Integer[] array = { 1, 2, 3, 4, 5 };
		for (Integer k : array) {
			stack.push(k);
		}
		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			System.out.println(stack.peek() + "   " + stack.pop());
		}
	}
	
	@Test
	public void testMiniStack() {
		MiniStack<Integer> stack = new MiniStack<Integer>();
		System.out.println(stack.isEmpty());
		Integer[] array = { 1, 2, 3, 4, 5 };
		for (Integer k : array) {
			stack.push(k);
		}
		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			System.out.println(stack.peek() + "   " + stack.pop());
		}
	}
	
	final int testmax = 1<<20;
	@Test
	public void testFuction(){
		Stack<Integer> stack1 = new Stack<Integer>();
		MiniStack<Integer> stack2 = new MiniStack<Integer>();
		Random random = new Random();
		int value;
		for(int i=0;i<=testmax;i++){
			value = random.nextInt(testmax);
			if(value%3!=0){
				stack1.push(value);
				stack2.push(value);
			}else if(!stack1.isEmpty()&&!stack2.isEmpty()){
				Assert.assertTrue(stack1.size()==stack2.size());
				Assert.assertTrue(stack1.peek().equals(stack2.peek()));
			}
		}
		while(!stack2.isEmpty()){
			Assert.assertTrue(stack1.pop().equals(stack2.pop()));
		}
		
	}
	
}
