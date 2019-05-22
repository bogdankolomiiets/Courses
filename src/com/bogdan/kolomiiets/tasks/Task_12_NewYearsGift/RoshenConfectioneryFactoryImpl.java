package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

import static com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift.ConfectioneryCatalog.*;

public class RoshenConfectioneryFactoryImpl implements ConfectioneryFactory {
    private static Logger LOGER = Logger.getLogger(RoshenConfectioneryFactoryImpl.class);
    private Map<Confectionery, Integer> confectionery = new HashMap<>();

    @Override
    public void makeConfectionery() {
        confectionery.put(new Candy(CRAZY_BEE), 5000);
        confectionery.put(new Candy(KORIVKA), 4500);
        confectionery.put(new Candy(MILKY_SPLASH), 1500);
        confectionery.put(new Candy(MINKY_BINKY), 3000);
        confectionery.put(new Candy(SLYVKY_LENYVKY), 2000);
        confectionery.put(new Wafer(ROSHETTO_DARK), 3000);
        confectionery.put(new Wafer(ROSHETTO_MILK), 3000);

        LOGER.debug(this.getClass().getSimpleName() + " made confectionery.");
    }

    @Override
    public Map<Confectionery, Integer> getConfectionery() {
        return confectionery;
    }

    @Override
    public String toString() {
        return confectionery.toString();
    }
}
