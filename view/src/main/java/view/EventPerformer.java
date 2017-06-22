package view;

import controller.Order;
import controller.OrderPerformerable;
import controller.UserOrder;
import controller.UserOrderable;
import gameframe.EventPerformerable;

import java.awt.event.KeyEvent;

/**
 * Created by mathi on 19/06/2017.
 */
public class EventPerformer implements EventPerformerable {

    private final OrderPerformerable orderPerformer;

    /**
     * Constructor
     *
     * @param orderPerformer
     */
    public EventPerformer(OrderPerformerable orderPerformer) {
        this.orderPerformer = orderPerformer;
    }

    /**
     * @param keyCode
     */
    public void eventPerform(KeyEvent keyCode) {
        UserOrderable userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
        if(userOrder != null) {
            this.orderPerformer.orderPerform(userOrder);
        }
    }

    /**
     * @param keyCode
     * @return
     */
    private UserOrderable keyCodeToUserOrder(int keyCode) {

        UserOrderable userOrder = null;

        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                userOrder = new UserOrder(Order.UP);
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                userOrder = new UserOrder(Order.RIGHT);
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                userOrder = new UserOrder(Order.DOWN);
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                userOrder = new UserOrder(Order.LEFT);
                break;

            case KeyEvent.VK_ESCAPE:
                userOrder  = new UserOrder(Order.EXIT);
                break;
        }

        return userOrder;
    }

}
