package baseball.controller;

import baseball.domain.Match;
import baseball.domain.Numbers;
import baseball.domain.UserNumbers;
import baseball.view.UserConsole;

import java.util.List;

public class BaseballController {
	public void run() {
		do {
			startGame();
		} while (UserConsole.continueGame());
	}

	private static void startGame() {
		List<Integer> numbers = Numbers.generate();

		String userNumbers;
		do {
			userNumbers = UserConsole.enterNumbers();
		} while (!(UserNumbers.isValid(userNumbers) && Match.correctAnswer(numbers, UserNumbers.parseUserNumbers(userNumbers))));
	}
}
