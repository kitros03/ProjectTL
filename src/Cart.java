public class Cart {
    private int service_id;
    private int company_id;
    private double service_price;
    private int user_id;

    public double getprice() {
        return service_price;
    }

    public void setprice(double service_price) {
        this.service_price = service_price;
    }

    public int getservice_id() {
        return service_id;
    }

    public void setservice_id(int service_id) {
        this.service_id = service_id;
    }

    public int getcompany_id() {
        return company_id;
    }

    public void setcompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public Cart(){}

    public Cart(int service_id, int company_id, int user_id, double service_price) {
        this.service_id = service_id;
        this.company_id = company_id;
        this.user_id = user_id;
        this.service_price = service_price;
    }
}