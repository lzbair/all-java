public class ArrayLimitation {

    public static void main(String... args) {
        fill(new String[10], 3);
    }

    static <T> void fill(T[] arr, T value) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = value;
    }
}
