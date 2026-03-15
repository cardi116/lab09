package example3;

public class Recursion {
    private static int step = 0;

    public static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print(" ");
        }
    }

    public static void m(int x) {
        space();
        System.out.println("Вход в m(" + x + ")");
        step++;

        if ((2 * x + 1) < 20) {
            m(2 * x + 1);
        }

        step--;
        space();
        System.out.println("Выход из m(" + x + ")");
    }

    public static void main(String[] args) {
        System.out.println("Пример 3: Демонстрация входа и выхода");
        m(1);
    }
}