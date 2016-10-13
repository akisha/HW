package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SparseMatrix extends Matrix {

    String inF;

    String outF;

    public SparseMatrix(String inF, String outF){
        this.inF = inF;
        this.outF = outF;
    }

    public int nRow = CountRow(inF);

    public int nCol = CountCol(inF);

    public double[][] matrix = setMatrix(nRow, nCol, inF);

    public void multSpSp(SparseMatrix other) {
        if (nCol != other.nRow) throw new IllegalArgumentException("Dimensions disagree");
        double[][] result = new double[nRow][other.nCol];
        Map<Integer, HashMap<Integer, Double>> tOther = new HashMap<>();
        for(int k = 0; k < nCol; k++) {
            tOther.put(k, new HashMap<Integer, Double>());
            for(int j = 0; j < other.nCol; j++) {
                if (other.matrix[k][j] != 0){
                    tOther.get(k).put(j, other.matrix[k][j]);
                }
            }
        }
        for(int i = 0; i < nRow; i++) {
            for(int k = 0; k < nCol; k++) {
                if (matrix[i][k] != 0){
                    for (Integer j: tOther.get(k).keySet()) {
                        result[i][j] += matrix[i][k] * tOther.get(k).get(j);
                    }
                }
            }
        }
        printMatrix(nRow, other.nCol, result, "mul" + outF + other.outF);
    }

    public void multSD(DenseMatrix other) {
        if (nCol != other.nRow) throw new IllegalArgumentException("Dimensions disagree");
        double[][] result = new double[nRow][other.nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                for (int k = 0; k < nCol; k++) {
                    result[i][j] += matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        printMatrix(nRow, other.nCol, result, "mulSD" + outF + other.outF);
    }
}