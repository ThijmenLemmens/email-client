import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements ActionListener {

    private JFrame frame;

    private Button stop = new Button("stop");
    private Button start = new Button("start");

    private JTextField amount = new JFormattedTextField("amount");
    private JTextField email = new JFormattedTextField("Email");
    private JTextField message = new JFormattedTextField("Message");
    private JTextField title = new JFormattedTextField("Title");

    private ImageIcon img = new ImageIcon("C:\\Users\\lemme\\OneDrive\\Afbeeldingen\\jorandecrafter.png");

    private JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

    public Window() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setTitle("Spam Client!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(img.getImage());
        frame.add(panel);
        panel.add(start);
        panel.add(stop);
        stop.addActionListener(this);
        start.addActionListener(this);
        panel.add(email);
        panel.add(amount);
        panel.add(title);
        panel.add(message);
    }

    private void stopProgram() {
        frame.dispose();
    }

    private void sendMail() {
        Mail mail = new Mail();
        mail.setMessage(message.getText());
        mail.setTitle(title.getText());
        for (int i = 0; i < Integer.parseInt(amount.getText()); i++) {
            mail.sendMessage(email.getText());
        }
        System.out.println("Done!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (start.equals(source)) {
            sendMail();
        }
        if (stop.equals(source)) {
            stopProgram();
        }
    }
}
