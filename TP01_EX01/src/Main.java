import java.util.*;

public class Main {

    static Scanner in = new Scanner(System.in);
    static List<ChaveUtilizador> boletim;

    static int idChaveUtilTemp;
    static List<ChaveSorteada> resultados;

    static int idChaveSortTemp;

    static Random rnd = new Random();

    static int numSortTemp[] = new int[5];
    static int estSortTemp[] = new int[2];

    static int numUtilTemp[] = new int[5];

    static int estUtilTemp[] = new int[2];

    static boolean continuarSorteio = true;



    public static void main(String[] args) {

        boletim = new ArrayList<>();
        resultados = new ArrayList<>();
        idChaveUtilTemp = 1;
        idChaveSortTemp = 1;

        int op = 1;
        while (op != 0) {
            System.out.println("1-Simular um sorteio");
            System.out.println("2-Escolher boletim");
            System.out.println("3-Sortear boletim");
            System.out.println("4-!!!Simulação!!!CUIDADO!!!");
            System.out.println("5-Ver sorteios");
            System.out.println("0-Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    SimularChave();
                    break;
                case 2:
                    EscolherBoletim();
                    break;
                case 3:
                    SortearBoletim();
                    break;
                case 4:
                    Simular();
                    break;
                case 5:
                    VerSorteio();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        }

    }

    private static void VerSorteio() {
        if (resultados.size() > 0) {
            System.out.println("==================Sorteios==================");
            for (int i = 0; i < resultados.size(); i++) {
                System.out.println(resultados.get(i).toString());
            }
            System.out.println("\n============================================");
        } else {
            System.out.println("==================Sorteios==================");
            System.out.println("Não existem sorteios");
            System.out.println("\n============================================");
        }
    }

    private static void Simular() {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();


        //Boletim vazio
        boletim =new ArrayList<>();
        //System.out.println(boletim.toString());       //Testar Array vazio

        //Registar chave

        //registar os números de cada aposta
        for (int i = 0; i < 5; i++) {
            System.out.println("Qual o " + (i + 1) + "º numero (Ente 1 e 50)");
            numUtilTemp[i] = in.nextInt();
            if (numUtilTemp[i] > 0 && numUtilTemp[i] <= 50) {
                for (int j = 0; j < i; j++) {
                    //System.out.println(numUtilTemp[i] + " " +numUtilTemp[j]);     //comfirmar numero anterior
                    if (numUtilTemp[i] == numUtilTemp[j]) {
                        System.out.println("Número já exixtente");
                        i--;
                    }
                }
            } else {
                System.out.println("Por favor selecione um número ente 1 e 50");
                i--;
            }
        }

        //registar as estrelas de cada aposta
        for (int i = 0; i < 2; i++) {
            System.out.println("Qual a " + (i + 1) + "ª estrela (Ente 1 e 12)");
            estUtilTemp[i] = in.nextInt();
            if (estUtilTemp[i] > 0 && estUtilTemp[i] <= 12) {
                for (int j = 0; j < i; j++) {
                    //System.out.println(estUtilTemp[i] + " " + estUtilTemp[j]);    //comfirmar numero anterior
                    if (estUtilTemp[i] == estUtilTemp[j]) {
                        System.out.println("Número já exixtente");
                        i--;
                    }
                }
            } else {
                System.out.println("Por favor selecione uma estrela ente 1 e 12");
                i--;
            }
        }
        //adicionar ao boletim cada uma das apostas
        Arrays.sort(numUtilTemp);
        Arrays.sort(estUtilTemp);
        boletim.add(new ChaveUtilizador(idChaveUtilTemp, numUtilTemp[0], numUtilTemp[1], numUtilTemp[2], numUtilTemp[3], numUtilTemp[4], estUtilTemp[0], estUtilTemp[1]));
        idChaveUtilTemp++;

        //VAMOS VER QUANTO TEMPO DEMORA ATÉ FICAR RICO!!!!


        do {
            SimularChave();
            VerPremios();
        }

        while (continuarSorteio == true);

    }

    private static void SortearBoletim() {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        //Boletim vazio
        boletim =new ArrayList<>();
        //System.out.println(boletim.toString());       //Testar Array vazio

        //SimularChave();     //Testar Resultados

        System.out.println("Quantas apostas que fazer? (Max. 5 chaves)");
        int quantChaves = in.nextInt();

        //Verificar se o numero de apostas está entre 1 e 5
        while (quantChaves <= 0 || quantChaves > 5) {
            System.out.println("Quantas apostas que fazer? (Max. 5 chaves)");
            quantChaves = in.nextInt();
        }
        //Verificar se o numero de apostas está entre 1 e 5
        if (quantChaves > 0 && quantChaves <= 5) {
            for (int k = 0; k < quantChaves; k++) {
                //System.out.println("Qual a combinação da sua " + (k + 1) + " ª chave?");
                //registar os números de cada aposta
                for (int i = 0; i < 5; i++) {
                    //System.out.println("Qual o " + (i + 1) + "º numero (Ente 1 e 50)");
                    numUtilTemp[i] = rnd.nextInt(1,51);
                    //System.out.println(numUtilTemp[i]);                                     //Ver numero
                    if (numUtilTemp[i] > 0 && numUtilTemp[i] <= 50) {
                        for (int j = 0; j < i; j++) {
                            //System.out.println(numUtilTemp[i] + " " +numUtilTemp[j]);     //comfirmar numero anterior
                            if (numUtilTemp[i] == numUtilTemp[j]) {
                                //System.out.println("Número já exixtente");
                                i--;
                            }
                        }
                    } else {
                        //System.out.println("Por favor selecione um número ente 1 e 50");
                        i--;
                    }
                }

                //registar as estrelas de cada aposta
                for (int i = 0; i < 2; i++) {
                    //System.out.println("Qual a " + (i + 1) + "ª estrela (Ente 1 e 12)");
                    estUtilTemp[i] = rnd.nextInt(1,13);
                    //System.out.println(estUtilTemp[i]);                                     //Ver estrela
                    if (estUtilTemp[i] > 0 && estUtilTemp[i] <= 12) {
                        for (int j = 0; j < i; j++) {
                            //System.out.println(estUtilTemp[i] + " " + estUtilTemp[j]);    //comfirmar numero anterior
                            if (estUtilTemp[i] == estUtilTemp[j]) {
                                //System.out.println("Número já exixtente");
                                i--;
                            }
                        }
                    } else {
                        //System.out.println("Por favor selecione uma estrela ente 1 e 12");
                        i--;
                    }
                }
                //adicionar ao boletim cada uma das apostas
                Arrays.sort(numUtilTemp);
                Arrays.sort(estUtilTemp);
                boletim.add(new ChaveUtilizador(idChaveUtilTemp, numUtilTemp[0], numUtilTemp[1], numUtilTemp[2], numUtilTemp[3], numUtilTemp[4], estUtilTemp[0], estUtilTemp[1]));
                idChaveUtilTemp++;
            }

            //retornar ao menu em caso de algum erro
        } else {
            return;
        }

        SimularChave();
        VerPremios();

    }

    private static void EscolherBoletim() {
        Scanner in = new Scanner(System.in);

        //Boletim vazio
        boletim =new ArrayList<>();
        //System.out.println(boletim.toString());       //Testar Array vazio

        //SimularChave();     //Testar Resultados

        System.out.println("Quantas apostas que fazer? (Max. 5 chaves)");
        int quantChaves = in.nextInt();

        //Verificar se o numero de apostas está entre 1 e 5
        while (quantChaves <= 0 || quantChaves > 5) {
            System.out.println("Quantas apostas que fazer? (Max. 5 chaves)");
            quantChaves = in.nextInt();
        }
        //Verificar se o numero de apostas está entre 1 e 5
        if (quantChaves > 0 && quantChaves <= 5) {
            for (int k = 0; k < quantChaves; k++) {
                System.out.println("Qual a combinação da sua " + (k + 1) + " ª chave?");
                //registar os números de cada aposta
                for (int i = 0; i < 5; i++) {
                    System.out.println("Qual o " + (i + 1) + "º numero (Ente 1 e 50)");
                    numUtilTemp[i] = in.nextInt();
                    if (numUtilTemp[i] > 0 && numUtilTemp[i] <= 50) {
                        for (int j = 0; j < i; j++) {
                            //System.out.println(numUtilTemp[i] + " " +numUtilTemp[j]);     //comfirmar numero anterior
                            if (numUtilTemp[i] == numUtilTemp[j]) {
                                System.out.println("Número já exixtente");
                                i--;
                            }
                        }
                    } else {
                        System.out.println("Por favor selecione um número ente 1 e 50");
                        i--;
                    }
                }

                //registar as estrelas de cada aposta
                for (int i = 0; i < 2; i++) {
                    System.out.println("Qual a " + (i + 1) + "ª estrela (Ente 1 e 12)");
                    estUtilTemp[i] = in.nextInt();
                    if (estUtilTemp[i] > 0 && estUtilTemp[i] <= 12) {
                        for (int j = 0; j < i; j++) {
                            //System.out.println(estUtilTemp[i] + " " + estUtilTemp[j]);    //comfirmar numero anterior
                            if (estUtilTemp[i] == estUtilTemp[j]) {
                                System.out.println("Número já exixtente");
                                i--;
                            }
                        }
                    } else {
                        System.out.println("Por favor selecione uma estrela ente 1 e 12");
                        i--;
                    }
                }
                //adicionar ao boletim cada uma das apostas
                Arrays.sort(numUtilTemp);
                Arrays.sort(estUtilTemp);
                boletim.add(new ChaveUtilizador(idChaveUtilTemp, numUtilTemp[0], numUtilTemp[1], numUtilTemp[2], numUtilTemp[3], numUtilTemp[4], estUtilTemp[0], estUtilTemp[1]));
                idChaveUtilTemp++;
            }

            //retornar ao menu em caso de algum erro
        } else {
            return;
        }

        SimularChave();
        VerPremios();


    }

    private static void VerPremios() {
        int nCertos;
        nCertos = 0;
        int eCertos;
        eCertos = 0;

        System.out.println("==================Prémios==================");

            for (int i = 0; i < boletim.size(); i++) {
                //System.out.println(boletim.get(i).toString());
                if (    boletim.get(i).getN1() == resultados.get(resultados.size() - 1).getCs_n1() ||
                        boletim.get(i).getN1() == resultados.get(resultados.size() - 1).getCs_n2() ||
                        boletim.get(i).getN1() == resultados.get(resultados.size() - 1).getCs_n3() ||
                        boletim.get(i).getN1() == resultados.get(resultados.size() - 1).getCs_n4() ||
                        boletim.get(i).getN1() == resultados.get(resultados.size() - 1).getCs_n5() ) {
                    nCertos++;
                } if (  boletim.get(i).getN2() == resultados.get(resultados.size() - 1).getCs_n1() ||
                        boletim.get(i).getN2() == resultados.get(resultados.size() - 1).getCs_n2() ||
                        boletim.get(i).getN2() == resultados.get(resultados.size() - 1).getCs_n3() ||
                        boletim.get(i).getN2() == resultados.get(resultados.size() - 1).getCs_n4() ||
                        boletim.get(i).getN2() == resultados.get(resultados.size() - 1).getCs_n5() ) {
                    nCertos++;
                } if (  boletim.get(i).getN3() == resultados.get(resultados.size() - 1).getCs_n1() ||
                        boletim.get(i).getN3() == resultados.get(resultados.size() - 1).getCs_n2() ||
                        boletim.get(i).getN3() == resultados.get(resultados.size() - 1).getCs_n3() ||
                        boletim.get(i).getN3() == resultados.get(resultados.size() - 1).getCs_n4() ||
                        boletim.get(i).getN3() == resultados.get(resultados.size() - 1).getCs_n5() ) {
                    nCertos++;
                } if (  boletim.get(i).getN4() == resultados.get(resultados.size() - 1).getCs_n1() ||
                        boletim.get(i).getN4() == resultados.get(resultados.size() - 1).getCs_n2() ||
                        boletim.get(i).getN4() == resultados.get(resultados.size() - 1).getCs_n3() ||
                        boletim.get(i).getN4() == resultados.get(resultados.size() - 1).getCs_n4() ||
                        boletim.get(i).getN4() == resultados.get(resultados.size() - 1).getCs_n5() ) {
                    nCertos++;
                } if (  boletim.get(i).getN5() == resultados.get(resultados.size() - 1).getCs_n1() ||
                        boletim.get(i).getN5() == resultados.get(resultados.size() - 1).getCs_n2() ||
                        boletim.get(i).getN5() == resultados.get(resultados.size() - 1).getCs_n3() ||
                        boletim.get(i).getN5() == resultados.get(resultados.size() - 1).getCs_n4() ||
                        boletim.get(i).getN5() == resultados.get(resultados.size() - 1).getCs_n5() ) {
                    nCertos++;
                } if (  boletim.get(i).getE1() == resultados.get(resultados.size() - 1).getCs_e1() ||
                        boletim.get(i).getE1() == resultados.get(resultados.size() - 1).getCs_e2() ) {
                    eCertos++;
                } if (  boletim.get(i).getE2() == resultados.get(resultados.size() - 1).getCs_e1() ||
                        boletim.get(i).getE2() == resultados.get(resultados.size() - 1).getCs_e2() ) {
                    eCertos++;
                }
                if (nCertos == 5 && eCertos == 2){
                    continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 1.º Prémio\n");
                } if (nCertos == 5 && eCertos == 1){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 2.º Prémio\n");
                } if (nCertos == 5 && eCertos == 0){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 3.º Prémio\n");
                } if (nCertos == 4 && eCertos == 2){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 4.º Prémio\n");
                } if (nCertos == 4 && eCertos == 1){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 5.º Prémio\n");
                } if (nCertos == 3 && eCertos == 2){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 6.º Prémio\n");
                } if (nCertos == 4 && eCertos == 0){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 7.º Prémio\n");
                } if (nCertos == 2 && eCertos == 2){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 8.º Prémio\n");
                } if (nCertos == 3 && eCertos == 1){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 9.º Prémio\n");
                } if (nCertos == 3 && eCertos == 0){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 10.º Prémio\n");
                } if (nCertos == 1 && eCertos == 2){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 11.º Prémio\n");
                } if (nCertos == 2 && eCertos == 1){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 12.º Prémio\n");
                } if (nCertos == 2 && eCertos == 0){
                    //continuarSorteio = false;                                     //TESTAR SIMULAÇÃO QUANTIDADE DE VEZES
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("!!!PARABENS!!!\n Ganhou o 13.º Prémio\n");
                } if (nCertos == 1 && eCertos == 0){
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("Chave sem prémio \n");
                } if (nCertos == 1 && eCertos == 1){
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("Chave sem prémio \n");
                } if (nCertos == 0 && eCertos == 0){
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("Chave sem prémio \n");
                } if (nCertos == 0 && eCertos == 1){
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("Chave sem prémio \n");
                } if (nCertos == 0 && eCertos == 2){
                    System.out.println(boletim.get(i).toString() + "\n");
                    System.out.println("Chave sem prémio \n");
                } else {
                    System.out.println("============================================");
                }
                nCertos = 0;
                eCertos = 0;
            }

    }


    private static void SimularChave() {
        in = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            numSortTemp[i]= rnd.nextInt(1,51);
            for (int j = 0; j < i; j++)
                if (numSortTemp[i]==numSortTemp[j]){
                    i--;
                    break;
                }
        }

        for (int i = 0; i < 2; i++) {
            estSortTemp[i]= rnd.nextInt(1,13);
            for (int j = 0; j < i; j++)
                if (estSortTemp[i]==estSortTemp[j]){
                    i--;
                    break;
                }
            }

        System.out.println("==========Sorteio nº " + idChaveSortTemp+ "==========");
        Arrays.sort(numSortTemp);
        for (int i = 0; i < numSortTemp.length; i++) {
            System.out.print(numSortTemp[i]+" ");
        }
        System.out.println("\t");
        Arrays.sort(estSortTemp);
        for (int i = 0; i < estSortTemp.length; i++) {
            System.out.print(estSortTemp[i]+" ");
        }
        System.out.println("\n================================");

        resultados.add(new ChaveSorteada(idChaveSortTemp,numSortTemp[0],numSortTemp[1],numSortTemp[2],numSortTemp[3],numSortTemp[4],estSortTemp[0],estSortTemp[1]));
        idChaveSortTemp++;
    }
}