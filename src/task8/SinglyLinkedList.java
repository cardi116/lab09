package task8;


import java.util.Random;
import java.util.Scanner;

public class SinglyLinkedList {

    private Node head;  // голова списка

    public SinglyLinkedList() {
        this.head = null;
    }

    // ==================== МЕТОДЫ С ИСПОЛЬЗОВАНИЕМ ЦИКЛА ====================

    /**
     * a) Ввод с головы с использованием цикла
     * Создает список, добавляя новые элементы в начало
     */
    public void createHead(int[] values) {
        head = null; // очищаем список

        for (int i = values.length - 1; i >= 0; i--) {
            Node newNode = new Node(values[i]);
            newNode.next = head;
            head = newNode;
        }

        System.out.println("Список создан с головы (createHead)");
    }

    /**
     * Альтернативный вариант createHead с вводом с клавиатуры
     */
    public void createHeadFromInput() {
        Scanner scanner = new Scanner(System.in);
        head = null;

        System.out.println("Введите элементы списка (отрицательное число для завершения):");

        while (true) {
            System.out.print("Введите число: ");
            int value = scanner.nextInt();

            if (value < 0) {
                break;
            }

            // Добавляем в начало
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }

        System.out.println("Список создан с головы");
    }

    /**
     * b) Ввод с хвоста с использованием цикла
     * Создает список, добавляя новые элементы в конец
     */
    public void createTail(int[] values) {
        head = null; // очищаем список

        if (values.length == 0) return;

        // Создаем первый узел
        head = new Node(values[0]);
        Node current = head;

        // Добавляем остальные в конец
        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node(values[i]);
            current.next = newNode;
            current = newNode;
        }

        System.out.println("Список создан с хвоста (createTail)");
    }

    /**
     * Альтернативный вариант createTail с вводом с клавиатуры
     */
    public void createTailFromInput() {
        Scanner scanner = new Scanner(System.in);
        head = null;

        System.out.println("Введите элементы списка (отрицательное число для завершения):");

        Node current = null;

        while (true) {
            System.out.print("Введите число: ");
            int value = scanner.nextInt();

            if (value < 0) {
                break;
            }

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }

        System.out.println("Список создан с хвоста");
    }

    /**
     * c) Вывод списка в строку с использованием цикла
     * @return строка с элементами списка
     */
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(" -> ");
            }
            current = current.next;
        }

        result.append("]");
        return result.toString();
    }

    /**
     * Вывод списка в строку (упрощенный вариант)
     */
    public String toStringSimple() {
        StringBuilder result = new StringBuilder();
        Node current = head;

        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(" ");
            }
            current = current.next;
        }

        return result.toString();
    }

    /**
     * d) Добавление элемента в начало списка
     */
    public void AddFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        System.out.println("Элемент " + value + " добавлен в начало");
    }

    /**
     * e) Добавление элемента в конец списка
     */
    public void AddLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        System.out.println("Элемент " + value + " добавлен в конец");
    }

    /**
     * f) Вставка элемента в список с указанным номером (индексом)
     * @param value значение для вставки
     * @param position позиция для вставки (0 - начало)
     * @return true если вставка успешна
     */
    public boolean Insert(int value, int position) {
        if (position < 0) {
            System.out.println("Ошибка: позиция не может быть отрицательной");
            return false;
        }

        if (position == 0) {
            AddFirst(value);
            return true;
        }

        Node current = head;
        int index = 0;

        // Ищем узел перед позицией вставки
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Ошибка: позиция " + position + " превышает размер списка");
            return false;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;

        System.out.println("Элемент " + value + " вставлен на позицию " + position);
        return true;
    }

    /**
     * g) Удаление элемента с головы списка
     * @return удаленное значение или null если список пуст
     */
    public Integer RemoveFirst() {
        if (head == null) {
            System.out.println("Ошибка: список пуст");
            return null;
        }

        int removedValue = head.value;
        head = head.next;

        System.out.println("Удален элемент с головы: " + removedValue);
        return removedValue;
    }

    /**
     * h) Удаление последнего элемента списка
     * @return удаленное значение или null если список пуст
     */
    public Integer RemoveLast() {
        if (head == null) {
            System.out.println("Ошибка: список пуст");
            return null;
        }

        // Если в списке только один элемент
        if (head.next == null) {
            int removedValue = head.value;
            head = null;
            System.out.println("Удален последний элемент: " + removedValue);
            return removedValue;
        }

        // Ищем предпоследний элемент
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        int removedValue = current.next.value;
        current.next = null;

        System.out.println("Удален последний элемент: " + removedValue);
        return removedValue;
    }

    /**
     * i) Удаление элемента с указанным номером (индексом)
     * @param position позиция для удаления
     * @return удаленное значение или null если удаление не удалось
     */
    public Integer Remove(int position) {
        if (head == null) {
            System.out.println("Ошибка: список пуст");
            return null;
        }

        if (position < 0) {
            System.out.println("Ошибка: позиция не может быть отрицательной");
            return null;
        }

        if (position == 0) {
            return RemoveFirst();
        }

        Node current = head;
        int index = 0;

        // Ищем узел перед удаляемым
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null || current.next == null) {
            System.out.println("Ошибка: позиция " + position + " превышает размер списка");
            return null;
        }

        int removedValue = current.next.value;
        current.next = current.next.next;

        System.out.println("Удален элемент на позиции " + position + ": " + removedValue);
        return removedValue;
    }

    // ==================== МЕТОДЫ С ИСПОЛЬЗОВАНИЕМ РЕКУРСИИ ====================

    public void createHeadRec(int[] values) {
        head = createHeadRecHelper(values, values.length - 1);
        System.out.println("Список создан с головы (рекурсивно)");
    }

    private Node createHeadRecHelper(int[] values, int index) {
        if (index < 0) {
            return null;
        }

        Node node = new Node(values[index]);
        node.next = createHeadRecHelper(values, index - 1);
        return node;
    }


    public void createTailRec(int[] values) {
        head = createTailRecHelper(values, 0);
        System.out.println("Список создан с хвоста (рекурсивно)");
    }

    private Node createTailRecHelper(int[] values, int index) {
        if (index >= values.length) {
            return null;
        }

        Node node = new Node(values[index]);
        node.next = createTailRecHelper(values, index + 1);
        return node;
    }

    /**
     * l) Вывод списка в строку с использованием рекурсии
     * @return строка с элементами списка
     */
    public String toStringRec() {
        if (head == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        toStringRecHelper(head, result);
        result.append("]");
        return result.toString();
    }

    private void toStringRecHelper(Node node, StringBuilder result) {
        if (node == null) {
            return;
        }

        result.append(node.value);
        if (node.next != null) {
            result.append(" -> ");
        }

        toStringRecHelper(node.next, result);
    }

    /**
     * Рекурсивный вывод в обратном порядке (для демонстрации)
     */
    public String toStringReverseRec() {
        if (head == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        toStringReverseRecHelper(head, result);
        result.append("]");
        return result.toString();
    }

    private void toStringReverseRecHelper(Node node, StringBuilder result) {
        if (node == null) {
            return;
        }

        toStringReverseRecHelper(node.next, result);

        result.append(node.value);
        if (node != head) {
            result.append(" <- ");
        }
    }

    // ==================== ДОПОЛНИТЕЛЬНЫЕ МЕТОДЫ ====================

    /**
     * Очистка списка
     */
    public void clear() {
        head = null;
        System.out.println("Список очищен");
    }

    /**
     * Получение размера списка (итеративно)
     */
    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * Получение размера списка (рекурсивно)
     */
    public int sizeRec() {
        return sizeRecHelper(head);
    }

    private int sizeRecHelper(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecHelper(node.next);
    }

    /**
     * Поиск элемента по значению
     */
    public int find(int value) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    /**
     * Получение элемента по индексу
     */
    public Integer get(int index) {
        if (index < 0) {
            return null;
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.value;
            }
            current = current.next;
            currentIndex++;
        }

        return null;
    }

    /**
     * Сортировка списка (пузырьковая)
     */
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;

            while (current.next != null) {
                if (current.value > current.next.value) {
                    // Обмен значениями
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("Список отсортирован");
    }

    /**
     * Разворот списка (итеративно)
     */
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        System.out.println("Список развернут");
    }

    /**
     * Разворот списка (рекурсивно)
     */
    public void reverseRec() {
        head = reverseRecHelper(head, null);
        System.out.println("Список развернут (рекурсивно)");
    }

    private Node reverseRecHelper(Node current, Node prev) {
        if (current == null) {
            return prev;
        }

        Node next = current.next;
        current.next = prev;
        return reverseRecHelper(next, current);
    }

    /**
     * Создание списка со случайными значениями
     */
    public void createRandom(int count, int bound) {
        Random random = new Random();
        int[] values = new int[count];

        for (int i = 0; i < count; i++) {
            values[i] = random.nextInt(bound);
        }

        createTail(values);
        System.out.println("Создан случайный список из " + count + " элементов");
    }
}