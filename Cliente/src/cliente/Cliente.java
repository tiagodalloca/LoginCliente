/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author u15194
 */
public class Cliente extends Application {
    
    static String[] opts = new String[] { "java.version", "java.vendor",
            "java.vendor.url", "java.home", "java.vm.specification.version",
            "java.vm.specification.vendor", "java.vm.specification.name",
            "java.vm.version", "java.vm.vendor", "java.vm.name",
            "java.specification.version", "java.specification.vendor",
            "java.specification.name", "java.class.version", "java.class.path",
            "java.library.path", "java.io.tmpdir", "java.compiler",
            "java.ext.dirs", "os.name", "os.arch", "os.version",
            "file.separator", "path.separator", "line.separator", "user.name",
            "user.home", "user.dir" };
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for(String o : opts) {
            System.out.println(o + ": " + System.getProperty(o));
        }
        
        launch(args);
    }
    
}
