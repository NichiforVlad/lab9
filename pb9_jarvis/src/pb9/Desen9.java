
package pb9;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Desen9 extends Canvas {
    private ArrayList puncte = new ArrayList();
    private ArrayList frontiera = new ArrayList();
    private Vector x = new Vector();
    private Vector y = new Vector();
    private boolean potIntroducePuncte = true;
    private int stare = 0;

    public Desen9() {
        this.setSize(500, 500);
        this.enableEvents(500L);
    }

    public void paint(Graphics var1) {
        var1.setColor(Color.BLACK);
        var1.drawLine(0, 0, 500, 0);
        var1.drawLine(0, 0, 0, 500);
        var1.drawLine(500, 0, 500, 500);
        var1.drawLine(0, 500, 500, 500);
        var1.drawLine(this.calcX(-20.0), this.calcY(0.0), this.calcX(20.0), this.calcY(0.0));
        var1.drawString("x", this.calcX(21.0), this.calcY(-1.0));
        var1.drawLine(this.calcX(20.0) - 3, this.calcY(0.0) - 3, this.calcX(20.0), this.calcY(0.0));
        var1.drawLine(this.calcX(20.0) - 3, this.calcY(0.0) + 3, this.calcX(20.0), this.calcY(0.0));
        var1.drawLine(this.calcX(0.0), this.calcY(-20.0), this.calcX(0.0), this.calcY(20.0));
        var1.drawString("y", this.calcX(-1.0), this.calcY(21.0));
        var1.drawLine(this.calcX(0.0) + 3, this.calcY(20.0) + 3, this.calcX(0.0), this.calcY(20.0));
        var1.drawLine(this.calcX(0.0) - 3, this.calcY(20.0) + 3, this.calcX(0.0), this.calcY(20.0));
        Iterator var2 = this.puncte.iterator();

        while(var2.hasNext()) {
            Punct9 var3 = (Punct9)var2.next();
            var1.fillOval(this.calcX(var3.getX()) - 2, this.calcY(var3.getY()) - 2, 4, 4);
        }

        if (this.stare == 1 && this.puncte.size() >= 3) {
            Algoritm9 var8 = new Algoritm9(this.puncte);
            var8.algoritm();
            ArrayList var4 = var8.getListaNord();
            int var5 = 0;

            for(int var6 = 0; var6 < var4.size() - 1; ++var6) {
                var1.drawLine(this.calcX(((Punct9)var4.get(var6)).getX()), this.calcY(((Punct9)var4.get(var6)).getY()), this.calcX(((Punct9)var4.get(var6 + 1)).getX()), this.calcY(((Punct9)var4.get(var6 + 1)).getY()));
                var1.drawString("" + var5++, this.calcX(((Punct9)var4.get(var6)).getX()) + 1, this.calcY(((Punct9)var4.get(var6)).getY()) + 1);
            }

            ArrayList var9 = var8.getListaSud();

            for(int var7 = 0; var7 < var9.size() - 1; ++var7) {
                var1.drawLine(this.calcX(((Punct9)var9.get(var7)).getX()), this.calcY(((Punct9)var9.get(var7)).getY()), this.calcX(((Punct9)var9.get(var7 + 1)).getX()), this.calcY(((Punct9)var9.get(var7 + 1)).getY()));
                var1.drawString("" + var5++, this.calcX(((Punct9)var9.get(var7 + 1)).getX()) + 1, this.calcY(((Punct9)var9.get(var7 + 1)).getY()) + 1);
            }
        }

    }

    public int calcX(double var1) {
        return (int)(250.0 + var1 * 10.0);
    }

    public int calcY(double var1) {
        return (int)(250.0 - var1 * 10.0);
    }

    public void setStare(int var1) {
        this.stare = var1;
    }

    public void processMouseEvent(MouseEvent var1) {
        if (var1.getID() == 500 && this.stare == 0) {
            double var2 = (double)(var1.getX() - 250) / 10.0;
            double var4 = (double)(250 - var1.getY()) / 10.0;
            Punct9 var6 = new Punct9(var2, var4);
            this.puncte.add(var6);
            this.repaint();
        }

        this.repaint();
    }
}
