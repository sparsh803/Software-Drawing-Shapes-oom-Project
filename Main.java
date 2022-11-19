package  oomP;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("World of Shapes");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        Dialogue dialogBox = new Dialogue();
        dialogBox.entrance("Welcome to the Land Of Art\n");

        String name = dialogBox.askName();

        if(name.isEmpty()) {
            dialogBox.leaving();
            System.exit(0);
        }
        int a=0;
        for(int i=0;i<name.length();++i) {
            if(name.charAt(i)==' ') {
                a++;
            }
        }
        if(a==name.length()) {
            dialogBox.leaving();
            System.exit(0);
        }

        ShapeList list=new ShapeList();
        list.adduser(name);

        if(dialogBox.ask(name)==JOptionPane.YES_OPTION) {
            String shape[];
            int index=dialogBox.ShapeType("Choose the dimensions of shape");

            if(index==0) {
                shape=new String[list.shapes2D.size()];

                for(int i=0;i<list.shapes2D.size();++i)  {
                    shape[i]=list.shapes2D.get(i).name;
                }

                int index2D=dialogBox.type(shape,"Choose a shape");
                if(index2D>=0&&index2D<6) {
                    Shape_2dimension make2d=new Shape_2dimension(index2D);
                    frame.add(make2d);
                }
                else {
                    System.exit(0);
                }


            }
            else if(index==1) {

                shape=new String[list.shapes3D.size()];

                for(int i=0;i<list.shapes3D.size();++i) {
                    shape[i]=list.shapes3D.get(i).name;
                }

                int index3D=dialogBox.type(shape,"Choose a shape");
                if(index3D>=0&&index3D<4) {
                    if(dialogBox.ques()==JOptionPane.NO_OPTION) {
                        Shape_3dimension make3d=new Shape_3dimension(index3D,false);
                        frame.add(make3d);
                    }
                    else {
                        Shape_3dimension make3d=new Shape_3dimension(index3D,true);
                        frame.add(make3d);
                    }
                }
                else {
                    System.exit(0);
                }
            }
            else {
                System.exit(0);
            }
        }
        else {
            dialogBox.leaving(name);
            System.exit(0);
        }
        frame.setResizable(false);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}