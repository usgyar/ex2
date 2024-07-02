import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);

        String fileName = input.nextLine();
        String delimiter = input.nextLine();

        double a, b, c;

        try(Scanner reader = new Scanner(new File(fileName))){
            String line = reader.nextLine();
            String[] coefficients = line.split(delimiter);

            if (coefficients.length != 3)
                throw new IllegalArgumentException("Чисел в файле должно быть 3");

            a = Double.valueOf(coefficients[0]);
            b = Double.valueOf(coefficients[1]);
            c = Double.valueOf(coefficients[2]);
        }

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d < 0){
            System.out.println("Решения нет");
            return;
        }
        System.out.println("Решение:");
        if (d == 0){
            System.out.println(-b/(2*a));
            return;
        }
        double x1 = (-b+Math.sqrt(d))/(2*a);
        double x2 = (-b-Math.sqrt(d))/(2*a);
        System.out.println(x1 + ", " + x2);
    }
}