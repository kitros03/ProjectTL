public Menu{
    private int business_id;
    private int service_id;
    private String service_name;
    private float service_price;
    private String service_category;

    public Menu() {}

    public Menu(int business_id, int service_id, String service_name, float service_price, String service_category) {
        this.business_id = business_id;
        this.service_category = service_category;
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_price = service_price;
    }