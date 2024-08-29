package Q3.Prog52aForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prog52aForm {
    private JTextField txtLen;
    private JTextField txtWid;
    private JButton btnClear;
    private JButton btnCalc;
    private JLabel lblArea;
    private JLabel lblPerim;
    private JPanel mainPanel;

    public Prog52aForm() {
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int len = Integer.parseInt(txtLen.getText());
                int wid = Integer.parseInt(txtWid.getText());
                int area = len * wid;
                int perim = 2 * len + 2 * wid;
                lblArea.setText("" + area);
                lblPerim.setText("" + perim);
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtLen.setText("");
                txtWid.setText("");
                lblArea.setText("");
                lblPerim.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Prog52a");
        frame.setContentPane(new Prog52aForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
