import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import javax.swing.JFrame;


public class SierpinskiTriangle extends JFrame {
    Image img;
    public static void main(String[] args){
        
        SierpinskiTriangle quadro = new SierpinskiTriangle();
        Graphics g = quadro.getGraphics();

        int [] cX = {0,250,500};
        int [] cY = {450,0,450};

        quadro.drawTriangle(cX,cY,Integer.parseInt(args[0]),g);
    }
    
    public SierpinskiTriangle(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,450);
        setResizable(false);
        setVisible(true);
        setTitle("Sierpinski Triangle");
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(img, 0, 25, this);
    }
    
    public void drawTriangle(int [] cX, int [] cY, int contador, Graphics g){
        if(contador == 0){
            //parada 
        }else{
            g.setColor(java.awt.Color.blue);
            g.drawPolygon(cX, cY, 3);

            drawTriangle(UpdateTopX(cX), UpdateTopY(cY), contador-1, g);
            drawTriangle(UpdateLeftX(cX), UpdateLeftY(cY), contador-1, g);
            drawTriangle(UpdateRightX(cX), UpdateRightY(cY),contador-1, g);
        }
    }

    public static int [] UpdateTopX(int [] c){
        int[] r = {0,0,0};
        r[0] = ((c[2]-c[1])/2)+c[0];
        r[1] = c[1];
        r[2] = ((c[2]-c[1])/2)+c[1];
        return r;
    }
    
    public static int [] UpdateTopY(int [] c){
        int[] r = {0,0,0};
        r[0] = ((c[2]-c[1])/2)+c[1];
        r[1] = c[1];
        r[2] = ((c[2]-c[1])/2)+c[1];
        return r;
    }
    
    public static int [] UpdateLeftX(int [] c){
        int[] r = {0,0,0};
        r[0] = c[0];
        r[1] = ((c[2]-c[1])/2)+c[0];
        r[2] = c[1];
        return r;
    }
    
    public static int [] UpdateLeftY(int [] c){
        int[] r = {0,0,0};
        r[0] = c[0];
        r[1] = ((c[2]-c[1])/2)+c[1];
        r[2] = c[0];
        return r;
    }
    
    public static int [] UpdateRightX(int [] c){
        int[] r = {0,0,0};
        r[0] = c[1];
        r[1] = ((c[2]-c[1])/2)+c[1];
        r[2] = c[2];
        return r;    
    }
    
    public static int [] UpdateRightY(int [] c){
        int[] r = {0,0,0};
        r[0] = c[2];
        r[1] = ((c[2]-c[1])/2)+c[1];
        r[2] = c[2];
        return r;    
    }
}

