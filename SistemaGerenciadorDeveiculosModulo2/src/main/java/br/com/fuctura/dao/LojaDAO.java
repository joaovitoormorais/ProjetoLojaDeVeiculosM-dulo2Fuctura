package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Loja;

public class LojaDAO {

	public static void inserirLojaDAO(Connection conexao, Loja loj) throws SQLException {
		System.out.println("Inserindo dados da Loja.");

		String comandoInsert = "insert into loja (nome, endereco, telefone, cnpj) values (?, ?, ?, ?)";

		PreparedStatement pstm = conexao.prepareStatement(comandoInsert);

		pstm.setString(1, loj.getNome());
		pstm.setString(2, loj.getEndereco());
		pstm.setString(3, loj.getTelefone());
		pstm.setString(4, loj.getCnpj());
		pstm.execute();

		System.out.println("Código executado com sucesso!");

	}

	public void pesquisarPorLojaDAO(Connection conexao, String nomeLoja) throws SQLException {

		String comandoDePesquisa = "SELECT * FROM loja WHERE nome = ?";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoDePesquisa);
		
		pstm.setString(1, nomeLoja);
		
		ResultSet resultadoPesquisa = pstm.executeQuery();
			

		while(resultadoPesquisa.next()) {
			
			String nome = resultadoPesquisa.getString("nome");
			String endereco = resultadoPesquisa.getString("endereço");
			String telefone = resultadoPesquisa.getString("telefone");
			String cnpj = resultadoPesquisa.getString("cnpj");
			
			System.out.println("-----------------------");
			System.out.println("Nome:" + nome);
			System.out.println("Endereço:" + endereco);
			System.out.println("Telefone:" + telefone);
			System.out.println("Cnpj:" + cnpj);
		}

		
	}
}