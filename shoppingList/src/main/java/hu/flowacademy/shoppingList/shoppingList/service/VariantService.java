package hu.flowacademy.shoppingList.shoppingList.service;

import hu.flowacademy.shoppingList.shoppingList.domain.Variant;
import hu.flowacademy.shoppingList.shoppingList.repository.VariantRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VariantService {

    @Autowired
    private VariantRepository variantRepository;

    public List<Variant> getAllElements() {
        return variantRepository.findAll();
    }

    public Variant saveElement(Variant variant) {
        return variantRepository.save(variant);
    }

    public double sumPrice(String id) {
        return variantRepository.sumPrice(id);
    }

    public List<Variant> listVariants() {
        return variantRepository.listVariants();
    }
}
