import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;

import javax.swing.JFrame;


public class BasicFrame implements GLEventListener{

    public static void main(String[] args) {
        // Getting capabilities of GL2 Profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The Canvas
        final GLCanvas canvas = new GLCanvas(capabilities);
        BasicFrame basicFrame = new BasicFrame();
        canvas.addGLEventListener(basicFrame);
        canvas.setSize(640, 480);

        // Adding Canvas to Frame
        final JFrame frame = new JFrame ("Basic Frame");
        frame.getContentPane().add(canvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        final GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(0f, 0f);
        gl.glEnd();

    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
