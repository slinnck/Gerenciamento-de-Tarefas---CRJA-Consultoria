import java.util.Scanner;

public class ArraysOrdenados {

    public static void main(String[] args) {

        Scanner scanNum = new Scanner(System.in);

        int sizeV1;
        int sizeV2;
        System.out.println("Qual o tamanho do seu primeiro vetor: ");
        sizeV1 = scanNum.nextInt();
        System.out.println("Qual o tamanho do seu segundo vetor: ");
        sizeV2 = scanNum.nextInt();

        int vetor[] = new int[sizeV1];
        int vetor2[] = new int[sizeV2];
        int uniaoDosVetores[] = new int[sizeV1 + sizeV2];
        for (int m = 0; m < vetor.length; m++) {
            System.out.println("Digite o " + (m+1) + "º número a que você quer colocar no seu primeiro vetor: ");
            vetor[m] = scanNum.nextInt();
        }

        for (int m=0; m<vetor2.length; m++) {
            System.out.println("Digite o " + (m+1) + "º número a que você quer colocar no seu segundo vetor: ");
            vetor2[m] = scanNum.nextInt();
        }

        for (int m=0; m<vetor.length; m++) {
            uniaoDosVetores[m] = vetor[m];
        }

        for (int m = vetor.length, o = 0; m < uniaoDosVetores.length; m++, o++) {
            uniaoDosVetores[m] = vetor2[o];
        }

        for (int m = 0; m < uniaoDosVetores.length; m++) {
            for (int o = 0; o < uniaoDosVetores.length - 1; o++) {
                if (uniaoDosVetores[m] < uniaoDosVetores[o]) {
                    int x = uniaoDosVetores[m];
                    uniaoDosVetores[m] = uniaoDosVetores[o];
                    uniaoDosVetores[o] = x;
                }
            }
        }

        for (int m = 0; m < uniaoDosVetores.length; m++) {
            System.out.println("[" + uniaoDosVetores[m] + "]");
        }
    }
}
