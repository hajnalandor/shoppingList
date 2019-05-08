package hu.flowacademy.shoppingList.util;

import hu.flowacademy.shoppingList.domain.ShoppingItem;
import hu.flowacademy.shoppingList.domain.User;
import hu.flowacademy.shoppingList.repository.ShoppingListRepository;
import hu.flowacademy.shoppingList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitLoadRunner implements CommandLineRunner {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("hajnalandor","qwes","Hajnal Andor");
        User user2 = new User("gitpush2019","pushpull","Pecze Tamas");
        User user3 = new User("miczol","police10","Micsik Zoltan");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        ShoppingItem s1= new ShoppingItem("1","fogkefe","Occso",3,2,399,"Colgate Occso fogkefe",user1);
        ShoppingItem s2= new ShoppingItem("2","hasznaltfogkefe","OccsodeJo",31,22,3299,"Colgate Occso fogkefe",user2);

        shoppingListRepository.save(s1);
        shoppingListRepository.save(s2);

    }
}
