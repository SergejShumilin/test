public class AppReverse {
    public static void main(String[] args) {
        String string = "Hello World";
        StringBuilder stringBuilder = new StringBuilder(string).reverse();
        System.out.println(stringBuilder);
    }
}
