package com.codegym.task.task37.task3711;

public class Computer {
    private CPU cpu = new CPU();
    private HardDrive hardDrive = new HardDrive();
    private Memory memory = new Memory();

    void run(){
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
