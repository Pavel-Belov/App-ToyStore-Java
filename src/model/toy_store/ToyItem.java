package model.toy_store;

public interface ToyItem<T> {
    Integer getToyId();

    String getToyName();

    Integer getToyWeight();

    String getInfo();

    String getNotFoundInfo();
}
