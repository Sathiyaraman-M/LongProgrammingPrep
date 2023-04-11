import java.util.*;
import long_programming_prep.*;

public class Main {

    private static List<Product> ourProducts = Arrays.asList(
        new Product(1, "Surface Pro", 1500, "Microsoft"),
        new Product(2, "Raspberry Pi 4", 200, "ABC"),
        new Product(3, "Medium Size Soap", 10, "Cinthol"),
        new Product(4, "Rockerzz 450 Pro", 100, "Boat"),
        new Product(5, "Probook 440 G1", 400, "HP")
    );

    private static Cart cart = new Cart();

    //Shopping Cart App - Shopify
    public static void main(String[] args) {
        int choice = 1;
        Scanner sc = new Scanner(System.in);
        while(choice != 2) {
            System.out.println("Welcome to Shopiffy");
            System.out.println("-------------------------------");
            System.out.print("Enter 1 to See products and 2 to exit:");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    int secondChoice = 1;
                    while(secondChoice != 3)
                    {
                        System.out.println("-------------------------------");
                        System.out.println("Id  |   Product  |  Rate  |  Brand");
                        System.out.println("-------------------------------");
                        for(Product product: ourProducts)
                        {
                            System.out.println(product.id + " | " + product.name + " | " + product.rate + " | " + product.brand);
                        }
                        System.out.println("-------------------------------");
                        System.out.println("Options:\n1. Select Product\n2. Go to Cart\n3. Exit");
                        System.out.println("-------------------------------");
                        System.out.print("Enter your choice:");
                        secondChoice = sc.nextInt();
                        System.out.println("-------------------------------");
                        switch(secondChoice)
                        {
                            case 1:
                                System.out.print("Enter Product ID to select:");
                                int selectedProductId = sc.nextInt();
                                Product selectedProduct = null;
                                for(Product product: ourProducts)
                                {
                                    if(product.id == selectedProductId)
                                    {
                                        selectedProduct = product;
                                        break;
                                    }
                                }
                                if(selectedProduct == null)
                                {
                                    System.out.println("Invalid Product ID. Please try again.");
                                    break;
                                }
                                System.out.println("You have selected Product " + selectedProduct.name);
                                int thirdChoice = 1;
                                while(thirdChoice != 2)
                                {
                                    System.out.println("-------------------------------");
                                    System.out.println("Options:\n1. Add to Cart\n2. Exit");
                                    System.out.println("-------------------------------");
                                    System.out.print("Enter your choice:");
                                    thirdChoice = sc.nextInt();
                                    // further options => add to cart, exit
                                    switch(thirdChoice) {
                                        case 1:
                                            System.out.print("Enter quantity: ");
                                            int quantity = sc.nextInt();
                                            cart.addToCart(selectedProduct, quantity);
                                            if (viewCart(sc))
                                            {
                                                secondChoice = 3;
                                            }
                                            break;
                                        case 2:                                            
                                            break;
                                        default:
                                            System.out.println("Invalid Choice. Please try again.");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                if (viewCart(sc))
                                {
                                    secondChoice = 3;
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid Choice. Please try again.");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Exiting Shopiffy...");
                    break;
                default:
                    System.out.println("Invalid Choice. Try again...");
                    break;
            }
        }
    }

    private static boolean viewCart(Scanner sc) {
        int choice = 0;
        while(choice != 1 && choice != 2)
        {
            System.out.println("-------------------------------");
            System.out.println("Cart Section"); 
            System.out.println("-------------------------------");
            
            System.out.println("Products coming here from Cart");
            for(int i = 0; i < cart.cartLines.size(); i++)
            {
                CartLine currentCartLine = cart.cartLines.get(i);
                System.out.println((i + 1) + " " + currentCartLine.getProduct().name + " - " + currentCartLine.getQuantity() + " - $" + currentCartLine.getAmount());
            }
            System.out.println("-------------------------------");
            System.out.println("Options:\n1.Buy Now\n2.Exit");
            System.out.println("-------------------------------");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    cart.printBill();
                    return true;
                case 2:
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
            }
        }
        return false;
    }
}