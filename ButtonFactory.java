import javax.swing.*;

public class ButtonFactory extends JFrame {

    public JButton CreateButton(String buttonName) {
        JButton Button = new JButton(buttonName);
        return Button;
    }

    public JLabel CreateJLabel(String JLabelName) {
        JLabel jLabel = new JLabel(JLabelName);
        return jLabel;
    }

}
