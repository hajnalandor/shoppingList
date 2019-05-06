package hu.flowacademy.shoppingList.repository;

import hu.flowacademy.shoppingList.domain.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingListRepository extends JpaRepository<ShoppingItem, String> {

    public void deleteById(String id);

    @Query("SELECT SUM(shoppingItem.price) FROM ShoppingItem shoppingItem")
    public int sumprice();

}
