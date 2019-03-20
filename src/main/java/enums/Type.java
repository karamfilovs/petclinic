package enums;

public enum Type {
    BIRD("bird"),
    DOG("dog"),
    LIZARD("lizard"),
    CAT("cat");

    private Type(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
