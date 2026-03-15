package task2;
import java.util.Scanner;

public class DecimalToBinary {

    /**
     * Рекурсивный метод для перевода десятичного числа в двоичное
     * @param n десятичное число
     * @return строка с двоичным представлением
     */
    public static String toBinary(int n) {
        // Базовый случай
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }

        // Рекурсивный случай: делим число на 2 и добавляем остаток
        return toBinary(n / 2) + (n % 2);
    }

    /**
     * Рекурсивный метод с выводом процесса вычисления
     * @param n десятичное число
     * @param indent отступ для визуализации рекурсии
     * @return двоичное представление
     */
    public static String toBinaryWithTrace(int n, String indent) {
        System.out.println(indent + "toBinary(" + n + ")");

        if (n == 0) {
            System.out.println(indent + "  Базовый случай: возвращаем \"0\"");
            return "0";
        }
        if (n == 1) {
            System.out.println(indent + "  Базовый случай: возвращаем \"1\"");
            return "1";
        }

        System.out.println(indent + "  " + n + " / 2 = " + (n / 2) + ", остаток = " + (n % 2));
        String result = toBinaryWithTrace(n / 2, indent + "  ") + (n % 2);
        System.out.println(indent + "  Результат: " + result);

        return result;
    }

    /**
     * Альтернативный рекурсивный метод с накоплением результата
     * @param n десятичное число
     * @param result текущий результат (накапливаемый параметр)
     * @return двоичное представление
     */
    public static String toBinaryAccumulator(int n, String result) {
        if (n == 0) {
            return result.isEmpty() ? "0" : result;
        }
        return toBinaryAccumulator(n / 2, (n % 2) + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ПЕРЕВОД ЧИСЛА В ДВОИЧНУЮ СИСТЕМУ СЧИСЛЕНИЯ ===");
        System.out.print("Введите целое число: ");

        try {
            int number = scanner.nextInt();

            System.out.println("\n1. Простой рекурсивный метод:");
            System.out.println(number + " (десятичное) = " + toBinary(number) + " (двоичное)");

            System.out.println("\n2. Метод с накоплением результата:");
            System.out.println(number + " (десятичное) = " + toBinaryAccumulator(number, "") + " (двоичное)");

            System.out.println("\n3. Детальный процесс вычисления:");
            System.out.println("Результат: " + toBinaryWithTrace(number, ""));

            // Проверка с использованием встроенного метода Java
            System.out.println("\nПроверка (Integer.toBinaryString): " + Integer.toBinaryString(number));

        } catch (Exception e) {
            System.out.println("Ошибка ввода. Пожалуйста, введите целое число.");
        } finally {
            scanner.close();
        }
    }
}