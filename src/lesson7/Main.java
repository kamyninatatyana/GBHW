package lesson7;

public class Main {

    public static void main(String[] args) {

        Cat[] catArray = {

                new Cat("Пушок", false, (int) (Math.random() * 50) + 1),
                new Cat("Барсик", false, (int) (Math.random() * 50) + 1),
                new Cat("Мурзик", false, (int) (Math.random() * 50) + 1),
                new Cat("Тигр", false, (int) (Math.random() * 50) + 1)
        };

        Plate plate = new Plate(50);
        plate.info();

        int satietyCats = 0;

        while (true) {

            for (int i = 0; i < catArray.length; i++) {

                catArray[i].eat(plate);
                plate.info();
                plate.fillPlate();
                catArray[i].info();
            }
            for (int i = 0; i < catArray.length; i++) {
                if (catArray[i].isSatiety()) {
                    satietyCats++;
                }
                if (satietyCats == catArray.length) {
                    System.out.println("Ура! Все коты сыты!");
                    return;
                }

            }


        }

    }
}

