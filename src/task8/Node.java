package task8;


/**
 * Класс узла односвязного списка
 */
class Node {
    public int value;      // значение узла
    public Node next;      // ссылка на следующий узел

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}