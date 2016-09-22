package pos.dao;

import java.util.ArrayList;
import java.util.List;

import pos.model.Pessoa;

public class PessoaDAO {
	
	private static List<Pessoa> pessoas = new ArrayList<>();

	public static void salvar(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public static List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public static void remover(Pessoa pessoa) {
		pessoas.remove(pessoa);
	}
	
	public static void atualizar(int id, Pessoa pessoa) {
		pessoas.set(id, pessoa);
	}
	
	public static Pessoa getPessoaPorId(int id) {
		return pessoas.get(id);
	}
}
