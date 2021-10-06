package domain;

import exception.UserInputException;

import java.util.LinkedList;
import java.util.List;

public class UserNumbers {
	private static final int NUMBER_LEN = 3;

	public static List<Integer> parseUserNumbers(String userNumbers) {
		if (!vaildLength(userNumbers)) throw new UserInputException("[ERROR] 3자리 숫자로 입력해주세요.");
		if (!vaildNumber(userNumbers)) throw new UserInputException("[ERROR] 1~9까지 숫자만 입력해주세요.");

		List<Integer> numbers = new LinkedList<>();
		for (int i = 0; i < NUMBER_LEN; i++) {
			numbers.add(Integer.parseInt(userNumbers.substring(i, i+1)));
		}

		return numbers;
	}

	private static boolean vaildLength(String numbers) {
		return numbers.length() == NUMBER_LEN;
	}

	private static boolean vaildNumber(String numbers) {
		return numbers.matches("[1-9]{" + NUMBER_LEN + "}");
	}
}
