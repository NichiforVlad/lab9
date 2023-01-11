
package pb9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Problema9 extends JPanel {
    private Desen9 canvas;
    private JButton infasoara;
    private JButton play;
    private AscultatorButon ab;

    public Problema9() {
        this.setLayout(new BorderLayout());
        this.ab = new AscultatorButon();
        JPanel var1 = new JPanel(new GridLayout(2, 1));
        this.infasoara = new JButton("Infasoara");
        this.infasoara.addActionListener(this.ab);
        var1.add(this.infasoara);
        this.play = new JButton("Play");
        this.play.addActionListener(this.ab);
        var1.add(this.play);
        this.play.setVisible(false);
        this.canvas = new Desen9();
        JPanel var2 = new JPanel();
        var2.add(var1);
        this.add(var2, "West");
        this.add(this.canvas, "Center");
    }

    public class AscultatorButon implements ActionListener {
        public AscultatorButon() {
        }

        public void actionPerformed(ActionEvent var1) {
            if (var1.getSource() == Problema9.this.infasoara) {
                Problema9.this.canvas.setStare(1);
                System.out.println("AM apasat!");
                Problema9.this.infasoara.setEnabled(false);
            } else if (var1.getSource() == Problema9.this.play) {
            }

        }
    }
}
