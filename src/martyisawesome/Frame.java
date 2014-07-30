package martyisawesome;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Marty
 */
public class Frame extends JFrame {

    public static int
            WIDTH = 1000,
            HEIGHT = 700 + 60;

    private Panel panel;
    private JSlider minRe, maxRe;

    public Frame() {
        super("Fractals!");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        panel = new Panel();

        c.add(panel);

        minRe = new JSlider(-2, 5, -2);
        maxRe = new JSlider(-2, 5, 1);

        minRe.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                panel.setMinRealVal(minRe.getValue());
                repaint();
                System.out.println("New minRe value is " + minRe.getValue());
            }
        });

        maxRe.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                panel.setMaxRealVal(maxRe.getValue());
                repaint();
                System.out.println("New maxRe value is " + maxRe.getValue());

            }
        });


        c.add(minRe);
        c.add(maxRe);


        setVisible(true);
    }

    //main
    public static void main(String[] args) {
        new Frame();

    }



}
