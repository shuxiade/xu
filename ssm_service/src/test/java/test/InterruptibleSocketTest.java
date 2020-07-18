/*
 * package test;
 * 
 * import java.awt.BorderLayout; import java.awt.EventQueue; import
 * java.net.InetSocketAddress; import java.net.ServerSocket; import
 * java.net.Socket; import java.nio.channels.SocketChannel; import
 * java.util.Scanner;
 * 
 * import javax.swing.JButton; import javax.swing.JFrame; import
 * javax.swing.JPanel; import javax.swing.JScrollPane; import
 * javax.swing.JTextArea;
 * 
 * public class InterruptibleSocketTest {
 * 
 * public static void main(String[] args) {
 * 
 * }
 * 
 * class InterruptibleSocketFrame extends JFrame{ private Scanner in; private
 * JButton interruptibleButton; private JButton blockingButton; private JButton
 * cancelButton; private JTextArea messages; private TestServer server; private
 * Thread connectThread;
 * 
 * public InterruptibleSocketFrame() { JPanel northPanel = new JPanel();
 * add(northPanel,BorderLayout.NORTH);
 * 
 * final int TEXT_ROWS = 20; final int TEXT_COLUMNS = 60; messages = new
 * JTextArea(TEXT_ROWS, TEXT_COLUMNS); add(new JScrollPane(messages));
 * 
 * interruptibleButton = new JButton("Interruptible"); blockingButton = new
 * JButton("Blocking");
 * 
 * northPanel.add(interruptibleButton); northPanel.add(blockingButton);
 * 
 * interruptibleButton.addActionListener(event->{
 * interruptibleButton.setEnabled(false); blockingButton.setEnabled(false);
 * cancelButton.setEnabled(true); connectThread = new Thread(()->{
 * 
 * connectInterruptibly();
 * 
 * }); connectThread.start(); });
 * 
 * blockingButton.addActionListener(event->{
 * interruptibleButton.setEnabled(false); blockingButton.setEnabled(false);
 * cancelButton.setEnabled(true); connectThread = new Thread(()->{
 * connectBlocking(); }); connectThread.start(); });
 * 
 * cancelButton = new JButton("Cancel"); cancelButton.setEnabled(false);
 * northPanel.add(cancelButton); cancelButton.addActionListener(even->{
 * 
 * connectThread.interrupt(); cancelButton.setEnabled(false);
 * 
 * }); server = new TestServer(); new Thread(server).start(); pack(); } public
 * void connectInterruptible() { messages.append("Interruptible:\n");
 * try(SocketChannel channel = SocketChannel.open(new
 * InetSocketAddress("localhost",8189))){ in = new Scanner(channel,"UTF-8");
 * while(!Thread.currentThread().isInterrupted()) { messages.append("Reading ");
 * if(in.hasNextLine()) { String line = in.nextLine(); messages.append(line);
 * messages.append("\n"); } } }finally { EventQueue.invokeLater(()->{
 * messages.append("Channel closed \n"); interruptibleButton.setEnabled(true);
 * blockingButton.setEnabled(true); }); } }
 * 
 * public void connectBlocking() { messages.append("Blocking:\n"); try(Socket
 * sock = new Socket("localhost",8189)){ in = new
 * Scanner(sock.getInputStream(),"UTF-8");
 * while(!Thread.currentThread().isInterrupted()){ messages.append("Reading ");
 * if(in.hasNextLine()) { String line = in.nextLine(); messages.append(line);
 * messages.append("\n"); } } }finally { EventQueue.invokeLater(()->{
 * messages.append("Socket closed \n"); interruptibleButton.setEnabled(true);
 * blockingButton.setEnabled(true); }); } }
 * 
 * class TestServer implements Runnable{
 * 
 * public void run() { try(ServerSocket s = new ServerSocket(8189)){ while
 * (true) { Socket incoming = s.accept(); Runnable r = new
 * TestServerHandler(incoming); Thread t = new Thread(r); t.start();
 * 
 * } } } }
 * 
 * } }
 */