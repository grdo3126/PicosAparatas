package pizzaMachine;

import pizzaMachine.implementation.PizzaMachine;
import pizzaMachine.implementation.Products;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Products p = new Products(10, 10, 11, 12, 10);
        PizzaMachine m = new PizzaMachine(p,"Laisvės pr.");

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose the number of pizza:");
            System.out.println("1. Capri");
            System.out.println("2. Margarita");
            System.out.println("3. Pizza with tomatoes");
            int pizzaNr = sc.nextInt();

            System.out.println("Enter the size of pizza: ");
            int pizzaSize = sc.nextInt();

            m.listMethod(pizzaSize,pizzaNr);
            //m.mapMethod(pizzaSize,pizzaNr);
            //m.makePizza(pizzaNr, pizzaSize);
            m.state();

//          m.fillProducts(new Products(1, 1, 1, 1, 1));

        } while (PizzaMachine.use < PizzaMachine.limit);
    }

}

