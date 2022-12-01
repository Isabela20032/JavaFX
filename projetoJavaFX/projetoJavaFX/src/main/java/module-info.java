module br.edu.iftm.lp2.projetojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens br.edu.iftm.lp2.projetojavafx to javafx.fxml;
    exports br.edu.iftm.lp2.projetojavafx;
}