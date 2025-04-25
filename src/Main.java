import java.util.Random;

public class Main {

    // Program starts here
    public static void main(String[] args) {
        int[] numbers = generate(1, 100, 10000);  // create 10,000 random numbers from 1 to 100
        mergesort(numbers, 0, 99);               // sort just the first 100
        display(numbers, 100);                   // show the first 100
    }

    // Create and return an array of random numbers
    public static int[] generate(int low, int high, int size) {
        int[] result = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(high - low + 1) + low; // random number in range
        }
        return result;
    }

    // Merge sort from index 'low' to 'high'
    public static void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(a, low, mid);       // sort left half
            mergesort(a, mid + 1, high);  // sort right half
            merge(a, low, mid, high);     // merge both
        }
    }

    // Merge two sorted halves
    private static void merge(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = a[low + i];        // copy left half
        for (int j = 0; j < n2; j++)
            right[j] = a[mid + 1 + j];   // copy right half

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            a[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }

        while (i < n1) a[k++] = left[i++];   // copy remaining left
        while (j < n2) a[k++] = right[j++];  // copy remaining right
    }

    // Print the first 'count' numbers from the array
    public static void display(int[] a, int count) {
        for (int i = 0; i < Math.min(a.length, count); i++) {
            System.out.print(a[i]);
            System.out.print((i % 10 == 9) ? "\n" : "\t");  // print 10 per line
        }
        System.out.println();
    }
}
