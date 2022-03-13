package ru.gb.reflection;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @BeforeSuite
    public void before() {
        System.out.println("Before");
    }

    @Test(priority = 2)
    public String say() {
        return "Мяу";
    }
    @Test(priority = 1)
    public String jump() {
        return "Jump";
    }
    @Test(priority = 3)
    public String sleep() {
        return "Sleep";
    }

    @AfterSuite
    public void after() {
        System.out.println("After");
    }
}
