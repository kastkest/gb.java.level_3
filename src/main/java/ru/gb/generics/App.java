package ru.gb.generics;

import java.util.ArrayList;
import java.util.Arrays;

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
    }

    public <T> T[] changePlace(T[] param, int firstPosition, int secondPosition) {

        T temp = param[firstPosition];
        param[firstPosition] = param[secondPosition];
        param[secondPosition] = temp;
        return param;
    }

    public <T> ArrayList<T> arrayToList (T[] param) {
        return new ArrayList<>(Arrays.asList(param));
    }
}
