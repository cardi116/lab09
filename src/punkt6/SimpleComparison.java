package punkt6;

import java.util.*;

public class SimpleComparison {

    private static final int N = 100000; // количество элементов

    public static void main(String[] args) {
        System.out.println("=== СРАВНЕНИЕ ПРОИЗВОДИТЕЛЬНОСТИ (УПРОЩЕННОЕ) ===\n");

        // Тест для ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long arrayListTime = getRunningTime(arrayList);
        System.out.println("Время выполнения операции добавления в ArrayList = " + arrayListTime + " мс");

        // Тест для LinkedList
        List<Integer> linkedList = new LinkedList<>();
        long linkedListTime = getRunningTime(linkedList);
        System.out.println("Время выполнения операции добавления в LinkedList = " + linkedListTime + " мс");

        // Тест для HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        long hashMapTime = getHashMapRunningTime(hashMap);
        System.out.println("Время выполнения операции добавления в HashMap = " + hashMapTime + " мс");

        // Вывод результатов
        printResults(arrayListTime, linkedListTime, hashMapTime);
    }

    private static long getRunningTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            list.add(i); // добавление в конец
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getHashMapRunningTime(Map<Integer, String> map) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            map.put(i, "Value" + i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void printResults(long arrayTime, long linkedTime, long mapTime) {
        System.out.println("\n=== РЕЗУЛЬТАТЫ ===");
        System.out.println("Количество элементов: " + N);
        System.out.println("ArrayList:  " + arrayTime + " мс");
        System.out.println("LinkedList: " + linkedTime + " мс");
        System.out.println("HashMap:    " + mapTime + " мс");

        System.out.println("\nАнализ:");
        if (arrayTime < linkedTime) {
            System.out.println("- ArrayList быстрее LinkedList в " +
                    String.format("%.2f", (double)linkedTime/arrayTime) + " раз");
        } else {
            System.out.println("- LinkedList быстрее ArrayList в " +
                    String.format("%.2f", (double)arrayTime/linkedTime) + " раз");
        }

        System.out.println("- HashMap " + (mapTime < arrayTime ? "быстрее" : "медленнее") +
                " ArrayList в " + String.format("%.2f",
                (double)Math.max(mapTime, arrayTime)/Math.min(mapTime, arrayTime)) + " раз");
    }
}