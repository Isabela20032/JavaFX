package br.edu.iftm.lp2.projetojavafx;

import br.edu.iftm.lp2.projetojavafx.util.Notificacao;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TelaCadastroClienteController implements Initializable {

    private List<Cliente> listaCliente = new ArrayList<>();

    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoEmail;

    @FXML
    private Button botaoSalvar;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEndereco;

    //private TextField campoNumero;

    @FXML
    private TableColumn<Cliente, String> tableColumnNome;

    @FXML
    private TableColumn<Cliente, String> tableColumnEndereco;

    @FXML
    private TableView<Cliente> tabelaCliente;

    @FXML
    private TableColumn<Cliente, String> tableColumnCPF;

    @FXML
    private TableColumn<Cliente, String> tableColumnEmail;

    @FXML
    private TableColumn<Cliente, Cliente> tableColumnRemover;

    @FXML
    private TableColumn<Cliente, Cliente> tableColumnEditar;

    private ObservableList<Cliente> obsLista;

    private Cliente cliente;

    @FXML
    void salvarCliente(ActionEvent event) {
        String nome = campoNome.getText();
        String cpf = campoCPF.getText();
        String email = campoEmail.getText();
        String endereco = campoEndereco.getText();

        if(nome.trim().equals("") ||
             cpf.trim().equals("") ||
             email.trim().equals("") ||
             endereco.trim().equals("")){
            Notificacao.mostraNotificacao("Erro", null,
                    "Cadatro possui campos vazios",
                    Alert.AlertType.ERROR);
        }else{

            if(cliente == null){
                cliente = new Cliente(nome,cpf,email,endereco);
                listaCliente.add(cliente);
            }else{
                int posicao = listaCliente.indexOf(cliente);
                cliente = new Cliente(nome,cpf,email,endereco);
                listaCliente.set(posicao,cliente);
            }
            limpaFormulario();
            atualizaTabela();
            for (Cliente cliente: listaCliente) {
                System.out.println(cliente);
            }
            cliente = null;
        }

        //convertendo de String para valor numero
        /*int numero1 = Integer.parseInt(campoNumero.getText());
        float numero2 = Float.parseFloat(campoNumero.getText());
        double numero3 = Double.parseDouble(campoNumero.getText());*/
    }

    private void limpaFormulario(){
        campoNome.clear();
        campoCPF.clear();
        campoEmail.clear();
        campoEndereco.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializaTela();

    }

    public void inicializaTela(){
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

        atualizaTabela();



    }

    public void atualizaTabela(){
        //converte a lista de Cliente na lista  (obsLista).
        obsLista = FXCollections.observableList(listaCliente);
        //adiciona a lista na tabela
        tabelaCliente.setItems(obsLista);
        inicalizaBotaoEditar();
        inicalizaBotaoRemover();
    }

    private void inicalizaBotaoRemover() {
        tableColumnRemover.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnRemover.setCellFactory(param -> new TableCell<Cliente,Cliente>(){
            
            private final Button botao = new Button("remover");
            
            @Override
            protected void updateItem(Cliente obj, boolean vazio){
                super.updateItem(obj,vazio);
                if(obj == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(botao);
                botao.setOnAction(event -> removeCliente(obj));
            }
        });
        
    }

    private void removeCliente(Cliente obj) {
        Optional<ButtonType> resultado = Notificacao.mostrarConfirmacao("Confirmação",
                "Você tem certeza que deseja remover o Cliente ?");

        if(resultado.get() == ButtonType.OK){
            listaCliente.remove(obj);
            atualizaTabela();
        }
    }

    private void inicalizaBotaoEditar() {
        tableColumnEditar.setCellValueFactory( param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnEditar.setCellFactory(param -> new TableCell<Cliente,Cliente>(){
            private final Button botao = new Button("editar");

            @Override
            protected void updateItem(Cliente obj, boolean vazio){
                super.updateItem(obj,vazio);
                if(obj == null){
                    setGraphic(null);
                    return;
                }
                setGraphic(botao);
                botao.setOnAction(event -> editarCliente(obj));

            }
        });
    }

    private void editarCliente(Cliente obj) {
        campoNome.setText(obj.getNome());
        campoCPF.setText(obj.getCpf());
        campoEmail.setText(obj.getEmail());
        campoEndereco.setText(obj.getEndereco());
        cliente = obj;
    }
}

