package org.xerrard.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import org.junit.Test;

public class TestSpeed {
	
	final int testmax = 1<<23;
	@Test
	public void testJDKQueue(){
		Queue<Integer> queue = new LinkedList<Integer>();
		Random random = new Random();
		int value;
		for(int i=0;i<=testmax;i++){
			value = random.nextInt(testmax);
			if(value%3!=0){
				queue.offer(value);
			}else if(!queue.isEmpty()){
				queue.peek();
				queue.poll();
			}
		}
		while(!queue.isEmpty()){
			queue.poll();
		}
		
	}
	
	@Test
	public void testMiniQueue(){
		MiniQueue<Integer> queue = new MiniQueue<Integer>();
		Random random = new Random();
		int value;
		for(int i=0;i<=testmax;i++){
			value = random.nextInt(testmax);
			if(value%3!=0){
				queue.offer(value);
			}else if(!queue.isEmpty()){
				queue.peek();
				queue.poll();
			}
		}
		while(!queue.isEmpty()){
			queue.poll();
		}
		
	}
}
