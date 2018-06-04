package pizzaMachine.implementation;

import pizzaMachine.interfacesAndAbstracts.APizza;
import pizzaMachine.interfacesAndAbstracts.IRecipe;
import pizzaMachine.interfacesAndAbstracts.Machine;

import java.util.*;

public class PizzaMachine implements Machine {

    Products p;                                 //PRODUCTS
    IRecipe r = new Recipe();                   //RECIPE
    public static int use = 0;                  //TIMES USING MACHINE
    public static final int limit = 20;         //LIMIT OF USING MACHINE
    String address;                             //MACHINE ADDRESS
    APizza aPizza;                              //PIZZA OBJECT

    public PizzaMachine(Products products, String address) {
        this.p = products;
        this.address = address;
    }

    protected void reduceProducts(Products p) {
        this.p.removeCheese(p.getCheese());
        this.p.removePad(p.getPad());
        this.p.removeSausage(p.getSausage());
        this.p.removeSouce(p.getSouce());
        this.p.removeTomatoe(p.getTomatoe());
    }

    protected void checkIsEnoughProducts(Products p) throws Exception {
        if (this.p.getPad() < p.getPad()) {
            throw new Exception("There is not enough pad");
        }
        if (this.p.getSouce() < p.getSouce()) {
            throw new Exception("There is not enough souce");
        }
        if (this.p.getCheese() < p.getCheese()) {
            throw new Exception("There is not enough cheese");
        }
        if (this.p.getSausage() < p.getSausage()) {
            throw new Exception("There is not enough sausage");
        }
        if (this.p.getTomatoe() < p.getTomatoe()) {
            throw new Exception("There is not enough tomatoes");

        }
    }

    // METHOD TO SET SIZE, PRODUCTS, NAME FOR PIZZAS AND CREATE NEW PIZZA OBJECT

    protected void settingTheParameters(int size,
                                        String pizzaName,
                                        double cheeseConstant,
                                        double padConstant,
                                        double souceConstant,
                                        double sausageConstant,
                                        double tomatoeConstant) {
        r.setSize(size);                                                //SETTING SIZE
        r.setProducts(new Products(cheeseConstant * size,       //SETTING PRODUCTS
                padConstant * size,
                souceConstant * size,
                sausageConstant * size,
                tomatoeConstant * size));
        r.setName(pizzaName);                                           //SETTING NAME
        this.aPizza = new Pizza(r, r.getSize(), pizzaName);             //ASSIGNING NEW PIZZA OBJECT TO aPizza VARIABLE
    }


    @Override
    public APizza makePizza(int pizzaNr, int size) {

        switch (pizzaNr) {
            case 1:
                settingTheParameters(size, "Capri",
                        0.25, 0.25, 0.25, 0.25, 0);
                break;
            case 2:
                settingTheParameters(size, "Margarita",
                        0.1, 0.1, 0.1, 0, 0);
                break;
            case 3:
                settingTheParameters(size, "Pizza with tomatoes",
                        0.2, 0.2, 0.2, 0.2, 0.2);
                break;
            default:
                System.out.println("Wrong choice");
                return null;
        }
        if (aPizza != null) {
            try {
                checkIsEnoughProducts(r.getUsedProducts(r.getSize()));
                reduceProducts(r.getUsedProducts(r.getSize()));
                System.out.println(aPizza.getName() + " is made!");
                use++;
                return aPizza;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        return aPizza;
    }

    //FILLING PRODUCTS

    @Override
    public void fillProducts(Products p) {
        this.p.addCheese(p.getCheese());
        this.p.addPad(p.getPad());
        this.p.addSouce(p.getSouce());
        this.p.addSausage(p.getSausage());
        this.p.addTomatoe(p.getTomatoe());
        System.out.println("Products are filled");
    }

    //STATE OF THE PRODUCTS LEFT

    public void state() {
        System.out.println("Products left:");
        System.out.println("Cheese left: " + this.p.getCheese());
        System.out.println("Pad left: " + this.p.getPad());
        System.out.println("Souce left: " + this.p.getSouce());
        System.out.println("Sausage left: " + this.p.getSausage());
        System.out.println("Tomatoes left: " + this.p.getTomatoe());
        System.out.println("Till wash:");
        System.out.println(limit - use);
    }

    //MACHINE CLEARING

    public void clear() {
        this.use = 0;
        System.out.println("Cleared");
    }

    //MAKING PIZZA USING MAPS

    public APizza mapMethod(int size, int pizzaNr) {

        Map<Integer, Object> makingPizza = new HashMap();  //Integer - pizza number, Object - pizza

        makingPizza.put(1, new Pizza(r, size, "Capri"));
        makingPizza.put(2, new Pizza(r, size, "Margarita"));
        makingPizza.put(3, new Pizza(r, size, "Pizza with tomatoes"));


        APizza pizza1 = (APizza) makingPizza.get(pizzaNr);

        if (pizza1 != null) {
            try {

                if(pizza1.getName().equals("Capri")) {
                    settingTheParameters(size, pizza1.getName(),
                            0.25, 0.25, 0.25, 0.25, 0);//??????????
                }if(pizza1.getName().equals("Margarita")) {
                    settingTheParameters(size, pizza1.getName(),
                            0.1, 0.1, 0.1, 0, 0);//??????????
                }if(pizza1.getName().equals("Pizza with tomatoes")) {
                    settingTheParameters(size, pizza1.getName(),
                            0.2, 0.2, 0.2, 0.2, 0.2);//??????????
                }
                checkIsEnoughProducts(r.getUsedProducts(r.getSize()));
                reduceProducts(r.getUsedProducts(r.getSize()));
                System.out.println(pizza1.getName() + " is made!");
                use++;
                return pizza1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        } else {
            System.out.println("Wrong choice");
            return null;
        }
        return pizza1;
    }

    //MAKING PIZZA USING LISTS

    public APizza listMethod(int size, int pizzaNr) {

        List<Object> makingPizza = new ArrayList();

        makingPizza.add(new Pizza(r, size, "Capri"));
        makingPizza.add(new Pizza(r, size, "Margarita"));
        makingPizza.add(new Pizza(r, size, "Pizza with tomatoes"));

        APizza pizza1 = (APizza) makingPizza.get(pizzaNr-1);

        if (pizza1 != null) {
            try {

                if(pizza1.getName().equals("Capri")) {
                    settingTheParameters(size, pizza1.getName(),
                            0.25, 0.25, 0.25, 0.25, 0);//??????????
                }if(pizza1.getName().equals("Margarita")) {
                    settingTheParameters(size, pizza1.getName(),
                            0.1, 0.1, 0.1, 0, 0);//??????????
                }if(pizza1.getName().equals("Pizza with tomatoes")) {
                    settingTheParameters(size, pizza1.getName(),
                            0.2, 0.2, 0.2, 0.2, 0.2);//??????????
                }
                checkIsEnoughProducts(r.getUsedProducts(r.getSize()));
                reduceProducts(r.getUsedProducts(r.getSize()));
                System.out.println(pizza1.getName() + " is made!");
                use++;
                return pizza1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        } else {
            System.out.println("Wrong choice");
            return null;
        }
        return pizza1;
    }
}


