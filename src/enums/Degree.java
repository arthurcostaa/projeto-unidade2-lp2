package enums;

public enum Degree {
    SPECIALIZATION(0.25),
    MASTER(0.5),
    DOCTORATE(0.75);

    private final Double degree;

    Degree(Double degree) {
        this.degree = degree;
    }

    public Double getDegree() {
        return degree;
    }
}
