import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelQuicksort extends RecursiveAction {
    private final int[] array;
    private final int low;
    private final int high;

    public ParallelQuicksort(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            ParallelQuicksort left = new ParallelQuicksort(array, low, pivotIndex - 1);
            ParallelQuicksort right = new ParallelQuicksort(array, pivotIndex + 1, high);
            invokeAll(left, right);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void parallelQuickSort(int[] array) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ParallelQuicksort task = new ParallelQuicksort(array, 0, array.length - 1);
        forkJoinPool.invoke(task);
    }
}