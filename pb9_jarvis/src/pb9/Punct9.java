
package pb9;

public class Punct9 implements Comparable {
    private double x;
    private double y;

    public Punct9(double var1, double var3) {
        this.x = var1;
        this.y = var3;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(int var1) {
        this.x = (double)var1;
    }

    public void setY(int var1) {
        this.y = (double)var1;
    }

    public int compareTo(Object var1) {
        if (((Punct9)var1).getX() < this.getX()) {
            return 255;
        } else if (((Punct9)var1).getX() > this.getX()) {
            return -256;
        } else if (((Punct9)var1).getX() == this.getX() && this.y > ((Punct9)var1).getY()) {
            return -255;
        } else {
            return ((Punct9)var1).getX() == this.getX() && this.y < ((Punct9)var1).getY() ? 256 : 0;
        }
    }

    public String toString() {
        return this.x + " " + this.y;
    }
}

