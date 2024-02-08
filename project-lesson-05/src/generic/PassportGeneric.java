package generic;

public class PassportGeneric<T> {
    private T id;

    public PassportGeneric(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
