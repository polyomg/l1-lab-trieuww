package com.example.lab5.service;

import com.example.lab5.model.DB;
import com.example.lab5.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item origin = DB.items.get(id);
        if (origin == null) return null;
        if (map.containsKey(id)) {
            Item it = map.get(id);
            it.setQty(it.getQty() + 1);
            return it;
        } else {
            Item it = new Item(id, origin.getName(), origin.getPrice(), 1);
            map.put(id, it);
            return it;
        }
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item it = map.get(id);
        if (it != null) it.setQty(qty);
        return it;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().stream().mapToInt(Item::getQty).sum();
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(i -> i.getPrice() * i.getQty()).sum();
    }
}
