import java.util.Arrays;

public class Per_39 {

    public static <T extends Comparable<T>> void sort(T[] array) {
        Arrays.sort(array);
    }

    public static void main(String[] args) {
        Integer[] intArray = {3, 1, 4, 2, 5};
        System.out.println("Before sorting: " + Arrays.toString(intArray));
        sort(intArray);
        System.out.println("After sorting: " + Arrays.toString(intArray));

        String[] stringArray = {"Apple", "Banana", "Orange", "Mango"};
        System.out.println("Before sorting: " + Arrays.toString(stringArray));
        sort(stringArray);
        System.out.println("After sorting: " + Arrays.toString(stringArray));

        Product[] productArray = {
            new Product("Laptop", 1200),
            new Product("Phone", 800),
            new Product("Tablet", 600)
        };
        System.out.println("Before sorting products by price: " + Arrays.toString(productArray));
        sort(productArray);
        System.out.println("After sorting products by price: " + Arrays.toString(productArray));
    }
}

class Product implements Comparable<Product> {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
