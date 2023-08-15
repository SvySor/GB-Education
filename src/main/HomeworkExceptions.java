import java.util.Scanner;

public class HomeworkExceptions {

    private static float inputFloat(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            String string = scan.nextLine();
            try {
                float floatNumber = Float.parseFloat(string);
                return floatNumber;
            } catch (Exception e) {
                System.out.println("Введите корректное число");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите число с плавающей запятой");
        System.out.println("Ваше число: " + inputFloat());
    }
}
