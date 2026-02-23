package org.example.fitness;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Club club = new Club();

        Person person1 = new Person("Иван", "Иванов", 1990);
        Person person2 = new Person("Мария", "Петрова", 1995);
        Person person3 = new Person("Сергей", "Сидоров", 1985);
        Person person4 = new Person("Анна", "Кузнецова", 2000);

        Abonement single = new SingleAbonement(person1);
        Abonement daytime = new DaytimeAbonement(person2, LocalDate.now().plusMonths(1));
        Abonement full = new FullTimeAbonement(person3, LocalDate.now().plusYears(1));
        Abonement expired = new FullTimeAbonement(person4, LocalDate.now().minusDays(1));


        System.out.println("Если Утро (10:00)");
        LocalTime morning = LocalTime.of(10, 0);

        club.registerClient(single, ZoneType.POOL, morning);
        club.registerClient(daytime, ZoneType.GROUP, morning);
        club.registerClient(full, ZoneType.GYM, morning);
        club.registerClient(expired, ZoneType.GYM, morning);

        club.registerClient(daytime, ZoneType.POOL, morning);
        club.registerClient(single, ZoneType.GROUP, morning);

        club.printCurrentClients();


        System.out.println("\nЕсли Вечер (18:00)");
        LocalTime evening = LocalTime.of(18, 0);

        club.registerClient(daytime, ZoneType.GYM, evening);
        club.registerClient(full, ZoneType.POOL, evening);
        club.registerClient(single, ZoneType.GYM, evening);

        club.printCurrentClients();


        System.out.println("\nЕсли Ночь (23:00)");
        LocalTime night = LocalTime.of(23, 0);
        club.registerClient(full, ZoneType.GYM, night);


        club.closeClub();
        club.printCurrentClients();
    }
}
