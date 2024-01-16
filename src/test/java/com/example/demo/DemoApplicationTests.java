package com.example.demo;

import com.example.demo.subject.SubjectType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void enumtest() {
		String type = "korean";

		Assertions.assertThat(SubjectType.KOREAN.name()).isEqualTo(type);
	}

}
