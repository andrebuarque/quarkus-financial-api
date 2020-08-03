package br.com.financial_api.dtos;

import br.com.financial_api.entities.Category;
import br.com.financial_api.entities.CategoryType;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CategoryDTO {
    public String id;
    @NotBlank
    public String name;
    @NotNull
    public CategoryType type;

    public Category toEntity() {
        final Category entity = new Category();

        if (Objects.nonNull(this.id)) {
            entity.id = new ObjectId(this.id);
        }

        entity.name = this.name;
        entity.type = this.type;

        return entity;
    }
}
