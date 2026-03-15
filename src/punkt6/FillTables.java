package punkt6;


import java.util.*;

public class FillTables {

    public static void main(String[] args) {
        System.out.println("=== ЗАПОЛНЕНИЕ ТАБЛИЦ СРАВНЕНИЯ ===\n");

        // Параметры тестирования
        int smallSize = 10000;   // для операций в начало/середину
        int largeSize = 100000;   // для операций в конец и получения

        // ТАБЛИЦА 1: Добавление
        System.out.println("ТАБЛИЦА 1. Сравнение времени выполнения операции добавления (мс)");
        System.out.println("=================================================================");
        System.out.printf("| %-12s | %-20s | %-20s | %-20s |%n",
                "Коллекция", "в начало", "в середину", "в конец");
        System.out.println("=================================================================");

        // ArrayList
        System.out.printf("| %-12s | %-20d | %-20d | %-20d |%n",
                "ArrayList",
                addToBeginningTest(new ArrayList<>(), smallSize),
                addToMiddleTest(new ArrayList<>(), smallSize),
                addToEndTest(new ArrayList<>(), largeSize));

        // LinkedList
        System.out.printf("| %-12s | %-20d | %-20d | %-20d |%n",
                "LinkedList",
                addToBeginningTest(new LinkedList<>(), smallSize),
                addToMiddleTest(new LinkedList<>(), smallSize),
                addToEndTest(new LinkedList<>(), largeSize));

        // HashMap (для добавления используется put)
        System.out.printf("| %-12s | %-20s | %-20s | %-20d |%n",
                "HashMap", "N/A", "N/A", hashMapPutTest(largeSize));

        System.out.println("=================================================================\n");

        // ТАБЛИЦА 2: Удаление
        System.out.println("ТАБЛИЦА 2. Сравнение времени выполнения операции удаления (мс)");
        System.out.println("=================================================================");
        System.out.printf("| %-12s | %-20s | %-20s | %-20s |%n",
                "Коллекция", "с начала", "из середины", "с конца");
        System.out.println("=================================================================");

        // ArrayList
        System.out.printf("| %-12s | %-20d | %-20d | %-20d |%n",
                "ArrayList",
                removeFromBeginningTest(createArrayList(largeSize), smallSize),
                removeFromMiddleTest(createArrayList(largeSize)),
                removeFromEndTest(createArrayList(largeSize)));

        // LinkedList
        System.out.printf("| %-12s | %-20d | %-20d | %-20d |%n",
                "LinkedList",
                removeFromBeginningTest(createLinkedList(largeSize), smallSize),
                removeFromMiddleTest(createLinkedList(largeSize)),
                removeFromEndTest(createLinkedList(largeSize)));

        // HashMap
        System.out.printf("| %-12s | %-20s | %-20s | %-20d |%n",
                "HashMap", "N/A", "N/A", hashMapRemoveTest(largeSize));

        System.out.println("=================================================================\n");

        // ТАБЛИЦА 3: Получение по индексу
        System.out.println("ТАБЛИЦА 3. Сравнение времени выполнения операции получения элемента по индексу (мс)");
        System.out.println("=================================================================");
        System.out.printf("| %-12s | %-50s |%n", "Коллекция", "По индексу для " + largeSize + " элементов");
        System.out.println("=================================================================");

        // ArrayList
        System.out.printf("| %-12s | %-50d |%n",
                "ArrayList",
                getByIndexTest(createArrayList(largeSize)));

        // LinkedList
        System.out.printf("| %-12s | %-50d |%n",
                "LinkedList",
                getByIndexTest(createLinkedList(largeSize)));

        // HashMap
        System.out.printf("| %-12s | %-50d |%n",
                "HashMap",
                hashMapGetTest(largeSize));

        System.out.println("=================================================================");

        // Вывод объяснений
        printExplanations();
    }

    // ==================== МЕТОДЫ ДЛЯ ТАБЛИЦЫ 1 (ДОБАВЛЕНИЕ) ====================

    private static long addToBeginningTest(List<Integer> list, int count) {
        list.clear();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long addToMiddleTest(List<Integer> list, int count) {
        list.clear();
        // Заполняем начальными данными
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(list.size() / 2, i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long addToEndTest(List<Integer> list, int count) {
        list.clear();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - start;
    }

    private static long hashMapPutTest(int count) {
        Map<Integer, String> map = new HashMap<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            map.put(i, "value" + i);
        }
        return System.currentTimeMillis() - start;
    }

    // ==================== МЕТОДЫ ДЛЯ ТАБЛИЦЫ 2 (УДАЛЕНИЕ) ====================

    private static ArrayList<Integer> createArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static LinkedList<Integer> createLinkedList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static long removeFromBeginningTest(List<Integer> list, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count && !list.isEmpty(); i++) {
            list.remove(0);
        }
        return System.currentTimeMillis() - start;
    }

    private static long removeFromMiddleTest(List<Integer> list) {
        int count = Math.min(10000, list.size() / 10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < count && list.size() > 1; i++) {
            list.remove(list.size() / 2);
        }
        return System.currentTimeMillis() - start;
    }

    private static long removeFromEndTest(List<Integer> list) {
        int count = Math.min(10000, list.size());
        long start = System.currentTimeMillis();
        for (int i = 0; i < count && !list.isEmpty(); i++) {
            list.remove(list.size() - 1);
        }
        return System.currentTimeMillis() - start;
    }

    private static long hashMapRemoveTest(int count) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(i, "value" + i);
        }

        int removeCount = Math.min(10000, count);
        long start = System.currentTimeMillis();
        for (int i = 0; i < removeCount; i++) {
            map.remove(i);
        }
        return System.currentTimeMillis() - start;
    }

    // ==================== МЕТОДЫ ДЛЯ ТАБЛИЦЫ 3 (ПОЛУЧЕНИЕ) ====================

    private static long getByIndexTest(List<Integer> list) {
        Random random = new Random();
        int size = list.size();

        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(size);
            list.get(index);
        }
        return System.currentTimeMillis() - start;
    }

    private static long hashMapGetTest(int count) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(i, "value" + i);
        }

        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int key = random.nextInt(count);
            map.get(key);
        }
        return System.currentTimeMillis() - start;
    }

    private static void printExplanations() {
        System.out.println("\n\n=== ПОЯСНЕНИЯ К РЕЗУЛЬТАТАМ ===");
        System.out.println("""
            
            ArrayList:
            - Добавление в конец: быстро (O(1) амортизированно)
            - Добавление в начало/середину: медленно (O(n)) - требуется сдвиг элементов
            - Удаление с конца: быстро
            - Удаление с начала/середины: медленно (требуется сдвиг)
            - Получение по индексу: очень быстро (O(1))
            
            LinkedList:
            - Добавление в начало/конец: быстро (O(1))
            - Добавление в середину: медленно (O(n)) - требуется поиск позиции
            - Удаление с начала/конца: быстро
            - Удаление из середины: медленно
            - Получение по индексу: медленно (O(n)) - требуется обход
            
            HashMap:
            - Добавление: O(1) в среднем
            - Удаление: O(1) в среднем
            - Получение по ключу: O(1) в среднем
            - Не поддерживает операции по индексу
            """);
    }
}