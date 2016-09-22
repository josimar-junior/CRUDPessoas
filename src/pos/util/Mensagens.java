/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.util;

import javafx.scene.control.Alert;

/**
 *
 * @author Junior
 */
public class Mensagens {
    
    public static void mensagemInformacao(String cabecalho) {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Informação do Sistema");
            dialogoInfo.setHeaderText(cabecalho);
            dialogoInfo.show();
    }
    
    public static void mensagemAlerta(String cabecalho) {
            Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
            dialogoInfo.setTitle("Alerta do Sistema");
            dialogoInfo.setHeaderText(cabecalho);
            dialogoInfo.show();
    }
    
    public static void mensagemErro(String cabecalho) {
            Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
            dialogoInfo.setTitle("Erro do Sistema");
            dialogoInfo.setHeaderText(cabecalho);
            dialogoInfo.show();
    }
}
