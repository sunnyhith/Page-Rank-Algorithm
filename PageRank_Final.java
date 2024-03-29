package pagerank_user;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SunnySony
 */

public class PageRank_Final extends JFrame {

    /**
     * Creates new form Sunny2
     */
    
    double [] pr; //to store the pagerank values of each page. Initial value is 0.15 for each page
    
    public PageRank_Final() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        
        p1 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();
        l2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("GUI"); // NOI18N

        l1.setText("Enter no of pages :");

        tf1.addActionListener(this::tf1ActionPerformed);

        b1.setText("Click Here");
        b1.addActionListener(this::b1ActionPerformed);

        l2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(l1)
                        .addGap(18, 18, 18)
                        .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1)
                    .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setTitle("Page Rank Calculator");
        setLocationRelativeTo(null);
    }

   
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {
                            
        if(tf1.getText().isEmpty())
        {
           l2.setText("Don't leave the textfield blank!"); 
        }
        else
        try{
            Integer.parseInt(tf1.getText());
            ButtonGrid bg1 = new ButtonGrid(Integer.parseInt(tf1.getText()));
        }
        catch(NumberFormatException e){
            l2.setText("      Enter Only Numbers!");
        }
    }

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
        
    final class ButtonGrid extends JFrame implements ActionListener{
        
        
        JFrame frame=new JFrame(); //creates Link Array window
        JPanel p1=new JPanel(); //panel for instructions
        JPanel p2=new JPanel(); //panel for button grid
        JPanel p3=new JPanel(); //panel for display results button
        JButton[][] grid; //names the grid of buttons
        String clickedButton; //to get the name of each button
        JLabel [] resultLabel; //label array used in resultFrame
        JTextField [] resultText; //textfield array used in resultFrame
        int [][] link; //to form the 2-D link array
        int [] outlink; //to find the number of outgoing links from a page
	int src,dest; //local variables for the class
        int length; //local variable for the class, common to all methods
        double d=0.85,term=0; //d is the damping factor
         
        public ButtonGrid(int size){

            int i=0,j=0;
            length=size;
        	
            frame.setTitle("Link Array");
            frame.setSize(new Dimension(700,400));
            frame.setLayout(new BorderLayout()); //set layout
            
            JLabel lab = new JLabel("Click the button to create a link from page 'X' to page 'Y'");
            lab.setFont(new Font("DROID SANS MONO", Font.BOLD, 15) );
            p1.add(lab);
            p1.setBounds(new Rectangle(new Point(0,0),new Dimension(1200,55)));
            p1.setBorder(BorderFactory.createTitledBorder("Note"));
            frame.add(p1, BorderLayout.PAGE_START);
            
            p2.setBounds(new Rectangle(new Point(0,75)));
            p2.setLayout(new GridLayout(size,size,5,5));
            p2.setBorder(BorderFactory.createTitledBorder("Link Grid"));
            frame.add(p2, BorderLayout.CENTER);
            
            p3.setLayout(new FlowLayout());
            p3.setBounds(new Rectangle(new Point(0,555),new Dimension(1200,400)));
            JButton resultButton=new JButton("Display Results");
            resultButton.setPreferredSize(new Dimension(150,30));
            p3.add(resultButton);
            p3.setBorder(BorderFactory.createTitledBorder("Finalize"));
            resultButton.addActionListener(this);
            frame.add(p3, BorderLayout.PAGE_END);
            
            grid=new JButton[size][size]; //allocate the size of grid
            link= new int[size][size] ;
            outlink= new int[size];
            pr=new double[size];
            resultLabel=new JLabel[size];
            resultText=new JTextField[size];
                
            for(i=0; i<size; i++)
                for(j=0; j<size; j++)
                    if(i!=j){                                
                        grid[i][j]=new JButton((char)(i+65)+" -> "+(char)(j+65)); //creates new button     
                        p2.add(grid[i][j]); //adds button to grid
                        grid[i][j].addActionListener(this);
                    }
                            
            initializeValues();
                          
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to close all the windows
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //to close only the Link Array window
            frame.setLocationRelativeTo(null);
            frame.setVisible(true); //makes frame visible
           
        } //end of ButtonGrid(int size)
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            clickedButton = (String) e.getActionCommand();
            
            if("Display Results".equals(clickedButton)){
                result_Frame();
            }            
            
            else{
            //int source=0,destination=0;
            src = (int)clickedButton.charAt(0)-65; //to get the first character from "X -> Y" i.e X
            dest = (int)clickedButton.charAt(5)-65; //to get the last character from "X -> Y" i.e Y
            grid[src][dest].setBackground(Color.CYAN);
            link[src][dest] = 1;
            grid[src][dest].setText("Link  " + clickedButton + "  is created.");
            outlink[src]++;
                        
            }
            
        } //end of actionPerformed
        
        
        public void result_Frame(){
            
            JFrame resultFrame = new JFrame();
            resultFrame.setTitle("Result Window");
            resultFrame.setLayout(new FlowLayout());
            resultFrame.setSize(400,300);
            resultFrame.setVisible(true);
            resultFrame.setLocationRelativeTo(null);
                        
            for(int k=0;k<length;k++){
                for(int i=(k+1)%length ; (i!=k) ; i=(i+1)%length){
                    if((link[i][k]==1) && (outlink[i]!=0))
                    term = term + pr[i]/outlink[i];
                }
                pr[k] = (1-d)+d*(term);
                term=0;
            }
            
            JLabel l1 = new JLabel("------The final Pagerank values are------");
            resultFrame.add(l1);
            for(int i=0;i<length;i++){
                resultLabel[i]= new JLabel("The pagerank value of page - " + (char)(i+65) +" is :");
                resultFrame.add(resultLabel[i]);
                JTextField resultText=new JTextField(null,15);
                resultText.setText(Double.toString(pr[i]));
                resultFrame.add(resultText);
            }
            
        } //end of result_Frame()
        
        
        public void initializeValues(){
            for(int i=0;i<length;i++)
                for(int j=0;j<length;j++){
                    link[i][j]=0;
                    outlink[i]=0;
                    pr[i]=0.15;
                }
        }
        
    } //end of ButtonGrid class
    
    
    /**
     * @param args the command line arguments
     */
    
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
            java.util.logging.Logger.getLogger(PageRank_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageRank_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageRank_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageRank_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PageRank_Final().setVisible(true);
            }
        });
        
    } //end of main()

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JPanel p1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables

}