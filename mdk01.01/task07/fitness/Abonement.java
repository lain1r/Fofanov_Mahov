package org.example.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Abonement {
    protected Person owner;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Abonement(Person owner, LocalDate endDate) {
        this.owner = owner;
        this.startDate = LocalDate.now();
        this.endDate = endDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(endDate);
    }

    public Person getOwner() {
        return owner;
    }

    public abstract boolean canAccess(ZoneType zone, LocalTime time);

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + " - " + owner.lastName + "]";
    }
}