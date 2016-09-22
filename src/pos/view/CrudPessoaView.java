package pos.view;

import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pos.dao.PessoaDAO;
import pos.model.Contato;
import pos.model.Endereco;
import pos.model.ItensProperty;
import pos.model.Pessoa;
import pos.model.PessoaFisica;
import pos.model.PessoaJuridica;
import pos.model.TipoPessoa;
import pos.util.Mensagens;

public class CrudPessoaView extends Application {

	private AnchorPane pane;
	private Label lbNome, lbIdade, lbEmail, lbTelefone, lbCidade, lbRua, lbCpf, lbCnpj, lbTipoPessoa;
	private TextField tfNome, tfIdade, tfEmail, tfTelefone, tfCidade, tfRua, tfCpf, tfCnpj;
	private ComboBox<String> cbTipoPessoa;
	private Button btSalvar, btAtualizar, btRemover, btLimpar;
	private TableView<ItensProperty> table;
	private static ObservableList<ItensProperty> listaPessoas = FXCollections.observableArrayList();
	private int indice;
	private Pessoa pessoaSelecionada;

	private void initCompontens() {
		pane = new AnchorPane();
		pane.setPrefSize(900, 600);

		lbNome = new Label("Nome:");
		lbNome.setFont(Font.font("Tahoma", 15));

		lbIdade = new Label("Idade:");
		lbIdade.setFont(Font.font("Tahoma", 15));

		lbEmail = new Label("Email:");
		lbEmail.setFont(Font.font("Tahoma", 15));

		lbNome = new Label("Nome:");
		lbNome.setFont(Font.font("Tahoma", 15));

		lbTelefone = new Label("Telefone:");
		lbTelefone.setFont(Font.font("Tahoma", 15));

		lbCidade = new Label("Cidade:");
		lbCidade.setFont(Font.font("Tahoma", 15));

		lbRua = new Label("Rua:");
		lbRua.setFont(Font.font("Tahoma:", 15));

		lbCpf = new Label("CPF:");
		lbCpf.setFont(Font.font("Tahoma", 15));
		lbCpf.setVisible(false);

		lbCnpj = new Label("CNPJ:");
		lbCnpj.setFont(Font.font("Tahoma", 15));
		lbCnpj.setVisible(false);

		lbTipoPessoa = new Label("Tipo:");
		lbTipoPessoa.setFont(Font.font("Tahoma", 15));

		tfNome = new TextField();
		tfNome.setPrefWidth(200);
		tfNome.setFont(Font.font("Tahoma", 15));

		tfIdade = new TextField();
		tfIdade.setPrefWidth(50);
		tfIdade.setFont(Font.font("Tahoma", 15));

		tfEmail = new TextField();
		tfEmail.setPrefWidth(200);
		tfEmail.setFont(Font.font("Tahoma", 15));

		tfTelefone = new TextField();
		tfTelefone.setPrefWidth(200);
		tfTelefone.setFont(Font.font("Tahoma", 15));

		tfCidade = new TextField();
		tfCidade.setPrefWidth(200);
		tfCidade.setFont(Font.font("Tahoma", 15));

		tfRua = new TextField();
		tfRua.setPrefWidth(200);
		tfRua.setFont(Font.font("Tahoma", 15));

		tfCpf = new TextField();
		tfCpf.setPrefWidth(200);
		tfCpf.setFont(Font.font("Tahoma", 15));
		tfCpf.setVisible(false);

		tfCnpj = new TextField();
		tfCnpj.setPrefWidth(200);
		tfCnpj.setFont(Font.font("Tahoma", 15));
		tfCnpj.setVisible(false);

		cbTipoPessoa = new ComboBox<>();
		cbTipoPessoa.getItems().addAll(TipoPessoa.FISICA.getDescricao(), TipoPessoa.JURIDICA.getDescricao());
		cbTipoPessoa.setValue("Selecione");
		cbTipoPessoa.getStyleClass().add("cbTipoPessoa");

		btSalvar = new Button("Salvar");
		btSalvar.setFont(Font.font("Tahoma", 15));
		btSalvar.getStyleClass().add("botao");

		btAtualizar = new Button("Atualizar");
		btAtualizar.setFont(Font.font("Tahoma", 15));
		btAtualizar.getStyleClass().add("botao");
		btAtualizar.setDisable(true);

		btRemover = new Button("Remover");
		btRemover.setFont(Font.font("Tahoma", 15));
		btRemover.getStyleClass().add("botao");
		btRemover.setDisable(true);
		
		btLimpar = new Button("Limpar");
		btLimpar.setFont(Font.font("Tahoma", 15));
		btLimpar.getStyleClass().add("btLimpar");

		initTable();

		pane.getChildren().addAll(lbNome, lbIdade, lbEmail, lbTelefone, lbCidade, lbRua, lbCpf, lbCnpj, lbTipoPessoa,
				tfNome, tfIdade, tfEmail, tfTelefone, tfCidade, tfRua, tfCpf, tfCnpj, cbTipoPessoa, btSalvar,
				btAtualizar, btRemover, btLimpar, table);
	}

	private void initTable() {
		table = new TableView<>();
		
		table.setPlaceholder(new Label("Nenhuma pessoa encontrada."));

		TableColumn<ItensProperty, String> nome = new TableColumn("Nome");
		TableColumn<ItensProperty, String> email = new TableColumn("Email");
		TableColumn<ItensProperty, String> telefone = new TableColumn("Telefone");
		TableColumn<ItensProperty, String> cidade = new TableColumn("Cidade");

		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		nome.setSortable(false);

		email.setCellValueFactory(new PropertyValueFactory<>("email"));
		email.setSortable(false);

		telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		telefone.setSortable(false);

		cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		cidade.setSortable(false);

		nome.setPrefWidth(298);
		email.setPrefWidth(200);
		telefone.setPrefWidth(200);
		cidade.setPrefWidth(200);

		table.getColumns().addAll(nome, email, telefone, cidade);
	}

	private void initLayout() {
		lbNome.setLayoutX(20);
		lbNome.setLayoutY(20);

		tfNome.setLayoutX(20);
		tfNome.setLayoutY(40);

		lbIdade.setLayoutX(250);
		lbIdade.setLayoutY(20);

		tfIdade.setLayoutX(250);
		tfIdade.setLayoutY(40);

		lbEmail.setLayoutX(330);
		lbEmail.setLayoutY(20);

		tfEmail.setLayoutX(330);
		tfEmail.setLayoutY(40);

		lbTelefone.setLayoutX(560);
		lbTelefone.setLayoutY(20);

		tfTelefone.setLayoutX(560);
		tfTelefone.setLayoutY(40);

		lbCidade.setLayoutX(20);
		lbCidade.setLayoutY(90);

		tfCidade.setLayoutX(20);
		tfCidade.setLayoutY(110);

		lbRua.setLayoutX(250);
		lbRua.setLayoutY(90);

		tfRua.setLayoutX(250);
		tfRua.setLayoutY(110);

		lbTipoPessoa.setLayoutX(480);
		lbTipoPessoa.setLayoutY(90);

		cbTipoPessoa.setLayoutX(480);
		cbTipoPessoa.setLayoutY(110);

		lbCpf.setLayoutX(643);
		lbCpf.setLayoutY(90);

		tfCpf.setLayoutX(643);
		tfCpf.setLayoutY(110);

		lbCnpj.setLayoutX(643);
		lbCnpj.setLayoutY(90);

		tfCnpj.setLayoutX(643);
		tfCnpj.setLayoutY(110);

		btSalvar.setLayoutX(20);
		btSalvar.setLayoutY(170);

		btAtualizar.setLayoutX(115);
		btAtualizar.setLayoutY(170);

		btRemover.setLayoutX(230);
		btRemover.setLayoutY(170);
		
		btLimpar.setLayoutX(350);
		btLimpar.setLayoutY(170);

		table.setPrefSize(pane.getWidth(), 347);
		table.setLayoutX(0);
		table.setLayoutY(250);
	}

	private void initListeners() {

		cbTipoPessoa.setOnAction((event) -> {
			String tipo = cbTipoPessoa.getValue().toString();
			if (tipo.equals(TipoPessoa.FISICA.getDescricao())) {
				lbCpf.setVisible(true);
				tfCpf.setVisible(true);
				lbCnpj.setVisible(false);
				tfCnpj.setVisible(false);
			} else {
				lbCpf.setVisible(false);
				tfCpf.setVisible(false);
				lbCnpj.setVisible(true);
				tfCnpj.setVisible(true);
			}
		});

		btSalvar.setOnAction((event) -> {
			String nome = tfNome.getText();
			Integer idade = Integer.parseInt(tfIdade.getText());
			String email = tfEmail.getText();
			String telefone = tfTelefone.getText();
			String cidade = tfCidade.getText();
			String rua = tfRua.getText();
			String cpf = tfCpf.getText();
			String cnpj = tfCnpj.getText();

			Contato contato = new Contato(email, telefone);
			Endereco endereco = new Endereco(cidade, rua);
			if (cpf.isEmpty()) {
				PessoaJuridica pj = new PessoaJuridica(nome, idade, contato, endereco, cnpj);
				PessoaDAO.salvar(pj);
				Mensagens.mensagemInformacao("Pessoa Jurídica cadastrada com sucesso!");
			} else {
				PessoaFisica pf = new PessoaFisica(nome, idade, contato, endereco, cpf);
				PessoaDAO.salvar(pf);
				Mensagens.mensagemInformacao("Pessoa física cadastrada com sucesso!");
			}
			preencherTabela();
			limparCampos();
		});

		btAtualizar.setOnAction((event) -> {
			
			String nome = tfNome.getText();
			Integer idade = Integer.parseInt(tfIdade.getText());
			String email = tfEmail.getText();
			String telefone = tfTelefone.getText();
			String cidade = tfCidade.getText();
			String rua = tfRua.getText();
			String cpf = tfCpf.getText();
			String cnpj = tfCnpj.getText();
			
			String tipoPessoa = cbTipoPessoa.getValue().toString();
			
			if(tipoPessoa.equals(TipoPessoa.FISICA.getDescricao())) {
				cnpj = "";
			} else {
				cpf = "";
			}
			
			Contato contato = new Contato(email, telefone);
			Endereco endereco = new Endereco(cidade, rua);
			
			if (cpf.isEmpty()) {
				PessoaJuridica pj = new PessoaJuridica(nome, idade, contato, endereco, cnpj);
				PessoaDAO.atualizar(indice, pj);
				Mensagens.mensagemInformacao("Pessoa jurídica atualizada com sucesso!");
			} else {
				PessoaFisica pf = new PessoaFisica(nome, idade, contato, endereco, cpf);
				PessoaDAO.atualizar(indice, pf);
				Mensagens.mensagemInformacao("Pessoa física atualizada com sucesso!");
			}
			preencherTabela();
			limparCampos();
		});
		
		btRemover.setOnAction((event) -> {
			PessoaDAO.remover(pessoaSelecionada);
			if(pessoaSelecionada instanceof PessoaFisica) {
				Mensagens.mensagemInformacao("Pessoa física excluída com sucesso!");
			} else {
				Mensagens.mensagemInformacao("Pessoa jurídica excluída com sucesso!");
			}
			preencherTabela();
			limparCampos();
		});
		
		btLimpar.setOnAction((event) -> {
			limparCampos();
		});

		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItensProperty>() {

			@Override
			public void changed(ObservableValue<? extends ItensProperty> observable, ItensProperty oldValue,
					ItensProperty newValue) {

				try {
					indice = table.getSelectionModel().getSelectedIndex();
					pessoaSelecionada = PessoaDAO.getPessoaPorId(indice);
					setPessoaSelecionadaCampos();
					btSalvar.setDisable(true);
					btAtualizar.setDisable(false);
					btRemover.setDisable(false);
				} catch (Exception e) {

				}
			}
		});
	}

	private void setPessoaSelecionadaCampos() {
		tfNome.setText(pessoaSelecionada.getNome());
		tfIdade.setText(pessoaSelecionada.getIdade().toString());
		tfEmail.setText(pessoaSelecionada.getContato().getEmail());
		tfTelefone.setText(pessoaSelecionada.getContato().getTelefone());
		tfCidade.setText(pessoaSelecionada.getEndereco().getCidade());
		tfRua.setText(pessoaSelecionada.getEndereco().getRua());

		if (pessoaSelecionada instanceof PessoaFisica) {
			lbCpf.setVisible(true);
			tfCpf.setVisible(true);
			cbTipoPessoa.setValue(TipoPessoa.FISICA.getDescricao());
			tfCpf.setText(((PessoaFisica) pessoaSelecionada).getCpf());
		} else {
			lbCnpj.setVisible(true);
			tfCnpj.setVisible(true);
			cbTipoPessoa.setValue(TipoPessoa.JURIDICA.getDescricao());
			tfCnpj.setText(((PessoaJuridica) pessoaSelecionada).getCnpj());
		}
	}

	private void preencherTabela() {
		List<Pessoa> pessoas = PessoaDAO.getPessoas();
		listaPessoas.clear();
		for (Pessoa pessoa : pessoas) {
			listaPessoas.add(new ItensProperty(pessoa.getNome(), pessoa.getContato().getEmail(),
					pessoa.getContato().getTelefone(), pessoa.getEndereco().getCidade()));
		}
	}

	private void limparCampos() {
		TextField[] tfCampos = { tfNome, tfIdade, tfEmail, tfTelefone, tfCidade, tfRua, tfCpf, tfCnpj };
		for (TextField tf : tfCampos) {
			tf.setText("");
		}
		cbTipoPessoa.setValue("Selecione");

		lbCnpj.setVisible(false);
		tfCnpj.setVisible(false);
		lbCpf.setVisible(false);
		tfCpf.setVisible(false);
		
		btSalvar.setDisable(false);
		btAtualizar.setDisable(true);
		btRemover.setDisable(true);
		tfNome.requestFocus();
	}

	@Override
	public void start(Stage stage) throws Exception {
		initCompontens();
		initListeners();
		table.setItems(listaPessoas);
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("/pos/css/style.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("CRUD de Pessoas");

		stage.show();
		initLayout();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
