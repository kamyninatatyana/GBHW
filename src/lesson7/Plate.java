package lesson7;

public class Plate {

    private int food;
    boolean isFoodEnough = false;

    public Plate(int food) {
        this.food = food;
    }

    public void decreasePerMeal(int foodPerMeal) {
        if (foodPerMeal < food ) {
            food -= foodPerMeal;
        } else {
            return;
        }
    }

    public boolean getIsFoodEnough(int foodPerMeal) {
        if (foodPerMeal > food ) {
            isFoodEnough = false;

        } else {
            isFoodEnough = true;
        }
        return isFoodEnough;
    }

    public void info() {
        System.out.println("В тарелке: " + food + " еды.");
    }

    public void fillPlate() {
        if (isFoodEnough == false) {
            System.out.println("Вы положили в тарелку " + (50 - food));
            food = 50;
        }

    }
}
