import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestBoard {

    public static void main(String[] args) {  
        JButton[][] buttons = new JButton[8][8];  

        JFrame frame = new JFrame("Dungeons and Dragons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(); //mainPanel contains the tilesPanel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel tilesPanel = new JPanel();
        tilesPanel.setLayout(new GridLayout(8, 8));
        tilesPanel.setMaximumSize(new Dimension(400, 400));

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(1, 3));
        sidePanel.setMaximumSize(new Dimension(150, 50));
        JButton startBtn = new JButton(); 
        startBtn.setPreferredSize(new Dimension(50, 50));
        startBtn.setText("Start");
        sidePanel.add(startBtn);
        JButton resetBtn = new JButton(); 
        resetBtn.setPreferredSize(new Dimension(50, 50));
        resetBtn.setText("Reset");
        sidePanel.add(resetBtn); 
        JButton nextTurnBtn = new JButton(); 
        nextTurnBtn.setPreferredSize(new Dimension(50, 50));
        nextTurnBtn.setText("Next");
        sidePanel.add(nextTurnBtn);


        for (int row=0; row<8; row++) {
            for(int column = 0; column<8; column++){
                int r = row;
                int c = column;
                buttons[r][c] = new JButton(); 
                buttons[r][c].setPreferredSize(new Dimension(50, 50));
                buttons[r][c].setText(r + " " + c);
                tilesPanel.add(buttons[r][c]);

                //Random walls generation FOR TESTING
                int top = 0;
                int left = 0;
                int bottom = 0;
                int right = 0; 
                int bool[] = {0, 0, 0, 0};
                for(int i = 0; i < 4; i++){
                    if(Math.random() > 0.5) {
                        bool[i] = 1;
                    }
                }
                for(int i = 0; i < 4; i++) {
                    if (i == 0) { //top
                        top = bool[i];
                    }
                    if (i == 1) { //left
                        left = bool[i];
                    }
                    if (i == 2) { //bottom
                        bottom = bool[i];
                    }
                    if (i == 3) { //right
                        right = bool[i];
                    }
                }


                buttons[r][c].setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.black)); //createMatteBorder(int top, int left, int bottom, int right, Color matteColor)
                buttons[r][c].setOpaque(true); //REALLY IMPORTANT FOR BACKGROUND COLOUR TO CHANGE for both actionlistener and mouselistener!
                buttons[r][c].setBackground(Color.white);
                buttons[r][c].addActionListener(e -> buttonPressed(buttons[r][c]));
                buttons[r][c].addMouseListener(new MouseAdapter() 
                {
                   public void mouseEntered(MouseEvent evt) 
                   {
                    buttons[r][c].setBackground(Color.ORANGE); //hover colour: orange
                   }
                   public void mouseExited(MouseEvent evt) 
                   {
                    buttons[r][c].setBackground(Color.white); //back to original
                   }
                });
            }
        }


        
        mainPanel.add(tilesPanel);
        mainPanel.add(sidePanel);
        frame.setContentPane(mainPanel);
        
        frame.setSize(520,600);
        frame.setMinimumSize(new Dimension(520,600));
        frame.setVisible(true);
    }

    static void buttonPressed(JButton btn) {
        Point location = btn.getLocation();
        int Xcoord = location.x;
        int Ycoord = location.y;
        System.out.println(Xcoord + " " + Ycoord);
    }

    static void mouseEntered(JButton btn) {
        btn.setBackground(Color.ORANGE);
    }
}