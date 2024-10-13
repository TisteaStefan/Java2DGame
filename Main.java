package main;
//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
import javax.swing.JFrame;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            JFrame window=new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setTitle("BrrGame");

            GamePanel gamePanel=new GamePanel();
            window.add(gamePanel);
            window.pack();

            window.setLocationRelativeTo(null);
            window.setVisible(true);
            gamePanel.startGameThread();
    }
}