package models;

public enum Level {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8);

    private final Integer level;

    Level(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }
}
