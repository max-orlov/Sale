package sales;

public class RandomNumberGenerator {
    private int minimumValue;
    private int maximumValue;

    public RandomNumberGenerator(int minimumValue, int maximumValue) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

    public int random() {
        return (int)(minimumValue + Math.random() * maximumValue);
    }

    public void setValues(int minimumValue, int maximumValue){
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }

}
