package pizzaMachine.implementation;

import pizzaMachine.interfacesAndAbstracts.IRecipe;

public class Recipe implements IRecipe {

    String pizzaName;
    int pizzaSize;
    Products products;

    @Override
    public Products getUsedProducts(int pizzaSize) {
        if(products == null || pizzaSize == 0 || pizzaName == null){
            System.err.println("Wrong parameters");
            return null;
        }
        else {
            return products;
        }
    }

    @Override
    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public void setSize(int size) {
        this.pizzaSize = size;
    }

    @Override
    public int getSize() {
        return this.pizzaSize;
    }

    @Override
    public void setName(String name) {
        this.pizzaName = name;
    }

}
