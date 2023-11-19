/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Graficos.TableroGrafico;
import Presentacion.IPresentacionJuego;
import dominio_domino.Ficha;
import dominio_domino.FichaJugador;
import dominio_domino.FichaPozo;
import dominio_domino.FichaTablero;
import dominio_domino.Jugador;
import dominio_domino.Pozo;
import dominio_dominodto.FichaDTO;
import dominio_dominodto.FichaTableroDTO;
import dominio_dominodto.JugadorDTO;
import dominio_dominodto.PartidaDTO;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class VistaJuego extends javax.swing.JFrame {

    private IPresentacionJuego presentador;

    private TableroGrafico tablero;
    private boolean respuesta;
    private boolean partidaIniciada = false;

    /**
     * Creates new form VistaJuego
     */
    public VistaJuego(IPresentacionJuego presentador) {

        this.presentador = presentador;
        tablero = new TableroGrafico(this);
        initComponents();
        btnRobar.setVisible(false);
        Votacion.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        pantallaespera = new javax.swing.JPanel();
        Votacion = new javax.swing.JPanel();
        BtnNo = new javax.swing.JButton();
        btnSi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRobar = new javax.swing.JButton();
        Jugador3 = new javax.swing.JPanel();
        lblJugador3 = new javax.swing.JLabel();
        lblAvatar3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Jugador2 = new javax.swing.JPanel();
        lblJugador2 = new javax.swing.JLabel();
        lblAvatar2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Jugador4 = new javax.swing.JPanel();
        lblJugador4 = new javax.swing.JLabel();
        lblAvatar4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        Jugador1 = new javax.swing.JPanel();
        lblJugador1 = new javax.swing.JLabel();
        lblAvatar1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnIniciarVotacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 0));
        setMinimumSize(new java.awt.Dimension(1300, 600));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        pantallaespera.setBackground(new java.awt.Color(0, 153, 0));
        pantallaespera.setForeground(new java.awt.Color(0, 153, 0));

        BtnNo.setText("No");
        BtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNoActionPerformed(evt);
            }
        });

        btnSi.setText("Si");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("¿Quieres iniciar la partida?");

        javax.swing.GroupLayout VotacionLayout = new javax.swing.GroupLayout(Votacion);
        Votacion.setLayout(VotacionLayout);
        VotacionLayout.setHorizontalGroup(
            VotacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VotacionLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(VotacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(BtnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
            .addGroup(VotacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VotacionLayout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(276, Short.MAX_VALUE)))
        );
        VotacionLayout.setVerticalGroup(
            VotacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VotacionLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(BtnNo)
                .addGap(57, 57, 57))
            .addGroup(VotacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VotacionLayout.createSequentialGroup()
                    .addContainerGap(149, Short.MAX_VALUE)
                    .addComponent(btnSi)
                    .addGap(58, 58, 58)))
        );

        btnRobar.setText("Robar Ficha");
        btnRobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRobarActionPerformed(evt);
            }
        });

        Jugador3.setBackground(new java.awt.Color(204, 204, 204));
        Jugador3.setPreferredSize(new java.awt.Dimension(500, 130));
        Jugador3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJugador3.setText("Jugador:");
        Jugador3.add(lblJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 44, -1, -1));
        Jugador3.add(lblAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Jugador3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 0, 50, 130));

        Jugador2.setBackground(new java.awt.Color(204, 204, 204));
        Jugador2.setPreferredSize(new java.awt.Dimension(500, 130));
        Jugador2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJugador2.setText("Jugador:");
        Jugador2.add(lblJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 44, -1, -1));
        Jugador2.add(lblAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Jugador2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 50, 130));

        Jugador4.setBackground(new java.awt.Color(204, 204, 204));
        Jugador4.setPreferredSize(new java.awt.Dimension(500, 130));
        Jugador4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJugador4.setText("Jugador:");
        Jugador4.add(lblJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 44, -1, -1));
        Jugador4.add(lblAvatar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Jugador4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 50, 130));

        Jugador1.setBackground(new java.awt.Color(204, 204, 204));
        Jugador1.setPreferredSize(new java.awt.Dimension(500, 130));
        Jugador1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJugador1.setText("Jugador:");
        Jugador1.add(lblJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 44, -1, -1));
        Jugador1.add(lblAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Jugador1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 0, 50, 130));

        btnIniciarVotacion.setText("Iniciar Votacion");
        btnIniciarVotacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarVotacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pantallaesperaLayout = new javax.swing.GroupLayout(pantallaespera);
        pantallaespera.setLayout(pantallaesperaLayout);
        pantallaesperaLayout.setHorizontalGroup(
            pantallaesperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaesperaLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(pantallaesperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pantallaesperaLayout.createSequentialGroup()
                        .addComponent(Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(btnIniciarVotacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pantallaesperaLayout.createSequentialGroup()
                        .addGroup(pantallaesperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pantallaesperaLayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(Votacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addComponent(btnRobar))
                    .addComponent(Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pantallaesperaLayout.setVerticalGroup(
            pantallaesperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaesperaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pantallaesperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pantallaesperaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnIniciarVotacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(pantallaesperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pantallaesperaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pantallaesperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pantallaesperaLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(Jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pantallaesperaLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(Votacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRobar))
                .addGap(10, 10, 10)
                .addComponent(Jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(812, 812, 812)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pantallaespera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(622, 622, 622)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pantallaespera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        arrastrarFicha(evt);
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        realizarMovimiento(evt);
    }//GEN-LAST:event_formMouseReleased

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        agarrarFicha(evt);
    }//GEN-LAST:event_formMousePressed

    private void btnRobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRobarActionPerformed
        robarFicha();
    }//GEN-LAST:event_btnRobarActionPerformed

    private void btnIniciarVotacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarVotacionActionPerformed
        inicioVotacion();
    }//GEN-LAST:event_btnIniciarVotacionActionPerformed

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        respuesta = true;
        respuestaVotacion();

    }//GEN-LAST:event_btnSiActionPerformed

    private void BtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNoActionPerformed
        respuesta = false;
        respuestaVotacion();

    }//GEN-LAST:event_BtnNoActionPerformed
    public void limpiarInformacion() {
        // Limpia los textos de los JLabels
        lblJugador1.setText("");
        lblJugador2.setText("");
        lblJugador3.setText("");
        lblJugador4.setText("");

        // Limpia los iconos de los JLabels
        lblAvatar1.setIcon(null);
        lblAvatar2.setIcon(null);
        lblAvatar3.setIcon(null);
        lblAvatar4.setIcon(null);
    }

    public void mostrarJugadores() {
        List<JugadorDTO> list = presentador.listaJugadores();
        limpiarInformacion();
        if (!partidaIniciada) {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    lblJugador1.setText(list.get(0).getNombre());
                    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(list.get(0).getAvatar()));
                    ImageIcon iconoRedimensionado = new ImageIcon(iconoOriginal.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH));
                    lblAvatar1.setIcon(iconoRedimensionado);
                }
                if (i == 1) {
                    lblJugador2.setText(list.get(1).getNombre());
                    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(list.get(1).getAvatar()));
                    ImageIcon iconoRedimensionado = new ImageIcon(iconoOriginal.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH));
                    lblAvatar2.setIcon(iconoRedimensionado);
                }
                if (i == 2) {
                    lblJugador3.setText(list.get(2).getNombre());
                    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(list.get(2).getAvatar()));
                    ImageIcon iconoRedimensionado = new ImageIcon(iconoOriginal.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH));
                    lblAvatar3.setIcon(iconoRedimensionado);
                }
                if (i == 3) {
                    lblJugador4.setText(list.get(3).getNombre());
                    ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(list.get(3).getAvatar()));
                    ImageIcon iconoRedimensionado = new ImageIcon(iconoOriginal.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH));
                    lblAvatar4.setIcon(iconoRedimensionado);
                }
            }
        }
       
        this.setPartidaTablero();
//        tablero.setPartida(presentador.getPartida());
        tablero.repaint();
    }
    public void setPartidaTablero(){
        tablero.setPartida(presentador.getPartida());
        tablero.repintarFichasJugador();
    }

    public void pintarFichas() {
        tablero.repintarFichasJugador();
    }

    public void robarFicha() {
        
        presentador.robarFicha();
    }

    public int validaHitbox(MouseEvent e) {
        return tablero.validaHitbox(e);
    }

    public void mostrarMensajeError(String error) {
        JOptionPane.showMessageDialog(rootPane, error);
    }

    public void agarrarFicha(MouseEvent evt) {
        
        Insets insets = this.getInsets();
        int adjustedX = evt.getX() - insets.left;
        int adjustedY = evt.getY() - insets.top;
        tablero.moverFicha(new MouseEvent(evt.getComponent(), evt.getID(), evt.getWhen(), evt.getModifiersEx(), adjustedX, adjustedY, evt.getClickCount(), evt.isPopupTrigger()));

    }

    public void arrastrarFicha(MouseEvent evt) {
        
        Insets insets = this.getInsets();
        int adjustedX = evt.getX() - insets.left;
        int adjustedY = evt.getY() - insets.top;
        tablero.arrastrarFicha(new MouseEvent(evt.getComponent(), evt.getID(), evt.getWhen(), evt.getModifiersEx(), adjustedX, adjustedY, evt.getClickCount(), evt.isPopupTrigger()));

    }

    public void realizarMovimiento(MouseEvent evt) {
        
        Insets insets = this.getInsets();
        int adjustedX = evt.getX() - insets.left;
        int adjustedY = evt.getY() - insets.top;

        int valida = validaHitbox(new MouseEvent(evt.getComponent(), evt.getID(), evt.getWhen(), evt.getModifiersEx(), adjustedX, adjustedY, evt.getClickCount(), evt.isPopupTrigger()));
        if (valida == 0) {

            return;
        }
        FichaDTO ficha = tablero.obtenerFichaSeleccionada();
        FichaTableroDTO f = new FichaTableroDTO(ficha.getImagen(), ficha.getPuntoAbajo(), ficha.getPuntoArriba());
       
        presentador.realizaMovimiento(f, valida);
//        boolean validaFicha = false;
//
//        switch (valida) {
//            case 1:
//                validaFicha = presentador.realizaMovimiento(f, valida);
//                break;
//            case 2:
//                validaFicha = presentador.realizaMovimiento(f, valida);
//                break;
//            case 3:
//                validaFicha = presentador.realizaMovimiento(f, valida);
//                break;
//        }
//        if (!validaFicha) {
//            tablero.resetearFichaSeleccionada();
//        }
//        if (validaFicha) {
//            switch (valida) {
//                case 1:
//                    tablero.colocarInicial(f);
//                    break;
//                case 2:
//                    tablero.colocarTrenDerecha(f);
//                    break;
//                case 3:
//                    tablero.colocarTrenIzquierda(f);
//                    break;
//            }
////            presentador.eliminarFichaJugador(ficha);
//        }
    }
    public void resetearFicha(){
        tablero.resetearFichaSeleccionada();
    }
    public void colocarFicha(FichaTableroDTO f,int zona){
        System.out.println("Se coloco ");
        switch (zona) {
                case 1:
                    System.out.println("inicial");
                    tablero.colocarInicial(f);
                    break;
                case 2:
                     System.out.println("derecha");
                    tablero.colocarTrenDerecha(f);
                    break;
                case 3:
                     System.out.println("izquierda");
                    tablero.colocarTrenIzquierda(f);
                    break;
            }
    }
    

    public void iniciarJuego() {
        Jugador1.setVisible(false);
        Jugador2.setVisible(false);
        Jugador3.setVisible(false);
        Jugador4.setVisible(false);

        add(tablero);
//        presentador.iniciarPartida();
        this.partidaIniciada=true;
        this.setContentPane(tablero);
        tablero.add(btnRobar);
        btnRobar.setVisible(true);
//        tablero.agregarFichasIniciales();
    }

    public void votacion() {
        btnIniciarVotacion.setVisible(false);
        Jugador1.setVisible(false);
        Jugador2.setVisible(false);
        Jugador3.setVisible(false);
        Jugador4.setVisible(false);
        Votacion.setVisible(true);

    }

    public void votacionNoaceptada() {
        Votacion.setVisible(false);
        btnIniciarVotacion.setVisible(true);
        Jugador1.setVisible(true);
        Jugador2.setVisible(true);
        Jugador3.setVisible(true);
        Jugador4.setVisible(true);
        btnSi.setEnabled(true);
        BtnNo.setEnabled(true);
    }

    public void respuestaVotacion() {
        presentador.respuestaVotacion(respuesta);
        BtnNo.setEnabled(false);
        btnSi.setEnabled(false);
    }

    public void mostrarMensaje() {
        JOptionPane.showMessageDialog(this, "Faltas jugadores");
    }

    public void inicioVotacion() {

        presentador.iniciarVotacion();
    }

    public boolean isTurno() {
        return presentador.isTurno();
    }

    public void asignarJugadorJugando(JugadorDTO jugador) {
        tablero.setJugador(jugador);
        this.pintarFichas();
        
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNo;
    private javax.swing.JPanel Jugador1;
    private javax.swing.JPanel Jugador2;
    private javax.swing.JPanel Jugador3;
    private javax.swing.JPanel Jugador4;
    private javax.swing.JPanel Votacion;
    private javax.swing.JButton btnIniciarVotacion;
    private javax.swing.JButton btnRobar;
    private javax.swing.JButton btnSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblAvatar1;
    private javax.swing.JLabel lblAvatar2;
    private javax.swing.JLabel lblAvatar3;
    private javax.swing.JLabel lblAvatar4;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblJugador4;
    private javax.swing.JPanel pantallaespera;
    // End of variables declaration//GEN-END:variables

}
