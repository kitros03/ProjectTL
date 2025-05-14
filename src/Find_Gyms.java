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

    public void addcompany(Company_User company) {
        try{
            if(companyList.contains(company)){
                System.out.println("company already exists");
        }
        else{
            companyList.add(company);
            System.out.println("company added successfully");
        }
        }
        catch(Exception e){
            System.out.println("Error adding company: " + e.getMessage());
        }
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

    public void adduser(User user) {
        try{
            if(userList.contains(user)){
                System.out.println("User already exists");
        }
        else{
            userList.add(user);
            System.out.println("User added successfully");
        }
        }
        catch(Exception e){
            System.out.println("Error adding user: " + e.getMessage());
        }
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
        System.out.println("Search any category, product, or pharmacy:");
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

    public void showuserProfile(int userId) {
        for (User user : userList) {
            if (user.getuser_id() == userId) {
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

    public void addToFavourites(String serviceName, int userId, String companyName) {
        boolean found = false;
        for (Company_User company : companyList) {
            if (company.getcompany_name().equals(companyName)) {
                found = true;
                break;
            }
        }
        Favourites fav = new Favourites();
        for (Services service : servicesList) {
            if (service.getservice_name().equals(serviceName) && service.getcompany_name().equals(companyName)) {
                fav.setservice_name(service.getservice_name());
                fav.setservice_price(service.getservice_price());
                fav.setservice_category(service.getservice_category());
                fav.setservice_id(service.getservice_id());
                fav.setcompany_id(service.getcompany_id());
                fav.setuser_id(userId);
                break;
            }
        }
        if (fav.getservice_name() == null) {
            System.out.println("Service not found.");
            return;
        }
        for (Favourites favourite : favouritesList) {
            if (favourite.getservice_name().equals(fav.getservice_name()) && favourite.getuser_id() == userId) {
                System.out.println("Service already in favourites.");
                return;
            }
        }
        favouritesList.add(fav);
        System.out.println("Service added to favourites: " + fav.getservice_name());
    }

    public void showUserFavourites(int userId) {
        System.out.println("Favourites for user ID " + userId + ":");
        for (Favourites fav : favouritesList) {
            if (fav.getuser_id() == userId) {
                System.out.println("- " + fav.getservice_name());
            }
        }
    }

    public void addToCart(String serviceName, int userId, String companyName) {
        boolean found = false;      
        for (Company_User company : companyList) {
            if (company.getcompany_name().equals(companyName)) {
                found = true;
                break;
            }
            else {
                System.out.println("company not found.");
                return;
            }
        }
        for(Services service : servicesList) {
            if (service.getservice_name().equals(serviceName) && service.getcompany_name().equals(companyName)) {
                Cart cart = new Cart();
                cart.setservice_id(service.getservice_id());
                cart.setcompany_id(service.getcompany_id());
                cart.setuser_id(userId);
                cart.setprice(service.getservice_price());
                System.out.println("Service added to cart: " + service.getservice_name());
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("Service not found.");
        }
    }

    public void showCart(int userId) {
        System.out.println("Cart for user ID " + userId + ":");
        for (Cart cart : cartList) {
            if (cart.getuser_id() == userId) {
                System.out.println("- Service ID: " + cart.getservice_id());
                System.out.println("- company ID: " + cart.getcompany_id());
                System.out.println("- Price: " + cart.getprice());
            }
        }
    }

    public void completeOrder(int userId) {
        System.out.println("Order completed for user ID " + userId);
        for (Cart cart : cartList) {
            if (cart.getuser_id() == userId) {
                System.out.println("- Service ID: " + cart.getservice_id());
                System.out.println("- company ID: " + cart.getcompany_id());
                System.out.println("- Price: " + cart.getprice());
                Order order = new Order(cart.getcompany_id(), cart.getuser_id());
                order.setService_id(cart.getservice_id());
                order.setService_name(cart.getservice_name());
                order.setService_price(cart.getprice());
                ordersList.add(order);
                System.out.println("Order added to orders list.");
            }
        }

    }

    public void cardCreation(int userId, int companyId) {
        My_Codes card = new My_Codes();
        card.setuser_id(userId);
        card.setcompany_id(companyId);
        card.setcard_number("CARD-" + userId + "-" + companyId);
        digitalCardList.add(card);
        System.out.println("Digital card created for user ID " + userId + " and company ID " + companyId);
    }
}
