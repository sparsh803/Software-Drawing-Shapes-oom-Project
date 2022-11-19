package oomP;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.media.j3d.Alpha;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;

import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.QuadArray;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.TransformGroup;

public class Shape_3dimension extends ShapeGenerator {

    GraphicsConfiguration config;
    Canvas3D canvas;
    SimpleUniverse universe;
    BranchGroup group;

    Background background;
    BoundingSphere boundingSphere;

    Color3f lightColor;
    Vector3f lightDirection;
    BoundingSphere bounds;
    DirectionalLight light;

    Alpha spinAlpha = new Alpha(-1, 10000);
    RotationInterpolator spin;

    TransformGroup tGroup;


    Shape_3dimension(int shape_index, boolean flag) {

        setLayout(new BorderLayout());

        config = SimpleUniverse.getPreferredConfiguration();
        canvas = new Canvas3D(config);
        universe = new SimpleUniverse(canvas);
        group = new BranchGroup();

        background = new Background(new Color3f(255,255,255));
        boundingSphere = new BoundingSphere(new Point3d(0,0,0), 100000);
        background.setApplicationBounds(boundingSphere);
        group.addChild(background);

        tGroup = new TransformGroup();
        tGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        group.addChild(tGroup);

        shape=new ProtoShapes();
        this.index=shape_index;

        shape.cube = new ColorCube(0.25f);
        QuadArray cubeArr = new QuadArray(24, QuadArray.COORDINATES | QuadArray.COLOR_4);
        cubeArr = (QuadArray) shape.cube.getGeometry();
        for(int i=0;i<16;i++) {
            cubeArr.setColor(i, new Color3f(0.0f, 12.0f, 2.0f));
        }

        shape.cylinder = new Cylinder(0.25f, 1);
        shape.sphere = new Sphere(0.25f);
        shape.cone = new Cone(0.5f, 1.0f);

        if(index==0) tGroup.addChild(shape.cube);

        else if(index==1) tGroup.addChild(shape.sphere);

        else if(index==2) tGroup.addChild(shape.cylinder);

        else if(index==3) tGroup.addChild(shape.cone);

        lightColor = new Color3f(1f, 1f, 1f);
        lightDirection = new Vector3f(-1, -1, -1);
        bounds = new BoundingSphere(new Point3d(0, 0, 0), 100);
        light = new DirectionalLight(lightColor, lightDirection);
        light.setInfluencingBounds(bounds);
        group.addChild(light);

        spinAlpha = new Alpha(-1, 20000);
        spin = new RotationInterpolator(spinAlpha, tGroup);
        spin.setSchedulingBounds(new BoundingSphere(new Point3d(), 0));
        if(flag==true) {
            tGroup.addChild(spin);
            universe.getViewingPlatform().setNominalViewingTransform();
            universe.getViewer().getView().setBackClipDistance(10.0);
            universe.addBranchGraph(group);

            this.add(canvas);
        }
        else {
            universe.getViewingPlatform().setNominalViewingTransform();
            universe.getViewer().getView().setBackClipDistance(10.0);
            universe.addBranchGraph(group);

            this.add(canvas);
        }



    }

    class EventHandler3D implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
        }
    }

}
