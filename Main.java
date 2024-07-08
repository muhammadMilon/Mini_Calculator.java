import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(415, 490);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        JTextField textField = new JTextField();
        textField.setBounds(10, 10, 380, 80);
        Font myFont = new Font("Ink Free", Font.BOLD, 30);
        textField.setFont(myFont);
        textField.setEditable(true);
        textField.setBackground(Color.CYAN);
        textField.setForeground(Color.BLACK);

        frame.add(textField);
        frame.setVisible(true);

        new Calculator(frame, textField, myFont);
    }
}
