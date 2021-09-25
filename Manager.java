import java.util.ArrayList;
public class Manager extends Personnel {
    private ArrayList<Order>assignments;
    private ArrayList<Employee>overseen;
    public Manager(String fn, String ln, String pn, int ID){
        super(fn,ln,pn,ID);
        this.overseen = new ArrayList<Employee>(); 
        this.assignments = new ArrayList<Order>();
    }
    public void addEmployee(Employee A){
        this.overseen.add(A);
    }
    public void addOrder(Order B){
        this.assignments.add(B); 
    }
    public Employee removeEmployee(int index){
        return this.overseen.remove(index);
    }  
    public boolean giveAssignment(int Ordernum, int ID){
        Order order = this.assignments.get(Ordernum);
        Employee e = this.overseen.get(ID);
        if(e.hasOrder() != true ){
            e.setOrder(order);
            System.out.println("Order has been given to " + e.getFirst_name() + " " + e.getLast_name());
            this.assignments.remove(order);
            return true;
        }
        else{
            System.out.println("This order couldn't be assigned to" + e.getFirst_name() + e.getLast_name());
            return false;
        }
    }
    public ArrayList<Employee> getOverseen() {
        return overseen;
    }
    public ArrayList<Order> getAssignments() {
        return assignments;
    }
    public void setAssignments(ArrayList<Order> assignments) {
        this.assignments = assignments;
    }
}