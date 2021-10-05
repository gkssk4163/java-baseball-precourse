package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
	private List<Integer> numbers;

	@BeforeEach
	void 생성() {
		numbers = Numbers.generate();
	}

	@Test
	void 길이검증() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@RepeatedTest(10)
	void 중복체크() {
		assertThat(numbers.size()).isEqualTo(numbers.stream().distinct().count());
	}
}