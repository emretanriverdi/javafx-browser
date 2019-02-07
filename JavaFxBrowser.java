import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import java.awt.*;
import static javax.swing.SwingUtilities.*;

public class JavaFxBrowser implements Runnable {
    private WebEngine webEngine;

    public static void main(String[] args) {
        invokeLater(new JavaFxBrowser());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1024, 768));

        JFXPanel jfxPanel = new JFXPanel();
        frame.getContentPane().add(jfxPanel);
        frame.pack();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebView view = new WebView();
                webEngine = view.getEngine();

                jfxPanel.setScene(new Scene(view));
                webEngine.load("http://google.com.tr");
            }
        });
    }
}