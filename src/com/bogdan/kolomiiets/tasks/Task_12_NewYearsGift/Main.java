package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

public class Main {
    public static void main(String[] args) {
        ConfectioneryFactory factory = new RoshenConfectioneryFactoryImpl();
        factory.makeConfectionery(new Candy(CandiesName.CRAZY_BEE, 2), 5000);
    }
}
