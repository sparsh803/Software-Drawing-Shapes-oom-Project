package oomP;
import java.util.ArrayList;

public class ShapeList {

    ArrayList<User> users = new ArrayList <User> ();
    ArrayList<Shape_2D> shapes2D = new ArrayList <Shape_2D> ();
    ArrayList<Shape_3D> shapes3D = new ArrayList <Shape_3D> ();

    ShapeList(){

        Shape_3D cube = new Shape_3D("Cube");
        shapes3D.add(cube);
        Shape_3D sphere = new Shape_3D("Sphere");
        shapes3D.add(sphere);
        Shape_3D cylinder = new Shape_3D("Cylinder");
        shapes3D.add(cylinder);
        Shape_3D cone = new Shape_3D("Cone");
        shapes3D.add(cone);

        Shape_2D square = new Shape_2D("Square");
        shapes2D.add(square);
        Shape_2D ellipse = new Shape_2D("Ellipse");
        shapes2D.add(ellipse);
        Shape_2D triangle = new Shape_2D("Triangle");
        shapes2D.add(triangle);
        Shape_2D rectangle = new Shape_2D("Rectangle");
        shapes2D.add(rectangle);
        Shape_2D circle = new Shape_2D("Circle");
        shapes2D.add(circle);
        Shape_2D star = new Shape_2D("Star");
        shapes2D.add(star);
    }

    void adduser(String name) {
        User userName = new User(name);
        users.add(userName);
    }
}
