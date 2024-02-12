package Q3.Prog408a;

public class SortingAlgs {
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min_index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min_index]) min_index = j;
            }
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i-1;
            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }

    public static Cl408a[] insertionSort(Cl408a[] array) {
        for (int i = 1; i < array.length; i++) {
            Cl408a key = array[i];
            int j = i-1;
            while (j >= 0 && array[j].getScore() < key.getScore()) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }
}
