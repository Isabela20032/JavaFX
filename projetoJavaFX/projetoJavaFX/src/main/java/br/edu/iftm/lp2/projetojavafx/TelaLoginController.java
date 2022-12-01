package br.edu.iftm.lp2.projetojavafx;

import br.edu.iftm.lp2.projetojavafx.excecao.LoginFalhaException;
import br.edu.iftm.lp2.projetojavafx.excecao.LoginSucessoException;
import br.edu.iftm.lp2.projetojavafx.util.Notificacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class TelaLoginController {

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button botaoLogin;

    @FXML
    void fazerLogin(ActionEvent event) {
        try {
            String usario = campoUsuario.getText();
            String senha = campoSenha.getText();
            if(usario.equals("lp22022") && senha.equals("shrek")){
                App.setRaiz("TelaCadastroCliente.fxml", 580.0, 600.0);
                throw new LoginSucessoException();
            }else{
                throw new LoginFalhaException();
            }
        }catch (LoginSucessoException e){
            Notificacao.mostraNotificacao("Login Sucesso", "Login realizado com sucesso",
                    e.getMessage(), AlertType.INFORMATION);
        }catch (LoginFalhaException e){
            Notificacao.mostraNotificacao("Login Erro", "Login nao realizado",
                    e.getMessage(), AlertType.ERROR);
        }catch (IOException e){
            Notificacao.mostraNotificacao("ERRO", "Erro ao carregar a janela",
                    e.getMessage(), AlertType.ERROR);
        }

    }

}
