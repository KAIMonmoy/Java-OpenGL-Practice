import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;

import javax.swing.JFrame;

import java.util.Scanner;


public class DDA implements GLEventListener{

    static private float x1, x2, y1, y2;

    public static void main(String[] args) {
        // Getting capabilities of GL2 Profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The Canvas
        final GLCanvas canvas = new GLCanvas(capabilities);
        DDA dda = new DDA();
        canvas.addGLEventListener(dda);
        canvas.setSize(640, 480);

        // Adding Canvas to Frame
        final JFrame frame = new JFrame ("DDA Algorithm");
        frame.getContentPane().add(canvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        final Scanner scanner = new Scanner(System.in);


        // Line from (x1, y1) to (x2, y2)
        System.out.print("Enter x1 (-1.0 ~ 1.0): ");
        x1 = scanner.nextFloat();
        System.out.print("Enter y1 (-1.0 ~ 1.0): ");
        y1 = scanner.nextFloat();
        System.out.print("Enter x2 (-1.0 ~ 1.0): ");
        x2 = scanner.nextFloat();
        System.out.print("Enter y2 (-1.0 ~ 1.0): ");
        y2 = scanner.nextFloat();
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        final GL2 gl = glAutoDrawable.getGL().getGL2();

        // DDA Algorithm
        float dx = x2 - x1;
        float dy = y2 - y1;

        float step = Math.max(Math.abs(dx), Math.abs(dy));

        if (dx == 0 && dy == 0) {
            drawPoint(gl, x1, y1);
        }
        else {
            float incX = dx / step;
            float incY = dy / step;


            final float INCREMENT_FACTOR = 0.00001f;

            while (Math.abs(x1-x2) > INCREMENT_FACTOR || Math.abs(y1-y2) > INCREMENT_FACTOR) {
                drawPoint(gl, x1, y1);
                x1 += incX * INCREMENT_FACTOR;
                y1 += incY * INCREMENT_FACTOR;
            }
        }

        gl.glFlush();

    }

    private void drawPoint(GL2 gl, float x, float y) {
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(x, y);
        gl.glEnd();
    }


    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
