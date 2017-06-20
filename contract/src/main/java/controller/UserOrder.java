package controller;

/**
 * Created by doz Grou on 20/06/2017.
 */
public class UserOrder implements UserOrderable {

    private Order order;

    public UserOrder(Order order) {
        this.order = order;
    }

    @Override
    public Order getOrder() {
        return this.order;
    }
}
