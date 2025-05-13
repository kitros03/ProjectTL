public class Temp_Cart {
    double sum;
    Company_User c_user = new Company_User();
    Services services = new Services();

    public Temp_Cart() {}

    public double getsum() {
        return sum;
    }

    public void setsum(double sum) {
        this.sum = sum;
    }

    public Company_User getc_user() {
        return c_user;
    }

    public void setc_user(Company_User c_user) {
        this.c_user = c_user;
    }

    public Services getservices() {
        return services;
    }

    public void setservices(Services services) {
        this.services = services;
    }

}