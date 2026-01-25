import javax.swing.*;
import java.awt.*;


public class Board extends JComponent{

    private int[] data;
    private int lenght;
    private int index;
    private Graphics2D g2d;
    private Enum graph;

    private boolean ready = false;



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            g2d = (Graphics2D) g;

            switch (graph){
                case DataType.Triangle -> {drawTriangle();}
                case DataType.Line -> {drawLine();}
                case DataType.Spiral -> {drawSpiral();}
                case DataType.ColorCircle -> {drawColorCircle();}
                case DataType.Bonefire -> {drawBonefire();}
                default -> {}
            }


    }


    public Board(int[] data, int index){
        this.data = data;
        this.lenght = data.length;
        this.index = index;
    }

    public void setGraph(Enum graph){
        this.graph = graph;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public void setReadyness(boolean ready){
        this.ready = ready;
    }


    private void drawTriangle(){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRect(0, 0, 1800, 900);


        int w = 1;
        int SizeMult = 1;


        if(lenght == 256){
            w = 4; SizeMult = 4;
        } else if (lenght == 512) {
            w = 2; SizeMult = 2;
        }else{
            w = 1; SizeMult = 1;
        }

        for(int i = 0; i < lenght; i++) {
            if (ready) {
                if (i < index) {
                    g2d.setColor(new Color(10, 255, 10));
                } else if (i == index) {
                    g2d.setColor(new Color(255, 10, 10));
                } else {
                    g2d.setColor(new Color(255, 255, 255));
                }
            } else {
                if (i == index) {
                    g2d.setColor(new Color(255, 10, 10));
                } else {
                    g2d.setColor(new Color(255, 255, 255));
                }
            }





            if(i==index){
                g2d.fillRect(25 + i * w, 830 - data[i] * w/2, w, data[i] * w * SizeMult/2);
            }else {
                g2d.fillRect(25 + i * w, 830 - data[i] * w/2, w, data[i] * w * SizeMult/2);
            }
        }
    }

    private void drawLine(){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRect(0, 0, 1800, 900);

        float w = 2048 / lenght + 1;


        for(int i = 0; i < lenght; i++) {
            if (ready) {
                if (i < index) {
                    g2d.setColor(new Color(10, 255, 10));
                } else {
                    g2d.setColor(new Color(255, 255, 255));
                }
            } else {
                g2d.setColor(new Color(255, 255, 255));

            }

            if(i==index){
                g2d.fillOval((int) (50 + i * w*2/6), (int) (800 - data[i] * (w * 1/6)), (int) (w * 2), (int) (w * 2));
            }else {
                g2d.fillOval((int) (50 + i * w*2/6), (int) (800 - data[i] * (w * 1/6)), (int) (w * 2), (int) (w * 2));
            }
        }

        if(index >= lenght){index = lenght-1;}
        g2d.setColor(new Color(255, 10, 10));
        g2d.fillOval((int) (50 + index * w*2/6), (int) (800 - data[index] * (w * 1/6)), (int) (w * 2), (int) (w * 2));


    }

    private void drawSpiral(){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRect(0, 0, 1800, 900);

        int w = 1024 / lenght +1;

        for(int i = 0; i < lenght; i++) {
            if (ready) {
                if (i < index) {
                    g2d.setColor(new Color(10, 255, 10));
                }else {
                    g2d.setColor(new Color(255, 255, 255));
                }
            } else {
                if (i == index) {

                } else {
                    g2d.setColor(new Color(255, 255, 255));
                }
            }


            g2d.fillOval((int) (600 + Math.cos( Math.toRadians(360*i/lenght)) * data[i] * w/5), (int) (410+ Math.sin(Math.toRadians(360*i/lenght)) * data[i] * w/5), w, w );


        }

        if(index >= lenght){index = lenght-1;}

        g2d.setColor(new Color(255, 10, 10));
        g2d.fillOval((int) (600 + Math.cos( Math.toRadians(360*index/lenght)) * data[index] * w/5), (int) (410 + Math.sin(Math.toRadians(360*index/lenght)) * data[index] * w/5), w*3, w*3 );

    }

    private void drawColorCircle(){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRect(0, 0, 1800, 900);
        for(int i = 0; i < lenght; i++) {
            if (ready) {
                if (i < index) {
                    g2d.setColor(new Color(255, 255, 255));
                } else if (i == index) {
                    g2d.setColor(new Color(255, 10, 10));
                } else {
                    g2d.setColor(new Color(255, 255, 255));
                }
            } else {
                if (i == index) {
                    g2d.setColor(new Color(255, 250, 250));
                } else {
                    g2d.setColor(new Color(255*data[i]/lenght, 0, 255-255*data[i]/lenght));
                }
            }
            int w = 1024 / lenght + 1;
            if(i==index){
                g2d.drawLine(850, 450, (int) (850 + Math.cos( Math.toRadians(360*i/lenght))*400),(int)(450 + Math.sin( Math.toRadians(360*i/lenght))*400));
            }else {
                g2d.drawLine(850, 450, (int) (850 + Math.cos( Math.toRadians(360*i/lenght))*400),(int)(450 + Math.sin( Math.toRadians(360*i/lenght))*400));
            }
        }
    }

    private void drawBonefire(){
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRect(0, 0, 1800, 900);
        for(int i = 0; i < lenght; i++) {
            if (ready) {
                if (i < index) {
                    g2d.setColor(new Color(10, 255, 10));
                } else if (i == index) {
                    g2d.setColor(new Color(255, 10, 10));
                } else {
                    g2d.setColor(new Color(255, 255, 255));
                }
            } else {
                if (i == index) {
                    g2d.setColor(new Color(255, 10, 10));
                } else {
                    g2d.setColor(new Color(255, 255, 255));
                }
            }
            double w = 1024 / lenght +1;

            double r = Math.pow(Math.sin( 1.2 * data[i]), 2) + Math.pow(Math.cos( 6 * data[i]), 3) * 400;

            if(i==index){
                g2d.fillOval((int) (850 + Math.cos( Math.toRadians(360*i/lenght)) * r)  , (int) (450 + Math.sin(Math.toRadians(360*i/lenght)) * r), (int) (w*6), (int) (w*6));
            }else {
                g2d.fillOval((int) (850 + Math.cos( Math.toRadians(360*i/lenght)) * r)  , (int) (450 + Math.sin(Math.toRadians(360*i/lenght)) * r), (int) (w*3), (int) (w*3));
            }
        }
    }
}
