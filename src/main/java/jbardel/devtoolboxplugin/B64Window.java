package jbardel.devtoolboxplugin;

import java.util.function.Function;
import javax.swing.*;

public class B64Window {
    private JPanel panel1;
    private JTextArea sourceTextArea;
    private JButton encodeButton;
    private JButton decodeButton;
    private JTextArea destTextArea;

    public B64Window(final Function<String, String> encodeAction, final Function<String, String> decodeAction) {

        encodeButton.addActionListener(e -> {
            destTextArea.setText(encodeAction.apply(sourceTextArea.getText()));
        });

        decodeButton.addActionListener(e -> {
            destTextArea.setText(decodeAction.apply(sourceTextArea.getText()));
        });

    }

    public JPanel getContent() {
        return panel1;
    }

}
