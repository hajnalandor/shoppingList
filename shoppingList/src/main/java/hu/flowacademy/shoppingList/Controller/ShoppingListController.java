package hu.flowacademy.shoppingList.Controller;

import hu.flowacademy.shoppingList.domain.ShoppingItem;
import hu.flowacademy.shoppingList.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/shoppinglist")
public class ShoppingListController {


    @Autowired
    private ShoppingService shoppingService;

    @PostMapping("/add")
    public ResponseEntity<ShoppingItem> addElement(@RequestBody ShoppingItem shoppingList) {
        return ResponseEntity.ok(shoppingService.save(shoppingList));
    }

    @PostMapping("/addlist")
    public ResponseEntity<List<ShoppingItem>> addElements(@RequestBody List<ShoppingItem> shoppingList) {
     return ResponseEntity.ok(shoppingService.saveList(shoppingList));
    }

    @PutMapping("/update")
    public ResponseEntity<ShoppingItem> updateElement(@RequestBody ShoppingItem shoppingList) {
        return ResponseEntity.ok(shoppingService.save(shoppingList));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShoppingItem(@PathVariable String id) {
        shoppingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/shoppingList")
    public ResponseEntity<List<ShoppingItem>> shoppingList() {
        return ResponseEntity.ok(shoppingService.listItems());

    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ShoppingItem> getItemById(@PathVariable String id) {
        return ResponseEntity.ok(shoppingService.getOneItem(id));
    }

    @GetMapping("/sum")
    public ResponseEntity<Integer> sum() {
         return ResponseEntity.ok(shoppingService.sum());
    }





}
