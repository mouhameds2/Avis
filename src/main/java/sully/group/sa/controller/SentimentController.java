package sully.group.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import sully.group.sa.entites.Client;
import sully.group.sa.entites.Sentiment;
import sully.group.sa.entites.enums.SentimentType;
import sully.group.sa.services.SentimentService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path="sentiment", produces = APPLICATION_JSON_VALUE )
public class SentimentController {

    SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createSentiment(@RequestBody Sentiment sentiment){
        this.sentimentService.createSentiment(sentiment);
    }

    @GetMapping()
    public List<Sentiment> sentimentList(@RequestParam(required = false) SentimentType type) {
        return this.sentimentService.sentimentList(type);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void deleteSentiement(@PathVariable int id){
         this.sentimentService.deleteSentiement(id);

    }
}
