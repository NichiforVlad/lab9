package pb9;

import java.util.ArrayList;
import java.util.TreeSet;

public class Algoritm9 {
    ArrayList puncte, puncte1, listanord, listasud;
    Punct9 a, b, c, d;

    public Algoritm9(ArrayList var1) {
        this.puncte = new ArrayList(var1);
        this.a = new Punct9(0.0, 0.0);
        this.b = new Punct9(0.0, 0.0);
        this.c = new Punct9(0.0, 0.0);
        this.d = new Punct9(0.0, 0.0);
        this.listanord = new ArrayList();
        this.listasud = new ArrayList();
    }

    private void sort() {
        TreeSet var1 = new TreeSet(this.puncte);
        this.puncte = new ArrayList(var1);
    }

    public void algoritm() {
        this.sort();
        System.out.println("!!! - toate punctele sortate dupa abscisa - !!!");

        for(int var1 = 0; var1 < this.puncte.size(); ++var1) {
            System.out.println(this.puncte.get(var1));
        }

        boolean[] var6 = new boolean[this.puncte.size()];
        if (this.puncte.size() != 0) {
            int var2 = 0;
            this.a = (Punct9)this.puncte.get(0);
            this.b = (Punct9)this.puncte.get(this.puncte.size() - 1);
            var6[0] = true;
            this.listanord.add(this.a);
            this.c = this.a;
            System.out.println("Lista Nord");

            while(true) {
                int var3;
                boolean var4;
                int var5;
                while(this.c.compareTo(this.b) != 0) {
                    for(var3 = var2 + 1; var3 < this.puncte.size(); ++var3) {
                        var4 = true;
                        this.c = (Punct9)this.puncte.get(var3);
                        var6[var3] = true;
                        var4 = true;

                        for(var5 = var2 + 1; var5 < this.puncte.size(); ++var5) {
                            this.d = (Punct9)this.puncte.get(var5);
                            if (!var6[var5] && this.det() > 0.0) {
                                var4 = false;
                                break;
                            }
                        }

                        if (var4) {
                            this.listanord.add(this.c);
                            this.a = this.c;

                            for(var5 = var2 + 1; var5 < var3; ++var5) {
                                var6[var5] = true;
                            }

                            var2 = var3;
                            break;
                        }

                        var6[var3] = false;
                    }
                }

                System.out.println("Lista Sud");
                var2 = 0;
                this.c = new Punct9(0.0, 0.0);
                this.d = new Punct9(0.0, 0.0);
                var6 = new boolean[this.puncte.size()];
                this.a = (Punct9)this.puncte.get(0);
                this.b = (Punct9)this.puncte.get(this.puncte.size() - 1);
                var6[0] = true;
                this.listasud.add(this.a);
                this.c = this.a;

                while(true) {
                    while(this.c.compareTo(this.b) != 0) {
                        for(var3 = var2 + 1; var3 < this.puncte.size(); ++var3) {
                            var4 = true;
                            this.c = (Punct9)this.puncte.get(var3);
                            var6[var3] = true;
                            var4 = true;

                            for(var5 = var2 + 1; var5 < this.puncte.size(); ++var5) {
                                this.d = (Punct9)this.puncte.get(var5);
                                if (!var6[var5] && this.det() < 0.0) {
                                    var4 = false;
                                    break;
                                }
                            }

                            if (var4) {
                                this.listasud.add(this.c);
                                this.a = this.c;

                                for(var5 = var2 + 1; var5 < var3; ++var5) {
                                    var6[var5] = true;
                                }

                                var2 = var3;
                                break;
                            }

                            var6[var3] = false;
                        }
                    }

                    return;
                }
            }
        }
    }

    public ArrayList getListaNord() {
        System.out.println(this.listanord.size() + " Dimensiunea listei de nord!");
        return this.listanord;
    }

    public double det() {
        return this.d.getX() * this.a.getY() + this.a.getX() * this.c.getY() + this.c.getX() * this.d.getY() - this.a.getY() * this.c.getX() - this.c.getY() * this.d.getX() - this.d.getY() * this.a.getX();
    }

    public ArrayList getListaSud() {
        System.out.println(this.listasud.size() + " Dimensiunea listei de sud!");
        return this.listasud;
    }
}
