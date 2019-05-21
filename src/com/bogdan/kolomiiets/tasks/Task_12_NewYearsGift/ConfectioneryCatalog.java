package com.bogdan.kolomiiets.tasks.Task_12_NewYearsGift;

public enum ConfectioneryCatalog {
    MILKY_SPLASH(5, Candies.class),
    MINKY_BINKY(3.5, Candies.class),
    SLYVKY_LENYVKY(5.5, Candies.class),
    KORIVKA(7, Candies.class),
    JELLY(2.5, Candies.class),
    CRAZY_BEE(4, Candies.class),
    WAFERS_HAZELNUT(72, Wafers.class),
    WAFERS_CHOKO(72, Wafers.class),
    WAFERS_MILK(72, Wafers.class),
    ROSHETTO_DARK(32, Wafers.class),
    ROSHETTO_MILK(32, Wafers.class);

    private double weightGramme;
    private Class<? extends Confectionery> confectioneryType;

    public Class<? extends Confectionery> getConfectioneryType() {
        return confectioneryType;
    }

    public double getWeight(){
        return weightGramme;
    }

    ConfectioneryCatalog(double weightGramme, Class<? extends Confectionery> confectionery) {
        this.weightGramme = weightGramme;
        this.confectioneryType = confectionery;
    }
}
