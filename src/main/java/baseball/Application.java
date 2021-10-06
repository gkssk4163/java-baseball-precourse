package baseball;

import baseball.domain.Match;
import baseball.domain.Numbers;
import baseball.domain.UserNumbers;
import baseball.view.UserConsole;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        do {
            startGame();
        } while (UserConsole.continueGame());
    }

    private static void startGame() {
        List<Integer> numbers = Numbers.generate();

        String userNumbers = null;
        do {
        	userNumbers = UserConsole.enterNumbers();
        } while (!(UserNumbers.isValid(userNumbers) && Match.correctAnswer(numbers, UserNumbers.parseUserNumbers(userNumbers))));
    }
}
