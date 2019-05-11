package hu.flowacademy.shoppingList.shoppingList.repository;

import hu.flowacademy.shoppingList.shoppingList.domain.User;
import hu.flowacademy.shoppingList.shoppingList.domain.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariantRepository extends JpaRepository<Variant,Long> {

    @Query("SELECT COUNT(variant.price) FROM Variant variant WHERE shoppingItem_id= ?1")
    public double sumPrice(String id);

    @Query("SELECT variant FROM Variant variant GROUP BY variant.id")
    public List<Variant> listVariants();
}
