package edu.sdu.woz;

public enum Item {
    GARLIC("Garlic", "a string of garlic", "/images/garlic.png"),
    KEY("Key", "an item that grants you access", "/images/key.png"),
    SHOTGUN("Shotgun", "a badass sawed-off shotgun", "/images/shotgun.png"),
    LIGHTER("Lighter", "a Zippo lighter", "/images/lighter.png");

    private final String name;
    private final String description;
    private final String imageUrl;

    Item(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
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
