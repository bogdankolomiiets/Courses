package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GiftMain {
    private static ConfectioneryFactory confectioneryFactory;
    private static NewYearsGift newYearsGift;
    private static Scanner scanner = new Scanner(System.in);
    private static Logger LOGGER = Logger.getLogger(GiftMain.class);

    public static void main(String[] args) {
        initParameters();
        createGift(confectioneryFactory);
        System.out.println(newYearsGift);
        sortGift();
        System.out.println(newYearsGift);
        findConfectioneryInGift();
        serialiseObjects();
    }

    public static boolean initParameters() {
        //Create confectionery factory which will be made products
        confectioneryFactory = new RoshenConfectioneryFactoryImpl();
        BufferedReader reader = null;
        try {

            FileInputStream fis = new FileInputStream(GiftMain.class.getClass().getResource("/filesPath.properties").getPath());
            Properties properties = new Properties();
            properties.load(fis);
            reader = new BufferedReader(new FileReader(properties.getProperty("inFile")));
        } catch (IOException e) {
            LOGGER.warn(e);
        }
        //If confectionery factory made confectionery go to next step else exit
        return confectioneryFactory.makeConfectionery(reader);
    }

    public static void createGift(ConfectioneryFactory factory) {
            //Create empty new years gift
            newYearsGift = new NewYearsGift();
            Scanner scanner = new Scanner(System.in);
            int countFromUser = 0;
            int maxCountOfEachKindOfConfectionery = 20;
            do {
                System.out.println("Please specify the count of each kind of confectionery in the gift. Max count = " + maxCountOfEachKindOfConfectionery);
                countFromUser = scanner.hasNext(Pattern.compile("\\d+")) ? scanner.nextInt() : 0;
                scanner.nextLine();
            } while (countFromUser < 1 || countFromUser > maxCountOfEachKindOfConfectionery);
            //put confectionery to the gift
            newYearsGift.putToGift(factory.getConfectionery(), countFromUser);
    }

    public static boolean sortGift() {
        System.out.println("\nPlease select sorting method: enter any symbol or ENTER - BY_NAME, 2 - BY_WEIGHT.");
        GiftSorter sorter = new GiftSorter();
        String temp = scanner.nextLine();
        boolean result;
        switch (temp) {
            case "2":
                result = sorter.sortGift(newYearsGift, GiftSorter.BY_WEIGHT);
                break;
            default:
                result = sorter.sortGift(newYearsGift, GiftSorter.BY_NAME);
                break;
        }
        return result;
    }

    public static void findConfectioneryInGift() {
        System.out.println("\nPlease specify name or weight of the product you want to find");
        Scanner scannerForFind = new Scanner(System.in);
        String res = scannerForFind.nextLine().replaceAll(",", ".");
        if (Pattern.matches("(\\d+[.|,]?\\d+)|\\d", res)) {
            newYearsGift.getConfectionery(Double.parseDouble(res));
        } else newYearsGift.getConfectionery(res);
    }

    public static void serialiseObjects() {
        System.out.println("\nSerialize objects? Y - yes, N - not.");
        boolean loop;
        String temp;
        do {
            temp = scanner.nextLine();
            loop = temp.equalsIgnoreCase("Y") ? false : temp.equalsIgnoreCase("N") ? false : true;
        } while (loop);

        if (temp.equalsIgnoreCase("Y")) {
            try {
                Properties properties = new Properties();
                FileInputStream fis = new FileInputStream(GiftMain.class.getClass().getResource("/filesPath.properties").getPath());
                properties.load(fis);
                LOGGER.info("Serialization started...");
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(properties.getProperty("outFile")))){
                    outputStream.writeObject(newYearsGift);
                    LOGGER.info("Objects serialised successful.");
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.warn("Objects don't serialised.", e);
                }
            } catch (Exception e) {
                LOGGER.warn("Objects not serialized.", e);
            }
        } else {
            System.out.println("You chose N - objects not serialized.");
        }
    }
}
