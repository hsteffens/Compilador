package visao.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import visao.Interface;
import analisador.lexico.LexicalError;
import analisador.lexico.Lexico;
import analisador.lexico.Token;
import analisador.lexico.tipoConstants.EnConstantes;

public class Compilar implements ActionListener{

	private Interface tela;
	
	public Compilar(Interface tela) {
		this.tela = tela;
	}
	
	public Interface getTela() {
		return tela;
	}

	public void setTela(Interface tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		String text = getTela().getEditor().getText();
		
		if (text.isEmpty()) {
			getTela().getConsole().setText("nenhum programa para compilar!");
			return;
		}
		
		Lexico lexico = new Lexico();
		lexico.setInput(text);
    	
		TreeMap<Integer, String> conteudoEdicao = getArvoreConteudoPorLinha(text);
    	
    	List<String> linhas = new ArrayList<>();
    	List<String> classes = new ArrayList<>();
    	List<String> lexemas = new ArrayList<>();

    	//Monta o cabecalho de saida
    	linhas.add( "linha");
    	classes.add("classe");
    	lexemas.add("lexema");
    	
    	int linha = 0;
    	Token token = null;
    	try{
    		while ((token = lexico.nextToken()) != null) {
    			if (EnConstantes.COMENTARIO == EnConstantes.get(token.getId())) {
					continue;
				}
    			linhas.add(getLinhaToken(conteudoEdicao, token, linha));
    			classes.add(EnConstantes.get(token.getId()).getDescricao());
    			lexemas.add(token.getLexeme());
			}
    		
    		linhas = formatTabela(linhas);
    		classes = formatTabela(classes);
    		lexemas = formatTabela(lexemas);
    		
    		List<String> listaSimbolos = new ArrayList<String>();
    		for (int i = 0; i < linhas.size(); i++) {
    			listaSimbolos.add(linhas.get(i));
    			listaSimbolos.add(classes.get(i));
    			listaSimbolos.add(lexemas.get(i));
    		}
    		
    		
    		String saidaFormatada = String.format(getFormat(listaSimbolos), listaSimbolos.toArray());
    		saidaFormatada = saidaFormatada + '\n'+ "programa compilado com sucesso.";
			getTela().getConsole().setText(saidaFormatada);
    	}catch(LexicalError tokenError){
    		int linhaAtual = 1;
    		for (Integer posicao : conteudoEdicao.keySet()) {
    			if (tokenError.getPosition() < posicao) {
    				linha = linhaAtual;
    				break;
    			}
    			linhaAtual ++;
    		}
    		getTela().getConsole().setText("Erro na linha "+ linha+" - " + tokenError.getMessage());
    	}
		
	}

	private String getFormat(List<String> arrayList) {
		int count = 1;
		String format = "";
		for (int i = 0; i < arrayList.size(); i++) {
			if (count == 1) {
				format = format + "%s ";
			}else if(count == 2){
				format = format + "%50s ";
			}else if(count == 3){
				format = format + "%20s\n";
				count = 0;
			}
			
			count ++;
		}
		return format;
	}

	/**
	 * Retorna a linha que o token atual está sendo editado
	 * @param conteudoEdicao
	 * @param token
	 * @param linha
	 * @return
	 */
	private String getLinhaToken(TreeMap<Integer, String> conteudoEdicao, Token token, int linha) {
		int linhaAtual = 1;
		for (Integer posicao : conteudoEdicao.keySet()) {
			if (token.getPosition() < posicao && conteudoEdicao.get(posicao).contains(token.getLexeme())) {
				linha = linhaAtual;
				break;
			}
			linhaAtual ++;
		}
		return String.valueOf(linha);
	}

	/**
	 * Recebe uma {@link String} e separa cada quebra de linha em um registro especifico, 
	 * a chave da arvore é a posição de termino de cada quebra de linha.
	 * @param text
	 * @return
	 */
	private TreeMap<Integer, String> getArvoreConteudoPorLinha(String text) {
		TreeMap<Integer, String> hashMap = new TreeMap<Integer, String>();
    	int count = 0;
    	text = text+'\n';
    	for (int i = 0; i < text.length(); i++) {
			char charAt = text.charAt(i);
			if ('\n' == charAt) {
				int position = i;
				hashMap.put(position, text.substring(count, position));
				count = position;
			}
		}
		return hashMap;
	}
	
	  private List<String> formatTabela(List<String>tabela){
	    	int maiorLeght = 0;
	    	for (String string : tabela) {
				if (maiorLeght == 0) {
					maiorLeght = string.length();
					continue;
				}
				
				if (maiorLeght < string.length()) {
					maiorLeght = string.length();
					continue;
				}
			}
	    	
	    	List<String> tabelaFormatada = new ArrayList<>();
	    	for (String string : tabela) {
				int tamanho = string.length();
				if (maiorLeght > tamanho) {
					for (int i = 0; i < (maiorLeght - tamanho); i++) {
						string = string.concat(" ");
					}
				}
				tabelaFormatada.add(string);
			}
	    	
	    	return tabelaFormatada;
	    	
	    }

}
