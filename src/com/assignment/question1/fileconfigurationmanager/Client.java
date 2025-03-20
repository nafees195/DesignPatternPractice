package com.assignment.question1.fileconfigurationmanager;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(10);
        InstanceProvider instanceProvider=new InstanceProvider();
        Future<FileBasedConfigurationManagerImpl> future=es.submit(instanceProvider);
        for(int i=1;i<=100;i++){
            System.out.println(future.get());
        }
        es.shutdown();
    }
}
