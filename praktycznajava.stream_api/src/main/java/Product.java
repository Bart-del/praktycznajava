public class Product {
    private int id;
    private double price;
    private String description;
    private Type type;

    public Product(int id, double price, String description, Type type) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.type = type;
    }

    public enum Type{
        TABLE("Table"),
        CHAIR("Chair"),
        BOARD("Board");

        String typeOfProduct;

        Type(String typeOfProduct){
            this.typeOfProduct = typeOfProduct;
        }
    }

    @Override
    public String toString() {
        return "\n Product{" +
                "id=" + id +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }

    //Gettery i Settery...


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
