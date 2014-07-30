package martyisawesome;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Drawing class
 *
 * @author Marty
 */
public class Panel extends JPanel {

    private double MinRe = -2.0;
    private double MaxRe = 1.0;
    private double MinIm = -1.2;
    private double MaxIm = MinIm + (((MaxRe - MinRe) * Frame.HEIGHT) / Frame.WIDTH);
    private double Re_factor = (MaxRe - MinRe) / (Frame.WIDTH - 1);
    private double Im_factor = (MaxIm - MinIm) / (Frame.HEIGHT - 1);
    private int MaxIterations = 50;

    public void paint(Graphics g) {
        super.paint(g);

        MaxIm = MinIm + (((MaxRe - MinRe) * Frame.HEIGHT) / Frame.WIDTH);
        Re_factor = (MaxRe - MinRe) / (Frame.WIDTH - 1);
        Im_factor = (MaxIm - MinIm) / (Frame.HEIGHT - 1);

        System.out.println("Max re is " + MaxRe);

        for(int y = 0; y < Frame.HEIGHT; y++) {
            double c_im = MaxIm - y * Im_factor;

            for(int x = 0; x < Frame.WIDTH; x++) {
                double c_re = MinRe + x * Re_factor;

                double Z_re = c_re, Z_im = c_im;
                boolean isInside = true;
                for(int n = 0; n < MaxIterations; n++)
                {
                    double Z_re2 = Z_re*Z_re, Z_im2 = Z_im*Z_im;
                    if(Z_re2 + Z_im2 > 4)
                    {
                        isInside = false;
                        g.setColor(n < MaxIterations / 2 ?
                                new Color((n  / 2) * 10,
                                           0,
                                         ((MaxIterations / 2) - n) * 10) :
                                new Color(0,
                                        ((MaxIterations - n) * 10),
                                         (n - (MaxIterations / 2)) * 10));

                        /**
                         * n = 0, red
                         * n = maxiterations / 2, green
                         * n = maxiterations, blue
                         */
                        g.drawRect(x, y, 1, 1);
                        break;
                    }
                    Z_im = 2*Z_re*Z_im + c_im;
                    Z_re = Z_re2 - Z_im2 + c_re;
                }

                if(isInside) {
                    g.setColor(Color.black);
                    g.drawRect(x, y, 1, 1);
                }
            }
        }
        System.out.println("Repainted ");

    }

    public void setMinRealVal(double newMinReal) {
        this.MinRe = newMinReal;
    }

    public void setMaxRealVal(double newMaxReal) {
        this.MaxRe = newMaxReal;
    }



}
