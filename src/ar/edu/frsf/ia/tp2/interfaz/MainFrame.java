package ar.edu.frsf.ia.tp2.interfaz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import ar.edu.frsf.ia.tp2.sistemaDeProducciones.Accion;
import ar.edu.frsf.ia.tp2.sistemaDeProducciones.SistemaDeProduccion;

public class MainFrame {
	JFrame frame;
	private SistemaDeProduccion sdp;
	private JTextField field;
	private JTextArea editArea;
	private JButton limpiar;
	
    public MainFrame(SistemaDeProduccion sdp){
    	this.sdp = sdp;
    	frame = buildFrame();
    	setListeners();
    }

	private void setListeners() {
        field.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					procesarEntrada(field.getText());
					field.setText("");
				}
			}
		});
        
        limpiar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				editArea.setText("");
			}
		});
	}

	protected void procesarEntrada(String text) {
		editArea.append("Entrada: "+text+"\n");
		ArrayList<Accion> respuesta = sdp.start(field.getText());
		editArea.append("Acciones: " + respuesta + "\n\n");
		
	}

	private JFrame buildFrame() {
		JFrame frame = new JFrame("Agente de seguridad ciudadana");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container panel = frame.getContentPane();
        JPanel abajo = new JPanel(new FlowLayout());
        
        editArea = new JTextArea();
        editArea.setPreferredSize(new Dimension(800,400));
        editArea.setEditable(false);
        panel.add(editArea, BorderLayout.CENTER);
        
        JLabel label = new JLabel("Entrada");
        abajo.add(label);
        
        field = new JTextField();

        
        field.setPreferredSize(new Dimension(800,30));
        abajo.add(field);
        limpiar = new JButton("Limpiar");
        abajo.add(limpiar);
        panel.add(abajo,BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);
        return frame;
	}

}
