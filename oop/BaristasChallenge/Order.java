import java.util.ArrayList;

public class Order {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items;

    public Order () {
        name = "Guest";
        items = new ArrayList<Item>();
    }

    public Order (String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal (double total) {
        this.total = total;
    }

    public boolean isReady () {
        return ready;
    }

    public void setReady (boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems () {
        return items;
    }

    public void setItems (ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem (Item item) {
        items.add(item);
    }
}

