package pos.model;

import javafx.beans.property.SimpleStringProperty;

public class ItensProperty {

	private SimpleStringProperty nome;
	private SimpleStringProperty email;
	private SimpleStringProperty telefone;
	private SimpleStringProperty cidade;

	public ItensProperty(String nome, String email, String telefone,
			String cidade) {
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty(email);
		this.telefone = new SimpleStringProperty(telefone);
		this.cidade = new SimpleStringProperty(cidade);
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public String getTelefone() {
		return telefone.get();
	}

	public void setTelefone(String telefone) {
		this.telefone.set(telefone);
	}

	public String getCidade() {
		return cidade.get();
	}

	public void setCidade(String cidade) {
		this.cidade.set(cidade);
	}


}
