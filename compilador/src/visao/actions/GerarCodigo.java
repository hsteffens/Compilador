package visao.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import analisador.lexico.LexicalError;
import analisador.lexico.Lexico;
import analisador.lexico.SemanticError;
import analisador.lexico.Semantico;
import analisador.lexico.Sintatico;
import analisador.lexico.SyntaticError;
import analisador.lexico.Token;
import manipulacao.RecuperarSalvarArquivo;
import visao.Interface;

public class GerarCodigo implements ActionListener{
	public static String codigo = "";
	private Interface tela;

	public GerarCodigo(Interface tela) {
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
	    Lexico lexico = new Lexico();
	    Sintatico sintatico = new Sintatico();
	    Semantico semantico = new Semantico();
	    
		lexico.setInput(text);

		TreeMap<Integer, String> conteudoEdicao = getArvoreConteudoPorLinha(text);

		int linha = 0;
		
		if	(text.toString() != null && !"".equals(text.toString().trim())){
			try{
				sintatico.parse(lexico, semantico);
			
				 try {
					if (Interface.file == null) {
		                javax.swing.JFileChooser
		                arquivo = new javax.swing.JFileChooser();
		                arquivo.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
		                int resultadoArq = arquivo.showSaveDialog(null);
		                if( resultadoArq == javax.swing.JFileChooser.CANCEL_OPTION){
		                    return;
		                }    
		                Interface.file = arquivo.getSelectedFile();
		                if(Interface.file == null || Interface.file.getName().equals("")){
		                    javax.swing.JOptionPane.showMessageDialog( null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", javax.swing.JOptionPane.ERROR_MESSAGE);
		                }else{
		                	Interface.file.getAbsolutePath().concat(".il");
		                	Interface.file.getName().concat(".il");
		                    try{
		                        RecuperarSalvarArquivo.salvar("", codigo, Paths.get(Interface.file.getAbsolutePath()));
		                    }catch(Exception e){
		                        JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e.toString());
		                    }
		                } 
		            }else{
		                RecuperarSalvarArquivo.salvar(text, codigo, Paths.get(Interface.file.getAbsolutePath()));
		            }
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e.toString());
		        }
				String saidaFormatada = String.format("Código objeto gerado com sucesso.");
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
				String errorMsg = "Erro na linha "+ linha+" - " + tokenError.getMessage();
	
				if ("Símbolo inválido".equals(tokenError.getMessage())) {
					errorMsg = errorMsg +": "+ getTokenError(text, tokenError);
				}
				getTela().getConsole().setText(errorMsg);
			}catch (SyntaticError e){
				int linhaAtual = 1;
				for (Integer posicao : conteudoEdicao.keySet()) {
					if (e.getPosition() < posicao) {
						linha = linhaAtual;
						break;
					}
					linhaAtual ++;
				}
				String errorMsg = "Erro na linha "+ linha+" - Encontrado " ;
				errorMsg = errorMsg + getSyntaticError(text, e) + " ";
				errorMsg = errorMsg + e.getMessage();
				
				getTela().getConsole().setText(errorMsg);
				
				e.printStackTrace();
			}catch (SemanticError e) {
				int linhaAtual = 1;
				for (Integer posicao : conteudoEdicao.keySet()) {
					if (e.getPosition() < posicao) {
						linha = linhaAtual;
						break;
					}
					linhaAtual ++;
				}
				String errorMsg = "Erro na linha "+ linha+ " - ";
				errorMsg = errorMsg + e.getMessage();
				
				getTela().getConsole().setText(errorMsg);
				
				e.printStackTrace();
			}
		}else{
			getTela().getConsole().setText("Erro. Programa vazio.");
		}
 
	}

	private String getTokenError(String text, LexicalError tokenError) {
		int quebraLinha = text.indexOf('\n', tokenError.getPosition());
		int tabulacao = text.indexOf('\t', tokenError.getPosition());
		int espaco = text.indexOf(' ', tokenError.getPosition());
		if (quebraLinha == -1) {
			quebraLinha =999999999;
		}
		if (tabulacao == -1) {
			tabulacao =999999999;
		}
		if (espaco == -1) {
			espaco =999999999;
		}
		int endIndex = quebraLinha < tabulacao && quebraLinha < espaco ? quebraLinha :
			tabulacao < quebraLinha && tabulacao < espaco ? tabulacao : 
				espaco < quebraLinha && espaco < tabulacao ? espaco : espaco;

		String simbolo = text.substring(tokenError.getPosition(), endIndex == 999999999 ? text.length() : endIndex);
		return simbolo;
	}
	
	private String getSyntaticError(String text, SyntaticError syntaticError) {
		int quebraLinha = text.indexOf('\n', syntaticError.getPosition());
		int tabulacao = text.indexOf('\t', syntaticError.getPosition());
		int espaco = text.indexOf(' ', syntaticError.getPosition());
		if (quebraLinha == -1) {
			quebraLinha =999999999;
		}
		if (tabulacao == -1) {
			tabulacao =999999999;
		}
		if (espaco == -1) {
			espaco =999999999;
		}
		int endIndex = quebraLinha < tabulacao && quebraLinha < espaco ? quebraLinha :
			tabulacao < quebraLinha && tabulacao < espaco ? tabulacao : 
				espaco < quebraLinha && espaco < tabulacao ? espaco : espaco;

		String simbolo = text.substring(syntaticError.getPosition(), endIndex == 999999999 ? text.length() : endIndex);
		return simbolo;
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
