public class App {
    private static final String str1 = "aasddfg";
    private static  final String str2 = "asdfgk";
    private static final String str3 = "assdfg";
    private static int i = 0;

    public static void main(String[] args) {

        if (toArray(str1)>0){i++;}
        if (toArray(str2)>0){i++;}
        if (toArray(str3)>0){i++;}

        System.out.println("Есть повторяющиеся символы: count = " + i);

    }

    static int toArray(String string) {
        int count = 0;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count = count + 1;
            }
        }
        return count;
    }
}
