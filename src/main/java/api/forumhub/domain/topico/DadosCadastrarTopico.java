package api.forumhub.domain.topico;

import api.forumhub.domain.curso.Curso;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastrarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,

        @NotNull
        @Future
        LocalDateTime dataCriacao,
        @NotBlank
        Status status,
        @NotBlank
        Curso curso ) {
}
