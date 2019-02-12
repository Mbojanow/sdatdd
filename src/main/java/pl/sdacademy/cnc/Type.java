package pl.sdacademy.cnc;

public enum Type {
    CIRCLE("O"),
    CROSS("X");

    private String displayValue;

    Type(final String displayName) {
        this.displayValue = displayName;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
