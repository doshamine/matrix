import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static int SIZE = 8;
    public static String FILENAME = "example.dat";

    public static void main(String[] args) {
        Matrix matrix = new Matrix(SIZE, SIZE);

        try {
            matrix.setValues(FILENAME);
        } catch (FileNotFoundException e) {
            System.err.printf("Файл %s не найден", FILENAME);
        }

        System.out.println("Матрица до поворота:");
        System.out.println(matrix);

        System.out.print("Выберите угол поворота по часовой стрелке (90, 180 или 270): ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();

        switch (choice) {
            case "90":
                matrix.turn(RotationType.CLOCKWISE);
                break;
            case "180":
                matrix.turn(RotationType.REFLECTION);
                break;
            case "270":
                matrix.turn(RotationType.COUNTERCLOCKWISE);
                break;
            default:
                System.out.println("Неверное значение угла поворота");
                System.exit(0);
        }

        System.out.println("Матрица после поворота:");
        System.out.println(matrix);
    }
}