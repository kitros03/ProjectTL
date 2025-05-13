public class Company_User {
    private int company_id = 0;
    private String company_name;
    private int postal_code;
    private String email;
    private String address;
    private long phone_no;
    private long tax_id;
    private String password;

    public Company_User(){};

    public Company_User(int company_id, String company_name, int postal_code, String email, String address, long phone_no, long tax_id, String password){
        this.company_id = company_id;
        this.company_name = company_name;
        this.postal_code = postal_code;
        this.email = email;
        this.address = address;
        this.phone_no = phone_no;
        this.tax_id = tax_id;
        this.password = password;
    }

    public int getcompany_id(){
        return  company_id;
    }

    public String getcompany_name(){
        return company_name;
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

    public void setcompany_id(int company_id){
        this.company_id = company_id;
    }

    public void setcompany_name(String company_name){
        this.company_name = company_name;
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
