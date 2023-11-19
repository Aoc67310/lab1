import java.awt.*;

class Main{
    public static void main(String[] args)
    {

        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        mechanic theo = new mechanic<>(20);

        theo.addList(saab);
        theo.addList(volvo);
        System.out.println(theo.carList);
    }
}