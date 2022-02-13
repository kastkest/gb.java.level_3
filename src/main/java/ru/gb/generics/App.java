package ru.gb.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        String[] stringArray = {"Котик", "Уточков", "Бобик"};
        Integer[] intArray2 = {10, 20, 30, 40, 50, 60};
        String[] stringArray2 = {"Java", "Python", "JS", "C++"};
        App app = new App();
        System.out.println(Arrays.toString(app.changePlace(intArray, 2, 4)));
        System.out.println(Arrays.toString(app.changePlace(stringArray, 0, 2)));
        System.out.println();

        System.out.println(app.arrayToList(intArray2));
        System.out.println(app.arrayToList(stringArray2));
        System.out.println();

        List<Fruit> fruitList = new ArrayList<Fruit>();
        fruitList.add(new Apple(1.0f));
        fruitList.add(new Apple(1.0f));
        fruitList.add(new Apple(1.0f));
        fruitList.add(new Orange(1.5f));
        fruitList.add(new Orange(1.5f));
        fruitList.add(new Orange(1.5f));

        Box<Apple> appleBox = Box.create();
        Box<Orange> orangeBox = Box.create();
        appleBox.put(new Apple(1.0f));
        appleBox.put(new Apple(1.0f));
        appleBox.put(new Apple(1.0f));
        appleBox.put(new Apple(1.0f));
        appleBox.put(new Apple(1.0f));
        System.out.println(appleBox.getWeight());

        orangeBox.put(new Orange(1.5f));
        orangeBox.put(new Orange(1.5f));
        orangeBox.put(new Orange(1.5f));
        System.out.println(orangeBox.getWeight());

        Box<Apple> newAppleBox = Box.create();
        appleBox.shift(newAppleBox);
        System.out.println(appleBox.getWeight());
        System.out.println(newAppleBox.getWeight());

        System.out.println(newAppleBox.compareTo(orangeBox));
    }

    public <T> T[] changePlace(T[] param, int firstPosition, int secondPosition) {

        T temp = param[firstPosition];
        param[firstPosition] = param[secondPosition];
        param[secondPosition] = temp;
        return param;
    }

    public <T> ArrayList<T> arrayToList(T[] param) {

        return new ArrayList<>(Arrays.asList(param));
    }


}

