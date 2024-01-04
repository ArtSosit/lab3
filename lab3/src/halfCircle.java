import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class halfCircle extends JFrame {

    public halfCircle() {
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

    }

    public static void main(String[] args) {
        halfCircle Fm = new halfCircle();
        MidpointCircle Mpc = new MidpointCircle();
        Fm.add(Mpc);
        Fm.setVisible(true);
    }
}

class MidpointCircle extends JPanel {
    public MidpointCircle() {
        setSize(700, 700);
        setLayout(null);
    }

    public void paint(Graphics g) {

        MidpointCircle(g, 200, 200, 200, 200, 140);
    }

    void plotQ(Graphics g, int x, int y, int xcenter, int ycenter, int xc, int yc) {
        // g.fillOval(xcenter + (xc + x), ycenter + (yc + y), 5, 5);

        // g.fillOval(xcenter + (xc + y), ycenter + (yc + x), 5, 5);

        g.fillOval(xcenter + (xc + y), ycenter + (yc - x), 5, 5);

        g.fillOval(xcenter + (xc + x), ycenter + (yc - y), 5, 5);

        g.fillOval(xcenter + (xc - x), ycenter + (yc - y), 5, 5);

        g.fillOval(xcenter + (xc - y), ycenter + (yc - x), 5, 5);

        // g.fillOval(xcenter + (xc - y), ycenter + (yc + x), 5, 5);

        // g.fillOval(xcenter + (xc - x), ycenter + (yc + y), 5, 5);
    }

    void MidpointCircle(Graphics g, int xcenter, int ycenter, int r, int xc, int yc) {
        int x = 0;
        int y = r;
        int p = 1 - r;

        g.setColor(Color.green);
        plotQ(g, x, y, xcenter, ycenter, xc, yc);

        while (x <= y) {
            x = x + 1;
            if (p < 0) {
                p = p + 2 * x + 1;
            } else {
                y = y - 1;
                p = p + 2 * x + 1 - 2 * y;
            }
            plotQ(g, x, y, xcenter, ycenter, xc, yc);
        }
    }
}
