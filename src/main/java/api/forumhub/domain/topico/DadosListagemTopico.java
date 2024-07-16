package api.forumhub.domain.topico;

import api.forumhub.domain.curso.Curso;
import api.forumhub.domain.perfil.Perfil;
import api.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, String Mensagem, LocalDateTime dataCriacao, Usuario autor, Curso curso, Status status ) {


    public DadosListagemTopico(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), topicos.getDataCriacao(),
                topicos.getAutor(), topicos.getCurso(), topicos.getStatus());
    }


}
