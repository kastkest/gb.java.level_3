package ru.gb.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        start(Cat.class, cat);
    }

    public static void start(Class clazz, Cat cat) {
        int beforeCount = 0;
        int afterCount = 0;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println();
            if (method.getDeclaredAnnotation(BeforeSuite.class) != null) {
                beforeCount++;
                if (beforeCount <= 1) {
                    try {
                        method.invoke(cat, null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            if (method.getDeclaredAnnotation(Test.class) != null) {
                try {
                    System.out.println(method.invoke(cat, null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (method.getDeclaredAnnotation(AfterSuite.class) != null) {
                afterCount++;
                if (afterCount <= 1) {
                    try {
                        System.out.println(method.invoke(cat, null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
    }
}
