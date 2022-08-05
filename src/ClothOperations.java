import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClothOperations {
    private static LinkedList<Cloth> listOfCloth;

    public ClothOperations(){ listOfCloth = new LinkedList<>();
    }
    public void addCloth(Cloth cloth){
        int index = getBrandIndex(cloth.getClothBrand());
        if(index !=-1){
            brandExcep("Cloth Already Exist!!");
            return;
        }
        if(listOfCloth.size()>5){
            stockExcep("Size if full ie ->5");
            return;
        }
        listOfCloth.add(cloth);
        System.out.println("Added Successfully!");
    }

    public void updateCloth(Cloth cloth, String brand){
        int index = getBrandIndex(brand);
        if(index==-1){
            brandExcep("Not Found Cloth Brand!!");
            return;
        }
        listOfCloth.set(index,cloth);
        System.out.println("Update Successfully");
    }
    public void deleteCloth(String brand){
        int index = getBrandIndex(brand);
        if(index==-1){
            brandExcep("Brand not found");
            return;
        }
        listOfCloth.remove(index);
        System.out.println("Deleted Successfully!!");
    }
    public boolean checkStock(){
        if(listOfCloth.size()==0){
            return true;
        }return false;
    }
    public void buyCloth(String brand, String size){
        int index = getBrandIndex(brand);
        if(index==-1){
            stockExcep("Stock is Empty!!");
            return;
        }
        Cloth saveCloth = listOfCloth.get(index);
        if(size.equalsIgnoreCase("small")&& saveCloth.getSmall()!=0){
            int available = saveCloth.getSmall();
            int remaining = available-1;
            saveCloth.setSmall(remaining);
            listOfCloth.set(index,saveCloth);
            System.out.println("Purchased Successfully!!");
            return;
        }

        if(size.equalsIgnoreCase("medium") && saveCloth.getMedium()!=0) {
            int available = saveCloth.getMedium();
            int remaining = available - 1;
            saveCloth.setMedium(remaining);
            listOfCloth.set(index, saveCloth);
            System.out.println("Purchased Successfully!!");
            return;
        }

        if(size.equalsIgnoreCase("large") && saveCloth.getLarge()!=0) {
            int available = saveCloth.getLarge();
            int remaining = available - 1;
            saveCloth.setLarge(remaining);
            listOfCloth.set(index, saveCloth);
            System.out.println("Purchased Successfully!!");
            return;
        }

        if(size.equalsIgnoreCase("XL") && saveCloth.getXL()!=0) {
            int available = saveCloth.getXL();
            int remaining = available - 1;
            saveCloth.setXL(remaining);
            listOfCloth.set(index, saveCloth);
            System.out.println("Purchased Successfully!!");
            return;
        }

        if(size.equalsIgnoreCase("XXL") && saveCloth.getXXL()!=0){
        int available = saveCloth.getXXL();
        int remaining  = available-1;
        saveCloth.setXXL(remaining);
        listOfCloth.set(index,saveCloth);
        System.out.println("Purchased Successfully!!");
        return;
    }
        stockExcep("Out of Stock!!");
    }

    public void getClothDetailsByBrand(String brand){
        int index= getBrandIndex(brand);
        if(index==-1){
            brandExcep("Brand not found");
            return;
        }
        System.out.println(listOfCloth.get(index));
    }

    public void getAllCloths(){
        if(checkStock()){
            stockExcep("Empty Cloth Stock");
            return;
        }
        listOfCloth.forEach(System.out::println);
//        for (Cloth s:
//             listOfCloth) {
//            System.out.println(s);
//        }
    }
    public List<String> getAvailableClothBrand() {
        if(checkStock()){
            stockExcep("Stock is empty!!");
            return null;
        }
        List<String> allBrands = new ArrayList<>();
        listOfCloth.forEach((i) ->System.out.println(i));
//                for (Cloth cloth :
//                        listOfCloth) {
//                    allBrands.add(cloth.getClothBrand());
//                }
         return allBrands;
    }
    public int getBrandIndex(String brand){
        int index = 0;
        for (Cloth cloth:
             listOfCloth) {
            if(cloth.getClothBrand().equalsIgnoreCase(brand)){
                return index;
            }
            index++;
        }
        return -1;
    }

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
