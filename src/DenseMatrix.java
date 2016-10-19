package src;

import src.Matrix;

import java.util.HashMap;
import java.util.Map;

public class DenseMatrix extends Matrix {

    String inF;

    DenseMatrix(String inF){
        this.inF = inF;
    }

    public int nRow = 2; //CountRow(inF);

    public int nCol = CountCol(inF);

    public double[][] matrix = setMatrix(nRow, nCol, inF);

    public void multDS(SparseMatrix other) {
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
        printMatrix(nRow, other.nCol, result, "mul" + inF.substring(0, inF.length() - 4) + other.inF);
    }

    public void multDD(DenseMatrix other) {
        if (nCol != other.nRow) throw new IllegalArgumentException("Dimensions disagree");
        double[][] result = new double[nRow][other.nCol];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                for (int k = 0; k < nCol; k++) {
                    result[i][j] += matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        printMatrix(nRow, other.nCol, result, "mulSD" + inF.substring(0, inF.length() - 4) + other.inF);
    }
}