import java.util.ArrayList;
public class IKEA {
    private ArrayList<Personnel>staff;
    private ArrayList<Order>done;
    public IKEA(){
        this.done = new ArrayList<Order>();
        this.staff = new ArrayList<Personnel>();
        this.staff.add(
            new Employee("mordecai","person","1-888-8888", 3)
        );
        this.staff.add(
            new Employee("rigby","trashboat","1-888-8888", 4)
        );      
        this.staff.add(
            new Employee("skips","person","1-888-8888", 5)
        );       
        this.staff.add(
            new Employee("pops","person","1-888-8888", 6)
        );      
        this.staff.add(
            new Employee("muscle","man","1-888-8888", 7)
        );      
        this.staff.add(
            new Manager("benson","[insert gumball pun]","1-888-8888", 8)
        );     

        this.assignStaff();
    }
    public void processOrder(){
        ArrayList<Employee>ar = this.getEmployee();
        int index = 0;
        while(index < ar.size()){
            if(ar.get(index).hasOrder()){
                this.done.add(ar.get(index).processOrder());
                break;
            }
        index++;
        }
    }
    public void assignOrder(){
        int index = 0;
        if(!this.getManager().getAssignments().isEmpty()){
            while(index < this.getEmployee().size()){
                if (!this.getEmployee().get(index).hasOrder()){
                   this.getManager().giveAssignment(0,this.getEmployee().get(index).getID());
                   break;
                }
                index++;
            }    
        }
        
    }
    public void switchStaff(){
        Manager m = new Manager("bob", "builder", "1-111-1111", 9);
        int index = 0;
        while (index < this.staff.size()){
            if (this.staff.get(index) instanceof Manager){
                //((Manager)this.staff.get(index)).getAssignments();
                m.setAssignments(((Manager)this.staff.get(index)).getAssignments());
                this.staff.remove(index);
               break;
            }
        index++;
        }
        this.staff.add(m);
        index = 0;
        while(index < this.staff.size()){ 
            if(this.staff.get(index) instanceof Employee){
                this.staff.remove(index);
            }
            else{
                index += 1;
            }

    }
        this.staff.add(
            new Employee("phil", "phil", "1-222-2222,", 10));
        this.staff.add(
            new Employee("adam", "adam", "3-333-3333,", 11));
        this.staff.add(
            new Employee("joe", "joe", "4-222-2222,", 12));
        this.staff.add(
            new Employee("ed", "ed", "5-222-2222,", 13));
        this.staff.add(
            new Employee("fred", "fredrickson", "6-222-2222,", 14));
        this.staff.add(
            new Employee("Guy", "Something", "7-222-2222,", 15));
        this.assignStaff();
    }

    public void assignStaff(){
        Manager m = this.getManager();
        int index = 0;
        while (index < this.staff.size()){
            if (this.staff.get(index) instanceof Employee){
                m.addEmployee((Employee) this.staff.get(index));
            }
        index++;
        }
    }
    public ArrayList<Order> getDone() {
        return done;
    }
    public Manager getManager(){
       int index = 0;
        while (index < this.staff.size()){
           if (this.staff.get(index) instanceof Manager){
                return (Manager) this.staff.get(index);
           }
           index++;
       }
       return null;
    }

    public ArrayList<Employee>getEmployee(){
        ArrayList<Employee> ar = new ArrayList<Employee>();
        int index = 0;
        while (index < this.staff.size()){
            if (this.staff.get(index) instanceof Employee){
                ar.add((Employee) this.staff.get(index));                        
            }
            index = index + 1; 
        }
        return ar;
    }
}


