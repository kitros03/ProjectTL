import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Find_Gym find_gym;
    Business_User b_user;
    Services services;
    User user;
    private int business_id = 0, user_id = 0, service_id = 0;

    
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

    public int getservice_id() {
        return service_id;
    }

    public void setservice_id(int service_id) {
        this.service_id = service_id;
    }

    public int getuser_info(String username, String password) {

        for (Business_User bussinesuserE : find_gym.businessList) {
            if (bussinesuserE.getbusiness_name().equals(username) && bussinesuserE.getpassword().equals(password)) {
                int businessid = bussinesuserE.getbusiness_id();
                String businessname = bussinesuserE.getbusiness_name();
                String businessemail = bussinesuserE.getemail();
                String businessaddress = bussinesuserE.getaddress();
                long businessphone = bussinesuserE.getphone_no();
                int businesspostalcode =   bussinesuserE.getpostal_code();
                long businesstaxid = bussinesuserE.gettax_id();
                bussinesuserE = new Business_User(businessid, businessname, businesspostalcode, businessemail, businessaddress, businessphone, businesstaxid, password);
                return 1;
            }
        }

        for (User userE : find_gym.userList) {
            if (userE.getusername().equals(username) && userE.getpassword().equals(password)) {
                int ID = userE.getuser_id();
                String fname = userE.getfirstname();
                String lname = userE.getlastname();
                String email = userE.getemail();
                String address = userE.getaddress();
                String phone = userE.getphone_number();
                user = new User(ID, fname, lname, username, email, password, phone, address);
                return 2;
            }
        }
        return 0;
    }

    public void newbusiness_user_info() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Creating your business account...");
        System.out.println("Give your gym's name:");
        String name = scan.nextLine();
        System.out.println("Give your address");
        String address = scan.nextLine();
        System.out.println("Give your Phone Number:");
        long phone_number = scan.nextLong();
        System.out.println("Give your Postal Code:");
        int postal_code = scan.nextInt();
        System.out.println("Give your email:");
        String email = scan.nextLine();
        System.out.println("Give your Tax Id (TIN):");
        long tax_id = scan.nextLong();
        System.out.println("Password:");
        String password = scan.nextLine();
        System.out.println("Repeat Password:");
        b_user = new Business_User(this.business_id, name, postal_code, email, address, phone_number, tax_id, password);
        find_gym.addbusiness(b_user);
        this.business_id++;
    }

    public void newuser_info() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Creating your account...");
        System.out.println("Give your username:");
        String username = scan.nextLine();
        System.out.println("Give your email:");
        String email = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();
        user = new User(this.user_id, null, null, username, email, password, null, null);
        find_gym.adduser(user);
        this.user_id++;
    }

    public void menu(Find_Gym find_gym) {
        this.find_gym = find_gym;
    }

    public void newservices() {
        Scanner scanner = new Scanner(System.in);
        int service_count;
        boolean flag = false;
        System.out.print("Enter the number of products you want to add: ");
        service_count = scanner.nextInt();
        scanner.nextLine();
        List<Services> newservices_list = new ArrayList<>();

        for (int i = 0; i < service_count; i++) {
            System.out.println("Enter details for the (" + (i+1) + ") service you want to add:");
            System.out.print("Service Name:");
            String service_name = scanner.nextLine();
            System.out.print("Service Price:");
            float service_price = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Service category:");
            String service_category = scanner.nextLine();
            flag = false;
            for (Services services : find_gym.servicesList) {
                if (service_name.equals(services.getservice_name())) {
                    services = new Services(b_user.getbusiness_id(), services.getservice_id(), service_name, service_price, service_category);
                    flag = true;
                }
            }
            if (!flag) {
                services = new Services(b_user.getbusiness_id(), this.service_id, service_name, service_price, service_category);
                this.service_id++;
            }
            newservices_list.add(services);
            flag  = false;
        }
        find_gym.servicesList.addAll(newservices_list);
    }


    public void showmenu() {
        boolean flag = false, back = false;
        Scanner scan = new Scanner(System.in);
        int sign = 0;
        while (sign != 1 && sign != 2) {
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("Choose an option: (Give number)");
            sign = scan.nextInt();
            scan.nextLine();
            if (sign != 1 && sign != 2)
                System.out.println("Choose a valid option");
        }

        if (sign == 1) {
            String username, password;
            System.out.print("Username:");
            username = scan.nextLine();
            System.out.print("Password:");
            password = scan.nextLine();
            int acc = getuser_info(username, password);
            if (acc == 1) {
                while (flag == false) {
                    System.out.println("Welcome " + b_user.getbusiness_name() + " to GYMHUB");
                    System.out.println("-------------------------------");
                    System.out.println("1.Find Gyms");
                    System.out.println("2.Services");
                    System.out.println("3.Profile");
                    System.out.println("4.Subscription History");
                    System.out.println("5.Announcements");
                    System.out.println();
                    System.out.println("Choose an option: (Give number)");
                    int insert;
                    insert = scan.nextInt();
                    switch (insert) {
                        case 1:
                            back = false;
                            int search ;
                                while (back == false) {
                                    System.out.println("1. Search");
                                    System.out.println("2. Show categories");
                                    System.out.println("3. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int case1 = scan.nextInt();
                                    scan.nextLine();
                                    if (case1 == 1){
                                        find_gym.search();
                                    }
                                    else if (case1 == 2){
                                    find_gym.showCategories();
                                    System.out.println("1. Find services for a category");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Give the category you are interested in: (Give Name)");
                                        String category = scan.nextLine();
                                        find_gym.showCategoryServices(category);
                                        System.out.println("1. Get info for a service");
                                        System.out.println("2. Go back:");
                                        System.out.println();
                                        System.out.println("Choose an option: (Give number)");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1){
                                            System.out.println("Give the service you are interested in: (Give Name)");
                                            String service = scan.nextLine();
                                            System.out.println();
                                            find_gym.showServiceInfo(service);
                                            System.out.println("1. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1)
                                                back = true;
                                        }

                                            else if (check == 2)
                                                back = true;
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                  }
                                    else if (case1 == 3)
                                        back = true;
                                }
                            break;

                        case 2:
                            back = false;
                            System.out.println("1. Services");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                newservices();
                                System.out.println("Services added to your gym!");
                                System.out.println();
                                back = true;
                            }
                            break;


                        case 3:
                            back = false;
                            System.out.println("1. Profile");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.showBuserInfo(b_user.getbusiness_name());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email)");
                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new Name:");
                                            String name = scan.nextLine();
                                            for (Business_User bUser : find_gym.businessList ){
                                                if (bUser.getbusiness_id() == b_user.getbusiness_id())
                                                    bUser.setbusiness_name(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (Business_User bUser : find_gym.businessList ){
                                                if (bUser.getbusiness_id() == b_user.getbusiness_id())
                                                    bUser.setaddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (Business_User bUser : find_gym.businessList ){
                                                if (bUser.getbusiness_id() == b_user.getbusiness_id())
                                                    bUser.setphone_no(phone);
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (Business_User bUser : find_gym.businessList ){
                                                if (bUser.getbusiness_id() == b_user.getbusiness_id())
                                                    bUser.setemail(email);
                                            }
                                        }

                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;
                        }
                        case 4:
                            back = false;
                            System.out.println("1.Subscription History");
                            System.out.println("2.Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.OrderHistory(b_user.getbusiness_id());
                                    System.out.println("1. Go Back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 5:
                            flag = true;
                            break;
                    }
                }
                flag = true;
            } else if (acc == 2) {
                while (flag == false) {
                    System.out.println();
                    System.out.println("Welcome " + user.getfirstname() + " "+ user.getlastname() + " to GymHub!");
                    System.out.println("------------------------");
                    System.out.println("1.Search categories");
                    System.out.println("2.Show categories");
                    System.out.println("3.Favorites");
                    System.out.println("4.Shopping Cart");
                    System.out.println("5.Profile");
                    System.out.println("6.Exit");
                    System.out.println();
                    System.out.println("Choose an option: (Give number)");
                    int eisodos;
                    Scanner eis = new Scanner(System.in);
                    eisodos = eis.nextInt();

                    switch (eisodos) {
                        case 1:
                            back = false;
                            int search ;
                            while (back == false) {
                                System.out.println("1. Search");
                                System.out.println("2. Go back");
                                System.out.println();
                                System.out.println("Choose an option (Give number)");
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    find_gym.search();
                                }
                                else if (case1 == 2)
                                    back = true;
                            }
                            break;
                        case 2:
                            back = false;
                            System.out.println("1. Show categories");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.showCategories();
                                    System.out.println("1. Find services for a category");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int  check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        System.out.println("Give the category you are interested in: (Give name)");
                                        String category = scan.nextLine();
                                        find_gym.showCategoryServices(category);
                                        System.out.println("1. Get info for a service");
                                        System.out.println("2. Go back");
                                        System.out.println();
                                        System.out.println("Choose an option: (Give number)");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1) {
                                            System.out.println("Give the service you are interested in: (Give name)");
                                            String service_name = scan.nextLine();
                                            find_gym.showServiceInfo(service_name);
                                            System.out.println("1. Add Service to Favourites");
                                            System.out.println("2. Add Service to Cart");
                                            System.out.println("3. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1) {
                                                System.out.println("Give the name of the Gym you want to add the service from:");
                                                String gym = scan.nextLine();
                                                find_gym.addToFavourites(service_name, user.getuser_id(), gym);
                                                find_gym.showUserFavourites(user.getuser_id());
                                                back = true;
                                            }
                                            if (c == 2) {
                                                System.out.println("Give the name of the Gym you want to buy the service from:");
                                                String gym = scan.nextLine();
                                                find_gym.addToCart(service_name, user.getuser_id(), gym);
                                                System.out.println("Service added to cart.");
                                                find_gym.showCart(user.getuser_id());
                                                System.out.println("Do you want to complete your order?");
                                                System.out.println("1. Yes.");
                                                System.out.println("2. No.");
                                                c = scan.nextInt();
                                                scan.nextLine();
                                                if (c == 1) {
                                                    find_gym.completeOrder(user.getuser_id());
                                                    back = true;
                                                }
                                                back = true;
                                            }
                                            if (c == 3)
                                                back = true;
                                        } else if (check == 2)
                                            back = true;
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;
                        case 3:
                            back = false;
                            System.out.println("1. Favourite products");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.showUserFavourites(user.getuser_id());
                                    System.out.println("1. Remove a service from Favourite List");
                                    System.out.println("2. Remove all services from Favourite List");
                                    System.out.println("3. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Name of the gym the service belongs to:");
                                        String pharm = scan.nextLine();
                                        int businessID = -1;
                                        int serviceID = -1;
                                        for (Business_User gym_user : find_gym.businessList){
                                            if (gym_user.getbusiness_name().equals(pharm))
                                                businessID = gym_user.getbusiness_id();
                                        }
                                        System.out.println("Name of the service you want to delete:");
                                        String servString = scan.nextLine();
                                        List<Favourites> removeProductFromFavorite = new ArrayList<>();

                                        for (Favourites favour1 : find_gym.favouritesList) {
                                            if (user.getuser_id() == favour1.getuser_id() && favour1.getbusiness_id() == businessID) {
                                                for (Services serv : find_gym.servicesList) {
                                                    if (serv.getservice_name().equals(servString) && serv.getbusiness_id() == businessID) {
                                                        serviceID = serv.getservice_id();
                                                    }
                                                }
                                                if (favour1.getservice_id() == serviceID) {
                                                    removeProductFromFavorite.add(favour1);
                                                }
                                            }
                                        }

                                        find_gym.favouritesList.removeAll(removeProductFromFavorite);
                                    }
                                    if (check == 2){
                                        List<Favourites> removeUserFavorites = new ArrayList<>();
                                        for (Favourites fav : find_gym.favouritesList) {
                                            if (user.getuser_id() == fav.getuser_id()) {
                                                removeUserFavorites.add(fav);
                                            }
                                        }
                                        find_gym.favouritesList.removeAll(removeUserFavorites);
                                    }
                                    if (check == 3) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 4:
                            back = false;
                            System.out.println("1. Cart");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.showCart(user.getuser_id());
                                    System.out.println("1. Complete Order");
                                    System.out.println("2. Remove a service from cart");
                                    System.out.println("3. Remove all services from cart");
                                    System.out.println("4. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1)
                                        find_gym.OrderServices(user.getuser_id());
                                    if (check == 2){
                                        System.out.println("Name of the pharmacy you want to delete the product from:");
                                        String gym = scan.nextLine();
                                        int businessID = -1;
                                        int serviceID = -1;
                                        for (Business_User gym_user : find_gym.businessList){
                                            if (gym_user.getbusiness_name().equals(gym))
                                                businessID = gym_user.getbusiness_id();
                                        }
                                        System.out.println("Name of the product you want to delete:");
                                        String servString = scan.nextLine();
                                        List<Cart> removeServiceFromCart = new ArrayList<>();

                                        for (Cart cart1 : find_gym.cartList) {
                                            if (user.getuser_id() == cart1.getuser_id() && cart1.getbusiness_id() == businessID) {
                                                for (Services serv : find_gym.servicesList) {
                                                    if (serv.getservice_name().equals(servString) && serv.getbusiness_id() == businessID) {
                                                        serviceID = serv.getservice_id();
                                                    }
                                                }
                                                if (cart1.getservice_id() == serviceID) {
                                                    removeServiceFromCart.add(cart1);
                                                }
                                            }
                                        }

                                        find_gym.cartList.removeAll(removeServiceFromCart);
                                    }
                                    if (check == 3){
                                        List<Cart> removeServiceFromCart = new ArrayList<>();
                                        for (Cart cart2 : find_gym.cartList) {
                                            if (user.getuser_id() == cart2.getuser_id()) {
                                                removeServiceFromCart.add(cart2);
                                            }
                                        }
                                        find_gym.cartList.removeAll(removeServiceFromCart);
                                    }

                                    if (check == 4) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 5:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            System.out.println("Choose an option (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.showUserProfile(user.getuser_id());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println("Choose an option (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email, Username)");
                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new First Name:");
                                            String fname = scan.nextLine();
                                            for (User user1 : find_gym.userList ){
                                                if (user.getuser_id() == user1.getuser_id())
                                                    user1.setfirstname(username);
                                            }
                                            System.out.println("Give new Last Name:");
                                            String lname = scan.nextLine();
                                            for (User user1 : find_gym.userList ){
                                                if (user.getuser_id() == user1.getuser_id())
                                                    user1.setlastname(lname);
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (User user2 : find_gym.userList) {
                                                if (user.getuser_id() == user2.getuser_id())
                                                    user2.setaddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            String phone = scan.nextLine();
                                            scan.nextLine();
                                            for (User user3 : find_gym.userList ){
                                                if (user.getuser_id() == user3.getuser_id())
                                                    user3.setphone_number(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (User user4 : find_gym.userList ){
                                                if (user.getuser_id() == user4.getuser_id())
                                                    user4.setemail(email);
                                            }
                                        }
                                        if (edit.equals("Username") ){
                                            System.out.println("Give new Username:");
                                            String uname = scan.nextLine();
                                            for (User user5 : find_gym.userList ){
                                                if (user.getuser_id() == user5.getuser_id())
                                                    user5.setusername(uname);
                                            }
                                        }

                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;
                        }
                        case 6:
                            flag = true;
                            break;
                    }
                }
            }
        } else if (sign == 2) {
            int creatingAccount = 0;
            while (creatingAccount != 1 && creatingAccount != 2) {
                System.out.println("1. Create a business account.");
                System.out.println("2. Create a customer account");
                creatingAccount = scan.nextInt();
                scan.nextLine();
                if (creatingAccount != 1 && creatingAccount != 2)
                    System.out.println("Choose a valid option");
            }
            if (creatingAccount == 1) {
                newbusiness_user_info();
                while (flag == false) {
                    System.out.println("Welcome " + b_user.getbusiness_name() + " to GymHub!");
                    System.out.println("-------------------------------");
                    System.out.println("1.Search or Show categories");
                    System.out.println("2.Add service");
                    System.out.println("3.Profile");
                    System.out.println("4.Show order history");
                    System.out.println("5.Exit");
                    System.out.println();
                    System.out.println("Choose an option: (Give number)");
                    int insert;
                    insert = scan.nextInt();

///
/// ////
/// /               Stin 333 grammi en exume order history mesto find_gym. 
///                 Sto edit profile pio panw allaxa ta onomata metavlitwn alla prepi na prosthesume j gia ta extra dika mas info
/// /               prepei na prosthesoume kai to digitalcard
/// /               stin 550 kai 608 den exume tis methodous sto find_gym
/// /               prepei na ginei announcement obj
/// 
/// /
/// /
/// /
/// 


                    switch (insert) {
                        case 1:
                            back = false;
                            int search ;
                            while (back == false) {
                                System.out.println("1. Search");
                                System.out.println("2. Show categories");
                                System.out.println("3. Go back");
                                System.out.println();
                                System.out.println("Choose an option: (Give number)");
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    find_gym.search();
                                }
                                else if (case1 == 2){
                                    find_gym.showCategories();
                                    System.out.println("1. Find services for a category");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Give the category you are interested in: (Give Name)");
                                        String category = scan.nextLine();
                                        System.out.println();
                                        find_gym.showCategoryServices(category);
                                        System.out.println("1. Get info for a service");
                                        System.out.println("2. Go back:");
                                        System.out.println();
                                        System.out.println("Choose an option: (Give number)");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1){
                                            System.out.println("Give the service you are interested in: (Give Name)");
                                            String serviceString = scan.nextLine();
                                            System.out.println();
                                            find_gym.showServiceInfo(serviceString);
                                            System.out.println("1. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1)
                                                back = true;
                                        }

                                        else if (check == 2)
                                            back = true;
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                                else if (case1 == 3)
                                    back = true;
                            }
                            break;

                        case 2:
                            back = false;
                            System.out.println("1. Add services");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                newservices();
                                System.out.println("Services added to your page!");
                                System.out.println();
                                back = true;
                            }
                            break;


                        case 3:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.showBusinessProfile(b_user.getbusiness_id());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email)"); //ADD NEW
                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new Name:");
                                            String name = scan.nextLine();
                                            for (Business_User buser1 : find_gym.businessList ){
                                                if (buser1.getbusiness_id() == b_user.getbusiness_id())
                                                    buser1.setbusiness_name(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (Business_User buser2 : find_gym.businessList){
                                                if (buser2.getbusiness_id() == b_user.getbusiness_id())
                                                    buser2.setaddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (Business_User buser3 : find_gym.businessList ){
                                                if (buser3.getbusiness_id() == b_user.getbusiness_id())
                                                    buser3.setphone_no(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (Business_User buser4 : find_gym.businessList ){
                                                if (buser4.getbusiness_id() == b_user.getbusiness_id())
                                                    buser4.setemail(email);
                                            }
                                        }
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;

                        case 4:
                            back = false;
                            System.out.println("1.Sales History");
                            System.out.println("2.Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.OrderHistory(b_user.getbusiness_id());
                                    System.out.println("1. Go Back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 5:
                            flag = true;
                            break;
                    }


                }
                flag = true;
            }
            else if (creatingAccount == 2) {
                newUserInfo();
                while (flag == false) {
                    System.out.println();
                    System.out.println("Welcome " + user.getfirstname() + " " + user.getlastname() +" to Galenus Pharmacy");
                    System.out.println("------------------------");
                    System.out.println("1.Search categories");
                    System.out.println("2.Show categories");
                    System.out.println("3.Favorites");
                    System.out.println("4.Shopping Cart");
                    System.out.println("5.Profile");
                    System.out.println("6.Exit");
                    System.out.println();
                    System.out.println("Choose an option: (Give number)");
                    int eisodos;
                    Scanner eis = new Scanner(System.in);
                    eisodos = eis.nextInt();

                    switch (eisodos) {
                        case 1:
                            back = false;
                            int search ;
                            while (back == false) {
                                System.out.println("1. Search");
                                System.out.println("2. Go back");
                                System.out.println();
                                System.out.println("Choose an option (Give number)");
                                int case1 = scan.nextInt();
                                scan.nextLine();
                                if (case1 == 1){
                                    find_gym.search();
                                }
                                else if (case1 == 2)
                                    back = true;
                            }
                            break;
                        case 2:
                            back = false;
                            System.out.println("1. Show categories");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    find_gym.showCategories();
                                    System.out.println("1. Find services for a category");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int  check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1) {
                                        System.out.println("Give the category you are interested in: (Give name)");
                                        String category = scan.nextLine();
                                        find_gym.showCategoryServices(category);
                                        System.out.println("1. Get info for a service");
                                        System.out.println("2. Go back");
                                        System.out.println();
                                        System.out.println("Choose an option: (Give number)");
                                        check = scan.nextInt();
                                        scan.nextLine();
                                        if (check == 1) {
                                            System.out.println("Give the service you are interested in: (Give name)");
                                            String product = scan.nextLine();
                                            find_gym.showProductInfo(product);
                                            System.out.println("1. Add Product to Favorites");
                                            System.out.println("2. Add Product to Shopping Cart");
                                            System.out.println("3. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1) {
                                                System.out.println("Give the name of the pharmacy you want to add the product to favorites from:");
                                                String pharm = scan.nextLine();
                                                eshop.addToFavorites(product, user.getUser_ID(), pharm);
                                                System.out.println("Product added to favorites.");
                                                eshop.showUserFavorites(user.getUser_ID());
                                                back = true;
                                            }
                                            if (c == 2) {
                                                System.out.println("Give the name of the pharmacy you want to buy the product from:");
                                                String pharm = scan.nextLine();
                                                System.out.println("Give the amount of " + product + " you want to add to your shopping cart:");
                                                int amount = scan.nextInt();
                                                scan.nextLine();
                                                eshop.addToShoppingCart(product, user.getUser_ID(), pharm, amount);
                                                System.out.println("Product added to shopping cart.");
                                                eshop.showShoppingCart(user.getUser_ID());
                                                System.out.println("Do you want to complete your order?");
                                                System.out.println("1. Yes.");
                                                System.out.println("2. No.");
                                                c = scan.nextInt();
                                                scan.nextLine();
                                                if (c == 1) {
                                                    eshop.OrderProducts(user.getUser_ID());
                                                    back = true;
                                                }
                                                back = true;
                                            }
                                            if (c == 3)
                                                back = true;
                                        } else if (check == 2)
                                            back = true;
                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;
                        case 3:
                            back = false;
                            System.out.println("1. Favorite products");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option: (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showUserFavorites(user.getUser_ID());
                                    System.out.println("1. Remove a product from Favorite List");
                                    System.out.println("2. Remove all products from Favorite List");
                                    System.out.println("3. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Name of the pharmacy you want to delete the product from:");
                                        String pharm = scan.nextLine();
                                        int pharmacyId = -1;
                                        int productId = -1;
                                        for (Pharmacy_User pharmacyy : eshop.pharmacyUserList){
                                            if (pharmacyy.getPharmacy_Name().equals(pharm))
                                                pharmacyId = pharmacyy.getPharmacy_ID();
                                        }
                                        System.out.println("Name of the product you want to delete:");
                                        String prod = scan.nextLine();
                                        List<Favorite> removeProductFromFavorite = new ArrayList<>();

                                        for (Favorite favor1 : eshop.favoriteList) {
                                            if (user.getUser_ID() == favor1.getUser_ID() && favor1.getPharmacy_ID() == pharmacyId) {
                                                for (Products prods : eshop.productsList) {
                                                    if (prods.getProduct_Name().equals(prod) && prods.getPharmacy_ID() == pharmacyId) {
                                                        productId = prods.getProduct_id();
                                                    }
                                                }
                                                if (favor1.getProduct_ID() == productId) {
                                                    removeProductFromFavorite.add(favor1);
                                                }
                                            }
                                        }

                                        eshop.favoriteList.removeAll(removeProductFromFavorite);
                                    }
                                    if (check == 2){
                                        List<Favorite> removeUserFavorites = new ArrayList<>();
                                        for (Favorite fav : eshop.favoriteList) {
                                            if (user.getUser_ID() == fav.getUser_ID()) {
                                                removeUserFavorites.add(fav);
                                            }
                                        }
                                        eshop.favoriteList.removeAll(removeUserFavorites);
                                    }
                                    if (check == 3) {
                                        back = true;
                                    }
                                }
                            }
                            break;

                        case 4:
                            back = false;
                            System.out.println("1. Shopping Cart");
                            System.out.println("2. Go back");
                            System.out.println();
                            System.out.println("Choose an option (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showShoppingCart(user.getUser_ID());
                                    System.out.println("1. Complete Order");
                                    System.out.println("2. Remove a product from shopping cart");
                                    System.out.println("3. Remove all products from shopping cart");
                                    System.out.println("4. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1)
                                        eshop.OrderProducts(user.getUser_ID());
                                    if (check == 2){
                                        System.out.println("Name of the pharmacy you want to delete the product from:");
                                        String pharm = scan.nextLine();
                                        int pharmacyId = -1;
                                        int productId = -1;
                                        for (Pharmacy_User pharmacyy : eshop.pharmacyUserList){
                                            if (pharmacyy.getPharmacy_Name().equals(pharm))
                                                pharmacyId = pharmacyy.getPharmacy_ID();
                                        }
                                        System.out.println("Name of the product you want to delete:");
                                        String prod = scan.nextLine();
                                        List<Cart> removeProductFromCart = new ArrayList<>();

                                        for (Cart cartt : eshop.cartList) {
                                            if (user.getUser_ID() == cartt.getUser_ID() && cartt.getPharmacy_ID() == pharmacyId) {
                                                for (Products prods : eshop.productsList) {
                                                    if (prods.getProduct_Name().equals(prod) && prods.getPharmacy_ID() == pharmacyId) {
                                                        productId = prods.getProduct_id();
                                                    }
                                                }
                                                if (cartt.getProduct_ID() == productId) {
                                                    removeProductFromCart.add(cartt);
                                                }
                                            }
                                        }

                                        eshop.cartList.removeAll(removeProductFromCart);
                                    }
                                    if (check == 3){
                                        List<Cart> removeProductFromCart = new ArrayList<>();
                                        for (Cart carttt : eshop.cartList) {
                                            if (user.getUser_ID() == carttt.getUser_ID()) {
                                                removeProductFromCart.add(carttt);
                                            }
                                        }
                                        eshop.cartList.removeAll(removeProductFromCart);
                                    }

                                    if (check == 4) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 5:
                            back = false;
                            System.out.println("1. See profile");
                            System.out.println("2. Go back");
                            System.out.println("Choose an option (Give number)");
                            search = scan.nextInt();
                            scan.nextLine();
                            if (search == 2)
                                break;
                            else {
                                while (back == false) {
                                    eshop.showUserProfile(user.getUser_ID());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println("Choose an option (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email, Username)");
                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new Name:");
                                            String name = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setFullname(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (User userr : eshop.userList) {
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setAddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setPhone_number(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setEmail(email);
                                            }
                                        }
                                        if (edit.equals("Username") ){
                                            System.out.println("Give new Username:");
                                            String name = scan.nextLine();
                                            for (User userr : eshop.userList ){
                                                if (user.getUser_ID() == userr.getUser_ID())
                                                    userr.setUsername(name);
                                            }
                                        }

                                    }
                                    if (check == 2) {
                                        back = true;
                                    }
                                }
                            }
                            break;


                        case 6:
                            flag = true;
                            break;
                    }
                }
            }
        }
    }

}
}