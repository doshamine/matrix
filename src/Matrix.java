import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private int[][] values;
    private int height;
    private int width;

    public Matrix(int height, int width) {
        this.values = new int[height][width];
        this.height = height;
        this.width = width;
    }

    public void setValues(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));

        for (int i = 0; i < this.height; i++) {
            String[] line = sc.nextLine().split("\\s+");

            for (int j = 0; j < this.width; j++) {
                this.values[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    public void turnClockwise() {
        int[][] newValues = new int[this.width][this.height];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                newValues[i][j] = this.values[j][this.height - i - 1];
            }
        }
        this.values = newValues;
        this.width = this.height;
        this.height = newValues.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                sb.append(this.values[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
