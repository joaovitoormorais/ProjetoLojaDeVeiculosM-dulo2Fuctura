package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Venda;

public class VendaDAO {

	public static void inserirVendaDAO(Connection conexao, Venda ven) throws SQLException {

		System.out.println("Cadastrando dados da venda!");

		String comandoInsert = "INSERT INTO venda (codigo, valor, veiculo, vendedor, cliente, data) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = conexao.prepareStatement(comandoInsert)) {
			pstm.setInt(1, ven.getCodigo());
			pstm.setDouble(2, ven.getValor());
			pstm.setString(3, ven.getVeiculovendido());
			pstm.setString(4, ven.getVendedorresponsavel());
			pstm.setString(5, ven.getClientecomprador());
			pstm.setString(6, ven.getDatavenda());

			pstm.executeUpdate();

			System.out.println("Venda registrada com sucesso!");
		}catch(SQLException e) {
			System.err.println("Erro ao registrar a venda" + e.getMessage());
		throw e;
		}
	}

	public static List<Venda> pesquisarVendaDAO(Connection conexao, String cliente) throws SQLException {
		String comandoDePesquisa = "SELECT * FROM venda WHERE cliente LIKE ?";

		try (PreparedStatement pstm = conexao.prepareStatement(comandoDePesquisa)) {
			pstm.setString(1, cliente + "%");

			try (ResultSet resultadoPesquisa = pstm.executeQuery()) {
				List<Venda> listaDeVendas = new ArrayList<>();

				while (resultadoPesquisa.next()) {
					int codigoVenda = resultadoPesquisa.getInt("codigo");
					double valorVenda = resultadoPesquisa.getDouble("valor");
					String veiculoVendido = resultadoPesquisa.getString("veiculo");
					String vendedorResponsavel = resultadoPesquisa.getString("vendedor");
					String clienteResponsavel = resultadoPesquisa.getString("cliente");
					String dataVenda = resultadoPesquisa.getString("data");

					Venda venda = new Venda();
					venda.setCodigo(codigoVenda);
					venda.setValor(valorVenda);
					venda.setVeiculovendido(veiculoVendido);
					venda.setVendedorresponsavel(vendedorResponsavel);
					venda.setClientecomprador(clienteResponsavel);
					venda.setDatavenda(dataVenda);

					listaDeVendas.add(venda);
				}

				return listaDeVendas;
			}
		} catch(SQLException e) {
			System.err.println("Erro ao pesquisar venda" + e.getMessage());
			throw e;
		}

	}

	public static void excluirVendaDAO(Connection conexao, int codigo) throws SQLException {
		String comandoExcluir = "DELETE FROM venda WHERE codigo = ?";

		try (PreparedStatement pstm = conexao.prepareStatement(comandoExcluir)) {
			pstm.setInt(1, codigo);

			int linhasAfetadas = pstm.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Venda excluída com sucesso!");
			} else {
				System.out.println("Nenhuma venda foi encontrada com o código fornecido.");
			}
		}catch(SQLException e) {
			System.err.println("Erro ao excluir venda" + e.getMessage());
			throw e;
		}

	}

}