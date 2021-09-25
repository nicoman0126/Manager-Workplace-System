class Personnel{
    private String first_name = "";
    private String last_name = "";
    private String phone_number = "";
    private int ID = 0;

    public Personnel(String fn, String ln, String pn, int ID){
        this.first_name = fn;
        this.last_name = ln;
        this.phone_number = pn;
        this.ID = ID;
    }
    public String getFirst_name() {
        return first_name;
    
    }
    public String getLast_name() {
        return last_name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public int getID() {
        return ID;
    }
    @Override
    public String toString(){
        return this.getFirst_name() + " " + this.getLast_name();
    }
}

