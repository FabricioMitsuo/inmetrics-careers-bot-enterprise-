
package br.com.inmetrics.bot.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.*;
import br.com.inmetrics.bot.automation.InmetricsPlaywrightBot;
import br.com.inmetrics.bot.model.Vaga;

@Service
public class VagaService {

    private final InmetricsPlaywrightBot bot;
    private final KafkaProducerService kafka;

    public VagaService(InmetricsPlaywrightBot bot, KafkaProducerService kafka) {
        this.bot = bot;
        this.kafka = kafka;
    }

    @PostConstruct
    public void executar() {
        List<Vaga> vagas = bot.buscarVagas();
        vagas.forEach(v -> {
            System.out.println(v.getTitulo());
            kafka.enviar(v);
        });
    }
}
