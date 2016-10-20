package src;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrix extends Matrix {

    public String inF;

    public int nRow;

    public int nCol;

    double[][] matrix;

    public SparseMatrix(String in) {
        inF = in;
        int nRow = CountRow(inF);
        int nCol = CountCol(inF);
        double[][] matrix = setMatrix(nRow, nCol, inF);
    }

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
       //printMatrix(nRow, other.nCol, result, "mul" + inF.substring(0, inF.length() - 4) + other.inF);
        printMatrixCons(nRow, other.nCol, result);
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
        //printMatrix(nRow, other.nCol, result, "mulSD" + inF.substring(0, inF.length() - 4) + other.inF);
        printMatrixCons(nRow, other.nCol, result);
    }
}