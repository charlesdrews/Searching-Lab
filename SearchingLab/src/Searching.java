/**
 * Created by charlie on 3/15/16.
 */
public class Searching {
    public static void main(String[] args) {
        int[] numbers  = new int[]{5,12,2,32,-2,-10,-1,100,16,101};

        System.out.println("Unsorted numbers:");
        for (int i=0;i<numbers.length;i++) {
            System.out.println(String.valueOf(numbers[i]));
        }

        quickSort(numbers);

        System.out.println("Quick-sorted numbers:");
        for (int i=0;i<numbers.length;i++) {
            System.out.println(String.valueOf(numbers[i]));
        }

        System.out.println("Search for 16:");
        System.out.println(binarySearch(numbers, 16));
    }

    public static int binarySearch(int[] array, int searchValue) {
        return binarySearch(array, searchValue, 0, array.length - 1);
    }

    /**
     * Returns position of searchValue in a sorted array from lowIdx to highIdx
     * @param array - must be sorted
     * @param searchValue - value to be found
     * @param lowIdx - starting index of array to search, inclusive
     * @param highIdx - ending index of array to search, inclusive
     * @return index of searchValue in array if present, -1 otherwise
     */
    public static int binarySearch(int[] array, int searchValue, int lowIdx, int highIdx) {
        // base case if subarray has length 1
        if (highIdx == lowIdx) {
            return array[highIdx] == searchValue ? highIdx : -1;
        }

        int midIdx = lowIdx + ((highIdx - lowIdx) / 2);
        int midVal = array[midIdx];

        if (midVal == searchValue) {
            return midIdx;
        } else if (midVal > searchValue) {
            return binarySearch(array, searchValue, lowIdx, midIdx - 1);
        } else {
            return binarySearch(array, searchValue, midIdx + 1, highIdx);
        }
    }

    public static void quickSort(int[] array) {
        if (array.length > 1) {
            quickSort(array, 0, array.length - 1);
        }
    }

    public static void quickSort(int[] array, int lowIdx, int highIdx) {
        if (lowIdx < highIdx) {
            int pivotIdx = partition(array, lowIdx, highIdx);
            quickSort(array, lowIdx, pivotIdx);
            quickSort(array, pivotIdx + 1, highIdx);
        }
    }

    public static int partition(int[] array, int lowIdx, int highIdx) {
        int pivot = array[lowIdx];
        int leftMaxIdx = lowIdx;

        for (int i = lowIdx + 1; i <= highIdx; i++) {
            if (array[i] < pivot) {
                // move leftMaxIdx right one, then swap w/ position i
                swap(array, i, ++leftMaxIdx);
            }
        }
        // the pivot value is still in array[low]; move it to final position
        swap(array, lowIdx, leftMaxIdx);

        return leftMaxIdx;
    }

    public static void swap(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }
}