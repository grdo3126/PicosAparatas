package pizzaMachine.implementation;

public class Products {

    protected double cheese;
    protected double pad;
    protected double souce;
    protected double sausage;
    protected double tomatoe;

    public Products(double cheese, double pad, double souce, double sausage, double tomatoe){
        validating();
        this.cheese = cheese;
        this.pad = pad;
        this.souce = souce;
        this.sausage = sausage;
        this.tomatoe = tomatoe;
    }

    private void validating(){
        if(cheese < 0){
            cheese = 0;
        }
        if(pad < 0){
            pad = 0;
        }
        if(souce < 0){
            souce = 0;
        }
        if(sausage < 0){
            sausage = 0;
        }
        if(tomatoe < 0){
            tomatoe = 0;
        }
    }

    //ADDING PRODUCTS

    protected void addCheese(double cheese){
        if(cheese < 0){
            cheese = 0;
        }
        this.cheese += cheese;
    }

    protected void addPad(double pad){
        if(pad < 0){
            pad = 0;
        }
        this.pad += pad;
    }

    protected void addSouce(double souce){
        if(souce < 0){
            souce = 0;
        }
        this.souce += souce;
    }

    protected void addSausage(double sausage){
        if(sausage < 0){
            sausage = 0;
        }
        this.sausage += sausage;
    }

    protected void addTomatoe(double tomatoe){
        if(tomatoe < 0){
            tomatoe = 0;
        }
        this.tomatoe += tomatoe;
    }

    //REMOVING PRODUCTS

    protected void removeCheese(double cheese){
        if(cheese < 0){
            cheese = 0;
        }
        this.cheese -= cheese;
    }

    protected void removePad(double pad){
        if(pad < 0){
            pad = 0;
        }
        this.pad -= pad;
    }

    protected void removeSouce(double souce){
        if(souce < 0){
            souce = 0;
        }
        this.souce -= souce;
    }

    protected void removeSausage(double sausage){
        if(sausage < 0){
            sausage = 0;
        }
        this.sausage -= sausage;
    }

    protected void removeTomatoe(double tomatoe){
        if(tomatoe < 0){
            tomatoe = 0;
        }
        this.tomatoe -= tomatoe;
    }

    // GET THE AMOUNT OF PRODUCTS

    protected double getCheese(){
        return cheese;
    }

    protected double getPad(){
        return pad;
    }

    protected double getSouce(){
        return souce;
    }

    protected double getSausage(){
        return sausage;
    }

    protected double getTomatoe(){
        return tomatoe;
    }

}
