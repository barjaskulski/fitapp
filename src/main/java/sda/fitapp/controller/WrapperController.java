package sda.fitapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.fitapp.entity.WrapperIngredientToProportion;
import sda.fitapp.repository.WrapperIngredientProportionRepository;

@RestController
@RequestMapping("/api/meal/wrapper")
public class WrapperController {
    WrapperIngredientProportionRepository wrapperIngredientProportionRepository;

    @Autowired
    public WrapperController(WrapperIngredientProportionRepository wrapperIngredientProportionRepository) {
        this.wrapperIngredientProportionRepository = wrapperIngredientProportionRepository;
    }




    @PostMapping
    public WrapperIngredientToProportion addWrapper
            (WrapperIngredientToProportion wrapperIngredientToProportion){
        return wrapperIngredientProportionRepository.save(wrapperIngredientToProportion);
    }

}
