public class Order {
    private String order_name;
    private String customer;
    public Order(String name, String cstmr){
        this.order_name = name;
        this.customer = cstmr;
    }

    public String getName() {
        return order_name;
    }
    public String getCustomer() {
        return customer; 
    }
    @Override
    public String toString(){
        return "order:" + this.getName()+ " for: " + this.getCustomer();
    }
}



