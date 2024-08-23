package br.com.fuctura.entidade;

public class Venda {

	int codigo;
	double valor;
	String veiculovendido;
	String vendedorresponsavel;
	String clientecomprador;
	String datavenda;

	public String getVeiculovendido() {
		return veiculovendido;
	}

	public void setVeiculovendido(String veiculovendido) {
		this.veiculovendido = veiculovendido;
	}

	public String getVendedorresponsavel() {
		return vendedorresponsavel;
	}

	public void setVendedorresponsavel(String vendedorresponsavel) {
		this.vendedorresponsavel = vendedorresponsavel;
	}

	public String getClientecomprador() {
		return clientecomprador;
	}

	public void setClientecomprador(String clientecomprador) {
		this.clientecomprador = clientecomprador;
	}

	public String getDatavenda() {
		return datavenda;
	}

	public void setDatavenda(String datavenda) {
		this.datavenda = datavenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", valor=" + valor + ", veiculovendido=" + veiculovendido
				+ ", vendedorresponsavel=" + vendedorresponsavel + ", clientecomprador=" + clientecomprador
				+ ", datavenda=" + datavenda + "]";
	}

}
