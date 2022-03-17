package ru.gb.concurrency;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import static ru.gb.concurrency.MainClass.CARS_COUNT;

public class Road extends Stage {

    private Semaphore roadSemaphore;
    private CyclicBarrier cyclicBarrier;


    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.roadSemaphore = new Semaphore(CARS_COUNT);
        this.cyclicBarrier = new CyclicBarrier(CARS_COUNT);

    }
    @Override
    public void go(Car c) {
        try {
            roadSemaphore.acquire();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            roadSemaphore.release();
            System.out.println(c.getName() + " закончил этап: " + description);
        }
    }
}