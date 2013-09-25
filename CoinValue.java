public enum CoinValue{
    QUARTER(25),
    NICKEL(5),
    DIME(10);
    
    private int value;
    
    private CoinValue(int v){
        value = v;
    }
    
    public int getCoinValue() {
        return value;
    }
}
