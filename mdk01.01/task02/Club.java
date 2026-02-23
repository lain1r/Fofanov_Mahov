package org.example.fitness;

import java.time.LocalTime;
import java.util.ArrayList;

public class Club {
    private static final int GYM_CAPACITY = 50;
    private static final int POOL_CAPACITY = 20;
    private static final int GROUP_CAPACITY = 10;

    private ArrayList<Abonement> gymClients = new ArrayList<>();
    private ArrayList<Abonement> poolClients = new ArrayList<>();
    private ArrayList<Abonement> groupClients = new ArrayList<>();

    public void registerClient(Abonement abonement, ZoneType zone, LocalTime currentTime) {
        System.out.println("Попытка регистрации: " + abonement.getOwner().lastName + " в " + zone + " в " + currentTime);

        if (abonement.isExpired()) {
            System.out.println("  Абонемент просрочен.\n");
            return;
        }

        if (!abonement.canAccess(zone, currentTime)) {
            System.out.println("Нет доступа в эту зону в это время.\n");
            return;
        }

        switch (zone) {
            case GYM:
                if (gymClients.size() >= GYM_CAPACITY) {
                    System.out.println("Тренажерный зал полон.\n");
                    return;
                }
                gymClients.add(abonement);
                break;
            case POOL:
                if (poolClients.size() >= POOL_CAPACITY) {
                    System.out.println("Бассейн полон.\n");
                    return;
                }
                poolClients.add(abonement);
                break;
            case GROUP:
                if (groupClients.size() >= GROUP_CAPACITY) {
                    System.out.println("Зал групповых занятий полон.\n");
                    return;
                }
                groupClients.add(abonement);
                break;
        }
        System.out.println(abonement.getOwner().lastName + " вошел в " + zone + ".\n");
    }

    public void closeClub() {
        gymClients.clear();
        poolClients.clear();
        groupClients.clear();
        System.out.println("КЛУБ ЗАКРЫТ. Все клиенты покинули зоны.");
    }

    public void printCurrentClients() {
        System.out.println("Тренажерный зал (" + gymClients.size() + "/" + GYM_CAPACITY + "): " + gymClients);
        System.out.println("Бассейн (" + poolClients.size() + "/" + POOL_CAPACITY + "): " + poolClients);
        System.out.println("Групповые (" + groupClients.size() + "/" + GROUP_CAPACITY + "): " + groupClients);
    }
}