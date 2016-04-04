package visao;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import manipulacao.RecuperarSalvarArquivo;
import visao.actions.Compilar;

public class Interface extends javax.swing.JFrame {
    File file = null;
    String textoCopyCutPaste = "";
    
    public Interface() {
        initComponents();
        editor.setBorder(new NumberedBorder());
        editor.setRows(100);
        editor.setColumns(200);
        console.setRows(50);
        console.setColumns(200);
        bEquipe.setMnemonic(KeyEvent.VK_F1);
        
        //Hotkey novo
        KeyStroke keyNovo = KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK); 
        Action performNovo = new AbstractAction("Novo") {  
            public void actionPerformed(ActionEvent e) {     
                 bNovoActionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performNovo", performNovo);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyNovo, "performNovo");
        
        //Hotkey Abrir
        KeyStroke keyAbrir = KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK); 
        Action performAbrir = new AbstractAction("Abrir") {  
            public void actionPerformed(ActionEvent e) {     
                 bAbrirActionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performAbrir", performAbrir);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyAbrir, "performAbrir");
        
        //Hotkey Salvar
        KeyStroke keySave = KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK); 
        Action performSave = new AbstractAction("Save") {  
            public void actionPerformed(ActionEvent e) {     
                 bSaveActionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performSave", performSave);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keySave, "performSave"); 
        
        //Hotkey Copiar
        KeyStroke keyCopiar = KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK); 
        Action performCopiar = new AbstractAction("Copiar") {  
            public void actionPerformed(ActionEvent e) {     
                 bCopiarActionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performCopiar", performCopiar);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyCopiar, "performCopiar");
        
        //Hotkey Colar
        KeyStroke keyColar = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK); 
        Action performColar = new AbstractAction("Colar") {  
            public void actionPerformed(ActionEvent e) {     
                 bColarActionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performColar", performColar);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyColar, "performColar");
        
        //Hotkey Recortar
        KeyStroke keyRecortar = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK); 
        Action performRecortar = new AbstractAction("Recortar") {  
            public void actionPerformed(ActionEvent e) {     
                 bRecortarActionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performColar", performRecortar);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyRecortar, "performRecortar");
        
        //Hotkey Compilar
        KeyStroke keyCompilar = KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0); 
        final Compilar compilar = new Compilar(this);
        Action performCompilar = new AbstractAction("Compilar") {  
            public void actionPerformed(ActionEvent e) { 
            	compilar.actionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performCompilar", performCompilar);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyCompilar, "performCompilar");
        
        //Hotkey Gerar
        KeyStroke keyGerar = KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0); 
        Action performGerar = new AbstractAction("Gerar") {  
            public void actionPerformed(ActionEvent e) {     
                 bGerarActionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performGerar", performGerar);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyGerar, "performGerar");
        
        //Hotkey Equipe
        KeyStroke keyEquipe = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0); 
        Action performEquipe = new AbstractAction("Equipe") {  
            public void actionPerformed(ActionEvent e) {     
                 bEquipeActionPerformed(e);
            }
        }; 
        bSave.getActionMap().put("performEquipe", performEquipe);
        bSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyEquipe, "performEquipe");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        bNovo = new javax.swing.JButton();
        bAbrir = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bCopiar = new javax.swing.JButton();
        bColar = new javax.swing.JButton();
        bRecortar = new javax.swing.JButton();
        bCompilar = new javax.swing.JButton();
        bEquipe = new javax.swing.JButton();
        bGerar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        barraStatus = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");
        setMaximumSize(new java.awt.Dimension(920, 620));
        setMinimumSize(new java.awt.Dimension(920, 620));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        bNovo.setBackground(new java.awt.Color(255, 255, 255));
        bNovo.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Novo.jpg"))); // NOI18N
        bNovo.setText("Novo[ctrl-n]");
        bNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bNovo.setMaximumSize(new java.awt.Dimension(50, 50));
        bNovo.setMinimumSize(new java.awt.Dimension(50, 50));
        bNovo.setPreferredSize(new java.awt.Dimension(50, 50));
        bNovo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Novo.jpg"))); // NOI18N
        bNovo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });
        bNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bNovoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bNovoKeyTyped(evt);
            }
        });

        bAbrir.setBackground(new java.awt.Color(255, 255, 255));
        bAbrir.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Abrir.jpg"))); // NOI18N
        bAbrir.setText("Abrir[ctrl-a]");
        bAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAbrir.setMaximumSize(new java.awt.Dimension(100, 42));
        bAbrir.setMinimumSize(new java.awt.Dimension(100, 42));
        bAbrir.setPreferredSize(new java.awt.Dimension(100, 42));
        bAbrir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAbrirActionPerformed(evt);
            }
        });

        bSave.setBackground(new java.awt.Color(255, 255, 255));
        bSave.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Salvar.jpg"))); // NOI18N
        bSave.setText("Salvar[ctr-sl]");
        bSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSave.setMaximumSize(new java.awt.Dimension(100, 42));
        bSave.setMinimumSize(new java.awt.Dimension(100, 42));
        bSave.setPreferredSize(new java.awt.Dimension(100, 42));
        bSave.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bCopiar.setBackground(new java.awt.Color(255, 255, 255));
        bCopiar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Copiar.jpg"))); // NOI18N
        bCopiar.setText("Copiar[ctrl-c]");
        bCopiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCopiar.setMaximumSize(new java.awt.Dimension(100, 42));
        bCopiar.setMinimumSize(new java.awt.Dimension(100, 42));
        bCopiar.setPreferredSize(new java.awt.Dimension(100, 42));
        bCopiar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bCopiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCopiarActionPerformed(evt);
            }
        });

        bColar.setBackground(new java.awt.Color(255, 255, 255));
        bColar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bColar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Colar.jpg"))); // NOI18N
        bColar.setText("Colar[ctrl-v]");
        bColar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bColar.setMaximumSize(new java.awt.Dimension(100, 42));
        bColar.setMinimumSize(new java.awt.Dimension(100, 42));
        bColar.setPreferredSize(new java.awt.Dimension(100, 42));
        bColar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bColar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bColar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bColarActionPerformed(evt);
            }
        });

        bRecortar.setBackground(new java.awt.Color(255, 255, 255));
        bRecortar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bRecortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Recortar.jpg"))); // NOI18N
        bRecortar.setText("Recortar[ctrl-x]");
        bRecortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRecortar.setMaximumSize(new java.awt.Dimension(100, 42));
        bRecortar.setMinimumSize(new java.awt.Dimension(100, 42));
        bRecortar.setPreferredSize(new java.awt.Dimension(100, 42));
        bRecortar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bRecortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bRecortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRecortarActionPerformed(evt);
            }
        });

        bCompilar.setBackground(new java.awt.Color(255, 255, 255));
        bCompilar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Compilar.jpg"))); // NOI18N
        bCompilar.setText("Compilar[F8]");
        bCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCompilar.setMaximumSize(new java.awt.Dimension(100, 42));
        bCompilar.setMinimumSize(new java.awt.Dimension(100, 42));
        bCompilar.setPreferredSize(new java.awt.Dimension(100, 42));
        bCompilar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCompilar.addActionListener(new Compilar(this));

        bEquipe.setBackground(new java.awt.Color(255, 255, 255));
        bEquipe.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bEquipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Equipe.jpg"))); // NOI18N
        bEquipe.setText("Equipe[F1]");
        bEquipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bEquipe.setMaximumSize(new java.awt.Dimension(100, 42));
        bEquipe.setMinimumSize(new java.awt.Dimension(100, 42));
        bEquipe.setPreferredSize(new java.awt.Dimension(100, 42));
        bEquipe.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bEquipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEquipeActionPerformed(evt);
            }
        });
        bEquipe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bEquipeKeyPressed(evt);
            }
        });

        bGerar.setBackground(new java.awt.Color(255, 255, 255));
        bGerar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Gerar.jpg"))); // NOI18N
        bGerar.setText("Gerar[F9]");
        bGerar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bGerar.setMaximumSize(new java.awt.Dimension(100, 42));
        bGerar.setMinimumSize(new java.awt.Dimension(100, 42));
        bGerar.setPreferredSize(new java.awt.Dimension(100, 42));
        bGerar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bGerar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGerarActionPerformed(evt);
            }
        });

        console.setEditable(false);
        console.setColumns(20);
        console.setRows(5);
        console.setTabSize(5);
        console.setAutoscrolls(false);
        console.setMinimumSize(new java.awt.Dimension(750, 110));
        jScrollPane2.setViewportView(console);

        editor.setColumns(20);
        editor.setRows(5);
        editor.setTabSize(5);
        editor.setAutoscrolls(false);
        editor.setMaximumSize(new java.awt.Dimension(750, 450));
        editor.setMinimumSize(new java.awt.Dimension(750, 450));
        editor.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                editorCaretUpdate(evt);
            }
        });
        editor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editorKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(editor);
        editor.getAccessibleContext().setAccessibleParent(jScrollPane2);

        barraStatus.setPreferredSize(new java.awt.Dimension(15, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bAbrir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCopiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bColar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bRecortar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bCompilar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bGerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bColar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRecortar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bAbrir, bColar, bCompilar, bCopiar, bEquipe, bGerar, bNovo, bRecortar, bSave});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
       file = null;
       editor.setText("");
       console.setText("");
       barraStatus.setText("Não modificado");
    }//GEN-LAST:event_bNovoActionPerformed

    private void bNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bNovoKeyPressed
    }//GEN-LAST:event_bNovoKeyPressed

    private void bEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEquipeActionPerformed
        console.setText("Diogo Lehner, Hélinton Pereira Steffens.");
    }//GEN-LAST:event_bEquipeActionPerformed

    private void bGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGerarActionPerformed
        console.setText("Funcionalidade Não implementada.");
    }//GEN-LAST:event_bGerarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void bAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbrirActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if( returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            try {
                editor.setText(RecuperarSalvarArquivo.recuperarArquivo(Paths.get(file.getAbsolutePath())));
                console.setText("");
                barraStatus.setText(file.getAbsolutePath() + " >>>Não modificado");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo: " + e.toString());
            }
        }
    }//GEN-LAST:event_bAbrirActionPerformed

    private void bColarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bColarActionPerformed
        if (textoCopyCutPaste != null) {
            String aux = editor.getText().substring(0, editor.getSelectionStart()) + textoCopyCutPaste + editor.getText().subSequence(editor.getSelectionEnd(), editor.getText().length());
            editor.setText(aux);
            
            if (file != null) {
                barraStatus.setText(file.getAbsolutePath() + " >>>Modificado");
            }else{
                barraStatus.setText("Modificado");
            }
        }
    }//GEN-LAST:event_bColarActionPerformed

    private void bCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCopiarActionPerformed
        textoCopyCutPaste = editor.getSelectedText();
    }//GEN-LAST:event_bCopiarActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        try {
            if (file == null) {
                javax.swing.JFileChooser
                arquivo = new javax.swing.JFileChooser();
                arquivo.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
                int resultadoArq = arquivo.showSaveDialog(null);
                if( resultadoArq == javax.swing.JFileChooser.CANCEL_OPTION){
                    return;
                }    
                file = arquivo.getSelectedFile();
                if(file == null || file.getName().equals("")){
                    javax.swing.JOptionPane.showMessageDialog( null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", javax.swing.JOptionPane.ERROR_MESSAGE);
                }else{
                    try{
                        RecuperarSalvarArquivo.salvar(editor.getText(), Paths.get(file.getAbsolutePath()));
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e.toString());
                    }
                } 
            }else{
                RecuperarSalvarArquivo.salvar(editor.getText(), Paths.get(file.getAbsolutePath()));
            }
            
            //satus
            console.setText("");
            barraStatus.setText(file.getAbsolutePath() + " >>>Não modificado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e.toString());
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void editorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editorCaretUpdate
        
    }//GEN-LAST:event_editorCaretUpdate

    private void editorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editorKeyPressed
       if (file != null) {
            barraStatus.setText(file.getAbsolutePath() + " >>>Modificado");
        }else{
            barraStatus.setText("Modificado");
        }
    }//GEN-LAST:event_editorKeyPressed

    private void bRecortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRecortarActionPerformed
        textoCopyCutPaste = editor.getSelectedText();
        String aux = editor.getText().substring(0, editor.getSelectionStart()) + editor.getText().substring(editor.getSelectionEnd(), editor.getText().length());
        editor.setText(aux);
        
    }//GEN-LAST:event_bRecortarActionPerformed

    private void bNovoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bNovoKeyTyped
        
    }//GEN-LAST:event_bNovoKeyTyped

    private void bEquipeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bEquipeKeyPressed
    }//GEN-LAST:event_bEquipeKeyPressed
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbrir;
    private javax.swing.JButton bColar;
    private javax.swing.JButton bCompilar;
    private javax.swing.JButton bCopiar;
    private javax.swing.JButton bEquipe;
    private javax.swing.JButton bGerar;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bRecortar;
    private javax.swing.JButton bSave;
    private javax.swing.JLabel barraStatus;
    private javax.swing.JTextArea console;
    private javax.swing.JTextArea editor;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;

    public javax.swing.JTextArea getConsole() {
		return console;
	}

	public void setConsole(javax.swing.JTextArea console) {
		this.console = console;
	}

	public javax.swing.JTextArea getEditor() {
		return editor;
	}

	public void setEditor(javax.swing.JTextArea editor) {
		this.editor = editor;
	}
    
    

}
