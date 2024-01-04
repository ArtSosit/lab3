import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class six extends JFrame {

    public six() {
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

    }

    public static void main(String[] args) {
        six Fm = new six();
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

        MidpointCircle(g, 320, 100, 10, 20, 0);
        MidpointCircle(g, 320, 100, 30, 20, 0);
        MidpointCircle(g, 320, 100, 50, 20, 0);
        MidpointCircle(g, 320, 100, 70, 20, 0);
        MidpointCircle(g, 320, 100, 90, 20, 0);

        MidpointCircle(g, 150, 300, 10, 20, 0);
        MidpointCircle(g, 150, 300, 30, 20, 0);
        MidpointCircle(g, 150, 300, 50, 20, 0);
        MidpointCircle(g, 150, 300, 70, 20, 0);
        MidpointCircle(g, 150, 300, 90, 20, 0);

        MidpointCircle(g, 450, 300, 10, 20, 0);
        MidpointCircle(g, 450, 300, 30, 20, 0);
        MidpointCircle(g, 450, 300, 50, 20, 0);
        MidpointCircle(g, 450, 300, 70, 20, 0);
        MidpointCircle(g, 450, 300, 90, 20, 0);

        Draww(170, 300, 470, 300, g);
        Draww(170, 300, 340, 100, g);
        Draww(340, 100, 470, 300, g);
    }

    void plotQ(Graphics g, int x, int y, int xcenter, int ycenter, int xc, int yc) {
        g.fillOval(xcenter + (xc + x), ycenter + (yc + y), 5, 5);

        g.fillOval(xcenter + (xc + y), ycenter + (yc + x), 5, 5);

        g.fillOval(xcenter + (xc + y), ycenter + (yc - x), 5, 5);

        g.fillOval(xcenter + (xc + x), ycenter + (yc - y), 5, 5);

        g.fillOval(xcenter + (xc - x), ycenter + (yc - y), 5, 5);

        g.fillOval(xcenter + (xc - y), ycenter + (yc - x), 5, 5);

        g.fillOval(xcenter + (xc - y), ycenter + (yc + x), 5, 5);

        g.fillOval(xcenter + (xc - x), ycenter + (yc + y), 5, 5);
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

    void Draww(int x1, int y1, int x2, int y2, Graphics g) {
        int x, y, dx, dy, p;
        x = x1;
        y = y1;
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);
        int dx1 = (x2 - x1 >= 0) ? 1 : -1; // Direction for x
        int dy1 = (y2 - y1 >= 0) ? 1 : -1; // Direction for y
        int p1;

        g.setColor(Color.red);
        g.drawOval(x, y, 5, 5);

        if (dx >= dy) {
            p = 2 * dy - dx;
            p1 = 2 * dy;
            int p2 = 2 * (dy - dx);
            while (x != x2) {
                x += dx1;
                if (p < 0) {
                    p += p1;
                } else {
                    y += dy1;
                    p += p2;
                }
                g.drawOval(x, y, 5, 5);
            }
        } else {
            p = 2 * dx - dy;
            p1 = 2 * dx;
            int p2 = 2 * (dx - dy);
            while (y != y2) {
                y += dy1;
                if (p < 0) {
                    p += p1;
                } else {
                    x += dx1;
                    p += p2;
                }
                g.drawOval(x, y, 5, 5);
            }
        }
    }

}
