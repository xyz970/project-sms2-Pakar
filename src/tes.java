
import com.fazecast.jSerialComm.SerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.comm.SerialPortEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
//import jssc.SerialPortList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mhmmdadi21
 */
public class tes {

//    public static void main(String[] args) {
//         SerialPort ports[] = SerialPort.getCommPorts();
//
//        for(SerialPort port: ports){
//            System.out.println(port.getDescriptivePortName());
//        }
//        
//        
//        for (SerialPort port : ports) {
//            System.out.println(port);
//        }
//        
//        Scanner i = new Scanner(System.in);
//        int x = i.nextInt();
//
//        SerialPort port = ports[x-1];
//
//        port.setComPortParameters(9600, 8, 0, 0);
//        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
//        Scanner data = new Scanner(port.getInputStream());
//
////I just had to give it a try or guess..
//        do{
//            System.out.print(data.nextLine());
//        }while(x<99);
//
//    }
    
    private static final int TIME_VISIBLE = 3000;

    public static void main(String[] args) {

        final JFrame frame1 = new JFrame("My App");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(100, 100);
        frame1.setLocation(100, 100);

        JButton button = new JButton("My Button");
        frame1.getContentPane().add(button);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = new JOptionPane("Message", JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = pane.createDialog(null, "Title");
                dialog.setModal(false);
                dialog.setVisible(true);

                new Timer(TIME_VISIBLE, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                }).start();
            }
        });

        frame1.setVisible(true);

    }

}
