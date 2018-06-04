package pizzaMachine.implementation;

import pizzaMachine.interfacesAndAbstracts.APizza;

public class Pizza extends APizza {

    String pizzzaName;

    public Pizza(pizzaMachine.interfacesAndAbstracts.IRecipe IRecipe, int size, String pizzzaName) {
        super(IRecipe, size);
        this.pizzzaName = pizzzaName;
    }

    @Override
    public pizzaMachine.interfacesAndAbstracts.IRecipe getIRecipe() {
        return super.getIRecipe();
    }

    @Override
    public String getName() {
        return this.pizzzaName;
    }
}
