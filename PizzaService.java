package pizzaMachine.implementation;

import pizzaMachine.interfacesAndAbstracts.IRecipe;

import java.util.ArrayList;
import java.util.List;

public class PizzaService {

    PizzaMachine pizzaMachine;
    IRecipe recipe;
    List<String> pizzaMachinesList = new ArrayList();

    public PizzaService(PizzaMachine pizzaMachine, IRecipe recipe){
        this.pizzaMachine = pizzaMachine;
        this.recipe = recipe;
    }

    public PizzaMachine createNewPizzaMachine(Products products, String address){
        pizzaMachine = new PizzaMachine(products, address);
        return pizzaMachine;
    }
}
