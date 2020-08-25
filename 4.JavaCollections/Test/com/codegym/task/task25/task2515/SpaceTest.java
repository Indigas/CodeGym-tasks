package com.codegym.task.task25.task2515;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {

    @Test
    void getAllItems() {
        Space sp = new Space(10,10);
        List<BaseObject> bo = new ArrayList<>();

        sp.getAllItems().stream().forEach(System.out::println);
        assertNull(sp.getAllItems());
    }
}