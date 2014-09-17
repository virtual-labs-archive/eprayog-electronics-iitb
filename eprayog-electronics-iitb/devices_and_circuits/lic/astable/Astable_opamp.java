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


public class astable_opamp extends JApplet implements Runnable {

    Thread animator;
    int pixel=0;
    boolean playing = true;
    boolean stopRequested=false;
    boolean rise=true;
    boolean first;
    int ypixel;
    //for the placemnt of the graph
    int originx1 = 30;
    int originy1 = 150;
    int originx2 = 30;
    int originy2 = 350;


    public void init() {
        initComponents();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        Container jPanel1 = getContentPane();
        cktPanel = new Ckt_JPanel();
        paramPanel = new Param_JPanel();
        capValue = new
javax.swing.JScrollBar(JScrollBar.HORIZONTAL,100,0,100,200);
        cap = new javax.swing.JLabel("C = 100 nF");
        res1Value = new
javax.swing.JScrollBar(JScrollBar.HORIZONTAL,500,50,500,850);
        res1 = new javax.swing.JLabel("Ra = 500 ohms");
        res2Value = new
javax.swing.JScrollBar(JScrollBar.HORIZONTAL,500,0,500,700);
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

        javax.swing.GroupLayout cktPanelLayout = new
javax.swing.GroupLayout(cktPanel);
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

        capValue.addAdjustmentListener(new
java.awt.event.AdjustmentListener() {
            public void
adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                capValueAdjustmentValueChanged(evt);
            }
        });

        cap.setName("cap"); // NOI18N

        res1Value.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        res1Value.setName("res1Value"); // NOI18N

        res1Value.addAdjustmentListener(new
java.awt.event.AdjustmentListener() {
            public void
adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                res1ValueAdjustmentValueChanged(evt);
            }
        });


        res1.setName("res1"); // NOI18N

        res2Value.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        res2Value.setName("res2Value"); // NOI18N

        res2Value.addAdjustmentListener(new
java.awt.event.AdjustmentListener() {
            public void
adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
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

        javax.swing.GroupLayout paramPanelLayout = new
javax.swing.GroupLayout(paramPanel);
        paramPanel.setLayout(paramPanelLayout);
        paramPanelLayout.setHorizontalGroup(

paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paramPanelLayout.createSequentialGroup()
                .addContainerGap()

.addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(res2 ,
javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(cap)
                    .addComponent(res1))
                .addGap(70, 70, 70)

.addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
false)
                    .addComponent(res1Value,
javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(res2Value,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE)
                    .addComponent(capValue,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE))

.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60,
Short.MAX_VALUE)
                .addComponent(pause, javax.swing.GroupLayout.DEFAULT_SIZE,
60, Short.MAX_VALUE)
                .addContainerGap())
        );
        paramPanelLayout.setVerticalGroup(

paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
paramPanelLayout.createSequentialGroup()
                .addContainerGap()

.addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cap)
                    .addComponent(capValue,
javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)

.addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(res1)
                    .addComponent(res1Value,
javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE))

.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39,
Short.MAX_VALUE)

.addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pause)

.addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(res2)
                        .addComponent(res2Value,
javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        graphPanel.setBackground(backgroundColor);

graphPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        graphPanel.setName("graphPanel"); // NOI18N
        graphPanel.setPreferredSize(new java.awt.Dimension(300, 500));

        javax.swing.GroupLayout graphPanelLayout = new
javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(

graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(

graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new
javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(

jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()

.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
false)
                    .addComponent(paramPanel,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE)
                    .addComponent(cktPanel,
javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))

.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanel,
javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(

jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cktPanel,
javax.swing.GroupLayout.PREFERRED_SIZE,
javax.swing.GroupLayout.DEFAULT_SIZE,
javax.swing.GroupLayout.PREFERRED_SIZE)

.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramPanel,
javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
Short.MAX_VALUE))
            .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
511, Short.MAX_VALUE)
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
                        Thread.sleep(350);
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
        }
    }

    private void
capValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        cap.setText("C = " + capValue.getValue() + " nF ");
        graphPanel.set_values();
        graphPanel.repaint();
    }

    private void
res1ValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        res1.setText("Ra = " + res1Value.getValue() + " ohms ");
        graphPanel.set_values();
        graphPanel.repaint();
    }

    private void
res2ValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
        res2.setText("Rb = " + res2Value.getValue() + " ohms ");
        graphPanel.set_values();
        graphPanel.repaint();
    }
     private void
res3ValueAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {

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
        int Yaxislen =
125;
;
        int pixel=0;

        //boolean rise= true;
        double cap= 100/Math.pow(10,9);
        double taufall= cap*500;
        double taurise= cap*1000;
        double scaleX=40.0/taurise;
        double ton, toff, t;
        int prevx,prevy,xpixel,xreset,ypixel2;
        double x,y;
        boolean reset = true;
        double
beta=res2Value.getValue()/res1Value.getValue()+res2Value.getValue();
        double beta1=(1+beta)/(1-beta);

        void set_values(){
            cap = capValue.getValue()/Math.pow(10,9);
            taufall = cap*res2Value.getValue();
            taurise = cap*(res1Value.getValue()+res2Value.getValue());

            ton = taurise*Math.log(1-beta*(Vtl/Vth))/(1-beta);
            toff = taufall*Math.log(1-beta*(Vth-Vtl))/1-beta;
            t = ton+toff;
        }

        public void draw (int p) {
            pixel = p;
            reset = false;
            repaint();
        }

        public void resetplot () {
            rise=true;
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
            g.drawLine(originx1,originy1,originx1,originy1-Yaxislen/2);
            g.drawLine(originx1,originy1,originx1,originy1+Yaxislen/2);

            g.drawString("t",originx1+Xaxislen+10,originy1+15);
            g.drawString("v-",originx2-10,originy2-Yaxislen-140);


            //2nd graph
            g.drawLine(originx2,originy2,originx2+Xaxislen+10,originy2);
            g.drawLine(originx2,originy2,originx2,originy2+Yaxislen/2);
            g.drawLine(originx2,originy2,originx2,originy2-Yaxislen/2);
            g.drawString("v+",originx2-10,originy2-Yaxislen+60);
            g.drawString("t",originx2+Xaxislen+10,originy2+15);




            //putting the grey lines
            g.setColor(Color.GRAY.brighter());
            //1st graph


            g.setColor(Color.GREEN.darker().darker());

            g.drawString("Vth",originx1+Xaxislen-260,originy1-5-35);
            g.drawString("Vtl",originx1+Xaxislen-260,originy1-5+45);
            g.drawString("Vth",originx2+Xaxislen-260,originy1-5+175);
            g.drawString("Vtl",originx2+Xaxislen-260,originy1-5+245);

            g.setColor(Color.BLUE.darker().darker());
            g.drawString("CHARGING AND DISCHARGING OF
CAPACITOR",originx1+Xaxislen-250,originy1-5-95);

g.drawString("--------------------------------------------------------------------",originx1+Xaxislen-250,originy1-5-85);
            g.drawString("OUTPUT WAVEFORM OF ASTABLE
MULTIVIBRATOR",originx2+Xaxislen-265,originy1-5+295);

g.drawString("-------------------------------------------------------------------------",originx2+Xaxislen-265,originy1-5+305);

            g.setColor(Color.BLACK);

            //drawing graph
             first=true;
            prevx=originx1;
            prevy=originy1-10;
            for (xpixel=0;xpixel<=pixel;xpixel++){
                if(first){
                   // x=(double)xpixel/scaleX;
                    //y=(Vcc-Vtl)*Math.exp(-x/taurise);
                    //ypixel=(int)(y*108/Vcc);
                    ypixel2=originy2;
                    if(ypixel>=0){
                        ypixel=10;
                        rise=false;
                      xreset=xpixel;
                        first=false;
                        //g.setColor(Color.GRAY.brighter());

//g.drawLine(originx2+xpixel,originy1+10,originx2+xpixel,originy2);
                        g.setColor(Color.RED);

g.drawLine(originx2+xpixel,originy2,originx2+xpixel,originy2);

                    }

                    prevx=originx1+xpixel;
                    prevy=originy1-ypixel-20;
                }
                 else if(rise){
                    x=(double)(xpixel-xreset)/scaleX;
                    y=Vcc-(Vcc-Vtl)*Math.exp(-x/taurise);
                    ypixel=(int)(y*210/Vcc);
                    ypixel2=originy2-36;
                    if(ypixel>=140){
                        ypixel=140;
                        rise=false;
                        xreset=xpixel;
                        g.setColor(Color.GRAY.brighter());

g.drawLine(originx2+xpixel,originy1-35,originx2+xpixel,originy2+30);//for
the third gray line..
                        g.setColor(Color.RED);

g.drawLine(originx2+xpixel,originy2-36,originx2+xpixel,originy2+36);//for
right hand side upper square wave

                    }


                    g.setColor(Color.GREEN.darker());

g.drawLine(prevx,prevy,xpixel+originx1,originy1-ypixel+104);

                    prevx=originx1+xpixel;
                    prevy=originy1-ypixel+104;
                }
                else {
                    x=(double)(xpixel-xreset)/scaleX;
                    y=(double)Vcc*2/3*Math.exp(-x/taufall);
                    ypixel=(int)(y*210/Vcc);
                    ypixel2=originy2;
                    if(ypixel<=70){
                        ypixel=70;

                        rise=true;
                        xreset=xpixel;
                        g.setColor(Color.GRAY.brighter());

g.drawLine(originx2+xpixel,originy1+30,originx2+xpixel,originy2);//for the
second gray line..
                        g.setColor(Color.RED);

g.drawLine(originx2+xpixel,originy2-36,originx2+xpixel,originy2+36);
                    }

                    g.setColor(Color.GREEN.darker());

g.drawLine(prevx,prevy,xpixel+originx1,originy1-ypixel+104);
                    prevx=originx1+xpixel;
                    prevy=originy1-ypixel+104;

                }
                g.setColor(Color.RED);
                if(rise)

g.drawLine(originx2+xpixel,ypixel2,originx2+xpixel+1,ypixel2);
                else

g.drawLine(originx2+xpixel,ypixel2+36,originx2+xpixel+1,ypixel2+36);
            }
            g.setColor(Color.GRAY);

g.drawLine(originx1+xpixel,originy1-ypixel+104,originx2+xpixel,ypixel2);//for
the first gray line
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
            g2.drawString("TIME PERIOD OF THE OUTPUT WAVEFORM =",10,280);
            g2.drawString("2RCln(1+2Rb/Ra)",270,280);
            g2.drawString("EQUATION OF CHARGING OF CAPACITOR =",10,310);
            g2.drawString("Vsat-(Vsat-Vtl)exp(-t/tau)",260,310);
            g2.drawString("EQUATION OF DISCHARGING OF CAPACITOR =",10,340);
            g2.drawString("(-Vsat)-(-Vsat-Vth)exp(-t/tau)",280,340);

            //to draw the resistor
            VResistor r1=new VResistor(250,111);
            VResistor r2=new VResistor(250,150);

            //to draw the comparator

            Comparator c1 = new Comparator(150,100);

            //to draw the capacitor
            Capacitor c = new Capacitor(80,100);
            //to draw the ground
            Ground gr1 = new Ground(30,100);
            Ground gr2 = new Ground(250,210);
            //to draw the horizontal resistor
            HResistor r = new HResistor(165,70);
            c.draw(g2);
            r1.draw(g2);
            r2.draw(g2);
            r.draw(g2);
            c1.draw(g2);
            gr2.draw(g2);
            gr1.draw(g2);
            g2.drawLine(130, 70, 170, 70);
            g2.drawLine(130, 70, 130, 100);
            g2.drawLine(290, 70, 290, 110);
            g2.drawLine(205, 70, 290, 70);
            g2.drawLine(150, 120, 150, 160);
            g2.drawLine(150, 160, 250, 160);
            g2.fillOval(310, 107, 6, 6);
             g2.fillOval(246, 157, 6, 6);
             g2.fillOval(127, 97, 6, 6);

            //labels
            g2.drawString("C",70,90);
            g2.drawString("Ra",256,135);
            g2.drawString("Rb",256,180);
            g2.drawString("R=5k",200,60);


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
            Line2D.Double w6= new Line2D.Double(x+80,y+10,x+160,y+10);

            g2.drawString("+",x+45,y+25);
            g2.drawString("-",x+45,y+7);

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
            Line2D.Double w1= new Line2D.Double(x+10,y-10,x+10,y+10);//for
capacitor's 1st lead
            Line2D.Double w2= new Line2D.Double(x+20,y,x+80,y);//for
capacitors wire right side

            Line2D.Double w3= new Line2D.Double(x-50,y,x+10,y);//for
capacitors left wire
            Line2D.Double w4= new Line2D.Double(x+20,y-10,x+20,y+10);//for
capacitor's 2nd lead

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





}//End of class Astable
