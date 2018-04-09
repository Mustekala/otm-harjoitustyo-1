package fi.helsinki.arkanoidotm;

import javax.swing.*;

public class Main {
    public static JFrame frame;
    public static Game game;
    
    public static void main(String[] args) {
        frame = new JFrame("Arkanoid");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        
        game = new Game(frame);
        game.setSize(frame.getSize());
        frame.add(game);
        
        frame.setVisible(true);
    }
    
}