import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.DeflaterInputStream;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DrawPanel extends JPanel{


    ArrayList<BufferedImage> images = new ArrayList<>(3);

    private ArrayList<Point> points = new ArrayList<>();

    ArrayList<Vehicle> carsDP = new ArrayList<>(3);



    public void uppdatecarlist(ArrayList<Vehicle> CARS) {
        carsDP = CARS;
    }
    // TODO: Make this genereal for all cars
    // Added: Generalizes for each car added in cc.cars (CarController)
    public void moveit(){
        if (points.size() > carsDP.size()){
            points.remove(points.size() -1 );

        }

        if (carsDP.size() == (points.size() + 1)) {
            points.add(carsDP.size()- 1, new Point(carsDP.get(carsDP.size() - 1).point.x, points.get(points.size() - 1).y + 50 ));
            carsDP.get(carsDP.size()- 1).point = new Point(carsDP.get(carsDP.size() - 1).point.x, points.get(points.size() - 1).y );

        } else if (carsDP.size() > points.size()) {
            for (int i = 0; (carsDP.size() != points.size()); i++) {
                points.add(i, carsDP.get(i).point);
            }

        }else if (carsDP.size() == points.size()) {
            for (int i = 0; i < carsDP.size(); i++) {
                points.set(i, carsDP.get(i).point);
            }
        }
    }


    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.CYAN);
        try {

            images.add(0,ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            images.add(1,ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            images.add(2,ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Added: Draws each car with their respected image and position
        for( int i = 0; i < carsDP.size(); i++){
            if (Objects.equals(carsDP.get(i).modelName, "Volvo240")){
                g.drawImage(images.get(0),
                        points.get(i).x, points.get(i).y, null );
            } else if (Objects.equals(carsDP.get(i).modelName, "Saab95")){
                g.drawImage(images.get(1),
                        points.get(i).x, points.get(i).y, null );
            } else if (Objects.equals(carsDP.get(i).modelName, "Scania")) {
                g.drawImage(images.get(2),
                        points.get(i).x, points.get(i).y, null);
            }
            //System.out.println(points.get(i).y);
        }
        //g.drawImage(carImage0, carPoint.x, carPoint.y, null); // Original code
    }
}
