package com.codegym.task.task37.task3702;

import com.codegym.task.task37.task3702.female.FemaleFactory;
import com.codegym.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType){
        if(humanFactoryType == HumanFactoryType.MALE)
            return new MaleFactory();

        return new FemaleFactory();
    }

    // nepatri k ulohe
    static Human createHuman(FactoryProducer.HumanFactoryType humanFactoryType, int age){
        if(humanFactoryType == HumanFactoryType.MALE)
            return new MaleFactory().getPerson(age);

        return new FemaleFactory().getPerson(age);
    }

    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }
}
