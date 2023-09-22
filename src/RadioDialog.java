import javax.swing.*;
import java.awt.*;

public class RadioDialog extends JFrame {
    static int width = 800;
    static int height = 600;
    static String[] resolutions = {"800x600", "1024x768", "1200x600", "1280x1024", "1680x1050", "1920x1080"};

    public RadioDialog() {
        super("RadioDialog");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(RadioDialog.width, RadioDialog.height));
        this.setLocation(d.width / 2 - RadioDialog.width / 2, d.height / 2 - RadioDialog.height / 2);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.okButtonText", "OK");

        ButtonGroup bg = new ButtonGroup();
        JRadioButton[] rba = new JRadioButton[RadioDialog.resolutions.length];
        for (int i = 0; i < RadioDialog.resolutions.length; i++) {
            rba[i] = new JRadioButton(RadioDialog.resolutions[i]);
            bg.add(rba[i]);
        }

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        JPanel panel = new JPanel(new GridBagLayout());
        for (int i = 0; i < rba.length; i ++) {
            constraints.gridy = i;
            panel.add(rba[i], constraints);
        }

        int result = JOptionPane.showConfirmDialog(null, panel, "Выбирете разрешение", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION && bg.getSelection() != null) {
            if (rba[0].isSelected()) {
                width = 800;
                height = 600;
            } else if (rba[1].isSelected()) {
                width = 1024;
                height = 768;
            } else if (rba[2].isSelected()) {
                width = 1200;
                height = 600;
            } else if (rba[3].isSelected()) {
                width = 1280;
                height = 1024;
            } else if (rba[4].isSelected()) {
                width = 1680;
                height = 1050;
            } else if (rba[5].isSelected()) {
                width = 1920;
                height = 1080;
            }
        }

        RadioDialog frame = new RadioDialog();
    }
}
