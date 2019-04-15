package main;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Interface extends javax.swing.JFrame {

    public Grafo grafos[];
    
    public Interface() {
        initComponents();
        jTBmatriz.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jBkrus = new javax.swing.JButton();
        jBdij = new javax.swing.JButton();
        jBell = new javax.swing.JButton();
        jBexibir = new javax.swing.JButton();
        jTexibir = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTcaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jTtxt)
                                .addGap(30, 30, 30)
                                .addComponent(jBgerar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTrepres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTBmatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addComponent(jBprof, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTbuscas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBlarg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBcam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBconex, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTverif, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTBlista, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jBkrus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBprim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTalg, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBexibir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jTexibir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBdij, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTtitle)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTcaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTtxt)
                                    .addComponent(jBgerar))))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTbuscas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBprof)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBlarg))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTverif)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBconex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBcam))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTalg, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBprim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBkrus))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBdij)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBell)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTrepres)
                    .addComponent(jTexibir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTBmatriz)
                    .addComponent(jTBlista)
                    .addComponent(jBexibir))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void jTcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTcaminhoActionPerformed
        // Caminho dos grafos
    }//GEN-LAST:event_jTcaminhoActionPerformed

    private void jBexibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexibirActionPerformed
        if (jTBmatriz.isSelected())
            Util.imprimirMatrizAdj(Util.matriz);
        else
            Util.imprimirListaAdj(Util.lista);
    }//GEN-LAST:event_jBexibirActionPerformed
    
    private void jTBmatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBmatrizActionPerformed
        jTBmatriz.setSelected(true);
        jTBlista.setSelected(false);
    }//GEN-LAST:event_jTBmatrizActionPerformed

    private void jTBlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBlistaActionPerformed
        jTBlista.setSelected(true);
        jTBmatriz.setSelected(false);
    }//GEN-LAST:event_jTBlistaActionPerformed

    private void jBgerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgerarActionPerformed
        String caminho = jTcaminho.getText();
        int aux;
        try {
            aux = Util.criarGrafos(caminho);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "O caminho para o arquivo texto nao existe!");
            return;
        }

        for(int i=0; i<Util.matriz.length; i++)
            grafos[i] = new Grafo(i);
            
        jBexibir.setEnabled(true);
        jBprof.setEnabled(true);
        jBlarg.setEnabled(true);
        jBcam.setEnabled(true);
        jBdij.setEnabled(true);
        jBell.setEnabled(true);

        if (aux == 1) {
            JOptionPane.showMessageDialog(null, "Os grafos foram gerados com sucesso!");
            jBprim.setEnabled(true);
            jBkrus.setEnabled(true);
            jBconex.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "Os digrafos foram gerados com sucesso!");
            jBprim.setEnabled(false);
            jBkrus.setEnabled(false);
            jBconex.setEnabled(false);
        }
    }//GEN-LAST:event_jBgerarActionPerformed
    
    private void jBlargActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlargActionPerformed
        int ini = Util.grafoInicial(); 
         
        if (jTBmatriz.isSelected())
            grafos = Util.buscaLarguraM(ini);
        else
            grafos = Util.buscaLarguraL(ini);
        Util.exibirLargura(grafos, ini);
    }//GEN-LAST:event_jBlargActionPerformed

    private void jBprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprofActionPerformed
        int ini = Util.grafoInicial(); 
        
        if (jTBmatriz.isSelected())
            grafos = Util.buscaProfundidadeM(ini);
        else 
            grafos = Util.buscaProfundidadeL(ini);
        Util.exibirProfundidade(grafos, ini);
    }//GEN-LAST:event_jBprofActionPerformed

    private void jBcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcamActionPerformed
        int ini, fim;

        do
            ini = Integer.valueOf(
                    JOptionPane.showInputDialog("Escolha o grafo inicial entre 0 e " + Util.matriz.length + ":"));
        while (!Util.isValid(ini, -1));

        do
            fim = Integer.valueOf(JOptionPane.showInputDialog("Escolha o grafo final entre 0 e " + Util.matriz.length
                    + ", com excessao do grafo inicial " + ini + ":"));
        while (!Util.isValid(fim, ini));

        String opcoes[] = { "Profundidade", "Largura" };
        int aux = JOptionPane.showOptionDialog(null, "Deseja procurar o caminho com qual tipo de busca?\n\n",
                "Tipo de busca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);

        switch (aux) {
        case 0:
            if (jTBmatriz.isSelected())
                Util.caminhoUVProfundidadeM(ini, fim);
            else
                Util.caminhoUVProfundidadeL(ini, fim);
            break;

        case 1:
            if (jTBmatriz.isSelected())
                Util.caminhoUVLarguraM(ini, fim);
            else
                Util.caminhoUVLarguraL(ini, fim);
            break;
        }
    }//GEN-LAST:event_jBcamActionPerformed

    private void jBconexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBconexActionPerformed
        Util.verificarConexo(this.grafos);
    }//GEN-LAST:event_jBconexActionPerformed

    private void jBprimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprimActionPerformed
        // PRIM
    }//GEN-LAST:event_jBprimActionPerformed

    private void jBkrusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBkrusActionPerformed
        // KRUSKAL
    }//GEN-LAST:event_jBkrusActionPerformed

    private void jBdijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdijActionPerformed
        // DIJKSTRA
    }//GEN-LAST:event_jBdijActionPerformed

    private void jBellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBellActionPerformed
        // BELL
    }//GEN-LAST:event_jBellActionPerformed

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
    private javax.swing.JPanel jPanel1;
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
