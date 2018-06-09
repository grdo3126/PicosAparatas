package pizzaMachine.implementation;

import pizzaMachine.interfacesAndAbstracts.Machine;

import java.util.*;

public class PizzaService {

    PizzaMachine pizzaMachine;
    List<Machine> pizzaMachinesList = new ArrayList();
    Map<Integer, String> pizzaMachinesAddressMap = new HashMap();

    //CONSTRUCTOR WITH ADDRESS MAP

    public PizzaService() {
        pizzaMachinesAddressMap.put(1, "Laivės pr.43-19");
        pizzaMachinesAddressMap.put(2, "Žirmūnų g. 6-5");
        pizzaMachinesAddressMap.put(3, "Gedimino pr.9");
        pizzaMachinesAddressMap.put(4, "Naugarduko 24");
        pizzaMachinesAddressMap.put(5, "Nemenčinės pl.51");
    }

    //CREATING NEW PIZZA MACHINE AND ADDING TO THE LIST

    public PizzaMachine createNewPizzaMachine(Products products, int addressNr) {
        pizzaMachine = new PizzaMachine(products, addressNr);
        pizzaMachinesList.add(pizzaMachine);
        return pizzaMachine;
    }

    //REMOVING PIZZA MACHINE FROM THE LIST

    public void deletePizzaMachine(int pizzaMachineNr) {
        pizzaMachinesList.remove(pizzaMachineNr - 1);
    }

    //PRINTING PIZZA MACHINES LIST

    public void printPizzaMachinesList() {
        System.out.println("Pizza machines list:");
        for (int i = 0; i < pizzaMachinesList.size(); i++) {
            System.out.println(pizzaMachinesList.get(i));
        }
    }
    //ORDERING PIZZA

    public void orderPizza() {

        Products p = new Products(10, 10, 11, 12, 10);

        do {
            Scanner sc = new Scanner(System.in);

            // CHOOSING THE ADDRESS NUMBER

            System.out.println("Choose the address you would like to order from:");
            for (int i = 1; i <= pizzaMachinesAddressMap.size(); i++) {
                System.out.println(i + ". " + pizzaMachinesAddressMap.get(i));
            }
            int addressNr = sc.nextInt();

            // CHOOSING PIZZA

            System.out.println("Choose the number of pizza:");
            System.out.println("1. Capri");
            System.out.println("2. Margarita");
            System.out.println("3. Pizza with tomatoes");
            int pizzaNr = sc.nextInt();

            // CHOOSING THE SIZE OF PIZZA

            System.out.println("Enter the size of pizza: ");
            int pizzaSize = sc.nextInt();

            // MAKING PIZZA

            createNewPizzaMachine(p, addressNr);        //CREATING NEW PIZZA MACHINE OBJECT
            printPizzaMachinesList();                   //PRINTING THE LIST OF THE MACHINES CREATED
            pizzaMachine.makePizza(pizzaNr, pizzaSize);  //MAKING SELECTED PIZZA FROM SELECTED PIZZA MACHINE
            deletePizzaMachine(1);             //TRYING TO DELETE SELECTED PIZZA MACHINE
            printPizzaMachinesList();                   // CHECKING IF IT IS DELETED SUCCESSFULY

        } while (PizzaMachine.use < PizzaMachine.limit);
    }

}
