package Testing;

import java.util.Objects;

public class Meal {

    private int price;
    private String name;

    public Meal(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountPrice(int discount){
        if(discount>this.price)
            throw new IllegalArgumentException("discount cannot be higher than price");

        return this.price - discount;
    }

    public Meal(int price, String name) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return price == meal.price &&
                Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
