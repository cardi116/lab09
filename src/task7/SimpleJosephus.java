package task7;

import java.util.LinkedList;

public class SimpleJosephus {

    public static void main(String[] args) {
        System.out.println("=== ЗАДАЧА ИОСИФА (LinkedList) ===\n");

        // Тест 1: N = 7
        System.out.println("Тест 1: N = 7");
        simulate(7);

        // Тест 2: N = 10
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Тест 2: N = 10");
        simulate(10);

        // Тест 3: N = 41 (классическая задача)
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Тест 3: N = 41 (классическая задача)");
        int result = simulate(41);
        System.out.println("\nИсторический факт: Иосиф должен был стать на позицию " + result);

        // Тест производительности
        System.out.println("\n" + "=".repeat(40));
        System.out.println("ТЕСТ ПРОИЗВОДИТЕЛЬНОСТИ:");
        performanceTest();
    }

    public static int simulate(int n) {
        LinkedList<Integer> people = new LinkedList<>();

        // Заполняем список
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        System.out.println("Начальный круг: " + (n <= 20 ? people : "[...]"));

        int index = 0;
        int step = 1;

        while (people.size() > 1) {
            index = (index + 1) % people.size();
            int removed = people.remove(index);

            if (n <= 20) {
                System.out.printf("Шаг %2d: вычеркнут %2d, осталось: %s%n",
                        step++, removed, people);
            }
        }

        System.out.println("Последний оставшийся: " + people.get(0));
        return people.get(0);
    }

    public static void performanceTest() {
        int[] sizes = {1000, 10000, 100000, 500000, 1000000};

        System.out.println("\nРазмер (N) | Время (мс)");
        System.out.println("-".repeat(30));

        for (int n : sizes) {
            long startTime = System.currentTimeMillis();

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }

            int index = 0;
            while (list.size() > 1) {
                index = (index + 1) % list.size();
                list.remove(index);
            }

            long endTime = System.currentTimeMillis();
            double timeMs = endTime - startTime;

            System.out.printf("%9d | %8.2f%n", n, timeMs);
        }
    }
}