 package br.com.fuctura.entidade;

import java.util.Objects;

import lombok.Data;
@Data
public class Veiculo {

	@Override
	public String toString() {
		return "Veiculo [ano=" + ano + ", modelo=" + modelo + ", placa=" + placa + "]";
	}
	int codigo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	int ano;
	String modelo;
	String placa;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ano, modelo, placa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return ano == other.ano && Objects.equals(modelo, other.modelo) && Objects.equals(placa, other.placa);
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
}
