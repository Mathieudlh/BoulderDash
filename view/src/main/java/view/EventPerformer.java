package view;

import java.awt.event.KeyEvent;

/**
 * Created by mathi on 19/06/2017.
 */
public class EventPerformer {

    public EventPerformer(IOrderPerformer orderPerformer){

    }

    public eventPerform(KeyEvent keyCode) {

    }

    private UserOrder keyCodeToUserOrder(int keyCode) {

    UserOrder userOrder;

        switch (keyCode) {

            case KeyEvent.VK_UP:
                userOrder = new UserOrder(0, Order.UP);
                break;
            case KeyEvent.VK_RIGHT:
                userOrder = new UserOrder(0, Order.RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                userOrder = new UserOrder(0, Order.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                userOrder = new UserOrder(0, Order.LEFT);
                break;

        }

        return userOrder;
    }

}
