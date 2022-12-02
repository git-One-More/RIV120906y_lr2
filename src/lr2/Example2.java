package lr2;

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Example2 extends JDialog {

    static int v1=0;

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JLabel label2;
    private JButton следующаяЗадачаButton;

    public Example2() {
        label3.setText("Условие: Введите число которое делится на 5 с остатком 2 и на 7 с остатком 1");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        следующаяЗадачаButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onNext();
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
    private void onNext() {
        v1=1;
        this.setVisible(false);
        Example3.main(null);

    }
    private void onOK() {
        DecimalFormat df = new DecimalFormat("#.##");
        double b;
        b= Integer.parseInt(textField1.getText());
        if ((b%5==2&&b%7==1)^(b%5==-2&&b%7==-1)) {
            textField2.setText("Число соответствует условию. Результат: "+String.valueOf(b/5)+" и "+String.valueOf(df.format(b/7)));
        }
        else {textField2.setText("Число не соответствует условию");}
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {


        Example2 dialog = new Example2();
        dialog.pack();
        dialog.setTitle("Example2");
        dialog.setLocationRelativeTo(null);
        dialog.setSize(520,150);
        if (v1==1) {
            Example1.main(null);
            dialog.setVisible(false);
        }
        else {
            dialog.setVisible(true);
        }
    }
}
