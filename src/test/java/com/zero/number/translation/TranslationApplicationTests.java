package com.zero.number.translation;

import com.zero.number.translation.service.TranslationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TranslationApplicationTests {

    @Test
    void testZero() {
        Long number = Long.valueOf(0);
        String words = TranslationService.convert(number);
        assertThat(words).isEqualTo("Zero");
    }
    @Test
    void test1() {
        Long number = Long.valueOf(10);
        String words = TranslationService.convert(number);
        assertThat(words)
                .isEqualTo("Ten");
    }
    @Test
    void test2() {
        Long number = Long.valueOf(21);
        String words = TranslationService.convert(number);
        assertThat(words)
                .isEqualTo("Twenty one");
    }
    @Test
    void test3() {
        Long number = Long.valueOf(-21);
        String words = TranslationService.convert(number);
        assertThat(words)
                .isEqualTo("Negative twenty one");
    }
    @Test
    void test4() {
        Long number = Long.valueOf(101);
        String words = TranslationService.convert(number);
        assertThat(words)
                .isEqualTo("One hundred and one");
    }

    @Test
    void test5() {
        Long number = Long.valueOf(100);
        String words = TranslationService.convert(number);
        assertThat(words)
                .isEqualTo("One hundred");
    }
    @Test
    void test6() {
        Long number = Long.valueOf(1101);
        String words = TranslationService.convert(number);
        assertThat(words)
                .isEqualTo("One thousand one hundred and one");
    }
    @Test
    void test7() {
        Long number = Long.valueOf(1234123456789L);
        String words = TranslationService.convert(number);
        assertThat(words)
                .isEqualTo("One trillion two hundred thirty four billion one " +
                        "hundred twenty three million four hundred fifty six " +
                        "thousand seven hundred and eighty nine");
    }
    @Test
    void test8() {
        Long number = Long.valueOf(-1234123456789L);
        String words = TranslationService.convert(number);
        assertThat(words)
                .isEqualTo("Negative one trillion two hundred thirty four billion one " +
                        "hundred twenty three million four hundred fifty six " +
                        "thousand seven hundred and eighty nine");
    }
    @Test
    void test9() {
        Long number = Long.valueOf(1101);
        String words = TranslationService.convert(null);
        assertThat(words)
                .isEqualTo("Number can not be empty");
    }



}
