package view;

import controller.Order;
import controller.OrderPerformerable;
import controller.UserOrder;
import controller.UserOrderable;

import java.awt.event.KeyEvent;

/**
 * Created by mathi on 19/06/2017.
 */
public class EventPerformer {

    /**
     * Constructor
     *
     * @param orderPerformer
     */
    public EventPerformer(OrderPerformerable orderPerformer) {

    }

    /**
     * @param keyCode
     */
    public void eventPerform(KeyEvent keyCode) {

    }

    /**
     * @param keyCode
     * @return
     */
    private UserOrderable keyCodeToUserOrder(int keyCode) {

        UserOrderable userOrder = null;

        switch (keyCode) {

            case KeyEvent.VK_UP:
                userOrder = new UserOrder(Order.UP);
                break;
            case KeyEvent.VK_RIGHT:
                userOrder = new UserOrder(Order.RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                userOrder = new UserOrder(Order.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                userOrder = new UserOrder(Order.LEFT);
                break;

        }

        return userOrder;
    }

}
