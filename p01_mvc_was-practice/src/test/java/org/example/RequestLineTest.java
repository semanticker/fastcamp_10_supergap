package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RequestLineTest {

    @DisplayName("객체가 올바르게 생성되어야 한다.")
    @Test
    void create() {

        String line = "GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1";

        RequestLine requestLine = new RequestLine(line);
        assertThat(requestLine).isNotNull();

        assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "operand1=11&operator=*&operand2=55"));
    }
}
