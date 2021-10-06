package domain;

import exception.UserInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class UserNumbersTest {
	@Test
	void 사용자입력값_변환확인() {
		assertThat(UserNumbers.parseUserNumbers("123")).isEqualTo(Arrays.asList(1,2,3));
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "1", "12", "1234"})
	void 사용자입력값_길이유효성검증(String numbers) {
		assertThatExceptionOfType(UserInputException.class)
				.isThrownBy(() -> {
					UserNumbers.parseUserNumbers(numbers);
				}).withMessageContaining("[ERROR] 3자리 숫자로 입력해주세요.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc", "가나다", "12a"})
	void 사용자입력값_문자유효성검증(String numbers) {
		assertThatExceptionOfType(UserInputException.class)
				.isThrownBy(() -> {
					UserNumbers.parseUserNumbers(numbers);
				}).withMessageContaining("[ERROR] 1~9까지 숫자만 입력해주세요.");
	}

}