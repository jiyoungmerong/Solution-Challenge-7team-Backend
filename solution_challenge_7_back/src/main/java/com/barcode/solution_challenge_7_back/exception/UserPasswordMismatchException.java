package com.barcode.solution_challenge_7_back.exception;

public class UserPasswordMismatchException extends Exception {
    public UserPasswordMismatchException(String message) {
        super(message);
    }
}