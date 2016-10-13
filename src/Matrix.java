package src;

import java.io.*;
import java.util.Scanner;

public abstract class Matrix {

    public int CountRow(String fileName) {
        int m = 0;
        try {
            FileReader fs = new FileReader(fileName);
            BufferedReader bfs = new BufferedReader(fs);
            while (bfs.readLine() != null) {
                m++;
            }
            fs.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }

    public int CountCol(String fileName) {
        int n = 0;
        FileReader fs = null;
        try {
            fs = new FileReader(fileName);
        BufferedReader bfs = new BufferedReader(fs);
        try {
            Scanner sc = new Scanner(bfs.readLine());
            while (sc.hasNextDouble()){
                n++;
                sc.nextDouble();
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return n;
    }

    public double[][] setMatrix(int n, int m, String fileName){
        double[][] matrix = new double[m][n];
        Scanner in = null;
        try {
            in = new Scanner(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextDouble();
            }
        }
        return matrix;
    }

    public void printMatrix(int n, int m, double[][] matrix, String fileName){
        File newFile = new File(fileName);
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(matrix[i][j] + "  ");
                if (j == m - 1) out.println();
            }
        }
    }
 }
