package main;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Interface extends javax.swing.JFrame {

    public static Grafo grafos[];

    public Interface() {
        initComponents();
        jTBmatriz.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jABAS = new javax.swing.JTabbedPane();
        jPane1 = new javax.swing.JPanel();
        jBkrus = new javax.swing.JButton();
        jBdij = new javax.swing.JButton();
        jBell = new javax.swing.JButton();
        jBexibir = new javax.swing.JButton();
        jTexibir = new javax.swing.JLabel();
        jTtitle = new javax.swing.JLabel();
        jTcaminho = new javax.swing.JTextField();
        jTtxt = new javax.swing.JLabel();
        jBgerar = new javax.swing.JButton();
        jTbuscas = new javax.swing.JLabel();
        jBprof = new javax.swing.JButton();
        jBlarg = new javax.swing.JButton();
        jTrepres = new javax.swing.JLabel();
        jTBmatriz = new javax.swing.JToggleButton();
        jTBlista = new javax.swing.JToggleButton();
        jTverif = new javax.swing.JLabel();
        jBconex = new javax.swing.JButton();
        jBcam = new javax.swing.JButton();
        jTalg = new javax.swing.JLabel();
        jBprim = new javax.swing.JButton();
        jPane2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jBkrus.setText("Kruskal");
        jBkrus.setEnabled(false);
        jBkrus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBkrusActionPerformed(evt);
            }
        });

        jBdij.setText("Dijkstra");
        jBdij.setEnabled(false);
        jBdij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdijActionPerformed(evt);
            }
        });

        jBell.setText("Bellman-Ford");
        jBell.setEnabled(false);
        jBell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBellActionPerformed(evt);
            }
        });

        jBexibir.setText("Exibir");
        jBexibir.setEnabled(false);
        jBexibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexibirActionPerformed(evt);
            }
        });

        jTexibir.setText("Exibir grafos:");

        jTtitle.setText("Digite o caminho do arquivo texto onde os grafos se encontram: ");

        jTcaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTcaminhoActionPerformed(evt);
            }
        });

        jTtxt.setText(".txt");

        jBgerar.setText("Gerar grafos");
        jBgerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgerarActionPerformed(evt);
            }
        });

        jTbuscas.setText("Buscas:");

        jBprof.setText("Profundidade");
        jBprof.setEnabled(false);
        jBprof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBprofActionPerformed(evt);
            }
        });

        jBlarg.setText("Largura");
        jBlarg.setEnabled(false);
        jBlarg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlargActionPerformed(evt);
            }
        });

        jTrepres.setText("Representações:");

        jTBmatriz.setText("Matriz Adj.");
        jTBmatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBmatrizActionPerformed(evt);
            }
        });

        jTBlista.setText("Lista Adj.");
        jTBlista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBlistaActionPerformed(evt);
            }
        });

        jTverif.setText("Verificações:");

        jBconex.setText("Conexo");
        jBconex.setEnabled(false);
        jBconex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBconexActionPerformed(evt);
            }
        });

        jBcam.setText("Caminho");
        jBcam.setEnabled(false);
        jBcam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcamActionPerformed(evt);
            }
        });

        jTalg.setText("Algoritmos:");

        jBprim.setText("Prim");
        jBprim.setEnabled(false);
        jBprim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBprimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPane1Layout = new javax.swing.GroupLayout(jPane1);
        jPane1.setLayout(jPane1Layout);
        jPane1Layout.setHorizontalGroup(
            jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPane1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPane1Layout.createSequentialGroup()
                        .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPane1Layout.createSequentialGroup()
                                .addComponent(jTcaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTtxt)
                                .addGap(30, 30, 30)
                                .addComponent(jBgerar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPane1Layout.createSequentialGroup()
                        .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTrepres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTBmatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBprof, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTbuscas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBlarg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPane1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBcam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBconex, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTverif, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTBlista, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jBkrus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBprim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTalg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBexibir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPane1Layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jTexibir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBdij, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        jPane1Layout.setVerticalGroup(
            jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPane1Layout.createSequentialGroup()
                        .addComponent(jTtitle)
                        .addGap(6, 6, 6)
                        .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTcaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPane1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTtxt)
                                    .addComponent(jBgerar))))
                        .addGap(23, 23, 23)
                        .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPane1Layout.createSequentialGroup()
                                .addComponent(jTbuscas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBprof)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBlarg))
                            .addGroup(jPane1Layout.createSequentialGroup()
                                .addComponent(jTverif)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBconex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBcam))))
                    .addGroup(jPane1Layout.createSequentialGroup()
                        .addComponent(jTalg, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBprim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBkrus))
                    .addGroup(jPane1Layout.createSequentialGroup()
                        .addComponent(jBdij)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBell)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTrepres)
                    .addComponent(jTexibir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTBmatriz)
                    .addComponent(jTBlista)
                    .addComponent(jBexibir))
                .addGap(30, 30, 30))
        );

        jABAS.addTab("Main", jPane1);

        javax.swing.GroupLayout jPane2Layout = new javax.swing.GroupLayout(jPane2);
        jPane2.setLayout(jPane2Layout);
        jPane2Layout.setHorizontalGroup(
            jPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        jPane2Layout.setVerticalGroup(
            jPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        jABAS.addTab("Help", jPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jABAS)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jABAS)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void jBgerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgerarActionPerformed
        String caminho = jTcaminho.getText();
        int aux;
        try {
            aux = Funcionalidade.criarGrafos(caminho);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "O caminho para o arquivo texto nao existe!");
            return;
        }

        for(int i=0; i<Funcionalidade.matriz.length; i++)
            grafos[i] = new Grafo(i);

        jBexibir.setEnabled(true);
        jBprof.setEnabled(true);
        jBlarg.setEnabled(true);
        jBcam.setEnabled(true);
        jBdij.setEnabled(true);
        jBell.setEnabled(true);

        if (aux == 1) {
            JOptionPane.showMessageDialog(null, "Os digrafos foram gerados com sucesso!");
            jBprim.setEnabled(false);
            jBkrus.setEnabled(false);
            jBconex.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(null, "Os grafos foram gerados com sucesso!");
            jBprim.setEnabled(true);
            jBkrus.setEnabled(true);
            jBconex.setEnabled(true);
        }
    }//GEN-LAST:event_jBgerarActionPerformed

    private void jBcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcamActionPerformed
        int ini, fim;

        do
        ini = Integer.valueOf(
            JOptionPane.showInputDialog("Escolha o grafo inicial entre 0 e " + Funcionalidade.matriz.length + ":"));
        while (!Util.isValid(ini, -1));

        do
        fim = Integer.valueOf(JOptionPane.showInputDialog("Escolha o grafo final entre 0 e " + Funcionalidade.matriz.length
            + ", com excessao do grafo inicial " + ini + ":"));
    while (!Util.isValid(fim, ini));

    String opcoes[] = { "Profundidade", "Largura" };
    int aux = JOptionPane.showOptionDialog(null, "Deseja procurar o caminho com qual tipo de busca?\n\n",
        "Tipo de busca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);

        switch (aux) {
            case 0:
            if (jTBmatriz.isSelected())
                Funcionalidade.verifCaminhoProfundidadeM(ini, fim);
            else
                Funcionalidade.verifCaminhoProfundidadeL(ini, fim);
            break;

            case 1:
            if (jTBmatriz.isSelected())
                Funcionalidade.verifCaminhoLarguraM(ini, fim);
            else
                Funcionalidade.verifCaminhoLarguraL(ini, fim);
            break;
        }
    }//GEN-LAST:event_jBcamActionPerformed

    private void jTcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTcaminhoActionPerformed
        // Caminho dos grafos
    }//GEN-LAST:event_jTcaminhoActionPerformed

    private void jBconexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBconexActionPerformed
        Funcionalidade.verificarConexo();
    }//GEN-LAST:event_jBconexActionPerformed

    private void jTBlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBlistaActionPerformed
        jTBlista.setSelected(true);
        jTBmatriz.setSelected(false);
    }//GEN-LAST:event_jTBlistaActionPerformed

    private void jTBmatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBmatrizActionPerformed
        jTBmatriz.setSelected(true);
        jTBlista.setSelected(false);
    }//GEN-LAST:event_jTBmatrizActionPerformed

    private void jBexibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexibirActionPerformed
        if (jTBmatriz.isSelected())
            Util.imprimirMatrizAdj(Funcionalidade.matriz);
        else
            Util.imprimirListaAdj(Funcionalidade.lista);
    }//GEN-LAST:event_jBexibirActionPerformed

    private void jBlargActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlargActionPerformed
        int ini = Util.grafoInicial();

        if (jTBmatriz.isSelected())
            grafos = Funcionalidade.buscaLarguraM(ini);
        else
            grafos = Funcionalidade.buscaLarguraL(ini);
        
        Util.exibirLargura(grafos, ini);
    }//GEN-LAST:event_jBlargActionPerformed

    private void jBprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprofActionPerformed
        int ini = Util.grafoInicial();

        if (jTBmatriz.isSelected())
            grafos = Funcionalidade.buscaProfundidadeM(ini);
        else
            grafos = Funcionalidade.buscaProfundidadeL(ini);
        
        Util.exibirProfundidade(grafos, ini);
    }//GEN-LAST:event_jBprofActionPerformed

    private void jBkrusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBkrusActionPerformed
        for (int i=0; i<grafos.length; i++){
            System.out.println(grafos[i].getPredecessor()+"\n");
        }
    }//GEN-LAST:event_jBkrusActionPerformed
    
    private void jBprimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprimActionPerformed
        // PRIM
    }//GEN-LAST:event_jBprimActionPerformed

    private void jBellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBellActionPerformed
        // BELL
    }//GEN-LAST:event_jBellActionPerformed

    private void jBdijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdijActionPerformed
        // DIJKSTRA
    }//GEN-LAST:event_jBdijActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jABAS;
    private javax.swing.JButton jBcam;
    private javax.swing.JButton jBconex;
    private javax.swing.JButton jBdij;
    private javax.swing.JButton jBell;
    private javax.swing.JButton jBexibir;
    private javax.swing.JButton jBgerar;
    private javax.swing.JButton jBkrus;
    private javax.swing.JButton jBlarg;
    private javax.swing.JButton jBprim;
    private javax.swing.JButton jBprof;
    private javax.swing.JPanel jPane1;
    private javax.swing.JPanel jPane2;
    private javax.swing.JToggleButton jTBlista;
    private javax.swing.JToggleButton jTBmatriz;
    private javax.swing.JLabel jTalg;
    private javax.swing.JLabel jTbuscas;
    private javax.swing.JTextField jTcaminho;
    private javax.swing.JLabel jTexibir;
    private javax.swing.JLabel jTrepres;
    private javax.swing.JLabel jTtitle;
    private javax.swing.JLabel jTtxt;
    private javax.swing.JLabel jTverif;
    // End of variables declaration//GEN-END:variables
}