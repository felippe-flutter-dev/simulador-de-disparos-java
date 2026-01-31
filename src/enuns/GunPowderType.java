package enuns;

public enum GunPowderType {
    SUBSONIC("Subsonic", 0.85),
    STANDARD("Standard", 1.0),
    HIGH_VELOCITY("High Velocity", 1.15),
    PROOF_LOADER("Proof Loader", 1.50),
    PLUS_P("+P", 1.10),
    PLUS_P_PLUS("+P+", 1.25);

    public final String description;
    public final double powerMultiplier;

    GunPowderType(String description, double powerMultiplier) {
        this.description = description;
        this.powerMultiplier = powerMultiplier;
    }
}
