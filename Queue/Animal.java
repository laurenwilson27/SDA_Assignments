package Queue;

public class Animal {
    private String name;
    private final boolean isCat;

    public Animal(String name, boolean isCat) {
        this.name = name;
        this.isCat = isCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCat() { return isCat; }

    @Override
    public String toString() {
        if (isCat())
            return name+" (Cat)";
        else
            return name+" (Dog)";
    }
}
