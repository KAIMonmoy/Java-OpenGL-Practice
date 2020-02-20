import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.util.Scanner;

import java.util.Random;


class dda_algorithm implements GLEventListener{
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile


        dda_algorithm l = new dda_algorithm();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 400);

        final JFrame frame = new JFrame ("straight Line");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        Random rand = new Random();
        int rangeMin = -1;
        int rangeMax = 1;
        float m, x_next, y_next;

        //gl.glBegin (GL2.GL_POINTS);//static field
        for(int i = 0; i < 1; i++){
            //random float between -1 & 1
            float x1 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
            float y1 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
            float x2 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
            float y2 = rangeMin + (rangeMax - rangeMin) * rand.nextFloat();
            System.out.println("x1: " + x1 + " " + "y1: " + y1 + " x2: " + x2 + " " + "y2: " + y2 + " i: " + i);


            if(x1 > x2){
                float temp = x1;
                x1 = x2;
                x2 = temp;
                //temp = 0.0;
                temp = y1;
                y1 = y2;
                y2 = temp;

                //calculate slope
                m = ((y2-y1)/(x2-x1));
                System.out.println("x1 is greater " + m);
            }else{
                //m = (y2-y1)/(x2-x1);
                m = ((y2-y1)/(x2-x1));
                System.out.println("x2 is greater " + m);
            }
            System.out.println("end of for");

            if(m > -1 && m < 1){

                while(x1 < x2){

                    x_next = (float) (x1 + (1* 0.000001)) ;
                    y_next = (float) (y1 + (m * 0.000001)) ;
                    System.out.println("loop1 m: " + m + " " + "x: " + x_next + " " + "y: " + y_next);
                    gl.glBegin (GL2.GL_POINTS);
                    gl.glVertex2d(x_next, y_next);
                    gl.glEnd();
                    x1 = x_next;
                    y1 = y_next;

                }
            }else{

                while(y1 < y2){

                    x_next = (float) (x1 + ((1/m) * 0.000001));
                    y_next = (float) (y1 + (1 * 0.000001)) ;
                    System.out.println("loop2 m: " + m + " " + "x: " + x_next + " " + "y: " + y_next);
                    gl.glBegin (GL2.GL_POINTS);
                    gl.glVertex2d(x_next, y_next);
                    gl.glEnd();
                    x1 = x_next;
                    y1 = y_next;

                }
            }


        }



    }

    public void dispose(GLAutoDrawable arg0) {
        //method body
    }


    public void init(GLAutoDrawable drawable) {
        // method body
        //4. drive the display() in a loop
    }

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }
    //end of main
}//end of classimport javax.media.opengl.GL2;
