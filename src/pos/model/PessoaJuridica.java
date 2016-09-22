package pos.model;

public class PessoaJuridica extends Pessoa {

	private String cnpj;
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica(String nome, Integer idade, Contato contato, Endereco endereco, String cnpj) {
		super(nome, idade, contato, endereco);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
