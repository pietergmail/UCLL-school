public class Product_old {
    private String title;
    private String type;
    private String id;

    public Product_old(String title, String id, String type) {
        this.title = title;
        this.type = type;
        this.id = id;
    }

    public double getPrice(int days){
        double price = 0;
        if(this.getType().equals("M")){
            price = 5;
            int daysLeft = days - 3;
            if (daysLeft > 0){
                price += (daysLeft * 2);
            }
        } else if(this.getType().equals("G")){
            price = days * 3;
        }
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
