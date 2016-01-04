package org.xerrard.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class TestQueue {
	@Test
	public void testJDKQueue() {
		Queue<Integer> queue = new LinkedList<Integer>();
		System.out.println(queue.isEmpty());
		Integer[] array = { 1, 2, 3, 4, 5 };
		for (Integer k : array) {
			queue.offer(k);
		}
		System.out.println(queue.size());
		while (!queue.isEmpty()) {
			System.out.println(queue.peek() + "   " + queue.poll());
		}
	}

	@Test
	public void testMiniQueue() {
		MiniQueue<Integer> queue = new MiniQueue<Integer>();
		System.out.println(queue.isEmpty());
		Integer[] array = { 1, 2, 3, 4, 5 };
		for (Integer k : array) {
			queue.offer(k);
		}
		System.out.println(queue.size());
		while (!queue.isEmpty()) {
			System.out.println(queue.peek() + "   " + queue.poll());
		}
	}
	
	final int testmax = 1<<20;
	@Test
	public void testFuction(){
		Queue<Integer> queue1 = new LinkedList<Integer>();
		MiniQueue<Integer> queue2 = new MiniQueue<Integer>();
		Random random = new Random();
		int value;
		for(int i=0;i<=testmax;i++){
			value = random.nextInt(testmax);
			if(value%3!=0){
				queue1.offer(value);
				queue2.offer(value);
			}else if(!queue1.isEmpty()&&!queue2.isEmpty()){
				Assert.assertTrue(queue1.size()==queue2.size());
				Assert.assertTrue(queue1.peek().equals(queue2.peek()));
			}
		}
		while(!queue2.isEmpty()){
			Assert.assertTrue(queue1.poll().equals(queue2.poll()));
		}
		
	}
	
}
