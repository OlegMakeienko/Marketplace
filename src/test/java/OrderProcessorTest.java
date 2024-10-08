import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderProcessorTest {

    @Test
    @DisplayName("Beräkna totalpris för en order med två produkter med hjälp av Mockito")
    void totalPriceWithMockedProductRepository() {
        Order order = new Order();
        order.addProduct("1", 2);
        order.addProduct("2", 1);

        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.getPrice("1")).thenReturn(100);
        when(productRepository.getPrice("2")).thenReturn(200);

        OrderProcessor orderProcessor = new OrderProcessor(productRepository);

        double totalPrice = orderProcessor.calculateTotalPrice(order);

        assertEquals(400.0, totalPrice);
    }
}