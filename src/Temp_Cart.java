public class Temp_Cart {
    double sum;
    Business_User b_user = new Business_User();
    Services services = new Services();

    public Temp_Cart() {}

    public double getsum() {
        return sum;
    }

    public void setsum(double sum) {
        this.sum = sum;
    }

    public Business_User getb_user() {
        return b_user;
    }

    public void setb_user(Business_User b_user) {
        this.b_user = b_user;
    }

    public Services getservices() {
        return services;
    }

    public void setservices(Services services) {
        this.services = services;
    }

}