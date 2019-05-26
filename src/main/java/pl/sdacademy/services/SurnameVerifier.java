package pl.sdacademy.services;

public class SurnameVerifier {

    public boolean isValid(final String surname) {
        return surname.length() >= 2;
    }

    void test() {

    }
}
