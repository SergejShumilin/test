

public class App {
    private static final String str1 = "aasddfg";
    private static final String str2 = "asdfgks";
    private static final String str3 = "asdfg";
    private static final String str4 = "авасв";

    private static int count = 0;

    public static void main(String[] args) {
        if (toArray(str1) > 0) {count++;}
        if (toArray(str2) > 0) {count++;}
        if (toArray(str3) > 0) {count++;}
        if (toArray(str4) > 0) {count++;}
        System.out.println("Есть повторяющиеся символы: count = " + count);
    }

    private static int toArray(String string) {

        int count = 0;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < chars.length; j++) {
                if (i != j) {
                    if (chars[i] == chars[j]) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;

    }
}
