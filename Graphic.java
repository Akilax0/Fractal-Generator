import java.awt.*; /* java abstract window toolkit */
import javax.swing.*;
import java.awt.geom.Line2D;

@SuppressWarnings("serial")
public final class Graphic extends JPanel{

    private float x[][];
    //private int height,width;

    Graphic(){
        this.x = Fractal.arr;
    }

    private static void printPoint(Graphics2D frame, Color c, int a,int b) {
        //for given point color with given color
        frame.setColor(c); 
        frame.draw(new Line2D.Double(a,b,a,b)); 
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        Graphics2D g2D = (Graphics2D)g;

        try{
            //iterate through array and color each point in frame
            for(int i=0;i<x.length;i++){
                for(int j=0;j<x[i].length;j++){
                    float grey = x[i][j];
                    //System.out.println(grey);
                    Color color;
                    if(grey == 1){
                        color = Color.BLACK;
                    }
                    else{
                        //uses HSB format for color
                        color = Color.getHSBColor(grey * 3f, 1.0f, 1.0f);
                    }
                    
                    printPoint(g2D,color,i,Fractal.height-j-1);
                }
            }
        }catch(IndexOutOfBoundsException ine){
           System.out.println(ine);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
