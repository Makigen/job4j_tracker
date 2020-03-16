import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод получения списка всех заявок
     * @return список всех заявок
     */
    public Item[] findAll() {
        return items;
    }

    /**
     * Медот получения списка по имени
     * @param key имя заявки
     * @return список заявок с одинаковым именем?
     */
    public Item[] findByName(String key) {
        return items;
    }

    /**
     * Метод получения заявки по id
     * @param id
     * @return искомая заявка
     */
    public Item findById(String id) {
        return null;
    }
}