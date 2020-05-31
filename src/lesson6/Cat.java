package lesson6;

public class Cat extends Animal {

    public Cat(String name, int possibleDistanceToRun, int possibleDistanceToSwim) {
        super(name, possibleDistanceToRun, possibleDistanceToSwim);
    }

    @Override
    public void run (int actualDistanceRun) {
        if (actualDistanceRun <= possibleDistanceToRun) {
            System.out.println("Кот " + name + " удрал и пулей пролетел " + actualDistanceRun + " метров.");
        }
        if (actualDistanceRun > possibleDistanceToRun) {
            System.out.println("Пробежать " + actualDistanceRun + " метров??? Кот " + name + " не хочет никуда бежать, так как знает, что больше "
                    + possibleDistanceToRun + " метров ему не пробежать.");
        }
    }

    @Override
    public void swim (int actualDistanceSwim) {
        System.out.println("Проплыть " + actualDistanceSwim + " метров??? Это невозможно!!! Кот " + name + " истошно кричит и упирается. Он не умеет плавать.");
    }
}
