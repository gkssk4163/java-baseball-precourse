package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UserNumbersTest {
	private PrintStream standardOut;
	private OutputStream captor;

	@BeforeEach
	void setUp() {
		standardOut = System.out;
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	@Test
	void 사용자입력값_변환확인() {
		assertThat(UserNumbers.parseUserNumbers("123")).isEqualTo(Arrays.asList(1,2,3));
	}

	@Test
	void 사용자입력값_유효성검증() {
		boolean result = UserNumbers.isValid("123");
		assertThat(result).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "1", "12", "1234"})
	void 사용자입력값_길이유효성검증(String numbers) {
		boolean result = UserNumbers.isValid(numbers);
		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("[ERROR] 3자리 숫자로 입력해주세요.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc", "가나다", "12a"})
	void 사용자입력값_문자유효성검증(String numbers) {
		boolean result = UserNumbers.isValid(numbers);
		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("[ERROR] 1~9까지 숫자만 입력해주세요.");
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
	}

}