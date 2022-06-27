import java.util.*;

class Pessoa {
    List<Integer> idade = new ArrayList<>();
    String sexo;

    public String toString() {
        return "Resultado: ";
    }
}

public class Idade {
    public static void main(String[] args) {
        Scanner scanNum = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        int homeMaisVelho = 0, homemMaisNovo = 0, mulherMaisNova = 0, mulherMaisVelha = 0, somaHm, multiplicacaoMh;
        Pessoa pessoas = new Pessoa();

        do {
            Pessoa homem = new Pessoa();
            Pessoa mulher = new Pessoa();
            List<Pessoa> homemOuMulher = new ArrayList<>();
            do {
                System.out.println("Deseja registrar primeiro homem ou mulher?");
                homem.sexo = scanner.nextLine();
                while (!homem.sexo.equalsIgnoreCase("homem") && !homem.sexo.equalsIgnoreCase("mulher")) {
                    System.out.println("Sexo inexistente. Tente de novo!");
                    homem.sexo = scanner.nextLine();
                }
            } while (!homem.sexo.equalsIgnoreCase("homem") && !homem.sexo.equalsIgnoreCase("mulher"));

            if (homem.sexo.equalsIgnoreCase("homem")) {
                System.out.println("Informe a idade do 1º homem: ");
                homem.idade.add(scanNum.nextInt());
                System.out.println("Informe a idade do 2º homem: ");
                homem.idade.add(scanNum.nextInt());
                while(homem.idade.get(0) == homem.idade.get(1)) {
                    homem.idade.remove(1);
                    System.out.println("A segunda idade não pode ser igual a primeira. Tente de novo!");
                    homem.idade.add(scanNum.nextInt());
                }
                System.out.println("Informe a idade da 1ª mulher: ");
                mulher.idade.add(scanNum.nextInt());
                System.out.println("Informe a idade da 2ª mulher: ");
                mulher.idade.add(scanNum.nextInt());
                while(mulher.idade.get(0) == mulher.idade.get(1)) {
                    mulher.idade.remove(1);
                    System.out.println("A segunda idade não pode ser igual a primeira. Tente de novo!");
                    mulher.idade.add(scanNum.nextInt());
                }
            } else {
                System.out.println("Informe a idade da 1ª mulher: ");
                mulher.idade.add(scanNum.nextInt());
                System.out.println("Informe a idade da 2ª mulher: ");
                mulher.idade.add(scanNum.nextInt());
                while(mulher.idade.get(0) == mulher.idade.get(1)) {
                    mulher.idade.remove(1);
                    System.out.println("A segunda idade não pode ser igual a primeira. Tente de novo!");
                    mulher.idade.add(scanNum.nextInt());
                }
                System.out.println("Informe a idade do 1ª homem: ");
                homem.idade.add(scanNum.nextInt());
                System.out.println("Informe a idade do 2ª homem: ");
                homem.idade.add(scanNum.nextInt());
                while(homem.idade.get(0) == homem.idade.get(1)) {
                    homem.idade.remove(1);
                    System.out.println("A segunda idade não pode ser igual a primeira. Tente de novo!");
                    homem.idade.add(scanNum.nextInt());
                }
                homemOuMulher.add(mulher);
            }
            homemOuMulher.add(homem);
            homemOuMulher.add(mulher);

            homeMaisVelho = homem.idade.stream().max(Integer::compare).get();
            mulherMaisVelha = mulher.idade.stream().max(Integer::compare).get();
            homemMaisNovo = homem.idade.stream().min(Integer::compare).get();
            mulherMaisNova = mulher.idade.stream().min(Integer::compare).get();

            somaHm = homeMaisVelho + mulherMaisNova;
            multiplicacaoMh = mulherMaisVelha * homemMaisNovo;

            System.out.println("++Soma das idades do homem mais velho junto com a mulher mais nova: " + somaHm);
            System.out.println("**Multiplicação das idades da mulher mais velha junto com o homem mais novo:" + multiplicacaoMh);

            System.out.println("\nDeseja realizar uma nova consulta? 1 para continuar, 2 para finalizar.");
            opcao = scanNum.nextInt();
            while (opcao != 1 && opcao != 2) {
                System.out.println("Não entendi. Tente novamente!");
                opcao = scanNum.nextInt();
            }
        } while (opcao == 1);

        scanNum.close();
        scanner.close();
    }
}