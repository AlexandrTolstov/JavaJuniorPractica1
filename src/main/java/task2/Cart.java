package main.java.task2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food>{
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market){
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuff(){
        return foodstuffs;
    }

    public void printFoodstuff(){
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancing(){
//        boolean proteins = false;
//        boolean fats = false;
//        boolean cardohydrates = false;

//        for(var food : foodstuffs){
//            if(!proteins && food.getProteins())
//                proteins = true;
//            else if(!fats && food.getFats())
//                fats = true;
//            else if(!cardohydrates && food.getCarbohydrates())
//                cardohydrates = true;
//            else if(proteins && fats && cardohydrates)
//                break;
//        }

        boolean proteins = foodstuffs.stream().anyMatch(Food::getProteins);
        boolean fats = foodstuffs.stream().anyMatch(Food::getFats);
        boolean cardohydrates = foodstuffs.stream().anyMatch(Food::getCarbohydrates);

        if(proteins && fats && cardohydrates){
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        if(!proteins){
            foodstuffs.add((T)market.getThings(Food.class).stream().filter(Food::getProteins).findAny().orElse(null));
            proteins = true;
        } else if (!fats) {
            foodstuffs.add((T)market.getThings(Food.class).stream().filter(Food::getFats).findAny().orElse(null));
            fats = true;
        } else if (!cardohydrates) {
            foodstuffs.add((T)market.getThings(Food.class).stream().filter(Food::getFats).findAny().orElse(null));
            cardohydrates = true;
        }


//        for(var thing : market.getThings(Food.class)){
//            if(!proteins && thing.getProteins()){
//                proteins = true;
//                foodstuffs.add((T)thing);
//            }
//            else if (!fats && thing.getFats()) {
//                fats = true;
//                foodstuffs.add((T)thing);
//            }
//            else if (!cardohydrates && thing.getCarbohydrates()) {
//                cardohydrates = true;
//                foodstuffs.add((T)thing);
//            }
//            if(proteins && fats && cardohydrates)
//                break;
//        }

        if(proteins && fats && cardohydrates){
            System.out.println("Корзина уже сбалансирована по БЖУ.");
        }
        else {
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
        }
    }
}
