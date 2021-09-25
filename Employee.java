public class Employee extends Personnel{
    private Order order;
    public Employee (String fn, String ln, String pn, int ID){

    
     super(fn,ln,pn,ID);
     this.order = null;    
    }
    public Order processOrder(){
        System.out.println(this.order.getName() + " for " + this.order.getCustomer());
        System.out.println("is processed by " + this.getFirst_name());
        Order temp = this.order;
        this.order = null; 
        return temp;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public boolean hasOrder(){
        return this.order != null;        
    }
    
}
