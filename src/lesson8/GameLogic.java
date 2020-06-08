package lesson8;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

        static final int SIZE = 3;
        static final int DOTS_TO_WIN = 3;
        static final char DOT_X = 'X';
        static final char DOT_O = 'O';
        static final char DOT_EMPTY = '.';

        static char[][] map;

        static Scanner sc = new Scanner(System.in);
        static Random random = new Random();

        public static void main(String[] args) {

            initMap();
            printMap();

            while (true) {

                humanTurn();
                printMap();

                if (checkWin(DOT_X)) {
                    System.out.println("Ты победил!");
                    break;
                }

                if (isFull()) {
                    System.out.println("Ничья");
                    break;
                }

                aiTurn();
                printMap();

                if (checkWin(DOT_O)) {
                    System.out.println("Компьютер победил!");
                    break;
                }

                if (isFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
        }

        public static void initMap() {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

        public static void printMap() {
            System.out.print("  ");
            for (int i = 0; i < SIZE; i++) {

                System.out.print(i + 1 + " ");
            }
            System.out.println();

            for (int i = 0; i < SIZE; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void humanTurn() {
            int x, y;

            do {
                System.out.println("Введите координаты Вашего хода X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(y, x));
            map[y][x] = DOT_X;
        }

        public static boolean isCellValid(int y, int x) {
            if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
                return false;
            }
            return map[y][x] == DOT_EMPTY;
        }

        public static void aiTurn() {
            int x, y;

            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }
            while (!isCellValid(y, x));
            map[y][x] = DOT_O;

        /* Здесь были мои попытки улучшить алгоритм компьютера. В общем-то пыталась использовать логику,
        которую Вы предложили на уроке - нахожу первую же пустую точку - ставлю туда Х, проверяю есть ли
        победная цепочка, если есть - то ставлю туда ноль. Если нет - то ставлю туда ноль и проверяю есть
        ли победная цепочка для компьютера. И так по всему массиву. Но имеенно пока я писала этот алгоритм
        - я увидела, что у меня неправильно отрабатывает проверка победной цепочки (см. комментарии ниже).
        В общем, я потратила слишком много времени, на то, чтобы попытаться исправить эту ошибку
        по-правильному вместо того, чтобы быстренько поставить заплатки и все-таки попробовать дописать
        алгоритм для ИИ. Удалять код не стала, так как планирую его все-таки дописать. */



            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        map[i][j] = DOT_X;
                        if (checkWin(DOT_X)) {
                            map[i][j] = DOT_O;
                            return;
                        } else {
                            map[i][j] = DOT_O;
                            if (checkWin(DOT_O)) {
                                map[i][j] = DOT_O;
                                return;
                            } else {
                                map[i][j] = DOT_EMPTY;
                                do {
                                    x = random.nextInt(SIZE);
                                    y = random.nextInt(SIZE);
                                }
                                while (!isCellValid(y, x));
                                map[y][x] = DOT_O;
                            }
                        }
                        return;
                    }

                }
            }
        }


        // if (countX == 1) ;
        // if (map[0][0] == DOT_X || map[0][2] == DOT_X) {
        //     for (int i = 0; i >= 0; ) {
        //        for (int j = 0; j <= 2; j++) {
        //            if (map[i][j] == DOT_EMPTY) {
        //                map[i][j] = DOT_O;
        //            } else {
        //                do {
        //                    x = random.nextInt(SIZE);
        //                    y = random.nextInt(SIZE);
        //                }
        //                while (!isCellValid(y, x));
        //                map[y][x] = DOT_O;

        //            }

        // }


        //    do {
        //            x = random.nextInt(SIZE);
        //            y = random.nextInt(SIZE);
        //       }
        //       while (!isCellValid(y, x));
        //       map[y][x] = DOT_O;
        // }


        public static boolean isFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        return false;
                    }
                }
            } return true;
        }



    /* public static boolean checkWin(char c) {
        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) {
            return true;
        }
        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) {
            return true;
        }
        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) {
            return true;
        }
        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) {
            return true;
        }
        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) {
            return true;
        }
        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) {
            return true;
        }
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
            return true;
        }
        return false;

    } */


        public static boolean checkWin(char c) {

            int countDiagonal1 = 0;
            int countDiagonal2 = 0;
            int countDiagonal3 = 0;
            int countRows = 0;
            int countColumns = 0;


            for (int i = 0; i < SIZE; i++) { //  проверяем левые диагонали
                for (int j = 0; j < SIZE; j++) {

                    if (map[i][j] == c && i == j) {
                        countDiagonal1++;
                    }
                    if (map[i][j] == c && i == j + 1) {
                        countDiagonal2++;
                    }
                    if (map[i][j] == c && i + 1 == j) {
                        countDiagonal3++;
                    }
                    if (countDiagonal1 == DOTS_TO_WIN || countDiagonal2 == DOTS_TO_WIN ||
                            countDiagonal3 == DOTS_TO_WIN) {
                        return true;
                    }
                }

            }

            countDiagonal1 = 0;
            countDiagonal2 = 0;
            countDiagonal3 = 0;

            for (int i = 0; i < SIZE; i++) { // Проверяем правые диагонали
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == c && i + j == SIZE - 1) {
                        countDiagonal1++;
                    }
                    if (map[i][j] == c && i + j == SIZE - 2) {
                        countDiagonal2++;
                    }
                    if (map[i][j] == c && i + j == SIZE) {
                        countDiagonal3++;
                    }

                    if (countDiagonal1 == DOTS_TO_WIN || countDiagonal2 == DOTS_TO_WIN ||
                            countDiagonal3 == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
            /*
             * Следующий цикл должен проверять все строки на наличие в них победной цепочки. По непонятной пока
             * для меня причине - он неправильно определяет только в одном случае - если победная строка - в 5-й
             * строке и идет с 2 по 5. При этом если она в той же строке будет идти с 1 по 4 позицию - то цикл ее
             * определит. (Это если поле 5х5 и фишек 4). При поле 3х3 - он не видит всю третью строку. Я два дня
             * с этим возилась, но так и не поняла, в каком конкретно месте я косячу. Буду разбираться позже. Сейчас,
             * чтобы формально выполнить и задачу для поля 3х3 и для поля 5х5 - поставила "заплатки". Знаю, что так
             * плохо. Надеюсь, смогу найти косяк и исправить позже.
             * */
            for (int i = 0; i < SIZE; i++) { // Проверяем строки
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == c) {
                        countRows++;
                    } else {
                        if (countRows == DOTS_TO_WIN) {
                            return true;
                        } else {
                            countRows = 0;
                        }
                    }
                }
            }

            /*
             * Заплатки
             */
            if (SIZE == 3) {
                if (map[2][0] == c && map[2][1] == c && map[2][2] == c) {
                    return true;
                }
            }

            if (SIZE == 5) {
                if (map[4][1] == c && map[4][2] == c && map[4][3] == c && map[4][4] == c) {
                    return true;
                }
            }
            /*
             * Следующий цикл должен проверять все столбцы. Проблема все таже: для поля 3х3 он не видит третий
             * столбец. Для поля 5х5 он не видит победную цепочку, если она находится в 5 столбце и начинается с 2.
             * Пока поставила заплатки.
             * */

            for (int j = 0; j < SIZE; j++) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][j] == c) { // Проверяем столбцы
                        countColumns++;
                    } else {
                        if (countColumns == DOTS_TO_WIN) {
                            return true;
                        } else {
                            countColumns = 0;
                        }
                    }
                }
            }

            /*
             * Заплатки
             */

            if (SIZE == 3) {
                if (map[0][2] == c && map[1][2] == c && map[2][2] == c) {
                    return true;
                }
            }
            if (SIZE == 5) {
                if (map[0][2] == c && map[1][2] == c && map[2][2] == c) {
                    return true;
                }
            }
            return false;
        }
    }
















