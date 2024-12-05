package main.java.task2;

/**
 * Сыр Балыковый (Балык)
 */
public class BalykChees implements Snack{
    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Сыр (Балык)";
    }
}
