import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShoesOperations {
    private static LinkedList<Shoes> listOfShoes;

    public ShoesOperations(){
        listOfShoes = new LinkedList<>();
    }

    public void addShoes(Shoes shoe){
        int index = getBrandIndex(shoe.getBrand());
        if(index !=-1){
            brandExcep("Shoe Already Exist!!");
            return;
        }
        if(listOfShoes.size()>5){
            stockExcep("Size if full ie ->5");
            return;
        }
        listOfShoes.add(shoe);
        System.out.println("Added Successfully");
    }
    public void updateShoes(Shoes shoe, String brand){
        int index = getBrandIndex(brand);
        if(index==-1){
            brandExcep("Not Found Shoe Brand!!");
            return;
        }
        listOfShoes.set(index, shoe);
        System.out.println("Update Successfully!!");
    }
    public void deleteShoes(String brand){
        int index = getBrandIndex(brand);
        if(index==-1){
            brandExcep("Brand not Found!!");
            return;
        }
        listOfShoes.remove(index);
        System.out.println("Deleted Successfully");
    }
    public boolean checkStock(){
        if(listOfShoes.size()==0){
            return true;
        }return false;
    }
    public void buyShoe(String brand, String size){
        int index = getBrandIndex(brand);
        if(index==-1){
            stockExcep("Stock is Empty!!");
            return;
        }
        Shoes savedShoe = listOfShoes.get(index);
        if(size.equalsIgnoreCase("small") && savedShoe.getSmall() != 0){
            int available = savedShoe.getSmall();
            int remaining = available-1;
            savedShoe.setSmall(remaining);
            listOfShoes.set(index, savedShoe);
            System.out.println("Purchased Succesfully!!");
            return;
        }
        if(size.equalsIgnoreCase("medium") && savedShoe.getMedium() != 0){
            int available = savedShoe.getSmall();
            int remaining = available-1;
            savedShoe.setMedium(remaining);
            listOfShoes.set(index, savedShoe);
            System.out.println("Purchased Succesfully!!");
            return;
        }
        if(size.equalsIgnoreCase("large") && savedShoe.getLarge() != 0){
            int available = savedShoe.getSmall();
            int remaining = available-1;
            savedShoe.setLarge(remaining);
            listOfShoes.set(index, savedShoe);
            System.out.println("Purchased Succesfully!!");
            return;
        }if(size.equalsIgnoreCase("xl") && savedShoe.getXL() != 0){
            int available = savedShoe.getSmall();
            int remaining = available-1;
            savedShoe.setXL(remaining);
            listOfShoes.set(index, savedShoe);
            System.out.println("Purchased Succesfully!!");
            return;
        }
        if(size.equalsIgnoreCase("xxl") && savedShoe.getXXL() != 0){
            int available = savedShoe.getSmall();
            int remaining = available-1;
            savedShoe.setXXL(remaining);
            listOfShoes.set(index, savedShoe);
            System.out.println("Purchased Succesfully!!");
            return;
        }
        stockExcep("Out of Stock!!");
    }
    public void getShoeDetailsByBrand(String brand){
        int index = getBrandIndex(brand);
        if(index==-1){
            brandExcep("Brand not found");
            return;
        }
        System.out.println(listOfShoes.get(index));
    }

    public void getAllShoes(){
        if(checkStock()){
            stockExcep("Empty Shoe Stock");
            return;
        }

        listOfShoes.forEach((i) ->System.out.println(i));
//        for (Shoes s:
//                listOfShoes) {
//            System.out.println(s);
//        }
    }

    public List<String> getAvailableShoesBrands() {
        if(checkStock()){
            stockExcep("Stock is empty!!");
            return null;
        }
        List<String> allBrands = new ArrayList<>();
        listOfShoes.forEach((i) ->System.out.println(i));
//        for (Shoes shoe : listOfShoes) {
//            allBrands.add(shoe.getBrand());
//        }

        return allBrands;
    }
    public int getBrandIndex(String brand){
        int index = 0;
        for (Shoes shoe:listOfShoes
        ) {
            if(shoe.getBrand().equalsIgnoreCase(brand)){
                return index;
            }
            index++;
        }
        return -1;
    }
//
    public void brandExcep(String in){
        try{
            throw new BrandException(in);
        }
        catch (BrandException ex){
            ex.printStackTrace();
        }
    }
    public void stockExcep(String in){
        try{
            throw new StockException(in);
        }
        catch (StockException ex){
            ex.printStackTrace();
        }
    }
}
