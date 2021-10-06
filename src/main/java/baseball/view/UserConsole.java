package baseball.view;

import nextstep.utils.Console;

public class UserConsole {
	public static String enterNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public static boolean continueGame() {
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
		return Console.readLine().equals("1");
	}
}
