package task3;


import java.util.Scanner;

public class RecursiveArray {

    /**
     * Рекурсивный ввод элементов массива
     * @param scanner объект Scanner для ввода
     * @param array массив для заполнения
     * @param index текущий индекс
     */
    public static void inputArray(Scanner scanner, int[] array, int index) {
        // Базовый случай: все элементы введены
        if (index >= array.length) {
            return;
        }

        // Ввод текущего элемента
        System.out.print("Введите элемент [" + index + "]: ");
        try {
            array[index] = scanner.nextInt();
            // Рекурсивный вызов для следующего индекса
            inputArray(scanner, array, index + 1);
        } catch (Exception e) {
            System.out.println("Ошибка ввода! Пожалуйста, введите целое число.");
            scanner.nextLine(); // Очистка буфера
            inputArray(scanner, array, index); // Повторный ввод текущего элемента
        }
    }

    /**
     * Рекурсивный ввод с подсказкой о прогрессе
     */
    public static void inputArrayWithProgress(Scanner scanner, int[] array, int index) {
        if (index >= array.length) {
            System.out.println("Ввод массива завершен!");
            return;
        }

        System.out.printf("Прогресс: %d/%d элементов. Введите элемент [%d]: ",
                index, array.length, index);
        try {
            array[index] = scanner.nextInt();
            inputArrayWithProgress(scanner, array, index + 1);
        } catch (Exception e) {
            System.out.println("Ошибка! Требуется целое число.");
            scanner.nextLine(); // Очистка буфера
            inputArrayWithProgress(scanner, array, index);
        }
    }

    /**
     * Рекурсивный вывод элементов массива (прямой порядок)
     * @param array массив для вывода
     * @param index текущий индекс
     */
    public static void printArrayForward(int[] array, int index) {
        // Базовый случай
        if (index >= array.length) {
            return;
        }

        // Вывод текущего элемента
        System.out.print(array[index]);
        if (index < array.length - 1) {
            System.out.print(", ");
        }

        // Рекурсивный вызов для следующего индекса
        printArrayForward(array, index + 1);
    }

    /**
     * Рекурсивный вывод элементов массива (обратный порядок)
     * @param array массив для вывода
     * @param index текущий индекс
     */
    public static void printArrayBackward(int[] array, int index) {
        if (index >= array.length) {
            return;
        }

        // Сначала рекурсивный вызов, потом вывод
        printArrayBackward(array, index + 1);

        System.out.print(array[index]);
        if (index > 0) {
            System.out.print(", ");
        }
    }

    /**
     * Красивый вывод массива в формате [a, b, c, ...]
     */
    public static void printArrayPretty(int[] array, int index, StringBuilder sb) {
        if (index >= array.length) {
            return;
        }

        if (index == 0) {
            sb.append("[");
        }

        sb.append(array[index]);

        if (index < array.length - 1) {
            sb.append(", ");
            printArrayPretty(array, index + 1, sb);
        } else {
            sb.append("]");
        }
    }

    /**
     * Рекурсивный метод для демонстрации процесса вывода
     */
    public static void printArrayWithTrace(int[] array, int index, String indent) {
        if (index >= array.length) {
            System.out.println(indent + "Конец массива");
            return;
        }

        System.out.println(indent + "Вывод элемента [" + index + "] = " + array[index]);
        printArrayWithTrace(array, index + 1, indent + "  ");
        System.out.println(indent + "Возврат из вызова для индекса " + index);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== РЕКУРСИВНЫЙ ВВОД И ВЫВОД МАССИВА ===");

        try {
            // Ввод размера массива
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.out.println("Размер массива должен быть положительным числом.");
                return;
            }

            int[] array = new int[size];

            System.out.println("\n--- Рекурсивный ввод массива ---");
            // Выберите один из методов ввода:
            inputArray(scanner, array, 0);
            // inputArrayWithProgress(scanner, array, 0);

            System.out.println("\n--- Рекурсивный вывод массива ---");

            // Прямой вывод
            System.out.print("Массив (прямой порядок): [");
            printArrayForward(array, 0);
            System.out.println("]");

            // Обратный вывод
            System.out.print("Массив (обратный порядок): [");
            printArrayBackward(array, 0);
            System.out.println("]");

            // Красивый вывод через StringBuilder
            StringBuilder sb = new StringBuilder();
            printArrayPretty(array, 0, sb);
            System.out.println("Массив (pretty format): " + sb.toString());

            // Вывод с детальной трассировкой
            System.out.println("\n--- Детальный процесс вывода (прямой порядок) ---");
            printArrayWithTrace(array, 0, "");

            // Демонстрация суммы элементов через рекурсию
            System.out.println("\n--- Дополнительные рекурсивные операции ---");
            System.out.println("Сумма элементов: " + sumArray(array, 0));
            System.out.println("Максимальный элемент: " + findMax(array, 0, array[0]));
            System.out.println("Минимальный элемент: " + findMin(array, 0, array[0]));

        } catch (Exception e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    /**
     * Рекурсивное вычисление суммы элементов массива
     */
    public static int sumArray(int[] array, int index) {
        if (index >= array.length) {
            return 0;
        }
        return array[index] + sumArray(array, index + 1);
    }

    /**
     * Рекурсивный поиск максимального элемента
     */
    public static int findMax(int[] array, int index, int currentMax) {
        if (index >= array.length) {
            return currentMax;
        }
        if (array[index] > currentMax) {
            currentMax = array[index];
        }
        return findMax(array, index + 1, currentMax);
    }

    /**
     * Рекурсивный поиск минимального элемента
     */
    public static int findMin(int[] array, int index, int currentMin) {
        if (index >= array.length) {
            return currentMin;
        }
        if (array[index] < currentMin) {
            currentMin = array[index];
        }
        return findMin(array, index + 1, currentMin);
    }
}