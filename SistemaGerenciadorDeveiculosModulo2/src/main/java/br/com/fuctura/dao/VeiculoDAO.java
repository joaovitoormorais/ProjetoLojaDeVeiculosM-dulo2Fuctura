package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Veiculo;

public class VeiculoDAO {

	public static void inserirVeiculoDAO(Connection conexao, Veiculo vei) throws SQLException {

		System.out.println("Cadastrando dados do vendedor!");

		String comandoInsert = "insert into veiculo (placa, modelo, ano, valor) values (?, ?, ?, ?)";

		PreparedStatement pstm = conexao.prepareStatement(comandoInsert);

		pstm.setInt(1, vei.getAno());
		pstm.setString(2, vei.getModelo());
		pstm.setString(3, vei.getPlaca());
		pstm.execute();

		System.out.println("Veículo cadastrado com sucesso!");
	}

	public List<Veiculo> pesquisaPorPlaca(Connection conexao, Veiculo vei) throws SQLException {

		String comandoDePesquisa = "SELECT * FROM veiculo WHERE placa LIKE ?";

		PreparedStatement pstm = conexao.prepareStatement(comandoDePesquisa);

		pstm.setString(1, vei.getPlaca());

		ResultSet resultadoPesquisa = pstm.executeQuery();

		List<Veiculo> listaDeVeiculo = new ArrayList<>();

		while (resultadoPesquisa.next());
			

		int codigoVeiculo = resultadoPesquisa.getInt("código");
		int ano = resultadoPesquisa.getInt("ano");
		String modelo = resultadoPesquisa.getString("modelo");
		String placa = resultadoPesquisa.getString("placa");

		System.out.println("-----------------------");

		Veiculo resultadoLista = new Veiculo();
		resultadoLista.setCodigo(codigoVeiculo);
		resultadoLista.setAno(ano);
		resultadoLista.setPlaca(placa);
		resultadoLista.setModelo(modelo);

		listaDeVeiculo.add(resultadoLista);

		return listaDeVeiculo;
	}
}