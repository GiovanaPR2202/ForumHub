package api.forumhub.domain.perfil;

public record  DadosListagemPerfil(String nome){

    public DadosListagemPerfil(Perfil perfil){
        this(perfil.getNome());
    }
}
