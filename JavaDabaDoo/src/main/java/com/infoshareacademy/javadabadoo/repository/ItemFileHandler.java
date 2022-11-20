package com.infoshareacademy.javadabadoo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.javadabadoo.model.Article;
import com.infoshareacademy.javadabadoo.model.AudioBook;
import com.infoshareacademy.javadabadoo.model.Book;
import com.infoshareacademy.javadabadoo.model.Item;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
public class ItemFileHandler implements FileHandler {
    private ObjectMapper mapper;
    private File file = new File(this.getClass().getClassLoader().getResource("library.json").getFile());

    public ItemFileHandler() {
        this.mapper = new ObjectMapper();
    }


    private Map<String, String> readFromFile() {
        Map<String, String> itemsList;
        try {
            itemsList = mapper.readValue(
                    file,
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return itemsList;
    }

    @Override
    public List<Item> read() {
        List<Item> items = new ArrayList<>();
        Map<String, String> fromJson = readFromFile();
        Set<String> itemsAsString = fromJson.keySet();
        for (String item : itemsAsString) {
            switch (fromJson.get(item)) {
                case "Book":
                    items.add(new Book(item));
                    break;
                case "AudioBook":
                    items.add(new AudioBook(item));
                    break;
                case "Article":
                    items.add(new Article(item));
                    break;
            }
        }
        return items;
    }

    @Override
    public void write(List<Item> items) {
        ObjectMapper mapper2 = new ObjectMapper();
        Map<String, String> itemsToSave = new HashMap<>();

        for (Item item : items) {
            itemsToSave.put(item.toString(), item.getClass().getSimpleName());
        }

        try {
            mapper.writeValue(new File("src/main/resources/library.json"), itemsToSave);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
