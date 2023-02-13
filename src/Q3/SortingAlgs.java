package Q3;

public class SortingAlgs {
    public static int[] bubbleSort(int[] array) {
        for (int lcv = 0; lcv < array.length; lcv++) {
            for (int lcv2 = 0; lcv2 < array.length-1; lcv2++) {
                if (array[lcv2] > array[lcv2 + 1]) {
                    int temp = array[lcv2];
                    array[lcv2] = array[lcv2 + 1];
                    array[lcv2 + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int lcv = 0; lcv < array.length; lcv++) {
            int min = lcv;
            for (int lcv2 = lcv + 1; lcv2 < array.length; lcv2++) {
                if (array[lcv2] < array[min]) min = lcv2;
            }
            int temp = array[lcv];
            array[lcv] = array[min];
            array[min] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        for (int lcv = 1; lcv < array.length; lcv++) {
            int temp = array[lcv];
            int lcv2 = lcv - 1;
            while (lcv2 >= 0 && array[lcv2] > temp) {
                array[lcv2+1] = array[lcv2];
                lcv2--;
            }
            array[lcv2+1] = temp;
        }
        return array;
    }

    public static Cl408a[] insertionSort(Cl408a[] array) {
        for (int lcv = 1; lcv < array.length; lcv++) {
            Cl408a temp = array[lcv];
            int lcv2 = lcv - 1;
            while (lcv2 >= 0 && array[lcv2].getScore() < temp.getScore()) {
                array[lcv2+1] = array[lcv2];
                lcv2--;
            }
            array[lcv2+1] = temp;
        }
        return array;
    }
}
