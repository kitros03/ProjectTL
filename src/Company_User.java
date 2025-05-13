public class Business_User {
    private int business_id = 0;
    private String business_name;
    private int postal_code;
    private String email;
    private String address;
    private long phone_no;
    private long tax_id;
    private String password;

    public Business_User(){};

    public Business_User(int business_id, String business_name, int postal_code, String email, String address, long phone_no, long tax_id, String password){
        this.business_id = business_id;
        this.business_name = business_name;
        this.postal_code = postal_code;
        this.email = email;
        this.address = address;
        this.phone_no = phone_no;
        this.tax_id = tax_id;
        this.password = password;
    }

    public int getbusiness_id(){
        return  business_id;
    }

    public String getbusiness_name(){
        return business_name;
    }

    public int getpostal_code(){
        return postal_code;
    }

    public String getemail(){
        return email;
    }

    public String getaddress(){
        return address;
    }

    public long getphone_no(){
        return phone_no;
    }

    public long gettax_id(){
        return tax_id;
    }

    public String getpassword(){
        return password;
    }

    public void setbusiness_id(int business_id){
        this.business_id = business_id;
    }

    public void setbusiness_name(String business_name){
        this.business_name = business_name;
    }

    public void setpostal_code(int postal_code){
        this.postal_code = postal_code;
    }

    public void setemail(String email){
        this.email = email;
    }

    public void setaddress(String address){
        this.address = address;
    }

    public void setphone_no(long phone_no){
        this.phone_no = phone_no;
    }

    public void settax_id(long tax_id){
        this.tax_id = tax_id;
    }

    public void setpassword(String password){
        this.password = password;
    }

}
