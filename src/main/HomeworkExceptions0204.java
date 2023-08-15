import java.util.Scanner;

public class HomeworkExceptions0204 {

//    4.	Разработайте программу, которая выбросит Exception,
//    когда пользователь вводит пустую строку.
//    Пользователю должно показаться сообщение,
//    что пустые строки вводить нельзя.

    private static String inputString() throws Exception {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        if (string.length() != 0) {
            return string;
        } else {
            throw new Exception("Вы ввели пустую строку");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Введите непустую строку:");
            System.out.println("Вы ввели: " + inputString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
