package oomP;
import javax.swing.JOptionPane;

public class Dialogue {

        void entrance(String s) {
            JOptionPane.showMessageDialog(null, s, "Welcome to ScaleiT", JOptionPane.INFORMATION_MESSAGE);
        }

        String askName() {
            return JOptionPane.showInputDialog(null, "Enter your name", "Name", JOptionPane.QUESTION_MESSAGE);
        }

        int ask(String user_name) {
            return JOptionPane.showConfirmDialog(null, "Hey " + user_name + ", would you like to try ScaleiT ?\n", "Offer", JOptionPane.YES_NO_OPTION);
        }

        int ShapeType(String str) {
            return JOptionPane.showOptionDialog(null, str, "Shape dimension", 0, JOptionPane.QUESTION_MESSAGE, null, new String[] {"2D", "3D"}, 0);
        }

        int type(String[] types, String str) {
            return JOptionPane.showOptionDialog(null, str, "Shapes", 0, JOptionPane.QUESTION_MESSAGE, null, types, 0);
        }

        int leaving(String name) {
            JOptionPane.showMessageDialog(null, "It was a nice time with you " + name , "Exit", JOptionPane.PLAIN_MESSAGE);
            return 0;
        }

        void leaving()
        {
            JOptionPane.showMessageDialog(null, "Not a valid user " , "Exit", JOptionPane.PLAIN_MESSAGE);
        }

        int ques() {
            return JOptionPane.showConfirmDialog(null,"Would you like to view rotation of selected shape as well ?\n", "Offer", JOptionPane.YES_NO_OPTION);
        }
}
