package ocrPack;

import ANN.NeuralNetwork;
import java.awt.*;
import java.awt.image.BufferedImage;
import JavaLib.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CancerDetection extends javax.swing.JFrame {

    MainForm parent;
    BufferedImage bIn, bProceed;
    Graphics2D gIn, gProcessed;
    int ww, hh;
    ImageIcon iiIn, iiProcessed;
    int inPixels[][];
    //int gX[][], gY[][], g[][];
    long sumAll, sumCount;
    boolean loaded;

    public CancerDetection(MainForm parent) {
        this.parent = parent;
        initComponents();
        Dimension sd = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth() / 2, sd.height / 2 - this.getHeight() / 2);




        loaded = false;

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabelIn = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabelOut = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Cancer Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 10))); // NOI18N
        new LoadForm();

        jLabelIn.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/zImagePack/Profile256x256.PNG"))); // NOI18N
        jScrollPane2.setViewportView(jLabelIn);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Detected Output"));

        jScrollPane3.setViewportView(jLabelOut);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 587, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jScrollPane3)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Load");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Process");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cancer Detection");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 187, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 628, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1048, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(55, 55, 55)
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(46, 46, 46)
                        .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jProgressBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(34, 34, 34))
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 613, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane4)))
                .add(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int minDistance(int val, int centroid) {
        return Math.abs(val - centroid);
    }

    int[][][] getHSV(BufferedImage rgbImage) {
        int hsvVal[][][] = new int[rgbImage.getHeight()][rgbImage.getWidth()][2];

        int h, s, v;
        int r, g, b, col;
        int rgbMin, rgbMax;

        //  System.out.println("Dimension:    " + rgbImage.getHeight() + "  " + rgbImage.getWidth());
        for (int yy = 0; yy < rgbImage.getHeight(); yy++) {
            for (int xx = 0; xx < rgbImage.getWidth(); xx++) {
                b = rgbImage.getRGB(xx, yy) & 0xff;
                g = (rgbImage.getRGB(xx, yy) >> 8) & 0xff;
                r = (rgbImage.getRGB(xx, yy) >> 16) & 0xff;
                //System.out.println("  " + r + "  " + g + "  " + b);
                h = s = v = 0;
                rgbMin = Math.min(Math.min(r, g), b);
                rgbMax = Math.max(Math.max(r, g), b);
                v = rgbMax;
                if (v == 0) {
                    h = s = 0;
                    hsvVal[yy][xx][0] = 0;
                    hsvVal[yy][xx][1] = 0;


                } else {
                    s = 255 * (rgbMax - rgbMin) / v;
                    if (s == 0) {
                        h = 0;
                        //thumbH.setRGB(xx, yy, 0);
                    } else {


                        if (rgbMax == r) {
                            h = 0 + 43 * (g - b) / (rgbMax - rgbMin);


                        } else if (rgbMax == g) {
                            h = 85 + 43 * (b - r) / (rgbMax - rgbMin);


                        } else if (rgbMax == b) {
                            h = 171 + 43 * (r - g) / (rgbMax - rgbMin);
                        }
                        if (h < 0) {
                            h = 255 + h;
                        }
                    }
                    hsvVal[yy][xx][0] = h;
                    hsvVal[yy][xx][1] = s;

                }
            }

        }
        return hsvVal;
    }

    public int convertToInt(double outD[]) {
        int outI[] = new int[outD.length];
        double max = 0.0;
        int index = 0;
        for (int i = 0; i < outD.length; i++) {
            if (outD[i] > max) {
                max = outD[i];
                index = i;
            }
        }
        return index;
    }

    class processTask extends TimerTask {

        processTask() {
        }

        @Override
        public void run() {

            try {

                jProgressBar1.setIndeterminate(true);
                int sumX, sumY, sum;
                int col, th;

                if (!loaded) {
                    new MessageBox(parent, "Load An Image First!").setVisible(true);
                    return;
                }

                int offSet = 10;
                NeuralNetwork nn = null;
                try {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(System.getProperty("user.dir") + "\\train.dat")));
                    nn = (NeuralNetwork) in.readObject();
                    in.close();
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }

                gProcessed.setColor(Color.LIGHT_GRAY);
                for (int y = 0; y < hh; y += 10) {
                    gProcessed.drawLine(0, y, ww, y);
                    jLabelOut.repaint();
                    Thread.sleep(30);

                }
                for (int x = 0; x < ww; x += 10) {
                    gProcessed.drawLine(x, 0, x, hh);
                    jLabelOut.repaint();
                    Thread.sleep(30);

                }
                int totalBlockX = ww / offSet;
                int totalBlockY = hh / offSet;
                int foundRedCnt = 0;

                for (int y = 0; y < hh; y += offSet) {
                    for (int x = 0; x < ww; x += offSet) {
                        BufferedImage brTemp = new BufferedImage(offSet, offSet, BufferedImage.TYPE_INT_RGB);
                        for (int xx = 0; xx < offSet; xx++) {
                            for (int yy = 0; yy < offSet; yy++) {
                                brTemp.setRGB(xx, yy, inPixels[y + yy][x + xx] & 0xffffff);
                            }
                        }

                        int[][][] HS = getHSV(brTemp);

                        double input[] = new double[100];
                        int rowIndex = 0;
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) {
                                input[rowIndex] = (HS[i][j][0] * 1.0) / 255;
                                rowIndex++;
                            }
                        }

                        nn.setInputs(input);
                        double curr_out_D[] = nn.runNetwork();
                        int output = convertToInt(curr_out_D);
                        if (output == 0) {
                            //System.out.println("Cancer");
                            gProcessed.setColor(Color.red);
                            gProcessed.drawRect(x, y, 10, 10);
                            foundRedCnt++;
                        } else {
                            //System.out.println("Non Cancer");
//                            gProcessed.setColor(Color.LIGHT_GRAY);
//                            gProcessed.drawRect(x+1, y+1, 8, 8);
                        }
                        jLabelOut.repaint();
                        Thread.sleep(2);
                    }
                }
                jLabelOut.repaint();

                double per = (foundRedCnt * 1.0 * 100) / (totalBlockX * totalBlockY);

                jTextArea1.setText("Total  Blocks: " + (totalBlockX * totalBlockY) + "\n" + "Red Count: " + foundRedCnt + "\n Percentage:" + per + "%");

                if (per < 20) {
                    jTextArea2.setText("No Cancer Detected");

                }

                if (per > 20 && per < 60) {
                    jTextArea2.setText("Medium level Cancer Detected");

                }

                if (per > 60) {
                    jTextArea2.setText("Sever level Cancer Detected");

                }

                jProgressBar1.setIndeterminate(false);


            } catch (Exception e) {
                System.out.println("Error: " + e);
            }



        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        Timer t = new Timer();
        processTask pt = new processTask();
        t.schedule(pt, 100);




//        int sumX, sumY, sum;
//        int col, th;
//
//        if (!loaded) {
//            new MessageBox(this, "Load An Image First!").setVisible(true);
//            return;
//        }
//
//        int offSet = 10;
//        NeuralNetwork nn = null;
//        try {
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(System.getProperty("user.dir") + "\\train.dat")));
//            nn = (NeuralNetwork) in.readObject();
//            in.close();
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//        }
//
//        gProcessed.setColor(Color.LIGHT_GRAY);
//        for (int y = 0; y < hh; y += 10) {
//            gProcessed.drawLine(0, y, ww, y);
//
//        }
//        for (int x = 0; x < ww; x += 10) {
//            gProcessed.drawLine(x, 0, x, hh);
//
//        }
//
//        for (int y = 0; y < hh; y += offSet) {
//            for (int x = 0; x < ww; x += offSet) {
//                BufferedImage brTemp = new BufferedImage(offSet, offSet, BufferedImage.TYPE_INT_RGB);
//                for (int xx = 0; xx < offSet; xx++) {
//                    for (int yy = 0; yy < offSet; yy++) {
//                        brTemp.setRGB(xx, yy, inPixels[y + yy][x + xx] & 0xffffff);
//                    }
//                }
//
//                int[][][] HS = getHSV(brTemp);
//
//                double input[] = new double[100];
//                int rowIndex = 0;
//                for (int i = 0; i < 10; i++) {
//                    for (int j = 0; j < 10; j++) {
//                        input[rowIndex] = (HS[i][j][0] * 1.0) / 255;
//                        rowIndex++;
//                    }
//                }
//
//                nn.setInputs(input);
//                double curr_out_D[] = nn.runNetwork();
//                int output = convertToInt(curr_out_D);
//                if (output == 0) {
//                    //System.out.println("Cancer");
//                    gProcessed.setColor(Color.red);
//                    gProcessed.drawRect(x, y, 9, 9);
//                } else {
//                    //System.out.println("Non Cancer");
//                    gProcessed.setColor(Color.LIGHT_GRAY);
//                    gProcessed.drawRect(x, y, 9, 9);
//
//                }
//            }
//        }
//        jLabelOut.repaint();
//
//
//



    }//GEN-LAST:event_jButton3ActionPerformed
    BufferedImage resizeImage(BufferedImage image, int width, int height) {
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(image, 0, 0, width, height, null);
        // g.dispose();
        //System.out.println("RESIZEING IMAGE.....");
        return resizedImage;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:        
        String fname;
        FileDialog fd = new FileDialog(this, "Select Image To Load", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() == null) {
            return;
        }

        fname = fd.getDirectory() + fd.getFile();

        try {
            bIn = ImageIO.read(new File(fname));
            ww = 500;
            hh = 500;
            bIn = resizeImage(bIn, ww, hh);
            gIn = bIn.createGraphics();
            iiIn = new ImageIcon(bIn);
            jLabelIn.setIcon(iiIn);



            bProceed = new BufferedImage(ww, hh, BufferedImage.TYPE_INT_ARGB);
            bProceed = bIn;
            gProcessed = bProceed.createGraphics();
            iiProcessed = new ImageIcon(bProceed);
            jLabelOut.setIcon(iiProcessed);
            gIn.drawImage(bIn, 0, 0, ww, hh, null);
            inPixels = new int[hh][ww];
            for (int yy = 0; yy < hh; yy++) {
                for (int xx = 0; xx < ww; xx++) {
                    inPixels[yy][xx] = bIn.getRGB(xx, yy) & 0xffffff;
                }
            }

            jLabelIn.repaint();
            loaded = true;
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        setVisible(false);
        parent.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelIn;
    private javax.swing.JLabel jLabelOut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
