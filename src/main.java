public class main{
    public static void main(String[] args){

        Services serv = new Services();
        Cart cart =  new Cart();
        User user = new User();
        Company_User c_user =new Company_User();
        Find_Gyms fgym = new Find_Gyms();
        Menu menu = new Menu();
        int user_id = 0;
        int company_id = 0;
        int service_id = 0;

        c_user = new Company_User(company_id, "Athlesis", 26221, "athlesis@gymhub.com", "Korinthou, 123", "6912345678", 123456789, "password");
        fgym.addcompany(c_user);
        company_id++;
        menu.setcompany_id(company_id);

        c_user = new Company_User(company_id, "GainsFactory", 26221, "gains_factory@gmail.com", "Kanakari, 68", "6912345687", 987654321, "password");
        fgym.addcompany(c_user);
        company_id++;
        menu.setcompany_id(company_id);

        c_user = new Company_User(company_id, "Sporting Centre", 26223, "sportingcentre@yahoo.com", "Konstantinoupoleos, 50", "6912345696", 123456789, "password");
        fgym.addcompany(c_user);
        company_id++;
        menu.setcompany_id(company_id);

        serv = new Services(1, service_id, "1 Month Subscription", 40.0f, "Subscription");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(1, service_id, "3 Month Subscription", 100.0f, "Subscription");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(1, service_id, "Personal Training(Per month)", 120.0f, "Personal Training");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(2, service_id, "1 Month Subscription", 35.0f, "Subscription");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(2, service_id, "4 Month Subscription", 115.0f, "Subscription");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(2, service_id, "Personal Training(Per month)", 100.0f, "Personal Training");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(3, service_id, "1 Month Subscription", 50.0f, "Subscription");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(3, service_id, "3 Month Subscription", 130.0f, "Subscription");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(3, service_id, "Yoga Class(Per Month)", 50.0f, "Classes");
        fgym.addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        user = new User(user_id, "Antreas", "Kerkidis", "antreas_kerkidis", "antkerk123@gmail.com", "kerk99", "Korinthou 20", "6944559591");
        fgym.adduser(user);
        user_id++;
        menu.setuser_id(user_id);

        user = new User(user_id, "Dimitris", "Gewrgiou", "dimitris_gewrgiou", "dimigew23@gmail.com", "dimitris02", "Karaiskaki 64", "6944559678");
        fgym.adduser(user);
        user_id++;
        menu.setuser_id(user_id);

        user = new User(user_id, "Pantelis", "Petrou", "pantelis_petrou", "pantpet69@gmail.com", "petrou03", "Zaimi 12", "6944128561");
        fgym.adduser(user);
        user_id++;
        menu.setuser_id(user_id);

        menu.showmenu();
    }
}