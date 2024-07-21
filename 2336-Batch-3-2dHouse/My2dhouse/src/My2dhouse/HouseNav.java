package My2dhouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Room {
    private String name;
    private int width;
    private int height;
    private Color color;

    public Room(String name, int width, int height, Color color) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
}

class House {
    private List<Room> rooms;

    public House() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }
}

public class HouseNav extends JPanel {
    private House house;
    private int currentRoomIndex;
    private boolean showInitialHouse;

    private static final List<Image> houseImages = new ArrayList<>();
    static {
        houseImages.add(new ImageIcon("C:\\Users\\lokes\\eclipse-workspace\\My2dhouse\\image\\house_front.png").getImage()); // Replace with the path to your house image
    }

    public HouseNav(House house) {
        this.house = house;
        currentRoomIndex = 0;
        showInitialHouse = true;

        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.PLAIN, 12));
        nextButton.setPreferredSize(new Dimension(60, 30));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextRoom();
            }
        });

        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showNextRoom() {
        if (showInitialHouse) {
            showInitialHouse = false;
        } else {
            currentRoomIndex = (currentRoomIndex + 1) % house.getRooms().size();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (showInitialHouse) {
            // Display the initial front-side drawing of the house
            int imageWidth = houseImages.get(0).getWidth(this);
            int imageHeight = houseImages.get(0).getHeight(this);
            g.drawImage(houseImages.get(0), 0, 0, imageWidth, imageHeight, this);
        } else {
            // Display individual rooms (Living Room, Bedroom, Kitchen, etc.)
            Room currentRoom = house.getRooms().get(currentRoomIndex);

            // Determine the position of the current room based on its name
            int roomX, roomY;
            if (currentRoom.getName().equals("Living Room")) {
                roomX = 50;
                roomY = 200;
            } else if (currentRoom.getName().equals("Bedroom")) {
                roomX = 250;
                roomY = 200;
            } else if (currentRoom.getName().equals("Kitchen")) {
                roomX = 450;
                roomY = 200;
            } else {
                // Add more room positions as needed
                roomX = 0;
                roomY = 0;
            }

            // Draw the current room
            g.setColor(currentRoom.getColor());
            g.fillRect(roomX, roomY, currentRoom.getWidth(), currentRoom.getHeight());

            // Draw room name
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString(currentRoom.getName(), roomX + 10, roomY + 30);

            // Draw an outer box for the current room
            g.setColor(Color.BLACK);
            g.drawRect(roomX - 5, roomY - 5, currentRoom.getWidth() + 10, currentRoom.getHeight() + 10);
        }
    }

    public static void main(String[] args) {
        House house = new House();
        house.addRoom(new Room("Living Room", 120, 180, Color.RED));
        house.addRoom(new Room("Bedroom", 100, 150, Color.BLUE));
        house.addRoom(new Room("Kitchen", 80, 120, Color.YELLOW));
        // Add more rooms as needed

        JFrame frame = new JFrame("2D House with Different Room Locations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new HouseNav(house));
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
