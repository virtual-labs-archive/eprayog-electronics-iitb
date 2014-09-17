import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class DTSConvolution extends JApplet {

    /** Initializes the applet DTS */
    public void init() {
        initComponents();
        inputPanel.repaint();
        impulseResponsePanel.repaint();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        Container container = getContentPane();
        inputPanel = new Input_JPanel();
        jLabel1 = new javax.swing.JLabel("Input Signal x(t)");
        resetX = new javax.swing.JButton("Reset x(t)");
        impulseResponsePanel = new Input_JPanel();
        jLabel2 = new javax.swing.JLabel("Impulse Response h(t)");
        resetH = new javax.swing.JButton("Reset h(t)");
        outputPanel = new Output_JPanel();
        jLabel3 = new javax.swing.JLabel("Output Signal y(t)");
        SelectPanel = new Output_JPanel();
        kValue = new javax.swing.JComboBox();

        container.setName("container"); // NOI18N
        container.setPreferredSize(new java.awt.Dimension(700, 500));
        inputPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        Color backgroundColor = new Color(231,248,255);
        inputPanel.setBackground(backgroundColor);
        inputPanel.setName("inputPanel"); // NOI18N
        inputPanel.setPreferredSize(new java.awt.Dimension(330, 150));
        inputPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inputPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inputPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                inputPanelMouseReleased(evt);
            }
        });
        inputPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                inputPanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                inputPanelMouseMoved(evt);
            }
        });
        jLabel1.setName("jLabel1"); // NOI18N
        resetX.setName("resetX"); // NOI18N
        resetX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetXActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(resetX))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(resetX))
        );
        impulseResponsePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        impulseResponsePanel.setBackground(backgroundColor);
        impulseResponsePanel.setName("impulseResponsePanel"); // NOI18N
        impulseResponsePanel.setPreferredSize(new java.awt.Dimension(330, 150));
        impulseResponsePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                impulseResponsePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                impulseResponsePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                impulseResponsePanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                impulseResponsePanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                impulseResponsePanelMouseReleased(evt);
            }
        });
        impulseResponsePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                impulseResponsePanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                impulseResponsePanelMouseMoved(evt);
            }
        });
        jLabel2.setName("jLabel2"); // NOI18N
        resetH.setName("resetH"); // NOI18N
        resetH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout impulseResponsePanelLayout = new javax.swing.GroupLayout(impulseResponsePanel);
        impulseResponsePanel.setLayout(impulseResponsePanelLayout);
        impulseResponsePanelLayout.setHorizontalGroup(
            impulseResponsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(impulseResponsePanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, impulseResponsePanelLayout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(resetH))
        );
        impulseResponsePanelLayout.setVerticalGroup(
            impulseResponsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(impulseResponsePanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(resetH))
        );
        outputPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        outputPanel.setName("outputPanel"); // NOI18N
        outputPanel.setPreferredSize(new java.awt.Dimension(670, 160));
        jLabel3.setName("jLabel3"); // NOI18N
        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addContainerGap(600, Short.MAX_VALUE))
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputPanelLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        SelectPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        SelectPanel.setName("SelectPanel"); // NOI18N
        SelectPanel.setPreferredSize(new java.awt.Dimension(670, 160));
        SelectPanel.setRequestFocusEnabled(false);
        SelectPanel.setVerifyInputWhenFocusTarget(false);
        kValue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "x(-5)h(t+5)", "x(-4)h(t+4)", "x(-3)h(t+3)", "x(-2)h(t+2)", "x(-1)h(t+1)", "x(0)h(t)", "x(1)h(t-1)", "x(2)h(t-2)", "x(3)h(t-3)", "x(4)h(t-4)", "x(5)h(t-5)" }));
        kValue.setName("kValue"); // NOI18N
        kValue.setSelectedIndex(5);
        kValue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kValueItemStateChanged(evt);
            }
        });
        javax.swing.GroupLayout SelectPanelLayout = new javax.swing.GroupLayout(SelectPanel);
        SelectPanel.setLayout(SelectPanelLayout);
        SelectPanelLayout.setHorizontalGroup(
            SelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectPanelLayout.createSequentialGroup()
                .addComponent(kValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(600, Short.MAX_VALUE))
        );
        SelectPanelLayout.setVerticalGroup(
            SelectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectPanelLayout.createSequentialGroup()
                .addComponent(kValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                 .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(impulseResponsePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SelectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(impulseResponsePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>

    private void inputPanelMouseClicked(java.awt.event.MouseEvent evt) {                                        
        inputPanel.change(evt);
    }                                       
    private void inputPanelMouseDragged(java.awt.event.MouseEvent evt) {                                        
        inputPanelMouseClicked(evt);  
    }                                       
    private void inputPanelMouseEntered(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
    }                                       
    private void inputPanelMouseExited(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      
    private void inputPanelMouseMoved(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    }                                     
    private void inputPanelMousePressed(java.awt.event.MouseEvent evt) {                                        
        inputPanelMouseClicked(evt);
    }                                       
    private void inputPanelMouseReleased(java.awt.event.MouseEvent evt) {                                         
        inputPanelMouseClicked(evt);
    }                                        
    private void impulseResponsePanelMouseClicked(java.awt.event.MouseEvent evt) {                                                  
        impulseResponsePanel.change(evt);
    }                                                 
    private void impulseResponsePanelMouseDragged(java.awt.event.MouseEvent evt) {                                                  
        impulseResponsePanelMouseClicked(evt);
    }                                                 
    private void impulseResponsePanelMouseEntered(java.awt.event.MouseEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 
    private void impulseResponsePanelMouseExited(java.awt.event.MouseEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                
    private void impulseResponsePanelMouseMoved(java.awt.event.MouseEvent evt) {                                                
        // TODO add your handling code here:
    }                                               
    private void impulseResponsePanelMousePressed(java.awt.event.MouseEvent evt) {                                                  
        impulseResponsePanelMouseClicked(evt);
    }                                                 
    private void impulseResponsePanelMouseReleased(java.awt.event.MouseEvent evt) {                                                   
        impulseResponsePanelMouseClicked(evt);
    }                                                  
    private void resetXActionPerformed(java.awt.event.ActionEvent evt) {                                       
        inputPanel.reset();
    }                                      
    private void resetHActionPerformed(java.awt.event.ActionEvent evt) {                                       
        impulseResponsePanel.reset();
    }                                      
    private void kValueItemStateChanged(java.awt.event.ItemEvent evt) {
       Convolution();
    }

    // Variables declaration - do not modify
    private Output_JPanel SelectPanel;
    private Input_JPanel impulseResponsePanel;
    private Input_JPanel inputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox kValue;
    private Output_JPanel outputPanel;
    private javax.swing.JButton resetH;
    private javax.swing.JButton resetX;
    // End of variables declaration

    //Logic of Convolution
    public void Convolution() {
        int numPoints=11;
        int k = kValue.getSelectedIndex();
        int i, j, outmax=0; 
        //main logic of convolution
        for(i=0;i<2*numPoints-1;i++){
            SelectPanel.output[i]=0;
            outputPanel.output[i]=0;
        }
        for (i=0;i<2*numPoints-1;i++){
             for(j=0;j<=i;j++){
                outputPanel.output[i]+=(inputPanel.inputx[j]*impulseResponsePanel.inputx[i-j]);
                if (k==j){
                    SelectPanel.output[i]=inputPanel.inputx[j]*impulseResponsePanel.inputx[i-j];
                }
            }
            if (Math.abs(outputPanel.output[i])>outmax){
                outmax=Math.abs(outputPanel.output[i]);
            }
        }
        outputPanel.scaleY=(((int)(outmax/10)+1)*10)/5;
        outputPanel.repaint();
        SelectPanel.repaint();
    }
    
    class Input_JPanel extends JPanel {
        int numPoints = 11;
        public int[] inputx = new int[2 * numPoints - 1];
        public int[] inputX = new int[2 * numPoints - 1];
    
        //---- IDEAL values ---- will change once the applet paints once! ----
        int width=330;
        int height=150;
    
        double scaleX = 30;
        double scaleY = 15;
    
        int intervalx=width/numPoints;     
        int intervaly=(height)/(numPoints-1);
        
        int centerline=width/2;
        int zeroline=height/2;
        //-------------------------
        
        //String title;
        int originx =width/2;
        int originy =height/2;  
        int Xaxislenp = (width)/2;
        int Xaxislenn = (width)/2;
        int Yaxislenp = (height)/2;
        int Yaxislenn = (height)/2;  
          
        Input_JPanel() {
            for (int j=0; j<numPoints; j++)    {
                inputx[j] = 0;
                inputX[j] = intervalx*(j+1)-15;
            }
        }
        
        public void change(MouseEvent evt) {
            int x = evt.getX();
            int y = evt.getY();
            int newx=0;
            newx = x/intervalx;
            if (newx<numPoints && y>=0 && y<=150){
                inputx[newx] =(int)Math.round((zeroline-y)/scaleY);
            }
            repaint();
            Convolution();
        }

        public void reset() {
            for (int j=0; j<2*numPoints-1; j++)    {
                inputx[j] = 0;
            }        
            repaint();
            Convolution();
        }
                
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g) ;
            
            g.setColor(Color.BLACK);
            g.drawLine(0,zeroline,width,zeroline);
            g.drawLine(centerline,0,centerline,height);
            g.setColor(Color.BLACK);            
            Font prevFont = g.getFont();
            Font font = new Font(prevFont.getName(), prevFont.getStyle(), 8);
            g.setFont(font);
            for (int x = originx - Xaxislenn; x <= originx + Xaxislenp; x+=intervalx) {
                g.drawString(Integer.toString((int)(((x-originx)/scaleX)+0.5)),x+10,originy+10);
            }
            for (int y = originy - Yaxislenn; y <= originy + Yaxislenp; y+=intervaly) {
               g.drawString(Integer.toString((int)((originy-y)/scaleY)),originx-10,y-1);
            }            
            for (int j = 0; j < numPoints; j++) {
                g.drawLine(inputX[j],zeroline,inputX[j],(int)(zeroline-scaleY*inputx[j]));
                // g.drawString(Integer.toString(inputx[j]),inputX[j],(int)(zeroline-scaleY*inputx[j]));
                g.fillRect(inputX[j]-1,(int)(zeroline-scaleY*inputx[j])-1,3,3);
            }
        }
    }//End of class Input_JPanel

    class Output_JPanel extends JPanel {
        int numPoints = 11;
        int[] input1 = new int[2 * numPoints - 1];
        int[] input2 = new int[2 * numPoints -1];
        int[] inputX = new int[2 * numPoints - 1];
        int[] output = new int[2*numPoints - 1];

        //---- IDEAL values ---- will change once the applet paints once! ----
        int width=660;
        int height=160;
      
        int intervalx=33;
        int intervaly=16;
    
        int centerline=670/2;
        int zeroline=height/2;
        //-------------------------
        
        int max=10;
        double scaleX = 33;
        double scaleY = 2;
        int originx =670/2;
        int originy =height/2;  
        int Xaxislenp = width/2;
        int Xaxislenn = width/2;
        int Yaxislenp = height/2;
        int Yaxislenn = height/2;  
        int x;
        
        Output_JPanel() {
            for (int j=0; j< 2*numPoints-1; j++)    {
                inputX[j] = (int)(intervalx * (j+1) - 28);
                output[j] = 0;
            }
        }
         
        public void reset() {
            for (int j=0; j<numPoints; j++)    {
                output[j] = 0;
            }        
            repaint();
        }
        
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);    
            Color backgroundColor = new Color(231,248,255);
            g.setColor(backgroundColor);
            g.fillRect(0,0,width+10,height);
            g.setColor(Color.BLACK);    
            g.drawLine(0,zeroline,width+10,zeroline);
            g.drawLine(centerline,0,centerline,height);
            g.setColor(Color.BLACK);   
            max=0;
            for (int j = 0; j < 2 * numPoints - 1; j++) {
                if (Math.abs(output[j])>max){
                    max=Math.abs(output[j]);
                }
            }
            scaleY=(((int)(max/10)+1)*10)/5;
            Font prevFont = g.getFont();
            Font font = new Font(prevFont.getName(), prevFont.getStyle(), 8);
            g.setFont(font);
            for (x = originx - 10*intervalx; x < originx + Xaxislenp; x+=intervalx) {
                g.drawString(Integer.toString((int)((x-originx)/scaleX)),x-1,originy+10);
            }
            g.drawString(Integer.toString((int)((x-originx)/scaleX)),x-5,originy+10);
            for (int y = originy - Yaxislenn; y <= originy + Yaxislenp; y+=intervaly) {
                g.drawString(Integer.toString((int)((originy-y)/intervaly*scaleY )),originx-10,y+3);
            }            
            for (int j = 0; j < 2 * numPoints - 1; j++) {
                g.drawLine(inputX[j],zeroline,inputX[j],(int)(zeroline-intervaly*output[j]/scaleY));
                g.fillRect(inputX[j]-1,(int)(zeroline-intervaly*output[j]/scaleY)-1,3,3);
            }
        }
    }//End of class Output_JPanel
}//End of class DTSCon