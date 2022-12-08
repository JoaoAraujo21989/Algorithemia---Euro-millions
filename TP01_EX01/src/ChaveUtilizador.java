public class ChaveUtilizador {
    // ATRIBUTOS
    private int id;
    private int n1;
    private int n2;
    private int n3;
    private int n4;
    private int n5;
    private int e1;
    private int e2;



    // CONSTRUTORES

    public ChaveUtilizador() {
        int id=0;
        int n1=0;
        int n2=0;
        int n3=0;
        int n4=0;
        int n5=0;
        int e1=0;
        int e2=0;
    }

    public ChaveUtilizador(int id, int n1, int n2, int n3, int n4, int n5, int e1, int e2) {
        this.setId(id);
        this.setN1(n1);
        this.setN2(n2);
        this.setN3(n3);
        this.setN4(n4);
        this.setN5(n5);
        this.setE1(e1);
        this.setE2(e2);
    }

    // ENCAPSULAMENTO

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN4() {
        return n4;
    }

    public void setN4(int n4) {
        this.n4 = n4;
    }

    public int getN5() {
        return n5;
    }

    public void setN5(int n5) {
        this.n5 = n5;
    }

    public int getE1() {
        return e1;
    }

    public void setE1(int e1) {
        this.e1 = e1;
    }

    public int getE2() {
        return e2;
    }

    public void setE2(int e2) {
        this.e2 = e2;
    }

    //OVERRIDE


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return n1 +" "+n2 +" "+n3 +" "+n4 +" "+n5 +" \t"+e1 +" "+e2;
    }
}
