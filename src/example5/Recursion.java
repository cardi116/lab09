package example5;


import java.util.ArrayList;
import java.util.List;

public class Recursion {
    private static int callCounter = 0;
    private static List<String> treeTraversal = new ArrayList<>();

    public static int fact(int n) {
        callCounter++;
        String indent = getIndent(callCounter);

        treeTraversal.add(indent + "→ Вызов fact(" + n + ")");
        System.out.println(indent + "Вызов fact(" + n + ")");

        int result;
        if (n == 0) {
            treeTraversal.add(indent + "  ← Базовый случай: fact(0) = 0");
            System.out.println(indent + "  Базовый случай: fact(0) = 0");
            callCounter--;
            return 0;
        } else if (n == 1) {
            treeTraversal.add(indent + "  ← Базовый случай: fact(1) = 1");
            System.out.println(indent + "  Базовый случай: fact(1) = 1");
            callCounter--;
            return 1;
        } else {
            System.out.println(indent + "  Вычисляем fact(" + n + ") = fact(" + (n-2) + ") + fact(" + (n-1) + ")");

            int left = fact(n - 2);
            int right = fact(n - 1);
            result = left + right;

            treeTraversal.add(indent + "  ← fact(" + n + ") = " + left + " + " + right + " = " + result);
            System.out.println(indent + "  fact(" + n + ") = " + left + " + " + right + " = " + result);

            callCounter--;
            return result;
        }
    }

    private static String getIndent(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Пример 5: Числа Фибоначчи с обходом дерева рекурсивных вызовов");
        System.out.println("=================================================================");

        int n = 5;
        System.out.println("\nВычисление fact(" + n + "):");
        System.out.println("-----------------------------------------------------------------");

        int result = fact(n);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("\nРезультат: fact(" + n + ") = " + result);

        System.out.println("\nПоследовательность обхода дерева рекурсивных вызовов:");
        System.out.println("=================================================================");
        for (String step : treeTraversal) {
            System.out.println(step);
        }
        System.out.println("=================================================================");
    }
}