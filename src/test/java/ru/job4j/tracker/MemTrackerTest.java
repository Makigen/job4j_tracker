package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.nullValue;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindAllThenReturnThreeItems() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        List<Item> result = memTracker.findAll();
        assertThat(result, is(new ArrayList<>(Arrays.asList(item1, item2, item3))));
    }

    @Test
    public void whenFindAllTest1ThenReturnTwoItemsArray() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test1");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        Item[] result = memTracker.findByName("test1").toArray(new Item[0]);
        assertThat(result, is(new Item[]{item1, item3}));
    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenReplaceMinus() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        int id = 0;
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findAll().toArray(), is(new Item[]{bug}));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}