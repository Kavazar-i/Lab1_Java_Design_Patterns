package com.kalosha.lab.shapes.exeption;

import java.io.IOException;

public class IncorrectPointException extends IOException {
    public IncorrectPointException(String message) {
        super(message);
    }
}
