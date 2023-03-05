package de.wow.wowgui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        panel.setLayout(null);

        vorschlag = new JLabel();
        vorschlag.setBounds(335,342,75,30);
        vorschlag.setText("Drück mich!!!");
        vorschlag.setForeground(Color.WHITE);
        vorschlag.setOpaque(false);
        panel.add(vorschlag);

        button = new RunderButton("Drück mich!!!");
        try{
            button.setBounds(320, 325, 110, 70);
            Image ima = ImageIO.read(new File("C:\\GitHub\\WoWGUI\\WowGUI\\src\\main\\java\\de\\wow\\wowgui\\buttontest.png"));

            Shape shape = new Ellipse2D.Float(0,0, button.getWidth(), button.getHeight());
            BufferedImage mI = new BufferedImage(button.getWidth(), button.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = mI.createGraphics();
            g2d.setClip(shape);
            g2d.drawImage(ima, 0,0,null);
            g2d.dispose();
            Icon bgIcon = new ImageIcon(mI);
            button.setIcon(bgIcon);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgabe.setText(aufgabenListe());
            }
        });
        panel.add(button);

        ausgabe = new JLabel("", SwingConstants.CENTER);
        ausgabe.setBounds(40, 30, 400, 30);
        ausgabe.setForeground(Color.WHITE);
        ausgabe.setFont(ausgabe.getFont().deriveFont(Font.BOLD, 16));

        panel.add(ausgabe);

        add(panel);
        setPreferredSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String aufgabenListe() {
        Random rnd = new Random();
        int zufall;
        List<String> variations = new ArrayList<>();
        variations.add("Gold farmen in der Methode deiner Wahl");
        variations.add("Ausloggen!!!");
        variations.add("Gebiete erkunden.");
        variations.add("Erfolge sammeln.");
        variations.add("Kräuter farmen");
        variations.add("Leder farmen");
        variations.add("Dungeons grinden");
        variations.add("In einer Hauptstadt deiner Wahl chillen.");
        variations.add("Ruf einer Fraktion deiner Wahl farmen.");
        variations.add("Neuen Char Leveln.");
        variations.add("Role Play in Sturmwind");
        variations.add("PVP als Healer");
        variations.add("Mit unsichtbarkeitstränken nach Orgrimmar.");
        variations.add("Aktuellen Charakter löschen.");
        variations.add("Was anderes zocken.");
        variations.add("Angeln skillen.");
        variations.add("Angeln.");
        variations.add("Berufe verlernen und neue Berufe lernen.");

        zufall = rnd.nextInt(variations.size());

        return variations.get(zufall);
    }
}
