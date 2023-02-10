package org.example.calculate;

import org.example.cal.ArithmeticOperator;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> operators = List.of(
            new AdditionOperator(),
            new SubtractionOperator(),
            new MultiplicationOperator(),
            new DivisionOperator()
    );

    private static int calculate(int operand1, String operator, int operand2) {

       return operators.stream()
                .filter(operators -> operators.supports(operator))
                .map(operators -> operators.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

    }
}
