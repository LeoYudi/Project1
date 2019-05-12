package main;

import java.io.IOException;
import java.util.ArrayList;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("FORMATO DA BASE QUE DEVE SERGUIR O ARQUIVO TEXTO\n\n<sinalizador>\t\t\t// 0 - grafo, 1 - dígrafo\n<numero_de_grafos>\n<vertice1> <vertice2> <valor1>\t// definição das arestas\n<vertice3> <vertice4> <valor2>\n...\n\n\nINFORMAÇÕES\n\t- Para grafos não-ponderados, colocar '0' no valor.\n\t- Caso um campo preenchivel seja deixado em branco, o problema será abortado.\n\t- O limite para o número de arestas é 100\n\n\nFUNÇÕES\n\t- Gerar grafos: gera os grafos com as arestas definidas no arquivo texto.\n\t- Exibir: exibe o grafo da forma escolhida (matriz ou lista).\n\t- Representações:\n\t\t- Matriz Adj: quando selecionado todas as outras funcionalidades irão utilizar uma matriz de adjacência para solucionar os problemas.\n\t\t- Lista Adj: quando selecionado todas as outras funcionalidades irão utilizar uma lista de adjacência para solucionar os problemas.\n\t- Buscas:\n\t\t- Profundidade: reliza uma busca em profundidade no grafo e irá imprimir o tempo de chegada e de saída de cada vértice.\n\t\t- Largura: realiza uma busca em largura no grafo e irá imprimir a distância de cada vértice da raiz escolhida.\n\t- Verificações:\n\t\t- Caminho: verifica se existe um caminho entre dois vértices escolhidos caso exista.\n\t\t- Conexo: verifica se o grafo é conexo, se não imprimi as subárvores existentes.\n\t- Algoritmos:");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPane2Layout = new javax.swing.GroupLayout(jPane2);
        jPane2.setLayout(jPane2Layout);
        jPane2Layout.setHorizontalGroup(
            jPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
        );
        jPane2Layout.setVerticalGroup(
            jPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
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
    }//GEN-LAST:event_formWindowGainedFocus

    private void jBgerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgerarActionPerformed
        /* Le o arquivo texto e cria os grafos em memoria */
        String caminho = jTcaminho.getText();
        int aux;
        try {
            aux = Funcionalidade.criarGrafos(caminho);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "O caminho para o arquivo texto não existe!");
            return;
        }
        for(int i=0; i<grafos.length; i++)
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

    private void jTcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTcaminhoActionPerformed
        // Caminho dos grafos
    }//GEN-LAST:event_jTcaminhoActionPerformed
    
    private void jTBlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBlistaActionPerformed
        /* Seleciona opcao de armazenamento em lista de adjacencia */
        jTBlista.setSelected(true);
        jTBmatriz.setSelected(false);
    }//GEN-LAST:event_jTBlistaActionPerformed
    
    private void jTBmatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBmatrizActionPerformed
        /* Seleciona opcao de armazenamento em matriz de adjacencia */
        jTBmatriz.setSelected(true);
        jTBlista.setSelected(false);
    }//GEN-LAST:event_jTBmatrizActionPerformed
    
    private void jBexibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexibirActionPerformed
        /* Imprime os grafos */
        System.out.println("\n\n\n\n\n\n\n\n\n");
        if (jTBmatriz.isSelected())
            Util.imprMatrizAdj(Funcionalidade.matriz);
        else
            Util.imprListaAdj(Funcionalidade.lista);
    }//GEN-LAST:event_jBexibirActionPerformed
    
    private void jBlargActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlargActionPerformed
        /* Realiza uma busca em largura */
        int ini;
        if((ini = Util.grafoInicial()) == -1)
            return;
        System.out.println("\n\n\n\n\n\n\n\n\n");
        if (jTBmatriz.isSelected()){
            System.out.println("Busca em largura utilizando Matriz de Adjacencia:\n");
            grafos = Funcionalidade.buscaLarguraM(ini);
        }
        else{
            System.out.println("Busca em largura utilizando Lista de Adjacencia:\n");
            grafos = Funcionalidade.buscaLarguraL(ini);
        }
        Util.imprLargura(grafos, ini);
    }//GEN-LAST:event_jBlargActionPerformed
    
    private void jBprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprofActionPerformed
        /* Realiza uma busca em profundidade */
        int ini;
        if((ini = Util.grafoInicial()) == -1)
            return;
        System.out.println("\n\n\n\n\n\n\n\n\n");
        if (jTBmatriz.isSelected()){
            System.out.println("Busca em profundidade utilizando Matriz de Adjacencia:\n");
            grafos = Funcionalidade.buscaProfundidadeM(ini);
        }
        else{
            System.out.println("Busca em profundidade utilizando Lista de Adjacencia:\n");
            grafos = Funcionalidade.buscaProfundidadeL(ini);
        }
        Util.imprProfundidade(grafos, ini);
    }//GEN-LAST:event_jBprofActionPerformed

    private void jBconexActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBconexActionPerformed
        /* Verifica conexidade de um grafo */
        System.out.println("\n\n\n\n\n\n\n\n\n");
        if (jTBmatriz.isSelected()) {
            System.out.println("Verificar conexidade utilizando Matriz de Adjacencia:\n");
            grafos = Funcionalidade.buscaProfundidadeM(0);
        } else {
            System.out.println("Verificar conexidade utilizando Lista de Adjacencia:\n");
            grafos = Funcionalidade.buscaProfundidadeL(0);
        }
        int tempo, tempoant = 1;
        ArrayList<Integer> desconexos = null;
        if ((desconexos = Funcionalidade.verificarConexo()) == null)
            System.out.println("     O grafo eh conexo!\n");
        else {
            System.out.println("     O grafo eh desconexo! Existem " + desconexos.size() + " subarvores:\n");
            // Montando arvores
            for (int i = 0; i < desconexos.size(); i++) {
                tempo = grafos[desconexos.get(i)].getTempoFim(); // Tempo de saida da raiz, para encontrar os
                                                                 // componentes da mesma
                System.out.printf(
                        "        Subarvore de raiz " + desconexos.get(i) + " : \n        " + desconexos.get(i) + "  ");
                for (int j = 0; j < Interface.grafos.length; j++) {
                    if ((grafos[j].getTempoFim() < tempo) && (grafos[j].getTempoFim() > tempoant))
                        System.out.printf(grafos[j].getChave() + "  ");
                }
                tempoant = tempo;
                System.out.println("\n");
            }
        }
    }// GEN-LAST:event_jBconexActionPerformed

    private void jBcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcamActionPerformed
        /* Verifica existencia de caminho entre 2 vertices */
        int ini, fim;
        try {
            do
            ini = Integer.valueOf(JOptionPane.showInputDialog("Escolha o grafo inicial entre 0 e " + 
                    Funcionalidade.matriz.length + ":"));
                    while (!Util.isValid(ini, -1));
        } catch (NumberFormatException ex) {
            return;
        }
        try {
            do
                fim = Integer.valueOf(JOptionPane.showInputDialog("Escolha o grafo final entre 0 e " + (Funcionalidade.matriz.length-1)
                    + ", com excessao do grafo inicial " + ini + ":"));
                    while (!Util.isValid(fim, ini));
        } catch (NumberFormatException ex) {
            return;
        }       
        String opcoes[] = {"Profundidade", "Largura" };
        int aux = JOptionPane.showOptionDialog(null, "Deseja procurar o caminho com qual tipo de busca?\n\n",
        "Tipo de busca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
        
        System.out.println("\n\n\n\n\n\n\n\n\n");
        switch (aux) {
            case 0:
            if (jTBmatriz.isSelected()){
                System.out.println("Verificar caminho entre "+ini+" e "+fim+" utilizando Busca em Profundidade e Matriz de Adjacencia:\n");
                Funcionalidade.verifCaminhoProfundidadeM(ini, fim);
            }
            else{
                System.out.println("Verificar caminho entre "+ini+" e "+fim+" utilizando Busca em Profundidade e Lista de Adjacencia:\n");
                Funcionalidade.verifCaminhoProfundidadeL(ini, fim);
            }
            break;

            case 1:
            if (jTBmatriz.isSelected()){
                System.out.println("Verificar caminho entre "+ini+" e "+fim+" utilizando Busca em Largura e Matriz de Adjacencia:\n");
                Funcionalidade.verifCaminhoLarguraM(ini, fim);
            }
            else{
                System.out.println("Verificar caminho entre "+ini+" e "+fim+" utilizando Busca em Largura e Lista de Adjacencia:\n");
                Funcionalidade.verifCaminhoLarguraL(ini, fim);
            }
            break;
        }
    }//GEN-LAST:event_jBcamActionPerformed

    private void jBprimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBprimActionPerformed
        // PRIM
        int ini;
        if((ini = Util.grafoInicial()) == -1)
            return;
        System.out.println("\n\n\n\n\n\n\n\n\n");
        if (jTBmatriz.isSelected())
            Funcionalidade.PrimM(ini);
        else
            Funcionalidade.PrimL(ini);
    }//GEN-LAST:event_jBprimActionPerformed

    private void jBkrusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBkrusActionPerformed
        // KRUSKAL
        System.out.println("\n\n\n\n\n\n\n\n\n");
        if (jTBmatriz.isSelected())
            Funcionalidade.KruskalM();
        else
            Funcionalidade.KruskalL();
    }//GEN-LAST:event_jBkrusActionPerformed
    
    private void jBdijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdijActionPerformed
        // DJKISTRA
        int ini = Util.grafoInicial();
        System.out.println("\n\n\n\n\n\n\n\n\n");
        if(jTBmatriz.isSelected()) {
            grafos = Funcionalidade.dijkstraM(ini);
            Util.imprCaminhoDijkstraM(grafos, ini);
        }
        else {
            grafos = Funcionalidade.dijkstraL(ini);
            Util.imprCaminhoDijkstraL(grafos, ini);
        }
    }//GEN-LAST:event_jBdijActionPerformed

    private void jBellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBellActionPerformed
        // BELLMAN
        int ini = Util.grafoInicial();
        System.out.println("\n\n\n\n\n\n\n\n\n");        
        boolean cicloNeg = true;
        if(jTBmatriz.isSelected()) {
            grafos = Funcionalidade.bellmanFordM(ini, cicloNeg);
            if(cicloNeg == false) 
                System.out.println("O grafo possui ciclo de peso negativo");
            else 
                Util.imprCaminhoBellmanM(grafos, ini);
        }
        else {
            grafos = Funcionalidade.bellmanFordL(ini, cicloNeg);
            if(cicloNeg == false) 
                System.out.println("O grafo possui ciclo de peso negativo");
            else 
                Util.imprCaminhoBellmanL(grafos, ini);
        }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jTBlista;
    private javax.swing.JToggleButton jTBmatriz;
    private javax.swing.JLabel jTalg;
    private javax.swing.JLabel jTbuscas;
    private javax.swing.JTextField jTcaminho;
    private javax.swing.JLabel jTexibir;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jTrepres;
    private javax.swing.JLabel jTtitle;
    private javax.swing.JLabel jTtxt;
    private javax.swing.JLabel jTverif;
    // End of variables declaration//GEN-END:variables
}