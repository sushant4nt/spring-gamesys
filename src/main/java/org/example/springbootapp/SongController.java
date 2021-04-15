package org.example.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SongController {

    @Autowired
    private SongRepo repo;

    @GetMapping
    public String showHomePage() {
        return "home";
    }

    @GetMapping("songs")
    public String showSongsPage(Model model) {
        model.addAttribute("songs", repo.findAll());
        return "songs";
    }

    @GetMapping("newsong")
    public String showNewSongPage(Model model) {
        model.addAttribute("song", new Song());
        return "newsong";
    }

    @PostMapping("newsong")
    public String addNewSong(Song song, Model model) {
        repo.save(song);
        model.addAttribute("song", song);
        return "newsong";
    }
}
