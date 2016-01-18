package org.xerrard.sort;

import java.util.Arrays;

import org.junit.Test;

public class Sortint {

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
	 * 插入排序算法：假设前i-1个数据已经排序完毕，那么第i个数据和前i-1个比较：
	 * 如果第i个数据和第i-1个数据相对较大，直接放在第i个位置，如果相对较小，往前遍历检索到比a[i]大的位置。
	 * 从前往后是不行的，只能从后往前遍历，因为牵扯到后移的问题
	 * 
	 * @param array
	 */
	public static void insert_sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				int key = array[i];
				for (int j = i - 1; j >= 0; j--) {
					if (key < array[j]) {
						array[j + 1] = array[j];
						array[j] = key;
					}
				}
			}
		}
	}

	/**
	 * 选择排序：先取最小的，然后取次小的，依次下去。如何取一个数组中的最小数呢？
	 * 从第二个数开始将每个数与第一个数进行比较，如果相对较小，则交换，这样循环完毕后，第一个数就肯定是最小的
	 * 
	 * @param array
	 */
	public static void select_sort(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[i]) {
					min = array[j];
					array[j] = array[i];
					array[i] = min;
				}
			}
		}
	}

	/**
	 * shell排序算法：是直接插入排序的优化算法；直接插入排序是间隔为1的数据之间的排序，那么我们把这个间隔GAP先改为length/2
	 * 进行直接插入排序, 然后完成一次排序后，修改GAP为/2进行排序，直到GAP为1，进行最后一次插入排序。 shell排序的好处：
	 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的： 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率。
	 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位。
	 * 
	 * @param array
	 */
	public static void shell_sort(int[] array) {
		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; i += gap) {
				if (array[i] < array[i - gap]) {
					int key = array[i];
					for (int j = i - gap; j >= 0; j -= gap) {
						if (key < array[j]) {
							array[j + gap] = array[j];
							array[j] = key;
						}
					}
				}
			}
		}
	}

	/**
	 * 归并排序算法：当前数据分为两份，分别排序，然后将两个排好序的数据集合合并，依次递归
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void merge_sort(int[] array, int start, int end) {
		if (start < end) {
			int size = end - start + 1;
			int half = start + size / 2;
			merge_sort(array, start, half - 1);
			merge_sort(array, half, end);
			mergearray(array, start, half, end);
		}
	}

	private static void mergearray(int[] array, int start, int half, int end) {
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = half;
		int k = 0;
		while (i < half && j < end + 1) {
			if (array[i] < array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		while (i < half) {
			temp[k++] = array[i++];
		}
		while (j < end + 1) {
			temp[k++] = array[j++];
		}
		System.arraycopy(temp, 0, array, start, end - start);
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
	public void testInsertSort() {
		int[] array = new int[] { 2, 97, 3, 5, 8, 15, 19, 22 };
		insert_sort(array);
		String intArrayString = Arrays.toString(array);
		System.out.println(intArrayString);
	}

	@Test
	public void testSelectSort() {
		int[] array = new int[] { 2, 97, 3, 5, 8, 15, 19, 22 };
		select_sort(array);
		String intArrayString = Arrays.toString(array);
		System.out.println(intArrayString);
	}

	@Test
	public void testShellSort() {
		int[] array = new int[] { 2, 97, 3, 5, 8, 15, 19, 22 };
		shell_sort(array);
		String intArrayString = Arrays.toString(array);
		System.out.println(intArrayString);
	}

	@Test
	public void testMergeSort() {
		int[] array = new int[] { 2, 97, 3, 5, 8, 15, 19, 22 };
		merge_sort(array, 0, array.length - 1);
		String intArrayString = Arrays.toString(array);
		System.out.println(intArrayString);
	}

	@Test
	public void testQuickSort() {
		int[] array = new int[] { 2, 97, 3, 5, 8, 15, 19, 22 };
		quick_sort(array, 0, array.length - 1);
		String intArrayString = Arrays.toString(array);
		System.out.println(intArrayString);
	}
}
