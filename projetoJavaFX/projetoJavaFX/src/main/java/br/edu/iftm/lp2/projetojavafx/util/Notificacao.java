package br.edu.iftm.lp2.projetojavafx.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Notificacao {

    public static void mostraNotificacao(String titulo, String cabecalho, String mensagem, AlertType tipo){
        //objeto que representa a janela de notificacao
        Alert notificacao = new Alert(tipo);
        //adiciona o titulo da janela
        notificacao.setTitle(titulo);
        //adiciona o cabeçalho da janela (javafx obriga essa configuração)
        notificacao.setHeaderText(cabecalho);
        //adiciona a mensagem que será mostrada na janela
        notificacao.setContentText(mensagem);
        //abre a janela de notificação
        notificacao.show();
    }

    public static Optional<ButtonType> mostrarConfirmacao(String titulo, String mensagem){
        Alert confirmacao = new Alert(AlertType.CONFIRMATION);
        confirmacao.setTitle(titulo);
        confirmacao.setHeaderText(null);
        confirmacao.setContentText(mensagem);
        return confirmacao.showAndWait();
    }
}
