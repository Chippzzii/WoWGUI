package de.wow.wowgui;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RunderButton extends JButton {

    public RunderButton(String label) {
        setOpaque(false);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        if(getModel().isArmed()) {
            g.setColor(Color.gray);
        } else {
            g.setColor(getBackground());
        }


        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        super.paintComponent(g);

    }



    @Override
    protected void paintBorder(Graphics g) {
        setOpaque(false);
        setBorderPainted(false);
        g.setColor(Color.gray);
        g.drawOval(0, 0, getSize().width-1, getSize().height-1);
    }


}
