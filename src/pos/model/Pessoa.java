package pos.model;

public abstract class Pessoa {

	private String nome;
	private Integer idade;
	private Contato contato;
	private Endereco endereco;

	public Pessoa() {

	}

	public Pessoa(String nome, Integer idade, Contato contato, Endereco endereco) {
		this.nome = nome;
		this.contato = contato;
		this.idade = idade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
