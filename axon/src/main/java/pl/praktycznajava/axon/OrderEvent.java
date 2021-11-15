package pl.praktycznajava.axon;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
class OrderCreatedEvent {

    private final String orderId;
    private final String productId;
}

@Getter
@Setter
@Data
class OrderConfirmedEvent {

    private final String orderId;
}

@Getter
@Setter
@Data
class OrderShippedEvent {

    private final String orderId;
}


