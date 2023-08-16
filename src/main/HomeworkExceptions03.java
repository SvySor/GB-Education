import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HomeworkExceptions03 {

    private static void readData() {
        Scanner scanner = new Scanner(System.in);
        Pattern phone = Pattern.compile("^[0-9]{11}$");
        SimpleDateFormat birthday = new SimpleDateFormat("dd.MM.yyyy", Locale.US);

        System.out.println("Введите ваши данные в формате: Фамилия Имя Отчество, дата рождения, номер телефона, пол");
        String userData = scanner.nextLine();
        String[] userDataArray = userData.split(" ");
        if (userDataCheck(userDataArray)) {
            String[] targetData = new String[6];
            for (int i = 0; i < 6; i++) {
                String currentElement = userDataArray[i];
                if (currentElement.equals("f") || currentElement.equals("m")) {
                    targetData[5] = currentElement;
                } else {
                    if (phone.matcher(currentElement).matches()) {
                        targetData[4] = currentElement;
                    } else {
                        try {
                            birthday.parse(currentElement);
                            targetData[3] = currentElement;
                        } catch (Exception e) {
                            targetData[0] = currentElement;
                            targetData[1] = userDataArray[i + 1];
                            targetData[2] = userDataArray[i + 2];
                            i = i + 2;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(targetData));
            try {
                writeData(targetData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean userDataCheck(String[] userDataArray) {
        if (userDataArray.length > 6) {
            System.out.println("Вы ввели больше данных, чем нужно");
            return false;
        } else {
            if (userDataArray.length < 6) {
                System.out.println("Вы ввели недостаточно данных");
                return false;
            }
        }
        System.out.println("Ваши данные приняты");
        return true;
    }

    private static void writeData(String[] userDataArray) throws IOException {
        String family = userDataArray[0];
        File file = new File("data/" + family + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++){
            sb.append(userDataArray[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        sb.append("\n");
        fileWriter.write(sb.toString());
        fileWriter.close();
    }

    public static void main(String[] args) {
        readData();
    }
}
