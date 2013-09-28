

import java.util.Random;

public class HasCoinState implements State {
    GumballMachine gumballMachine;
   
 
    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    public void insertCoin(CoinValue coin) {
        gumballMachine.setCurrentValueOfInsertedCoins(gumballMachine.getCurrentValueOfInsertedCoins()+ coin.getCoinValue());
        System.out.println("Coin Inserted. Current Coin inserted value is: "+gumballMachine.getCurrentValueOfInsertedCoins()+" cents");
    }
 
    public void ejectCoin() {
        System.out.println("Returning all coins...");
        gumballMachine.setState(gumballMachine.getNoCoinState());
        gumballMachine.setCurrentValueOfInsertedCoins(0);
    }
 
    public void turnCrank() {
        System.out.println("You turned crank...");
        if(gumballMachine.getCurrentValueOfInsertedCoins() - GumballMachine.gumballPrice < 0) {
            System.out.println("You need to put minimum 50 cents to get a gumball. You put only "+gumballMachine.getCurrentValueOfInsertedCoins()+ "cents");
        }else {
            gumballMachine.setState(gumballMachine.getSoldState());
        } 
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "waiting for turn of crank";
    }
    
    public void takeGumball(){
        if(gumballMachine.getNumOfGumballInSlot() > 0) {
            System.out.println(gumballMachine.getNumOfGumballInSlot()+ " Gumball taken from slot.");
            gumballMachine.setNumOfGumballInSlot(0);
        } else {
            System.out.println("No Gumball in slot.");
        }
    }
}
