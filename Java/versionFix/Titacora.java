import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Robot;

class Titacora implements ActionListener {
    Timer timer;
    //int count=0;
    JButton startButton;
    JButton stopButton;
    //JLabel countLabel;
    JFrame frame;
    JPanel contentPane;
    Robot r;

    public Titacora() {
        try {
        frame = new JFrame("T1TA");
        r = new Robot();
        frame.setSize(400,400);
        frame.setLocation(400,400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(this);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);

        //countLabel = new JLabel("0");

        contentPane.add(startButton);
        //contentPane.add(countLabel);
        contentPane.add(stopButton);
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*count++;
                countLabel.setText(count+"");*/
                
                        //r.setAutoDelay(500);
                        r.keyPress(KeyEvent.VK_X);
                        //r.keyRelease(KeyEvent.VK_X);
                    }
                };
        timer = new Timer(50,listener);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
            }catch(Exception e){
            }
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton) {
            timer.start();
        }
        if(e.getSource() == stopButton) {
            timer.stop();
        }
    }
    public static void main(String args[]) {
        new Titacora();
    }
}       
