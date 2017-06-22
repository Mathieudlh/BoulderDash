package controller;

/**
 * Created by doz Grou on 20/06/2017.
 */
public class UserOrder implements UserOrderable {

    private Order order;

    /**
     * @param order
     */
    public UserOrder(Order order) {
        this.order = order;
    }

    /**
     * @return Order
     */
    @Override
    public Order getOrder() {
        return this.order;
    }
}
