package ru.gb.generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box> {

    private List<T> fruits;

    private Box() {
        fruits = new ArrayList<>();
    }

    public boolean put(T fruit) {
        return fruits.add(fruit);
    }

    public float getWeight() {
        float boxWeight = 0;
        for (T fruit : fruits) {
            boxWeight = boxWeight + fruit.getWeight();
        }
        return boxWeight;
    }

    public void shift(Box<T> newBox) {
        ArrayList<T> copyFruits = new ArrayList<>();
        copyFruits.addAll(fruits);
        for (T fruit : copyFruits) {
            newBox.put(fruit);
            fruits.remove(fruit);
        }
    }

    public static <T extends Fruit> Box<T> create() {
        return new Box<>();
    }


    @Override
    public int compareTo(Box o) {
        return getWeight() > o.getWeight() ? 1 : -1;
    }
}
