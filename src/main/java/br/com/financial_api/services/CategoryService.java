package br.com.financial_api.services;

import br.com.financial_api.entities.Category;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.List;

@ApplicationScoped
public class CategoryService {
    public Uni<List<Category>> listAll() {
        return Category.listAll();
    }

    public Multi<String> greetings(int count, String name) {
        return Multi.createFrom()
            .ticks()
            .every(Duration.ofSeconds(1))
            .onItem()
            .apply(n -> String.format("hello %s - %d", name, n))
            .transform()
            .byTakingFirstItems(count);
    }
}
