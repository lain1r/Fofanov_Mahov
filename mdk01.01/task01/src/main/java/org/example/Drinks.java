package org.example;

public class Drinks {
    enum TYPE {
        ALCOHOL,
        NO_ALCOHOL
    }

    private String name;
    private int kkal;
    private TYPE type;
    private int count;

    public Drinks(String name, int kkal, TYPE type, int count) {
        this.name = name;
        this.kkal = kkal;
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
                ", тип-" + type + "\nстоимость = " + count;
    }
}
