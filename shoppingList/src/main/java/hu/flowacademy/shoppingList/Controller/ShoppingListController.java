package hu.flowacademy.shoppingList.Controller;

import hu.flowacademy.shoppingList.domain.ShoppingList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/shoppinglist")
public class ShoppingListController {
    private Map<String, ShoppingList> list = new HashMap<>();

    @PostMapping("/add")
    public ResponseEntity<ShoppingList> addElement(@RequestBody ShoppingList shoppingList) {
        list.put(shoppingList.getId(), shoppingList);
        System.out.println(shoppingList);
        return ResponseEntity.ok(shoppingList);
    }

    @PostMapping("/addlist")
    public ResponseEntity<List<ShoppingList>> addElements(@RequestBody List<ShoppingList> shoppingList) {
        for (ShoppingList s: shoppingList) {
            list.put(s.getId(), s);
        }
        return ResponseEntity.ok(shoppingList);
    }

    @PutMapping("/update")
    public ResponseEntity<ShoppingList> updateElement(@RequestBody ShoppingList shoppingList) {
        ShoppingList foundTodoItem = list.get(shoppingList.getId());
        if (foundTodoItem != null) {
            list.remove(shoppingList.getId());
            list.put(shoppingList.getId(), shoppingList);
            return ResponseEntity.ok(shoppingList);
        }
        return ResponseEntity.ok(new ShoppingList());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteElement(@PathVariable String id) {
        list.remove(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/shoppingList")
    public ResponseEntity<List<ShoppingList>> shoppingList() {
        List<ShoppingList> todoListItems = new ArrayList<>(list.values());
        return ResponseEntity.ok(todoListItems);

    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ShoppingList> deleteTodoItem(@PathVariable String id) {
        ShoppingList item= list.get(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/sum")
    public ResponseEntity<Integer> sum() {
        Integer sum1=0;
        /*for (var s: list.entrySet()) {
    sum1+=s.getValue().getPrice()*s.getValue().getQuantityOne()*s.getValue().getQuantity();
        }*/
        return ResponseEntity.ok(list.values().stream().map(s -> s.getPrice()*s.getQuantity()).reduce(0, (a, b) -> a + b));
    }





}
