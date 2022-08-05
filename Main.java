package com.company;
import java.util.Arrays;

class FuncStat {
    public static int fiboR(int n) {
        if (n < 2) {
            return n;
        } else {
            return fiboR(n - 1) + fiboR(n - 2);

        }
    }

    public static int fiboI(int n) {
        {
            if (n <= 1) {
                return n;
            }

            int previousFib = 0, currentFib = 1;
            for (int i = 0; i < n - 1; i++) {
                int newFib = previousFib + currentFib;
                previousFib = currentFib;
                currentFib = newFib;
            }

            return currentFib;
        }
    }

    public static int factR(int n) {
        if (n >= 1)
            return n * factR(n - 1);
        else
            return 1;
    }

    public static int factI(int n) {
        int result = 1;
        while (n > 1) {
            result = result * n;
            n -= 1;
        }
        return result;

    }

    public static int gcdR(int a, int b) {
        if (b != 0) {
            return gcdR(b, a % b);
        } else {
            return a;
        }
    }

    public static int gcdI(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int maxElem(int[] arr, int from) {
        if (from == arr.length - 1) {
            return arr[from];
        }
        int a = maxElem(arr, from + 1);
        if (a > arr[from]) {
            return a;
        } else {
            return arr[from];
        }
    }

    public static int numEven(int[] arr, int from) {
        if (arr.length == from) {
            return 0;
        } else if (arr[from] % 2 == 0) {

            return 1 + numEven(arr, from + 1);
        } else {

            return 0 + numEven(arr, from + 1);
        }


    }

    public static void reverse(int[] arr, int from) {
        int temp;
        int end = arr.length-1;

        while (from < end)
        {
            temp = arr[from];
            arr[from] = arr[end];
            arr[end] = temp;
            from++;
            end--;
        }
    }

    public static boolean isPalindrom(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;
        if (s.charAt(0) == s.charAt(s.length() - 1))
            return isPalindrom(s.substring(1, s.length() - 1));
        return false;


    }


    public static void main(String[] args) {
        System.out.println("Wait...");
        System.out.println(FuncStat.fiboR(45));
        System.out.println(FuncStat.fiboI(45));
        System.out.println(FuncStat.factR(12));
        System.out.println(FuncStat.factI(12));
        System.out.println(FuncStat.gcdR(12125, 40643));
        System.out.println(FuncStat.gcdI(12125, 40643));
        int[] a = {3, 8, 2, 9, 7, 4};
        System.out.println("Max : " + FuncStat.maxElem(a, 0));
        System.out.println("Num even: " + FuncStat.numEven(a, 0));
        System.out.println("Before: " + Arrays.toString(a));
        FuncStat.reverse(a, 0);
        System.out.println("After : " + Arrays.toString(a));
        System.out.println("Is 'radar' a palindrom? " +
                FuncStat.isPalindrom("radar"));
        System.out.println("Is 'abba' a palindrom? " +
                FuncStat.isPalindrom("abba"));
        System.out.println("Is 'rover' a palindrom? " +
                FuncStat.isPalindrom("rover"));
    }
}
