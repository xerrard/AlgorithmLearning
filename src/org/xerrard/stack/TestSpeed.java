package org.xerrard.stack;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import org.junit.Test;

public class TestSpeed {
	
	final int testmax = 1<<23;
	@Test
	public void testSqStack(){
		Stack<Integer> stack = new Stack<Integer>();
		Random random = new Random();
		int value;
		for(int i=0;i<=testmax;i++){
			value = random.nextInt(testmax);
			if(value%3!=0){
				stack.push(value);
			}else if(!stack.isEmpty()){
				stack.peek();
				stack.pop();
			}
		}
		while(!stack.isEmpty()){
			stack.pop();
		}
		
	}
	
	@Test
	public void testLinkedList(){
		LinkedList<Integer> stack = new LinkedList<Integer>();
		Random random = new Random();
		int value;
		for(int i=0;i<=testmax;i++){
			value = random.nextInt(testmax);
			if(value%3!=0){
				stack.push(value);
			}else if(!stack.isEmpty()){
				stack.peek();
				stack.pop();
			}
		}
		while(!stack.isEmpty()){
			stack.pop();
		}
		
	}
	
	@Test
	public void testMiniStack(){
		MiniStack<Integer> stack = new MiniStack<Integer>();
		Random random = new Random();
		int value;
		for(int i=0;i<=testmax;i++){
			value = random.nextInt(testmax);
			if(value%3!=0){
				stack.push(value);
			}else if(!stack.isEmpty()){
				stack.peek();
				stack.pop();
			}
		}
		while(!stack.isEmpty()){
			stack.pop();
		}
		
	}
}
