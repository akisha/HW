package src;

public class Main {
    public static void main(String[] args) {
        SparseMatrix mS1 = new SparseMatrix("S1.txt");
        SparseMatrix mS2 = new SparseMatrix("S2.txt");
        mS1.multSpSp(mS2);
        String t = mS1.Test();
        System.out.println(t);
    }
}
