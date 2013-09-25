

import java.util.Random;

public class HasCoinState implements State {
    GumballMachine gumballMachine;
    int currentCoinValue = 0;
    int currentGumballValue = 50;
 
    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    public void insertCoin(CoinValue coin) {
        currentCoinValue += coin.getCoinValue();
        if(currentCoinValue <= currentGumballValue) {
            System.out.println("Coin Inserted. Current Coin inserted value is: "+currentCoinValue+" cents");
        } else {
            System.out.println("Max 50 cents accepted. Returning change: "+(currentCoinValue-currentGumballValue)+" cents");
            currentCoinValue = currentGumballValue;
        }
    }
 
    public void ejectCoin() {
        System.out.println("Returning all coins...");
        gumballMachine.setState(gumballMachine.getNoCoinState());
        currentCoinValue = 0;
    }
 
    public void turnCrank() {
        System.out.println("You turned...");
        if(currentCoinValue-currentGumballValue < 0) {
            System.out.println("You need to put minimum 50 cents to get a gumball. You put only "+currentCoinValue+ "cents");
            ejectCoin();
        }else {
            gumballMachine.setState(gumballMachine.getSoldState());
            currentCoinValue = 0;
        } 
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "waiting for turn of crank";
    }
    
    public void takeGumball(){
        System.out.println("No gumball in slot");
    }
}
