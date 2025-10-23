package circularqueuquicksort;

public class QuickSortStrings {
    static void swap(String[] arr, int i, int j) {
        String temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    static int partition(String[] arr, int low, int high) {
        String pivot = arr[high]; int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) { i++; swap(arr, i, j); }
        }
        swap(arr, i + 1, high); return i + 1;
    }

    static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1); quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"Banana", "Apple", "Mango", "Cherry"};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted strings:");
        for (String s : arr) System.out.println(s);
    }
}
