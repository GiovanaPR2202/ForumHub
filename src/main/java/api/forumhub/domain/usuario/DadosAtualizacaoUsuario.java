package api.forumhub.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        long id,
        String nome,
        String email,
        String senha



) {
}
