package currencyconvert;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class convert extends JFrame {

private JPanel contentPane;
private final ButtonGroup buttonGroup = new ButtonGroup();


public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                convert frame = new convert();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}


public convert() {

    setTitle("Currency Converter");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(70, 33, 385, 272);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JTextPane txtnumIn = new JTextPane();
    txtnumIn.setBounds(90, 46, 124, 26);
    contentPane.add(txtnumIn);

    JRadioButton celRadio = new JRadioButton("USD");
    buttonGroup.add(celRadio);
    celRadio.setBounds(221, 42, 67, 26);
    contentPane.add(celRadio);

    JRadioButton fahrenRadio = new JRadioButton("INR");
    buttonGroup.add(fahrenRadio);
    fahrenRadio.setBounds(221, 64, 85, 24);
    contentPane.add(fahrenRadio);

    

    JTextPane numOutput = new JTextPane();
    numOutput.setBackground(UIManager.getColor("Button.background"));
    numOutput.setEditable(false);
    numOutput.setBounds(111, 138, 290, 22);
    contentPane.add(numOutput);

    JButton btnNewButton = new JButton("Convert");
    btnNewButton.setBounds(110, 104, 98, 26);
    contentPane.add(btnNewButton);
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {

            if(celRadio.isSelected()){
                try{
                    double num=Double.parseDouble(txtnumIn.getText());
                    num = num * 82.59;
                    numOutput.setText(Double.toString(num)+" INR");
                }catch(Exception e){
                    numOutput.setText("Please enter a valid number.");
                }
            }else{
                try{
                    double num=Double.parseDouble(txtnumIn.getText());
                    num = num *0.0121074;
                    numOutput.setText(Double.toString(num)+" USD");
                }catch(Exception e){
                    numOutput.setText("Please enter a valid number.");
                }
            }
        }
    });
}
}
