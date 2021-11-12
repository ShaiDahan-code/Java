import java.util.ArrayList;
import java.util.List;

public class DiagonalMatrix implements Matrix{

    Double[] ls;
    int size;

    public DiagonalMatrix(int size){
        ls =  new Double[2*size-1];
        for(int i=0; i < ls.length; i++){
            ls[i] = 0.0;
        }
        this.size = size;
    }


    public DiagonalMatrix( ){
        this(MAX_SIZE);
        this.size = MAX_SIZE;
    }


    @Override
    public double get(int i, int j)  {
        int mid;
        if(i > ls.length/2+1 || j > ls.length/2 + 1){
            throw new IllegalArgumentException("Error");
        }
        mid = (int)(ls.length/2);

        if(i == j){
            return ls[mid];
        }
        else if(j > i){
            return ls[mid+(j-i)];

        }
        return ls[mid - (i - j)];

    }

    @Override
    public void set(int i, int j, double x) {
        int mid;
        if(i > (int)ls.length|| j > (int)ls.length){
            System.out.println("as:" +(int)ls.length/2+1);
            System.out.println("as:" +(int)ls.length);
            throw new IllegalArgumentException("Error");
        }
        mid = (int)ls.length/2;

        if(i == j){
            ls[mid] = x;
        }
        else if(j > i){
            ls[mid-(j-i)]= x;

        }
        ls[mid+(i - j)] =  x;
    }

    @Override
    public void transpose() {
        Double[] ls_new = new Double[ls.length];
        for(int i = ls.length-1; i > 0;i--){
            ls_new[ls.length-1-i] = ls[i];
        }
        ls = ls_new;

    }

    @Override
    public Matrix getTranspose() {
        Matrix ls_new;

        ls_new = new DiagonalMatrix((int)(ls.length / 2));

        transpose();
        int mid;
        for(int i = 0; i < ls.length;i++){
            mid = (int)ls.length/2 + 1;
            System.out.println(i);
            ls_new.set(i,i,ls[i]);

        }
        transpose();
        return ls_new;
    }


    public String toString(){
        String ss = "";
        for(int i=0;i<(int)ls.length/2+1;i++){
            for(int j=0;j<(int)ls.length/2+1;j++){
                try {
                    ss += this.get(i,j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ss += '\t';
            }
            ss += '\n';
        }
        return ss;
    }
}
