package long_programming_prep;

import java.util.*;

public class Cart {
    public List<CartLine> cartLines = new ArrayList<CartLine>();

    //add to cart
    //remove cartline
    //change product quantity

    public void addToCart(Product product, int quantity) {
        cartLines.add(new CartLine(product, quantity));
    }

    public int getTotal() {
        int total = 0;
        for(CartLine cartLine: cartLines)
        {
            total +=  cartLine.getAmount();
        }
        return total;
    }

    public void printBill() {
        System.out.println("-------------------------------");
        System.out.println("Shopiffy - Your Bill");
        System.out.println("-------------------------------");
        System.out.println("Date:" + new Date());
        System.out.println("-------------------------------");
        System.out.println("Id | Product | Quantity | Rate | Amount");
        System.out.println("-------------------------------");
        
        for(CartLine cartLine: cartLines)
        {
            Product currentProduct = cartLine.getProduct();
            System.out.println(currentProduct.id + " | " + currentProduct.name + " | " + cartLine.getQuantity() + " | " + currentProduct.rate + " | " + cartLine.getAmount());
        }
        
        System.out.println("-------------------------------");
        System.out.println("Grand Total       => $" + getTotal());
        System.out.println("-------------------------------");
        System.out.println("Thanks for buying. Please come again!");
        System.out.println("-------------------------------");
    }
}
