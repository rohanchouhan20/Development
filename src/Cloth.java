public class Cloth {
    private String ClothBrand;
    private int small;
    private int medium;
    private int large;
    private int XL;
    private int XXL;

    public Cloth(String clothBrand, int small, int medium, int large, int XL, int XXL) {
        ClothBrand = clothBrand;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.XL = XL;
        this.XXL = XXL;
    }
    public Cloth(String clothBrand) {
        ClothBrand = clothBrand;
        this.small = 5;
        this.medium = 5;
        this.large = 5;
        this.XL = 5;
        this.XXL = 5;
    }

    public String getClothBrand() {
        return ClothBrand;
    }

    public void setClothBrand(String clothBrand) {
        ClothBrand = clothBrand;
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

    @Override
    public String toString() {
        return
                "ClothBrand='" + ClothBrand + '\'' +
                ", small='" + small + '\'' +
                ", medium='" + medium + '\'' +
                ", large='" + large + '\'' +
                ", XL='" + XL + '\'' +
                ", XXL='" + XXL + '\'' +
                '}';
    }
}
