package src;

public class Main {
    public static void main(String[] args) {
        SparseMatrix mS1 = new SparseMatrix("In.txt", "OutS1.txt");
        SparseMatrix mS2 = new SparseMatrix("InS2.txt", "OutS2.txt");
        mS1.multSpSp(mS2);
    }
}
