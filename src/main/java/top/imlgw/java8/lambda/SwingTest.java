package top.imlgw.java8.lambda;

import javax.swing.*;

/**
 * @author imlgw.top
 * @date 2019/9/14 17:14
 */
public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame("My JFrame");

        JButton jButton=new JButton("My JButton");

        jButton.addActionListener(event-> System.out.println("Button Pressed"));

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
