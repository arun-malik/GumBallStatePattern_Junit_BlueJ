

public class GumballMachine implements IGumballMachine {
 
    State soldOutState;
    State noCoinState;
    State hasCoinState;
    State soldState;
    State hasGumballInSlotState;
 
    State state = soldOutState;
    int count = 0;
 
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        hasGumballInSlotState = new HasGumballInSlotState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noCoinState;
        } 
    }
    

    public boolean isGumballInSlot(){
        if(getState().equals(hasGumballInSlotState)) {
            System.out.println("Gumball is present in slot");
            return true;
        }
        System.out.println("No Gumball is present in slot");
        return false;
    }
    
    public void takeGumballFromSlot(){
        state.takeGumball();
    }
 
    public void insertQuarter() {
        state.insertCoin(CoinValue.QUARTER);
    }
    
    public void insertDime(){
        state.insertCoin(CoinValue.DIME);
    }
    public void insertNickel(){
        state.insertCoin(CoinValue.NICKEL);
    }
 
    public void ejectQuarter() {
        state.ejectCoin();
    }
 
    public void turnCrank() {
        state.turnCrank();
        if(getState().equals(soldState)) {
            state.dispense();
        }
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        System.out.println("A gumball comes rolling out in the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }
 
    int getCount() {
        return count;
    }
 
    void refill(int count) {
        this.count = count;
        state = noCoinState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }
    
    public State getHasGumballInSlotState() {
        return hasGumballInSlotState;
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
		return result.toString();
    }
}
