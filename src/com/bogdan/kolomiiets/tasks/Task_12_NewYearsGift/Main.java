package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

public class Main {
    private static ConfectioneryFactory confectioneryFactory;
    private static NewYearsGift newYearsGift;

    public static void main(String[] args) {
        confectioneryFactory = new RoshenConfectioneryFactoryImpl();
        confectioneryFactory.makeConfectionery();
        newYearsGift = new NewYearsGift();
        newYearsGift.putToGift(confectioneryFactory.getConfectionery(), 3);
    }
}
