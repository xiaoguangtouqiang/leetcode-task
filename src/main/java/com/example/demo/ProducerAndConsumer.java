package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerAndConsumer {

    private static Integer maxSize = 5;

    class Producer implements Runnable {
        private List<Integer> container;

        public Producer(List<Integer> container) {
            this.container = container;
        }

        //生产一个产品
        public void produce() throws InterruptedException {
            synchronized (container) {
                while (maxSize == container.size()) {
                    System.out.println("容器满了，等一等");
                    container.wait();
                }
                Random random = new Random();
                int p = random.nextInt(50);
                System.out.println("生产产品：" + p);
                container.add(p);
                container.notifyAll();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        private List<Integer> container;

        public Consumer(List<Integer> container) {
            this.container = container;
        }

        public void consumer() throws InterruptedException {
            synchronized (container) {
                while (container.isEmpty()) {
                    System.out.println("容器空了，等一等");
                    container.wait();
                }
                Integer o = container.get(0);
                container.remove(o);
                System.out.println("消费产品：" + o);
                container.notifyAll();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        Producer producer1 = producerAndConsumer.new Producer(integers);
        Producer producer2 = producerAndConsumer.new Producer(integers);
        Thread thread1 = new Thread(producer1);
        Thread thread2 = new Thread(producer2);
        Thread thread3 = new Thread(producerAndConsumer.new Consumer(integers));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
