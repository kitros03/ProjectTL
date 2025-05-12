public class Order_History extends Order{
    private String email;

    public Order_History(int business_id, int user_id, String email){
        super(business_id, user_id);
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
