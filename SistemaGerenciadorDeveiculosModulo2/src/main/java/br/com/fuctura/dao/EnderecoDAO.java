package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Endereco;

public class EnderecoDAO {

	public static void inserirEndereco(Connection conexao, Endereco end) throws SQLException {
		System.out.println("Inserindo dados do endereço.");

		String comandoInsert = "insert into endereco (bairro, cep, cidade, rua)\r\n" + "values (?, ?, ?, ?)";

		PreparedStatement pstm = conexao.prepareStatement(comandoInsert);

		pstm.setString(1, end.getBairro(comandoInsert));
		pstm.setString(2, end.getCep(comandoInsert));
		pstm.setString(3, end.getCidade(comandoInsert));
		pstm.setString(4, end.getRua(comandoInsert));
		pstm.execute();

		System.out.println("Endereço registrado!");

	}

	public void pesquisarPorEnderecoDAO(Connection conexao, Endereco end) throws SQLException {

		String comandoDePesquisa = "SELECT * FROM endereço WHERE bairro = ? AND cep = ? AND cidade = ? AND rua = ?";
		PreparedStatement pstm = conexao.prepareStatement(comandoDePesquisa);
		pstm.setString(1, end.getBairro(comandoDePesquisa));
		pstm.setString(2, end.getCep(comandoDePesquisa));
		pstm.setString(3, end.getCidade(comandoDePesquisa));
		pstm.setString(4, end.getRua(comandoDePesquisa));

		ResultSet resultadopesquisa = pstm.executeQuery();

		while (resultadopesquisa.next()) {

			String nomeBairro = resultadopesquisa.getString("bairro");
			String Cep = resultadopesquisa.getString("cep");
			String Cidade = resultadopesquisa.getString("cidade");
			String Rua = resultadopesquisa.getString("rua");
			System.out.println("-----------------------");

			Endereco resultadoLista = new Endereco();
			resultadoLista.setBairro(nomeBairro);
			resultadoLista.setCep(Cep);
			resultadoLista.setCidade(Cidade);
			resultadoLista.setRua(Rua);
		}
	}
}
