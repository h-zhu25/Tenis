package Model;


public enum PointType {
    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("AD");

    private final String value;

    PointType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



