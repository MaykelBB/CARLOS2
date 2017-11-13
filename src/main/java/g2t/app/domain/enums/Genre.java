package g2t.app.domain.enums;

public enum Genre {
    M("Masculino"),
    F ("Femenino");

    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}


