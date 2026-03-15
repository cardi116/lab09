package task7;

import java.util.List;

public class ArrayList {

    /**
     * Моделирование процесса вычеркивания каждого второго человека
     * @param n количество человек
     * @return номер последнего оставшегося человека
     */
    public static int josephus(int n) {
        if (n <= 0) {
            return 0;
        }

        // Создаем список людей (нумерация с 1 до n)
        List<Integer> people = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0; // начинаем с первого человека

        System.out.println("Начальный круг: " + people);
        System.out.println("Процесс вычеркивания (ArrayList):");

        while (people.size() > 1) {
            // Вычисляем индекс следующего человека для удаления
            // Каждый второй означает шаг в 1 (удаляем следующего)
            index = (index + 1) % people.size();

            int removed = people.remove(index);
            System.out.println("  Вычеркнут человек " + removed + ". Осталось: " + people);

            // После удаления индекс автоматически указывает на следующего
            // (так как элементы сдвинулись)
        }

        return people.get(0);
    }

    /**
     * Моделирование с детальным выводом каждого шага
     */
    public static int josephusDetailed(int n) {
        if (n <= 0) {
            return 0;
        }

        List<Integer> people = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        System.out.println("\n=== ПРОЦЕСС С ДЕТАЛИЗАЦИЕЙ (ArrayList) ===");
        System.out.println("Начальная расстановка: " + people);

        int index = 0;
        int step = 1;

        while (people.size() > 1) {
            System.out.println("\nШаг " + step + ":");
            System.out.println("  Текущий круг: " + people);
            System.out.println("  Текущий индекс: " + index + " (человек " + people.get(index) + ")");

            index = (index + 1) % people.size();
            System.out.println("  Индекс для удаления: " + index + " (человек " + people.get(index) + ")");

            int removed = people.remove(index);
            System.out.println("  ВЫЧЕРКНУТ: человек " + removed);

            step++;
        }

        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        System.out.println("Последний оставшийся человек: " + people.get(0));

        return people.get(0);
    }

    /**
     * Метод для измерения производительности
     */
    public static long measurePerformance(int n) {
        List<Integer> people = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        long startTime = System.nanoTime();

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        System.out.println("=== МОДЕЛИРОВАНИЕ ЗАДАЧИ ИОСИФА (ArrayList) ===");

        // Тест с небольшим числом для демонстрации
        int n = 7; // 7 человек для наглядности
        int result = josephusDetailed(n);
        System.out.println("\nДля N = " + n + " последний остался человек №" + result);

        // Тест производительности
        System.out.println("\n=== ТЕСТ ПРОИЗВОДИТЕЛЬНОСТИ ArrayList ===");
        int[] testSizes = {100, 1000, 10000, 50000};

        for (int size : testSizes) {
            long time = measurePerformance(size);
            System.out.printf("N = %6d | Время: %8d нс | %.3f мс%n",
                    size, time, time / 1_000_000.0);
        }
    }
}