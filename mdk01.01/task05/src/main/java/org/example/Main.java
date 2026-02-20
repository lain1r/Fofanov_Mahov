package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        int setTime = 20;
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        db.isConnection();
        db.createTables();

        //основные блюда
        Eat salad = new Eat("Салат Цезарь", 400, Eat.isVEGAN.VEGAN, Eat.TYPE.SALAD, 1415);
        Eat steak = new Eat("Стейк Рибай", 1500, Eat.isVEGAN.N0_VEGAN, Eat.TYPE.MEAT, 2650);
        Eat salmon = new Eat("Лосось на гриле", 900, Eat.isVEGAN.N0_VEGAN, Eat.TYPE.FISH, 3115);
        Drinks coke = new Drinks("Кола", 150, Drinks.TYPE.NO_ALCOHOL, 145);
        Drinks wine = new Drinks("Вино (бокал)", 500, Drinks.TYPE.ALCOHOL, 455);

        // блюда от шеф-повора
        Eat spec1 = new Eat("Блюдо от шефа: Питерские Пышки", 300, Eat.isVEGAN.VEGAN, Eat.TYPE.OTHER, 315);
        Eat spec2 = new Eat("Блюдо от шефа: Ленинградский Рассольник", 550, Eat.isVEGAN.N0_VEGAN, Eat.TYPE.SOUP, 365);
        Eat spec3 = new Eat("Блюдо от шефа: Московский Борщ", 600, Eat.isVEGAN.N0_VEGAN, Eat.TYPE.SOUP, 375);
        Eat spec4 = new Eat("Блюдо от шефа: Котлета Пожарская", 750, Eat.isVEGAN.N0_VEGAN, Eat.TYPE.MEAT, 890);
        Eat spec5 = new Eat("Блюдо от шефа: Утиная грудка Су-вид", 1200, Eat.isVEGAN.N0_VEGAN, Eat.TYPE.MEAT, 1450);

        Eat bizLunch = new Eat("Бизнес-ланч", 500, Eat.isVEGAN.N0_VEGAN, Eat.TYPE.MEAT, 555);
        Eat morningEat = new Eat("Овсянка с фруктами", 250, Eat.isVEGAN.VEGAN, Eat.TYPE.OTHER, 215);

        Restaurant spb1 = new Restaurant("Кафе 'Зингер'", "SPB");
        Restaurant spb2 = new Restaurant("Палкинъ", "SPB");

        Restaurant msk1 = new Restaurant("Dr. Живаго", "Moscow");
        Restaurant msk2 = new Restaurant("Пушкинъ", "Moscow");
        Restaurant msk3 = new Restaurant("White Rabbit", "Moscow");

        spb1.addEat(spec1);
        spb2.addEat(spec2);
        msk1.addEat(spec3);
        msk2.addEat(spec4);
        msk3.addEat(spec5);

        restaurants.add(spb1);
        restaurants.add(spb2);
        restaurants.add(msk1);
        restaurants.add(msk2);
        restaurants.add(msk3);



        System.out.println("Здраствуйте, выберите город и ресторан в котором будете кушать.");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.print(i+1 + " ");
            System.out.println(restaurants.get(i));
        }


        Restaurant restaurantChoice = restaurants.get(sc.nextInt() - 1);
        restaurants.clear();
        if (restaurantChoice.getCity() == "Moscow") {
            double i = 1.1;
            salad.setNewCount(salad.getCount()*i);
            steak.setNewCount(steak.getCount()*i);
            salmon.setNewCount(salmon.getCount()*i);
            coke.setNewCount(coke.getCount()*i);
            wine.setNewCount(wine.getCount()*i);
        }
        if (setTime >= 15 && setTime <= 18) {
            double i = 0.2;
            salad.setNewCount(salad.getCount() - salad.getCount()*i);
            steak.setNewCount(steak.getCount() - steak.getCount()*i);
            salmon.setNewCount(salmon.getCount() -  salmon.getCount()*i);
            coke.setNewCount(coke.getCount() -  coke.getCount()*i);
            wine.setNewCount(wine.getCount() -  wine.getCount()*i);
        }

        if (setTime >= 12 && setTime <= 15) {
            restaurantChoice.delEat(0);
            restaurantChoice.addEat(bizLunch);
        } else if (setTime >= 7 && setTime <= 11) {
            restaurantChoice.delEat(0);
            restaurantChoice.addEat(morningEat);
        } else {
            restaurantChoice.addEat(salad);
            restaurantChoice.addEat(steak);
            restaurantChoice.addEat(salmon);
        }

        restaurantChoice.addDrinks(coke);
        restaurantChoice.addDrinks(wine);

        ArrayList<Drinks> orderDrink = new ArrayList<>();
        ArrayList<Eat> orderEat = new ArrayList<>();

        for (int i = 0;i < restaurantChoice.getArrEat().size();i++) {
            System.out.print(i+1 + " ");
            System.out.println(restaurantChoice.getMenu(i));
        }
        System.out.println("--------------------------------------------------------\nчто закажите из основного меню? 0 для выхода");
        int choice;
        while (true){
            choice = sc.nextInt();
            if (choice == 0) break;
            orderEat.add(restaurantChoice.getMenu(choice - 1));
            System.out.println("хотите что то ещё? 0 для выхода");

        }

        for (int i = 0;i < restaurantChoice.getArrDrink().size();i++) {
            System.out.print(i+1 + " ");
            System.out.println(restaurantChoice.getDrinksMenu(i));
        }
        System.out.println("--------------------------------------------------------\nчто закажите из барного меню? 0 для выхода");
        while (true){
            choice = sc.nextInt();
            if (choice == 0) break;
            orderDrink.add(restaurantChoice.getDrinksMenu(choice - 1));
            System.out.println("хотите что то ещё? 0 для выхода");

        }


        double suma = orderEat.stream().mapToDouble(s -> s.getCount()).sum() + orderDrink.stream().mapToDouble(s -> s.getCount()).sum();

        int id = db.addReceipt(suma);
        orderEat.forEach(s -> {
            try {
                db.addReceiptItem(s.getName(), s.getCount(), id);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        orderDrink.forEach(s -> {
            try {
                db.addReceiptItem(s.getName(), s.getCount(), id);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("--------------------------------------------------------\nсумма заказа: " + suma);
    }
}
