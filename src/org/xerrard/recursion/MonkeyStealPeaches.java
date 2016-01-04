package org.xerrard.recursion;

import org.junit.Test;

/**
 * 猴子偷桃问题 猴子吃桃问题，猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个。第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
 * 
 * @author xuqiang
 *
 */

public class MonkeyStealPeaches {

	/**
	 * 递推算法，An = 2 + 2*A(n+1)。 我们知道第十天 A10 = 1，我们递推出A9 = 2 + 2*A10 = 4
	 * ，这样我们就知道循环计算sum = 2+ 2*sum即可,我们需要得出的是A1，那么计算9次即可。
	 * 
	 * @param days
	 *            总共第几天
	 * @param remains
	 *            第days天，还剩下几个桃子
	 * @return
	 */
	public int getFirstDayPeachesIterative(int days, int remains) {
		int sum = remains;
		for (int i = 1; i < days; i++) {
			sum = 2 + 2 * sum;
		}

		return sum;

	}

	/**
	 * 递归算法
	 * @param days
	 * @param remains
	 * @return
	 */
	public int getFirstDayPeachesRecursion(int days, int remains) {
		return getPeachesRecursion(1, days, remains);
	}

	/**
	 * 第10天，返回1；否则返回后一天的值*2+2     An = 2 + 2A(n+1)
	 * @param day
	 * @param days
	 * @param remains
	 * @return
	 */
	public int getPeachesRecursion(int day, int days, int remains) {
		return day == days ? remains : 2 * remains + 2 * getPeachesRecursion(day + 1, days, remains);
	}

	@Test
	public void testgetPeachesIterative() {
		System.out.println("getPeachesIterative " + getFirstDayPeachesIterative(10, 1));
	}

	@Test
	public void testgetPeachesRecursion() {
		System.out.println("getPeachesRecursion " + getFirstDayPeachesRecursion(10, 1));
	}
}
