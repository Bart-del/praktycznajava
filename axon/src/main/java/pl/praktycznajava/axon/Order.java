package pl.praktycznajava.axon;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Order {

    private final String orderId;
    private final String productId;
    private OrderStatus orderStatus;

    public Order(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
        orderStatus = OrderStatus.CREATED;
    }

    public void setOrderConfirmed() {
        this.orderStatus = OrderStatus.CONFIRMED;
    }

    public void setOrderShipped() {
        this.orderStatus = OrderStatus.SHIPPED;
    }

}

enum OrderStatus {
    CREATED, CONFIRMED, SHIPPED
}
