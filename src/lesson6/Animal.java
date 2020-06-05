package lesson6;

public class Animal {
    String name;
    int possibleDistanceToRun;
    int possibleDistanceToSwim;

    public Animal (String name, int possibleDistanceToRun, int possibleDistanceToSwim) {
        this.name = name;
        this.possibleDistanceToRun = possibleDistanceToRun;
        this.possibleDistanceToSwim = possibleDistanceToSwim;

    }

    public void info() {
        System.out.println("Животное" + name + "может бегать - " + possibleDistanceToRun + "метров. " +
                "И может проплыть " + possibleDistanceToSwim + "метров.");
    }

    public void run (int actualDistanceRun) {
    System.out.println("Животное пробежало");
    }

    public int getPossibleDistanceToRun() {
        return possibleDistanceToRun;
    }

    public void swim(int actualDistanceSwim) {
        System.out.println("Животное проплыло");
    }

    public int getPossibleDistanceToSwim() {
        return possibleDistanceToSwim;
    }
}


