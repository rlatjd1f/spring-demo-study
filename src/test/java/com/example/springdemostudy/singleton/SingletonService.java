package com.example.springdemostudy.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void lobic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

