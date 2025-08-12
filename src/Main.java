import java.io.FileNotFoundException;

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
        matrix.turnClockwise();
        System.out.println("Матрица после поворота:");
        System.out.println(matrix);
    }
}