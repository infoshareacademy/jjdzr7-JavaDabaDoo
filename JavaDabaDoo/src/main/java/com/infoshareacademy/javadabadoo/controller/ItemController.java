package com.infoshareacademy.javadabadoo.controller;

import com.infoshareacademy.javadabadoo.exceptions.ItemNotFound;
import com.infoshareacademy.javadabadoo.model.article.Article;
import com.infoshareacademy.javadabadoo.model.article.ArticleRepository;
import com.infoshareacademy.javadabadoo.model.audiobook.AudioBook;
import com.infoshareacademy.javadabadoo.model.audiobook.AudioBookRepository;
import com.infoshareacademy.javadabadoo.model.book.Book;
import com.infoshareacademy.javadabadoo.model.book.BookRepository;
import com.infoshareacademy.javadabadoo.model.item.ItemRepository;
import com.infoshareacademy.javadabadoo.model.rating.Rating;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Controller
public class ItemController {

    private final ItemRepository itemRepository;
    private final BookRepository bookRepository;
    private final ArticleRepository articleRepository;
    private final AudioBookRepository audiobookRepository;

    ItemController(ItemRepository itemRepository, BookRepository bookRepository, AudioBookRepository audiobookRepository, ArticleRepository articleRepository) {
        this.itemRepository = itemRepository;
        this.bookRepository = bookRepository;
        this.articleRepository = articleRepository;
        this.audiobookRepository = audiobookRepository;
    }

    @GetMapping("/items")
    String all(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("audiobooks", audiobookRepository.findAll());
        return "itemsresult";
    }

    @GetMapping("/item/{id}")
    String one(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound(id)));
        return "itemresult";
    }

    ;

    @RequestMapping("/newItem")
    String newItem(Model model) {
        return ("newItem");
    }

    @PutMapping("/newArticle/{id}")
    String replaceItem(@RequestBody Article newItem, @PathVariable Long id, Model model) {

        articleRepository.findById(id)
                .map(item -> {
                    item.setLanguage(newItem.getLanguage());
                    item.setAuthor(newItem.getAuthor());
                    item.setScores(new ArrayList<Rating>());
                    item.setTitle(item.getTitle());
                    item.setSource(item.getSource());
                    item.setSubject(item.getSubject());
                    articleRepository.save(item);
                    model.addAttribute("item", item);
                    return "newArticle";
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    articleRepository.save(newItem);
                    model.addAttribute("item", newItem);
                    return "newArticle";
                });
        return "newArticle";
    }

    @PutMapping("/newBook/{id}")
    String replaceItem(@RequestBody Book newItem, @PathVariable Long id, Model model) {

        bookRepository.findById(id)
                .map(item -> {
                    item.setLanguage(newItem.getLanguage());
                    item.setAuthor(newItem.getAuthor());
                    item.setScores(new ArrayList<Rating>());
                    item.setTitle(item.getTitle());
                    item.setDateOfAdd(LocalDateTime.now());
                    item.setIsbn(item.getIsbn());
                    item.setCategory(item.getCategory());
                    bookRepository.save(item);
                    model.addAttribute("item", item);
                    return "newAudioBook";
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    bookRepository.save(newItem);
                    model.addAttribute("item", newItem);
                    return "newAudioBook";
                });
        return "newAudioBook";
    }

    @PutMapping("/newAudiobook/{id}")
    String replaceItem(@RequestBody AudioBook newItem, @PathVariable Long id, Model model) {

        audiobookRepository.findById(id)
                .map(item -> {
                    item.setLanguage(newItem.getLanguage());
                    item.setAuthor(newItem.getAuthor());
                    item.setScores(new ArrayList<Rating>());
                    item.setTitle(item.getTitle());
                    item.setDateOfAdd(LocalDateTime.now());
                    item.setLector(newItem.getLector());
                    item.setFormat(newItem.getFormat());
                    item.setLength(newItem.getLength());
                    audiobookRepository.save(item);
                    model.addAttribute("item", item);
                    return "newBook";
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    audiobookRepository.save(newItem);
                    model.addAttribute("item", newItem);
                    return "newBook";
                });
        return "newBook";
    }


    @DeleteMapping("/deleteItem/{id}")
    String deleteItem(@PathVariable Long id, Model model) {

        audiobookRepository.findById(id).ifPresentOrElse(item -> {
            itemRepository.deleteById(item.getId());
            model.addAttribute("result", "ok");
        }, () -> {
            model.addAttribute("result", ("not deleted!" + " " + id));
        });

        return "deleted";
    }

}
