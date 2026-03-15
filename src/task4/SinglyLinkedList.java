package task4;

// Класс узла списка
class Node {
    public int value;      // Значение узла
    public Node next;      // Ссылка на следующий узел

    // Конструктор для создания узла
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    // Конструктор для создания узла с указанием следующего узла
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{value=" + value + ", next=" + (next != null ? "Node(" + next.value + ")" : "null") + "}";
    }
}

public class SinglyLinkedList {

    /**
     * Создание однонаправленного списка из n элементов
     * @param n количество элементов
     * @return ссылка на первый узел (голову списка)
     */
    public static Node createList(int n) {
        if (n <= 0) {
            return null;
        }

        // Создаем первый узел (голову)
        Node head = new Node(0);
        Node current = head;

        // Создаем остальные узлы и связываем их
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(i);
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    /**
     * Рекурсивное создание списка
     * @param n количество элементов
     * @param currentValue текущее значение
     * @return ссылка на первый узел
     */
    public static Node createListRecursive(int n, int currentValue) {
        if (currentValue >= n) {
            return null;
        }

        Node node = new Node(currentValue);
        node.next = createListRecursive(n, currentValue + 1);
        return node;
    }

    /**
     * Вывод списка на экран (итеративный способ)
     * @param head голова списка
     */
    public static void printListIterative(Node head) {
        System.out.print("Список (итеративно): ");
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }

    /**
     * Вывод списка на экран (рекурсивный способ)
     * @param node текущий узел
     */
    public static void printListRecursive(Node node) {
        if (node == null) {
            System.out.print("null");
            return;
        }

        System.out.print(node.value);
        if (node.next != null) {
            System.out.print(" -> ");
            printListRecursive(node.next);
        } else {
            System.out.print(" -> ");
            printListRecursive(node.next);
        }
    }

    /**
     * Вывод списка с детальной информацией
     * @param head голова списка
     */
    public static void printListDetailed(Node head) {
        System.out.println("\n=== ДЕТАЛЬНАЯ ИНФОРМАЦИЯ О СПИСКЕ ===");
        Node current = head;
        int index = 0;

        while (current != null) {
            System.out.printf("Узел node%d: value=%d, ссылка на %s%n",
                    index,
                    current.value,
                    current.next != null ? "node" + (index + 1) : "null"
            );
            current = current.next;
            index++;
        }
        System.out.println("=====================================");
    }

    /**
     * Вывод списка в формате, аналогичном рисунку 8
     * @param head голова списка
     */
    public static void printListAsDiagram(Node head) {
        System.out.println("\n--- Диаграмма списка ---");
        Node current = head;
        int index = 0;

        while (current != null) {
            System.out.println("Узел node" + index);
            System.out.println("  node" + index + ".value=" + current.value);
            System.out.println("  Ссылка на " + (current.next != null ? "node" + (index + 1) : "null"));
            System.out.println();
            current = current.next;
            index++;
        }
    }

    /**
     * Получение размера списка (рекурсивно)
     * @param node текущий узел
     * @return размер списка
     */
    public static int getSize(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.next);
    }

    /**
     * Поиск элемента по индексу
     * @param head голова списка
     * @param index индекс для поиска
     * @return узел или null
     */
    public static Node getNodeAtIndex(Node head, int index) {
        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        return current;
    }

    public static void main(String[] args) {
        System.out.println("=== ПРИМЕР 6: ОДНОНАПРАВЛЕННЫЙ СПИСОК ===");

        // Создаем список из 4 элементов (как на рисунке)
        System.out.println("\n1. Создание списка из 4 элементов (итеративно):");
        Node head1 = createList(4);
        printListIterative(head1);

        System.out.println("\n2. Детальный вывод:");
        printListDetailed(head1);

        System.out.println("\n3. Вывод в формате диаграммы:");
        printListAsDiagram(head1);

        System.out.println("\n4. Рекурсивный вывод:");
        System.out.print("Список (рекурсивно): ");
        printListRecursive(head1);
        System.out.println();

        System.out.println("\n5. Информация о размере списка:");
        System.out.println("Размер списка: " + getSize(head1));

        // Создание списка рекурсивным методом
        System.out.println("\n6. Создание списка рекурсивным методом:");
        Node head2 = createListRecursive(5, 0);
        printListDetailed(head2);

        // Демонстрация доступа к отдельным узлам
        System.out.println("\n7. Доступ к отдельным узлам:");
        for (int i = 0; i < 4; i++) {
            Node node = getNodeAtIndex(head1, i);
            System.out.println("node" + i + ": " + node);
        }

        // Точки для отладки (здесь будут установлены брейкпоинты)
        System.out.println("\n=== ТОЧКИ ДЛЯ ОТЛАДКИ ===");
        debugPoint1(head1);  // Точка 1: Создание списка
        debugPoint2(head1);  // Точка 2: Обход списка
        debugPoint3(head1);  // Точка 3: Работа с узлами
    }

    // Точка для отладки 1: Создание списка
    private static void debugPoint1(Node head) {
        System.out.println("Точка 1: Создание списка");
        System.out.println("Голова списка: " + head);
        System.out.println("Значение головы: " + head.value);
        System.out.println("Следующий узел: " + head.next);
    }

    // Точка для отладки 2: Обход списка
    private static void debugPoint2(Node head) {
        System.out.println("\nТочка 2: Обход списка");
        Node current = head;
        int count = 0;

        while (current != null) {
            System.out.println("Текущий узел node" + count + ": value=" + current.value);
            current = current.next;
            count++;
        }
        System.out.println("Всего узлов: " + count);
    }

    // Точка для отладки 3: Работа с конкретным узлом
    private static void debugPoint3(Node head) {
        System.out.println("\nТочка 3: Работа с узлом node2");
        Node node2 = getNodeAtIndex(head, 2);
        System.out.println("node2: " + node2);
        System.out.println("node2.value = " + node2.value);
        System.out.println("node2.next = " + node2.next);
        System.out.println("node2.next.value = " + node2.next.value);
    }
}