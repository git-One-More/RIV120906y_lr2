package lr2;

import javax.swing.*;
import java.awt.event.*;

public class Example3 extends JDialog {
    static int v2=0;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label3;
    private JLabel label2;
    private JButton следующаяЗадачаButton;

    public Example3() {
        label3.setText("Введите число которое делится на 4 и не меньше 10 ");
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

    private void onOK() {
        int c;
        c= Integer.parseInt(textField1.getText());
        if (c%4==0&&c>=10) {
            textField2.setText("Число соответсвует условию. Результат: "+String.valueOf(c/4));
        }
        else {textField2.setText("Число не соответсвует условию");}
    }

    private void onNext() {
        v2=1;
        this.setVisible(false);
        Example4.main(null);
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {

        Example3 dialog = new Example3();
        dialog.pack();
        dialog.setTitle("Example3");
        dialog.setLocationRelativeTo(null);
        dialog.setSize(500,150);
        if (Example3.v2==1) {
            Example2.main(null);
            dialog.setVisible(false);
        }
        else {
            dialog.setVisible(true);
        }

    }
}
