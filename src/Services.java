public class Services {

    private int business_id;
    private int service_id;
    private String service_name;
    private float service_price;
    private String service_category;
    public Services() {};

    public Services(int business_id, int service_id, String service_name, float service_price, String service_category){
        this.business_id = business_id;
        this.service_category = service_category;
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_price = service_price;
    }

    public int getbusiness_id(){
        return business_id;
    }

    public int getservice_id(){
        return service_id;
    }

    public String getservice_name(){
        return service_name;
    }

    public float getservice_price(){
        return service_price;
    }

    public String getservice_category(){
        return service_category;
    }
}
