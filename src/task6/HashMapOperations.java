package task6;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class HashMapOperations {

    private HashMap<Integer, String> map;
    private Random random;

    public HashMapOperations() {
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Заполнение HashMap 10 объектами с автоматической генерацией
     */
    public void fillAutomatically() {
        map.clear();

        String[] words = {
                "яблоко", "груша", "банан", "апельсин", "мандарин",
                "арбуз", "дыня", "виноград", "клубника", "малина",
                "ежевика", "черника", "голубика", "ананас", "киви",
                "манго", "папайя", "лимон", "лайм", "грейпфрут"
        };

        for (int i = 0; i < 10; i++) {
            int key = i; // ключи от 0 до 9
            String value = words[random.nextInt(words.length)];
            map.put(key, value);
        }

        System.out.println("HashMap автоматически заполнена 10 объектами.");
    }

    /**
     * Заполнение HashMap вручную с клавиатуры
     */
    public void fillManually() {
        Scanner scanner = new Scanner(System.in);
        map.clear();

        System.out.println("Введите 10 пар (ключ - целое число, значение - строка):");

        for (int i = 0; i < 10; i++) {
            try {
                System.out.print("Введите ключ (целое число) #" + (i + 1) + ": ");
                int key = scanner.nextInt();
                scanner.nextLine(); // очистка буфера

                System.out.print("Введите значение (строку) #" + (i + 1) + ": ");
                String value = scanner.nextLine();

                map.put(key, value);
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
                scanner.nextLine(); // очистка буфера
                i--; // повтор ввода
            }
        }

        System.out.println("HashMap успешно заполнена!");
    }

    /**
     * Вывод всего содержимого HashMap
     */
    public void displayAll() {
        System.out.println("\n=== СОДЕРЖИМОЕ HashMap ===");
        if (map.isEmpty()) {
            System.out.println("HashMap пуста");
            return;
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " -> Значение: " + entry.getValue());
        }
        System.out.println("Всего элементов: " + map.size());
    }

    /**
     * Задание 1: Найти строки у которых ключ > 5
     * @return Map с элементами, где ключ больше 5
     */
    public HashMap<Integer, String> findWhereKeyGreaterThan(int threshold) {
        HashMap<Integer, String> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > threshold) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    /**
     * Задание 2: Если ключ = 0, вывести строки через запятую
     * @return строка со значениями для ключа 0 или сообщение об отсутствии
     */
    public String getStringForKeyZero() {
        if (map.containsKey(0)) {
            return "Значение для ключа 0: " + map.get(0);
        } else {
            return "Ключ 0 отсутствует в HashMap";
        }
    }

    /**
     * Задание 3: Перемножить все ключи, где длина строки > 5
     * @return произведение ключей
     */
    public long multiplyKeysWhereStringLengthGreaterThan(int lengthThreshold) {
        long product = 1;
        boolean found = false;

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > lengthThreshold) {
                product *= entry.getKey();
                found = true;
                System.out.println("  Ключ " + entry.getKey() + " (значение: \"" + entry.getValue() + "\", длина: " + entry.getValue().length() + ")");
            }
        }

        if (!found) {
            System.out.println("  Нет элементов с длиной строки > " + lengthThreshold);
            return 0;
        }

        return product;
    }

    /**
     * Выполнение всех заданий
     */
    public void executeAllTasks() {
        System.out.println("\n=== ВЫПОЛНЕНИЕ ВСЕХ ЗАДАНИЙ ===");

        // Задание 1: ключи > 5
        System.out.println("\n1. Элементы с ключом > 5:");
        HashMap<Integer, String> greaterThan5 = findWhereKeyGreaterThan(5);
        if (greaterThan5.isEmpty()) {
            System.out.println("  Нет элементов с ключом > 5");
        } else {
            for (Map.Entry<Integer, String> entry : greaterThan5.entrySet()) {
                System.out.println("  Ключ: " + entry.getKey() + " -> " + entry.getValue());
            }
        }

        // Задание 2: ключ = 0
        System.out.println("\n2. Поиск по ключу 0:");
        System.out.println("  " + getStringForKeyZero());

        // Задание 3: перемножение ключей где длина строки > 5
        System.out.println("\n3. Перемножение ключей, где длина строки > 5:");
        long product = multiplyKeysWhereStringLengthGreaterThan(5);
        if (product > 0) {
            System.out.println("  Произведение ключей: " + product);
        }
    }

    /**
     * Дополнительные методы для анализа
     */

    /**
     * Найти все элементы с длиной строки больше заданной
     */
    public HashMap<Integer, String> findWhereStringLengthGreaterThan(int length) {
        HashMap<Integer, String> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > length) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    /**
     * Получить статистику по длинам строк
     */
    public void printStringLengthStatistics() {
        System.out.println("\n=== СТАТИСТИКА ПО ДЛИНАМ СТРОК ===");

        int totalLength = 0;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        String maxString = "";
        String minString = "";

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int length = entry.getValue().length();
            totalLength += length;

            if (length > maxLength) {
                maxLength = length;
                maxString = entry.getValue();
            }

            if (length < minLength) {
                minLength = length;
                minString = entry.getValue();
            }

            System.out.println("  Ключ " + entry.getKey() + ": \"" + entry.getValue() + "\" (длина: " + length + ")");
        }

        System.out.println("\nСредняя длина строки: " + (double)totalLength / map.size());
        System.out.println("Максимальная длина: " + maxLength + " (строка: \"" + maxString + "\")");
        System.out.println("Минимальная длина: " + minLength + " (строка: \"" + minString + "\")");
    }

    /**
     * Сортировка и вывод по ключам
     */
    public void displaySortedByKey() {
        System.out.println("\n=== ОТСОРТИРОВАНО ПО КЛЮЧАМ ===");

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("Ключ: " + entry.getKey() + " -> " + entry.getValue()));
    }

    /**
     * Сортировка и вывод по значениям (длине строки)
     */
    public void displaySortedByValueLength() {
        System.out.println("\n=== ОТСОРТИРОВАНО ПО ДЛИНЕ СТРОКИ ===");

        map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e1.getValue().length(), e2.getValue().length()))
                .forEach(entry -> System.out.println("Ключ: " + entry.getKey() + " -> " + entry.getValue() + " (длина: " + entry.getValue().length() + ")"));
    }

    /**
     * Поиск по части строки
     */
    public void searchBySubstring(String substring) {
        System.out.println("\n=== ПОИСК ПО ПОДСТРОКЕ \"" + substring + "\" ===");

        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().toLowerCase().contains(substring.toLowerCase())) {
                System.out.println("  Ключ " + entry.getKey() + ": " + entry.getValue());
                found = true;
            }
        }

        if (!found) {
            System.out.println("  Ничего не найдено");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMapOperations app = new HashMapOperations();

        while (true) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    app.fillAutomatically();
                    break;
                case 2:
                    app.fillManually();
                    break;
                case 3:
                    app.displayAll();
                    break;
                case 4:
                    app.executeAllTasks();
                    break;
                case 5:
                    System.out.println("\n--- Задание 1: Ключи > 5 ---");
                    HashMap<Integer, String> result = app.findWhereKeyGreaterThan(5);
                    if (result.isEmpty()) {
                        System.out.println("Нет элементов с ключом > 5");
                    } else {
                        result.forEach((k, v) -> System.out.println("Ключ " + k + ": " + v));
                    }
                    break;
                case 6:
                    System.out.println("\n--- Задание 2: Ключ = 0 ---");
                    System.out.println(app.getStringForKeyZero());
                    break;
                case 7:
                    System.out.println("\n--- Задание 3: Произведение ключей ---");
                    System.out.print("Введите минимальную длину строки (по умолчанию 5): ");
                    int len = scanner.nextInt();
                    long product = app.multiplyKeysWhereStringLengthGreaterThan(len);
                    if (product > 0) {
                        System.out.println("Произведение ключей: " + product);
                    }
                    break;
                case 8:
                    app.printStringLengthStatistics();
                    break;
                case 9:
                    app.displaySortedByKey();
                    break;
                case 10:
                    app.displaySortedByValueLength();
                    break;
                case 11:
                    System.out.print("Введите подстроку для поиска: ");
                    scanner.nextLine(); // очистка буфера
                    String sub = scanner.nextLine();
                    app.searchBySubstring(sub);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== ОПЕРАЦИИ С HashMap ===");
        System.out.println("1. Автоматическое заполнение");
        System.out.println("2. Ручное заполнение");
        System.out.println("3. Показать все элементы");
        System.out.println("4. Выполнить все задания");
        System.out.println("5. Задание 1: Найти ключи > 5");
        System.out.println("6. Задание 2: Показать значение для ключа 0");
        System.out.println("7. Задание 3: Перемножить ключи (длина строки > N)");
        System.out.println("8. Статистика по длинам строк");
        System.out.println("9. Сортировка по ключам");
        System.out.println("10. Сортировка по длине строки");
        System.out.println("11. Поиск по подстроке");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    private static int getUserChoice(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
}