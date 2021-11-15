package pl.praktycznajava.axon;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@Setter
@Data
class CreateOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;
    private final String productId;
}

@Getter
@Setter
@Data
class ConfirmOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;
}

@Getter
@Setter
@Data
class ShipOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;
}

