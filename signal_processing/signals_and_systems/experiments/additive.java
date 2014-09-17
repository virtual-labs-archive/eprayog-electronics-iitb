import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.InputStream;
import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;
import java.awt.image.MemoryImageSource;
import java.lang.Math;
import javax.sound.sampled.*;
import java.text.NumberFormat;
public class additive extends javax.swing.JApplet implements Runnable{


    int var=0; 
    int maxY=100;//declare amplitude of sine wave
    int x,i,j; //x is used as degrees in sine wave
    int lk;
    double scl;
    int clicked=0;
    double multR;
    double multL;
    double max,min;
    double lcmvalue;
    double lcm[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    double time; //time period of the sine wave
    Thread engine = null;// declare variable engine for sound
    final double cvtDegToRad = Math.PI/180; // convert degrees into radians
    int add[]={0,0,0,0,0,0,0,0,0,0,0,0,0}; // variable for adding sine waves
    double amp=100,ph=0; //set initial amplitude =100,phase =0 of sine waves
    String amplitude,phase; //convert double values amplitude,phase into string form
    static final double pi = 3.14159265358979323846;
    double f[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //initialize variable for storing frequency
    double freq=0,frequency=0; // 
    int p=0,w,m=0,s;// local variables
    double z=0; 
    double a[]={100,100,100,100,100,100,100,100,100,100,100,100}; // amplitude of different sine waves by using arrays
    static double b[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // phase of different sine waves by using arrays
    int q[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0};  // variable used in drawing individual sine waves      
    int x2;  //variable for Graph-1 x axis
    String t,scale1,scale2;
    int cl1=1,cl2=3;
    int scl1 =1;
    int scl2 = 3;
    NumberFormat nf;
    int ind;
    
    public void init() {
         double[] b = new double[10000];
         nf = NumberFormat.getInstance();
         nf.setMaximumFractionDigits(1);        
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void initComponents() {
        
        jPanel2 = new plot();
        jPanel3 = new panel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new hel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel7 = new des();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel6 = new graph1();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel8 = new graph2();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new selected();
        jPanel1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(231, 248, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(380, 250));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setBackground(new java.awt.Color(231, 248, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel5);

        jTabbedPane1.addTab("Help", jScrollPane2);

        jScrollPane3.setBackground(new java.awt.Color(231, 248, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel7);

        jTabbedPane1.addTab("Description", jScrollPane3);

        jScrollPane4.setBackground(new java.awt.Color(231, 248, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel6);

        jTabbedPane1.addTab("Scale of Graph-1", jScrollPane4);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanel8);

        jTabbedPane1.addTab("Scale of Graph-2", jScrollPane5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel4);

        jTabbedPane1.addTab("Signals Selectd", jScrollPane1);

        jPanel3.setBackground(new java.awt.Color(231, 248, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(231, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 500));

        jLabel38.setText("Select No. of Signals to be Added");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4","5","6","7","8","None" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Sa  : 240 Hz", "Re  : 254 Hz", "Ga  : 302 Hz", "Ma : 320 Hz", "Pa  : 358.5 Hz", "Da  : 380 Hz", "Ni  : 451 Hz","Saa : 480 Hz","None" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("   (Units)");

        jLabel3.setText("(Degrees)");

        jLabel37.setText("Musical Octave  :");

        jLabel39.setText("Amplitude");

        jLabel40.setText(" Phase");

        jLabel1.setText(" ");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setText("User Defined");

        jLabel5.setText("Hz");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(231, 248, 255));
        jCheckBox1.setText("Sound");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jButton1.setText("Clear Graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(633, 633, 633)
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(507, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, 0, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jCheckBox1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(409, 409, 409))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(413, 413, 413))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(jButton1))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, 0, 280, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
        );
    amplitude = Double.toString(amp);
    phase = Double.toString(ph);
    jTextField1.setText(amplitude);
    jTextField2.setText(phase);
    jComboBox1.setSelectedIndex (8);
    jComboBox2.setSelectedIndex (8);    
    }// </editor-fold>

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        p = jComboBox2.getSelectedIndex(); // store the present value of combobox in p
            if(p==0){repaint();jCheckBox1.setSelected(false);m=0;var=0;i=0;}
            else if(p==1){repaint();jCheckBox1.setSelected(false);m=0;var=0;i=1;}
            else if(p==2){repaint();jCheckBox1.setSelected(false);m=0;var=0;i=2;}
            else if(p==3){repaint();jCheckBox1.setSelected(false);m=0;var=0;i=3;}
            else if(p==4){repaint();jCheckBox1.setSelected(false);m=0;var=0;i=4;}
            else if(p==5){repaint();jCheckBox1.setSelected(false);m=0;var=0;i=5;}
            else if(p==6){repaint();jCheckBox1.setSelected(false);m=0;var=0;i=6;}
            else if(p==7){repaint();jCheckBox1.setSelected(false);m=0;var=0;i=7;}
            else{m=0;var=0;i=-1;f[m]=0;lcm[m]=0;}     //if none is selected draw nothing
            if(i>=4){scl2 = 5;}
            else if(i<4){scl2=3;}
}                                          

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        s= jComboBox1.getSelectedIndex(); //store the present number of combobox in s
           if (s == 0) {           
              if(ind==2){m=0; 
                  for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase);
                               
                               repaint();
               }jTextField3.setText(null);ind=1;

           }
                     f[m]=240;lcm[m]=1;
                     m++; var++;   repaint();
     } else if (s == 1) {  
            if(ind==2){m=0; 
                for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;add[w]=0;q[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase); 
                               jTextField3.setText(null);
                        repaint();
              }ind=1;
          }
                        f[m]=254;lcm[m]=2;
                        m++; var++;   repaint();
     }else if (s == 2) {   
            if(ind==2){m=0; 
                for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;add[w]=0;q[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase); 
                               jTextField3.setText(null);
                        repaint();
               }ind=1;
          }
                        f[m]=302;lcm[m]=3;
                        m++; var++;   repaint();
     }else if (s == 3) {   
            if(ind==2){m=0; 
                for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;add[w]=0;q[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase);
                               jTextField3.setText(null);
                        repaint();
               }ind=1;
          }
                        f[m]=320;lcm[m]=4;
                        m++;var++;    repaint();
     }else if (s == 4) {   
            if(ind==2){m=0; 
                for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;add[w]=0;q[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase);
                               jTextField3.setText(null);
                        repaint();
               }ind=1;
          }
                        f[m]=358;lcm[m]=5;
                        m++; var++;   repaint();
     }else if (s == 5) {   
            if(ind==2){m=0; 
                for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;add[w]=0;q[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase);  
                               jTextField3.setText(null);
                        repaint();
              }ind=1;
          }
                        f[m]=380;lcm[m]=6;
                        m++; var++;   repaint();
     }else if (s == 6) {  
            if(ind==2){m=0; 
                 for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;add[w]=0;q[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase); 
                               jTextField3.setText(null);
                        repaint();
               }ind=1;
          }
                        f[m]=451;lcm[m]=7;
                        m++;var++;  repaint();
     }else if (s == 7) {  
            if(ind==2){m=0; 
                 for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;add[w]=0;q[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase);   
                               jTextField3.setText(null);
                        repaint();
               }ind=1;
          }
                        f[m]=451;
                        m++;var++;  repaint();                   
     }else {f[m]=0; lcm[m]=0;m=0;var=0; repaint();}   
      
                    if(m == (i+1)){jTextField3.setText("Press Clear Graph");
                                ind=1; repaint();
                                for(w=0;w<=i;w++){
                                      f[m]=0;lcm[m]=0;        
                        } ind=2;              
                }
}                                          

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
             a[m-1]=Double.parseDouble(jTextField1.getText());  //get the amplitude of the particular wave into the array             
             repaint();
}                                           

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
             b[m-1]=Double.parseDouble(jTextField2.getText());  //get the phae of the particular wave into the array            
             repaint();
}                                           

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {                                            
            if (evt.getItemSelectable() == jCheckBox1 ) {
                     doPlay(); //if checkbox is in on state then play the sound
         }
}                                           

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == jButton1){
            m=0; var=0;
            for(w=0;w<=9;w++){f[w]=0;lcm[w]=0;a[w]=100;b[w]=0;q[w]=0;add[w]=0;}  // if button is pressed clear the whole waveforms by making all the value to zero
                           
                        for(w=0;w<=i;w++){
                                    amplitude = Double.toString(a[w]);
                                    phase =  Double.toString(b[w]);
                                    jTextField1.setText(amplitude);
                                    jTextField2.setText(phase);
                                    jTextField3.setText(null);                                    
                  }
                  scl2=3;
                  clicked = 1;
                  x=0;
                  //jCheckBox1.setSelected(false);//if sound check box is on before pressing clear button pit it to off after pressing the button                  
                  repaint();
                  

     }
}                                        

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) { 
             /*if(f[var]>f[i+1]){m=0;var=0; for(w=0;w<=i;w++){f[w]=0;lcm[w]=0;add[w]=0;q[w]=0;
                               a[w]=100;b[w]=0;
                               amplitude = Double.toString(a[w]);
                               phase =  Double.toString(b[w]);
                               jTextField1.setText(amplitude);
                               jTextField2.setText(phase); 
                               
                            }
        f[var]=Double.parseDouble(jTextField3.getText()); 
           m++;var++; 
           repaint();                                                
            }*/          
      f[var]=Double.parseDouble(jTextField3.getText()); 
           m++;var++; 
           repaint(); 
          if(m==(i+1)){m=0;var=0;jTextField3.setText("Press Clear Graph");}
    }   

    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private plot jPanel2;
    private panel jPanel3;
    private selected jPanel4;
    private hel jPanel5;
    private graph1 jPanel6;
    private des jPanel7;
    private graph2 jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    
            class plot extends JPanel
    {
        
        public void paint(Graphics g) {
            int y,oldX, oldY,e;
            double radians;
            double degrees;
            g.setColor(Color.black);
            //g.drawString("
            
            Dimension d = this.getSize(); //get the dimension of this panel
            g.setColor(Color.white);
            g.fillRect(0,0,d.width,d.height);
     
            int axis = (int)(d.height/2);
           

            oldX = 0;
            oldY = 0;
            y=0;
            x2=0;    
            
            if(clicked!=1){
            for(j=0;j<=i;j++){  x2=0; q[j]=0;add[j]=0;     
             if(a[j] > 100 && a[j]%100 != 0){scl1=(int)((a[j]/100)+1);}
             else if(a[j] > 100 && a[j]%100 == 0){scl1=(int)((a[j]/100));}
             else{scl1=1;}   
             g.setColor(Color.black);             
             if(f[0]!=0){
             g.drawString("2",369,axis+15 );g.drawLine(377,axis+7,377,axis+14);g.drawLine(379,axis+7,379,axis+14);
             g.drawLine(376,axis+7,380,axis+7);                              
             //g.drawString(Double.toString(a[j]),3,(int) (axis-(a[j]/scl1)-3));
            // g.drawString("-"+Double.toString(a[j]),3,(int) (axis+(a[j]/scl1)+12));
        }

                for (int x=0; x<=360; x++) {  
            
                         scl = (int) (f[j]/100);
                         amplitude = Double.toString(a[j]);
                         jTextField1.setText(amplitude);
                         phase = Double.toString(b[j]);
                         jTextField2.setText(phase);
                        
                         radians = (scl*(x)*cvtDegToRad);
                         add[j] = (int)(a[j]*Math.sin(radians+(cvtDegToRad*b[j])));
                         if(j==0){g.setColor(Color.red);}
                         else if(j==1){g.setColor(Color.black);}
                         else if(j==2){g.setColor(Color.magenta);}
                         else if(j==3){g.setColor(Color.blue);}
                         else if(j==4){g.setColor(Color.green);}
                         else if(j==5){g.setColor(new Color(0,255,204));}
                         else if(j==6){g.setColor(Color.cyan);}
                         else if(j==7){g.setColor(Color.orange);}
                       
                         
                             if(x==0 && b[j]!=0){
                                q[j]=  add[j];
                                g.drawLine(x2, axis-(add[j]/scl1) , x, axis-(add[j]/scl1) );
                         }
                                else{
                                g.drawLine(x2, axis-(q[j]/scl1) , x, axis-(add[j]/scl1) ); 
                                x2=x;q[j]=add[j];add[j]=0;
                         }
                      g.setColor(Color.black);g.drawLine(0,axis ,370,axis );    
           } 
                
      }
    } if(clicked == 1){                              
                                g.setColor(Color.black);g.drawLine(0,axis ,370,axis );}
     g.setColor(Color.black); g.drawLine(0,0,0,d.height);g.drawString("0",3,axis+12);
            Font font = new Font("Times New Roman",Font.BOLD,14);
            g.setFont(font);            
            g.drawString("Graph-1 : INDIVIDUAL SIGNALS",105,15);
            g.drawString("Amplitude v/s Radians",130,238);
            g.drawLine(0,axis , 370,axis  );     
            clicked=0;
    }

  
 }
    
    class panel extends JPanel
    {
        public void paint(Graphics g) {
            int y,oldX, oldY,e;
            double radians;
            double scaleY=0.5;
            double degrees;
            double freq=0;
            Dimension d = this.getSize();
            g.setColor(Color.white);
            g.fillRect(0,0,d.width,d.height);
     
            int axis = (int)(d.height/2);
            g.setColor(Color.blue);
            g.drawLine(0,axis, 370,axis );
         
            oldX = 0;
            oldY = 0;
            y=0;
            int scale;
            time=0;
            
                                
            g.setColor(Color.blue); g.drawLine(0,0,0,d.height);g.drawString("0",3,axis+12);            
            if(clicked!=1){
            for (int x=0; x<=360; x++) {  
                
                for(j=0;j<=i;j++){
             g.setColor(Color.blue);
             g.drawString("2",369,axis+15 );g.drawLine(377,axis+7,377,axis+14);g.drawLine(379,axis+7,379,axis+14);
             g.drawLine(376,axis+7,380,axis+7);                    
                    
                            g.setColor(Color.blue);
                            scl = (int) (f[j]/100);
                            
                            radians = (scl*x*cvtDegToRad);
                            add[j] = (int)(a[j]*Math.sin(radians+(cvtDegToRad*b[j])));
                            y=y+add[j];
                            freq+=((f[j]));
                            
                            //if(axis-y <  0){scl2 = 6;}
                           
                            if(x==0 && b[j]!=0){
                                    oldY=  y;
                                   
                         }                    
            }
                        frequency=freq;
                        freq=0;
                        g.drawLine(oldX,axis-(oldY/scl2), x,axis-(y/scl2));
                        oldY = y;
            
                        oldX = x;
                        y=0;
               
         //if(clicked!=1){if(x==0){jCheckBox1.setSelected(false);}if(x==360){jCheckBox1.setSelected(true);}}
       }if(clicked==1){//jCheckBox1.setSelected(false);
           x=0;clicked=0;}                   
           g.setColor(Color.blue);
            Font font = new Font("Times New Roman",Font.BOLD,14);
            g.setFont(font);
            g.drawString("Graph-2 : RESULTANT SIGNAL",105,15);  
            g.drawString("Amplitude v/s Radians",130,238);            
           
        }
   }
 }
   
    int getFreq() {
            return (int) (/*27.5*/88.5*java.lang.Math.exp(frequency*.004158883084));
    }
   
 public void doPlay() {
     if (!jCheckBox1.isSelected()) 
            return;
            final int rate = 44100;
            playSampleCount = precalcSize/2;
             
            int v;
            double phs=0;
            double amps=0;
            for(j=0;j<=i;j++){
             phs = phs+b[j];
             amps =amps+a[j];
            }
            
            if(amp <100){
            multR = amp/100;
        }
         else if(amp == 100){
            multR = 0.5;
        } 
        else if(amp>100 && amp < 1000){
            multR = amp/1000;
        } 
        else if(amp>1000 && amp < 10000){
            multR = amp/10000;
        } 
       multL = 1-multR;    
    double multMax = (multL < multR) ? multR : multL;
    multL /= multMax;
    multR /= multMax;
    if(amps==0){
        multR =0;
        multL=0;
       }
            byte b[] = new byte[precalcSize];
            double mult = /*126*/126;
            double k = getFreq()*2*pi/rate;
            int pd = rate/getFreq();
            //double phase = phaseBar.getValue() * 2*pi/100.;
            //double multR = balanceBar.getValue()/100.;
            int cycles = (int) (precalcSize/2 *k / (2*pi)); /*(int) ((rate*precalcSize*2*pi)/(2*getFreq()));*/
            blockAdder = 2*(int) (cycles*2*pi/k);
            for (v = 0; v != playSampleCount; v++) {
                double q1 = /*0.5*java.lang.Math.sin(i*k);*/multL*java.lang.Math.sin(v*k);
                double q2 = /*0.5*java.lang.Math.sin(i*k);*/multR*java.lang.Math.sin(v*k-(cvtDegToRad*phs));
                b[v*2] = (byte) (q1*mult);
                b[v*2+1] = (byte) (q2*mult);
          }
                //System.out.print(b[0] + " " + b[2] + " " + b[blockAdder-2] + " " + b[blockAdder] + " " + b[blockAdder+2] + "\n");
                //System.out.print(cycles + " " + blockAdder + "\n");
                AudioFormat format = new AudioFormat(rate, 8, 2, true, false);
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                if (line == null) {
                    try {
                        line = (SourceDataLine) AudioSystem.getLine(info);
                        line.open(format, bufferSize);
                    } catch (Exception e) {
                        e.printStackTrace();
                }
                    line.start();
           }
                lineBuffer = b;
                start();

     }
   
            final int bufferSize = 8192;
            final int precalcSize = /*16384*/16384;
            SourceDataLine line = null;
            byte lineBuffer[];
            int playSampleCount;
            int blockAdder;
  
    public void start() {
                    if (engine == null) {
                        engine = new Thread(this);
                        engine.start();
                    }
                }
           
                public void stop() {
                    if (engine != null && engine.isAlive()) {
                        engine.stop();
                  }
                    engine = null;
           }
 
    public void run() {
           
        try {
                int offset = 0;
                while (true) {
                    if (!jCheckBox1.isSelected())
                    break;
                    byte q[] = new byte[bufferSize];
                    int i;
                    int len = (bufferSize+offset > blockAdder)  /*bufferSize = 8192,blockAdder = 2*(int) (cycles*2*pi/k),cycles = (int) (precalcSize/2 *k / (2*pi))*/
                    ? blockAdder-offset : bufferSize;        /*precalcSize = (16384)1638,  k = getFreq()*2*pi/rate,  rate = 44100,  playSampleCount = precalcSize/2*/
                    for (i = 0; i != len; i++)
                        q[i] = lineBuffer[i+offset];
                        line.write(q, 0, len);
                        offset += len;
                        if (offset >= blockAdder)
                        offset = 0;
             }
            } catch (Exception e) {
                    e.printStackTrace();
       }
       engine = null;
  }


  class hel extends JPanel{
   public void paint(Graphics g){
       Dimension di = this.getSize();
       g.setColor(Color.white);
       g.fillRect(0,0,di.width,di.height);
            Font font = new Font("Times New Roman",Font.BOLD,16);
            g.setFont(font);
       if(i==-1 && m==0){
            g.setColor(Color.red);           
           g.drawString("Step 1: ",7,30);
            g.setColor(Color.blue);           
           g.drawString("Select No. of Waves to be Added ",7,60);
           g.drawString("from the First Drop-Down Box",7,90);
        }
      else if(i!=-1 && m==0){
            g.setColor(Color.white);
            g.fillRect(0,0,di.width,di.height);
            g.setFont(font);     
            g.setColor(Color.black);            
            g.drawString("Step 2: ",7,30);
            g.setColor(Color.red);            
            g.drawString("1.For Sa,Re,Ga,Ma.... select Musical Octave.",7,60);
            g.setColor(Color.black);            
            g.drawString("OR",95,85);
            g.setColor(Color.blue);            
            g.drawString("2.For User Defined Frequency write the value",7,110);  
            g.drawString("in the Text box & Press ENTER",7,135);
        }
       
       else if(m!=0 && m!=(i+1) && i!=-1){ 
            g.setColor(Color.white);
            g.fillRect(0,0,di.width,di.height);
            g.setFont(font); 
            g.setColor(Color.blue);            
            g.drawString("Step 3: ",7,20);
            g.setColor(Color.magenta);            
            g.drawString("Frequency of ",7,40);
            g.drawString("is selected ",159,40);            
            g.drawString("Now give the desired Amplitue,Phase ",7,65); 
            g.drawString("to   ",7,85);
            g.drawString("in their respective  ",85,85);
            g.drawString("Text Boxes & then Press ENTER after each entry.",7,110);    
                for(j=0;j<=i;j++){
                    if(j==(m-1)){
                        g.setColor(Color.blue);                                    
                        g.drawString("Signal "+Integer.toString(j+1),100,40);
                        g.drawString("Signal "+Integer.toString(j+1),25,85);                        
                        
                    }
                }
        }
                else if(m==(i+1)){
                       g.setColor(Color.magenta);            
                       g.drawString("Step 4: ",7,20);   
                       g.setColor(Color.blue);                                   
                       g.drawString("1.For Scales taken for the two Graphs ",7,50);
                       g.drawString("CLICK on the scales tab.",7,70); 
                       g.setColor(Color.black);                                                          
                       g.drawString("2.To view the Signals You have selected",7,100);  
                       g.drawString("CLICK on the Signlas Selected tab",7,120);  
                       g.setColor(Color.red);                                                          
                       g.drawString("3.For information about the applet ",7,150);    
                       g.drawString("CLICK on Description tab",7,170);
              }
              else if(i==-1 && m!=0){   
                       g.setColor(Color.red); 
                       g.setFont(new Font("Times New Roman",Font.PLAIN,18));                       
                       g.drawString("Please selecte No. of waves ",7,45);
                       g.drawString("to be added.",7,70); 
                    }
        
    }
    }
  
    class des extends JPanel{
      public void paint(Graphics g){
            Dimension di = this.getSize();
            g.setColor(Color.white);
            g.fillRect(0,0,di.width,di.height);          
            g.setColor(Color.blue);  
            g.setFont(new Font("Times New Roman",Font.PLAIN,18));                
            g.drawString("This applet produces the tone of sinusoids or the resultant of ",7,15);
            g.drawString("additon of sinusoids at different frequencies,amplitudes & phases.",7,45);
            g.drawString("The sinusoids selected by the user are plotted on Graph-1 in  ",7,75);  
            g.drawString("different colours.The resultant signal is plotted on Graph-2 with ",7,105);
            g.drawString("different scales.This applet produces the tones of Musical Octaves",7,135);
            g.drawString("such as Sa,Re,Ga,Ma.... besides the tones of other frequencies",7,165);            
        }
    }

    class graph1 extends JPanel{
        public void paint(Graphics g){
            Dimension di = this.getSize();
            g.setColor(Color.white);
            g.fillRect(0,0,di.width,di.height);          
            g.setColor(Color.magenta);
            g.setFont(new Font("Times New Roman",Font.BOLD,16));    
            g.drawString("On X-axis :",7,15);
            g.drawString("1 Unit = 1 Radian",30,40);      
            g.drawString("On Y-axis :",7,70); 
            g.drawString("1 Unit = 1 Unit",30,95); 
            g.drawString("Scale of Frequency :",7,120);
            g.drawString("1 Hz = 100 Hz",30,145);
        }
    }
    class graph2 extends JPanel{
        public void paint(Graphics g){
            Dimension di = this.getSize();
            g.setColor(Color.white);
            g.fillRect(0,0,di.width,di.height);          
            g.setColor(Color.blue);        
            g.setFont(new Font("Times New Roman",Font.BOLD,16));    
            g.drawString("On X-axis :",7,15);
            g.drawString("1 Unit = 1 Radian",30,40);      
            g.drawString("On Y-axis :",7,70); 
            g.drawString("1 Unit =    Units",30,95);   
            g.drawString(Integer.toString(scl2),88,95);
            g.drawString("Scale of Frequency :",7,120);
            g.drawString("1 Hz = 100 Hz",30,145);
        }
    }

    class selected extends JPanel{
        public void paint(Graphics g){
            Dimension di = this.getSize();
            g.setColor(Color.white);
            g.fillRect(0,0,di.width,di.height);          
            g.setColor(Color.blue);        
            g.setFont(new Font("Times New Roman",Font.PLAIN,14));
            g.drawString("Signal     Frequency     Amplitude    Phase",3,15);
                    for(j=0;j<=i;j++){
                         if(j==0){g.setColor(Color.red);}
                         else if(j==1){g.setColor(Color.black);}
                         else if(j==2){g.setColor(Color.magenta);}
                         else if(j==3){g.setColor(Color.blue);}
                         else if(j==4){g.setColor(Color.green);}
                         else if(j==5){g.setColor(new Color(0,255,204));}
                         else if(j==6){g.setColor(Color.cyan);}
                         else if(j==7){g.setColor(Color.orange);}                      
                         g.drawString(Integer.toString(j+1),14,45+(j*22));
                         g.drawString(Double.toString(f[j]),60,45+(j*22));
                         g.drawString(Double.toString(a[j]),145,45+(j*22));
                         g.drawString(Double.toString(b[j]),215,45+(j*22));                         
                        }
                    }
                }
            }
