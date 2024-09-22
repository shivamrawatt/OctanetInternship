public class octanetCalc {

    private boolean isVeg;
    private boolean isPremium;

    public octanetCalc(boolean isVeg, boolean isPremium) {
        this.isVeg = isVeg;
        this.isPremium = isPremium;
}

public double getCost() {
        double cost = 0;
        if (isVeg) {
            cost += 250;

        } else {
            cost += 300;

        }
        if (isPremium) {
            cost += 100;

        }
        return cost;
    }

    public double addToppings(double cost, String toping) {
        if (toping.equals("cheese")) {
            cost += 20;

        } else if (toping.equals("chicken")) {
            cost += 50;
        } else if (toping.equals("Onion")) {
            cost += 15;
        }
        return cost;
    }

    public double addTax(double cost) {
        return cost + cost * 0.05;
    }

    public double addDiscount(double cost, double discount){
        return cost - cost*discount;

    }

    public static void main(String [] args) {
        System.out.println("*Welcome to my Pizza Shop!*");
        System.out.println("select the pizza type:");
        System.out.println("1. Veg");
        System.out.println("2. Non Veg");
        System.out.print("Enter the choice:");
        int choice = Integer.parseInt(System.console().readLine());
        boolean isVeg = false;
        if (choice==1){
            isVeg=true;

        }
        System.out.println("Do you want premium pizza?");  
        System.out.println("1. Yes ");  
        System.out.println("2. No");  
        System.out.print("Enter the choice:");  
        choice = Integer.parseInt(System.console().readLine());
        boolean isPremium= false;
        if (choice==1){
            isPremium=false;

        }
        octanetCalc receipt = new octanetCalc(isVeg, isPremium);
        double cost = receipt.getCost();

        System.out.println("Do you want to add any topping?");
        System.out.println("1. cheese");
        System.out.println("2. Chicken");
        System.out.println("3. Onion");
        System.out.println("4. No Toppings");
        System.out.print("Enter the choice:");
        choice = Integer.parseInt(System.console().readLine());
        if(choice!=4){
            String topping = "";
            if (choice==1){
                topping="Cheese";
            }
             else if (choice==2){
                topping="Chicken";
             }
           else if (choice==3){
                topping="Onion";
            }
            cost = receipt.addToppings(cost,topping);
        }
        System.out.println("Do you have any discount coupon?");
        System.out.println("1. Yes ");
        System.out.println("2. No");
        System.out.print("Enter the choice");
        choice = Integer.parseInt(System.console().readLine());
        if (choice==1){
            System.out.println("Enter the discount coupon:");
            double discount = Double.parseDouble(System.console().readLine());
            cost = receipt.addDiscount(cost, discount);
        }
        cost = receipt.addTax(cost);
        System.out.println("Total Cost: Rs."+cost);            
        }
    }
