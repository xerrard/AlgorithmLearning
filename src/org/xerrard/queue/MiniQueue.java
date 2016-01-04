package org.xerrard.queue;

class Node<T>{
	public T value;
	public Node<T> next;
	public Node(T value,Node<T> next) {
		super();
		this.value = value;
		this.next = next;
	}
	
}

public class MiniQueue<T> {
    
	private int size;
	private Node<T> head;
	private Node<T> last;
	
	
	
	public MiniQueue() {
		super();
		head = new Node<T>(null,null);
		last = head;
	}


	/**
	 * 入队
	 * @param t
	 */
	public void offer(T t){
		Node<T> node = new Node<T>(t, null);
		last.next = node;
		last=node;
		size++;
		
	}
	

	/**
	 * 队头元素
	 * @return
	 */
	public T peek(){
		if(isEmpty()){
			return null;
		}else{
			return head.next.value;
		}
	}
/**
 * 出队列
 * @return
 */
	public T poll(){
		if(isEmpty()){
			return null;	
		}else{
			Node<T> p = head.next;
			head.next=p.next;
			size--;
			if(size==0){
				last=head;
			}
			return p.value;
		}
	}
    
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty(){
		boolean ret = false;
		if(size==0){
			ret = true;
		}else{
			ret = false;
		}
		return ret;
	}
	
	public int size(){
		return size;
	}
}
