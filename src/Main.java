package src;

public class Main {
    public static void main(String[] args) {
        DenseMatrix d1 = new DenseMatrix("D1.txt");
        DenseMatrix d2 = new DenseMatrix("D2.txt");
        //d1.multDD(D2);
        SparseMatrix s1 = new SparseMatrix("S1.txt");
        d1.multDS(s1);
        System.out.println(d1.CountRow("D1.txt"));
        System.out.println(s1.CountCol("S1.txt"));
    }
}
