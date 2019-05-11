package hu.flowacademy.shoppingList.repository;

import hu.flowacademy.shoppingList.shoppingList.domain.ShoppingItem;
import hu.flowacademy.shoppingList.shoppingList.domain.User;
import hu.flowacademy.shoppingList.shoppingList.domain.Variant;
import hu.flowacademy.shoppingList.shoppingList.repository.VariantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


    @RunWith(SpringRunner.class)
    @DataJpaTest
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    public class VariantResositoryTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private VariantRepository variantRepository;

        @Test
        public void findByID_getNameEquals() {
            User user1 = new User("1","asdsa","joska");
            Variant variantItemShouldBeFound = new Variant("izeke", 5, new ShoppingItem("1","3","asd",1,1,1,"sad",user1));
            entityManager.persist(variantItemShouldBeFound);
            entityManager.flush();
            Variant variantFound = variantRepository.findById(variantItemShouldBeFound.getId()).orElse(null);
            assertThat(variantFound.getName()).isEqualTo(variantItemShouldBeFound.getName());
        }

    }

