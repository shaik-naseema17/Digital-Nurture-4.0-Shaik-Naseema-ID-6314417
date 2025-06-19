import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return productId + " | " + productName + " | " + category;
    }
}

public class EcommerceSearch {

    // Linear search: checks every product one by one
    public static void linearSearch(Product[] products, String targetName) {
        boolean found = false;
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                System.out.println("Product found (Linear): " + product);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found using Linear Search.");
        }
    }

    // Binary search: only works if array is sorted by product name
    public static void binarySearch(Product[] products, String targetName) {
        // Sort the array by productName before binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = targetName.compareToIgnoreCase(products[mid].productName);

            if (result == 0) {
                System.out.println("Product found (Binary): " + products[mid]);
                return;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println("Product not found using Binary Search.");
    }

    public static void main(String[] args) {
        // Explanation: Big O Notation (for student reference)
        System.out.println("Big O Notation explains how fast or slow an algorithm is as data grows.");
        System.out.println("Linear Search: O(n) - checks each item.");
        System.out.println("Binary Search: O(log n) - halves the list each time (works only on sorted data).");
        System.out.println("Best case: Found immediately (O(1)).");
        System.out.println("Average case: Found somewhere in middle.");
        System.out.println("Worst case: Not found at all or last (O(n) for linear, O(log n) for binary).\n");

        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Shoes", "Footwear"),
                new Product(3, "Book", "Stationery"),
                new Product(4, "Phone", "Electronics"),
                new Product(5, "Backpack", "Accessories")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();

        linearSearch(products, searchName);
        binarySearch(products, searchName);
        scanner.close();
    }
}
