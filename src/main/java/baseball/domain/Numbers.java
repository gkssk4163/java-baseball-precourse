package baseball.domain;

import nextstep.utils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class Numbers {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int NUMBER_LEN = 3;

	public static List<Integer> generate() {
		List<Integer> numbers = new LinkedList<>();
		boolean[] exist = new boolean[10];

		for (int i = 0; i < NUMBER_LEN; i++) {
			setRandomNumber(numbers, exist);
		}

		return numbers;
	}

	private static void setRandomNumber(List<Integer> numbers, boolean[] exist) {
		int number;
		do {
			number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		} while (exist[number]);

		numbers.add(number);
		exist[number] = true;
	}
}
