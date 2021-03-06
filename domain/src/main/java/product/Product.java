package product;

public class Product {
    private long idProduct;
    private String name;
    private int rate;
    private int price;

    public Product(Builder builder) {
        this.name = builder.name;
        this.rate = builder.rate;
        this.price = builder.price;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {

        return '\n' + "Product " +
                    "ID:" + idProduct +
                    "; name: '" + name + '\'' +
                    "; rate: " + rate +
                    "; price: " + price + "; "  ;
    }

    public static class Builder {
        String name;
        int rate;
        int price;

        public Builder (String name, int rate, int price) {
            this.name = name;
            this.rate = rate;
            this.price = price;
        }

        public Product build() {
            return new Product(this);
        }
    }

}

