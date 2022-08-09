/*
    Author : Akila(E/17/154)
*/
public class Fractal {
    //static variable declaration for height,width of frame
    //number of iterations and iteration arr
    public static int width = 800;
    public static int height = 800;
    public static int N=1000;
    public static float arr[][];

    public static void main(String args[]){
        arr = new float[width][height];
        String op ="";

        //get first argument to chech fractal
        if(args.length>0){
            op = args[0];
        }

        try{
            //if Mandelbrot
            //define coordinates for focused area
            //check argument number 
            //update relevent values
            if(op.equals("Mandelbrot")){
                float a1 = -1,a2 = 1, b1=-1, b2 =1;
                if(args.length >= 5){
                    a1 = Float.parseFloat(args[1]);
                    a2 = Float.parseFloat(args[2]);
                    b1 = Float.parseFloat(args[3]);
                    b2 = Float.parseFloat(args[4]);
                }
                else if(args.length != 1){
                    System.out.println("Wrong number of arguments");
                    System.exit(0);
                }
                if(args.length == 6)
                    N=Integer.parseInt(args[5]);
                
                //create Mandelbrot object with required parameters
                //calculate array values
                //draw the image
                Mandelbrot m = new Mandelbrot(a1, a2, b1, b2,0,0);
                m.calculate();
            }
            else if(op.equals("Julia")){
                //if julia
                //define constant
                //check arguments and update the values
                float ca =  -0.4f; 
                float cb =  0.6f;
                if(args.length >= 3){
                    ca = Float.parseFloat(args[1]);
                    cb = Float.parseFloat(args[2]);
                }
                else if(args.length != 1){
                    System.out.println("Wrong number of arguments");
                    System.exit(0);
                }
                if(args.length == 4){
                    N=Integer.parseInt(args[3]);
                }

                //create Julia object with required parameters
                //calculate array values
                //draw the image

                Julia j = new Julia(ca, cb,0);
                j.calculate();
    
            }
            else{
                System.out.println("Enter valid arguments");
                System.exit(0);
            }
        }catch(NumberFormatException e){
            //input fromat exception
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
