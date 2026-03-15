package example4;


public class Recursion {
    public static int fact(int n) {
        System.out.println("Вычисление fact(" + n + ")");
        int result;
        if (n == 1) {
            System.out.println("  Базовый случай: fact(1) = 1");
            return 1;
        } else {
            result = fact(n - 1) * n;
            System.out.println("  fact(" + n + ") = fact(" + (n-1) + ") * " + n + " = " + result);
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println("Пример 4: Вычисление факториала");
        int n = 5;
        System.out.println(n + "! = " + fact(n));
    }
}