import java.util.Scanner;
import java.util.ArrayList;

public class Find_Gyms {
    String name = "Find Gym";
    User user;
    Company_User c_user;
    Services serv;
    ArrayList<Services> servicesList = new ArrayList<>();
    ArrayList<Company_User> companyList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<String> companyNameList = new ArrayList<>();
    ArrayList<String> serviceCategoryList = new ArrayList<>();
    ArrayList<String> serviceNameList = new ArrayList<>();
    ArrayList<Favourites> favouritesList = new ArrayList<>();
    ArrayList<Cart> cartList = new ArrayList<>();
    ArrayList<My_Codes> digitalCardList = new ArrayList<>();
    ArrayList<My_Gyms> MyGymsList = new ArrayList<>();
    ArrayList<Order> ordersList = new ArrayList<>();
    ArrayList<Announcements> announcementsList = new ArrayList<>();

    public void findGym() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the gym you are looking for:");
        String gymName = scanner.nextLine();
        boolean found = false;

        for (Company_User company : companyList) {
            if (company.getcompany_name().equalsIgnoreCase(gymName)) {
                System.out.println("Gym found: " + company.getcompany_name());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Gym not found.");
        }
    
    }

    public int addcompany(Company_User company) {
        try{
            for (Company_User existingCompany : companyList) {
                if (existingCompany.getcompany_name().equals(company.getcompany_name())) {
                    System.out.println("Company already exists");
                    return 0;
                }
                if (existingCompany.getemail() == company.getemail()) {
                    System.out.println("Company email already exists");
                    return 0;
                }
            }
            companyList.add(company);
            System.out.println("company added successfully");
        
        }
        catch(Exception e){
            System.out.println("Error adding company: " + e.getMessage());
        }
        return 1;
    }

    public void addservice(Services service) {
        try{
            if(servicesList.contains(service)){
                System.out.println("Service already exists");
        }
        else{
            servicesList.add(service);
            System.out.println("Service added successfully");
        }
        }
        catch(Exception e){
            System.out.println("Error adding service: " + e.getMessage());
        }
    }

    public int adduser(User user) {
        try{
            for(User existingUser : userList) {
                if (existingUser.getusername().equals(user.getusername())) {
                    System.out.println("Username already exists");
                    return 0;
                }
                if (existingUser.getemail().equals(user.getemail())) {
                    System.out.println("Email already exists");
                    return 0;
                }
            }
            userList.add(user);
            System.out.println("User added successfully");
        }
        catch(Exception e){
            System.out.println("Error adding user: " + e.getMessage());
        }
        return 1;
    }

    public void showCategories(){
        System.out.println("Available service categories:");
        for (String category : serviceCategoryList) {
            System.out.println("- " + category);
        }
    }

    public void showCategoryServices(String category) {
        System.out.println("Available services:");
        for (Services service : servicesList) {
            if(service.getservice_category().equals(category)){
                System.out.println("- " + service.getservice_name());
            }
        }
    }

    public void search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Search any category, product, or gym:");
        String search = scan.nextLine();
        for (String categor : serviceCategoryList) {
            if (categor.equals(search))
                showCategoryServices(search);
        }
        for (Services service : servicesList){
            if (service.getservice_category().equals(search))
                showServiceInfo(search);
        }
        for (Company_User cuser : companyList) {
            if (search.equals(cuser.getcompany_name())) {
                showcuserInfo(search);
                System.out.println();
                showcompanyServices(search);
            }
        }
    }

    public void showServiceInfo(String serviceName) {
        for (Services service : servicesList) {
            if (service.getservice_name().equals(serviceName)) {
                System.out.println("Service Name: " + service.getservice_name());
                System.out.println("Service Price: " + service.getservice_price());
                System.out.println("Service Category: " + service.getservice_category());
            }
        }
    }

    public void showcuserInfo(String companyName) {
        for (Company_User cuser : companyList) {
            if (cuser.getcompany_name().equals(companyName)) {
                System.out.println("company Name: " + cuser.getcompany_name());
                System.out.println("company ID: " + cuser.getcompany_id());
                System.out.println("company Address: " + cuser.getaddress());
                System.out.println("company Phone: " + cuser.getphone_no());
            }
        }
    }

    public void showuserProfile(int userid) {
        for (User user : userList) {
            if (user.getuser_id() == userid) {
                System.out.println("User Name: " + user.getfirstname() +" " + user.getlastname()); 
                System.out.println("User Username: " + user.getusername());
                System.out.println("User ID: " + user.getuser_id());
                System.out.println("User Email: " + user.getemail());
                System.out.println("User Phone: " + user.getphone_number());
                System.out.println("User Address: " + user.getaddress());
            }
        }
    }

    public void showcompanyServices(String companyName) {
        for (Company_User cuser : companyList) {
            if (cuser.getcompany_name().equals(companyName)) {
                System.out.println("Services offered by " + cuser.getcompany_name() + ":");
                for (Services service : servicesList) {
                    if (service.getcompany_id() == cuser.getcompany_id()) {
                        System.out.println("- " + service.getservice_name());
                    }
                }
            }
        }
    }

    public void addToFavourites(String serviceName, int userid, int company_id) {
        boolean found = false;
        for (Company_User company : companyList) {
            if (company.getcompany_id() == company_id) {
                found = true;
                break;
            }
        }
        Favourites fav = new Favourites();
        for (Services service : servicesList) {
            if (service.getservice_name().equals(serviceName) && service.getcompany_id() == company_id) {
                fav.setservice_name(service.getservice_name());
                fav.setservice_price(service.getservice_price());
                fav.setservice_category(service.getservice_category());
                fav.setservice_id(service.getservice_id());
                fav.setcompany_id(service.getcompany_id());
                fav.setuser_id(userid);
                break;
            }
        }
        if (fav.getservice_name() == null) {
            System.out.println("Service not found.");
            return;
        }
        for (Favourites favourite : favouritesList) {
            if (favourite.getservice_name().equals(fav.getservice_name()) && favourite.getuser_id() == userid) {
                System.out.println("Service already in favourites.");
                return;
            }
        }
        favouritesList.add(fav);
        System.out.println("Service added to favourites: " + fav.getservice_name());
    }

    public void showUserFavourites(int userid) {
        System.out.println("Favourites for user ID " + userid + ":");
        for (Favourites fav : favouritesList) {
            if (fav.getuser_id() == userid) {
                System.out.println("- " + fav.getservice_name());
            }
        }
    }

    public void addToCart(String serviceName, int userid, int company_id) {
        boolean found = false;      
        for (Company_User company : companyList) {
            if (company.getcompany_id() == company_id) {
                found = true;
                break;
            }
            else {
                System.out.println("company not found.");
                return;
            }
        }
        for(Services service : servicesList) {
            if (service.getservice_name().equals(serviceName) && service.getcompany_id() == company_id) {
                Cart cart = new Cart();
                cart.setservice_id(service.getservice_id());
                cart.setcompany_id(service.getcompany_id());
                cart.setuser_id(userid);
                cart.setprice(service.getservice_price());
                System.out.println("Service added to cart: " + service.getservice_name());
                cartList.add(cart);
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("Service not found.");
        }
    }

    public void showCart(int userid) {
        System.out.println("Cart for user ID " + userid + ":");
        for (Cart cart : cartList) {
            if (cart.getuser_id() == userid) {
                System.out.println("- Service ID: " + cart.getservice_id());
                System.out.println("- company ID: " + cart.getcompany_id());
                System.out.println("- Price: " + cart.getprice());
            }
        }
    }

    public void completeOrder(int userid) {
        System.out.println("Order completed for user ID " + userid);
        for (Cart cart : cartList) {
            if (cart.getuser_id() == userid) {
                System.out.println("- Service ID: " + cart.getservice_id());
                System.out.println("- company ID: " + cart.getcompany_id());
                System.out.println("- Price: " + cart.getprice());
                Order order = new Order(cart.getcompany_id(), cart.getuser_id());
                order.setservice_id(cart.getservice_id());
                order.setservice_name(cart.getservice_name());
                order.setservice_price(cart.getprice());
                ordersList.add(order);
                System.out.println("Order added to orders list.");
            }
        }

    }

    public void cardCreation(int userid, int companyid) {
        My_Codes card = new My_Codes();
        for (My_Codes existingCard : digitalCardList) {
            if (existingCard.getuser_id() == userid && existingCard.getcompany_id() == companyid) {
                System.out.println("Digital card already exists for user ID " + userid + " and company ID " + companyid);
                return;
            }
        }
        card.setuser_id(userid);
        card.setcompany_id(companyid);
        card.setcard_number("CARD-" + userid + "-" + companyid);
        digitalCardList.add(card);
        System.out.println("Digital card created for user ID " + userid + " and company ID " + companyid);
    }

    public void AddGymToMyGyms(int userid, int companyid, String companyName, int serviceid) {
        for (My_Gyms existingGym : MyGymsList) {
            if (existingGym.getuser_id() == userid && existingGym.getcompany_id() == companyid) {
                System.out.println("Company ID" + companyid + "is already in My Gyms for user with ID" + userid);
                return;
            }
        }
        My_Gyms myGym = new My_Gyms();
        myGym.setuser_id(userid);
        myGym.setcompany_id(companyid);
        myGym.setcompany_name(companyName);
        myGym.setservice_id(serviceid);
        MyGymsList.add(myGym);
        System.out.println("Gym added to My Gyms list for user ID " + userid);
    }

    public void showSubscriptionHistory(int userid) {
        System.out.println("Subscription history for user ID " + userid + ":");
        for (Order order : ordersList) {
            if (order.getuser_id() == userid) {
                System.out.println("- Order ID: " + order.getorder_id());
                System.out.println("  Service Name: " + order.getservice_name());
                System.out.println("  Service Price: " + order.getservice_price());
                System.out.println("  Company ID: " + order.getcompany_id());
            }
        }
    }
    
  public void addusers(){
        Company_User c_user;
        Services serv;
        Menu menu = new Menu();
        User user;
        int company_id = 1;
        int user_id = 1;
        int service_id = 1;
        c_user = new Company_User(company_id, "Athlesis", 26221, "athlesis@gymhub.com", "Korinthou, 123", "6912345678", 123456789, "password");
        addcompany(c_user);
        company_id++;
        menu.setcompany_id(company_id);

        c_user = new Company_User(company_id, "GainsFactory", 26221, "gains_factory@gmail.com", "Kanakari, 68", "6912345687", 987654321, "password");
        addcompany(c_user);
        company_id++;
        menu.setcompany_id(company_id);

        c_user = new Company_User(company_id, "Sporting Centre", 26223, "sportingcentre@yahoo.com", "Konstantinoupoleos, 50", "6912345696", 123456789, "password");
        addcompany(c_user);
        company_id++;
        menu.setcompany_id(company_id);

        serv = new Services(1, service_id, "1 Month Subscription", 40.0f, "Subscription");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(1, service_id, "3 Month Subscription", 100.0f, "Subscription");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(1, service_id, "Personal Training(Per month)", 120.0f, "Personal Training");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(2, service_id, "1 Month Subscription", 35.0f, "Subscription");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(2, service_id, "4 Month Subscription", 115.0f, "Subscription");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(2, service_id, "Personal Training(Per month)", 100.0f, "Personal Training");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(3, service_id, "1 Month Subscription", 50.0f, "Subscription");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(3, service_id, "3 Month Subscription", 130.0f, "Subscription");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        serv = new Services(3, service_id, "Yoga Class(Per Month)", 50.0f, "Classes");
        addservice(serv);
        service_id++;
        menu.setservice_id(service_id);

        user = new User(user_id, "Antreas", "Kerkidis", "antreas_kerkidis", "antkerk123@gmail.com", "kerk99", "Korinthou 20", "6944559591");
        adduser(user);
        user_id++;
        menu.setuser_id(user_id);

        user = new User(user_id, "Dimitris", "Gewrgiou", "dimitris_gewrgiou", "dimigew23@gmail.com", "dimitris02", "Karaiskaki 64", "6944559678");
        adduser(user);
        user_id++;
        menu.setuser_id(user_id);

        user = new User(user_id, "Pantelis", "Petrou", "pantelis_petrou", "pantpet69@gmail.com", "petrou03", "Zaimi 12", "6944128561");
        adduser(user);
        user_id++;
        menu.setuser_id(user_id);
    }
}
