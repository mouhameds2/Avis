package sully.group.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sully.group.sa.entites.Sentiment;
import sully.group.sa.entites.enums.SentimentType;

import java.util.List;

public interface SentimentRepository extends JpaRepository <Sentiment, Integer> {
    List<Sentiment> findByType(SentimentType type);
}
