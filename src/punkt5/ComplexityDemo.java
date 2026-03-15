package punkt5;

import java.util.*;

/**
 * Класс для практической демонстрации влияния сложности на производительность
 */
public class ComplexityDemo {

    private static final int N = 100000; // количество элементов

    public static void main(String[] args) {
        System.out.println("=== ПРАКТИЧЕСКАЯ ДЕМОНСТРАЦИЯ СЛОЖНОСТИ ===\n");

        // Демонстрация для ArrayList
        demonstrateArrayList();

        // Демонстрация для TreeSet
        demonstrateTreeSet();

        // Демонстрация для LinkedList
        demonstrateLinkedList();

        // Сравнительная демонстрация
        demonstrateComparison();
    }

    private static void demonstrateArrayList() {
        System.out.println("\n📊 ARRAYLIST - ДЕМОНСТРАЦИЯ:");

        List<Integer> list = new ArrayList<>();

        // Добавление в конец - O(1)
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long time = System.nanoTime() - start;
        System.out.printf("   add(e) %d элементов: %.3f мс (O(1) амортиз.)%n",
                N, time / 1_000_000.0);

        // Получение по индексу - O(1)
        start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.get(i);
        }
        time = System.nanoTime() - start;
        System.out.printf("   get(i) %d раз: %.3f мс (O(1))%n",
                N, time / 1_000_000.0);

        // Добавление в начало - O(n)
        list.clear();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) { // меньше элементов для начала
            list.add(0, i);
        }
        time = System.nanoTime() - start;
        System.out.printf("   add(0, e) 1000 раз: %.3f мс (O(n))%n",
                time / 1_000_000.0);
    }

    private static void demonstrateTreeSet() {
        System.out.println("\n\n📊 TREESET - ДЕМОНСТРАЦИЯ:");

        Set<Integer> set = new TreeSet<>();

        // Добавление - O(log n)
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
        long time = System.nanoTime() - start;
        System.out.printf("   add(e) %d элементов: %.3f мс (O(log n))%n",
                N, time / 1_000_000.0);

        // Поиск - O(log n)
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            set.contains(i);
        }
        time = System.nanoTime() - start;
        System.out.printf("   contains(e) 1000 раз: %.3f мс (O(log n))%n",
                time / 1_000_000.0);

        // Получение первого/последнего - O(1)
        start = System.nanoTime();
        int first = ((TreeSet<Integer>) set).first();
        int last = ((TreeSet<Integer>) set).last();
        time = System.nanoTime() - start;
        System.out.printf("   first()/last(): %.3f мс (O(1))%n",
                time / 1_000_000.0);
    }

    private static void demonstrateLinkedList() {
        System.out.println("\n\n📊 LINKEDLIST - ДЕМОНСТРАЦИЯ:");

        List<Integer> list = new LinkedList<>();

        // Добавление в конец - O(1)
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long time = System.nanoTime() - start;
        System.out.printf("   add(e) %d элементов: %.3f мс (O(1))%n",
                N, time / 1_000_000.0);

        // Добавление в начало - O(1)
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            ((LinkedList<Integer>) list).addFirst(i);
        }
        time = System.nanoTime() - start;
        System.out.printf("   addFirst(e) 1000 раз: %.3f мс (O(1))%n",
                time / 1_000_000.0);

        // Получение по индексу - O(n)
        start = System.nanoTime();
        for (int i = 0; i < 100; i++) { // меньше элементов
            list.get(i * 1000);
        }
        time = System.nanoTime() - start;
        System.out.printf("   get(i) 100 раз: %.3f мс (O(n))%n",
                time / 1_000_000.0);
    }

    private static void demonstrateComparison() {
        System.out.println("\n\n📊 СРАВНИТЕЛЬНАЯ ДЕМОНСТРАЦИЯ:");

        int smallN = 10000;

        // ArrayList - добавление в конец
        List<Integer> arrayList = new ArrayList<>();
        long start1 = System.nanoTime();
        for (int i = 0; i < smallN; i++) {
            arrayList.add(i);
        }
        long time1 = System.nanoTime() - start1;

        // LinkedList - добавление в конец
        List<Integer> linkedList = new LinkedList<>();
        long start2 = System.nanoTime();
        for (int i = 0; i < smallN; i++) {
            linkedList.add(i);
        }
        long time2 = System.nanoTime() - start2;

        // TreeSet - добавление
        Set<Integer> treeSet = new TreeSet<>();
        long start3 = System.nanoTime();
        for (int i = 0; i < smallN; i++) {
            treeSet.add(i);
        }
        long time3 = System.nanoTime() - start3;

        System.out.println("   Сравнение добавления " + smallN + " элементов:");
        System.out.printf("   ArrayList  (add в конец): %.3f мс%n", time1 / 1_000_000.0);
        System.out.printf("   LinkedList (add в конец): %.3f мс%n", time2 / 1_000_000.0);
        System.out.printf("   TreeSet    (add):         %.3f мс%n", time3 / 1_000_000.0);

        // Вывод объяснения
        System.out.println("\n   📌 ОБЪЯСНЕНИЕ:");
        System.out.println("      • ArrayList и LinkedList показывают схожее время для add() в конец");
        System.out.println("      • TreeSet медленнее из-за необходимости балансировки дерева O(log n)");
        System.out.println("      • Но TreeSet всегда хранит элементы отсортированными!");
    }
}