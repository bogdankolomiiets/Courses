package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoshenConfectioneryFactoryImpl implements ConfectioneryFactory {
    private static Logger LOGER = Logger.getLogger(RoshenConfectioneryFactoryImpl.class);
    private List<Confectionery> confectionery = new ArrayList<>();

    @Override
    public boolean makeConfectionery(BufferedReader reader) {
        if (reader != null) {
            Pattern patternName = Pattern.compile("^\\w+.\\w+");
            Pattern patternWeight = Pattern.compile("\\d\\.?\\d?");
            Matcher matcherName;
            Matcher matcherWeight;
            String temp;
            try {
                while ((temp = reader.readLine()) != null) {
                    matcherName = patternName.matcher(temp);
                    matcherWeight = patternWeight.matcher(temp);
                    if (matcherName.find() && matcherWeight.find()) {
                        if (temp.contains("Candies")) {
                            confectionery.add(new Candy(matcherName.group(), Double.parseDouble(matcherWeight.group())));
                        } else if (temp.contains("Wafers")) {
                            confectionery.add(new Wafer(matcherName.group(), Double.parseDouble(matcherWeight.group())));
                        }
                    }
                }
                LOGER.info("Confectionery factory made " + confectionery.size() + " products");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        else {
            LOGER.warn("Confectionery don't made. Cause: reader = " + reader);
            return false;
        }
    }

    @Override
    public List<Confectionery> getConfectionery() {
        return confectionery;
    }

    @Override
    public String toString() {
        return confectionery.toString();
    }
}
