package org.xerrard.sort;

import java.util.Arrays;

import org.junit.Test;

public class Sort {

	/**
	 * 冒泡排序算法，其实更像是下沉算法，两两比较，将大的沉下去
	 * 
	 * @param array
	 */
	public static void bubble_sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				int max = Math.max(array[j], array[j + 1]);
				int min = Math.min(array[j], array[j + 1]);
				array[j] = min;
				array[j + 1] = max;
			}
		}
	}

	/**
	 * 插入排序算法：假设前n-1个数据已经排序完毕，那么第n个数据和前n-1个比较，放到合适的位置上即可
	 * 从前往后是不行的，只能从后往前遍历，因为牵扯到后移的问题
	 * @param array
	 */
	public static void insert_sort(int[] array) {

	}

	/**
	 * 快速排序算法。挖坑填数+分治法 详细算法解释见
	 * http://blog.csdn.net/morewindows/article/details/6684558
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 */
	public static void quick_sort(int[] array, int leftIndex, int rightIndex) {
		int i = leftIndex;
		int j = rightIndex;
		if (i < 0 || j < 1 || i >= j) {
			return;
		}
		int key = array[leftIndex];
		while (i < j) {
			while ((array[j] >= key) && (i < j)) {
				j--; // 1.从后往前找比key小的
			}
			if (i < j) {
				array[i++] = array[j]; // 2.将比key小的放到前面
			}
			while ((array[i] < key) && (i < j)) { // 3.从前往后找比key大的
				i++;
			}
			if (i < j) {
				array[j--] = array[i]; // 4.找到后，吧把比key大的放到后面
			}
		}
		array[i] = key; // 5.最后会有一个坑留出来，这就是放key的地方
		quick_sort(array, leftIndex, i - 1); // 递归做前面的
		quick_sort(array, i + 1, rightIndex); // 递归做后面的
	}

	@Test
	public void testbubbleSort() {
		int[] array = new int[] { 2, 97, 3, 5, 8, 15, 19, 22 };
		bubble_sort(array);
		String intArrayString = Arrays.toString(array);
		System.out.println(intArrayString);
	}

	@Test
	public void testQuickSort() {
		// int[] array = new int[] { 2, 97, 3, 5, 8, 15, 19, 22 };
		int[] array = new int[] { 97, 3, 5, 8, 15, 19, 22 };
		quick_sort(array, 0, array.length - 1);
		String intArrayString = Arrays.toString(array);
		System.out.println(intArrayString);
	}
}
