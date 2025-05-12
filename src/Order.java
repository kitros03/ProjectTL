public class Order {
    private int business_id;
    private int service_id;
    private String service_name;
    private float service_price;
    private String service_category;
    private int order_id;
    private int user_id;

    public Order(int business_id, int user_id) {
        this.business_id = business_id;
        this.user_id = user_id;
    };
    
    public Order(int business_id, int service_id, String service_name, float service_price, String service_category, int order_id, int user_id) {
        this.business_id = business_id;
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_price = service_price;
        this.service_category = service_category;
        this.order_id = order_id;
        this.user_id = user_id;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
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

    public float getService_price() {
        return service_price;
    }

    public void setService_price(float service_price) {
        this.service_price = service_price;
    }

    public String getService_category() {
        return service_category;
    }

    public void setService_category(String service_category) {
        this.service_category = service_category;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
