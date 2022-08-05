public class Shoes {
    private String brand;
    private int small;
    private int medium;
    private int large;
    private int XL;
    private int XXL;

    @Override
    public String toString() {
        return "Shoes{" +
                "brand='" + brand + '\'' +
                ", small=" + small +
                ", medium=" + medium +
                ", large=" + large +
                ", XL=" + XL +
                ", XXL=" + XXL +
                '}';
    }

    public Shoes(String brand) {
        this.brand = brand;
        this.small = 5;
        this.medium = 5;
        this.large = 5;
        this.XL = 5;
        this.XXL = 5;
    }
    public Shoes(String brand, int small, int medium, int large, int XL, int XXL) {
        this.brand = brand;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.XL = XL;
        this.XXL = XXL;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSmall() {
        return small;
    }

    public void setSmall(int small) {
        this.small = small;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public int getXL() {
        return XL;
    }

    public void setXL(int XL) {
        this.XL = XL;
    }

    public int getXXL() {
        return XXL;
    }

    public void setXXL(int XXL) {
        this.XXL = XXL;
    }
}
