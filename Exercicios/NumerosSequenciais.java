public class NumerosSequenciais {
    public static void main(String[] args) {
        System.out.println("##Lista de Números Sequenciais##");
        for (int i=1; i<= 10; i++) {
            if (i % 2 != 0) {
                System.out.println("[" + i + ", 1 2 3 4 5 6 7 8 9 10]");
            }
        }
    }
}