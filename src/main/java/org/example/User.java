package org.example;

public class User {
    private String password;
    public void initPassword(PasswordGenerator passwordGenerator) {

        // as-is
        //RandomPasswordGenerator passwordGenerator = new RandomPasswordGenerator();

        // to-be
        String password = passwordGenerator.generatePassword();

        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
