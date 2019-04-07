import java.util.Arrays;

public class AppReversLoop {
    public static void main(String[] args) {
        int[] data = {10, 20, 30, 40, 50};

        for (int index = 0; index<data.length/2; index++){
            swap(data, index, data.length-1-index);
        }

        System.out.println(Arrays.toString(data));
    }

    private static void swap(int[] data, int first, int second) {
        int tmp = data[first];
        data[first] = data[second];
        data[second] = tmp;
    }
}
