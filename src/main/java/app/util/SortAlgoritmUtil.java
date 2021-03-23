package app.util;

import java.util.Arrays;
import lombok.experimental.UtilityClass;

/**
 *
 * @author vasil
 */
@UtilityClass
public class SortAlgoritmUtil {

    public static int[] quickSort(int[] data) {
        System.out.println("Быстрая сортировка");
        printArray(data);
        long startTime = System.nanoTime();
        qSort(data, 0, data.length - 1);
        long endTime = System.nanoTime();
        printArray(data);
        System.out.println("Время выполнения : " + (endTime - startTime) / 1000 + " ms.");
        return data;
    }

    /**
     * Быстрая сортировка
     *
     * @param data
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static void qSort(int[] data, int beginIndex, int endIndex) {

        //завершить выполнение если длина массива равна 0
        if (data.length == 0) {
            return;
        }
        //завершить выполнение если уже нечего делить
        if (beginIndex >= endIndex) {
            return;
        }

        // выбрать опорный элемент
        int middle = endIndex + (beginIndex - endIndex) / 2;
        int opora = data[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = beginIndex, j = endIndex;
        while (i <= j) {
            while (data[i] < opora) {
                i++;
            }

            while (data[j] > opora) {
                j--;
            }
            //меняем местами
            if (i <= j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (beginIndex < j) {
            qSort(data, beginIndex, j);
        }

        if (endIndex > i) {
            qSort(data, i, endIndex);
        }

//        long endTime = System.nanoTime();
//        System.out.println("Время выполнения : " + (endTime - startTime) / 1000 + " ms.");
    }

    /**
     * Пузырьковая сортировка
     *
     * @param data
     * @return
     */
    public static int[] bubleSort(int[] data) {
        System.out.println("Сортировка пузырьком");
        printArray(data);
        long startTime = System.nanoTime();
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[j] <= data[i]) {
                    int temp = data[j];
                    data[j] = data[i];
                    data[i] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        printArray(data);
        System.out.println("Время выполнения : " + (endTime - startTime) / 1000 + " ms.");
        return data;
    }

    /**
     * Сортировка обменом
     *
     * @param data
     * @return
     */
    public static int[] changeSort(int[] data) {
        System.out.println("Сортировка обменом");
        printArray(data);
        long startTime = System.nanoTime();
        for (int i = 0; i < data.length - 1; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int j = 0; j < data.length - i; j++) {
                if (data[j] > max) {
                    max = data[j];
                    maxIndex = j;
                }
            }
            int dataMax = data[data.length - i - 1];
            data[data.length - i - 1] = data[maxIndex];
            data[maxIndex] = dataMax;
        }
        long endTime = System.nanoTime();
        printArray(data);
        System.out.println("Время выполнения : " + (endTime - startTime) / 1000 + " ms.");
        return data;
    }

    /**
     * Сортировка слиянием
     *
     * @param data
     * @return
     */
    public static int[] mergeSort(int[] data) {
        System.out.println("Сортировка слиянием");
        printArray(data);
        long startTime = System.nanoTime();

        mSort(data, 0, data.length - 1);

        long endTime = System.nanoTime();
        printArray(data);
        System.out.println("Время выполнения : " + (endTime - startTime) / 1000 + " ms.");
        return data;
    }

    /**
     *
     * @param buf1
     * @param beginIndex
     * @param endIndex
     */
    private static void mSort(int[] data, int beginIndex, int endIndex) {
        if (endIndex <= beginIndex) {
            return;
        }
        int middleIndex = (endIndex + beginIndex) / 2;

        mSort(data, beginIndex, middleIndex);
        mSort(data, middleIndex + 1, endIndex);

        // Слияние
        merge(data, beginIndex, middleIndex, endIndex);
    }

    /**
     * Слияние
     *
     * @param date
     * @param beginIndex
     * @param endIndex
     */
    public static void merge(int[] data, int beginIndex, int middleIndex, int endIndex) {
        // Слияние
        int lenLeft = middleIndex - beginIndex + 1;
        int lenRigth = endIndex - middleIndex;

        // Копируем отсортированные массивы во временные
        int[] tempLeft = Arrays.copyOfRange(data, beginIndex, beginIndex + lenLeft);
        int[] tempRigth = Arrays.copyOfRange(data, middleIndex + 1, middleIndex + 1 + lenRigth);

        int indexLeft = 0;
        int indexRigth = 0;

        // Копируем обратно в массив
        for (int i = beginIndex; i < endIndex + 1; i++) {
            if (indexLeft < tempLeft.length && indexRigth < tempRigth.length) {
                if (tempLeft[indexLeft] < tempRigth[indexRigth]) {
                    data[i] = tempLeft[indexLeft];
                    indexLeft++;
                } else {
                    data[i] = tempRigth[indexRigth];
                    indexRigth++;
                }
            } // Если остались элементы в leftTemp
            else if (indexLeft < tempLeft.length) {
                data[i] = tempLeft[indexLeft];
                indexLeft++;
            }// Если остались элементы в rigthTemp
            else if (indexRigth < tempRigth.length) {
                data[i] = tempRigth[indexRigth];
                indexRigth++;
            }
        }
    }

    /**
     * Печать данных
     *
     * @param data
     */
    public static void printArray(int[] data) {
        System.out.println(Arrays.toString(data));
    }

}
