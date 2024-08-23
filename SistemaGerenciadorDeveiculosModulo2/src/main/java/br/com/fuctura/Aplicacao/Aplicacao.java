package br.com.fuctura.Aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import br.com.fuctura.dao.ClienteDAO;
import br.com.fuctura.dao.EnderecoDAO;
import br.com.fuctura.dao.LojaDAO;
import br.com.fuctura.dao.TipoDAO;
import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.dao.VendaDAO;
import br.com.fuctura.dao.VendedorDAO;
import br.com.fuctura.entidade.Cliente;
import br.com.fuctura.entidade.Loja;
import br.com.fuctura.entidade.Tipo;
import br.com.fuctura.entidade.Venda;
import br.com.fuctura.entidade.Vendedor;
import lombok.Data;

@Data
public class Aplicacao {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "220504";

		 try (Connection conexao = DriverManager.getConnection(url, username, password)) {
	            System.out.println("Conectado com sucesso no banco de dados veículo!");

	            VendedorDAO vendDAO = new VendedorDAO();
	            VendaDAO vendaDAO = new VendaDAO();

	            Scanner scanMenuVeiculo = new Scanner(System.in);
	            int menuVeiculo;

	            do {
	                System.out.println("Escolha as opções do menu:");
	                System.out.println("1- Inserir Vendedor");
	                System.out.println("2 - Editar Dados");
	                System.out.println("3 - Pesquisar nome do Vendedor");
	                System.out.println("4 - Deletar vendedor");
	                System.out.println("5 - Inserir venda");
	                System.out.println("6 - Inserir tipo");
	                System.out.println("7 - Pesquisar venda");
	                System.out.println("8 - Deletar venda");
	                System.out.println("9 - Cadastrar cliente");
	                System.out.println("10- Cadastrar loja");
	                System.out.println("11- Pesquisar loja");
	                System.out.println("12- Pesquisar cliente");
	                System.out.println("13- Sair do sistema");
	                System.out.println("-----------------------------------------");

	                menuVeiculo = scanMenuVeiculo.nextInt();
	                scanMenuVeiculo.nextLine();

	                System.out.println("\nA opção escolhida foi: " + menuVeiculo);

	                switch (menuVeiculo) {
	                    case 1: // Inserir dados do vendedor
	                    		// você pode inserir qualquer
	                    		//vendedor que quiser
	                        System.out.println("-----------------------------------------");
	                        System.out.println("Inserir Vendedor");
	                        System.out.println("Insira o nome do vendedor:");
	                        String nome = scanMenuVeiculo.nextLine();

	                        System.out.println("Digite o CPF do vendedor:");
	                        String cpf = scanMenuVeiculo.nextLine();

	                        System.out.println("Digite o telefone do vendedor:");
	                        String telefone = scanMenuVeiculo.nextLine();

	                        Vendedor vend = new Vendedor();
	                        vend.setNome(nome);
	                        vend.setTelefone(telefone);
	                        vend.setCpf(cpf);
	                        vendDAO.inserirVendedorDAO(conexao, vend);

	                        System.out.println("Vendedor inserido com sucesso!");
	                        System.out.println("------------------------------");
	                        break;

	                    case 2: // Editar dados, escolha a opção na qual você quer editar
	                    	//dos dados que você inseriu e por acaso queira editar,
	                        System.out.println("------------------------------");
	                        System.out.println("Digite o que você quer editar:");
	                        System.out.println("1- Editar vendedor");
	                        System.out.println("2- Editar venda");
	                        int menuEdicao = scanMenuVeiculo.nextInt();
	                        scanMenuVeiculo.nextLine();
	                        
	                        if(menuEdicao == 1) {
	                        	System.out.println("Digite o código do vendedor que você quer editar:");
	                        	int codigoVendedor = scanMenuVeiculo.nextInt();
	                        	scanMenuVeiculo.nextLine();
	                        	System.out.println("------------------------------");
	                        	
	                        } else if(menuEdicao == 2) {
	                        	System.out.println("Digite o código da venda que você quer editar:");
	                        	int codigoVenda = scanMenuVeiculo.nextInt();
	                        	scanMenuVeiculo.nextLine();
	                        }
	                        System.out.println("------------------------------");
	                        break;

	                    case 3: // Pesquisar nome do vendedor
	                    		// se você inserir os nomes que você inseriu no case 1
	                    		//inserir vendedor, você aqui irá conseguir pesquisar
	                    		//pelo determinado vendedor através do nome dele
	                        System.out.println("------------------------------");
	                        System.out.println("3 - Pesquisar nome do Vendedor");
	                        System.out.println("Digite o nome do vendedor:");
	                        String vendedorPesquisa = scanMenuVeiculo.nextLine();
	                        List<Vendedor> vendedoresEncontrados = vendDAO.pesquisaPorVendedorDAO(conexao, vendedorPesquisa);

	                        if (vendedoresEncontrados.isEmpty()) {
	                            System.out.println("Nenhum vendedor encontrado com o nome: " + vendedorPesquisa);
	                        } else {
	                            System.out.println("Vendedores encontrados:");
	                            for (Vendedor vendedor : vendedoresEncontrados) {
	                                System.out.println("Código: " + vendedor.getCodigo());
	                                System.out.println("Nome: " + vendedor.getNome());
	                                System.out.println("CPF: " + vendedor.getCpf());
	                                System.out.println("Telefone: " + vendedor.getTelefone());
	                                System.out.println("------------------------------");
	                            }
	                        }
	                        break;

	                    case 4: // Deletar vendedor - Em desenvolvimento
	                        System.out.println("4 - Deletar vendedor");
	                        System.out.println("Digite o nome do vendedor que você quer excluir:");
	                        String nomeVendedor = scanMenuVeiculo.nextLine();
	                       vendDAO.deletarVendedorDAO(conexao, nomeVendedor);
	                        System.out.println("Vendedor deletado com sucesso!");
	                        System.out.println("------------------------------");
	                        break;

	                    case 5: // Inserir venda, você vai
	                    		//poder cadastrar qualquer
	                    		//informação que quiser
	                        System.out.println("------------------------------");
	                        System.out.println("5 - Inserir venda");

	                        System.out.println("Digite o código da venda:");
	                        int codigoVenda = scanMenuVeiculo.nextInt();

	                        System.out.println("Digite o valor da venda:");
	                        double valorVenda = scanMenuVeiculo.nextDouble();
	                        scanMenuVeiculo.nextLine(); // Limpar o buffer

	                        System.out.println("Digite o veículo vendido:");
	                        String veiculoVendido = scanMenuVeiculo.nextLine();

	                        System.out.println("Digite o nome do vendedor responsável:");
	                        String vendedorResponsavel = scanMenuVeiculo.nextLine();

	                        System.out.println("Digite o nome do cliente comprador:");
	                        String clienteComprador = scanMenuVeiculo.nextLine();

	                        System.out.println("Informe a data da venda:");
	                        String dataVenda = scanMenuVeiculo.nextLine();

	                     String sql = "INSERT INTO venda (valor, veiculo, vendedor, cliente, data) 	VALUES (?, ?, ?, ?, ?)";

	                     try(PreparedStatement pstmt = conexao.prepareStatement(sql)) {
	                    	 pstmt.setDouble(1, valorVenda);
	                    	 pstmt.setString(2, veiculoVendido);
	                    	 pstmt.setString(3, vendedorResponsavel);
	                    	 pstmt.setString(4, clienteComprador);
	                    	 pstmt.setString(5, dataVenda);
	                    	 pstmt.executeUpdate();
	                    	 
	                    	 System.out.println("Venda registrada com sucesso!");
	                    	 
	                    	 
	                    	 
	                     }catch(SQLException e) {
	                    	 System.out.println("Erro ao tentar conectar no banco de dados:" + e.getMessage());
	                     }
	                break;
	            
	                    case 6: //Inserir tipo -O usuário vai poder inserir a descrição
	                    	//do carro que ele vai querer comprar como por exemplo se o carro
	                    	//for Sedan, SUV, Picape, esportivo, peruas, etc.
	                        System.out.println("------------------------------");
	                        System.out.println("Digite a descrição do tipo:");
	                        String descricaoTipo = scanMenuVeiculo.nextLine();
	                        
	                        Tipo tip = new Tipo();
	                        tip.setDescricao(descricaoTipo);
	                        TipoDAO.inserirTipoDAO(conexao, tip);
	                        break;

	                    case 7: // Pesquisar venda, Se você quiser pesquisar o nome do cliente
	                    	//no qual você já cadastrou insira o menu vai perguntar qual vendedor
	                    	//você deseja pesquisar e insira o nome dele
	                    	
	                        System.out.println("------------------------------");
	                        System.out.println("7 - Pesquisar venda");
	                        System.out.println("Informe o nome do cliente que você quer pesquisar:");
	                        String cliente = scanMenuVeiculo.nextLine();
	                        vendaDAO.pesquisarVendaDAO(conexao, cliente);
	                        System.out.println("O nome do cliente pesquisado foi:" + cliente);
	                        scanMenuVeiculo.nextLine();
	                        System.out.println("------------------------------");
	                        break;

	                    case 8: // Deletar venda: Você vai poder deletar a venda na qual
	                    	//você cadastrou.
	                        System.out.println("------------------------------");
	                        System.out.println("8 - Deletar venda");
	                        System.out.println("Digite o código da venda que você quer excluir:");
	                        int codigoVendaExcluir = scanMenuVeiculo.nextInt();
	                        scanMenuVeiculo.nextLine();
	                        vendaDAO.excluirVendaDAO(conexao, codigoVendaExcluir);
	                        System.out.println("Venda excluída com sucesso!");
	                        System.out.println("------------------------------");
	                        break;
	                        
	                    case 9://nesse campo você vai cadastrar o nome do cliente que comprou
	                    	//determinado veículo
	                    	System.out.println("------------------------------");
	                    	System.out.println("10- Cadastrar cliente");
	                    	System.out.println("Informe o nome do cliente:");
	                    	String nomeCliente = scanMenuVeiculo.nextLine();
	                    	System.out.println("Informe o cpf do cliente:");
	                    	String cpfCliente = scanMenuVeiculo.nextLine();
	                    	System.out.println("informe o telefone do cliente:");
	                    	String telefoneCliente = scanMenuVeiculo.nextLine();
	                    	
	                    	Cliente clie = new Cliente();
	                    	clie.setNome(nomeCliente);
	                    	clie.setCpf(cpfCliente);
	                    	clie.setTelefone(telefoneCliente);
	                    	
	                    	try {
	                    		ClienteDAO.inserirClienteDAO(conexao, clie);
	                    	}catch(SQLException e) {
	                    		System.out.println("Erro ao cadastrar cliente" + e.getMessage());
	                    	}
	                    	break;
	                    	
	                    case 10://cadastrar Loja
	                    	//aqui você vai poder cadastrar o nome da loja
	                    	//que você quer inserir.
	                    	System.out.println("Digite o nome da Loja:");
	                    	String nomeLoja = scanMenuVeiculo.nextLine();
	                    	System.out.println("Digite o endereço da Loja:");
	                    	String enderecoLoja = scanMenuVeiculo.nextLine();
	                    	System.out.println("Digite o telefone da Loja:");
	                    	String telefoneLoja = scanMenuVeiculo.nextLine();
	                    	System.out.println("Digite  o cnpj da Loja:");
	                    	String cnpjLoja = scanMenuVeiculo.nextLine();
	                    	Loja loj = new Loja();
	                    	loj.setNome(nomeLoja);
	                    	loj.setEndereco(enderecoLoja);
	                    	loj.setTelefone(telefoneLoja);
	                    	loj.setCnpj(cnpjLoja);
	                    	LojaDAO.inserirLojaDAO(conexao, loj);
	                    	break;
	                    	
	                    case 11://Pesquisar Loja: aqui o usuário vai poder pesquisar pela loja
	                    	//que ele cadastrou no menu.
	                    	System.out.println("------------------------------");
	                    	System.out.println("Digite o nome da Loja que você quer pesquisar:");
	                    		String nomeLojaPesquisa = scanMenuVeiculo.nextLine();
	                    		
	                    		LojaDAO lojaDAO = new LojaDAO();
	                    		lojaDAO.pesquisarPorLojaDAO(conexao, nomeLojaPesquisa);
	                    		System.out.println("O nome da Loja pesquisada foi:" + nomeLojaPesquisa);
	                    		       break;
	                    		       
	                    case 12://Pesquisar cliente: aqui o usuário vai poder pesquisar pelo
	                    	//cliente que ele cadastrou através do cpf que ele for inserir
	                    	System.out.println("------------------------------");
	                    	System.out.println("Informe o cpf do cliente que você quer pesquisar:");
	                    	String cpfClientePesquisa = scanMenuVeiculo.nextLine();
	                    	
	                    	ClienteDAO clieDAO = new ClienteDAO();
	                    	clieDAO.pesquisaPorCpfDAO(conexao, cpfClientePesquisa );
	                    		System.out.println("O cpf do cliente informado é:" + cpfClientePesquisa);
	                    		break;
	                    		
	                    case 13: // Sair do sistema
	                        System.out.println("------------------------------");
	                        System.out.println("13 - Sair do sistema");
	                        System.out.println("------------------------------");
	                        break;
	                        
	                    default:
	                        System.out.println("------------------------------");
	                        System.out.println("Erro, tente uma das opções acima!");
	                        System.out.println("------------------------------");
	                        break;
	                }
	            } while (menuVeiculo != 13);
	            System.out.println("Obrigado por usar o sistema.");
	        } catch (SQLException e) {
	            System.err.println("Erro ao conectar no banco de dados: " + e.getMessage());
	        }
	    }
	}