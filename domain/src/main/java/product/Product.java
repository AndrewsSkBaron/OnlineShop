package product;

public class Product {
    private String name;
    private int rate;
    private int price;

    public Product(Builder builder) {
        this.name = builder.name;
        this.rate = builder.rate;
        this.price = builder.price;
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
        return "Product { " +
                "name = '" + name + '\'' +
                ", rate = " + rate +
                ", price = " + price + " " +
                '}' + '\n';
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

