package org.dto.inventario;

import org.model.Inventario;
import org.model.Item;
import org.model.Jogador;

public record InventarioRequest(
        Long id,
        Integer quantidade,
        Long idJogador,
        Long idItem
) {
    public Inventario toEntity() {
        Inventario i = new Inventario();
        if (id != null) {
            i.setId(id);
        }
        i.setQuantidade(quantidade);
        if (this.idJogador != null) {
            Jogador jogador = new Jogador();
            jogador.setId(this.idJogador);
            i.setJogador(jogador);
        }
        if (this.idItem != null) {
            Item item = new Item();
            item.setId(this.idItem);
            i.setItem(item);
        }
        return i;
    }
}
