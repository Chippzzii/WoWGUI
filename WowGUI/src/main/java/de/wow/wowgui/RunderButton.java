package de.wow.wowgui;


import javax.swing.*;
import java.awt.*;

public class RunderButton extends JButton {

    public RunderButton(String label) {
        super(label);
        setBackground(Color.GREEN); // Hintergrundfarbe ändern
        setOpaque(false); // Hintergrund unsichtbar machen
        setPreferredSize(new Dimension(100, 100)); // Größe setzen
    }

    @Override
    protected void paintComponent(Graphics g) {

        if(getModel().isArmed()) {
            g.setColor(Color.gray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);

    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }


}
