package com.infoshareacademy.javadabadoo.controller;

import com.infoshareacademy.javadabadoo.model.article.ArticleRepository;
import com.infoshareacademy.javadabadoo.model.audiobook.AudioBookRepository;
import com.infoshareacademy.javadabadoo.model.book.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final BookRepository bookRepository;
    private final ArticleRepository articleRepository;
    private final AudioBookRepository audiobookRepository;

    public DashboardController(BookRepository bookRepository, ArticleRepository articleRepository, AudioBookRepository audiobookRepository) {
        this.bookRepository = bookRepository;
        this.articleRepository = articleRepository;
        this.audiobookRepository = audiobookRepository;
    }

    @GetMapping("/dashboard")
    String loginForm(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("audiobooks", audiobookRepository.findAll());

        return "blank";
    }
}
