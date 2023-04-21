package org.example;

import java.util.Objects;


public class Worker {
    private static class EmptyWorker {
        public static final Worker emptyWorker = new Worker();
    }

    private final long idnp;

    private final String nameEmploy;

    private final String surnameEmploy;

    private final String positionEmploy;

    private final String salaryCategory;

    private final Integer experienceEmploy;

    public Worker(long idnp,
                  String nameEmploy,
                  String surnameEmploy,
                  String positionEmploy,
                  String salaryCategory,
                  Integer experienceEmploy) {
        this.idnp = idnp;
        this.nameEmploy = nameEmploy;
        this.surnameEmploy = surnameEmploy;
        this.positionEmploy = positionEmploy;
        this.salaryCategory = salaryCategory;
        this.experienceEmploy = experienceEmploy;
    }

    public Worker(Worker worker) {
        this.idnp = worker.getIdnp();
        this.nameEmploy = worker.getNameEmploy();
        this.surnameEmploy = worker.getSurnameEmploy();
        this.positionEmploy = worker.getPositionEmploy();
        this.salaryCategory = worker.getSalaryCategory();
        this.experienceEmploy = worker.getExperienceEmploy();
    }

    private Worker() {
        this.idnp = 0;
        this.nameEmploy = "Tonya";
        this.surnameEmploy = "Melnyk";
        this.positionEmploy = "Designer";
        this.salaryCategory = "S";
        this.experienceEmploy = 0;
    }

    public static Worker emptyWorker() {
        return EmptyWorker.emptyWorker;
    }

    public long getIdnp() {
        return idnp;
    }

    public String getNameEmploy() {
        return nameEmploy;
    }

    public String getSurnameEmploy() {
        return surnameEmploy;
    }

    public String getPositionEmploy() {
        return positionEmploy;
    }

    public String getSalaryCategory() {
        return salaryCategory;
    }

    public Integer getExperienceEmploy() {
        return experienceEmploy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker that = (Worker) o;
        return idnp == that.idnp &&
                nameEmploy.equals(that.nameEmploy) &&
                surnameEmploy.equals(that.surnameEmploy) &&
                positionEmploy.equals(that.positionEmploy) &&
                salaryCategory.equals(that.salaryCategory) &&
                experienceEmploy.equals(that.experienceEmploy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idnp);
    }

    @Override
    public String toString() {
        return String.format(
                "%s\t%s\t%s\t%s\t%s\t%s",
                idnp,
                nameEmploy,
                surnameEmploy,
                positionEmploy,
                salaryCategory,
                experienceEmploy
        );
    }
}
