package task8;


import java.util.Scanner;

public class ListDemo {

    private static SinglyLinkedList list = new SinglyLinkedList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    demonstrateIterativeMethods();
                    break;
                case 2:
                    demonstrateRecursiveMethods();
                    break;
                case 3:
                    demonstrateAllMethods();
                    break;
                case 4:
                    interactiveMode();
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

    private static void printMainMenu() {
        System.out.println("\n=== ОДНОСВЯЗНЫЙ ЛИНЕЙНЫЙ СПИСОК ===");
        System.out.println("1. Демонстрация итеративных методов");
        System.out.println("2. Демонстрация рекурсивных методов");
        System.out.println("3. Демонстрация всех методов");
        System.out.println("4. Интерактивный режим");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    private static int getChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void demonstrateIterativeMethods() {
        System.out.println("\n=== ИТЕРАТИВНЫЕ МЕТОДЫ ===");

        // Создание списка с головы
        System.out.println("\n1. createHead (ввод с головы):");
        list.createHead(new int[]{5, 4, 3, 2, 1});
        System.out.println("Результат: " + list.toString());

        // Создание списка с хвоста
        System.out.println("\n2. createTail (ввод с хвоста):");
        list.createTail(new int[]{1, 2, 3, 4, 5});
        System.out.println("Результат: " + list.toString());

        // toString
        System.out.println("\n3. toString (вывод):");
        System.out.println("Список: " + list.toString());

        // AddFirst
        System.out.println("\n4. AddFirst (добавление в начало):");
        list.AddFirst(0);
        System.out.println("Результат: " + list.toString());

        // AddLast
        System.out.println("\n5. AddLast (добавление в конец):");
        list.AddLast(6);
        System.out.println("Результат: " + list.toString());

        // Insert
        System.out.println("\n6. Insert (вставка на позицию):");
        list.Insert(99, 3);
        System.out.println("Результат: " + list.toString());

        // RemoveFirst
        System.out.println("\n7. RemoveFirst (удаление с головы):");
        list.RemoveFirst();
        System.out.println("Результат: " + list.toString());

        // RemoveLast
        System.out.println("\n8. RemoveLast (удаление с хвоста):");
        list.RemoveLast();
        System.out.println("Результат: " + list.toString());

        // Remove
        System.out.println("\n9. Remove (удаление по индексу):");
        list.Remove(2);
        System.out.println("Результат: " + list.toString());
    }

    private static void demonstrateRecursiveMethods() {
        System.out.println("\n=== РЕКУРСИВНЫЕ МЕТОДЫ ===");

        // createHeadRec
        System.out.println("\n1. createHeadRec (рекурсивный ввод с головы):");
        list.createHeadRec(new int[]{5, 4, 3, 2, 1});
        System.out.println("Результат: " + list.toStringRec());

        // createTailRec
        System.out.println("\n2. createTailRec (рекурсивный ввод с хвоста):");
        list.createTailRec(new int[]{1, 2, 3, 4, 5});
        System.out.println("Результат: " + list.toStringRec());

        // toStringRec
        System.out.println("\n3. toStringRec (рекурсивный вывод):");
        System.out.println("Список: " + list.toStringRec());

        // Дополнительно: рекурсивный вывод в обратном порядке
        System.out.println("\n4. toStringReverseRec (рекурсивный вывод в обратном порядке):");
        System.out.println("Список: " + list.toStringReverseRec());

        // Рекурсивный размер
        System.out.println("\n5. sizeRec (рекурсивный подсчет размера):");
        System.out.println("Размер списка: " + list.sizeRec());
    }

    private static void demonstrateAllMethods() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ ВСЕХ МЕТОДОВ ===");

        // Итеративные методы
        System.out.println("\n--- ИТЕРАТИВНЫЕ МЕТОДЫ ---");

        list.createTail(new int[]{10, 20, 30, 40, 50});
        System.out.println("Исходный список: " + list.toString());

        list.AddFirst(5);
        System.out.println("AddFirst(5): " + list.toString());

        list.AddLast(60);
        System.out.println("AddLast(60): " + list.toString());

        list.Insert(25, 2);
        System.out.println("Insert(25, 2): " + list.toString());

        list.RemoveFirst();
        System.out.println("RemoveFirst(): " + list.toString());

        list.RemoveLast();
        System.out.println("RemoveLast(): " + list.toString());

        list.Remove(2);
        System.out.println("Remove(2): " + list.toString());

        // Рекурсивные методы
        System.out.println("\n--- РЕКУРСИВНЫЕ МЕТОДЫ ---");

        list.clear();

        list.createHeadRec(new int[]{1, 2, 3, 4, 5});
        System.out.println("createHeadRec: " + list.toStringRec());

        list.createTailRec(new int[]{6, 7, 8, 9, 10});
        System.out.println("createTailRec: " + list.toStringRec());

        System.out.println("toStringRec: " + list.toStringRec());
        System.out.println("sizeRec: " + list.sizeRec());
    }

    private static void interactiveMode() {
        System.out.println("\n=== ИНТЕРАКТИВНЫЙ РЕЖИМ ===");

        while (true) {
            printInteractiveMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    interactiveCreateHead();
                    break;
                case 2:
                    interactiveCreateTail();
                    break;
                case 3:
                    System.out.println("Текущий список: " + list.toString());
                    break;
                case 4:
                    interactiveAddFirst();
                    break;
                case 5:
                    interactiveAddLast();
                    break;
                case 6:
                    interactiveInsert();
                    break;
                case 7:
                    list.RemoveFirst();
                    System.out.println("Результат: " + list.toString());
                    break;
                case 8:
                    list.RemoveLast();
                    System.out.println("Результат: " + list.toString());
                    break;
                case 9:
                    interactiveRemove();
                    break;
                case 10:
                    interactiveCreateHeadRec();
                    break;
                case 11:
                    interactiveCreateTailRec();
                    break;
                case 12:
                    System.out.println("Рекурсивный вывод: " + list.toStringRec());
                    break;
                case 13:
                    System.out.println("Размер списка: " + list.size() + " (итеративно)");
                    System.out.println("Размер списка: " + list.sizeRec() + " (рекурсивно)");
                    break;
                case 14:
                    list.sort();
                    System.out.println("Результат: " + list.toString());
                    break;
                case 15:
                    list.reverse();
                    System.out.println("Результат: " + list.toString());
                    break;
                case 16:
                    list.reverseRec();
                    System.out.println("Результат: " + list.toString());
                    break;
                case 17:
                    interactiveCreateRandom();
                    break;
                case 18:
                    list.clear();
                    System.out.println("Список очищен");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void printInteractiveMenu() {
        System.out.println("\n--- МЕНЮ ИНТЕРАКТИВНОГО РЕЖИМА ---");
        System.out.println("1. createHead (ввод с головы)");
        System.out.println("2. createTail (ввод с хвоста)");
        System.out.println("3. toString (вывод списка)");
        System.out.println("4. AddFirst (добавить в начало)");
        System.out.println("5. AddLast (добавить в конец)");
        System.out.println("6. Insert (вставить по индексу)");
        System.out.println("7. RemoveFirst (удалить с начала)");
        System.out.println("8. RemoveLast (удалить с конца)");
        System.out.println("9. Remove (удалить по индексу)");
        System.out.println("10. createHeadRec (рекурсивный ввод с головы)");
        System.out.println("11. createTailRec (рекурсивный ввод с хвоста)");
        System.out.println("12. toStringRec (рекурсивный вывод)");
        System.out.println("13. size (размер списка)");
        System.out.println("14. sort (сортировка)");
        System.out.println("15. reverse (разворот)");
        System.out.println("16. reverseRec (рекурсивный разворот)");
        System.out.println("17. createRandom (случайный список)");
        System.out.println("18. clear (очистить список)");
        System.out.println("0. Назад");
        System.out.print("Выберите операцию: ");
    }

    private static void interactiveCreateHead() {
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        int[] values = new int[n];

        System.out.println("Введите " + n + " элементов:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        list.createHead(values);
        System.out.println("Результат: " + list.toString());
    }

    private static void interactiveCreateTail() {
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        int[] values = new int[n];

        System.out.println("Введите " + n + " элементов:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        list.createTail(values);
        System.out.println("Результат: " + list.toString());
    }

    private static void interactiveAddFirst() {
        System.out.print("Введите значение для добавления в начало: ");
        int value = scanner.nextInt();
        list.AddFirst(value);
        System.out.println("Результат: " + list.toString());
    }

    private static void interactiveAddLast() {
        System.out.print("Введите значение для добавления в конец: ");
        int value = scanner.nextInt();
        list.AddLast(value);
        System.out.println("Результат: " + list.toString());
    }

    private static void interactiveInsert() {
        System.out.print("Введите значение: ");
        int value = scanner.nextInt();
        System.out.print("Введите позицию (индекс): ");
        int position = scanner.nextInt();

        list.Insert(value, position);
        System.out.println("Результат: " + list.toString());
    }

    private static void interactiveRemove() {
        System.out.print("Введите позицию для удаления: ");
        int position = scanner.nextInt();
        list.Remove(position);
        System.out.println("Результат: " + list.toString());
    }

    private static void interactiveCreateHeadRec() {
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        int[] values = new int[n];

        System.out.println("Введите " + n + " элементов:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        list.createHeadRec(values);
        System.out.println("Результат: " + list.toStringRec());
    }

    private static void interactiveCreateTailRec() {
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        int[] values = new int[n];

        System.out.println("Введите " + n + " элементов:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        list.createTailRec(values);
        System.out.println("Результат: " + list.toStringRec());
    }

    private static void interactiveCreateRandom() {
        System.out.print("Введите количество элементов: ");
        int count = scanner.nextInt();
        System.out.print("Введите максимальное значение: ");
        int bound = scanner.nextInt();

        list.createRandom(count, bound);
        System.out.println("Результат: " + list.toString());
    }
}