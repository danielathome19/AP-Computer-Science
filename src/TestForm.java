import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestForm {
    private JPanel panel1;
    private JButton calculateButton;
    private JTextField txtlen;
    private JTextField txtwid;
    private JLabel lblarea;
    private JLabel lblperim;

    public TestForm() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int len = Integer.parseInt(txtlen.getText());
                int wid = Integer.parseInt(txtwid.getText());
                int area = len * wid;
                int perim = 2 * len + 2 * wid;
                lblarea.setText("Area: " + area);
                lblperim.setText("Perimeter: " + perim);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lang52a");
        frame.setContentPane(new TestForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
