package lesson7;

public class Cat {
    String name;
    boolean satiety;
    int foodPerMeal;

    public Cat (String name, boolean satiety, int foodPerMeal) {
        this.name = name;
        this.satiety = satiety;
        this.foodPerMeal = foodPerMeal;
    }

    public void info() {
        System.out.println(name + " " + satiety);
    }

    public void eat(Plate plate) {
        if (plate.getIsFoodEnough(foodPerMeal) && satiety == false) {
            plate.decreasePerMeal(foodPerMeal);
            System.out.println(name + " быстро свистнул с тарелки " + foodPerMeal + " еды" +
                    " и довольно облизнулся");
            satiety = true;
            return;
        }

        if (!plate.getIsFoodEnough(foodPerMeal) && satiety == false) {
            System.out.println((name + " остался голодным! На тарелке нет " + foodPerMeal + " еды."));
            satiety = false;
            return;
        }

        if (satiety == true) {
            System.out.println(name + " деликатно стоит в сторонке и ждет пока покушают голодные товарищи.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
}
