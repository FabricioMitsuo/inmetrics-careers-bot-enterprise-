
package br.com.inmetrics.bot.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import br.com.inmetrics.bot.model.Vaga;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(Vaga vaga) {
        kafkaTemplate.send("inmetrics-vagas",
            "Nova vaga aberta: " + vaga.getTitulo() + " - " + vaga.getLocal());
    }
}
