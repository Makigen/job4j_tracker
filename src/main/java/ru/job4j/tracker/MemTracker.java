package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class MemTracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private int generateId() {
        Random rm = new Random();
        return (int)(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод получения списка всех заявок
     *
     * @return список всех заявок
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Медот получения списка по имени
     *
     * @param key имя заявки
     * @return список заявок с одинаковым именем?
     */
    public List<Item> findByName(String key) {
        List<Item> allFound = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                allFound.add(item);
            }
        }
        return allFound;
    }

    /**
     * Метод получения заявки по id
     *
     * @param id
     * @return искомая заявка
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод возвращает index по id.
     *
     * @param id
     * @return index элемента с искомым id
     */
    private int indexOf(int id) {
        int rsl = -1;
        int index = 0;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }

    /**
     * Метод замены заявки с сохранением прежнего id
     *
     * @param id
     * @param item
     * @return
     */
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.set(index, item);
            item.setId(id);
            rsl = true;
        }
        return rsl;
    }

    /**
     * @param id
     * @return
     */
    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rsl = true;
        }
        return rsl;
    }
}