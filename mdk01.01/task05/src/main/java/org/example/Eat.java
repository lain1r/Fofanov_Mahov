package org.example;

public class Eat {
    enum isVEGAN {
        VEGAN,
        N0_VEGAN
    }
    enum TYPE {
        MEAT,
        FISH,
        SALAD,
        OTHER,
        SOUP
    }

    private String name;
    private int kkal;
    private isVEGAN vegan;
    private TYPE type;
    private int count;

    public Eat(String name, int kkal, isVEGAN vegan, TYPE type, int count) {
        this.name = name;
        this.kkal = kkal;
        this.vegan = vegan;
        this.type = type;
        this.count = count;
    }

    public void setNewCount(double count) {
        this.count = (int) count;
    }

    public double getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", калорийность-" + kkal +
                ", веганское-" + vegan +
                ", тип-" + type + "\nстоимость = " + count;
    }
}
