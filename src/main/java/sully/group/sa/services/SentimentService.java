package sully.group.sa.services;

import org.springframework.stereotype.Service;
import sully.group.sa.entites.Client;
import sully.group.sa.entites.Sentiment;
import sully.group.sa.entites.enums.SentimentType;
import sully.group.sa.repository.SentimentRepository;

import java.util.List;

@Service
public class SentimentService {
    private Clientservice clientService;
private SentimentRepository sentimentRepository;

    public SentimentService(Clientservice clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void createSentiment (Sentiment sentiment){
        Client client = this.clientService.readOrCreateClient(sentiment.getClient());
        sentiment.setClient(client);
        if(sentiment.getMessage().contains("pas")){
            sentiment.setType((SentimentType.NEGATIF));
        }else  {
            sentiment.setType((SentimentType.POSITIF));
        }
        this.sentimentRepository.save(sentiment);

    }


    public List<Sentiment> sentimentList(SentimentType type) {
        if (type == null) {
            return this.sentimentRepository.findAll() ;
        } else {
            return this.sentimentRepository.findByType(type);
        }

    }

    public void deleteSentiement(int id) {
     this.sentimentRepository.deleteById(id);

        }

}


