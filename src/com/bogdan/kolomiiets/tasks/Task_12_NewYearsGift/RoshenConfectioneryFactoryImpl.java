package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class RoshenConfectioneryFactoryImpl implements ConfectioneryFactory {
    private Map<Confectionery, Integer> confectionery = new HashMap<>();
    public Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void makeConfectionery(Confectionery confectionery, Integer kilo) {
        if (confectionery != null && kilo > 0) {
            this.confectionery.put(confectionery, kilo);
        } else {
            logger.warn(this.getClass().getSimpleName() + " can't made confectionery. Cause: parameter confectionery equals " + confectionery + " kilo = " + kilo);
        }
    }

    @Override
    public Map<Confectionery, Integer> getConfectionery() {
        return confectionery;
    }

}
