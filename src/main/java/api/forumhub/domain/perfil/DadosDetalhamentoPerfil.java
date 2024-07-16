package api.forumhub.domain.perfil;

public record DadosDetalhamentoPerfil(String nome) {

    public DadosDetalhamentoPerfil(Perfil perfil){
        this(perfil.getNome());
    }
}
