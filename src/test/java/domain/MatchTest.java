package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
	private PrintStream standardOut;
	private OutputStream captor;

	@BeforeEach
	void setUp() {
		standardOut = System.out;
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	@Test
	void _3스트라이크() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(1,2,3);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isTrue();
		assertThat(captor.toString().trim()).isEqualTo("3스트라이크");
	}

	@Test
	void _2스트라이크() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(1,2,9);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("2스트라이크");
	}

	@Test
	void _1스트라이크() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(1,8,9);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("1스트라이크");
	}

	@Test
	void _1볼() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(3,4,5);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("1볼");
	}

	@Test
	void _2볼() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(5,3,1);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("2볼");
	}

	@Test
	void _3볼() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(2,3,1);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("3볼");
	}

	@Test
	void _1스트라이크_1볼() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(1,3,5);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("1스트라이크 1볼");
	}

	@Test
	void _1스트라이크_2볼() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(3,2,1);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("1스트라이크 2볼");
	}

	@Test
	void _낫싱() {
		List<Integer> numbers = Arrays.asList(1,2,3);
		List<Integer> userNumbers = Arrays.asList(7,8,9);
		boolean result = Match.correctAnswer(numbers, userNumbers);

		assertThat(result).isFalse();
		assertThat(captor.toString().trim()).isEqualTo("낫싱");
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
	}
}