import java.util.Map;

public class OrderProcessor {
    private ProductRepository productRepository;

    public OrderProcessor(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int calculateTotalPrice(Order order) {
        int totalPrice = 0;
        for(Map.Entry<String, Integer> entry : order.getProducts().entrySet()){
            String productId = entry.getKey();
            int quantity = entry.getValue();
            Integer price = productRepository.getPrice(productId);

            if(price != null) {
                totalPrice += price * quantity;
            } else {
                System.out.println("product with id " + productId + " not found");
            }
        }
        return totalPrice;
    }
}
