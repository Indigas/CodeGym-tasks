package com.codegym.task.task25.task2515;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {

    @Disabled
    @Test
    void getAllItems() {
        Space sp = new Space(10,10);
        List<BaseObject> bo = new ArrayList<>();

        sp.getAllItems().stream().forEach(System.out::println);
        assertNull(sp.getAllItems());
    }

    @Disabled
    @Test
    void removeDead() {
        Space sp = new Space(20,20);
        sp.listOf.add(new Ufo(10,10));
        sp.listOf.add(new Bomb(1,1));
        sp.listOf.add(new Rocket(5,5));
        sp.listOf.get(0).setAlive(false);

        sp.removeDead();

        sp.listOf.forEach(System.out::println);

    }
}