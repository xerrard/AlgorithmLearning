package org.xerrard.queue;

import java.util.Stack;

import org.junit.Test;

/**
 * 
 * @author xuqiang
 * @param <T>
 *
 */
public class MyQueue<T> {
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	private int size=0;
	
    // Push element x to the back of queue.
    public void push(T x) {
        stack1.push(x);
        size++;
    }

    // Removes the element from in front of queue.
    public T pop() {
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	T ret = stack2.pop();
    	size--;
    	return ret;
        
    }

    // Get the front element.
    public T peek() {
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
		return stack2.peek();
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
    	return size==0?true:false;
    }
    
    @Test
    public void testMyQueue(){
    	MyQueue<Integer> queue = new MyQueue<Integer>();
    	queue.push(1);
    	queue.push(2);
    	queue.push(3);
    	queue.push(4);
    	while (!queue.empty()) {
			System.out.println(queue.peek() + "   " + queue.pop());
		}
    	
    	queue.push(5);
    	queue.push(6);
    	while (!queue.empty()) {
			System.out.println(queue.peek() + "   " + queue.pop());
		}
    	
    }
}