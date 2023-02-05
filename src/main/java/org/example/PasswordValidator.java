package org.example;

public class PasswordValidator {

    public static final String MESSAGE_EXCEPTION_WRONG_PASSWORD_LENGTH = "비밀번호는 최소 8자 이상 12자 이하여야 한다.";

    public static void validate(String password) {
        int length = password.length();

        if (length <= 8 || length > 12) {
            throw new IllegalArgumentException(MESSAGE_EXCEPTION_WRONG_PASSWORD_LENGTH);
        }
    }
}
