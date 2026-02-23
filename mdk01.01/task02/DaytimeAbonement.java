package org.example.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class DaytimeAbonement extends Abonement {
    public DaytimeAbonement(Person owner, LocalDate endDate) {
        super(owner, endDate);
    }

    @Override
    public boolean canAccess(ZoneType zone, LocalTime time) {
        boolean timeOk = !time.isBefore(LocalTime.of(8, 0)) && time.isBefore(LocalTime.of(16, 0));
        boolean zoneOk = (zone == ZoneType.GYM || zone == ZoneType.GROUP);
        return timeOk && zoneOk;
    }
}