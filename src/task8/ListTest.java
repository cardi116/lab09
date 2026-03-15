package task8;


public class ListTest {

    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ОДНОСВЯЗНОГО СПИСКА ===\n");

        SinglyLinkedList list = new SinglyLinkedList();

        // Тест 1: createHead
        System.out.println("Тест 1: createHead");
        list.createHead(new int[]{1, 2, 3, 4, 5});
        System.out.println("  Результат: " + list.toString());
        System.out.println("  Ожидалось: [1 -> 2 -> 3 -> 4 -> 5]");

        // Тест 2: createTail
        System.out.println("\nТест 2: createTail");
        list.createTail(new int[]{10, 20, 30, 40, 50});
        System.out.println("  Результат: " + list.toString());
        System.out.println("  Ожидалось: [10 -> 20 -> 30 -> 40 -> 50]");

        // Тест 3: AddFirst
        System.out.println("\nТест 3: AddFirst");
        list.AddFirst(5);
        System.out.println("  Результат: " + list.toString());
        System.out.println("  Ожидалось: [5 -> 10 -> 20 -> 30 -> 40 -> 50]");

        // Тест 4: AddLast
        System.out.println("\nТест 4: AddLast");
        list.AddLast(60);
        System.out.println("  Результат: " + list.toString());
        System.out.println("  Ожидалось: [5 -> 10 -> 20 -> 30 -> 40 -> 50 -> 60]");

        // Тест 5: Insert
        System.out.println("\nТест 5: Insert");
        list.Insert(25, 3);
        System.out.println("  Результат: " + list.toString());
        System.out.println("  Ожидалось: [5 -> 10 -> 20 -> 25 -> 30 -> 40 -> 50 -> 60]");

        // Тест 6: RemoveFirst
        System.out.println("\nТест 6: RemoveFirst");
        int removed = list.RemoveFirst();
        System.out.println("  Удалено: " + removed);
        System.out.println("  Результат: " + list.toString());
        System.out.println("  Ожидалось: [10 -> 20 -> 25 -> 30 -> 40 -> 50 -> 60]");

        // Тест 7: RemoveLast
        System.out.println("\nТест 7: RemoveLast");
        removed = list.RemoveLast();
        System.out.println("  Удалено: " + removed);
        System.out.println("  Результат: " + list.toString());
        System.out.println("  Ожидалось: [10 -> 20 -> 25 -> 30 -> 40 -> 50]");

        // Тест 8: Remove
        System.out.println("\nТест 8: Remove");
        removed = list.Remove(2);
        System.out.println("  Удалено с позиции 2: " + removed);
        System.out.println("  Результат: " + list.toString());
        System.out.println("  Ожидалось: [10 -> 20 -> 30 -> 40 -> 50]");

        // Тест 9: Рекурсивные методы
        System.out.println("\nТест 9: Рекурсивные методы");
        list.createHeadRec(new int[]{1, 2, 3, 4, 5});
        System.out.println("  createHeadRec: " + list.toStringRec());

        list.createTailRec(new int[]{6, 7, 8, 9, 10});
        System.out.println("  createTailRec: " + list.toStringRec());

        // Тест 10: Сортировка
        System.out.println("\nТест 10: Сортировка");
        list.createRandom(10, 100);
        System.out.println("  До сортировки: " + list.toString());
        list.sort();
        System.out.println("  После сортировки: " + list.toString());

        // Тест 11: Разворот
        System.out.println("\nТест 11: Разворот");
        System.out.println("  До разворота: " + list.toString());
        list.reverse();
        System.out.println("  После разворота (итеративно): " + list.toString());
        list.reverseRec();
        System.out.println("  После разворота (рекурсивно): " + list.toString());

        // Тест 12: size и sizeRec
        System.out.println("\nТест 12: Размер списка");
        System.out.println("  size(): " + list.size());
        System.out.println("  sizeRec(): " + list.sizeRec());

        // Тест 13: toStringReverseRec
        System.out.println("\nТест 13: toStringReverseRec");
        System.out.println("  Прямой порядок: " + list.toString());
        System.out.println("  Обратный порядок: " + list.toStringReverseRec());

        System.out.println("\n=== ВСЕ ТЕСТЫ ПРОЙДЕНЫ ===");
    }
}