
package ejercicio_3_poo;

public class Currency {

    private String name;
    private String sign;
    private double value;
    
    // The "value" variable is the percentage of value in comparison with the DOLLAR.
    
    public Currency (String name, String sign, double value) {
        this.name = name;
        this.sign = sign;
        this.value = value;
    }
    
    public Currency (String sign, double value) {
        this.name = "not specified";
        this.sign = sign;
        this.value = value;
    }

    Currency() {
        this.name = "not specified";
        this.sign = "not specified";
        this.value = 1;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    public void show() {
        System.out.println("Name : " + getName());
        System.out.println("Sign : " + getSign());
        System.out.println("Value: " + getValue() + sign + " = 1$");
    }
    
    public double getConvertion(double amount, Currency convertion) {
        // THE DOLLAR HAS AN VALUE OF 1.
        // THE EURO IS 84% of a dollar (0.84€ = 1$)
        // THE POUND IS 72% of a dollar (0.72₤ = 1$)
        // 10€ -> $ -> POUND
        double dollarAmount = amount/getValue();
        return (dollarAmount*convertion.getValue());
    }
}
