package pos.model;

public class PessoaFisica extends Pessoa {

	private String cpf;
	
	public PessoaFisica() {
	
	}

	public PessoaFisica(String nome, Integer idade, Contato contato, Endereco endereco, String cpf) {
		super(nome, idade, contato, endereco);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
