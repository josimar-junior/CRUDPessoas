package pos.model;

public class Endereco {

	private String cidade;
	private String rua;

	public Endereco(String cidade, String rua) {
		this.cidade = cidade;
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
