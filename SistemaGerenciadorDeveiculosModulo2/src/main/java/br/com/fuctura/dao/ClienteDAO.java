package br.com.fuctura.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Cliente;

public class ClienteDAO {

	public static void inserirClienteDAO(Connection conexao, Cliente clie) throws SQLException {
		
		System.out.println("Inserindo dados do cliente.");
		
		String comandoInsert = "insert into cliente (nome, cpf, telefone)\r\n"
				+ "values (?, ?, ?)";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoInsert);

		pstm.setString(1, clie.getNome());
		pstm.setString(2, clie.getCpf());
		pstm.setString(3, clie.getTelefone());

		pstm.execute();

		System.out.println("Cliente registrado com sucesso!");
	}
	
	public List<Cliente> pesquisaPorCpfDAO(Connection conexao, String cpfClientePesquisa ) throws SQLException {
		
		String comandoDePesquisa = "SELECT * FROM cliente WHERE cpf LIKE ?";

		PreparedStatement pstm = conexao.prepareStatement(comandoDePesquisa);

		pstm.setString(1, cpfClientePesquisa + "%");

		ResultSet resultadoPesquisa = pstm.executeQuery();
		
		List<Cliente> listaDeClientes = new ArrayList<>();
		
		while(resultadoPesquisa.next()) {
		
		int codigoCliente = resultadoPesquisa.getInt("codigo");
		String nomeCliente = resultadoPesquisa.getString("nome");
		String telefoneCliente = resultadoPesquisa.getString("telefone");
		System.out.println("-----------------------");
		
		Cliente resultadoLista = new Cliente();
		resultadoLista.setCodigo(codigoCliente);
		resultadoLista.setNome(nomeCliente);
		resultadoLista.setNome(nomeCliente);
		resultadoLista.setTelefone(telefoneCliente);
		
		listaDeClientes.add(resultadoLista);
	
	}
	
	return listaDeClientes;
}

}
