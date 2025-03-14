package dev.lira.lojavirtual.itemCarrinho.application.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ItemCarrinhoPatchResquest {
    private int quantidade;
}
