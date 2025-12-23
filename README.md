
# Inmetrics Careers Bot 🚀

Projeto enterprise em **Java + Spring Boot + Playwright + Kafka** para automação da aba **Carreiras** do site da Inmetrics.

## Funcionalidades
- Navegação automatizada até Carreiras
- Acesso à página Nossas Vagas
- Captura real de vagas abertas
- Geração de relatório
- Envio de mensagens para Tech Recruiters via Kafka

## Tecnologias
- Java 17
- Spring Boot 3
- Playwright
- Apache Kafka
- Maven

## Executar
```bash
mvn spring-boot:run
```

## Kafka
Tópico:
```
inmetrics-vagas
```

Mensagem enviada:
```
Nova vaga aberta: <titulo> - <local>
```

## Autor
Matheus – Full Stack / Automação / IA
