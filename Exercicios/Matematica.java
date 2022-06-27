import java.util.Scanner;

public class Matematica {
    public static void main(String[] args) {
        Scanner scanNum = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        Double x, y, z;
        String resposta;
        int opcao = 0;

        do {

            System.out.println("##==================##\n##Cálculo Matemático##\n##==================##\n");
            System.out.println("Informe o valor de X: ");
            x = scanner.nextDouble();
            System.out.println("Informe o valor de Y: ");
            y = scanNum.nextDouble();

            z = (x * y) + 5;
            if (z <= 0) {
                resposta = "A de Amor";
            } else if (z <= 100) {
                resposta = "B de Baixinho";
            } else {
                resposta = "C de coração";
            }

            System.out.println("Cáulco efetuado com Z: " + z);
            System.out.println("O resultado é: " + resposta);

            System.out.println("Quer calcular de novo? 1 - Sim, 2 Não.");
            opcao = scanNum.nextInt();
            while (opcao != 1 && opcao != 2) {
                System.out.println("Não entendi. Tente novamente!");
            }
        } while(opcao == 1);


        scanner.close();
        scanNum.close();
    }
}
