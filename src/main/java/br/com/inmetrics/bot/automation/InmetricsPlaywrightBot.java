
package br.com.inmetrics.bot.automation;

import com.microsoft.playwright.*;
import br.com.inmetrics.bot.model.Vaga;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class InmetricsPlaywrightBot {

    public List<Vaga> buscarVagas() {
        List<Vaga> vagas = new ArrayList<>();

        try (Playwright pw = Playwright.create()) {
            Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            page.navigate("https://www.inmetrics.com.br");
            page.locator("text=Carreiras").click();
            page.waitForTimeout(3000);

            page.locator("text=Nossas Vagas").click();
            page.waitForTimeout(3000);

            Locator cards = page.locator(".job-card");

            for (int i = 0; i < cards.count(); i++) {
                String titulo = cards.nth(i).innerText();
                vagas.add(new Vaga(titulo, "Brasil"));
            }
            browser.close();
        }
        return vagas;
    }
}
