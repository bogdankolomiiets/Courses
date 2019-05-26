package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main{
    private NewYearsGift newYearsGift;
    private static Logger LOGGER = Logger.getLogger(Main.class);
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.serialiseObjects();
        Console console = System.console();
        try {
            FileInputStream fis = new FileInputStream(Main.class.getResource("filesPath.properties").getFile());
            Properties properties = new Properties();
            try {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String outFile = properties.getProperty("outFile");
            PrintStream printStream = new PrintStream(new FileOutputStream(outFile));
            String temp;
            while ((temp = console.readLine()) != null){
                printStream.append(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        //console menu
        boolean consoleLoop = false;
        String temp;
        do {
            System.out.println("Hello. Start initialisation? Press Y or Q to exit");
            temp = scanner.nextLine().toUpperCase();
            switch (temp){
                case "Y":
                    consoleLoop = true;
                    break;
                case "Q":
                    System.out.println("Program has finished.");
                    System.exit(0);
            }
        }
        while (!consoleLoop);

        createGift();
        //Display new years gift
        System.out.println(newYearsGift);
        //sort method with console menu
        sortGift();
        //Display new years gift after sorting
        System.out.println(newYearsGift);
        //Find confectionery in new years gift
        System.out.println();
        //find confectionery by parameters
        System.out.println(newYearsGift.getConfectionery("korivka"));
    }

    private void createGift() {
        //Create confectionery factory which will be made products
        ConfectioneryFactory confectioneryFactory = new RoshenConfectioneryFactoryImpl();
        confectioneryFactory.makeConfectionery();
        //Create empty new years gift
        newYearsGift = new NewYearsGift();
        Scanner s = new Scanner(System.in);
        int usersCount = 0;
        int maxCountOfEachKindOfConfectionery = 20;
        do {
            System.out.println("Please specify the count of each kind of confectionery in the gift. Max count = " + maxCountOfEachKindOfConfectionery);
            usersCount = s.hasNext(Pattern.compile("\\d+")) ? s.nextInt() : 0;
            s.nextLine();
        } while (usersCount < 1 || usersCount > maxCountOfEachKindOfConfectionery);
        //put confectionery to the gift
        newYearsGift.putToGift(confectioneryFactory.getConfectionery(), usersCount);

    }

    public void sortGift() {
        System.out.println("\nPlease select sorting method: enter any symbol - BY_NAME, 2 - BY_WEIGHT.");
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
    }

    public void serialiseObjects() {
        System.out.println("Serialize objects? Y - yes, N - not.");
        boolean loop;
        String temp;
        do {
            temp = scanner.nextLine();
            loop = temp.equalsIgnoreCase("Y") ? false : temp.equalsIgnoreCase("N") ? false : true;
        } while (loop);

        if (temp.equalsIgnoreCase("Y")) {
            try {
                LOGGER.debug("Serialization started...");
                try (ObjectOutputStream outputStream = new ObjectOutputStream(
                        new FileOutputStream(newYearsGift.getClass().getSimpleName() + ".ser"));) {
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
