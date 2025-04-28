import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Vendedor
class Vendedor {
    private String nome;
    private String matricula;

    public Vendedor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }
}

// Classe Cliente
class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Cliente(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}

// Classe ItemPedido
class ItemPedido {
    private int codigoItem;
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(int codigoItem, String descricao, int quantidade, double precoUnitario) {
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double calcularValorItem() {
        return quantidade * precoUnitario;
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}

// Classe Pedido
class Pedido {
    private int idPedido;
    private LocalDateTime dataHora;
    private String status;
    private double valorTotal;
    private Vendedor vendedor;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido(int idPedido, Vendedor vendedor, Cliente cliente) {
        this.idPedido = idPedido;
        this.dataHora = LocalDateTime.now();
        this.status = "Em processamento";
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void calcularValorTotal() {
        valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.calcularValorItem();
        }
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        calcularValorTotal();
    }

    public void removerItem(int codigoItem) {
        itens.removeIf(item -> item.getCodigoItem() == codigoItem);
        calcularValorTotal();
    }

    public void aplicarDesconto(double percentual) {
        valorTotal -= valorTotal * (percentual / 100);
    }

    public void exibirPedido() {
        System.out.println("ID do Pedido: " + idPedido);
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("Status: " + status);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Vendedor: " + vendedor.getNome());
        System.out.println("Itens:");
        for (ItemPedido item : itens) {
            System.out.println(" - " + item.getDescricao() + " | Quantidade: " + item.getQuantidade() + " | Unitário: R$ " + item.getPrecoUnitario());
        }
        System.out.println("Valor Total: R$ " + valorTotal);
    }
}

// Classe principal (Main)
public class SwexatoSistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criar vendedor
        Vendedor vendedor = new Vendedor("João Silva", "A123");

        // Criar cliente
        Cliente cliente = new Cliente("Maria Souza", "123.456.789-00", "Rua X, 123", "(11) 99999-0000");

        // Criar pedido
        Pedido pedido = new Pedido(1, vendedor, cliente);

        // Adicionar itens
        pedido.adicionarItem(new ItemPedido(1, "Notebook Lenovo", 1, 3500.00));
        pedido.adicionarItem(new ItemPedido(2, "Mouse Logitech", 2, 150.00));

        // Exibir pedido antes do desconto
        System.out.println("----- Pedido antes do desconto -----");
        pedido.exibirPedido();

        // Aplicar desconto
        pedido.aplicarDesconto(10); // 10%

        // Exibir pedido após o desconto
        System.out.println("\n----- Pedido após 10% de desconto -----");
        pedido.exibirPedido();

        // Atualizar status
        pedido.atualizarStatus("Enviado");

        // Exibir pedido final
        System.out.println("\n----- Pedido atualizado -----");
        pedido.exibirPedido();

        sc.close();
    }
}
