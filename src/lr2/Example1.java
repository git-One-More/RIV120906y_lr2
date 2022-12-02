package lr2;

import javax.swing.*;
import java.awt.event.*;

public class Example1 extends JDialog {
   static int v=0;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label1;
    private JLabel label2;
    private JButton следующаяЗадачаButton;

    public Example1() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        label3.setText("Условие: Введите число которое делится на 3 без остатка");
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
    contentPane.addComponentListener(new ComponentAdapter() { } );}


    private void onNext() {
        v=1;
        this.setVisible(false);
        Example2.main(null);

    }

    private void onOK() {
       int a;
     a= Integer.parseInt(textField1.getText());
     if (a%3==0) {
         textField2.setText("Число соответсвует условию. Результат: "+String.valueOf(a/3));
     }
     else {textField2.setText("Число не соответсвует условию");}
    }



    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Example1 dialog = new Example1();
        dialog.pack();
        dialog.setTitle("Example1");
        dialog.setLocationRelativeTo(null);
        dialog.setSize(520,150);
        if (Example1.v==1) {
    dialog.setVisible(false);
        }
        else {
            dialog.setVisible(true);
        }

    }
}
