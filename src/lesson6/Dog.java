package lesson6;

public class Dog extends Animal {

    public Dog (String name, int possibleDistanceToRun, int possibleDistanceToSwim) {
        super(name, possibleDistanceToRun, possibleDistanceToSwim);
    }

    @Override
    public void run (int actualDistanceRun) {
        if (actualDistanceRun <= possibleDistanceToRun) {
            System.out.println("Пёс " + name + " со звонким лаем промчался " + actualDistanceRun + " метров.");
        }
        if (actualDistanceRun > possibleDistanceToRun) {
            System.out.println("Пробежать " + actualDistanceRun + "метров???" + "Пес" + name + " сидит на месте и скулит. Ведь больше "
                    + possibleDistanceToRun + " метров он пробежать не сможет.");
        }
    }

    @Override
    public void swim (int actualDistanceSwim) {
        if (actualDistanceSwim <= possibleDistanceToSwim) {
            System.out.println("Пёс " + name + " бросился в воду и проплыл " + actualDistanceSwim + " метров.");
        }
        if (actualDistanceSwim > possibleDistanceToSwim) {
            System.out.println("Проплыть " + actualDistanceSwim + " метров??? Пёс " + name + " тихо стучится головой об стену. Ведь больше "
                    + possibleDistanceToSwim + " метров он не проплывет.");
        }
    }
}
