package oomP;

import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.event.ActionEvent;

import java.awt.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Shape_2dimension extends ShapeGenerator {

    ProtoButtons rc = new ProtoButtons("Rotate ClockWise");
    ProtoButtons rac = new ProtoButtons("Rotate Anti-ClockWise");
    ProtoButtons change = new ProtoButtons("Change Color");
    Color color = Color.pink, color1, color2;
    int button_pressed, color_button_pressed;
    double angle;

    Shape_2dimension(int shape_index){
        shape = new ProtoShapes();

        this.index = shape_index;

        // add action listeners to these buttons,
        rc.addActionListener(new EventHandler2D ());

        rac.addActionListener(new EventHandler2D ());

        change.addActionListener(new EventHandler2D ());
        this.add(rc);
        this.add(rac);
        this.add(change);

        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g1 = (Graphics2D) g;

        AffineTransform trans = new AffineTransform();
        trans.rotate(angle, 250, 250);

        g1.setColor(Color.orange);

        Shape rotatedShape = null;
        shape.circle = new Ellipse2D.Double(100.0d, 100.0d, 100.0d, 100.0d);
        shape.ellipse = new Ellipse2D.Double(100.0d, 100.0d, 100.0d, 50.0d);
        shape.square = new Rectangle(300, 300, 100, 100);
        shape.rectangle = new Rectangle(300, 300, 100, 50);
        shape.triangle = new Polygon(new int[] { 400, 500, 500 }, new int[] {250, 225, 275 }, 3);

        shape.tri1 = new Polygon(new int[] { 425, 475, 450 }, new int[] { 275, 275, 225 }, 3);
        shape.tri2 = new Polygon(new int[] { 475, 475, 525 }, new int[] { 275, 325, 300 }, 3);
        shape.tri3 = new Polygon(new int[] { 475, 425, 450 }, new int[] { 325, 325, 375 }, 3);
        shape.tri4 = new Polygon(new int[] { 425, 425, 375 }, new int[] { 325, 275, 300 }, 3);
        shape.midrect = new Rectangle(425, 275, 50, 50);

        if(button_pressed % 2 == 0) {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color(R, G, B);
            g1.setColor(color);
            g1.setColor(color);
        }

        if(button_pressed % 2 != 0) {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color(R, G, B);
            g1.setColor(color);
            g1.setColor(color);
        }

        if(index == 0) {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color(R, G, B);
            g1.setColor(color);
            rotatedShape = trans.createTransformedShape(shape.square);
            g1.fill(rotatedShape);
        }

        if(index == 1) {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color(R, G, B);
            g1.setColor(color);
            rotatedShape = trans.createTransformedShape(shape.ellipse);
            g1.fill(rotatedShape);
        }

        if(index == 2) {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color(R, G, B);
            g1.setColor(color);
            rotatedShape = trans.createTransformedShape(shape.triangle);
            g1.fill(rotatedShape);
        }

        if(index == 3) {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color(R, G, B);
            g1.setColor(color);
            rotatedShape = trans.createTransformedShape(shape.rectangle);
            g1.fill(rotatedShape);
        }

        if(index == 4) {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color(R, G, B);
            g1.setColor(color);
            rotatedShape = trans.createTransformedShape(shape.circle);
            g1.fill(rotatedShape);
        }


        if(index == 5) {
            rotatedShape = trans.createTransformedShape(shape.tri1);
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color(R, G, B);
            g1.setColor(color);
            g1.fill(rotatedShape);

            rotatedShape = trans.createTransformedShape(shape.tri2);
            g1.setColor(color);
            g1.fill(rotatedShape);

            rotatedShape = trans.createTransformedShape(shape.tri3);
            g1.setColor(color);
            g1.fill(rotatedShape);

            rotatedShape = trans.createTransformedShape(shape.tri4);
            g1.setColor(color);
            g1.fill(rotatedShape);

            rotatedShape = trans.createTransformedShape(shape.midrect);
            g1.setColor(color);
            g1.fill(rotatedShape);
        }
    }

    class EventHandler2D implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(e.getSource() == rc) {
                int R = (int)(Math.random()*256);
                int G = (int)(Math.random()*256);
                int B= (int)(Math.random()*256);
                Color color = new Color(R, G, B);

                angle += 0.1;
                button_pressed++;
            }

            if(e.getSource() == rac) {
                int R = (int)(Math.random()*256);
                int G = (int)(Math.random()*256);
                int B= (int)(Math.random()*256);
                Color color = new Color(R, G, B);

                angle -= 0.1;
                button_pressed++;
            }

            if(e.getSource() == change) {
                color_button_pressed++;

                if(color_button_pressed % 2 == 0) {
                    color1 = Color.cyan;
                    color2 = Color.green;
                }
                if(color_button_pressed % 2 != 0) {
                    color1 = Color.red;
                    color2 = Color.magenta;
                }
            }

            setLayout(null);
            repaint();
        }
    }

}
