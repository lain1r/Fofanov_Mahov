package org.example.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class SingleAbonement extends Abonement {
    public SingleAbonement(Person owner) {
        super(owner, LocalDate.now());
    }

    @Override
    public boolean canAccess(ZoneType zone, LocalTime time) {
        boolean timeOk = !time.isBefore(LocalTime.of(8, 0)) && time.isBefore(LocalTime.of(22, 0));
        boolean zoneOk = (zone == ZoneType.POOL || zone == ZoneType.GYM);
        return timeOk && zoneOk;
    }
}