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

    public void turn(RotationType rotation) {
        int newHeight = this.height;
        int newWidth = this.width;

        if (rotation != RotationType.REFLECTION) {
            newHeight = this.width;
            newWidth = this.height;
        }

        int[][] newValues = new int[newHeight][newWidth];

        if (rotation == RotationType.CLOCKWISE) {
            for (int i = 0; i < newHeight; i++) {
                for (int j = 0; j < newWidth; j++) {
                    newValues[i][j] = this.values[this.height-1-j][i];
                }
            }
        } else if (rotation == RotationType.COUNTERCLOCKWISE) {
            for (int i = 0; i < newHeight; i++) {
                for (int j = 0; j < newWidth; j++) {
                    newValues[i][j] = this.values[j][this.width-1-i];;
                }
            }
        } else {
            for (int i = 0; i < newHeight; i++) {
                newValues[i] = this.values[this.height-1-i];
            }
        }

        this.values = newValues;
        this.height = newHeight;
        this.width = newWidth;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                sb.append(this.values[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
