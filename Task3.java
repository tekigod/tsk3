// На вход
// некоторому исполнителю
// подаётся четыре числа (a, b, c, d).

// У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раз, а умножается на c
// - команда 2 (к2): увеличить на d , к a прибавляется d
// написать программу, которая выдаёт общее количество
// возможных преобразований a в b
// набор команд, позволяющий число a превратить в число b или сообщить, что это
// невозможно

// Пример 1: а = 1, b = 7, c = 2, d = 1
// ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
// Пример 2: а = 11, b = 7, c = 2, d = 1
// ответ: нет решения.

import java.util.Scanner;

public class Task3 {
    public static int[] myMeth(int a, int b, int c, int d) {
        int[] newArr = new int[b + 1];
        newArr[a] = 1;
        for (int i = 0; i <= b; i++) {
            if (i % c == 0 && i / c > 0) {
                newArr[i] += newArr[i / c];
            }
            if (i > a && i - d > 0) {
                newArr[i] += newArr[i - d];
            }
        }
        return newArr;
    }

    public static String mPath(int a, int b, int c, int d, int[] array) {
        String res = "";
        while (b > a) {
            if (b % c == 0 && array[b/c] != 0) {
                res = String.format(" *%d", c) + res;
                b = b / c;
            } else {
                res = String.format(" +%d", d) + res;
                b -= d;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число a: ");
        int a = iScanner.nextInt();
        System.out.printf("Введите число b: ");
        int b = iScanner.nextInt();
        System.out.printf("Введите число c: ");
        int c = iScanner.nextInt();
        System.out.printf("Введите число d: ");
        int d = iScanner.nextInt();
        iScanner.close();
        int[] res = myMeth(a, b, c, d);
        if (res[b] == 0) {
            System.out.println("Нет решения!");
        } else {
            System.out.println("Количество возможных путей из " + a + " в " + b + ": " + res[b]);
            System.out.println(mPath(a, b, c, d, res));
        }
    }
}