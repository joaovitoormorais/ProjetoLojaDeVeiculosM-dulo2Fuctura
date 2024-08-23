package br.com.fuctura.entidade;

import java.util.Objects;

import lombok.Data;

@Data
public class Loja {

	String nome;
	String endereco;
	String telefone;
	String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Loja [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}

	public String getTelefone(String comandoDePesquisa) {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome(String comandoInsert) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTelefone() {
		// TODO Auto-generated method stub
		return null;
	}
}
