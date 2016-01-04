package org.xerrard.stack;

public class MiniStack<T> {
    private static final int max = 5;
  //不能写成泛型数组，java不能显式初始化泛型数组，可以发射实现
    private Object[] array = new Object[max]; 
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        boolean ret = false;
        if(size==0){
            ret = true;
        }
        
        return ret;
    }
    
    public void push(T element){
        array[size] = element;
        size++;
        if(size ==array.length){
            expandCapacity();
        }
    }

    /**
     * 此方法实现完整的扩充容量
     * @param i
     */
    private  void expandCapacity() {
    	Object[] newArray = new Object[size*2];  //先扩充容量
        System.arraycopy(array, 0, newArray, 0, size); //然后array copy过来
    	array = newArray;
    }
    
    public T peek(){
        T ret = null;
        if(!isEmpty()){
            ret = (T) array[size-1];
        }
        return ret;
    }
    
    public T pop(){
        T ret = null;
        if(!isEmpty()){
            ret = (T) array[size-1];
            array[size-1]=null;
            size--;
        }
        
        return ret;
    }
    
}
