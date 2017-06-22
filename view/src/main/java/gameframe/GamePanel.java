package gameframe;import javax.swing.*;import java.awt.*;import java.awt.image.BufferedImage;import java.util.Observable;import java.util.Observer;/** * Created by mathi on 20/06/2017. */public class GamePanel extends JPanel implements Observer {    /**     * Map     */    private BufferedImage map;    /**     * Player     */    private BufferedImage player;    private int x;    private int y;    /**     * Constructor     */    public GamePanel(/*IGraphicsBuilder graphicsBuilder*/) {        map = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);        player = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);        x = y = 0;    }    /**     * @param o     * @param arg     */    @Override    public void update(Observable o, Object arg) {    }    /**     * @param graphics     */    @Override    public void paintComponent(Graphics graphics) {        graphics.drawImage(map, 0, 0, null);        graphics.drawImage(player, x, y, null);    }    /**     * @param imageMap     */    public void setImageMap(BufferedImage imageMap) {        this.map = imageMap;        this.repaint();    }    /**     * @param imagePlayer     */    public void setImagePlayer(BufferedImage imagePlayer, int x, int y) {        this.player = imagePlayer;        this.x = x;        this.y = y;        this.repaint();    }}