package genspark.projects.project4;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class View extends JFrame implements Runnable {

    GridLayout layout;

    View(int size) {
        super("Monster Land");
        layout = new GridLayout(size, size);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(size * 150, size * 150);
        setLayout(new BorderLayout());
        setResizable(false);
    }

    public void introduce(Map<String, GamePiece> gamePieces) {
        String intro = ("""
                Look fool, this is You ( %you )
                You are in MonsterLand,
                Grab some treasure while you're here ( %cash )
                    
                Run from the pursuing enemy!
                He WILL chase you. ( %goblin )
                You Might die if he catches you!
                                
                You can only move Up, Down, Left, or Right.
                Use the ArrowKeys to move. Use SpaceBar to Exit.
                        
                """);
        intro = intro.replace("%you", gamePieces.get("player").toString());
        intro = intro.replace("%goblin", gamePieces.get("monster").toString());
        intro = intro.replace("%cash", gamePieces.get("treasure").toString());
        popupMsg(intro);
    }

    public void mapGamePieces(String[][] map) {
        JPanel pane = new JPanel(layout);
        final Font f = new Font("Segoe UI Emoji", Font.BOLD, 40);
        for (String[] x : map) {
            for (String val : x) {
                JLabel character = new JLabel(val);
                character.setFont(f);
                character.setHorizontalAlignment(JLabel.CENTER);
                pane.add(character);
            }
        }
        pane.setBackground(Color.YELLOW);
        add(pane, BorderLayout.CENTER);
        setVisible(true);
    }

    public void updateFrameMsg(String msg) {
        JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel frameMsg = new JLabel(msg);
        pane.add(frameMsg);
        add(pane, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void popupMsg(String msg) {
        if (msg != null)
        JOptionPane.showMessageDialog(this, msg);
    }

    public static int chooseDifficulty() {
        String difficulty =
                        """
                        Choose a Difficulty
                        1. Short  ( 4 squares )
                        2. Medium ( 5 Squares )
                        3. Long   ( 6 Squares - default )
                        """;
        try {
            int size = Integer.parseInt(JOptionPane.showInputDialog(null, difficulty));
            return switch (size) {
                case 1 -> 4;
                case 2 -> 5;
                default -> 6;
            };
        } catch (NumberFormatException npe) {
            return 6;
        }
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(this);
    }
}