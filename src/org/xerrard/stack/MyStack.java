package org.xerrard.stack;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class MyStack<T> {
	private Queue<T> queue1 = new LinkedList<T>();
	private Queue<T> queue2 = new LinkedList<T>();
	private int size = 0;

	// Push element x onto stack.
	public void push(T x) {
		if (empty()) {
			queue1.offer(x);
		} else {
			if (queue1.isEmpty()) {
				queue2.offer(x);
			} else {
				queue1.offer(x);
			}
		}
		size++;

	}

	// Removes the element on top of the stack.
	public T pop() {
		T ret = null;
		if (queue1.isEmpty()) {
			while (queue2.size() > 1) { // 还剩一个
				queue1.offer(queue2.poll());
			}
			ret = queue2.poll();
		} else {
			while (queue1.size() > 1) { // 还剩一个
				queue2.offer(queue1.poll());
			}
			ret = queue1.poll();
		}
		size--;
		return ret;
	}

	// Get the top element.
	public T top() {
		T ret = null;
		if (queue1.isEmpty()) {
			while (queue2.size() > 1) { // 还剩一个
				queue1.offer(queue2.poll());
			}
			ret = queue2.poll();
			queue1.offer(ret);
		} else {
			while (queue1.size() > 1) { // 还剩一个
				queue2.offer(queue1.poll());
			}
			ret = queue1.poll();
			queue2.offer(ret);
		}
		return ret;

	}

	// Return whether the stack is empty.
	public boolean empty() {

		return size == 0 ? true : false;

	}

	@Test
	public void testSqStack() {
		MyStack<Integer> stack = new MyStack<Integer>();
		System.out.println(stack.empty());
		Integer[] array = { 1, 2, 3, 4, 5 };
		for (Integer k : array) {
			stack.push(k);
		}
		while (!stack.empty()) {
			System.out.println(stack.top() + "   " + stack.pop());
		}
	}
}
