public class Julia extends Thread{
    //defines required variables
    private float a1 = -1,a2 = 1, b1=-1, b2 =1,ca,cb;
    private int width = Fractal.width;
    private int height = Fractal.height;
    private int N = Fractal.N;
    private int i;

    Julia(float ca,float cb,int i){
        //constructor takes values
        this.ca = ca;
        this.cb = cb;        
        this.i = i;
    }
/*

----------------Using Threads ------------------
    @Override
    public void run(){
        for(int j=0;j<height;j++){
                
            float a = (float)(a1 + ((float)i/(float)width)*(a2-a1));
            float b = (float)(b1 + ((float)j/(float)height)*(b2-b1));
            int n=0;
            while(n<N){
                float aa = a*a - b*b;
                float bb = 2*a*b;
                a = aa + ca;
                b = bb + cb;

                n++;
                //System.out.println(Math.abs(aa+bb));
                if(Math.abs(aa+bb)>4){
                    break;
                }
                    
            }

            float bright = (((float)n/(float)N));                
            Main.arr[i][j]=bright;
        }
    }
*/
    void calculate(){
        //method to calculate values for Julia set
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                
                float a = (float)(a1 + ((float)i/(float)width)*(a2-a1));
                float b = (float)(b1 + ((float)j/(float)height)*(b2-b1));
                int n=0;
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
        
        MyFrame frame2 = new MyFrame("Julia Set");
    }
}
