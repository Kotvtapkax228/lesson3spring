package com.lesson3.lesson3spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Data
@AllArgsConstructor
@Controller
public class PageController  {
    private PersonRepository personRepository;
    private UserRepository userRepository;
    private BookRepository bookRepository;

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    //@Transactional
    public String processFind(SearchForm form, Model model) {
        String author = form.getAuthor();
        String title = form.getTitle();
        String genre = form.getGenre();
        List<BookItem> items;
        System.out.println("author = "+author);
        System.out.println("title = "+title);
        System.out.println("genre = "+genre);
        if(author != null && !author.equals("") && title != null && !title.equals("") && genre != null && !genre.equals("")){
            items = bookRepository.findByAuthorAndTitleAndGenre(author, title, genre);
        }else if(author != null && !author.equals("") && title != null && !title.equals("")){
            items = bookRepository.findByAuthorAndTitle(author, title);
        }else if(author != null && !author.equals("") ){
            items = bookRepository.findByAuthor(author);
        }else if( title != null && !title.equals("")){
            items = bookRepository.findByTitle(title);
        }else {
            items = bookRepository.findAll();
        }
        model.addAttribute("result", items);
        System.out.println("result = "+items);
        return "result";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model){
        model.addAttribute("searchForm", new SearchForm());

        return "search";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){

        return "index";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(){
        return "admin";
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String user(){
        return "user";
    }

//    @RequestMapping(value = "/privatefolder", method = RequestMethod.GET)
//    public String privatefolder(){
//        return "privatefolder";
//    }
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public String logout(){
        return "logout";
    }
}
