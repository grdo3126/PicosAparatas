package pizzaMachine.interfacesAndAbstracts;

public abstract class APizza {

    protected pizzaMachine.interfacesAndAbstracts.IRecipe IRecipe;
    private int size;

    public APizza(pizzaMachine.interfacesAndAbstracts.IRecipe IRecipe, int size){
        this.IRecipe = IRecipe;
        this.size = size;
    }

    public pizzaMachine.interfacesAndAbstracts.IRecipe getIRecipe(){
        return IRecipe;
    }

    //public int getSize(){
//        return size;
//    }

    //padarom kad pica butinai turi turet pavadinima

    public abstract String getName();

}
