
import java.util.Random;

public class BubbleSort {

    private int[] array;
    private int size;

    public BubbleSort(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public void randomElement() {
        Random random = new Random();

        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(this.array.length);
        }
    }

    public void sort() {
        int length = this.array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (this.array[j] > this.array[j + 1]) {
                    int temp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    this.array[j + 1] = temp;
                }
            }
        }
    }

    public void display() {
        for (int x : this.array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public int[] getArray() {
        return this.array;
    }
}
