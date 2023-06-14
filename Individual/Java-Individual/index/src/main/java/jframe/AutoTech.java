package jframe;

public class AutoTech extends javax.swing.JFrame {

    public AutoTech() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        proximaTela = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        proximaTela1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(724, 478));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seja bem vindo!");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        proximaTela.setBackground(new java.awt.Color(51, 255, 255));
        proximaTela.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        proximaTela.setText("Proximo");
        proximaTela.setBorder(null);
        proximaTela.setBorderPainted(false);
        proximaTela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        proximaTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaTelaActionPerformed(evt);
            }
        });
        jPanel1.add(proximaTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 120, 38));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 110, 100));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(724, 478));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Seja bem vindo!");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        proximaTela1.setBackground(new java.awt.Color(51, 255, 255));
        proximaTela1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        proximaTela1.setText("Proximo");
        proximaTela1.setBorder(null);
        proximaTela1.setBorderPainted(false);
        proximaTela1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        proximaTela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaTela1ActionPerformed(evt);
            }
        });
        jPanel2.add(proximaTela1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 120, 38));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Somos mais que uma empresa, somos uma família. ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 370, 20));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 110, 100));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Com sede de mudar o mundo, deixando-o mais rápido");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 410, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("e eficaz, através da tecnologia. Com a ambição de deixar sua máquina mais potente");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 620, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 460));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Somos mais que uma empresa, somos uma família. Com sede de mudar o mundo, deixando-o mais rápido");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 560, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proximaTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaTelaActionPerformed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        this.setVisible(false);
        telaLogin.setLocationRelativeTo(null);
    }//GEN-LAST:event_proximaTelaActionPerformed

    private void proximaTela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaTela1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proximaTela1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutoTech().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton proximaTela;
    private javax.swing.JButton proximaTela1;
    // End of variables declaration//GEN-END:variables
}
