package com.infoshareacademy.javadabadoo.controller;

import com.infoshareacademy.javadabadoo.model.article.Article;
import com.infoshareacademy.javadabadoo.model.article.ArticleRepository;
import com.infoshareacademy.javadabadoo.model.audiobook.AudioBook;
import com.infoshareacademy.javadabadoo.model.audiobook.AudioBookRepository;
import com.infoshareacademy.javadabadoo.model.book.Book;
import com.infoshareacademy.javadabadoo.model.book.BookRepository;
import com.infoshareacademy.javadabadoo.model.item.Item;
import com.infoshareacademy.javadabadoo.model.item.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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

    @RequestMapping("/items")
    String all(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("audiobooks", audiobookRepository.findAll());
        return "itemsresult";
    }

    @RequestMapping("/item/{id}")
    String one(@PathVariable Long id, Model model) {
        Optional<Article> article = articleRepository.findById(id);
        Optional<Book> book = bookRepository.findById(id);
        Optional<AudioBook> audiobook = audiobookRepository.findById(id);

        Item item = null;
        if (audiobook.isPresent()) {
            item = audiobook.get();
        }
        if (book.isPresent()) {
            item = book.get();
        }
        if (article.isPresent()) {
            item = article.get();
        }

        model.addAttribute("item", item);

        return "itemresult";
    }

    @RequestMapping("/newItem")
    String newItem(Model model) {
        return ("newItem");
    }

    @GetMapping("/newArticle")
    public String showCreateArticle(Model model) {
        model.addAttribute("formData", new Article());
        return "newArticle";
    }

    @PostMapping("/newArticle")
    public String doCreateArticle(@ModelAttribute("formData") Article formData,
                                  BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            return "newArticle";
        }
        articleRepository.save(formData);
        return "newArticle";
    }

    @GetMapping("/eArticle/{id}")
    String editArticle(@PathVariable Long id, Model model) {

        var article = articleRepository.findById(id)
                .map(item -> {
                    model.addAttribute("formData", item);
                    return item;
                });

        if (article.isPresent()) {
            return "redirect:/editArticle/" + id;
        }
        return "redirect:/items";

    }

    @GetMapping("/editArticle/{id}")
    String editArticle(@PathVariable Long id, @ModelAttribute("formData") Article formData,
                       BindingResult bindingResult,
                       Model model) {

        if (bindingResult.hasErrors()) {
            return "editArticle";
        }
        articleRepository.findById(id)
                .map(item -> {
                    model.addAttribute("formData", item);
                    model.addAttribute("id", id);
                    return "editArticle";
                });

        return "editArticle";
    }

    @PostMapping("/editArticleDone/{id}")
    String editArticle2(@PathVariable Long id, @ModelAttribute("formData") Article formData,
                        BindingResult bindingResult,
                        Model model) {

        articleRepository.save(formData);

        return "redirect:/items";
    }


    @GetMapping("/eBook/{id}")
    String editBook(@PathVariable Long id, Model model) {

        var article = bookRepository.findById(id)
                .map(item -> {
                    model.addAttribute("formData", item);
                    return item;
                });

        if (article.isPresent()) {
            return "redirect:/editBook/" + id;
        }
        return "redirect:/items";

    }

    @GetMapping("/editBook/{id}")
    String editBook(@PathVariable Long id, @ModelAttribute("formData") Book formData,
                    BindingResult bindingResult,
                    Model model) {

        if (bindingResult.hasErrors()) {
            return "editBook";
        }

        bookRepository.findById(id)
                .map(item -> {
                    model.addAttribute("formData", item);
                    model.addAttribute("id", id);
                    return "editBook";
                });

        return "editBook";
    }

    @PostMapping("/editBookDone/{id}")
    String editBook2(@PathVariable Long id, @ModelAttribute("formData") Book formData,
                     BindingResult bindingResult,
                     Model model) {

        bookRepository.save(formData);

        return "redirect:/items";
    }

    @GetMapping("/newBook")
    public String showCreateBookForm(Model model) {
        model.addAttribute("formData", new Book());
        return "newBook";
    }

    @PostMapping("/newBook")
    public String doCreateBook(@ModelAttribute("formData") Book formData,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "newBook";
        }
        bookRepository.save(formData);
        return "newBook";
    }


    @GetMapping("/eAudioBook/{id}")
    String editAudioBook(@PathVariable Long id, Model model) {

        var audiobook = audiobookRepository.findById(id)
                .map(item -> {
                    model.addAttribute("formData", item);
                    return item;
                });

        if (audiobook.isPresent()) {
            return "redirect:/editAudioBook/" + id;
        }
        return "redirect:/items";

    }

    @GetMapping("/editAudioBook/{id}")
    String editArticle(@PathVariable Long id, @ModelAttribute("formData") AudioBook formData,
                       BindingResult bindingResult,
                       Model model) {

        if (bindingResult.hasErrors()) {
            return "editAudioBook";
        }

        audiobookRepository.findById(id)
                .map(item -> {
                    model.addAttribute("formData", item);
                    model.addAttribute("id", id);
                    return "editAudioBook";
                });

        return "editAudioBook";
    }

    @PostMapping("/editAudioBookDone/{id}")
    String editArticle2(@PathVariable Long id, @ModelAttribute("formData") AudioBook formData,
                        BindingResult bindingResult,
                        Model model) {

        audiobookRepository.save(formData);

        return "redirect:/items";
    }

    @GetMapping("/newAudioBook")
    public String showCreateAudioBookForm(Model model) {
        model.addAttribute("formData", new AudioBook());
        return "newAudioBook";
    }

    @PostMapping("/newAudioBook")
    public String doCreateAudioBook(@ModelAttribute("formData") AudioBook formData,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            return "newAudioBook";
        }
        audiobookRepository.save(formData);
        return "newAudioBook";
    }


    @RequestMapping("/deleteItem/{id}")
    String deleteItem(@PathVariable Long id, Model model) {


        Optional<Article> article = articleRepository.findById(id);
        Optional<Book> book = bookRepository.findById(id);
        Optional<AudioBook> audiobook = audiobookRepository.findById(id);

        Item item = null;
        if (audiobook.isPresent()) {
            item = audiobook.get();
            audiobookRepository.deleteById(item.getId());
            model.addAttribute("result", "ok");
            return "deleted";
        }
        if (book.isPresent()) {
            item = book.get();
            bookRepository.deleteById(item.getId());
            model.addAttribute("result", "ok");
            return "deleted";
        }
        if (article.isPresent()) {
            item = article.get();
            articleRepository.deleteById(item.getId());
            model.addAttribute("result", "ok");
            return "deleted";
        }

        model.addAttribute("result", ("not deleted!" + " " + id));

        return "deleted";
    }

}
