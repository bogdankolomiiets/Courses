package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    private NewYearsGift newYearsGift;
    private static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.serialiseObjects();
    }

    private void init() {
        //Create confectionery factory which will be made products
        ConfectioneryFactory confectioneryFactory = new RoshenConfectioneryFactoryImpl();
        confectioneryFactory.makeConfectionery();
        //Create empty new years gift
        newYearsGift = new NewYearsGift();
        //put confectionery to the gift
        newYearsGift.putToGift(confectioneryFactory.getConfectionery(), 3);
        //Display new years gift
        System.out.println(newYearsGift);
        GiftSorter sorter = new GiftSorter();
        sorter.sortGiftByName(newYearsGift, GiftSorter.BY_WEIGHT);
        //Display new years gift after sorting
        System.out.println(newYearsGift);
        //Find confectionery in new years gift
        System.out.println(newYearsGift.getConfectionery("korivka", 8));
    }

    public void serialiseObjects() {
        LOGGER.debug("Serialization started...");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(newYearsGift.getClass().getSimpleName() + ".ser"));){
            outputStream.writeObject(newYearsGift);
            LOGGER.info("Objects serialised successful.");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.warn("Objects don't serialised.", e);
        }
    }
}
