import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DeflaterInputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    // Added: an array of BufferdImmages to generalise and make adding an image to an object easier and
    // more compact.
    ArrayList<BufferedImage> images = new ArrayList<>(3);

    // Added: an array of points that makes it possible to track and print their positions
    private ArrayList<Point> points = new ArrayList<>(3);

    // TODO: Make this genereal for all cars
    // Added: Generalizes for each car added in cc.cars (CarController)
    public void moveit(ArrayList<Vehicle> CARS){
        for ( int i = 0;i < CARS.size(); i++){
            points.add(i, CARS.get(i).point);
        }
        //carPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in Intelli


            // Added: Add a new photo of a car as needed
            images.add(0,ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            images.add(1,ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            images.add(2,ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));


        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Added: Draws each car with their respected image and position
        for( int i = 0; i < images.size(); i++){
            g.drawImage(images.get(i),
                    points.get(i).x, points.get(i).y, null );
                    System.out.println(points.get(i).x);
        }
        //g.drawImage(carImage0, carPoint.x, carPoint.y, null); // Original code
    }
}
