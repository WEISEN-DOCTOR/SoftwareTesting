package cn.tjuscs.one;

public class Number {
	private int NumberOf50 = 1;
	private int NumberOf20 = 1;
	private int NumberOf10 = 1;
	private int NumberOf05 = 2;
	private int NumberOf01 = 3;

	public boolean number(int money) {
		while (money != 0) {
			if (money >= 50) {
				if (NumberOf50 > 0) {
					money = money - 50;
					NumberOf50--;
					continue;
				} else if (NumberOf20 > 0) {
					money = money - 20;
					NumberOf20--;
					continue;
				} else if (NumberOf10 > 0) {
					money = money - 10;
					NumberOf10--;
					continue;
				} else if (NumberOf05 > 0) {
					money = money - 5;
					NumberOf05--;
					continue;
				} else if (NumberOf01 > 0) {
					money--;
					NumberOf01--;
					continue;
				} else
					break;
			} else if (money >= 20 && money < 50) {
				if (NumberOf20 > 0) {
					money = money - 20;
					NumberOf20--;
					continue;
				} else if (NumberOf10 > 0) {
					money = money - 10;
					NumberOf10--;
					continue;
				} else if (NumberOf05 > 0) {
					money = money - 5;
					NumberOf05--;
					continue;
				} else if (NumberOf01 > 0) {
					money--;
					NumberOf01--;
					continue;
				} else
					break;
			} else if (money >= 10 && money < 20) {
				if (NumberOf10 > 0) {
					money = money - 10;
					NumberOf10--;
					continue;
				} else if (NumberOf05 > 0) {
					money = money - 5;
					NumberOf05--;
					continue;
				} else if (NumberOf01 > 0) {
					money--;
					NumberOf01--;
					continue;
				} else
					break;
			} else if (money >= 5 && money < 10) {
				if (NumberOf05 > 0) {
					money = money - 5;
					NumberOf05--;
					continue;
				} else if (NumberOf01 > 0) {
					money--;
					NumberOf01--;
					continue;
				} else
					break;
			} else if (money >= 1 && money < 5) {
				if (NumberOf01 > 0) {
					money--;
					NumberOf01--;
					continue;
				} else
					break;
			} else
				break;
		}
		if (money == 0) {
			return true;
		} else
			return false;
	}
}