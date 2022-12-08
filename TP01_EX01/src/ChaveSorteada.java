public class ChaveSorteada {
    // ATRIBUTOS
    private int id;
    private int cs_n1;
    private int cs_n2;
    private int cs_n3;
    private int cs_n4;
    private int cs_n5;
    private int cs_e1;
    private int cs_e2;

    // ENCAPSULAMENTO

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCs_n1() {
        return cs_n1;
    }

    public void setCs_n1(int cs_n1) {
        this.cs_n1 = cs_n1;
    }

    public int getCs_n2() {
        return cs_n2;
    }

    public void setCs_n2(int cs_n2) {
        this.cs_n2 = cs_n2;
    }

    public int getCs_n3() {
        return cs_n3;
    }

    public void setCs_n3(int cs_n3) {
        this.cs_n3 = cs_n3;
    }

    public int getCs_n4() {
        return cs_n4;
    }

    public void setCs_n4(int cs_n4) {
        this.cs_n4 = cs_n4;
    }

    public int getCs_n5() {
        return cs_n5;
    }

    public void setCs_n5(int cs_n5) {
        this.cs_n5 = cs_n5;
    }

    public int getCs_e1() {
        return cs_e1;
    }

    public void setCs_e1(int cs_e1) {
        this.cs_e1 = cs_e1;
    }

    public int getCs_e2() {
        return cs_e2;
    }

    public void setCs_e2(int cs_e2) {
        this.cs_e2 = cs_e2;
    }


    // CONSTRUTORES

    public ChaveSorteada() {
        id = 0;
        cs_n1 = 0;
        cs_n2 = 0;
        cs_n3 = 0;
        cs_n4 = 0;
        cs_n5 = 0;
        cs_e1 = 0;
        cs_e2 = 0;
    }

    public ChaveSorteada(int id, int cs_n1, int cs_n2, int cs_n3, int cs_n4, int cs_n5, int cs_e1, int cs_e2) {
        this.id = id;
        this.cs_n1 = cs_n1;
        this.cs_n2 = cs_n2;
        this.cs_n3 = cs_n3;
        this.cs_n4 = cs_n4;
        this.cs_n5 = cs_n5;
        this.cs_e1 = cs_e1;
        this.cs_e2 = cs_e2;
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
        return "Sorteio Nº " + id + " ->> " + cs_n1 + "\t" + cs_n2 + "\t" + cs_n3 + "\t" + cs_n4 + "\t" + cs_n5 + "\t - \t" + cs_e1 + "\t" + cs_e2;
    }
}
