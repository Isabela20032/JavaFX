package br.edu.iftm.lp2.projetojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene tela;

    @Override
    public void start(Stage palco) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
        Parent raiz = fxmlLoader.load();
        tela = new Scene(raiz);

        palco.setTitle("Tela de Login");
        palco.setScene(tela);
        palco.show();




        /*palco.setTitle("Minha primeira janela");

        Button botao = new Button("Clique aqui");
        botao.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("você clicou no botao.");
            }
        });

        StackPane painel = new StackPane();
        //adionando o botao no painel
        painel.getChildren().add(botao);
        Scene cena = new Scene(painel, 300, 250);
        palco.setScene(cena);
        palco.show();*/
    }

    public static void setRaiz(String fxml, double altura, double largura) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        //altera a altura da janela
        tela.getWindow().setHeight(altura);
        tela.getWindow().setWidth(largura);
        tela.setRoot(fxmlLoader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}