package com.lookup.lookup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCrudController<T extends BaseResponse> {
    private List<T> items = new ArrayList<>();

    public BaseCrudController()
    {
        init();
    }

    public T getItem(long itemId)
    {
        return items.stream().filter(m -> m.getId() == itemId).findFirst().orElse(null);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setItems(T item)
    {
        this.items.clear();
        this.items.add(item);
    }

    public List<T> deleteItem(int id)
    {
        items.removeIf(movie -> movie.getId() == id);
        return items;
    }

    public T merge(int id, T t)
    {
        items.forEach(m -> {
            if (m.getId() == id)
                m.copy(t);
        });
        return t;
    }

    public T addItem(T t)
    {
        t.setId(System.currentTimeMillis());
        items.add(t);
        return t;
    }



    public abstract void init();
}
