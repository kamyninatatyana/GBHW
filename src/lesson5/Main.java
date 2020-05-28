package lesson5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Employee[] employeesArray = {

                new Employee("Яшмешин Юрий Валентинович", 65, "Директор",
                        "jagmeshin@mail.ru", "+7(921)911-11-11", 250000),
                new Employee("Петрова Мария Владимировна", 35, "Главный бухгалтер",
                        "petrova@mail.ru", "+7(921)911-11-12", 115000),
                new Employee("Барышева Светлана Владимировна", 45, "Начальник отдела кадров",
                        "barysheva@mail.ru", "+7(921)911-11-13", 75000),
                new Employee("Волкова Светлана Владимировна", 50, "Начальник производства",
                        "volkova@mail.ru", "+7(921)911-11-14", 70000),
                new Employee("Грибанова Лариса Михайловна", 39, "Начальник отдела снабжения",
                        "gribanova@mail.ru", "+7(921)911-11-15", 70000),
        };

        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getAge() > 40) {
                employeesArray[i].info();
            }

        }

    }
}


