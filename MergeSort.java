import java.util.Random;

public class MergeSort {
    // Function to perform MergeSort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    // Function to merge two sorted subarrays
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
    
    private static void displayArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Driver method to test the sorting and measure execution time
    public static void main(String[] args) {
        Random rand = new Random();

        // Average case: Random array
        int[] avgArr = rand.ints(25, 0, 1000).toArray();
        System.out.print("Before Sorting: ");
        displayArray(avgArr); 
        long startTime = System.nanoTime();
        mergeSort(avgArr);
        long endTime = System.nanoTime();
        System.out.println("MergeSort (Average Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(avgArr);
        System.out.println();

        // Worst case: Sorted in descending order
        int[] worstArr = new int[25];
        for (int i = 0; i < worstArr.length; i++) {
            worstArr[i] = 1000 - i;
        }
        startTime = System.nanoTime();
        System.out.print("Before Sorting: ");
        displayArray(worstArr); 
        mergeSort(worstArr);
        endTime = System.nanoTime();
        System.out.println("MergeSort (Worst Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(worstArr); 
        System.out.println();

        // Best case: Sorted array
        int[] bestArr = new int[25];
        for (int i = 0; i < bestArr.length; i++) {
            bestArr[i] = i;
        }
        startTime = System.nanoTime();
        System.out.print("Before Sorting: ");
        displayArray(bestArr);
        mergeSort(bestArr);
        endTime = System.nanoTime();
        System.out.println("MergeSort (Best Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(bestArr);
    }
}
