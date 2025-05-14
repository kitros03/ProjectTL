public class My_Codes extends User {
    private String card_number;
    private int business_id;
    private int user_id;

    public My_Codes() {
    }

    public My_Codes(String card_number, int business_id, int user_id) {
        this.card_number = card_number;
        this.business_id = business_id;
        this.user_id = user_id;
    }

    public String getcard_number() {
        return card_number;
    }

    public void setcard_number(String card_number) {
        this.card_number = card_number;
    }

    public int getbusiness_id() {
        return business_id;
    }

    public void setbusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

}

