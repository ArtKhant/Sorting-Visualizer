import javax.swing.*;
import java.awt.*;


public class Board extends JComponent{

    int[] data;
    int lenght;
    public int index;
    Graphics2D g2d;

    public boolean ready = false;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.fillRect(0, 0, 900, 900);
        for(int i = 0; i < lenght; i++){
            if(ready){
                if(i<index){
                    g2d.setColor(new Color(10, 255, 10, 100));
                }else if (i == index) {
                    g2d.setColor(new Color(255, 10, 10, 100));
                }else {
                    g2d.setColor(new Color(255, 255, 255, 100));
                }
            }
            else {
                if (i == index) {
                    g2d.setColor(new Color(255, 10, 10, 100));
                } else {
                    g2d.setColor(new Color(255, 255, 255, 100));
                }
            }
            int w = 5;
            g2d.fillRect(i*w , 900-data[i]*w, w, data[i]*w);
        }

    }


    public Board(int[] data, int index){
        this.data = data;
        this.lenght = data.length;
        this.index = index;
    }
}
