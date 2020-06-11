package com.colorx.easy;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 * @author colorx
 * @version 1.0
 * @date 2020/6/11 9:40
 */
public class Test {
    private static  Test TEST = null;

    public static void main(String[] args) {
       for (int i = 0; i < 30; i++) {
                   new Thread( () -> {
                       System.out.println(getInstance());
                   } , String.valueOf(i) ).start();
               }


    }

    public static Test getInstance(){
        if (TEST == null){
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Test.class){
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                 if (TEST == null){
                     TEST = new Test();
                     return TEST;
                 }
                 return TEST;

            }
        }else {
            return TEST;
        }
    }
}
