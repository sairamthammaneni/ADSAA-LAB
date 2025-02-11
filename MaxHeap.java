import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    // Method to get the index of the parent node
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Method to get the index of the left child
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Method to get the index of the right child
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Method to heapify (maintain heap property)
    private void heapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        // Check if left child is larger than the current node
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        // Check if right child is larger than the current largest
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        // If largest is not the current node, swap and recursively heapify
        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    // Method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Method to insert an element into the heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }

        // Insert the new element at the end
        heap[size] = value;
        int current = size;
        size++;

        // Fix the heap property by bubbling up
        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Method to extract the maximum element from the heap
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE; // or an appropriate error code
        }

        // The root contains the maximum element
        int max = heap[0];

        // Replace the root with the last element
        heap[0] = heap[size - 1];
        size--;

        // Heapify the root element
        heapify(0);

        return max;
    }

    // Method to get the maximum element without extracting it
    public int getMax() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }
        return heap[0];
    }

    // Method to print the heap elements
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);

        System.out.println("Heap after insertions:");
        maxHeap.printHeap();

        System.out.println("Extracted Max: " + maxHeap.extractMax());

        System.out.println("Heap after extraction:");
        maxHeap.printHeap();

        System.out.println("Current Max: " + maxHeap.getMax());
    }
}
