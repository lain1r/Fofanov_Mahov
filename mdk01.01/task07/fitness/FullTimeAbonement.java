package org.example.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class FullTimeAbonement extends Abonement {
    public FullTimeAbonement(Person owner, LocalDate endDate) {
        super(owner, endDate);
    }

    @Override
    public boolean canAccess(ZoneType zone, LocalTime time) {
        boolean timeOk = !time.isBefore(LocalTime.of(8, 0)) && time.isBefore(LocalTime.of(22, 0));
        boolean zoneOk = (zone == ZoneType.GYM || zone == ZoneType.POOL || zone == ZoneType.GROUP);
        return timeOk && zoneOk;
    }
}