public class HomeworkExceptions0202 {

    public static void main(String[] args) {
//        int[] intArray = {0, 12, 56, 33, 45, 6, 77, 87, 90};
        int[] intArray = {0, 12, 56, 33, 45};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException i) {
            System.out.println("Catching exception: " + i);
        }
    }
}
