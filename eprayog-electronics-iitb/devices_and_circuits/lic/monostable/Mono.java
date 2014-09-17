import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class Mono extends JApplet implements Runnable {

    Thread animator;
    int pixel=0;
    boolean playing = true;
    boolean stopRequested = false;
    boolean rise=true;
    boolean trigger=true;
    boolean first=true;
    
    int ypixel2;
    
    /** Initializes the applet DTS */
    public void init() {
        initComponents();
                   
    }
             
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Container jPanel1 = getContentPane();
        cktPanel = new Ckt_JPanel();
        graphPanel = new Graph_JPanel();
        paramPanel = new Param_JPanel();
        capValue = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,100,0,100,200);
        cap = new javax.swing.JLabel("C = 100 nF");
        resValue = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,500,0,500,950);
        res = new javax.swing.JLabel("R = 500 ohms");
        trgAmp = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,0,0,0,500);
        triggerWidth = new javax.swing.JLabel("T_amp = 0.0 volts");
        triggerAmp = new javax.swing.JLabel();
        pause = new javax.swing.JButton("Stop");

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
            .addGap(0, 502, Short.MAX_VALUE)
        );

        paramPanel.setBackground(backgroundColor);
        paramPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        paramPanel.setName("paramPanel"); // NOI18N
        paramPanel.setPreferredSize(new java.awt.Dimension(442, 150));
        paramPanel.setRequestFocusEnabled(false);

        capValue.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        capValue.setName("capValue"); // NOI18N
        capValue.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                capValueAdjustmentValueChanged(evt);
            }
        });



        cap.setName("cap"); // NOI18N

        resValue.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        resValue.setName("resValue"); // NOI18N
        resValue.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                resValueAdjustmentValueChanged(evt);
            }
        });


        res.setName("res"); // NOI18N

        trgAmp.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        trgAmp.setName("trgAmp"); // NOI18N
        trgAmp.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                trgAmpAdjustmentValueChanged(evt);
            }
        });


        triggerWidth.setName("triggerWidth"); // NOI18N
        triggerAmp.setName("triggerAmp"); // NOI18N
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
                    .addComponent(cap)
                    .addComponent(res)
                    .addComponent(triggerWidth))
                .addGap(43, 43, 43)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(trgAmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capValue, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(resValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paramPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(triggerAmp)
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(paramPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pause)
                        .addGap(19,19,19))))
        );
        paramPanelLayout.setVerticalGroup(
            paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paramPanelLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pause)
                    .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trgAmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(triggerWidth)))
                .addContainerGap())
            .addGroup(paramPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(triggerAmp)
                    .addGroup(paramPanelLayout.createSequentialGroup()
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cap)
                            .addComponent(capValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(res))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cktPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(graphPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cktPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paramPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
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
                        Thread.sleep(75);
                        pixel++;
                        if (pixel > graphPanel.Xaxislen) {
                            pixel = 0;
                            graphPanel.resetplot();
                            cktPanel.repaint();
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
            pause.setText("Play");
            stopRequested=true;
            playing = false;
            graphPanel.draw(graphPanel.Xaxislen);
            cktPanel.repaint();
        }
        else {           
            pause.setText("Stop");
            pixel = 0;
            stopRequested=false;
            playing = true;
        }
    }                                     

    private void capValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {                                                
        cap.setText("C = " + capValue.getValue() + " nF");
        graphPanel.set_values();
        graphPanel.repaint(); 
    }                                               

    private void resValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {                                                 
        res.setText("R = " + resValue.getValue() + " ohms");
        graphPanel.set_values();
        graphPanel.repaint();
    }                                                

    private void trgAmpAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {                                                 
        triggerWidth.setText("T_amp = " + (double)(trgAmp.getValue()/100) + " volts");
        graphPanel.set_values();
        if(trgAmp.getValue()<=166)
                trigger=true;
            else
                trigger=false;
        graphPanel.repaint();
        cktPanel.repaint();
    }                                                

   
    // Variables declaration - do not modify
    private javax.swing.JLabel cap;
    private javax.swing.JScrollBar capValue;
    private Ckt_JPanel cktPanel;
    private Graph_JPanel graphPanel;
    private Container jPanel1;
    private Param_JPanel paramPanel;
    private javax.swing.JButton pause;
    private javax.swing.JLabel res;
    private javax.swing.JScrollBar resValue;
    private javax.swing.JScrollBar trgAmp;
    private javax.swing.JLabel triggerAmp;
    private javax.swing.JLabel triggerWidth;
    // End of variables declaration

    class Ckt_JPanel extends JPanel {
        int width = getWidth();
        int height = getHeight();
    
        public void change(MouseEvent evt) {
    
        }

    
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
        int originx1 = 30;
        int originy1 = 140;
        int originx2 = 30;
        int originy2 = 295;
        int originx3 = 30;
        int originy3 = 450;
        
        int Xaxislen = 250;
        int Yaxislen = 125;
        
        double cap= 100/Math.pow(10,9);
        double taurise=cap*500;
        double scaleX=25.0/taurise;
        int prevy1,prevy2,prevy3,xpixel,xreset,ypixel1,ypixel3;
        double x,y;
        boolean reset = true;
        boolean line;
        int tvalue;
        double ton=1.1*cap*500*10000;
       
        
        public void draw (int p) {
            pixel = p;
            reset = false;
            repaint();
        }
        
        
        public void resetplot () {
            rise = true;
        }
        
        
        void set_values(){
            cap = capValue.getValue()/Math.pow(10,9);
            taurise = cap*resValue.getValue();
            ton = 1.1 * cap * resValue.getValue()*10000;
    
        }
        
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            rise=true;
           
            //setting background colour
            Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,getWidth(),getHeight());            
            
            //Drawing axes
            g.setColor(Color.BLACK);
            //plot axes
            g.drawLine(originx1,originy1,originx1+Xaxislen,originy1);
            g.drawLine(originx1,originy1,originx1,originy1-Yaxislen);
            g.drawString("Vtrigger",originx1-20,originy1-Yaxislen);
            g.drawString("t",originx1+Xaxislen,originy1+15);
            
            g.drawLine(originx2,originy2,originx2+Xaxislen,originy2);
            g.drawLine(originx2,originy2,originx2,originy2-Yaxislen);
            g.drawString("Vc",originx2-20,originy2-Yaxislen);
            g.drawString("t",originx2+Xaxislen,originy2+15);
            
            g.drawLine(originx3,originy3,originx3+Xaxislen,originy3);
            g.drawLine(originx3,originy3,originx3,originy3-Yaxislen);
            g.drawString("Vo",originx3-20,originy3-Yaxislen);
            g.drawString("t",originx3+Xaxislen,originy3+15);
            
            //arrows
            g.drawLine(originx1,originy1-Yaxislen,originx1-3,originy1-Yaxislen+5);
            g.drawLine(originx1,originy1-Yaxislen,originx1+3,originy1-Yaxislen+5);
            g.drawLine(originx1+Xaxislen,originy1,originx1+Xaxislen-5,originy1-3);
            g.drawLine(originx1+Xaxislen,originy1,originx1+Xaxislen-5,originy1+3);
            g.drawLine(originx2,originy2-Yaxislen,originx2-3,originy2-Yaxislen+5);
            g.drawLine(originx2,originy2-Yaxislen,originx2+3,originy2-Yaxislen+5);
            g.drawLine(originx2+Xaxislen,originy2,originx2+Xaxislen-5,originy2-3);
            g.drawLine(originx2+Xaxislen,originy2,originx2+Xaxislen-5,originy2+3);
            g.drawLine(originx3,originy3-Yaxislen,originx3-3,originy3-Yaxislen+5);
            g.drawLine(originx3,originy3-Yaxislen,originx3+3,originy3-Yaxislen+5);
            g.drawLine(originx3+Xaxislen,originy3,originx3+Xaxislen-5,originy3-3);
            g.drawLine(originx3+Xaxislen,originy3,originx3+Xaxislen-5,originy3+3);
            
            g.drawString("Vcc",originx3+Xaxislen,originy3-108);
            g.drawString("Vcc",originx3+Xaxislen,originy2-108);
            g.drawString("Vth",originx3+Xaxislen,originy2-72);
            g.drawString("Vtl",originx3+Xaxislen,originy2-36);
            
            g.drawString("Vcc",originx1+Xaxislen,originy1-100);
            g.drawString("Vth",originx1+Xaxislen,originy1-67);
            g.drawString("Vtl",originx1+Xaxislen,originy1-33);
            
            //putting the grey lines
            g.setColor(Color.GRAY.brighter());
            g.drawLine(originx1,originy1-33,originx1+Xaxislen,originy1-33);
            g.drawLine(originx1,originy1-67,originx1+Xaxislen,originy1-67);
            g.drawLine(originx1,originy1-100,originx1+Xaxislen,originy1-100);
            
            g.drawLine(originx2,originy2-36,originx2+Xaxislen,originy2-36);
            g.drawLine(originx2,originy2-72,originx2+Xaxislen,originy2-72);
            g.drawLine(originx2,originy2-108,originx2+Xaxislen,originy2-108);
            
            //g.drawLine(originx3,originy3-36,originx3+Xaxislen,originy3-36);
            //g.drawLine(originx3,originy3-72,originx3+Xaxislen,originy3-72);
            g.drawLine(originx3,originy3-108,originx3+Xaxislen,originy3-108);
            
            //drawing graph
            first=true;
            rise=true;            
            Arrow a1;
            prevy1=trgAmp.getValue()*20/100;
            prevy2=0;
            prevy3=108;
            xreset=0;
            
            
            for (xpixel=0;xpixel<=pixel;xpixel++){
                line =false;
                if(trigger){
                    if (first){
                        g.setColor(Color.RED);
                        a1=new Arrow(originx3-1,originy3+20,"left");
                        a1.draw(g2);
                        g.drawLine(originx3,originy3+20,xpixel+originx3-1,originy3+20);
                    }
                    if(rise){
                        x=(double)(xpixel-xreset)/scaleX;
                        y=(double)Vcc*(1-Math.exp(-x/taurise));
                        if ((xpixel-xreset)<5){
                            ypixel1 = trgAmp.getValue()*20/100;
                        } else if ((xpixel-xreset)==5) {         
                            ypixel1 = 100;
                            g.setColor(Color.BLUE); 
                            g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                            line=true;
                        } else {
                            ypixel1 = 100;
                        }
                        ypixel2 =(int)(y*108/Vcc);
                        ypixel3 = 108;
                        if(ypixel2>=72){
                            ypixel2=0;
                            ypixel3=0;
                            rise=false;
                            xreset=xpixel;
                            g.setColor(Color.GREEN.darker());
                            g.drawLine(originx2+xpixel,originy2-prevy2,originx2+xpixel,originy2-ypixel2);
                            g.setColor(Color.GRAY.brighter());
                            g.drawLine(originx3+xpixel,originy2-ypixel2,originx3+xpixel,originy3-ypixel3);
                            g.setColor(Color.RED);
                            if(first){
                                Arrow a2=new Arrow(xpixel+originx3-1,originy3+20,"right");
                                a2.draw(g2);
                                tvalue=(int)Math.round(1.1*resValue.getValue()*cap*1000000);
                                g.drawString("1.1RC = "+Double.toString(tvalue/1000.0)+" ms",originx3,originy3+15);
                            }
                            g.drawLine(originx3+xpixel,originy3-prevy3,originx3+xpixel,originy3-ypixel3);
                            first=false;
                            prevy2=ypixel2;
                            prevy3=ypixel3;
                        }
                        if (!line){
                            g.setColor(Color.BLUE);
                            g.drawLine(originx1+xpixel-1,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                        }
                        g.setColor(Color.GREEN.darker());
                        g.drawLine(originx2+xpixel-1,originy2-prevy2,originx2+xpixel,originy2-ypixel2);
                        g.setColor(Color.RED);
                        if(!first && (xpixel-xreset)==1){
                            g.drawLine(originx3+xpixel,originy3-prevy3,originx3+xpixel,originy3-ypixel3);
                        } else {
                            g.drawLine(originx3+xpixel-1,originy3-prevy3,originx3+xpixel,originy3-ypixel3);
                        }
                        prevy1=ypixel1;
                        prevy2=ypixel2;    
                        prevy3=ypixel3;
                    } else {
                        x=(double)(xpixel-xreset)/scaleX;
                        if((xpixel-xreset)<40){
                            g.setColor(Color.BLUE);
                            g.drawLine(originx1+xpixel-1,originy1-prevy1,originx1+xpixel,originy1-prevy1);
                            g.setColor(Color.GREEN.darker());
                            g.drawLine(originx2+xpixel-1,originy2-prevy2,originx2+xpixel,originy2-prevy2);
                            g.setColor(Color.RED);
                            g.drawLine(originx3+xpixel-1,originy3-prevy3,originx3+xpixel,originy3-prevy3);
                        } else if ((xpixel-xreset)==40){  
                            g.setColor(Color.GREEN.darker());
                            g.drawLine(originx2+xpixel-1,originy2-prevy2,originx2+xpixel,originy2-prevy2);
                            g.setColor(Color.RED);
                            g.drawLine(originx3+xpixel-1,originy3-prevy3,originx3+xpixel,originy3-prevy3);
                            ypixel1=trgAmp.getValue()*20/100;
                            g.setColor(Color.BLUE);
                            g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                            prevy1=ypixel1;
                        } else {
                            xreset=xpixel;
                            rise=true;
                        }
                    }
                }
                else{
                    if (first){
                        g.setColor(Color.RED);
                        //a1=new Arrow(originx3-1,originy3+20,"left");
                        //a1.draw(g2);
                        //g.drawLine(originx3,originy3+20,xpixel+originx3-1,originy3+20);
                    }
                    if(rise){
                        x=(double)(xpixel-xreset)/scaleX;
                        y=(double)Vcc*(1-Math.exp(-x/taurise));
                        if ((xpixel-xreset)<5){
                            ypixel1 = trgAmp.getValue()*20/100;
                        } else if ((xpixel-xreset)==5) {         
                            ypixel1 = 100;
                            g.setColor(Color.BLUE); 
                            g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                            line=true;
                        } else {
                            ypixel1 = 100;
                        }
                        ypixel2 =(int)(y*108/Vcc);
                        ypixel3 = 108;
                        if(ypixel2>=72){
                            ypixel2=0;
                            ypixel3=0;
                            rise=false;
                            xreset=xpixel;
                            g.setColor(Color.GREEN.darker());
                            g.drawLine(originx2+xpixel,originy2,originx2+xpixel,originy2);
                            //g.setColor(Color.GRAY.brighter());
                            //g.drawLine(originx3+xpixel,originy2,originx3+xpixel,originy3);
                            g.setColor(Color.RED);
                            /*if(first){
                                Arrow a2=new Arrow(xpixel+originx3-1,originy3+20,"right");
                                a2.draw(g2);
                                //tvalue=(int)Math.round(1.1*resValue.getValue()*cap*1000000);
                                tvalue=0;
                                g.drawString("1.1RC = "+Double.toString(tvalue/1000.0)+" ms",originx3,originy3+15);
                            }*/
                            g.drawLine(originx3+xpixel,originy3,originx3+xpixel,originy3);
                            first=false;
                            prevy2=ypixel2;
                            prevy3=ypixel3;
                        }
                        if (!line){
                            g.setColor(Color.BLUE);
                            g.drawLine(originx1+xpixel-1,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                        }
                        g.setColor(Color.GREEN.darker());
                        g.drawLine(originx2+xpixel-1,originy2,originx2+xpixel,originy2);
                        g.setColor(Color.RED);
                        if(!first && (xpixel-xreset)==1){
                            g.drawLine(originx3+xpixel,originy3,originx3+xpixel,originy3);
                        } else {
                            g.drawLine(originx3+xpixel-1,originy3,originx3+xpixel,originy3);
                        }
                        prevy1=ypixel1;
                        prevy2=ypixel2;    
                        prevy3=ypixel3;
                    } else {
                        x=(double)(xpixel-xreset)/scaleX;
                        if((xpixel-xreset)<40){
                            g.setColor(Color.BLUE);
                            g.drawLine(originx1+xpixel-1,originy1-prevy1,originx1+xpixel,originy1-prevy1);
                            g.setColor(Color.GREEN.darker());
                            g.drawLine(originx2+xpixel-1,originy2,originx2+xpixel,originy2);
                            g.setColor(Color.RED);
                            g.drawLine(originx3+xpixel-1,originy3-prevy3,originx3+xpixel,originy3-prevy3);
                        } else if ((xpixel-xreset)==40){  
                            g.setColor(Color.GREEN.darker());
                            g.drawLine(originx2+xpixel-1,originy2,originx2+xpixel,originy2);
                            g.setColor(Color.RED);
                            g.drawLine(originx3+xpixel-1,originy3,originx3+xpixel,originy3);
                            ypixel1=trgAmp.getValue()*20/100;
                            g.setColor(Color.BLUE);
                            g.drawLine(originx1+xpixel,originy1-prevy1,originx1+xpixel,originy1-ypixel1);
                            prevy1=ypixel1;
                        } else {
                            xreset=xpixel;
                            rise=true;
                        }
                    }
                }
            }//end of for loop
        }
    }//end of class Graph_JPanel

    class CircuitA extends Ckt_JPanel{
        public CircuitA(int a, int b) {
            x = a;
            y = b;
        }
        
        //to draw the circuit
        public void draw(Graphics2D g2) {
            //wires
            Line2D.Double w1 = new Line2D.Double(130,20,130,90);
            Line2D.Double w2 = new Line2D.Double(70,60,130,60);
            Line2D.Double w3 = new Line2D.Double(70,150,70,120);
            Line2D.Double w4 = new Line2D.Double(40,140,40,275);
            Line2D.Double w5 = new Line2D.Double(40,140,130,140);
            Line2D.Double w6 = new Line2D.Double(100,220,130,220);
            Line2D.Double w7 = new Line2D.Double(330,150,395,150);
            Line2D.Double w8= new Line2D.Double(330,210,370,210);
            Line2D.Double w9= new Line2D.Double(130,270,130,320);
            Line2D.Double w10= new Line2D.Double(40,275,210,275);
            Line2D.Double w11= new Line2D.Double(130,305,210,305);
            Line2D.Double w12= new Line2D.Double(310,290,370,290);
            Line2D.Double w13= new Line2D.Double(370,210,370,290);
            
            //diagram for trigger
            Line2D.Double w14= new Line2D.Double(55,228,65,228);
            Line2D.Double w15= new Line2D.Double(65,228,65,238);
            Line2D.Double w16= new Line2D.Double(65,238,75,238);
            Line2D.Double w17= new Line2D.Double(75,238,75,228);
            Line2D.Double w18= new Line2D.Double(75,228,85,228);
            
            VResistor r1=new VResistor(130,90);
            VResistor r2=new VResistor(130,150);
            VResistor r3=new VResistor(130,210);
            VResistor ra=new VResistor(70,60);
            
            Comparator c1 = new Comparator(130,140);
            Comparator c2 = new Comparator(130,200);
            
            Capacitor c = new Capacitor(70,150);
            
            Ground gr1 = new Ground(130,320);
            Ground gr2 = new Ground(70,175);
            
            Rectangle ff = new Rectangle(250,120,80,120);
            Rectangle outline = new Rectangle(110,90,270,230);
            
            Transistor t = new Transistor(210,275);
            HResistor r = new HResistor(250,290);
            
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
            
            //diagram for trigger
            g2.draw(w14);
            g2.draw(w15);
            g2.draw(w16);
            g2.draw(w17);
            g2.draw(w18);
            
            ra.draw(g2);
            r1.draw(g2);
            r2.draw(g2);
            r3.draw(g2);
            
            r.draw(g2);
            c1.draw(g2);
            c2.draw(g2);
            
            c.draw(g2);
            
            gr1.draw(g2);
            gr2.draw(g2);
            
            g2.draw(ff);
            g2.drawString("R",255,155);
            g2.drawString("S",255,215);
            g2.drawString("Q",310,155);
            g2.drawString("Q",310,215);
            g2.drawString("_",310,200);
            
            t.draw(g2);
            
            //labels
            g2.drawString("Vcc = 5 V",120,19);
            g2.drawString("Output",402,152);
            g2.drawString("Trigger",50,222);
            g2.drawString("R",80,95);
            g2.drawString("C",80,168);
            g2.drawString("5k",140,125);
            g2.drawString("5k",140,185);
            g2.drawString("5k",140,245);
            g2.drawString("100 ohms",260,280);
            
            //joints
            g2.fillRect(69,139,3,3);
            g2.fillRect(129,59,3,3);
            g2.fillRect(99,219,3,3);
            g2.fillRect(129,139,3,3);
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
            loc=pixel*2;
            if(playing) {
                if(trigger && rise){
                    g2.setColor(new Color(255,0,255));
                    ra.draw(g2);
                    c.draw(g2);
                    g2.draw(new Line2D.Double(130,20,130,60));
                    g2.draw(new Line2D.Double(70,60,130,60));
                    g2.draw(new Line2D.Double(70,120,70,150));
                    g2.fillRect(129,59,3,3);
                    g2.fillRect(69,139,3,3);
                    g2.setColor(Color.RED);
                    g2.draw(w7);
                    g2.fillRect(394,149,3,3);
                    g2.drawString("CAPACITOR CHARGING",140,75);
                    /* while(loc>=200){
                        loc-=200;
                    }*/
                    loc+=220;
                    do {
                        if (loc<=40){
                            ckt=new Arrow(130,20+loc,"down");
                        } else if (loc<=100){
                            ckt = new Arrow(130+40-loc,60,"left");
                        } else if (loc<=220){
                            ckt = new Arrow(70,60+loc-100,"down");
                        } else {
                            ckt= new Arrow(0,0,"null");
                        }
                        ckt.draw(g2);
                        loc-=40;
                    }while (loc>=0);
                    if(ypixel2>3 && ypixel2<=36) {
                        g2.setColor(Color.RED);
                        c2.draw(g2);
                        g2.setColor(Color.BLACK);
                    }  
                    if(ypixel2>=67){
                        g2.setColor(Color.RED);
                        c1.draw(g2);
                        g2.setColor(Color.BLACK);
        
                    } 
                    g2.setColor(Color.BLACK);
                }
                else {
                    g2.setColor(new Color(255,0,255));
                    ra.draw(g2);
                    g2.draw(new Line2D.Double(130,20,130,60));
                    g2.draw(new Line2D.Double(70,60,130,60));
                    g2.draw(new Line2D.Double(70,120,70,140));
                    g2.fillRect(129,59,3,3);
                    g2.fillRect(69,139,3,3);
                    g2.draw(w10);
                    g2.draw(w4);
                    g2.draw(w11);
                    g2.draw(new Line2D.Double(40,140,70,140));
                    g2.draw(new Line2D.Double(130,305,130,320));
                    g2.fillRect(129,304,3,3);
                    g2.setColor(Color.RED);
                    g2.draw(w8);
                    g2.draw(w12);
                    g2.draw(w13);
                    r.draw(g2);
                    t.draw(g2);
                    loc+=620;
                    do {
                        if (loc<=40){
                            ckt=new Arrow(130,20+loc,"down");
                        } else if (loc<=100){
                            ckt = new Arrow(130+40-loc,60,"left");
                        } else if (loc<=180){
                            ckt = new Arrow(70,60+loc-100,"down");
                        } else if (loc<=210){
                            ckt = new Arrow(70-loc+180,140,"left");
                        } else if (loc<=345){
                            ckt = new Arrow(40,140+loc-210,"down");
                        } else if (loc<=515){
                            ckt = new Arrow(40+loc-345,275,"right");
                        } else if(loc<=595){
                            ckt = new Arrow(210-loc+515,305,"left");
                        } else if (loc<=620){
                            ckt = new Arrow(130,305+loc-595,"down");
                        } else {
                             ckt= new Arrow(0,0,"null");
                        }
                        ckt.draw(g2);
                        loc-=40;
                    }while (loc>=0);
                
                    
                }
           
                Color fontcolour = new Color(150,150,150);
                g2.setColor(Color.BLUE);
                g2.draw(outline);
            
            }
        }
        private int x,y;
        int loc;
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
        
        private int x,y,lastl;
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
 

}