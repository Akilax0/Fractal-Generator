import javax.swing.*;

@SuppressWarnings("serial")
public final class MyFrame extends JFrame{ 
    //creates frame when called
    MyFrame(String s){
        //sets defined height and width
        //creates Graphic  object to draw in frame
        this.setSize(Fractal.height,Fractal.width);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(s);
        Graphic g = new Graphic();
        this.add(g);
        this.setResizable(false);
        this.setVisible(true);
    }
}
