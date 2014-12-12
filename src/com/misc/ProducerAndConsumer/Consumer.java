package com.misc.ProducerAndConsumer;

/**
 * Created by Xiaomeng on 12/11/2014.
 */
public class Consumer implements Runnable{
    private Drop drop;

    public Consumer(Drop drop){
        this.drop = drop;
    }

    public void run(){
        for(String message = drop.take(); !message.equals("Done"); message = drop.take()){
            System.out.println("Message Received: " + message);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}
