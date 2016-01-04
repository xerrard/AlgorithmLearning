package org.xerrard.stack;

import java.util.Stack;

import org.junit.Test;

public class MinStack {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    private int size=0;
    
	
    public void push(int x) {
        stack1.push(x);
        if(!stack2.isEmpty()){
        	int min = Math.min(stack2.peek(), x);
            stack2.push(min);
        }else{
        	stack2.push(x);
        }
        
    	size++;
    }

    public void pop() {
    	stack1.pop();
    	stack2.pop();
        size--;
    }

    public int top() {
    	return stack1.peek();
        
    }

    public int getMin() {
        return stack2.peek();
    }

    @Test
    public void testMinStack(){
		MinStack stack = new MinStack();
		int[] array = {10, 6, 5,4,7,8,9 };
		for (int k : array) {
			stack.push(k);
		}

		while (stack.size!=0) {
			System.out.println(stack.top());
			System.out.println(stack.getMin());
			stack.pop();
			
		}
		
    }
}

