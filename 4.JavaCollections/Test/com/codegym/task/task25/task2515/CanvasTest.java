package com.codegym.task.task25.task2515;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanvasTest {

    @Test
    void clear() {
        Canvas cv = new Canvas(5,5);
        cv.clear();
        char[][] mt = cv.getMatrix();
    }
}