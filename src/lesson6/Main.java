package lesson6;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int catsTotal = 0;
        int dogsTotal = 0;


        Animal[] animalsArray = {

                new Cat("Мурзик", 200, 0),
                new Cat("Пушок", 250, 0),
                new Dog("Шарик", 500, 10),
                new Dog("Тузик", 400, 15),
                new Dog("Барбос", 600, 20)
        };

        for (int i = 0; i < animalsArray.length; i++) {
            animalsArray[i].run((int) (Math.random() * 600));
            animalsArray[i].swim((int) (Math.random() * 20));
            System.out.println();
        }

        for (int i = 0; i < animalsArray.length; i++) {
            if (animalsArray[i] instanceof Cat) {
                catsTotal++;
            }
            if (animalsArray[i] instanceof Dog) {
               dogsTotal++;
            }
        }

        System.out.println("Всего было создано " + catsTotal + " котов и " + dogsTotal + " собак.");

    }
}

