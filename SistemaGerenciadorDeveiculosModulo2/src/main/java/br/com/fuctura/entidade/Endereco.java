package br.com.fuctura.entidade;

import java.util.Objects;

import lombok.Data;
@Data
public class Endereco {

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(rua, other.rua);
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + "]";
	}

	String cep;
	String rua;
	String bairro;
	String cidade;
	
	public String getCep(String cep) {
		return cep;
	}
	
	public String getRua(String rua) {
		return rua;
	}
	
	public String getBairro(String bairro) {
		return bairro;
	}
	
	public String getCidade(String cidade) {
		return cidade;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
