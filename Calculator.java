import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[11];
    JButton addButton, subButton, mulButton, divButton;
    JButton pointButton, eqButton, delButton, clrButton;
    JButton orButton, andButton, notButton;

    Font myFont;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator(JFrame frame, JTextField textField, Font myFont) {
        this.frame = frame;
        this.textField = textField;
        this.myFont = myFont;

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        pointButton = new JButton(".");
        eqButton = new JButton("=");
        notButton = new JButton("NOT");
        orButton = new JButton("OR");
        andButton = new JButton("AND");
        clrButton = new JButton("CLR");
        delButton = new JButton("Backspace");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = pointButton;
        functionButtons[5] = eqButton;
        functionButtons[6] = notButton;
        functionButtons[7] = orButton;
        functionButtons[8] = andButton;
        functionButtons[9] = clrButton;
        functionButtons[10] = delButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].setFont(myFont);
            functionButtons[i].addActionListener(this);
            frame.add(functionButtons[i]);
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].addActionListener(this);
            frame.add(numberButtons[i]);
        }

        // Positioning the buttons on the frame
        int x = 10;
        int y = 100;
        for (int i = 1; i < numberButtons.length; i++) {
            numberButtons[i].setBounds(x, y, 60, 60);
            x += 70;
            if (i % 3 == 0) {
                x = 10;
                y += 70;
            }
        }
        numberButtons[0].setBounds(10, 310, 60, 60);
        pointButton.setBounds(80, 310, 60, 60);
        eqButton.setBounds(150, 310, 60, 60);
        addButton.setBounds(220, 100, 60, 60);
        subButton.setBounds(220, 170, 60, 60);
        mulButton.setBounds(220, 240, 60, 60);
        divButton.setBounds(220, 310, 60, 60);
        notButton.setBounds(290, 100, 100, 60);
        orButton.setBounds(290, 240, 100, 60);
        andButton.setBounds(290, 170, 100, 60);
        clrButton.setBounds(290, 310, 100, 60);
        delButton.setBounds(10, 380, 380, 60);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == pointButton) {
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }

        // Arithmetic operations handling
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '×';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '÷';
            textField.setText("");
        }

        // Logical operations handling
        if (e.getSource() == orButton) {
            num1 = Integer.parseInt(textField.getText());
            operator = '|';
            textField.setText("");
        }

        if (e.getSource() == andButton) {
            num1 = Integer.parseInt(textField.getText());
            operator = '&';
            textField.setText("");
        }

        if (e.getSource() == notButton) {
            num1 = Integer.parseInt(textField.getText());
            operator = '~';
            result = ~((int) num1);
            textField.setText(String.valueOf(result));
        }

        // Equal button handling
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '×':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
                case '|':
                    result = (int) num1 | (int) num2;
                    break;
                case '&':
                    result = (int) num1 & (int) num2;
                    break;
                default:
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        // Clear button handling
        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        // Backspace button handling
        if (e.getSource() == delButton) {
            String text = textField.getText();
            textField.setText(text.length() > 0 ? text.substring(0, text.length() - 1) : "");
        }
    }
}
