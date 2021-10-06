package domain;

import java.util.LinkedList;
import java.util.List;

public class UserNumbers {
	private static final int NUMBER_LEN = 3;

	public static boolean isValid(String userNumbers) {
		if (!validLength(userNumbers)) {
			System.out.println("[ERROR] 3자리 숫자로 입력해주세요.");
			return false;
		}
		if (!validNumber(userNumbers)) {
			System.out.println("[ERROR] 1~9까지 숫자만 입력해주세요.");
			return false;
		}
		return true;
	}

	public static List<Integer> parseUserNumbers(String userNumbers) {
		List<Integer> numbers = new LinkedList<>();
		for (int i = 0; i < NUMBER_LEN; i++) {
			numbers.add(Integer.parseInt(userNumbers.substring(i, i+1)));
		}

		return numbers;
	}

	private static boolean validLength(String numbers) {
		return numbers.length() == NUMBER_LEN;
	}

	private static boolean validNumber(String numbers) {
		return numbers.matches("[1-9]{" + NUMBER_LEN + "}");
	}
}
