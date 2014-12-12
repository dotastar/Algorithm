package com.misc.ProducerAndConsumer;

/**
 * Created by Xiaomeng on 12/11/2014.
 */
public class Producer implements Runnable{
    private Drop drop;

    public Producer(Drop drop){
        this.drop = drop;
    }

    public void run(){
        String[] messasges = {"Peter", "Michael", "Russel", "T-Mac", "Kobe"};
        for(String message : messasges){
            drop.put(message);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
        }
        drop.put("Done");
    }
}
