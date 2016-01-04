package org.xerrard.recursion;

import org.junit.Test;

public class GCDandLCM {

	/**
	 * 最大公约数算法：用小数除大数,如果余数不是零,就把余数和较小的数构成一组新数,继续上面的除法,知道大数被小数约尽,此时比较小的数就是最大公约数
	 */

	/**
	 * 递归算法
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int GCDRecursion(int m, int n) {
		return m < n ? n % m != 0 ? GCDRecursion(n % m, m) : m : m % n != 0 ? GCDRecursion(m % n, n) : n;

	}

	/**
	 * 递推算法
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int GCDIterative(int m, int n) {
		int max = Math.max(m, n);
		int min = Math.min(m, n);
		int remain = max % min;
		while (remain != 0) {
			max = min;
			min = remain;
			remain = max % min;
		}

		return min;

	}

	public int LCM(int m, int n) {
		return m * n / GCDIterative(m, n);
	}

	@Test
	public void testGCDRecursion() {
		System.out.println("GCDRecursion is  " + GCDRecursion(105, 126));
	}

	@Test
	public void testGCDIterative() {
		System.out.println("GCDIterative is  " + GCDIterative(105, 126));
	}
	
	@Test
	public void testLCM() {
		System.out.println("LCM is  " +  LCM(105, 126));
	}

}
