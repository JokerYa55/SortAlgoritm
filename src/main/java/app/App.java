package app;

import app.util.SortAlgoritmUtil;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author vasil
 */
public class App {

    private static final int SIZE = 300000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] data = initArray(SIZE);
        SortAlgoritmUtil.quickSort(Arrays.copyOf(data, data.length));
        SortAlgoritmUtil.mergeSort(Arrays.copyOf(data, data.length));
        SortAlgoritmUtil.changeSort(Arrays.copyOf(data, data.length));
        SortAlgoritmUtil.bubleSort(Arrays.copyOf(data, data.length));
    }

    private static int[] initArray(int size) {
        Random random = new Random();
        return random.ints(0, 10_000_000).limit(size).toArray();
    }

}
