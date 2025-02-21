package kz.bitlab.techorda2025.firstProject.db.DBManager;

import kz.bitlab.techorda2025.firstProject.models.Items;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager {
    @Getter
    static List<Items> itemsList = new ArrayList<>();
    static Long id = 7L;

    static {
        itemsList.add(new Items(1L, "Iphone 15", "This is Iphone 15", 555));
        itemsList.add(new Items(2L, "Iphone 16", "This is Iphone 16", 333));
        itemsList.add(new Items(3L, "Samsung S80", "This is Samsung S80", 444));
        itemsList.add(new Items(4L, "Iphone 14", "This is Iphone 14", 666));
        itemsList.add(new Items(5L, "Motorola", "This is Motorola", 888));
        itemsList.add(new Items(6L, "Nokia", "This is Nokia", 777));
    }



    public static void addItem(Items item) {
        itemsList.add(item);
        id++;
    }

    public static Items getItem(Long id) {
        Items newIt = null;
        for (Items item : itemsList) {
            if (Objects.equals(item.getId(), id)) {
                newIt = item;
            }
        }
        return newIt;
    }


    // Метод для обновления товара
    public static void updateItem(Items updatedItem) {
        itemsList.replaceAll(item -> item.getId().equals(updatedItem.getId()) ? updatedItem : item);
    }


    public static void deleteItem(Long id) {
        itemsList.removeIf(item -> item.getId().equals(id));
    }


}
