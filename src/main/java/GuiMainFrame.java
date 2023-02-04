import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GuiMainFrame {
    JLabel label1, label2;
    JTextField text1;
    JButton button1, button2;
    JComboBox<String> list1;
    JFileChooser file1;

    eHandler handler = new eHandler();

    public GuiMainFrame() {

        JFrame frame = new JFrame("Excel price editor v 0.3");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();

        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);

        Font font = new Font("TimesNewRoman", Font.BOLD, 16);
        Font font2 = new Font("TimesNewRoman", Font.PLAIN, 14);
        label1 = new JLabel("Excel price editor");
        label1.setFont(font);
        label2 = new JLabel("Укажите путь к файлу Excel для его изменения:");
        label2.setFont(font2);
        button1 = new JButton("Выбрать файл...");
        button1.setToolTipText("Нажмите, чтобы выбрать редактируемый файл");
        button2 = new JButton("ВЫПОЛНИТЬ ИЗМЕНЕНИЕ ФАЙЛА");
        button2.setToolTipText("Нажмите, чтобы изменить цены в выбранном прайсе на указанную величину");
        String[] actionList = new String[]{"Умножить цены прайса на ", "Разделить цены прайса на ", "Увеличить цены прайса на % ", "Уменьшить цены прайса на % "};
        list1 = new JComboBox<>(actionList);
        list1.setToolTipText("Нажмите, чтобы выбрать тип изменения цен");
        text1 = new JTextField(24);
        text1.setToolTipText("Введите сюда коэффициент изменения цен");
        file1 = new JFileChooser();


        container.add(label1);
        container.add(label2);
        container.add(button1);
        container.add(list1);
        container.add(text1);
        container.add(button2);
        button2.addActionListener(handler);
        button1.addActionListener(handler);

        layout.putConstraint(SpringLayout.WEST, label1, 225, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, label1, 25, SpringLayout.NORTH, container);

        layout.putConstraint(SpringLayout.WEST, label2, 30, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, label2, 85, SpringLayout.NORTH, container);

        layout.putConstraint(SpringLayout.WEST, button1, 375, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, button1, 75, SpringLayout.NORTH, container);

        layout.putConstraint(SpringLayout.WEST, list1, 30, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, list1, 155, SpringLayout.NORTH, container);

        layout.putConstraint(SpringLayout.WEST, text1, 245, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, text1, 160, SpringLayout.NORTH, container);

        layout.putConstraint(SpringLayout.WEST, button2, 175, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, button2, 280, SpringLayout.NORTH, container);

        frame.setSize(570, 400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        text1.requestFocusInWindow();
    }

    class eHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ExcelPriceExchanger excelPriceExchanger = new ExcelPriceExchanger();
            String inputNumber = text1.getText();
            if (e.getSource() == button2) {
                boolean isChanged = false;
                if (text1.getText().contains(",")) {
                    inputNumber = text1.getText().replace(",", ".");
                }
                if (Objects.equals(validateNumbers(inputNumber), "isBlank")) {
                    ErrorDialogIsBlank errorDialog = new ErrorDialogIsBlank();
                    errorDialog.createDialog(true);
                } else if (Objects.equals(validateNumbers(inputNumber), "notNumber")) {
                    ErrorDialogNotNumber errorDialog = new ErrorDialogNotNumber();
                    errorDialog.createDialog(true);
                }
                if (list1.getSelectedItem() == "Умножить цены прайса на ") {
                    if (Objects.equals(validateNumbers(inputNumber), "Integer")) {
                        try {
                            excelPriceExchanger.priceMultiplication(Integer.parseInt(inputNumber), file1.getSelectedFile());
                            isChanged = true;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (Objects.equals(validateNumbers(inputNumber), "Double")) {
                        try {
                            excelPriceExchanger.priceMultiplication(Double.parseDouble(inputNumber), file1.getSelectedFile());
                            isChanged = true;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                if (list1.getSelectedItem() == "Разделить цены прайса на ") {
                    if (Objects.equals(validateNumbers(inputNumber), "Integer")) {
                        try {
                            excelPriceExchanger.priceDivider(Integer.parseInt(inputNumber), file1.getSelectedFile());
                            isChanged = true;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (Objects.equals(validateNumbers(inputNumber), "Double")) {
                        try {
                            excelPriceExchanger.priceDivider(Double.parseDouble(inputNumber), file1.getSelectedFile());
                            isChanged = true;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                if (list1.getSelectedItem() == "Увеличить цены прайса на % ") {
                    if (Objects.equals(validateNumbers(inputNumber), "Integer")) {
                        try {
                            excelPriceExchanger.pricePercentAugment(Integer.parseInt(inputNumber), file1.getSelectedFile());
                            isChanged = true;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (Objects.equals(validateNumbers(inputNumber), "Double")) {
                        try {
                            excelPriceExchanger.pricePercentAugment(Double.parseDouble(inputNumber), file1.getSelectedFile());
                            isChanged = true;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                if (list1.getSelectedItem() == "Уменьшить цены прайса на % ") {
                    if (Objects.equals(validateNumbers(inputNumber), "Integer")) {
                        try {
                            excelPriceExchanger.pricePercentMinus(Integer.parseInt(inputNumber), file1.getSelectedFile());
                            isChanged = true;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (Objects.equals(validateNumbers(inputNumber), "Double")) {
                        try {
                            excelPriceExchanger.pricePercentMinus(Double.parseDouble(inputNumber), file1.getSelectedFile());
                            isChanged = true;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                if (isChanged) {
                    DialogSuccess dialogSuccess = new DialogSuccess();
                    dialogSuccess.createDialog(true);
                }
            }


            if (e.getSource() == button1) {
                file1.setDialogTitle("Выбор директории");
                int ret = file1.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = file1.getSelectedFile();
                }
            }
        }

    }

    String validateNumbers(String inputNumber) {
        if (inputNumber.isBlank()) {
            return "isBlank";
        } else {
            try {
                Integer.parseInt(inputNumber);
                return "Integer";
            } catch (NumberFormatException formatException) {
                try {
                    Double.parseDouble(inputNumber);
                    return "Double";
                } catch (NumberFormatException formatException2) {
                    return "notNumber";
                }
            }
        }
    }
}