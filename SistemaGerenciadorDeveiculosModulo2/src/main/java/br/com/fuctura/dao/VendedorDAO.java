package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Vendedor;

public class VendedorDAO {

	public static void inserirVendedorDAO(Connection conexao, Vendedor ven) throws SQLException {
		System.out.println("Cadastrando dados da venda!");
		
		String comandoInsert = "INSERT INTO vendedor (nome, cpf, telefone) VALUES (?, ?, ?)";
		
		try(PreparedStatement pstm = conexao.prepareStatement(comandoInsert)) {
	            pstm.setString(1, ven.getNome());
	            pstm.setString(2, ven.getCpf());
	            pstm.setString(3, ven.getTelefone());
			
			pstm.executeUpdate();
			
			System.out.println("Vendedor registrado com sucesso!");
			
		}catch(SQLException e) {
			System.err.println("Erro ao cadastrar vendedor:" + e.getMessage());
		throw e;
		}
	}
	
	public static List<Vendedor> pesquisaPorVendedorDAO(Connection conexao, String nome) throws SQLException {
	    List<Vendedor> vendedores = new ArrayList<>();

	    String comandoDePesquisa = "SELECT codigo, nome, cpf, telefone FROM vendedor WHERE nome LIKE ?";
	    
	    try (PreparedStatement pstm = conexao.prepareStatement(comandoDePesquisa)) {
	        pstm.setString(1, "%" + nome + "%");
	        
	        try (ResultSet rs = pstm.executeQuery()) {
	            while (rs.next()) {
	                Vendedor ven = new Vendedor();
	                ven.setCodigo(rs.getInt("codigo"));
	                ven.setNome(rs.getString("nome"));
	                ven.setCpf(rs.getString("cpf"));
	                ven.setTelefone(rs.getString("telefone"));
	                
	                vendedores.add(ven);
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao pesquisar vendedores: " + e.getMessage());
	        throw e;
	    }
	    
	    return vendedores;
	}
	
	public static void deletarVendedorDAO(Connection conexao, String nomeVendedor) throws SQLException {
		String comandoDelete = "DELETE FROM vendedor WHERE nome = ?";
        
        try (PreparedStatement pstm = conexao.prepareStatement(comandoDelete)) {
            pstm.setString(1, nomeVendedor);
            
            int linhasAfetadas = pstm.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Vendedor deletado com sucesso!");
            } else {
                System.out.println("Nenhum vendedor encontrado com o código: " + nomeVendedor);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar vendedor: " + e.getMessage());
            throw e;
        }
    }
}