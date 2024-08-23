package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Tipo;

import java.util.ArrayList;

public class TipoDAO {

	public static void inserirTipoDAO(Connection conexao, Tipo ti) throws SQLException {
		System.out.println("Inserindo tipo");
		String comandoInsert = "insert into tipo (descricao) values (?)";
		PreparedStatement pstm = conexao.prepareStatement(comandoInsert);
		pstm.setString(1, ti.getDescricao());
		pstm.execute();

		System.out.println("Tipo inserido com sucesso!");

	}

	public Tipo pesquisarTipoDAO(Connection conexao, String descricao) throws SQLException {

		String comandoDePesquisa = "SELECT * FROM tipo WHERE descricao LIKE ?";
		
		PreparedStatement pstm = conexao.prepareStatement(comandoDePesquisa);

		pstm.setString(1,  descricao + "%");

		ResultSet resultadoPesquisa = pstm.executeQuery();

		if(resultadoPesquisa.next()) {
			Tipo tip = new Tipo();
			
			tip.setCodigo(resultadoPesquisa.getInt("código"));
			tip.setDescricao(resultadoPesquisa.getString("descrição"));
			return tip;
		} else {
		return null;
	}

}
	
}