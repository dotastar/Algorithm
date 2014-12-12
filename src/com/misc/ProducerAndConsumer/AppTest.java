package com.misc.ProducerAndConsumer;

/**
 * Created by Xiaomeng on 12/11/2014.
 */
public class AppTest {
    public static void main(String[] args){
        Drop drop = new Drop();
        Thread producer = new Thread(new Producer(drop));
        Thread consumer = new Thread(new Consumer(drop));
        producer.start();
        consumer.start();
    }
}
