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
 /*   @RequestMapping("/newArticle")
    String newArticle(Model model) {
        model.addAttribute("test", "test");
        return "newArticle";
    }


    @RequestMapping("/editArticle/{id}")
    String editArticle(@PathVariable Long id, Model model) {

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
                    return "editArticle";
                });

        model.addAttribute("test", "test");
        return "editArticle";
    }
  */

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

    /*   @RequestMapping("/newBook")
       String newBook(Model model) {

           model.addAttribute("test", "test");
           return "newBook";
       }

       @RequestMapping("/editBook/{id}")
       String editBook(@PathVariable Long id, Model model) {

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
                       return "editBook";
                   });

           model.addAttribute("test", "test");
           return "editBook";
       }
   */
    @GetMapping("/newAudioBook")
    public String showCreateAudioBookForm(Model model) {
        model.addAttribute("formData", new Book());
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
    /*
    @RequestMapping("/newAudiobook")
    String newAudioBook(Model model) {

        model.addAttribute("test", "test");
        return "newAudiobook";
    }

    @RequestMapping("/editAudiobook/{id}")
    String editAudioBook(@PathVariable Long id, Model model) {

        System.out.println(id);
        if (true) {
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
                        return "editAudioBook";
                    });
        }
        model.addAttribute("test", "test");
        return "editAudioBook";
    }
     */


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
