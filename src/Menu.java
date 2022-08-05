import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String Brand;
    private static Scanner sc;
    private static ShoesOperations shoesOperations;
    private static ClothOperations clothOperations;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        shoesOperations = new ShoesOperations();
        clothOperations = new ClothOperations();
//        int option = 0;
        String choice = "";
        do{
            System.out.println("0. Exit");
            System.out.println("1. SHOES");
            System.out.println("2. CLOTH");
            System.out.println("Enter your choice");
//            int n = sc.nextInt();
            try{
                choice = sc.next();
            }catch (InvalidInputException ex){
                System.out.println(ex);
            }
            switch(choice){
                case "1":
                    String str1 = "Shoes";
                    showMenu(str1);

            choice = sc.next();
            switch(choice){
                    case "1":
                        addShoe();
                    break;
                    case "2":
                        buyShoes();
                    break;
                    case "3":
                        displayShoeDetails();
                    break;
                    case "4":
                        displayAllShoes();
                    break;
                    case "5":
                        upateShoe();
                    break;
                    case "6":
                        deleteShoes();
                    break;
                    case "0":
                        System.out.println("Thankyou!!");
                        sc.close();
                        System.exit(0);
                        break;
                default:
//                    invalidInputExcep("Please enter a valid choice");
                    System.out.println("Please enter a valid choice");
                    break;
            }
                break;
                case "2":
                    String str2 = "Cloth";
                    showMenu(str2);
                choice = sc.next();
                switch(choice){
                        case "1":
                            addCloth();
                        break;
                        case "2":
                            buyCloth();
                        break;
                        case "3":
                            displayClothDetails();
                        break;
                        case "4":
                            displayAllCloth();
                        break;
                        case "5":
                            upateCloth();
                        break;
                        case "6":
                            deleteCloth();
                        break;
                        case "0":
                            System.out.println("Thankyou!!");
                            sc.close();
                            System.exit(0);
                        break;
                        default:
                        System.out.println("Enter a valid choice");
                        break;}
                break;
                    case "0":
                        System.out.println("Thankyou for visiting!!");
                        sc.close();
                        System.exit(0);
                    break;
                default:
//                    invalidInputExcep("Please Enter a Valid Choice");
                    System.out.println("Please Enter a Valid Choice");
                    break;
            }
          }while (!choice.equals("0"));
    }
    public static void showMenu(String str){
        System.out.println("MENU OF "+str.toUpperCase());
		System.out.println("0: Exit");
		System.out.println("1: ADD "+str);
		System.out.println("2: Buy "+str);
		System.out.println("3: Display "+str+" By Brand Name");
		System.out.println("4: Display All "+str);
		System.out.println("5: Update "+str);
		System.out.println("6: Delete "+str);
		System.out.println("Please enter your choice:");
}
    public static void addShoe(){
        System.out.println("Enter the brand of shoes");
        String brand = sc.next();
        Shoes newShoes = new Shoes(brand);
        shoesOperations.addShoes(newShoes);
    }
    public static void buyShoes(){
        if(shoesOperations.checkStock()){
            shoesOperations.stockExcep("Stock is Empty!!");
            return;
        }
        displayAvailableShoesBrand();
        System.out.println("Enter the Brand of Shoes");
        String brand = sc.next();
        System.out.println("Enter the Size of Shoes");
        String size = sc.next();
        shoesOperations.buyShoe(brand, size);
    }
    public static void displayShoeDetails(){
        if(shoesOperations.checkStock()){
            shoesOperations.stockExcep("Stock is Empty!!");
            return;
        }
        displayAvailableShoesBrand();
        System.out.println("Enter brand of shoes:");
        String brand = sc.next();
        shoesOperations.getShoeDetailsByBrand(brand);
    }
    public static void deleteShoes(){
        if(shoesOperations.checkStock()){
            shoesOperations.stockExcep("Stock is Empty!!");
            return;
        }
        System.out.println("Enter brand of shoes:");
        String brand = sc.next();
        shoesOperations.deleteShoes(brand);
    }
    public static void displayAllShoes(){
        if(shoesOperations.checkStock()){
            shoesOperations.stockExcep("Stock is Empty!!");
            return;
        }
        shoesOperations.getAllShoes();
    }
    public static void upateShoe(){
        if(shoesOperations.checkStock()) {
            shoesOperations.stockExcep("Stock is Empty!!");
            return;
        }
        System.out.println("Enter Brand of Shoes");
        String brand = sc.next();
        System.out.println("Enter stock of small size");
        int small = sc.nextInt();
        System.out.println("Enter stock of medium size");
        int medium = sc.nextInt();
        System.out.println("Enter stock of large size");
        int large = sc.nextInt();
        System.out.println("Enter stock of XL size");
        int XL = sc.nextInt();
        System.out.println("Enter stock of XXL size");
        int XXL = sc.nextInt();
        Shoes newShoe = new Shoes(brand,small,medium,large,XL,XXL);
        shoesOperations.updateShoes(newShoe,brand);
    }
    public static void displayAvailableShoesBrand(){
        List<String> allShoesBrands = shoesOperations.getAvailableShoesBrands();
        if(allShoesBrands ==null){
            return;
        }
        System.out.println("Available Brands");
        for (String s:
                allShoesBrands) {
            System.out.println(s+" ");
        }
        System.out.println();

    }
public static void addCloth(){
    System.out.println("Enter brand of Cloth");
    String clothBrand = sc.next();
    Cloth cloth = new Cloth(clothBrand);
    clothOperations.addCloth(cloth);
}
public static void buyCloth(){
    if(clothOperations.checkStock()){
       clothOperations.stockExcep("Stock is Empty!!");
       return;
    }
        displayAvailableClothBrand();
        System.out.println("Enter Cloth Brand");
        String clothBrand = sc.next();
        System.out.println("Enter size of cloth");
        String clothSize = sc.next();
        clothOperations.buyCloth(clothBrand, clothSize);
    }

public static void displayClothDetails(){
    if(clothOperations.checkStock()){
        clothOperations.stockExcep("Stock is Empty!!");
        return;
    }
        displayAvailableClothBrand();
        System.out.println("Enter brand of cloth");
        String clothBrand = sc.next();
        clothOperations.getClothDetailsByBrand(clothBrand);
    }

public static void deleteCloth(){
    if(clothOperations.checkStock()){
        clothOperations.stockExcep("Stock is Empty!!");
        return;
    }
        System.out.println("Enter ClothBrand");
        String clothBrand = sc.next();
        clothOperations.deleteCloth(clothBrand);
    }
public static void displayAllCloth(){
    if(clothOperations.checkStock()){
       clothOperations.stockExcep("Stock is Empty!!");
       return;
    }
        clothOperations.getAllCloths();
    }

public static void displayAvailableClothBrand(){
        List<String> allClothBrands = clothOperations.getAvailableClothBrand();
        if(allClothBrands ==null){
            return;
        }
            System.out.println("Available Brands");
            for (String s :
                    allClothBrands) {
                System.out.println(s + " ");
            }
            System.out.println();
        }

public static void upateCloth(){
       if(clothOperations.checkStock()) {
           clothOperations.stockExcep("Stock is Empty!!");
           return;
       }
    System.out.println("Enter clothBrand");
    String clothBrand = sc.next();
    System.out.println("Enter small size");
    int small = sc.nextInt();
    System.out.println("Enter stock of medium size");
    int medium = sc.nextInt();
    System.out.println("Enter stock of large size");
    int large = sc.nextInt();
    System.out.println("Enter stock of XL size");
    int XL = sc.nextInt();
    System.out.println("Enter stock of XXL size");
    int XXL = sc.nextInt();
    Cloth cloth = new Cloth(clothBrand,small,medium,large,XL,XXL);
    clothOperations.updateCloth(cloth,clothBrand);
}
    public static void invalidInputExcep(String in){
        try{
            throw new InvalidInputException(in);
        }
        catch (InvalidInputException ex){
            ex.printStackTrace();
        }
    }
}

//        public static void showMenuCloth(){
//        System.out.println("MENU OF CLOTH");
//		System.out.println("0: Exit");
//		System.out.println("1: ADD Cloth");
//		System.out.println("2: Buy Cloth");
//		System.out.println("3: Display Cloth By Brand Name");
//		System.out.println("4: Display All Cloth");
//		System.out.println("5: Update Cloth");
//		System.out.println("6: Delete Cloth");
//		System.out.println("Please enter your choice:");
//}

