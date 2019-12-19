import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Robot;

@SuppressWarnings("serial")
public class TiTa extends JPanel {
    private static final int TIMER_DELAY = 300;
    private StartAction startAction = new StartAction();
    private StopAction stopAction = new StopAction();
    private JButton button = new JButton(startAction);
    private DefaultListModel<Integer> model = new DefaultListModel<>();
    private JList<Integer> jList = new JList<>(model);
    private Timer timer = new Timer(TIMER_DELAY, new TimerListener());
    private Robot r;

    public TiTa() {
        JPanel btnPanel = new JPanel();
        btnPanel.add(button);

        jList.setFocusable(false);
        jList.setVisibleRowCount(10);
        jList.setPrototypeCellValue(100000);
        JScrollPane scrollPane = new JScrollPane(jList);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int num = 1 + (int) (Math.random() * 100);
            //r.keyPress(KeyEvent.VK_X);
            //r.keyRelease(KeyEvent.VK_X);
            model.addElement(num);
        }
    }

    private class StartAction extends AbstractAction {
        public StartAction() {
            super("Start");
            putValue(MNEMONIC_KEY, KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
            button.setAction(stopAction);
        }
    }

    private class StopAction extends AbstractAction {
        public StopAction() {
            super("Stop");
            putValue(MNEMONIC_KEY, KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            button.setAction(startAction);
        }
    }


    private static void createAndShowGui() {
        JFrame frame = new JFrame("Start Stop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TiTa());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
