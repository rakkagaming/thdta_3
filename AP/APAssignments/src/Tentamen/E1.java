package Tentamen;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Created by robin on 20/10/2017.
 */
public class E1 extends JPanel{
    static int rounds = 0;
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D) g;

        // The 20x20 rectangle that you want to draw
        Rectangle2D rect = new Rectangle2D.Double( 0, 0, 20, 20 );

        // This transform is used to modify the rectangle (an affine
        // transform is a way to do operations like translations, rotations,
        // scalings, etc...)
        AffineTransform transform = new AffineTransform();

        // 3rd operation performed: translate the rectangle to the desired
        // x and y position
        //transform.translate( x + 10, y + 10 );

        // 2nd operation performed: rotate the rectangle around the origin
        transform.rotate( 10 );

        // 1st operation performed: translate the rectangle such that it is
        // centered on the origin
        //transform.translate( -10, -10 );

        // Apply the affine transform
        Shape s = transform.createTransformedShape( rect );

        // Fill the shape with the current paint
        g2d.fill( s );

        // Stroke the edge of the shape with the current paint
        g2d.draw( s );
    }
}
