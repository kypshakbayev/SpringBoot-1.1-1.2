package kz.bitlab.techorda2025.firstProject.controllers;

import kz.bitlab.techorda2025.firstProject.db.DBManager.DBManager;
import kz.bitlab.techorda2025.firstProject.models.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller //аналог Http Servlet
public class HomeController {

    @GetMapping("/home") //protected void doGet
    public String getIndex(Model model) { //req.getreguestDispatcher

        List<Items> itemsList = DBManager.getItemsList();

        model.addAttribute("tovary", itemsList); //req.setAttribute("tovary", itemsList)
        return "index"; //req.getRequestDispatcher("/pages/addBlog.jsp").forward(req, resp);
    }



    @GetMapping(value = "/addItem")
    public String getAddItemPage() {
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam("item_name") String name,
                          @RequestParam("productDescription") String description,
                          @RequestParam("productPrice") Double price) {

//        Items item = new Items();
//        item.setName(name);
//        item.setDescription(description);
//        item.setPrice(price);

        Items item = Items.builder().
                name(name).
                description(description).
                price(price).
                build();

        DBManager.addItem(item);
        return "redirect:/home";
    }

    @GetMapping(value = "/details")
    public String getDetails(@RequestParam("id") Long id, Model model) {
        Items newItem = DBManager.getItem(id);
        if(newItem != null) {
            model.addAttribute("tovar", newItem);
        }
        return "details";
    }

    // Открываем страницу редактирования товара
    @GetMapping("/edit")
    public String editItem(@RequestParam("id") Long id, Model model) {
        Items item = DBManager.getItem(id);
        if (item != null) {
            model.addAttribute("item", item);
            return "edit";
        }
        return "redirect:/";
    }

    // Обрабатываем обновление товара
    @PostMapping("/update")
    public String updateItem(@ModelAttribute Items item) {
        DBManager.updateItem(item);
        return "redirect:/home";
    }


    @PostMapping("/delete")
    public String deleteItem(@RequestParam("id") Long id) {
        DBManager.deleteItem(id);
        return "redirect:/home";
    }

}
