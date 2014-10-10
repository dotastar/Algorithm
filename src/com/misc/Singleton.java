package com.misc;

/**
 * Created by Xiaomeng on 10/10/2014.
 */
public class Singleton implements java.io.Serializable{
    private static Singleton instance;

    //Alternative thread-safe singleton implementation
    //Drawback: you can't change your mind and allow multiple singleton instances later on
    //public final static Singleton INSTANCE = new Singleton();

    private Singleton(){

    }

    /**
     * Performance enhancement need to be applied instead of synchronizing the whole method
     *
     */
    public synchronized static Singleton getInstance1(){
        //Lazy initialization, only create when needed
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * Double-checked locking
     *
     * Unfortunately, double-checked locking is not guaranteed to work because the compiler is free to assign a value to the singleton member variable before the singleton's constructor is called.
     * If that happens, Thread 1 can be preempted after the singleton reference has been assigned, but before the singleton is initialized,
     * so Thread 2 can return a reference to an uninitialized singleton instance.
     *
     */
    public static Singleton getInstance2(){
        //Lazy initialization, only create when needed
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * This is used to avoid the serializable interface for case:
     * If you serialize a singleton and then deserialize it twice
     *
     */
    private Object readResolve() {
        return instance;
    }
}
