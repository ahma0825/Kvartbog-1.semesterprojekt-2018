package edu.sdu.woz;

public enum Item {
    GARLIC("Garlic", "a string of garlic"),
    KEY("Key", "an item that grants you access"),
    SHOTGUN("Shotgun", "a badass sawed-off shotgun");

    private final String name;
    private final String description;

    Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getName();
    }

    /**
     * Parses the item name and attempts to find the corresponding enum. May return null.
     */
    public static Item parse(String name) {
        for (Item item : values()) {
            if (item.getName().equalsIgnoreCase(name)) return item;
        }
        return null;
    }
}
