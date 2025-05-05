public class SistemaPessoas {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "123.456.789-00", "99999-9999", "joao@email.com", "Rua X, 123");
        Fornecedor fornecedor = new Fornecedor("Empresa Y", "12.345.678/0001-99", "3333-3333", "contato@empresaY.com", "Produtos Eletrônicos");
        Empregado empregado = new Empregado("Maria", "987.654.321-00", "88888-8888", "maria@email.com", "EMP123", "Analista");
        Vendedor vendedor = new Vendedor("Pedro", "111.222.333-44", "77777-7777", "pedro@email.com", "EMP456", "Vendedor", 5.5);
        Usuario usuario = new Usuario("Ana", "555.666.777-88", "66666-6666", "ana@email.com", "anauser", "senha123");

        cliente.exibirDados();
        System.out.println();
        fornecedor.exibirDados();
        System.out.println();
        empregado.exibirDados();
        System.out.println();
        vendedor.exibirDados();
        System.out.println();
        usuario.exibirDados();
    }
}

class Pessoa {
    private String nome;
    private String documento;
    private String telefone;
    private String email;

    public Pessoa(String nome, String documento, String telefone, String email) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Documento: " + documento);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }
}

class Cliente extends Pessoa {
    private String enderecoEntrega;

    public Cliente(String nome, String documento, String telefone, String email, String enderecoEntrega) {
        super(nome, documento, telefone, email);
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Endereço de Entrega: " + enderecoEntrega);
    }
}

class Fornecedor extends Pessoa {
    private String cnpj;
    private String produtoFornecido;

    public Fornecedor(String nome, String documento, String telefone, String email, String produtoFornecido) {
        super(nome, documento, telefone, email);
        this.cnpj = documento;
        this.produtoFornecido = produtoFornecido;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Produto Fornecido: " + produtoFornecido);
    }
}

class Empregado extends Pessoa {
    private String matricula;
    private String cargo;

    public Empregado(String nome, String documento, String telefone, String email, String matricula, String cargo) {
        super(nome, documento, telefone, email);
        this.matricula = matricula;
        this.cargo = cargo;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Matrícula: " + matricula);
        System.out.println("Cargo: " + cargo);
    }
}

class Vendedor extends Empregado {
    private double comissao;

    public Vendedor(String nome, String documento, String telefone, String email, String matricula, String cargo, double comissao) {
        super(nome, documento, telefone, email, matricula, cargo);
        this.comissao = comissao;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Comissão: " + comissao + "%");
    }
}

class Usuario extends Pessoa {
    private String login;
    private String senha;

    public Usuario(String nome, String documento, String telefone, String email, String login, String senha) {
        super(nome, documento, telefone, email);
        this.login = login;
        this.senha = senha;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Login: " + login);
        System.out.println("Senha: " + senha);
    }
}
