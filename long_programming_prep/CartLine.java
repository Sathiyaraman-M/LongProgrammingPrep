package long_programming_prep;

public class CartLine {

    CartLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    private Product product;

    public Product getProduct() {
        return product;
    }

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return product.rate * quantity;
    }
}
