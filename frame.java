import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class frame extends JFrame{
    BufferedImage rest;
    ArrayList melody = new ArrayList<note>();
    public frame(){
        super();
        try{
            rest= ImageIO.read(new File("rest.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
        setSize(600,800);
        //buffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
        setUndecorated(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        //Thread t=new Thread(this);
        //t.start();
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 600, 800);
        g.setColor(Color.BLACK);
        int linespacing = 16;
        int barspacing = 150;
        int y = linespacing*2;
        int x = 0;
        for(int j=0; j < 6; j++){
            for(int i = 0; i < 5; i++){
                y = y+linespacing;
                g.drawLine(0, y, 600, y);
            }
            y = y + 30;
        } 
        for(int j=0; j < 6; j++){
            for(int i = 0; i < 5; i++){
                g.drawLine(x, j*(linespacing*5+30)+(linespacing*3), x, j*(linespacing*5+30)+(linespacing*7));
                x = x+barspacing;
            }
            x = 0;
        } 
        //quarterRest(g);
        whole(g, 'c');
    }

    public int noteNum(char note) {
        int num = (int)note-99;
        return -num;
    }

    public void whole(Graphics g, char note){
        //c is base
        int Yc = 65;
        int Yn = noteNum(note);

        g.drawOval(15, Yc+(Yn*8), 18, 14);
    }

    public void half(Graphics g, char note) {
        //c is base
        int Yc = 30;
        int Yn = noteNum(note);

        whole(g, note);
        g.drawLine(33, Yc+(Yn*9), 33, Yc+(Yn*9)+42);
    }

    public void quart(Graphics g, char note) {
        //c is base
        int Yc = 30;
        int Yn = noteNum(note);
        
        g.fillOval(15, Yc+(Yn*8)+35, 18, 14);
        g.drawLine(33, Yc+(Yn*9), 33, Yc+(Yn*9)+42);
    }

    public void eighth(Graphics g, char note) {
        //c is base
        int Yc = 30;
        int Yn = 0;

        quart(g, note);
        g.drawLine(33, Yc+(Yn*9), 41, Yc+(Yn*9)+25);
    }

    public void sixteenth(Graphics g, char note) {
        //c is base
        int Yc = 30;
        int Yn = 0;

        eighth(g, note);
        g.drawLine(33, Yc+(Yn*9)+10, 39, Yc+(Yn*9)+20+10);
    }

    public void quarterRest(Graphics g) {
        g.drawImage(rest, 15, 35, null);
    }
}
