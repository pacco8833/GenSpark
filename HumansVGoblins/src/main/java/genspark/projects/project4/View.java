package genspark.projects.project4;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class View extends JFrame implements Runnable {

    GridLayout layout;

    View(String title, int size) {
        super(title);
        layout = new GridLayout(size, size);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(size * 150, size * 150);
        setLayout(new BorderLayout());
        setResizable(false);
    }

    public static int chooseDifficulty() {

        try {
            int size = Integer.parseInt(JOptionPane.showInputDialog(null,
                    """
                            Choose a Difficulty
                            1 -> Short  (5 squares)
                            2 -> Medium (10 Squares)
                            3 -> Long   (15 Squares) <- default value
                            """));
            return switch (size) {
                case 1 -> 5;
                case 2 -> 10;
                default -> 15;
            };
        } catch (NullPointerException npe) {
            System.exit(0);
            return -1;
        }
    }

    public void introduce(Map<String, String> gamePieces) {
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
        intro = intro.replace("%you", gamePieces.get("player"));
        intro = intro.replace("%goblin", gamePieces.get("monster"));
        intro = intro.replace("%cash", gamePieces.get("treasure"));
        popupMsg(intro);
    }

    public void mapGamePieces(String[][] map) {
        JPanel pane = new JPanel(layout);
        final Font f = new Font("Segoe UI Emoji", Font.BOLD, 60);

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
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(this);
    }
}