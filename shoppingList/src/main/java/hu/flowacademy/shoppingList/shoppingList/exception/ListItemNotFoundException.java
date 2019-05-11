package hu.flowacademy.shoppingList.shoppingList.exception;

public class ListItemNotFoundException extends RuntimeException{

    public ListItemNotFoundException() {
        super("Az elem nem található a listában ");
    }

    public ListItemNotFoundException(String id) {
        super("Az elem nem talalhato a listaban"+id);
    }
}
