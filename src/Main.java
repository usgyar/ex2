import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        if (args.length != 2)
            throw new IllegalArgumentException("Должно быть 2 аргумента, название файла и разделитель");

        String fileName = args[0];
        String delimiter = args[1];

        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException("Файл не найден");

        double a, b, c;

        try(Scanner reader = new Scanner(file)){
            String line = reader.nextLine();

            if (!line.contains(delimiter)) {
                throw new IllegalArgumentException("Такого разделителя нет в файле");
            }

            String[] coefficients = line.split(delimiter);
            if (coefficients.length != 3)
                throw new IllegalArgumentException("Чисел в файле должно быть 3");

            a = Double.parseDouble(coefficients[0]);
            b = Double.parseDouble(coefficients[1]);
            c = Double.parseDouble(coefficients[2]);
        }

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d < 0){
            System.out.println("Решения нет");
        } else {
            System.out.println("Решение:");
            if (d == 0){
                System.out.println(-b/(2*a));
            } else {
                double x1 = (-b+Math.sqrt(d))/(2*a);
                double x2 = (-b-Math.sqrt(d))/(2*a);
                System.out.println(x1 + ", " + x2);
            }
        }
    }
}