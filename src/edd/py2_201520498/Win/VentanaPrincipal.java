/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.py2_201520498.Win;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JPanel Panel;
    private JButton btnAbrir, btnAumentar, btnDisminuir, btnImprimir, BotonCerrar;
    private File archivo;
    private CuadroImagen VentanaInterior;
    private JScrollPane scroll;
    private String imagenes[];

    private String path;
    private int numImg;

    public VentanaPrincipal() {
        super("EDD-201520498");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        numImg = 0;
        VentanaInterior = new CuadroImagen();
        scroll = new JScrollPane(VentanaInterior, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(scroll, BorderLayout.CENTER);

        Panel = new JPanel();
        btnAbrir = new JButton("Abrir");
        btnAumentar = new JButton("+");
        btnDisminuir = new JButton("-");
        BotonCerrar = new JButton("Cerrar");
        Panel.add(btnAbrir);
        Panel.add(btnAumentar);
        Panel.add(btnDisminuir);
        Panel.add(BotonCerrar);

        this.add(Panel, BorderLayout.SOUTH);
        //listeners
        btnAbrir.addActionListener(this);
        btnAumentar.addActionListener(this);
        btnDisminuir.addActionListener(this);
        BotonCerrar.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    //metodo de ActionListener
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAbrir) {
            JFileChooser jfc = new JFileChooser();
            int apr = jfc.showOpenDialog(this);
            if (apr == jfc.APPROVE_OPTION) {
                archivo = jfc.getSelectedFile();
                imagenes = archivo.getParentFile().list();

                path = archivo.getParent();
                VentanaInterior.setImagen(archivo.getAbsoluteFile().toString());
            }
        } else if (e.getSource() == btnAumentar) {
            VentanaInterior.aumentar();
        } else if (e.getSource() == btnDisminuir) {
            VentanaInterior.disminuir();
        } else if (e.getSource() == BotonCerrar) {
            this.setVisible(false);

        }
    }//funciones getter y setter

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    //Comprueba que solo cargue las imagenes
    public boolean esImagen(String dirImg) {
        if (dirImg.lastIndexOf(".jpg") > 0 || dirImg.lastIndexOf(".png") > 0 || dirImg.lastIndexOf(".gif") > 0 || dirImg.lastIndexOf(".jpeg") > 0) {
            return true;
        }
        return false;
    }
}
