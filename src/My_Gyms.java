public class My_Gyms {
    private int company_id;
    private int user_id;
    private int service_id;
        
    public My_Gyms() {
    }

    public My_Gyms(int company_id, int user_id, int service_id) {
        this.company_id = company_id;
        this.user_id = user_id;
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
    
    public int getservice_id() {
        return service_id;
    }

    public void setservice_id(int service_id) {
        this.service_id = service_id;
    }

}
