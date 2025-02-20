import java.util.Random;

public class QuickSort {
    // Function to perform QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);  // Sort left half
            quickSort(arr, pi + 1, high); // Sort right half
        }
    }

    // Function to find the partition index
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // pivot element
        int i = (low - 1);  // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot element)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver method to test the sorting and measure execution time
    public static void main(String[] args) {
        Random rand = new Random();
    
        // Average case: Random array
        int[] avgArr = rand.ints(25, 0, 100).toArray();
        System.out.println("Average Case (Before Sorting):");
        printArray(avgArr);  // Display the array before sorting
        long startTime = System.nanoTime();
        quickSort(avgArr, 0, avgArr.length - 1);
        long endTime = System.nanoTime();
        System.out.println("QuickSort (Average Case) Time: " + (endTime - startTime) + " ns");
        System.out.println("Average Case (After Sorting):");
        printArray(avgArr);  // Display the array after sorting
    
        // Worst case: Sorted in descending order
        int[] worstArr = new int[25];
        for (int i = 0; i < worstArr.length; i++) {
            worstArr[i] = 100 - i;
        }
        System.out.println("Worst Case (Before Sorting):");
        printArray(worstArr);  // Display the array before sorting
        startTime = System.nanoTime();
        quickSort(worstArr, 0, worstArr.length - 1);
        endTime = System.nanoTime();
        System.out.println("QuickSort (Worst Case) Time: " + (endTime - startTime) + " ns");
        System.out.println("Worst Case (After Sorting):");
        printArray(worstArr);  // Display the array after sorting
    
        // Best case: Sorted array
        int[] bestArr = new int[25];
        for (int i = 0; i < bestArr.length; i++) {
            bestArr[i] = i;
        }
        System.out.println("Best Case (Before Sorting):");
        printArray(bestArr);  // Display the array before sorting
        startTime = System.nanoTime();
        quickSort(bestArr, 0, bestArr.length - 1);
        endTime = System.nanoTime();
        System.out.println("QuickSort (Best Case) Time: " + (endTime - startTime) + " ns");
        System.out.println("Best Case (After Sorting):");
        printArray(bestArr);  // Display the array after sorting
    }
}
