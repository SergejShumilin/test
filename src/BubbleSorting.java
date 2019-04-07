import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] data = {40, 30, 50, 10, 20};

        for (int barrier = data.length - 1; barrier > 0; barrier--){
            for (int index = 0; index < barrier; index++){
                if(data[index]>data[index+1]){
                    swap(data, index);
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    private static void swap(int[] data, int index) {
        int tmp = data[index];
        data[index] = data[index+1];
        data[index+1] = tmp;
    }


}
