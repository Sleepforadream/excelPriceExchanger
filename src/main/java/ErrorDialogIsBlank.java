import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDialogIsBlank extends JFrame {

    JLabel label1;

    JButton button1;
    eHandler handler = new eHandler();

    public ErrorDialogIsBlank() {
        super("Ошибка");
        Container container = getContentPane();

        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setSize(350, 200);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);


        Font font = new Font("TimesNewRoman", Font.PLAIN, 14);
        //label1 = new JLabel("<html><div style='text-align: center;','line-height: 3.5;'>" + "Вы не ввели коэффициент изменения цен.<br>Пожалуйста, введите число" + "</div></html>");
        label1 = new JLabel("<html><div style='text-align: center;','line-height: 3.5;'>" + "Ну и какого х.я ты ничего не ввел/а?<br>Вводи в строку числовое значение" + "</div></html>");
        label1.setFont(font);

        label1.setLabelFor(button1);
        button1 = new JButton("ОК");
        button1.setSize(150, 150);
        Dimension dimension = new Dimension();
        dimension.setSize(75, 25);
        button1.setPreferredSize(dimension);
        container.add(label1);
        container.add(button1);
        button1.addActionListener(handler);
        label1.requestFocusInWindow();


        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label1, 0, SpringLayout.HORIZONTAL_CENTER, container);
        layout.putConstraint(SpringLayout.NORTH, label1, 30, SpringLayout.NORTH, container);

        layout.putConstraint(SpringLayout.WEST, button1, 130, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, button1, 110, SpringLayout.NORTH, container);
    }

    public JDialog createDialog(boolean modal) {
        return new JDialog(this, modal);
    }

    class eHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == button1) {
                dispose();
            }
        }
    }
}
