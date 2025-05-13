import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Find_Gyms find_gym;
    Company_User c_user;
    Services services;
    User user;
    private int company_id = 0, user_id = 0, service_id = 0;

    
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

    public int getuser_info(String username, String password) {

        for (Company_User bussinesuserE : find_gym.companyList) {
            if (bussinesuserE.getcompany_name().equals(username) && bussinesuserE.getpassword().equals(password)) {
                int companyid = bussinesuserE.getcompany_id();
                String companyname = bussinesuserE.getcompany_name();
                String companyemail = bussinesuserE.getemail();
                String companyaddress = bussinesuserE.getaddress();
                long companyphone = bussinesuserE.getphone_no();
                int companypostalcode =   bussinesuserE.getpostal_code();
                long companytaxid = bussinesuserE.gettax_id();
                bussinesuserE = new Company_User(companyid, companyname, companypostalcode, companyemail, companyaddress, companyphone, companytaxid, password);
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

    public void newCompany_User_info() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Creating your company account...");
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
        c_user = new Company_User(this.company_id, name, postal_code, email, address, phone_number, tax_id, password);
        find_gym.addcompany(c_user);
        this.company_id++;
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

    public void menu(Find_Gyms find_gym) {
        this.find_gym = find_gym;
    }

    public void newservices() {
        Scanner scanner = new Scanner(System.in);
        int service_count;
        boolean flag = false;
        System.out.print("Enter the number of servStrings you want to add: ");
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
                    services = new Services(c_user.getcompany_id(), services.getservice_id(), service_name, service_price, service_category);
                    flag = true;
                }
            }
            if (!flag) {
                services = new Services(c_user.getcompany_id(), this.service_id, service_name, service_price, service_category);
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
                    System.out.println("Welcome " + c_user.getcompany_name() + " to GYMHUB");
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
                                    find_gym.showcuserInfo(c_user.getcompany_name());
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
                                            for (Company_User bUser : find_gym.companyList ){
                                                if (bUser.getcompany_id() == c_user.getcompany_id())
                                                    bUser.setcompany_name(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (Company_User bUser : find_gym.companyList ){
                                                if (bUser.getcompany_id() == c_user.getcompany_id())
                                                    bUser.setaddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (Company_User bUser : find_gym.companyList ){
                                                if (bUser.getcompany_id() == c_user.getcompany_id())
                                                    bUser.setphone_no(phone);
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (Company_User bUser : find_gym.companyList ){
                                                if (bUser.getcompany_id() == c_user.getcompany_id())
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
                                    find_gym.OrderHistory(c_user.getcompany_id());
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
                    System.out.println("3.Favourites");
                    System.out.println("4. Cart");
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
                            System.out.println("1. Favourite servStrings");
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
                                        int companyID = -1;
                                        int serviceID = -1;
                                        for (Company_User gym_user : find_gym.companyList){
                                            if (gym_user.getcompany_name().equals(pharm))
                                                companyID = gym_user.getcompany_id();
                                        }
                                        System.out.println("Name of the service you want to delete:");
                                        String servString = scan.nextLine();
                                        List<Favourites> removeProductFromFavourite = new ArrayList<>();

                                        for (Favourites favour1 : find_gym.favouritesList) {
                                            if (user.getuser_id() == favour1.getuser_id() && favour1.getcompany_id() == companyID) {
                                                for (Services serv : find_gym.servicesList) {
                                                    if (serv.getservice_name().equals(servString) && serv.getcompany_id() == companyID) {
                                                        serviceID = serv.getservice_id();
                                                    }
                                                }
                                                if (favour1.getservice_id() == serviceID) {
                                                    removeProductFromFavourite.add(favour1);
                                                }
                                            }
                                        }

                                        find_gym.favouritesList.removeAll(removeProductFromFavourite);
                                    }
                                    if (check == 2){
                                        List<Favourites> removeUserFavourites = new ArrayList<>();
                                        for (Favourites fav : find_gym.favouritesList) {
                                            if (user.getuser_id() == fav.getuser_id()) {
                                                removeUserFavourites.add(fav);
                                            }
                                        }
                                        find_gym.favouritesList.removeAll(removeUserFavourites);
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
                                        System.out.println("Name of the pharmacy you want to delete the servString from:");
                                        String gym = scan.nextLine();
                                        int companyID = -1;
                                        int serviceID = -1;
                                        for (Company_User gym_user : find_gym.companyList){
                                            if (gym_user.getcompany_name().equals(gym))
                                                companyID = gym_user.getcompany_id();
                                        }
                                        System.out.println("Name of the servString you want to delete:");
                                        String servString = scan.nextLine();
                                        List<Cart> removeServiceFromCart = new ArrayList<>();

                                        for (Cart cart1 : find_gym.cartList) {
                                            if (user.getuser_id() == cart1.getuser_id() && cart1.getcompany_id() == companyID) {
                                                for (Services serv : find_gym.servicesList) {
                                                    if (serv.getservice_name().equals(servString) && serv.getcompany_id() == companyID) {
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
                                    find_gym.showuserProfile(user.getuser_id());
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
                System.out.println("1. Create a company account.");
                System.out.println("2. Create a customer account");
                creatingAccount = scan.nextInt();
                scan.nextLine();
                if (creatingAccount != 1 && creatingAccount != 2)
                    System.out.println("Choose a valid option");
            }
            if (creatingAccount == 1) {
                newCompany_User_info();
                while (flag == false) {
                    System.out.println("Welcome " + c_user.getcompany_name() + " to GymHub!");
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
                                    find_gym.showcompanyProfile(c_user.getcompany_id());
                                    System.out.println("1. Edit Profile");
                                    System.out.println("2. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("What do you want to edit?   Give a String (Name, Address, Phone_Number, Email)"); 
                                        
                                        
                                        
                                        //ADD NEW






                                        String edit = scan.nextLine();
                                        if (edit.equals("Name")) {
                                            System.out.println("Give new Name:");
                                            String name = scan.nextLine();
                                            for (Company_User buser1 : find_gym.companyList ){
                                                if (buser1.getcompany_id() == c_user.getcompany_id())
                                                    buser1.setcompany_name(name);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (Company_User buser2 : find_gym.companyList){
                                                if (buser2.getcompany_id() == c_user.getcompany_id())
                                                    buser2.setaddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            long phone = scan.nextInt();
                                            scan.nextLine();
                                            for (Company_User buser3 : find_gym.companyList ){
                                                if (buser3.getcompany_id() == c_user.getcompany_id())
                                                    buser3.setphone_no(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (Company_User buser4 : find_gym.companyList ){
                                                if (buser4.getcompany_id() == c_user.getcompany_id())
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
                                    find_gym.OrderHistory(c_user.getcompany_id());
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
                    System.out.println("3.Favourites");
                    System.out.println("4. Cart");
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
                                            String servString = scan.nextLine();
                                            find_gym.showServiceInfo(servString);
                                            System.out.println("1. Add Service to Favourites");
                                            System.out.println("2. Add Service to Cart");
                                            System.out.println("3. Go back");
                                            System.out.println();
                                            System.out.println("Choose an option: (Give number)");
                                            int c = scan.nextInt();
                                            scan.nextLine();
                                            if (c == 1) {
                                                System.out.println("Give the name of the company you want to add the service to favourites from:");
                                                String compString = scan.nextLine();
                                                find_gym.addToFavourites(servString, user.getuser_id(), compString);
                                                System.out.println("Product added to favorites.");
                                                find_gym.showUserFavourites(user.getuser_id());
                                                back = true;
                                            }
                                            if (c == 2) {
                                                System.out.println("Give the name of the company you want to buy the service from:");
                                                String compString = scan.nextLine();
                                                System.out.println("Give the amount of " + servString + " you want to add to your cart:");
                                                int amount = scan.nextInt();
                                                scan.nextLine();
                                                find_gym.addToCart(servString, user.getuser_id(), compString);
                                                System.out.println("Service added to  cart.");
                                                find_gym.showCart(user.getuser_id());
                                                System.out.println("Do you want to complete your order?");
                                                System.out.println("1. Yes.");
                                                System.out.println("2. No.");
                                                c = scan.nextInt();
                                                scan.nextLine();
                                                if (c == 1) {
                                                    find_gym.OrderServices(user.getuser_id());
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
                            System.out.println("1. Favourite Services");
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
                                    System.out.println("2. Remove all service from Favourite List");
                                    System.out.println("3. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1){
                                        System.out.println("Name of the company you want to delete the service from:");
                                        String compString = scan.nextLine();
                                        int company_id = -1;
                                        int service_id = -1;
                                        for (Company_User company : find_gym.companyList){
                                            if (company.getcompany_name().equals(compString))
                                                company_id = company.getcompany_id();
                                        }
                                        System.out.println("Name of the servString you want to delete:");
                                        String prod = scan.nextLine();
                                        List<Favourites> removeProductFromFavourite = new ArrayList<>();

                                        for (Favourites favor1 : find_gym.favouritesList) {
                                            if (user.getuser_id() == favor1.getuser_id() && favor1.getcompany_id() == company_id) {
                                                for (Services services : find_gym.servicesList) {
                                                    if (services.getservice_name().equals(prod) && services.getcompany_id() == company_id) {
                                                        service_id = services.getservice_id();
                                                    }
                                                }
                                                if (favor1.getservice_id() == service_id) {
                                                    removeProductFromFavourite.add(favor1);
                                                }
                                            }
                                        }

                                        find_gym.favouritesList.removeAll(removeProductFromFavourite);
                                    }
                                    if (check == 2){
                                        List<Favourites> removeUserFavourites = new ArrayList<>();
                                        for (Favourites fav : find_gym.favouritesList) {
                                            if (user.getuser_id() == fav.getuser_id()) {
                                                removeUserFavourites.add(fav);
                                            }
                                        }
                                        find_gym.favouritesList.removeAll(removeUserFavourites);
                                    }
                                    if (check == 3) {
                                        back = true;
                                    }
                                }
                            }
                            break;

                        case 4:
                            back = false;
                            System.out.println("1.  Cart");
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
                                    System.out.println("2. Remove a servString from  cart");
                                    System.out.println("3. Remove all servStrings from  cart");
                                    System.out.println("4. Go back");
                                    System.out.println();
                                    System.out.println("Choose an option: (Give number)");
                                    int check = scan.nextInt();
                                    scan.nextLine();
                                    if (check == 1)
                                        find_gym.OrderServices(user.getuser_id());
                                    if (check == 2){
                                        System.out.println("Name of the pharmacy you want to delete the servString from:");
                                        String pharm = scan.nextLine();
                                        int company_id = -1;
                                        int service_id = -1;
                                        for (Company_User company : find_gym.companyList){
                                            if (company.getcompany_name().equals(pharm))
                                                company_id = company.getcompany_id();
                                        }
                                        System.out.println("Name of the servString you want to delete:");
                                        String prod = scan.nextLine();
                                        List<Cart> removeProductFromCart = new ArrayList<>();

                                        for (Cart cartt : find_gym.cartList) {
                                            if (user.getuser_id() == cartt.getuser_id() && cartt.getcompany_id() == company_id) {
                                                for (Services services : find_gym.servicesList) {
                                                    if (services.getservice_name().equals(prod) && services.getcompany_id() == company_id) {
                                                        service_id = services.getservice_id();
                                                    }
                                                }
                                                if (cartt.getservice_id() == service_id) {
                                                    removeProductFromCart.add(cartt);
                                                }
                                            }
                                        }

                                        find_gym.cartList.removeAll(removeProductFromCart);
                                    }
                                    if (check == 3){
                                        List<Cart> removeProductFromCart = new ArrayList<>();
                                        for (Cart carttt : find_gym.cartList) {
                                            if (user.getuser_id() == carttt.getuser_id()) {
                                                removeProductFromCart.add(carttt);
                                            }
                                        }
                                        find_gym.cartList.removeAll(removeProductFromCart);
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
                                            System.out.println("Give new First name:");
                                            String fname = scan.nextLine();
                                            for (User userr : find_gym.userList ){
                                                if (user.getuser_id() == userr.getuser_id())
                                                    userr.setfirstname(fname);
                                            }
                                            System.out.println("Give new Last name:");
                                            String lname = scan.nextLine();
                                            for (User userr : find_gym.userList ){
                                                if (user.getuser_id() == userr.getuser_id())
                                                    userr.setlastname(lname);
                                            }
                                        }
                                        if (edit.equals("Address")) {
                                            System.out.println("Give new Address:");
                                            String address = scan.nextLine();
                                            for (User userr : find_gym.userList) {
                                                if (user.getuser_id() == userr.getuser_id())
                                                    userr.setaddress(address);
                                            }
                                        }

                                        if (edit.equals("Phone_Number")) {
                                            System.out.println("Give new Phone Number:");
                                            String phone = scan.nextLine();
                                            scan.nextLine();
                                            for (User userr : find_gym.userList ){
                                                if (user.getuser_id() == userr.getuser_id())
                                                    userr.setphone_number(phone);
                                            }
                                        }
                                        if (edit.equals("Email")){
                                            System.out.println("Give new Email:");
                                            String email = scan.nextLine();
                                            for (User userr : find_gym.userList ){
                                                if (user.getuser_id() == userr.getuser_id())
                                                    userr.setemail(email);
                                            }
                                        }
                                        if (edit.equals("Username") ){
                                            System.out.println("Give new Username:");
                                            String name = scan.nextLine();
                                            for (User userr : find_gym.userList ){
                                                if (user.getuser_id() == userr.getuser_id())
                                                    userr.setusername(name);
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
