package com.wgc.designpattern.observerpattern;

/**
 * 具体观察者 -报告板
 * Created by Administrator on 8/14/2018.
 */
public class CurrentCondituonDisplay implements Observer,DisplayElement{

    private float temperature;
    private float pressure;
    private float humidity;
    private Subject weatherData;

    public CurrentCondituonDisplay(Subject subject){
        this.weatherData = subject;
        weatherData.registerObserver(this);//注册观察者
    }

    @Override
    public void display() {
        System.out.println("Current conditions:"+temperature+"F degrees and "+humidity+"% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
}
