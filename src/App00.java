import java.util.HashSet;
import java.util.Set;

public class App00 {
    private static final String str1 = "aasddfg";
    private static final String str2 = "asdfgks";
    private static final String str3 = "asdfg";
    private static final String str4 = "авасв";

    private static int count = 0;

    public static void main(String[] args) {
        toArray(str1);
        toArray(str2);
        toArray(str3);
        toArray(str4);
        System.out.println("строки имеют повторяющиеся символы: count = " + count);
    }

    private static void toArray(String string) {
        char[] chars = string.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        if (chars.length != set.size()){
            count++;
        }
    }
}
