public class Mandelbrot extends Thread{
    //defines required variables
    private int width = Fractal.width;
    private int height = Fractal.height;
    private int N = Fractal.N;
    private float a1,a2,b1,b2;
    private int i,j;

    Mandelbrot(float a1,float a2,float b1,float b2,int i,int j){
        //constructor takes values
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        this.i = i;
        this.j = j;
    }
/*

-----Using Threads--------

    @Override
    public void run(){
        //System.out.println("New thread " +);
        synchronized(Main.arr){
            //for(j=0;j<height;j++){
                
                int n=0;
                float a = (float)(a1 + ((float)i/(float)width)*(a2-a1));
                float b = (float)(b1 + ((float)j/(float)height)*(b2-b1));
                System.out.println(i+" "+j);
    
                float ca = a;
                float cb = b;
    
                while(n<N){
                    float aa = a*a - b*b;
                    float bb = 2*a*b;
                    a = aa + ca;
                    b = bb + cb;
    
                    n++;
                    if(Math.abs(aa+bb)>4){
                        break;
                    }
                }
                
                float bright = (((float)n/(float)N));
                Main.arr[i][j]=bright;
            //}
        }
    }
*/
    void calculate(){
        //method to calculate values for mandelbrot set
        for(i=0;i<width;i++){
            for(j=0;j<height;j++){
                
                int n=0;
                float a = (float)(a1 + ((float)i/(float)width)*(a2-a1));
                float b = (float)(b1 + ((float)j/(float)height)*(b2-b1));
                //System.out.println(i+" "+j);
    
                float ca = a;
                float cb = b;
    
                while(n<N){
                    float aa = a*a - b*b;
                    float bb = 2*a*b;
                    a = aa + ca;
                    b = bb + cb;
    
                    n++;
                    if(Math.abs(aa+bb)>4){
                        break;
                    }
                }
                
                //set array value with bright variable
                float bright = (((float)n/(float)N));
                Fractal.arr[i][j]=bright;
            }
        }
        draw();

    }

    private void draw(){
        //creates MyFrame objject to create a Frame
        MyFrame frame1 = new MyFrame("Mandelbrot Set");
    }
}
