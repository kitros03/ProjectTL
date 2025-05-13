public class Services {

    private int business_id;
    private int service_id;
    private String service_name;
    private float service_price;
    private String service_category;
    private String business_name;
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

    public String getbusiness_name(){
        return business_name;
    }

    public void setbusiness_id(int business_id){
        this.business_id = business_id;
    }

    public void setservice_id(int service_id){
        this.service_id = service_id;
    }

    public void setservice_name(String service_name){
        this.service_name = service_name;
    }

    public void setservice_price(float service_price){
        this.service_price = service_price;
    }

    public void setservice_category(String service_category){
        this.service_category = service_category;
    }

    public void setbusiness_name(String business_name){
        this.business_name = business_name;
    }
}
