import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@ManagedBean
@SessionScoped
public class JogoBean {
    private ArrayList<Jogo> jogos = new ArrayList<>();
    private Jogo jogo = new Jogo();

    public void salvar() {
        Random rd = new Random();
        jogo.setId(jogos.size() + 1);
        jogo.setData(new Date());
        jogo.setNumeroSecreto(rd.nextInt(5) + 1); 

        
        if (jogo.getNumeroAposta().equals(jogo.getNumeroSecreto())) {
            jogo.setResultado("Acertou !!!, Meus parabéns!");
        } else {
            jogo.setResultado("Você não acertou.");
        }

        jogos.add(jogo);
        jogo = new Jogo();
    }
    public void excluir(Jogo jogo) {
        jogos.remove(jogo);
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
