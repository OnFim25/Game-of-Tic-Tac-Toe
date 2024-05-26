import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Myframe extends JFrame implements ActionListener {
    JPanel panel=new JPanel();
    JButton[] buttons=new JButton[9];
    Random random=new Random();
    boolean player1;

    Myframe(){
        panel.setBounds(0,0,500,500);
        panel.setBackground(Color.GRAY);
        panel.setLayout(new GridLayout(3,3,1,1));

        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            buttons[i].setBackground(Color.lightGray);
            buttons[i].setFont(new Font("MV Boli",Font.PLAIN,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);

        }
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Tick-Tack-Toe");
        this.setSize(500,540);
        this.setLayout(null);
        this.add(panel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1){
                    if(buttons[i].getText().equals("")) { //to make sure X and O will not be changed again
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1 = false;
                        winner();

                    }

                }
                else{
                    if(buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        player1 = true;
                        winner();

                    }
                }
            }
        }
    }

    public  void firstTurn(){
        if(random.nextInt(2)==0){
            player1=true;
            JOptionPane.showMessageDialog(null,"X Plays first","First Turn",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            player1=false;
            JOptionPane.showMessageDialog(null,"O Plays first","First Turn",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void winner(){ // winner is selected by checking all possible arrangements//
        Xwins(0,1,2);
        Xwins(3,4,5);
        Xwins(6,7,8);
        Xwins(0,3,6);
        Xwins(1,4,7);
        Xwins(2,5,8);
        Xwins(0,4,8);
        Xwins(2,4,6);

        Owins(0,1,2);
        Owins(3,4,5);
        Owins(6,7,8);
        Owins(0,3,6);
        Owins(1,4,7);
        Owins(2,5,8);
        Owins(0,4,8);
        Owins(2,4,6);
       
    }
    public void Xwins(int a,int b,int c){
        if((buttons[a].getText().equals("X"))&&(buttons[b].getText().equals("X"))&&(buttons[c].getText().equals("X"))){
            buttons[a].setBackground(new Color(153,255,153));
            buttons[b].setBackground(new Color(153,255,153));
            buttons[c].setBackground(new Color(153,255,153));

            JOptionPane.showMessageDialog(null,"X WINS","WINNER!",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void Owins(int a,int b,int c) {
        if ((buttons[a].getText().equals("O")) && (buttons[b].getText().equals("O")) && (buttons[c].getText().equals("O"))) {
            buttons[a].setBackground(new Color(153, 255, 153));
            buttons[b].setBackground(new Color(153, 255, 153));
            buttons[c].setBackground(new Color(153, 255, 153));

            JOptionPane.showMessageDialog(null, "O WINS", "WINNER!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}






