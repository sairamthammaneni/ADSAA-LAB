import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public MinHeap(int capacity) {
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
        int smallest = index;

        // Check if left child is smaller than the current node
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        // Check if right child is smaller than the current smallest
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // If smallest is not the current node, swap and recursively heapify
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
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
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Method to extract the minimum element from the heap
    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return Integer.MAX_VALUE; // or an appropriate error code
        }

        // The root contains the minimum element
        int min = heap[0];

        // Replace the root with the last element
        heap[0] = heap[size - 1];
        size--;

        // Heapify the root element
        heapify(0);

        return min;
    }

    // Method to get the minimum element without extracting it
    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return Integer.MAX_VALUE;
        }
        return heap[0];
    }

    // Method to print the heap elements
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(15);

        System.out.println("Heap after insertions:");
        minHeap.printHeap();

        System.out.println("Extracted Min: " + minHeap.extractMin());

        System.out.println("Heap after extraction:");
        minHeap.printHeap();

        System.out.println("Current Min: " + minHeap.getMin());
    }
}
