package de.wow.wowgui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Wahrsagekugel extends JFrame {

    private RunderButton button;
    private JLabel ausgabe;
    private JLabel vorschlag;

    public static void main(String[] args) {

        new Wahrsagekugel();

    }


    public Wahrsagekugel() {
        super("Wahrsagekugel");
        ImageIcon im = new ImageIcon("hintergrundTest.png");

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                try {
                    Image background = ImageIO.read(new File("C:\\GitHub\\WoWGUI\\WowGUI\\src\\main\\java\\de\\wow\\wowgui\\hintergrundTest.png"));
                    g2d.drawImage(background, 0, 0, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        };

        panel.setBounds(250, 250, im.getIconWidth(), im.getIconHeight());
        panel.setLayout(null);

        button = new RunderButton("Drück mich!!");
        button.setBounds(250, 275, 110, 70);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.BLUE);

        panel.add(button);


        ausgabe = new JLabel();
        ausgabe.setBounds(80, 30, 250, 30);
        ausgabe.setText("Hallo Welt");
        ausgabe.setForeground(Color.WHITE);
        ausgabe.setBackground(Color.white);
        ausgabe.setHorizontalTextPosition(SwingConstants.CENTER);

        panel.add(ausgabe);



        add(panel);

        setPreferredSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);




    }


}
