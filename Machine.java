package pizzaMachine.interfacesAndAbstracts;

import pizzaMachine.implementation.Products;

public interface Machine {

    public APizza makePizza(int pizzaNr, int size);

    public void fillProducts(Products products);

}
