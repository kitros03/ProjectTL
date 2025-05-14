public class Offer extends Services {
    private int service_id;
    private String service_name;
    private String service_description;
    private double service_price;
    private double service_new_price;

    public Offer() {
    }

    public Offer(int service_id, String service_name, String service_description, double service_price, double service_new_price) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_description = service_description;
        this.service_price = service_price;
        this.service_new_price = service_new_price;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public double getService_price() {
        return service_price;
    }

    public void setService_price(double service_price) {
        this.service_price = service_price;
    }

    public double getService_new_price() {
        return service_new_price;
    }

    public void setService_new_price(double service_new_price) {
        this.service_new_price = service_new_price;
    }
}