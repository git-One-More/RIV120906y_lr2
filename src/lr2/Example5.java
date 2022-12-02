package lr2;

import javax.swing.*;
import java.awt.event.*;

public class Example5 extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JLabel label2;


    public Example5() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        label3.setText("Условие: Сколько тысяч в числе");
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    private void onOK() {
        int n;
        String l="";
        n= Integer.parseInt(textField1.getText());
        int length = (int)(Math.log10(n)+1);
        n = n / 1000;
        if (n%10==1&&(n<=10^n>=20))
        {
            l="а";
        }
        if (n%10>=2&&n%10<5&&(n<=10^n>=20))
        {
            l="и";
        }
        if (length>=4) {
            textField2.setText("Число соответсвует условию. В числе сожержится "+String.valueOf(n)+" тысяч"+l);
        }
        else {textField2.setText("Число не соответсвует условию.");}
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();

    }
    public static void main(String[] args) {
        Example5 dialog = new Example5();
        dialog.pack();
        dialog.setTitle("Example5");
        dialog.setLocationRelativeTo(null);
        dialog.setSize(520, 150);
        dialog.setVisible(true);
    }
}
