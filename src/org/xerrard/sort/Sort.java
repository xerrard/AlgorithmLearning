package org.xerrard.sort;

import org.junit.Test;

import junit.framework.ComparisonCompactor;

public class Sort {

	/**
	 * 选择排序，N^2次比较，N次交换
	 * 
	 * @param a
	 */
	public static void select_sort(Comparable[] a) {

		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				// 1.先找到当前最小的那个
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			// 2.然后将最小的与第一个交换
			exchange(a, i, min);
		}
	}

	/**
	 * 冒泡排序算法，其实更像是下沉算法，两两比较，将大的沉下去
	 * 
	 * @param a
	 */
	public static void bubble_sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length - i; j++) {
				if (less(a[j], a[j - 1])) {
					exchange(a, j, j - 1);
				}
			}
		}
	}

	/**
	 * 插入排序算法：假设前i-1个数据已经排序完毕，那么第i个数据和前i-1个比较：
	 * 如果第i个数据和第i-1个数据相对较大，直接放在第i个位置，如果相对较小，往前遍历检索到比a[i]大的位置。
	 * 从前往后是不行的，只能从后往前遍历，因为牵扯到后移的问题
	 * 
	 * @param a
	 */
	public static void insert_sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				Comparable temp = a[i];
				for (int j = i - 1; j >= 0; j--) {
					if (less(temp, a[j])) {
						a[j + 1] = a[j];
						a[j] = temp;
					}
				}
			}
		}
	}

	/**
	 * 1.通过控制gap，将每组的数据进行直接插入排序，2.gap指数减小，直到为1
	 * 
	 * @param a
	 */
	public static void shell_sort(Comparable[] a) {
		for (int gap = a.length; gap > 0; gap /= 2) {
			for (int i = gap; i < a.length; i += gap) {
				if (less(a[i], a[i - gap])) {
					Comparable temp = a[i];
					for (int j = i - gap; j >= 0; j--) {
						if (less(temp, a[j])) {
							a[j + gap] = a[j];
							a[j] = temp;
						}
					}
				}
			}
		}
	}

	/**
	 * 归并排序：
	 * 1，将数组从中间分为两半，将前半部分排序，将后半部分排序，最后将排好序的两个数组合并排序
	 * 2.依次递归
	 * @param a
	 */
	public static void merge_sort(Comparable[] a) {
		mergesort(a, 0, a.length - 1);
	}

	private static void mergesort(Comparable[] a, int start, int end) {
		int length = end - start + 1;
		int half = start + length / 2;
		if (start < end) {
			mergesort(a, start, half - 1);
			mergesort(a, half, end);
			mergearray(a, start, half, end);
		}

	}

	/**
	 * 合并数组中已经排好序的两个部分
	 * @param a
	 * @param start
	 * @param half
	 * @param end
	 */
	private static void mergearray(Comparable[] a, int start, int half, int end) {
		Comparable[] temp = new Comparable[end+1];
		int i = start;
		int j = half;
		int k = start;
		while(i<half&&j<=end){
			if(less(a[i],a[j])){
				temp[k++]= a[i++];
			}else{
				temp[k++]=a[j++];
			}
			
		}

		while(i<half){
			temp[k++]= a[i++];
		}
		while(j<=end){
			temp[k++] = a[j++];
		}
		System.arraycopy(temp, start, a, start, end-start+1);
		
	}

	/**
	 * 比较
	 * 
	 * @param v
	 * @param w
	 * @return v<w
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * 交换
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + "  ");

		}
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testSelectSort() {
		String[] a = { "A", "B", "E", "H", "C", "W" };
		select_sort(a);
		assert isSorted(a);
		show(a);
	}

	@Test
	public void testBubbleSort() {
		String[] a = { "A", "B", "E", "H", "C", "W", "R", "O" };
		bubble_sort(a);
		assert isSorted(a);
		show(a);
	}

	@Test
	public void testInsertSort() {
		String[] a = { "A", "B", "E", "H", "C", "W", "R", "O" };
		insert_sort(a);
		assert isSorted(a);
		show(a);
	}

	@Test
	public void testShellSort() {
		String[] a = { "A", "B", "E", "H", "C", "W", "R", "O" };
		shell_sort(a);
		assert isSorted(a);
		show(a);
	}
	
	@Test
	public void testMergeSort() {
		String[] a = { "A", "B", "E", "H", "C", "W", "R", "O" };
		merge_sort(a);
		assert isSorted(a);
		show(a);
	}
}
