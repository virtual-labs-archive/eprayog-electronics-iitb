import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class TwoDiodeClipper extends JApplet implements Runnable  {

    Image cktimage;   

    int pixel=0;
    Thread animator;
    
    boolean playing = true;
    boolean stopRequested = false;
    
    void requestStop() {
       stopRequested = true;
    }
        void requestStart() {
       stopRequested = false;
    }


    /* Initializes the applet SlicerClipper */
    public void init() {
        initComponents();

    }
     class paint extends JPanel {
         public void paint(){
            }
           public void draw(Graphics g) {
        diode d1;
        d1 = new diode(150,80,false);
        d1.draw(g);
        diode d2;
        d2 = new diode(220,80,true);
        d2.draw(g);
        battery b1;
        b1 = new battery(135,140,true);
        b1.draw(g);
        battery b2;
        b2 = new battery (205,140,false);
        b2.draw(g);
        Graphics2D g2=(Graphics2D) g;
        HResistor r1;
        r1 = new HResistor(60,40);
        r1.draw(g2);
        Graphics2D g3=(Graphics2D) g;
        Arrowup a1;
        a1 = new Arrowup(60,40);
        a1.draw(g3);
        a1 = new Arrowup(290,40);
        a1.draw(g2);
        Graphics2D g4=(Graphics2D) g;
        Arrowdown a2;
        a2 = new Arrowdown(60,190);
        a2.draw(g4);
        a2 = new Arrowdown(290,190);
        a2.draw(g2);
        g.drawLine(150,40,150,80);
        g.drawLine(150,110,150,140);
        g.drawLine(150,147,150,190);
        g.drawLine(60,190,290,190);
        g.drawLine(150,40,290,40);
        g.drawLine(120,40,150,40);
        g.drawLine(220,40,220,80);
        g.drawLine(220,110,220,140);
        g.drawLine(220,147,220,190);
        g.drawLine(290,40,290,105);
        g.drawLine(290,125,290,190);
         g.drawLine(60,40,60,105);
          g.drawLine(60,125,60,190);
           
            g.drawString("Vi",55,120);
            g.drawString("Vo",285,120);
           g.drawString("R",85,30);
           g.drawString("D1",115,100);
           g.drawString("D2",185,100);
           g.drawString("V1",115,150);
           g.drawString("V2",185,150);
        }
    }
    
        class diode{
        public diode(int a,int b,boolean c){
            x=a;
            y=b;
            up=c;
        }
        public void draw(Graphics g){
            if(up){
                g.drawLine(x,y,x+15,y);
                g.drawLine(x,y,x-15,y);
                g.drawLine(x,y,x+15,y+30);
                g.drawLine(x,y,x-15,y+30);
                g.drawLine(x-15,y+30,x+15,y+30);
            }
            else{
                g.drawLine(x,y,x+15,y);
                g.drawLine(x,y,x-15,y);
                g.drawLine(x+15,y,x,y+30);
                g.drawLine(x-15,y,x,y+30);
                g.drawLine(x+15,y+30,x-15,y+30);
            }
        }
        private int x,y;
        private boolean up;
    }
    class battery{
        public battery(int a, int b,boolean c){
            x=a;
            y=b;
            up=c;
        }
        public void draw(Graphics g){
            if(up){
                g.drawLine(x,y,x+30,y);
                g.drawLine(x+7,y+7,x+23,y+7);
            }
            else{
                g.drawLine(x+7,y,x+23,y);
                g.drawLine(x,y+7,x+30,y+7);
            }    
        }
            private int x,y;
            private boolean up;
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
    class Arrowup {
        public Arrowup(int a, int b)
        {
            x=a;
            y=b;
        }
        
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x-3,y+5);
            Line2D.Double w2= new Line2D.Double(x,y,x+3,y+5);
            
            g2.draw(w1);
            g2.draw(w2);
        }
        
        private int x,y;
    }
    
    class Arrowdown {
        public Arrowdown(int a, int b)
        {
            x=a;
            y=b;
        }
        
        public void draw(Graphics2D g2)
        {
            Line2D.Double w1= new Line2D.Double(x,y,x-3,y-5);
            Line2D.Double w2= new Line2D.Double(x,y,x+3,y-5);
            
            g2.draw(w1);
            g2.draw(w2);
        }
        
        private int x,y;
    }
    
      // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Container mainPanel = getContentPane();
        Circuit = new ImagePanel();
        Graph = new PlotPanel();
        Parametre = new ParamPanel();
        Resistance = new javax.swing.JLabel();
        Vr1 = new javax.swing.JLabel();
        Vr2 = new javax.swing.JLabel();
        InputAmp = new javax.swing.JLabel();
        RScrollBar = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,1000,50,220,10050);
        VB1ScrollBar = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,80,1,61,121);
        VB2ScrollBar = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,80,1,61,121);
        InputAmpScrollBar = new javax.swing.JScrollBar(JScrollBar.HORIZONTAL,50,1,10,100);
        StopPlay = new javax.swing.JButton("STOP");
        Breakpoint1 = new JLabel();
        Breakpoint2 = new JLabel();
        jLabel1 = new javax.swing.JLabel();


        Color backgroundColor = new Color(231,248,255);
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        Circuit.setBackground(backgroundColor);
        Circuit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Circuit.setName("ImagePanel"); // NOI18N
        Circuit.setPreferredSize(new java.awt.Dimension(350, 230));

        javax.swing.GroupLayout CircuitLayout = new javax.swing.GroupLayout(Circuit);
        Circuit.setLayout(CircuitLayout);
        CircuitLayout.setHorizontalGroup(
            CircuitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        CircuitLayout.setVerticalGroup(
            CircuitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        Graph.setBackground(backgroundColor);
        Graph.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Graph.setName("PlotPanel"); // NOI18N
        Graph.setPreferredSize(new java.awt.Dimension(450, 485));

        javax.swing.GroupLayout GraphLayout = new javax.swing.GroupLayout(Graph);
        Graph.setLayout(GraphLayout);
        GraphLayout.setHorizontalGroup(
            GraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        GraphLayout.setVerticalGroup(
            GraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        Parametre.setBackground(backgroundColor);
        Parametre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Parametre.setName("ParamPanel"); // NOI18N
        Parametre.setPreferredSize(new java.awt.Dimension(350, 250));
        
        Resistance.setText("R = 1000 ohms");
        
        Vr1.setText("Vr1 = 2.0 V");
        
        Vr2.setText("Vr2 = 2.0 V");
        
        InputAmp.setText("Amplitude of Vi = 5.0 V");

        Breakpoint1.setText("Breakpoint 1 P1 = ( 2.7 V, 2.7 V )");
        
        Breakpoint2.setText("Breakpoint 2 P2 = ( -2.7 V, -2.7 V )");


        Resistance.setName("Resistance"); // NOI18N


        Vr1.setName("Vr1"); // NOI18N


        InputAmp.setName("InputAmp"); // NOI18N

        VB1ScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        VB1ScrollBar.setName("VB1ScrollBar"); // NOI18N
        VB1ScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                VB1ScrollBarAdjustmentValueChanged(evt);
            }
        });

        VB2ScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        VB2ScrollBar.setName("VB2ScrollBar"); // NOI18N
        VB2ScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                VB2ScrollBarAdjustmentValueChanged(evt);
            }
        });

        InputAmpScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        InputAmpScrollBar.setName("InputAmpScrollBar"); // NOI18N
        InputAmpScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                InputAmpScrollBarAdjustmentValueChanged(evt);
            }
        });


        StopPlay.setName("StopPlay"); // NOI18N
        StopPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopPlayActionPerformed(evt);
            }
        });


        Breakpoint1.setName("Breakpoint1"); // NOI18N


        Breakpoint2.setName("Breakpoint2"); // NOI18N

        RScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        RScrollBar.setName("RScrollBar"); // NOI18N
        RScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                RScrollBarAdjustmentValueChanged(evt);
            }
        });


        Vr2.setName("Vr2"); // NOI18N

        javax.swing.GroupLayout ParametreLayout = new javax.swing.GroupLayout(Parametre);
        Parametre.setLayout(ParametreLayout);
        ParametreLayout.setHorizontalGroup(
            ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParametreLayout.createSequentialGroup()
                .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ParametreLayout.createSequentialGroup()
                        .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(InputAmp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Vr2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Resistance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Vr1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputAmpScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VB2ScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VB1ScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ParametreLayout.createSequentialGroup()
                        .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Breakpoint2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Breakpoint1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addComponent(StopPlay)))
                .addGap(193, 193, 193))
        );
        ParametreLayout.setVerticalGroup(
            ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParametreLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Resistance)
                    .addComponent(RScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ParametreLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Vr1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ParametreLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(VB1ScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Vr2)
                    .addComponent(VB2ScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InputAmp)
                    .addComponent(InputAmpScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ParametreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ParametreLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(Breakpoint1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Breakpoint2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ParametreLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(StopPlay)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Circuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parametre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Graph, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(Circuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Parametre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Graph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(182, 182, 182))
        );


        jLabel1.setName("jLabel1"); // NOI18N

        //setComponent(mainPanel);
    }// </editor-fold>
    
    public void start() {
        animator = new Thread(this);
        animator.start();
    }
    
    
    public void run() {
            try {
                while (true) {
                    while(!stopRequested) {
                        Graph.draw(pixel);        
                        Thread.sleep(75);
                        pixel++;
                        if (pixel > Graph.inputaxis_len) {
                            pixel = 0;
                            Graph.resetplot();
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
    

    private void StopPlayActionPerformed(java.awt.event.ActionEvent evt) {
       if (playing) {
            Graph.stopped = true;            
            StopPlay.setText("Play");
            requestStop();
            playing = false;
            Graph.draw(Graph.inputaxis_len);
        }
        else {
            Graph.stopped = false;            
            StopPlay.setText("Stop");
            pixel = 0;
            requestStart();
            playing = true;
        } // TODO add your handling code here:
    }

    private void InputAmpScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
         InputAmp.setText("Amplitude of Vi = " + 1.0*InputAmpScrollBar.getValue()/10 + " V");
         Graph.InputAmp=1.0*InputAmpScrollBar.getValue()/10;
         Graph.repaint();// TODO add your handling code here:
    }

    private void VB2ScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        double V2 = (VB2ScrollBar.getValue() - 60)/10.0;
                Vr2.setText("V2 = " + V2 + " V");
        double breakpoint2 = (Math.round(10*(V2+ Graph.Vy)))/10.0;
        Breakpoint2.setText("Breakpoint 2 P2 = (" + (-1*breakpoint2) + " V ," + (-1*breakpoint2) + " V) ") ;
         Graph.set_breakpoint2(V2);
         Graph.repaint();// TODO add your handling code here:
    }

    private void VB1ScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        double V1 = (VB1ScrollBar.getValue() - 60)/10.0;
                Vr1.setText("V1 = " + V1 + " V");
        double breakpoint1 = (Math.round(10*(V1+ Graph.Vy)))/10.0;
        Breakpoint1.setText("Breakpoint 1 P1 = (" + breakpoint1 + " V ," + breakpoint1 + " V) ") ;
         Graph.set_breakpoint1(V1);
         Graph.repaint();
                // TODO add your handling code here:
    }

    private void RScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        Resistance.setText("R = " + RScrollBar.getValue() + "ohms");
         Graph.set_slope(RScrollBar.getValue());  
        Graph.repaint();
        // TODO add your handling code here:
    }


  

    // Variables declaration - do not modify
   private javax.swing.JLabel Breakpoint1;
    private javax.swing.JLabel Breakpoint2;
    private ImagePanel Circuit;
    private javax.swing.JLabel InputAmp;
    private javax.swing.JScrollBar InputAmpScrollBar;
    private ParamPanel Parametre;
    private PlotPanel Graph;
    private javax.swing.JScrollBar RScrollBar;
    private javax.swing.JLabel Resistance;
    private javax.swing.JButton StopPlay;
    private javax.swing.JScrollBar VB1ScrollBar;
    private javax.swing.JScrollBar VB2ScrollBar;
    private javax.swing.JLabel Vr1;
    private javax.swing.JLabel Vr2;
    private javax.swing.JLabel jLabel1;
    //private javax.swing.JPanel mainPanel;
    // End of variables declaration
    public class ParamPanel extends JPanel{
        
        @Override public void paintComponent(Graphics g){
            super.paintComponent(g);
            Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,getWidth(),getHeight());
        }
    }
    
     public class ImagePanel extends JPanel{
        @Override public void paintComponent(Graphics g){
            super.paintComponent(g);
            paint c = new paint();
            g.setColor(Color.BLACK);
            
            c.draw(g);
            g.drawImage(cktimage,0,0,getWidth(),getHeight(),this);
        }
    }
    public class PlotPanel extends JPanel{
        int R=1000;
        double V1=2;
        double V2=2;
        double Vy=0.7;
        int Rf=10;
        double InputAmp=5;
        int MAXInputAmp=10;
        
        double scaleX = 10.0;
        double scaleY = 10.0;
        
        int originx = 160;
        int originy = 160;
        
        int Xaxislenp = 125;
        int Xaxislenn = 125;
        int Yaxislenp = 125;
        int Yaxislenn = 125;
        

        
        int gap = 20;
        
        int inputaxis_originx = originx;
        int inputaxis_originy = originy+Yaxislenn+gap;
        int inputaxis_len = 100;
    
        int outputaxis_originx = originx+Xaxislenp+gap;
        int outputaxis_originy = originy;
        int outputaxis_len = 100;
    
        double slope = 1.0*Rf/(Rf+R);
    
        int pixel=0;
        boolean reset = false;
        
        void set_breakpoint1(double V10) {
            V1 = V10;
             double breakpoint1 = (Math.round(10*(V1+ Graph.Vy)))/10.0;
            breakpoint1 = (int)(scaleX*(V1+Vy)); //in pixels
        }
        
        void set_breakpoint2(double V20) {
            V2 = V20;
            double breakpoint2 = (Math.round(10*(V2+ Graph.Vy)))/10.0;
            breakpoint2 = (int)(scaleX*(V2+Vy)); //in pixels
        }
    
    
        void set_slope(int Rdash) {
            R = Rdash;
            slope = 1.0*Rf/(R+Rf);        
        }        
        
        public void draw (int p) {
            pixel = p;
            reset = false;
            repaint();
        }
        
        public void resetplot () {
        }
        
        boolean stopped = false;
           @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);
             Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,getWidth(),getHeight());
            
             g.setColor(Color.GRAY.brighter());
            
            //plot grid
            for(int x = originx - Xaxislenn; x <= originx + Xaxislenp; x+=25) {
                g.drawLine(x,originy-Yaxislenp,x,originy+Yaxislenn);
            }
            for (int y = originy - Yaxislenn; y <= originy + Yaxislenp; y+=25) {
                g.drawLine(originx-Xaxislenp,y,originx+Xaxislenn,y);
            }            
            //number grid
            g.setColor(Color.BLACK);            
            
            Font prevFont = g.getFont();
            Font font = new Font(prevFont.getName(), prevFont.getStyle(), 8);
            g.setFont(font);
    
            for (int x = originx - Xaxislenn; x <= originx + Xaxislenp; x+=25) {
                g.drawString(Float.toString((float)(x-originx)/10),x-2,originy+10);
            }
            for (int y = originy - Yaxislenn; y <= originy + Yaxislenp; y+=25) {
                g.drawString(Float.toString((float)(originy-y)/10),originx-15,y-1);
            }            
            g.setFont(prevFont);
            
            //draw the arrow & "breakpoint"
            g.setColor(Color.BLACK);
             double breakpoint1 = (Math.round(scaleX*(10*(V1+ Graph.Vy))))/10.0;
             double breakpoint2 = (Math.round(scaleX*(10*(V2+ Graph.Vy))))/10.0;
            g.fillRect((int)(originx+breakpoint1-1),(int)(originy-breakpoint1-1),3,3);
            //g.drawLine(originx+breakpoint,originy-(int)(scaleY*Vr),originx+breakpoint-5,originy-(int)(scaleY*Vr)+5);
            //g.drawLine(originx+breakpoint,originy-(int)(scaleY*Vr),originx+breakpoint+5,originy-(int)(scaleY*Vr)+5);
            g.drawString("P1",(int)(originx+breakpoint1-3),(int)(originy-breakpoint1-5));
            
            g.fillRect((int)(originx-breakpoint2-1),(int)(originy+breakpoint2-1),3,3);
            //g.drawLine(originx+breakpoint,originy-(int)(scaleY*Vr),originx+breakpoint-5,originy-(int)(scaleY*Vr)+5);
            //g.drawLine(originx+breakpoint,originy-(int)(scaleY*Vr),originx+breakpoint+5,originy-(int)(scaleY*Vr)+5);
            g.drawString("P2",(int)(originx-breakpoint2+3),(int)(originy+breakpoint2+5));
                        
            g.setColor(Color.RED);
            g.drawLine((int)(originx-breakpoint2),(int)(originy+breakpoint2),originx+(int)(breakpoint1),originy-(int)breakpoint1);
            g.drawLine(originx+(int)(breakpoint1),originy-(int)(breakpoint1),originx+(int)(scaleX*MAXInputAmp),(int)(originy-slope*(scaleY*MAXInputAmp-breakpoint1)-breakpoint1));
            g.drawLine(originx-(int)(scaleX*MAXInputAmp),(int)(originy+slope*(scaleY*MAXInputAmp-breakpoint2)+breakpoint2),(int)(originx-breakpoint2),(int)(originy+breakpoint2));
            
            g.setColor(Color.BLUE.darker());            
            
            
            //plot input axis
            g.setFont(prevFont);
            
            g.drawLine(inputaxis_originx,inputaxis_originy,inputaxis_originx,inputaxis_originy+inputaxis_len);
            g.drawLine(inputaxis_originx,inputaxis_originy+inputaxis_len,inputaxis_originx,inputaxis_originy+inputaxis_len+25);
            g.drawLine(inputaxis_originx-5,inputaxis_originy+inputaxis_len+20,inputaxis_originx,inputaxis_originy+inputaxis_len+25);
            g.drawLine(inputaxis_originx+5,inputaxis_originy+inputaxis_len+20,inputaxis_originx,inputaxis_originy+inputaxis_len+25);
                            
            //plot input wave                
            int prevx = inputaxis_originx;
            int prevy = inputaxis_originy;

            for (int i = inputaxis_originy; i <= inputaxis_originy + pixel; i++ ) {
                int j = i - inputaxis_originy;
                double y = j*(2*Math.PI)/inputaxis_len ;
                double x = scaleX*InputAmp*Math.sin(y) ;
                g.drawLine(prevx,prevy,(int)(inputaxis_originx + x),i);
                prevx = (int)(inputaxis_originx + x);
                prevy = i;
            }
            g.drawString("Input v/s Time",inputaxis_originx+10,inputaxis_originy+inputaxis_len);
            
            int animated_line_point_y = prevy-pixel-gap-Yaxislenn+(inputaxis_originx-prevx);
            
            int backupX = originx, backupY = originy;
            
            g.setColor(Color.GRAY);
            if (!stopped) {

                
                if (animated_line_point_y >= originy - breakpoint1 && animated_line_point_y <= originy + breakpoint2) {
                    g.drawLine(prevx,prevy,prevx,animated_line_point_y);
                    backupX = prevx; backupY = animated_line_point_y;
                }

                
                else if(animated_line_point_y >= originy + breakpoint2) {
                    g.drawLine(prevx,prevy,prevx,(int)(prevy-pixel-gap-Yaxislenn+breakpoint2+(int)(slope*1.0*(prevx-breakpoint2-originx))));
                    backupX = prevx; backupY = (int)(prevy-pixel-gap-Yaxislenn+breakpoint2-(int)(slope*1.0*(prevx-breakpoint2-originx)));                    
                }
                
                else{
                    g.drawLine(prevx,prevy,prevx,(int)(prevy-pixel-gap-Yaxislenn-breakpoint1-(int)(slope*1.0*(prevx-breakpoint1-originx))));
                    backupX = prevx; backupY = (int)(prevy-pixel-gap-Yaxislenn-breakpoint1-(int)(slope*1.0*(prevx-breakpoint1-originx)));                    
                }
            }
            g.setColor(Color.RED.darker());
            g.fillRect(prevx-2,prevy-2,4,4); 
            
            g.setColor(Color.GREEN.darker().darker());
            
             //draw output axis
            
        g.drawLine(outputaxis_originx,outputaxis_originy,outputaxis_originx+outputaxis_len,outputaxis_originy);
            g.drawLine(outputaxis_originx+outputaxis_len,outputaxis_originy,outputaxis_originx+outputaxis_len+25,outputaxis_originy);
            g.drawLine(outputaxis_originx+outputaxis_len+25,outputaxis_originy,outputaxis_originx+outputaxis_len+20,outputaxis_originy-5);
            g.drawLine(outputaxis_originx+outputaxis_len+25,outputaxis_originy,outputaxis_originx+outputaxis_len+20,outputaxis_originy+5);
          
            //plot output wave  
             prevx = outputaxis_originx;
             prevy = outputaxis_originy;
             
            for (int i = outputaxis_originx; i <= outputaxis_originx + pixel; i++ ) {
                int j = i - outputaxis_originx;
                double x = j*(2*Math.PI)/outputaxis_len ;
                double y = scaleY*InputAmp*Math.sin(x) ;
                if(y >= 0 && y > breakpoint1){
                    g.drawLine(prevx,prevy,i,(int)(outputaxis_originy - slope*(Math.abs(y)-breakpoint1) - breakpoint1));
                    prevy = (int)(outputaxis_originy - slope*(Math.abs(y)-breakpoint1) - breakpoint1);
                    //g.setColor(Color.RED.darker());
                    //g.fillRect(backupX-2,backupY-2,4,4); 
                }
                
                else if (y < 0 && Math.abs(y) >= breakpoint2) {
                    g.drawLine(prevx,prevy,i,(int)(outputaxis_originy + slope*(breakpoint2-Math.abs(y)) + breakpoint2));
                    prevy = (int)(outputaxis_originy + slope*(breakpoint2-Math.abs(y)) + breakpoint2);
                    //g.setColor(Color.RED.darker());
                    //g.fillRect(backupX-2,backupY-2,4,4); 
                }
                else //if(y < breakpoint1 && y > (-breakpoint2)) 
                {
                    g.drawLine(prevx,prevy,i,(int)(outputaxis_originy - y));
                    prevy = (int)(outputaxis_originy - y);
                }
                prevx = i;
            }
             g.drawString("Output v/s Time",outputaxis_originx+(int)(0.4*outputaxis_len),outputaxis_originy-(int)(scaleY*MAXInputAmp));

            g.setColor(Color.RED.darker());
            g.fillRect(prevx-2,prevy-2,4,4);
            
            g.setColor(Color.GRAY);
            if (!stopped) g.drawLine(prevx,prevy,backupX,prevy);

            g.setColor(Color.RED.darker());
            g.fillRect(backupX-2,backupY-2,4,4);        
             g.setColor(Color.BLACK);
             

             g.drawLine(originx-Xaxislenn,originy,originx+Xaxislenp,originy);
            g.drawString("Vin",originx-Xaxislenn-20,originy+5);
            g.drawLine(originx,originy-Yaxislenp,originx,originy+Yaxislenn);
            g.drawString("Vout",originx-13,originy-Yaxislenp-15); 
                
        
        }
    }
    
    

}