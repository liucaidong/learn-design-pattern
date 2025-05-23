package code.chapter21.singleton1;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        new SingletonWindow();
    }
}

//窗体类
class SingletonWindow{
    public SingletonWindow(){
        JFrame frame = new JFrame("单例模式");
        frame.setSize(1024,768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        frame.add(panel);
        panel.setLayout(null);
        JButton button = new JButton("打开工具箱");
        button.setBounds(10, 10, 120, 25);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame toolkit = new JFrame("工具箱");
                toolkit.setSize(150,300);
                toolkit.setLocation(100,100);
                toolkit.setResizable(false);
                toolkit.setAlwaysOnTop(true); //置顶
                toolkit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                toolkit.setVisible(true);
            }
        });
        panel.add(button);
        frame.setVisible(true);
    }
}



