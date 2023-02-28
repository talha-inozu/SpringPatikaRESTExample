package com.example.springpatika.tutorials.controller;

import com.example.springpatika.tutorials.beandto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @GetMapping({"/", "index"})
    public String index(){
        return "index";
    }




//    @GetMapping("/thymeleaf")
////    @ResponseBody
//    public  String getThymeleaf1(Model model){
//        model.addAttribute("model_key","Object Value");
//        List<ProductDto> productDtoList = new ArrayList<>();
//        ProductDto productDto = ProductDto.builder().id(0L).name("First Product").price(35).build();
//        ProductDto productDto2 = ProductDto.builder().id(1L).name("Second Product").price(70).build();
//        productDtoList.add(productDto);
//        productDtoList.add(productDto2);
//        model.addAttribute("model_key_object",productDtoList);
//        return "thymeleaf"; // returned  html page name
//    }


    @GetMapping({"/thymeleaf/{id}", "/thymeleaf1"})
//    @ResponseBody
    public  String getThymeleaf2(Model model, @PathVariable(name = "id", required = false) Long id){
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = ProductDto.builder().id(id).name("First Product").price(35).build();
        ProductDto productDto2 = ProductDto.builder().id(id+1).name("Second Product").price(70).build();
        productDtoList.add(productDto);
        productDtoList.add(productDto2);
        model.addAttribute("model_key_path_var",productDtoList);
        return "thymeleaf"; // returned  html page name
    }

    @GetMapping("/thymeleaf") // ?id=4
//    @ResponseBody
    public  String getThymeleaf3(Model model, @RequestParam(name = "id",defaultValue = "0") Long id){
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = ProductDto.builder().id(id).name("First Product").price(35).build();
        ProductDto productDto2 = ProductDto.builder().id(id+1).name("Second Product").price(70).build();
        productDtoList.add(productDto);
        productDtoList.add(productDto2);
        model.addAttribute("model_key_path_var",productDtoList);
        return "thymeleaf"; // returned  html page name
    }
}
