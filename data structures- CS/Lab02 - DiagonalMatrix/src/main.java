import java.io.IOException;

public class main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Matrix m = new DiagonalMatrix(3);
        m.set(0, 0, 5);
        m.set(0, 1, 4);
        m.set(0, 2, 3);
        m.set(1, 0, 2);
        m.set(2, 0, 1);
        System.out.println(m);
        Matrix s = m.getTranspose();
        System.out.println(s);
    }

}
