import dao.FornecedorDAO;
import dao.ProdutoDAO;
import model.Fornecedor;
import model.Produto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            
            while (true) {
                System.out.println("==== MENU ====");
                System.out.println("1 - Cadastrar Fornecedor");
                System.out.println("2 - Cadastrar Produto");
                System.out.println("0 - Sair");
                int opcao = Integer.parseInt(scanner.nextLine());
                
                if (opcao == 0) break;
                
                switch (opcao) {
                    case 1:
                        System.out.print("Nome do Fornecedor: ");
                        String nomeForn = scanner.nextLine();
                        Fornecedor fornecedor = new Fornecedor();
                        fornecedor.setNome(nomeForn);
                        fornecedorDAO.salvar(fornecedor);
                        break;
                        
                    case 2:
                        List<Fornecedor> fornecedores = fornecedorDAO.listarTodos();
                        if (fornecedores.isEmpty()) {
                            System.out.println("Nenhum fornecedor cadastrado.");
                            break;
                        }
                        
                        System.out.print("Nome do Produto: ");
                        String nomeProd = scanner.nextLine();
                        
                        System.out.println("Escolha o Fornecedor:");
                        for (int i = 0; i < fornecedores.size(); i++) {
                            System.out.println(i + " - " + fornecedores.get(i).getNome());
                        }
                        int escolha = Integer.parseInt(scanner.nextLine());
                        
                        Produto produto = new Produto();
                        produto.setNome(nomeProd);
                        produto.setFornecedor(fornecedores.get(escolha));
                        produtoDAO.salvar(produto);
                        break;
                        
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }
}
