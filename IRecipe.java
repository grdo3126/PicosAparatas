package pizzaMachine.interfacesAndAbstracts;

import pizzaMachine.implementation.Products;

public interface IRecipe {

    public Products getUsedProducts(int pizzaSize);

    public void setProducts(Products products);

    public void setSize(int size);

    public int getSize();

    public void setName(String name);

}
