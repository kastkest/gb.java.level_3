package ru.gb.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import static ru.gb.concurrency.MainClass.CARS_COUNT;

public class Tunnel extends Stage {

    private Semaphore tunnelSemaphore;
    private CyclicBarrier cyclicBarrier;


    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.tunnelSemaphore = new Semaphore(2,true);
        this.cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                tunnelSemaphore.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                tunnelSemaphore.release();
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}