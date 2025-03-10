import java.util.Scanner;
public class Array {
public static void main(String[] args) {
// Declaração e criação da matriz (array) 3x2 (3 linhas e 2 colunas)
int[][] matriz = new int[3][2];
// Scanner para leitura dos valores
Scanner scanner = new Scanner(System.in);
// Inclusão de valores na matriz
for (int i = 0; i < matriz.length; i++) {
for (int j = 0; j < matriz.length; j++) {
System.out.print("Digite o valor para o elemento [" + i + "][" + j + "]: ");
matriz [i][j] = scanner.nextInt();
}
}
// Listagem dos valores da matriz
System.out.println("\nValores da matriz 2x3:");
for (int i = 0; i < matriz.length; i++) {
for (int j = 0; j < matriz[i].length; j++) {
System.out.println("Elemento [" + i + "][" + j + "]: " + matriz[i][j]);
}
}
// Fechar o Scanner
scanner.close();
}
}