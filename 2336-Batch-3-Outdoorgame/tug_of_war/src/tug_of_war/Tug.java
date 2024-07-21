package tug_of_war;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;

public class Tug extends JPanel implements ActionListener, KeyListener {
    private int ropeWidth;
    private int ropeLength;
    private int teamSize;
    private int teamSpacing;
    private Timer timer;
    private int userStrength;
    private int computerStrength;
    private boolean userIsPulling;
    private Random random;
    private char targetKey;
    private char userKey;
    private int targetPresses; 
    private BufferedImage backgroundImage;
    private int backgroundX; // X-coordinate of the background image

    private JButton startButton;
    private int countdown;

    public Tug(int width, int length, int teamSize) {
        this.ropeWidth = width;
        this.ropeLength = length;
        this.teamSize = teamSize;
        this.teamSpacing = ropeWidth / (teamSize + 1);
        setPreferredSize(new Dimension(length, width));

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\lokes\\new eclips\\tug_of_war\\1697961063152.png")); // Change to the path of your image
        } catch (IOException e) {
            e.printStackTrace();
        }

        backgroundX = 0; 

        userStrength = teamSize * teamSpacing / 2;
        computerStrength = teamSize * teamSpacing / 2;
        userIsPulling = false;

        random = new Random();
        targetKey = generateRandomKey();
        userKey = ' ';
        targetPresses = 0;

        timer = new Timer(1000, this); 

        countdown = 5; 

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        setLayout(new BorderLayout());
        add(startButton, BorderLayout.SOUTH);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private char generateRandomKey() {
        String keys = "AQWERTYUIOPASDFGHJKLZXCVBNM";
        return keys.charAt(random.nextInt(keys.length()));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char pressedKey = Character.toUpperCase(e.getKeyChar());
        if (pressedKey == targetKey) {
            targetPresses--;

            backgroundX -= 5;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, -backgroundX, 0, getWidth(), getHeight(), this); 

        g.setColor(new Color(139, 69, 19)); 

        int y = (getHeight() - ropeWidth) / 2;
        int x = (getWidth() - ropeLength) / 2;

        g.fillRect(x, y, ropeLength, ropeWidth);

       
        g.setColor(Color.RED);
        g.fillRect(x + ropeLength / 2 - 5, y, 10, ropeWidth);

        int characterY = y + (ropeWidth - 40) / 2;
        int paddingX = 50;

        g.setColor(Color.BLUE);
        for (int i = 1; i <= teamSize; i++) {
            g.fillRect(x + paddingX + i * teamSpacing - 20, characterY, 20, 40);
        }

        g.setColor(Color.RED);
        for (int i = 1; i <= teamSize; i++) {
            g.fillRect(x + ropeLength - paddingX - i * teamSpacing, characterY, 20, 40);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("TUG OF WAR", (getWidth() - 150) / 2, 30); // Add the heading

        g.drawString("Countdown: " + countdown, 20, 60);

        g.drawString("Press '" + targetKey + "' " + targetPresses + " times to win.", 20, 90);
    }

    private void startGame() {
        countdown = 5; 
        targetKey = generateRandomKey();
        targetPresses = random.nextInt(9) + 7; 
        startButton.setEnabled(false);
        timer.start();
        backgroundX = 0; 
    }

    private void stopGame() {
        checkWin();
        countdown = 5; 
        startButton.setEnabled(true);
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (countdown > 0) {
            countdown--;
        } else {
            stopGame();
        }

        if (targetPresses == 0) {
            stopGame();
        }

        repaint();
    }

    private void checkWin() {
        if (targetPresses == 0) {
            JOptionPane.showMessageDialog(this, "User Wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "User Loses!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tug of War Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            int frameWidth = 900;
            int frameHeight = 400;

            frame.setSize(frameWidth, frameHeight);
            Tug game = new Tug(20, frameWidth - 2 * 50, 5);
            frame.add(game);
            frame.addKeyListener(game);
            frame.setVisible(true);
        });
    }
}
