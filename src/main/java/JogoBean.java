import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@ManagedBean
@SessionScoped /*Esta é uma anotação do JSF que especifica o escopo do bean gerenciado.
Quando um bean é anotado com @SessionScoped, ele é mantido na sessão HTTP do usuário.*/
public class JogoBean {
	private ArrayList<Jogo> jogos = new ArrayList<>();
	private Jogo jogo = new Jogo(); // Objeto para armazenar o jogo atual

	// Método para salvar o jogo atual
	public void salvar() {
		Random rd = new Random();
		// Definindo o ID e a data do jogo
		jogo.setId(jogos.size() + 1);
		jogo.setData(new Date());
		jogo.setNumeroSecreto(rd.nextInt(5) + 1); //irá gerar um número aleatório entre 1 e 5 (inclusive).

		
		if (jogo.getNumeroAposta().equals(jogo.getNumeroSecreto())) {
			jogo.setResultado("Acertou");
		} else {
			jogo.setResultado("Não acertou.");
		}

		// Adicionando o jogo à lista de jogos e reiniciando o jogo atual
		jogos.add(jogo);
		jogo = new Jogo();
	}

	// Método para excluir um jogo da lista de jogos
	public void excluir(Jogo jogo) {
		jogos.remove(jogo);
	}

	// Getters e setters
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
