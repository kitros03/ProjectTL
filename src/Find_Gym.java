import java.util.Scanner;
import java.util.ArrayList;

public class Find_Gym {
    String name = "Find Gym";
    User user;
    Business_User b_user;
    Services serv;
    ArrayList<Services> servicesList = new ArrayList<>();
    ArrayList<Business_User> businessList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<String> businessNameList = new ArrayList<>();
    ArrayList<String> serviceCategoryList = new ArrayList<>();
    ArrayList<String> serviceNameList = new ArrayList<>();

    public void findGym() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the gym you are looking for:");
        String gymName = scanner.nextLine();
        boolean found = false;

        for (Business_User business : businessList) {
            if (business.getbusiness_name().equalsIgnoreCase(gymName)) {
                System.out.println("Gym found: " + business.getbusiness_name());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Gym not found.");
        }
    
    }

    public void addbusiness(Business_User business) {
        try{
            if(businessList.contains(business)){
                System.out.println("Business already exists");
        }
        else{
            businessList.add(business);
            System.out.println("Business added successfully");
        }
        }
        catch(Exception e){
            System.out.println("Error adding business: " + e.getMessage());
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
        for (Business_User buser : businessList) {
            if (search.equals(buser.getbusiness_name())) {
                showBuserInfo(search);
                System.out.println();
                showBusinessServices(search);
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

    public void showBuserInfo(String businessName) {
        for (Business_User buser : businessList) {
            if (buser.getbusiness_name().equals(businessName)) {
                System.out.println("Business Name: " + buser.getbusiness_name());
                System.out.println("Business ID: " + buser.getbusiness_id());
                System.out.println("Business Address: " + buser.getaddress());
                System.out.println("Business Phone: " + buser.getphone_no());
            }
        }
    }

    public void showBusinessServices(String businessName) {
        for (Business_User buser : businessList) {
            if (buser.getbusiness_name().equals(businessName)) {
                System.out.println("Services offered by " + buser.getbusiness_name() + ":");
                for (Services service : servicesList) {
                    if (service.getbusiness_id() == buser.getbusiness_id()) {
                        System.out.println("- " + service.getservice_name());
                    }
                }
            }
        }
    }
}
