import java.util.Scanner;

public class Pessoa {
    private String nome;
    private double peso;
    private double altura;

    public Pessoa(String nome, double peso, double altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String obterAnaliseIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            return "Baixo peso. É recomendado procurar um médico.";
        } else if (imc <= 24.9) {
            return "Peso adequado. Avalie também outros parâmetros.";
        } else if (imc <= 29.9) {
            return "Sobrepeso. Atenção com hábitos e saúde.";
        } else if (imc <= 34.9) {
            return "Obesidade grau I. Procure orientação médica.";
        } else if (imc <= 39.9) {
            return "Obesidade grau II. Situação mais grave, busque ajuda.";
        } else {
            return "Obesidade grau III. Risco alto de doenças associadas.";
        }
    }

    public void exibirResultado() {
        System.out.printf("Nome: %s%n", nome);
        System.out.printf("IMC: %.2f%n", calcularIMC());
        System.out.println("Análise: " + obterAnaliseIMC());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o peso (kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Digite a altura (m): ");
        double altura = scanner.nextDouble();

        Pessoa pessoa = new Pessoa(nome, peso, altura);
        pessoa.exibirResultado();

        scanner.close();
    }
}
