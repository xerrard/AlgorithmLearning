package org.xerrard.sort;

public class HeapSort {

	/**
	 * 堆排序的大概步骤如下: 1.构建最大堆 2.选择顶，并与第0位置元素交换
	 * 3.由于步骤2的的交换可能破环了最大堆的性质，第0不再是最大元素，需要调用maxHeap调整堆(沉降法)，如果需要重复步骤2
	 * 
	 * @param array
	 */
	public static void heap_sort(int[] array) {
		buildHeap(array);

	}

	private static void buildHeap(int[] array) {
		int size = array.length;

	}
}
