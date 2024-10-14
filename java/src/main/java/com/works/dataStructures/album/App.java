package com.works.dataStructures.album;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arrayMain = { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4 };

        System.out.println("1. Get lower number from array");
        System.out.println(getLowerNumber(arrayMain));

        System.out.println("2. Get higher number from array");
        System.out.println(getHigherNumber(arrayMain));

        System.out.println("3. Get Lower and higher number from array");
        System.out.println(Arrays.toString(getLowerHigherNumber(arrayMain)));

        System.out.println("4. Get number with index from array");
        System.out.println(getNumberFromArray(arrayMain, 11));

        System.out.println("5. Validate if array is sorted");
        // Arrays.sort(arrayMain); test
        System.out.println(isOrdered(arrayMain));

        System.out.println("6. Count numbers Prime from array");
        System.out.println(countPrimeNumbers(arrayMain));

        // ------

        System.out.println("Album");
        Album album = new Album();
        album.setMinImage(0);
        album.setMaxImage(649);

        int[] arrayAlbum = { 2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 58, 259 };

        System.out.println("7. Get image repeated");
        System.out.println(Arrays.toString(album.getImageRepeated(arrayAlbum)));
    }

    public static int getLowerNumber(int[] array) {
        int[] arrayCopy = array.clone();
        Arrays.sort(arrayCopy);

        return arrayCopy[0];
    }

    public static int getHigherNumber(int[] array) {
        int[] arrayCopy = array.clone();
        Arrays.sort(arrayCopy);

        return arrayCopy[array.length - 1];
    }

    public static int[] getLowerHigherNumber(int[] array) {
        int[] arrayCopy = array.clone();
        Arrays.sort(arrayCopy);

        int[] both = { arrayCopy[0], arrayCopy[array.length - 1] };
        return both;
    }

    public static int getNumberFromArray(int[] array, int index) {
        if (index > array.length)
            return -1;

        return array[index - 1];
    }

    public static boolean isOrdered(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return false;

        return true;
    }

    public static int countPrimeNumbers(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++)
            if (isPrime(array[i]))
                count++;
        return count;
    }

    private static boolean isPrime(int number) {
        if (number == 1)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(number); i += 2)
            if (number % i == 0)
                return false;
        return true;
    }

}
