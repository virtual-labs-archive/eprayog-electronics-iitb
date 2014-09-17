import java.lang.String;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class AstableNew extends JApplet implements Runnable {

    Thread animator;
    int pixel=0;
    boolean playing = true;
    boolean stopRequested=false;
    boolean rise=true;
    boolean charging = true;
    int ypixel;
    
    int originx1 = 30;
    int originy1 = 200;
    int originx2 = 30;
    int originy2 = 400;
    

    public void init() {
        initComponents();
        //cktPanel.repaint();
        //paramPanel.repaint();
        //graphPanel.repaint();
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Container jPanel1 = getContentPane();
        cktPanel = new Ckt_JPanel();
        paramPanel = new Param_JPanel();
        capValue = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,100,0,100,200);
        cap = new javax.swing.JLabel("C = 100 nF");
        res1Value = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,500,50,500,950);
        res1 = new javax.swing.JLabel("Ra = 500 ohms");
        res2Value = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,500,0,500,700);
        res2 = new javax.swing.JLabel("Rb = 500 ohms");
        pause = new javax.swing.JButton("Stop");
        graphPanel = new Graph_JPanel();

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        Color backgroundColor = new Color(231,248,255);
        cktPanel.setBackground(backgroundColor);
        cktPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        cktPanel.setName("cktPanel"); // NOI18N
        cktPanel.setPreferredSize(new java.awt.Dimension(400, 350));

        javax.swing.GroupLayout cktPanelLayout = new javax.swing.GroupLayout(cktPanel);
        cktPanel.setLayout(cktPanelLayout);
        cktPanelLayout.setHorizontalGroup(
            cktPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        cktPanelLayout.setVerticalGroup(
            cktPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        paramPanel.setBackground(backgroundColor);
        paramPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        paramPanel.setName("paramPanel"); // NOI18N

        capValue.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        capValue.setName("capValue"); // NOI18N
        
        capValue.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                capValueAdjustmentValueChanged(evt);
            }
        });

        cap.setName("cap"); // NOI18N

        res1Value.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        res1Value.setName("res1Value"); // NOI18N
        
        res1Value.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                res1ValueAdjustmentValueChanged(evt);
            }
        });


        res1.setName("res1"); // NOI18N

        res2Value.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        res2Value.setName("res2Value"); // NOI18N
        
        res2Value.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                res2ValueAdjustmentValueChanged(evt);
            }
        });


        res2.setName("res2"); // NOI18N

        pause.setName("pause"); // NOI18N
        
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paramPanelLayout = new javax.swing.GroupLayout(paramPanel);
        paramPanel.setLayout(paramPanelLayout);
        paramPanelLayout.setHorizontalGroup(
            paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paramPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(res2 , javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(cap)
                    .addComponent(res1))
                .addGap(70, 70, 70)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(res1Value, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(res2Value, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(pause, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );
        paramPanelLayout.setVerticalGroup(
            paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paramPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cap)
                    .addComponent(capValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(res1)
                    .addComponent(res1Value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pause)
                    .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(res2)
                        .addComponent(res2Value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        graphPanel.setBackground(backgroundColor);
        graphPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        graphPanel.setName("graphPanel"); // NOI18N
        graphPanel.setPreferredSize(new java.awt.Dimension(300, 500));

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paramPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cktPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cktPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

    }// </editor-fold>

    public void start() {
        animator = new Thread(this);
        animator.start();
    }
    
    public void run() {
            try {
                while (true) {
                    while(!stopRequested) {
                        graphPanel.draw(pixel);  
                        cktPanel.repaint();
                        Thread.sleep(100);
                        pixel++;
                        if (pixel > graphPanel.Xaxislen) {
                            pixel = 0;
                            graphPanel.resetplot();
                            Thread.sleep(2000);
                        }
                    }
                }
            }
            catch (InterruptedException e) {
            }  
        }
     
     
    public void stop() {
        animator = null;
    }
    
    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {
        if (playing) {
            //graphPanel.stopped = true;            
            pause.setText("Play");
            stopRequested=true;
            playing = false;
            graphPanel.draw(graphPanel.Xaxislen);
            cktPanel.repaint();
        }
        else {
           //graphPanel.stopped = false;            
            pause.setText("Stop");
            pixel = 0;
            stopRequested=false;
            playing = true;
            charging = true;
        }
    }

    private void capValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        cap.setText("C = " + capValue.getValue() + " nF ");
        graphPanel.set_values();  
        graphPanel.repaint(); 
    }

    private void res1ValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        res1.setText("Ra = " + res1Value.getValue() + " ohms ");
        graphPanel.set_values();  
        graphPanel.repaint(); 
    }

    private void res2ValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        res2.setText("Rb = " + res2Value.getValue() + " ohms ");
        graphPanel.set_values();  
        graphPanel.repaint(); 
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel cap;
    private javax.swing.JScrollBar capValue;
    private Ckt_JPanel cktPanel;
    private Graph_JPanel graphPanel;
    private Container jPanel1;
    private Param_JPanel paramPanel;
    private javax.swing.JButton pause;
    private javax.swing.JLabel res1;
    private javax.swing.JScrollBar res1Value;
    private javax.swing.JLabel res2;
    private javax.swing.JScrollBar res2Value;
    // End of variables declaration

    class Ckt_JPanel extends JPanel {
        int width = getWidth();
        int height = getHeight();
        
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D)g;
            CircuitA c = new CircuitA(10,10);
            g.setColor(Color.BLACK);
            c.draw(g2);
               
            Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,width,height);    
        }
    }

    class Param_JPanel extends JPanel {
        int width = getWidth();
        int height = getHeight();
        
        @Override public void paintComponent(Graphics g) {
                super.paintComponent(g);    
                Color backgroundColor = new Color(231,248,255);
                g.setColor(backgroundColor);
                g.fillRect(0,0,width,height);  
            }
    }

    class Graph_JPanel extends JPanel {
    
        double Vcc = 5.0;
        double Vth = 2*Vcc/3;
        double Vtl = Vcc/3;
        
        
        int Xaxislen = 240;
        int Yaxislen = 125;
        int pixel=0;
        
        boolean rise= true;
        double cap= 100/Math.pow(10,9);
        double taufall= cap*500;
        double taurise= cap*1000;
        double scaleX=25.0/taurise;
        double ton, toff, t;
        int prevx,prevy,xpixel,xreset,ypixel2;
        double x,y;
        boolean reset = true;
         
        void set_values(){
            cap = capValue.getValue()/Math.pow(10,9);
            taufall = cap*res2Value.getValue();
            taurise = cap*(res1Value.getValue()+res2Value.getValue());
            //scaleX = 25.0/taurise;
            ton = 0.693*cap*(res1Value.getValue()+res2Value.getValue());
            toff = 0.693*cap*res2Value.getValue();
            t = ton+toff;
        }
        
        public void draw (int p) {
            pixel = p;
            reset = false;
            repaint();
        }
        
        public void resetplot () {
            rise=true;
            charging = true;
        }
        
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //setting background color
            Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,getWidth(),getHeight());
            g.setColor(Color.BLACK);
            
            //plot axes
            //1st graph
            g.drawLine(originx1,originy1,originx1+Xaxislen+10,originy1);
            g.drawLine(originx1,originy1,originx1,originy1-Yaxislen);
            g.drawString("Vc",originx1-20,originy1-Yaxislen);
            g.drawString("t",originx1+Xaxislen+10,originy1+15);
            
            //2nd graph
            g.drawLine(originx2,originy2,originx2+Xaxislen+10,originy2);
            g.drawLine(originx2,originy2,originx2,originy2-Yaxislen);
            g.drawString("Vo",originx2-20,originy2-Yaxislen);
            g.drawString("t",originx2+Xaxislen+10,originy2+15);
           
            //arrows 
            g.drawLine(originx1,originy1-Yaxislen,originx1-3,originy1-Yaxislen+5);
            g.drawLine(originx1,originy1-Yaxislen,originx1+3,originy1-Yaxislen+5);
            g.drawLine(originx1+Xaxislen+10,originy1,originx1+Xaxislen+5,originy1-3);
            g.drawLine(originx1+Xaxislen+10,originy1,originx1+Xaxislen+5,originy1+3);
            g.drawLine(originx2,originy2-Yaxislen,originx2-3,originy2-Yaxislen+5);
            g.drawLine(originx2,originy2-Yaxislen,originx2+3,originy2-Yaxislen+5);
            g.drawLine(originx2+Xaxislen+10,originy2,originx2+Xaxislen+5,originy2-3);
            g.drawLine(originx2+Xaxislen+10,originy2,originx2+Xaxislen+5,originy2+3);
            
            //putting the grey lines
            g.setColor(Color.GRAY.brighter());
            //1st graph
            g.drawLine(originx1,originy1-36,originx1+Xaxislen+10,originy1-36);
            g.drawLine(originx1,originy1-72,originx1+Xaxislen+10,originy1-72);
            g.drawLine(originx1,originy1-108,originx1+Xaxislen+10,originy1-108);
            //2nd graph
            //g.drawLine(originx2,originy2-36,originx2+Xaxislen+10,originy2-36);
            //g.drawLine(originx2,originy2-72,originx2+Xaxislen+10,originy2-72);
            g.drawLine(originx2,originy2-108,originx2+Xaxislen+10,originy2-108);
            
            g.setColor(Color.GREEN.darker().darker());
            g.drawString("Vcc",originx1+Xaxislen+10,originy1-108-5);
            g.drawString("Vth",originx1+Xaxislen+10,originy1-5-72);
            g.drawString("Vtl",originx1+Xaxislen+10,originy1-5-36);
            g.drawString("Vcc",originx2-20,originy2-108);
            
            g.setColor(Color.BLACK);

            //drawing graph
            prevx=originx1;
            prevy=originy1-36;
            rise=true;
            
            for (xpixel=xreset=0;xpixel<=pixel;xpixel++){
                if(rise){
                    x=(double)(xpixel-xreset)/scaleX;
                    y=Vcc-(double)(Vcc-Vtl)*Math.exp(-x/taurise);
                    ypixel=(int)(y*108/Vcc);
                    ypixel2=originy2-108;
                    if(ypixel>=72){
                        ypixel=72;
                        rise=false;
                        charging = false;
                        xreset=xpixel;
                        g.setColor(Color.GRAY.brighter());
                        g.drawLine(originx2+xpixel,originy1-72,originx2+xpixel,originy2);
                        g.setColor(Color.RED);
                        g.drawLine(originx2+xpixel,originy2-108,originx2+xpixel,originy2);
                        
                    }
                    //g.drawString(Integer.toString(ypixel),150,20+10*xpixel);
                    g.setColor(Color.GREEN.darker());
                    g.drawLine(prevx,prevy,xpixel+originx1,originy1-ypixel);
                    prevx=originx1+xpixel;
                    prevy=originy1-ypixel;
                } else {
                    x=(double)(xpixel-xreset)/scaleX;
                    y=(double)Vcc*2/3*Math.exp(-x/taufall);
                    ypixel=(int)(y*108/Vcc);
                    ypixel2=originy2;
                    if(ypixel<=36){
                        ypixel=36;
                        rise=true;
                        charging = true;
                        xreset=xpixel;
                        g.setColor(Color.GRAY.brighter());
                        g.drawLine(originx2+xpixel,originy1-36,originx2+xpixel,originy2);
                        g.setColor(Color.RED);
                        g.drawLine(originx2+xpixel,originy2-108,originx2+xpixel,originy2);
                    }
                    //g.drawString(Integer.toString(ypixel),150,20+10*xpixel);
                    g.setColor(Color.GREEN.darker());
                    g.drawLine(prevx,prevy,xpixel+originx1,originy1-ypixel);
                    prevx=originx1+xpixel;
                    prevy=originy1-ypixel;
                    //g.drawLine(100,100,200,200);
                }
                g.setColor(Color.RED);
                g.drawLine(originx2+xpixel,ypixel2,originx2+xpixel+1,ypixel2);
            }
            g.setColor(Color.GRAY);
            g.drawLine(originx1+xpixel,originy1-ypixel,originx2+xpixel,ypixel2);
        }
    }

    public class CircuitA extends Ckt_JPanel{
        public CircuitA(int a, int b) {
            x = a;
            y = b;
        }
        
        //to draw the circuit
        public void draw(Graphics2D g2) {
            //wires
            Line2D.Double w1 = new Line2D.Double(130,20,130,90);
            Line2D.Double w2 = new Line2D.Double(70,60,130,60);
            Line2D.Double w3 = new Line2D.Double(40,120,70,120);
            Line2D.Double w4 = new Line2D.Double(40,120,40,275);
            Line2D.Double w5 = new Line2D.Double(100,140,130,140);
            Line2D.Double w6 = new Line2D.Double(100,220,130,220);
            Line2D.Double w7 = new Line2D.Double(100,140,100,220);
            Line2D.Double w8 = new Line2D.Double(70,180,100,180);
            Line2D.Double w9 = new Line2D.Double(330,150,395,150);
            Line2D.Double w10= new Line2D.Double(330,210,370,210);
            Line2D.Double w11= new Line2D.Double(130,270,130,320);
            Line2D.Double w12= new Line2D.Double(40,275,210,275);
            Line2D.Double w13= new Line2D.Double(130,305,210,305);
            Line2D.Double w14= new Line2D.Double(310,290,370,290);
            Line2D.Double w15= new Line2D.Double(370,210,370,290);
            Line2D.Double w16= new Line2D.Double(70,180,70,220);
            Line2D.Double w17= new Line2D.Double(70,245,70,320);
            
            VResistor r1=new VResistor(130,90);
            VResistor r2=new VResistor(130,150);
            VResistor r3=new VResistor(130,210);
            VResistor ra=new VResistor(70,60);
            VResistor rb=new VResistor(70,120);
            
            Comparator c1 = new Comparator(130,140);
            Comparator c2 = new Comparator(130,200);
            
            Capacitor c = new Capacitor(70,220);
            
            Ground gr1 = new Ground(130,320);
            Ground gr2 = new Ground(70,320);
            
            Rectangle ff = new Rectangle(250,120,80,120);
            Rectangle outline = new Rectangle(110,90,270,230);
            
            Transistor t = new Transistor(210,275);
            HResistor r = new HResistor(250,290);
            
            g2.setColor(new Color(221,238,255));
            g2.fillRect(110,90,270,230);
            g2.setColor(Color.BLACK);
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
            g2.draw(w7);
            g2.draw(w8);
            g2.draw(w9);
            g2.draw(w10);
            g2.draw(w11);
            g2.draw(w12);
            g2.draw(w13);
            g2.draw(w14);
            g2.draw(w15);
            g2.draw(w16);
            g2.draw(w17);
            
            c.draw(g2);
            ra.draw(g2);
            rb.draw(g2);
            r1.draw(g2);
            r2.draw(g2);
            r3.draw(g2);
            
            r.draw(g2);
            c1.draw(g2);
            c2.draw(g2);
            t.draw(g2);
            
            //labels 
            g2.drawString("Vcc = 5 V",120,19);
            g2.drawString("Output",402,152);
            g2.drawString("Ra",80,95);
            g2.drawString("Rb",80,155);
            g2.drawString("C",80,238);
            g2.drawString("5k",140,125);
            g2.drawString("5k",140,185);
            g2.drawString("5k",140,245);
            g2.drawString("100 ohms",260,280);
            
            //joints
            g2.fillRect(69,119,3,3);
            g2.fillRect(129,59,3,3);
            g2.fillRect(69,179,3,3);
            g2.fillRect(129,159,3,3);
            g2.fillRect(129,199,3,3);
            g2.fillRect(129,304,3,3);
            g2.fillRect(394,149,3,3);
            
            //Legend
            g2.setColor(new Color(255,0,255));
            g2.drawLine(300,20,320,20);
            g2.setColor(Color.RED);
            g2.drawLine(300,40,320,40);
            g2.setColor(Color.BLACK);
            g2.drawString("Direction of Current",330,25);
            g2.drawString("High Voltage", 330, 45);
            
            Arrow ckt;
            int loc=pixel;
            if(playing) {
                if(charging) {
                    g2.setColor(new Color(255,0,255));
                    c.draw(g2);
                    g2.draw(new Line2D.Double(130,20,130,60));
                    g2.draw(new Line2D.Double(70,60,130,60));
                    ra.draw(g2);
                    rb.draw(g2);
                    g2.draw(w16);
                    g2.draw(w17);
                    g2.fillRect(129,59,3,3);
                    g2.fillRect(69,119,3,3);
                    g2.fillRect(69,179,3,3);
                    
                    g2.setColor(Color.RED);
                    g2.draw(w9);
                    g2.drawString("CAPACITOR CHARGING",140,75);
                    loc=loc+350;
                    do {
                        if (loc<=40){
                            ckt=new Arrow(130,20+loc,"down");
                        } else if (loc<=100){
                            ckt = new Arrow(130+40-loc,60,"left");
                        } else if(loc<=350){
                            ckt = new Arrow(70,60+loc-100,"down");
                        }else
                            ckt = new Arrow(0,0,"null");
                        ckt.draw(g2);
                        loc = loc-40;
                    }while (loc>=0);
                    g2.setColor(Color.BLACK);
                }
                else {
                    g2.setColor(new Color(255,0,255));
                    c.draw(g2);
                    rb.draw(g2);
                    g2.draw(w3);
                    g2.draw(w4);
                    g2.draw(w12);
                    g2.draw(w13);
                    g2.draw(w16);
                    g2.draw(w17);
                    g2.fillRect(69,119,3,3);
                    g2.fillRect(69,179,3,3);
                    g2.fillRect(129,304,3,3);
                    g2.draw(new Line2D.Double(130,305,130,320));
                    
                    g2.setColor(Color.RED);
                    g2.drawString("CAPACITOR DISCHARGING",140,75);
            
                    g2.draw(w10);
                    g2.draw(w14);
                    g2.draw(w15);
                    r.draw(g2);
                    //g2.drawString("abc",50,50);
                    t.draw(g2);
                    loc+=565;
                    do {
                        if (loc<=115){
                            ckt = new Arrow(70,235-loc,"up");
                        } else if (loc<=145){
                            ckt = new Arrow(70-loc+115,120,"left");
                        } else if (loc<=300){
                            ckt = new Arrow(40,120+loc-145,"down");
                        } else if (loc<=470){
                            ckt = new Arrow(40+loc-300,275,"right");
                        } /*else if (loc<=505){
                            ckt = new Arrow(40,140+loc-210,"down");
                        } else if (loc<=515){
                            ckt = new Arrow(40+loc-345,275,"right");
                        }*/else if(loc<=555){
                            ckt = new Arrow(215-loc+470,305,"left");
                        } else if(loc<=565){
                            ckt = new Arrow(130,305+loc-555,"down");
                        }else
                            ckt = new Arrow(0,0,"null");
                            
                        ckt.draw(g2);
                        loc = loc-40;
                    }while(loc>=0);
                    g2.setColor(Color.BLACK);
                }
                
                if(ypixel>=67){
                    //g2.drawString("abc",50,50);
                    g2.setColor(Color.RED);
                    c1.draw(g2);
                    g2.draw(w5);
                    g2.draw(w8);
                    g2.draw(new Line2D.Double(100,140,100,180));
                    g2.fillRect(129,159,3,3);
                    
                    g2.setColor(Color.BLACK);
    
                }
                
                if(ypixel<=41){
                    g2.setColor(Color.RED);
                    c2.draw(g2);
                    g2.draw(w8);
                    g2.draw(w6);
                    g2.draw(new Line2D.Double(100,180,100,220));
                    g2.fillRect(129,199,3,3);
                    g2.setColor(Color.BLACK);
    
                } 
            }
            
            gr1.draw(g2);
            gr2.draw(g2);
            
            g2.draw(ff);
            g2.drawString("R",255,155);
            g2.drawString("S",255,215);
            g2.drawString("Q",310,155);
            g2.drawString("Q",310,215);
            g2.drawString("_",310,200);
            
            Color fontcolour = new Color(150,150,150);
            g2.setColor(Color.BLUE);
            g2.draw(outline);
        }
        private int x,y;
    }


    class VResistor {
        public VResistor(int a, int b) {
            x = a;
            y = b;
        }
        public void draw(Graphics2D g2) {
            Line2D.Double w1= new Line2D.Double(x,y,x,y+20);
            Line2D.Double w2= new Line2D.Double(x,y+20,x-5,y+22);
            Line2D.Double w3= new Line2D.Double(x-5,y+22,x+5,y+25);
            Line2D.Double w4= new Line2D.Double(x+5,y+25,x-5,y+28);
            Line2D.Double w5= new Line2D.Double(x-5,y+28,x+5,y+31);
            Line2D.Double w6= new Line2D.Double(x+5,y+31,x-5,y+34);
            Line2D.Double w7= new Line2D.Double(x-5,y+34,x+5,y+37);
            Line2D.Double w8= new Line2D.Double(x+5,y+37,x,y+39);
            Line2D.Double w9= new Line2D.Double(x,y+39,x,y+60);
            
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
            g2.draw(w7);
            g2.draw(w8);
            g2.draw(w9);
        }
        
        private int x,y;
    }
    
    class HResistor {
        public HResistor(int a, int b) {
            x = a;
            y = b;
        }
        public void draw(Graphics2D g2) {
            Line2D.Double w1= new Line2D.Double(x,y,x+20,y);
            Line2D.Double w2= new Line2D.Double(x+20,y,x+22,y-5);
            Line2D.Double w3= new Line2D.Double(x+22,y-5,x+25,y+5);
            Line2D.Double w4= new Line2D.Double(x+25,y+5,x+28,y-5);
            Line2D.Double w5= new Line2D.Double(x+28,y-5,x+31,y+5);
            Line2D.Double w6= new Line2D.Double(x+31,y+5,x+34,y-5);
            Line2D.Double w7= new Line2D.Double(x+34,y-5,x+37,y+5);
            Line2D.Double w8= new Line2D.Double(x+37,y+5,x+39,y);
            Line2D.Double w9= new Line2D.Double(x+39,y,x+60,y);
            
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
            g2.draw(w7);
            g2.draw(w8);
            g2.draw(w9);
        }
        
        private int x,y;
    }
    
    class Comparator {
        public Comparator(int a, int b)
        {
            x=a;
            y=b;
        }
        
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x+40,y);
            Line2D.Double w2= new Line2D.Double(x,y+20,x+40,y+20);
            Line2D.Double w3= new Line2D.Double(x+40,y-10,x+40,y+30);
            Line2D.Double w4= new Line2D.Double(x+40,y-10,x+80,y+10);
            Line2D.Double w5= new Line2D.Double(x+40,y+30,x+80,y+10);
            Line2D.Double w6= new Line2D.Double(x+80,y+10,x+120,y+10);
            
            g2.drawString("+",x+45,y+7);
            g2.drawString("-",x+45,y+25);
            
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
        }
        private int x,y;
    }
    
    class Capacitor {
        public Capacitor(int a, int b)
        {
            x=a;
            y=b;
        }
        
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x,y+10);
            Line2D.Double w2= new Line2D.Double(x-5,y+10,x+5,y+10);
            Line2D.Double w3= new Line2D.Double(x-5,y+15,x+5,y+15);
            Line2D.Double w4= new Line2D.Double(x,y+15,x,y+25);
            
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
        }
        
        private int x,y;
    }
    
    class Ground {
        public Ground(int a, int b)
        {
            x=a;
            y=b;
        }
        
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x,y+10);
            Line2D.Double w2= new Line2D.Double(x-10,y+10,x+10,y+10);
            Line2D.Double w3= new Line2D.Double(x-6,y+15,x+6,y+15);
            Line2D.Double w4= new Line2D.Double(x-2,y+20,x+2,y+20);
            
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
        }
        
        private int x,y;
    }
    
    class Transistor {
        public Transistor(int a, int b)
        {
            x=a;
            y=b;
        }
        
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x+20,y+10);
            Line2D.Double w2= new Line2D.Double(x+20,y+15,x+40,y+15);
            Line2D.Double w3= new Line2D.Double(x+20,y,x+20,y+30);
            Line2D.Double w4= new Line2D.Double(x+20,y+20,x,y+30);
            Line2D.Double w5= new Line2D.Double(x,y+30,x+3,y+25);
            Line2D.Double w6= new Line2D.Double(x,y+31,x+5,y+31);
            Line2D.Double w7= new Line2D.Double(x+3,y+25,x+5,y+31);
            
            g2.draw(w1);
            g2.draw(w2);
            g2.draw(w3);
            g2.draw(w4);
            g2.draw(w5);
            g2.draw(w6);
            g2.draw(w7);
        }
        private int x,y;
    }
    
    class Arrow {
        public Arrow(int a, int b, String dir)
        {
            x=a;
            y=b;
            direction=dir;
        }
        
        public void draw(Graphics2D g2)
        {
            if(direction == "up"){
       
                Line2D.Double w1= new Line2D.Double(x,y,x-3,y+5);
                Line2D.Double w2= new Line2D.Double(x,y,x+3,y+5);
                
                g2.draw(w1);
                g2.draw(w2);
            }
            
            else if(direction == "down") {
                Line2D.Double w1= new Line2D.Double(x,y,x-3,y-5);
                Line2D.Double w2= new Line2D.Double(x,y,x+3,y-5);
                
                g2.draw(w1);
                g2.draw(w2);
            }
            
            else if(direction == "left"){
                Line2D.Double w1= new Line2D.Double(x,y,x+5,y-3);
                Line2D.Double w2= new Line2D.Double(x,y,x+5,y+3);
                
                g2.draw(w1);
                g2.draw(w2);
            }
            else {
                Line2D.Double w1= new Line2D.Double(x,y,x-5,y-3);
                Line2D.Double w2= new Line2D.Double(x,y,x-5,y+3);
                
                g2.draw(w1);
                g2.draw(w2);
            }
        }
        
        private String direction;
        private int x,y;
    } //end of class Arrow        
 
    
}//End of class Astable
