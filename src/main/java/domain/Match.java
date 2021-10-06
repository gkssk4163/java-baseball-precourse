package domain;

import java.util.List;

public class Match {
	private static final int NUMBER_LEN = 3;

	public static boolean correctAnswer(List<Integer> numbers, List<Integer> userNumbers) {
		// 정답인 경우
		if (numbers.equals(userNumbers)) {
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			return true;
		}

		checkHint(numbers, userNumbers);
		return false;
	}

	private static void checkHint(List<Integer> numbers, List<Integer> userNumbers) {
		int strike = 0;
		int ball = 0;

		for (int i = 0; i < NUMBER_LEN; i++) {
			strike += checkStrike(numbers, userNumbers, i);
			ball += checkBall(numbers, userNumbers, i);
		}

		printHint(strike, ball);
	}

	private static void printHint(int strike, int ball) {
		if (isNothing(strike, ball)) {
			System.out.println("낫싱");
			return;
		}

		String result = "";
		result += strike != 0 ? strike + "스트라이크 " : "";
		result += ball != 0 ? ball + "볼" : "";
		System.out.println(result);
	}

	private static int checkStrike(List<Integer> numbers, List<Integer> userNumbers, int index) {
		if (userNumbers.get(index).equals(numbers.get(index))) return 1;
		return 0;
	}

	private static int checkBall(List<Integer> numbers, List<Integer> userNumbers, int index) {
		if (numbers.contains(userNumbers.get(index)) && !userNumbers.get(index).equals(numbers.get(index))) return 1;
		return 0;
	}

	private static boolean isNothing(int strike, int ball) {
		return strike == 0 && ball == 0;
	}
}
