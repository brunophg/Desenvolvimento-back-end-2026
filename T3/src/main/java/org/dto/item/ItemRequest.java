package org.dto.item;

import org.model.Item;
import java.math.BigDecimal;

public record ItemRequest(
        Long id,
        String nome,
        String tipo,
        BigDecimal valor
) {
    public Item toEntity() {
        Item item = new Item();
        if (id != null) {
            item.setId(id);
        }
        item.setNome(nome);
        item.setTipo(tipo);
        item.setValor(valor);

        return item;
    }
}
