package br.com.fuctura.entidade;

import java.util.Objects;

import lombok.Data;
@Data
public class Vendedor {

	int codigo;
	String nome;
	String cpf;
	String telefone;
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	@Override
	public String toString() {
		return "Vendedor [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + "]";
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
		
	}

	
	}

	
	

