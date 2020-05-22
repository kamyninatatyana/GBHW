import java.util.Random;
import java.util.Scanner;

public class MasterClass {

    public static class HW03 {
        static Scanner sc;

        public static void main(String[] args) {
            sc = new Scanner(System.in);

            guessNumber();
            guessWord();

        }
            /* 1 Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3
            попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
            указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
            выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).*/

        public static void guessNumber() {

            int number = (int) (Math.random() * 10);
            String prefix = "";
            System.out.println("Фанзиль, я оставила Вам здесь подсказку: " + number);
            System.out.println("Введите число от 0 до 9.");

            for (int i = 1; i <= 3; i++) {
                int userAnswer = sc.nextInt();

                if (userAnswer == number) {
                    System.out.println("Поздравляю! Вы угадали!");
                    continueOrNot(userAnswer, i);
                    break;
                } else if (userAnswer > number) {
                    prefix = "больше";
                } else if (userAnswer < number) {
                    prefix = "меньше";
                }
                message(i, prefix);
                yesOrNo(i, number, userAnswer);

            }
            return;
        }

        /*
         * Метод проверяет остались ли попытки и предлагает ввести число, если попытки остались или сообщает
         * что попытки закончились и называет загаданное число.
         * */

        public static void yesOrNo(int i, int number, int userAnswer) {
            if ((3 - i) != 0) {
                System.out.println("Введите число");
            } else {
                System.out.println("К сожалению, Ваши попытки закончились! Загаданное число " + number);
                continueOrNot(userAnswer, i);
            }
        }

        /*
         * Метод выводит сообщение - число, которое ввел пользователь больше или меньше загаданного.
         * */

        public static void message(int i, String prefix) {
            System.out.println("Ваше число " + prefix + "! У Вас осталось " + (3 - i) + " попыток.");
        }

        /*
         * Метод задает вопрос нужно ли продолжить игру и если пользователь нажмет 1 - игра продолжится, в любом
         * другом случае - закончится.
         * */

        public static void continueOrNot(int UserAnswer, int i) {


            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int userAnswer = sc.nextInt();

            if (userAnswer == 1) {
                guessNumber();
            } else if (userAnswer == 0) {
                System.out.println("Спасибо за игру!");
                return;
            } else {
                System.out.println("1 – да / 0 – нет. Повторить игру еще раз?");
                userAnswer = sc.nextInt();
            }
        }


            /* 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
            При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его
            с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер
            показывает буквы, которые стоят на своих местах.
            apple – загаданное
            apricot - ответ игрока
            ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
            Для сравнения двух слов посимвольно можно пользоваться:
            String str = "apple";
            char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
            Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы. */

        public static void guessWord() {

            String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                    "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                    "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

            int number = (int) (Math.random() * words.length);
            String userAnswer = "";
            String word = words[number]; // загаданное слово
            System.out.println("Фанзиль, я поставила Вам здесь подсказку: " + word);

            int minLength = word.length(); // переменная для хранения минимальной длины, нужна для ограничения цикла
            // по этому признаку, иначе цикл будет вылетать за границы слова.

            while (true) {
                String finalTemplate = "";
                System.out.println("Угадайте слово /это название овоща или фрукта на английском языке/");
                userAnswer = sc.next();

                if (userAnswer.length() <= word.length()) { //определяем ограничение для цикла, который будет
                    // искать совпадение символов между загаданным словом и ответом пользователя
                    minLength = userAnswer.length();
                }

                if (userAnswer.equals(word)) {
                    System.out.println("Поздравляем! Вы угадали! Загаданное слово " + word);
                    return;
                }

                for (int i = 0; i < minLength; i++) { // проверяем символы на совпадение

                    if (word.charAt(i) == userAnswer.charAt(i)) {
                        char template = userAnswer.charAt(i);
                        finalTemplate = finalTemplate + template;
                    } else if (word.charAt(i) != userAnswer.charAt(i)) {
                        finalTemplate = finalTemplate + "#";
                    }
                }

                for (int i = 1; i <= 15 - minLength; i++) { // дописываем # к проверенной части слова
                    finalTemplate = finalTemplate + "#";
                }
                System.out.println("Вы угадали следующие буквы: " + finalTemplate);
                System.out.println("Попробуйте еще раз");

            }
        }
    }
}



